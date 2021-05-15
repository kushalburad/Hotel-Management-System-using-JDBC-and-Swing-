import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
	static int order_count;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		ServerSocket ss=new ServerSocket(6000);
		while(true)
		{
		Socket s;
		s=ss.accept();
		 DataOutputStream dout;
		DataInputStream din;
		Statement stmt = null;
		Connection conn=null;
		room_detail rd;
		String choice;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false","root","root");
			stmt=conn.createStatement();
	}
	catch(Exception e){
	}
		do
			{
				din = new DataInputStream(s.getInputStream());
				choice=din.readUTF();
				System.out.println(choice);
				if(choice.equals("1")) {
				System.out.println("display");
				ResultSet rs=stmt.executeQuery("select * from room_details;");
				while(rs.next()) {
				dout = new DataOutputStream(s.getOutputStream());
				dout.writeBoolean(false);
				rd=new room_detail(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				ObjectOutputStream oout=new ObjectOutputStream(s.getOutputStream());
				oout.writeObject(rd);
				System.out.println("display");
				System.out.println("\t"+rs.getString(1)+ "\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));	
				}

				dout = new DataOutputStream(s.getOutputStream());
				dout.writeBoolean(true);
				}
				
				if(choice.contentEquals("2"))
				{
				String roomno = din.readUTF();
				
				ResultSet rsnew =stmt.executeQuery("select room_details.room_no, room_details.status, room_details.day_cost, room_booking.cust_name, room_booking.cust_contact, room_booking.cust_bill, room_booking.cust_days, room_details.room_type from room_details join room_booking on room_details.room_no=room_booking.room_no where room_details.room_no="+roomno+";");
				rsnew.next();
				OccupantDetails opd = new OccupantDetails(rsnew.getInt(1),rsnew.getString(2),rsnew.getInt(3),rsnew.getString(4),rsnew.getString(5),rsnew.getInt(6),rsnew.getInt(7),rsnew.getString(8));
				ObjectOutputStream oout=new ObjectOutputStream(s.getOutputStream());
				oout.writeObject(opd);
				}
				
				if(choice.contentEquals("4")) {
					try {
						ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
					NewCustomer newcust = (NewCustomer)oin.readObject();
					
					String sql = "update room_booking set cust_name='"+newcust.cust_name+"',cust_contact='"+newcust.cust_contact+"',cust_bill="+newcust.cust_bill+",cust_days="+newcust.cust_days+" where room_no="+newcust.room_no;
					Statement statement = conn.createStatement();
					statement.executeUpdate(sql);
					
					String sql2 = "update room_details set status='booked' where room_no="+newcust.room_no;
					statement.executeUpdate(sql2);
					
						DataOutputStream dot = new DataOutputStream(s.getOutputStream());
						dot.writeBoolean(true);
					}catch(Exception e) {
						DataOutputStream dot = new DataOutputStream(s.getOutputStream());
						dot.writeBoolean(false);
					}
				}
				if(choice.contentEquals("5")) {
					String room_no = din.readUTF();
					String sql3 = "update room_booking set cust_name='"+"none"+"',cust_contact='"+"none"+"',cust_bill="+0+",cust_days="+0+" where room_no="+room_no;
					stmt.executeUpdate(sql3);
					String sql4 = "update room_details set status='available' where room_no="+room_no;
					stmt.executeUpdate(sql4);
				}
				if(choice.contentEquals("6")) {
					ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
					cust_food_order cfo = (cust_food_order)oin.readObject();
					int costFood[] = new int[50];
					int cindex =0;
					int bill=0;
					String food_names="";
					for(int i = 0;i<50;i++) {
						if(cfo.food_items[i]!=null) {
							cfo.food_items[i] = cfo.food_items[i].substring(0, cfo.food_items[i].length() - " : RS.   ".length());
							if(cfo.food_items[i+1]!=null)
							food_names = food_names+cfo.food_items[i]+" - "+cfo.quantity[i]+", ";
							else
							food_names = food_names+cfo.food_items[i]+" - "+cfo.quantity[i];
							ResultSet rs = stmt.executeQuery("select food_cost from food_details where food_name='"+cfo.food_items[i]+"'");
							rs.next();
							costFood[cindex] = rs.getInt(1);
							cindex++;
						}
						else
							break;
					}
					
					ResultSet rs = stmt.executeQuery("select cust_name from room_booking where room_no="+cfo.room_no);
					rs.next();
					String customer = rs.getString(1);
					int i=0;
					while(cindex!=0) {
						bill = bill + (costFood[i]*cfo.quantity[i]);
						cindex--;
						i++;
					}
					cfo.cust_name=customer;
					cfo.bill=bill;
					stmt.executeUpdate("insert into food_order(cust_name,cust_bill) values('"+cfo.cust_name+"',"+bill+")");
					ResultSet rst = stmt.executeQuery("select order_count from food_order where cust_name = '"+cfo.cust_name+"'");
					rst.next();
					int j =0;
					int order_count = rst.getInt(1);
					for(String fname : cfo.food_items) {
						if(cfo.food_items[j] !=null)
						stmt.executeUpdate("insert into food_info(food_name,food_quantity,count) values('"+fname+"',"+cfo.quantity[j]+","+order_count+")");
						j++;
					}
					cfo.food_str = food_names;
					ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
					oout.writeObject(cfo);
				}
				if(choice.contentEquals("7")) {
					try {
					String cust_name=din.readUTF();
					ResultSet rs = stmt.executeQuery("select cust_name,food_name,cust_bill,order_count from food_order where cust_name='"+cust_name+"' order by order_count desc");
					dout = new DataOutputStream(s.getOutputStream());
					if(rs.next()) {
					dout.writeBoolean(true);
					dout.writeUTF("Name : "+rs.getString(1)+"\t Food ordered : "+rs.getString(2)+"\t Bill : "+rs.getInt(3));
					order_count = rs.getInt(4);
					}
					else
					{
						dout.writeBoolean(false);
					}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				if(choice.contentEquals("8")) {
					@SuppressWarnings("unused")
					String cust_name=din.readUTF();
					stmt.executeUpdate("delete from food_order where order_count = "+order_count);
				}
			}while(choice!="3");
	}
	}
}


@SuppressWarnings("serial")
class NewCustomer implements Serializable{
	String cust_name,cust_contact;
	int room_no, cust_days, cust_bill;
	NewCustomer(String cust_name, String cust_contact, int room_no, int cust_days, int cust_bill){
		this.cust_name = cust_name;
		this.cust_contact = cust_contact;
		this.room_no = room_no;
		this.cust_days = cust_days;
		this.cust_bill = cust_bill;
	}
}

@SuppressWarnings("serial")
class OccupantDetails implements Serializable
{
	int room_no,cust_bill,cust_days,cost;
	String cust_name,cust_contact,status, room_type;
	public OccupantDetails(int room_no, String status,int cost,String cust_name,String cust_contact, int cust_bill, int cust_days, String room_type) {
		this.room_no = room_no;
		this.cust_bill = cust_bill;
		this.cust_days = cust_days;
		this.cust_name = cust_name;
		this.cust_contact = cust_contact;
		this.status = status;
		this.cost = cost;
		this.room_type = room_type;
	}
	public OccupantDetails() {
		super();
		this.room_no = 0;
		this.cust_bill = 0;
		this.cust_days = 0;
		this.cust_name = "None";
		this.cust_contact = "None";
		this.status="available";
		this.cost = 0;
		this.room_type="";
	}
}

@SuppressWarnings("serial")
class  room_detail implements Serializable{

	int roomno,cost;
	String status,type;
	room_detail(){
		this.roomno=0;
		this.cost=0;
		this.status=null;
		this.type=null;
	}
	public room_detail(int r,String s,String t,int p ){
		this.roomno=r;
		this.status=s;
		this.cost=p;
		this.type=t;
	}
}

@SuppressWarnings("serial")
class cust_food_order implements Serializable{
	String food_items[] = new String[50];
	int quantity[] = new int[50];
	String cust_name,food_str;
	int bill,room_no;
	cust_food_order() {
		this.bill=0;
	}
	cust_food_order(String []food_items, int []quantity, int room_no) {
		this.food_items = food_items;
		this.quantity = quantity;
		this.room_no = room_no;
	}
	
	cust_food_order(String []food_items, int []quantity, String cust_name, int bill) {
		this.food_items = food_items;
		this.quantity = quantity;
		this.cust_name = cust_name;
		this.bill = bill;
	}
}

/*SQL
CREATE QUERY FOR ROOM DETAILS TABLE
create table room_details(room_no int(10),status varchar(20),day_cost int(10),primary key(room_no)); 
*/
			