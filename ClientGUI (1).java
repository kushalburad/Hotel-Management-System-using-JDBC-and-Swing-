import java.awt.EventQueue;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class ClientGUI implements MouseListener{
	private static JFrame frame;
	static Socket s;
	String choice;
	JPanel panel;
	JLabel first;
	static JCheckBox chckbxCrispy,chckbxPaneerBhurji,chckbxVegManchurian,chckbxChineseBhel,chckbxPaneerMalaiTikka,chckbxPaneerSatay,chckbxMushroomTikka,chckbxCheesePineappleCherry;
	static JTextField lblCustCancelName = new JTextField("");
	JLabel second;
	JLabel third;
	private JLabel FR1;
	private JLabel FR2;
	private JLabel FR3;
	private JLabel FR4;
	private JLabel FR5;
	private JLabel SR1;
	private JLabel SR2;
	private JLabel SR3;
	private JLabel SR4;
	private JLabel SR5;
	private JLabel TR1;
	private JLabel TR2;
	private JLabel TR3;
	private JLabel TR4;
	private JLabel TR5;
	private JLabel FR6;
	private JLabel FR7;
	private JLabel SR6;
	private JLabel SR7;
	private JLabel TR6;
	private JLabel TR7;
	private JButton btnBookARoom;
	private JButton btnOrderFood;
	private static JLabel lblNewLabel;
	private JLabel TITLE;
	private JLabel hands1,hands2;
	private JLabel lblNewLabel_1;
	//private JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	JLabel lblSelectDate;
	JButton btnPickDate; 
	JLabel lblEnterHowMany;
	JLabel lblNameOfCustomer;
	JTextField txtName;
	JLabel lblViewContactDetails;
	JTextField txtContact;
	JButton btnConfirmBooking;
	String roomno="";
	static JPanel foodpanel;
	static JPanel cancelorderpanel;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		s = new Socket("localhost", 6000);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final ClientGUI window = new ClientGUI();
					window.initialize();
					frame.setVisible(true);
					foodpanel.setVisible(false);
					cancelorderpanel.setVisible(false);
					window.btnBookARoom.addActionListener(new ActionListener() {
						 	public void actionPerformed(ActionEvent arg0) {
						 		window.panel.setVisible(true);
						 		window.btnBookARoom.setVisible(false);
						 		window.btnOrderFood.setVisible(false);
						 		window.TITLE.setVisible(false);
						 		window.hands1.setVisible(false);
						 		window.hands2.setVisible(false);
						 		window.lblNewLabel_1.setVisible(false);
								try {
									window.choice="1";
							 		room_detail rd=new room_detail();
									System.out.println("eneterd");
									DataInputStream din;
								 	 DataOutputStream dout= new DataOutputStream(s.getOutputStream());
								 	 dout.writeUTF(window.choice);
									din = new DataInputStream(s.getInputStream());
									boolean exit=din.readBoolean();
									if(exit) {
										JOptionPane.showMessageDialog(null,"XYZ");
									}
									else {
										while(!exit) {							
											ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
											 rd=(room_detail)oin.readObject();
										System.out.print(rd.roomno);
										if(rd.roomno==101) {
											if(rd.status.equals("booked")) {
												window.FR1.setForeground(Color.red);
												Border border11=BorderFactory.createLineBorder(Color.red, 2);
												
												window.FR1.setBorder(border11);
											}
											else {
												window.FR1.setForeground(Color.GREEN);
												Border border1_1=BorderFactory.createLineBorder(Color.GREEN, 2);
												window.FR1.setBorder(border1_1);
											
											}
										}
										 if(rd.roomno==102) {
											if(rd.status.equals("booked")) {
												window.FR2.setForeground(Color.red);
												Border border12=BorderFactory.createLineBorder(Color.red,2);
												window.FR2.setBorder(border12);
											}
											else {
												window.FR2.setForeground(Color.GREEN);
												Border border1_2=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR2.setBorder(border1_2);											
											}
										}
										 if(rd.roomno==103) {
											if(rd.status.equals("booked")) {
												window.FR3.setForeground(Color.red);
												Border border13=BorderFactory.createLineBorder(Color.red,2);
												window.FR3.setBorder(border13);
											}
											else {
												window.FR3.setForeground(Color.GREEN);
												Border border1_3=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR3.setBorder(border1_3);
											}
										}
										 if(rd.roomno==104) {
											if(rd.status.equals("booked")) {
												window.FR4.setForeground(Color.red);
												Border border14=BorderFactory.createLineBorder(Color.red,2);
												window.FR4.setBorder(border14);
											}
											else {
												window.FR4.setForeground(Color.GREEN);
												Border border1_4=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR4.setBorder(border1_4);
											}
										}
										 if(rd.roomno==105) {
											if(rd.status.equals("booked")) {
												window.FR5.setForeground(Color.red);
												Border border15=BorderFactory.createLineBorder(Color.red,2);
												window.FR5.setBorder(border15);
											}
											else {
												window.FR5.setForeground(Color.GREEN);
												Border border1_5=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR5.setBorder(border1_5);
											}
										}
										 if(rd.roomno==106) {
											if(rd.status.equals("booked")) {
												window.FR6.setForeground(Color.red);
												Border border16=BorderFactory.createLineBorder(Color.red,2);
												window.FR6.setBorder(border16);
											}
											else {
												window.FR6.setForeground(Color.GREEN);
												Border border1_6=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR6.setBorder(border1_6);										
											}
										}
										 if(rd.roomno==107) {
											if(rd.status.equals("booked")) {
												window.FR7.setForeground(Color.red);
												Border border17=BorderFactory.createLineBorder(Color.red,2);
												window.FR7.setBorder(border17);											
											}
											else {
												window.FR7.setForeground(Color.GREEN);
												Border border1_7=BorderFactory.createLineBorder(Color.GREEN,2);
												window.FR7.setBorder(border1_7);										
											}
										}
										 if(rd.roomno==201) {
											if(rd.status.equals("booked")) {
												window.SR1.setForeground(Color.red);
												Border border21=BorderFactory.createLineBorder(Color.red,2);
												window.SR1.setBorder(border21);
											
											}
											else {
												window.SR1.setForeground(Color.GREEN);
												Border border2_1=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR1.setBorder(border2_1);
											}
										}
										 if(rd.roomno==202) {
											if(rd.status.equals("booked")) {
												window.SR2.setForeground(Color.red);
												Border border22=BorderFactory.createLineBorder(Color.red,2);
												window.SR2.setBorder(border22);
											}
											else {
												window.SR2.setForeground(Color.GREEN);
												Border border2_2=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR2.setBorder(border2_2);
											}
										}
										 if(rd.roomno==203) {
											if(rd.status.equals("booked")) {
												window.SR3.setForeground(Color.red);
												Border border23=BorderFactory.createLineBorder(Color.red,2);
												window.SR3.setBorder(border23);
											}
											else {
												window.SR3.setForeground(Color.GREEN);
												Border border2_3=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR3.setBorder(border2_3);
											}
										}
										 if(rd.roomno==204) {
											if(rd.status.equals("booked")) {
												window.SR4.setForeground(Color.red);
												Border border24=BorderFactory.createLineBorder(Color.red,2);
												window.SR4.setBorder(border24);
											}
											else {
												window.SR4.setForeground(Color.GREEN);
												Border border2_4=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR4.setBorder(border2_4);
											}
										}
										 if(rd.roomno==205) {
											if(rd.status.equals("booked")) {
												window.SR5.setForeground(Color.red);
												Border border25=BorderFactory.createLineBorder(Color.red,2);
												window.SR5.setBorder(border25);
											}
											else {
												window.SR5.setForeground(Color.GREEN);
												Border border2_5=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR5.setBorder(border2_5);
											}
										}
										 if(rd.roomno==206) {
											if(rd.status.equals("booked")) {
												window.SR6.setForeground(Color.red);
												Border border26=BorderFactory.createLineBorder(Color.red,2);
												window.SR6.setBorder(border26);
											}
											else {
												window.SR6.setForeground(Color.GREEN);
												Border border2_6=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR6.setBorder(border2_6);
											}
										}
										 if(rd.roomno==207) {
											if(rd.status.equals("booked")) {
												window.SR7.setForeground(Color.red);
												Border border27=BorderFactory.createLineBorder(Color.red,2);
												window.SR7.setBorder(border27);
											}
											else {
												window.SR7.setForeground(Color.GREEN);
												Border border2_7=BorderFactory.createLineBorder(Color.GREEN,2);
												window.SR7.setBorder(border2_7);
											}
										}
										 if(rd.roomno==301) {
											if(rd.status.equals("booked")) {
												window.TR1.setForeground(Color.red);
												Border border31=BorderFactory.createLineBorder(Color.red,2);
												window.TR1.setBorder(border31);
											}
											else {
												window.TR1.setForeground(Color.GREEN);
												Border border3_1=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR1.setBorder(border3_1);
											}
										}
										 if(rd.roomno==302) {
											if(rd.status.equals("booked")) {
												window.TR2.setForeground(Color.red);
												Border border32=BorderFactory.createLineBorder(Color.red,2);
												window.TR2.setBorder(border32);
											}
											else {
												window.TR2.setForeground(Color.GREEN);
												Border border3_2=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR2.setBorder(border3_2);
											}
										}
										 if(rd.roomno==303) {
											if(rd.status.equals("booked")) {
												window.TR3.setForeground(Color.red);
												Border border33=BorderFactory.createLineBorder(Color.red,2);
												window.TR3.setBorder(border33);
											}
											else {
												window.TR3.setForeground(Color.GREEN);
												Border border3_3=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR3.setBorder(border3_3);
											}
										}
										 if(rd.roomno==304) {
											if(rd.status.equals("booked")) {
												window.TR4.setForeground(Color.red);
												Border border34=BorderFactory.createLineBorder(Color.red,2);
												window.TR4.setBorder(border34);
											}
											else {
												window.TR4.setForeground(Color.GREEN);
												Border border3_4=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR4.setBorder(border3_4);
											}
										}
										
										 if(rd.roomno==305) {
											if(rd.status.equals("booked")) {
												window.TR5.setForeground(Color.red);
												Border border35=BorderFactory.createLineBorder(Color.red,2);
												window.TR5.setBorder(border35);
											}
											else {
												window.TR5.setForeground(Color.GREEN);
												Border border3_5=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR5.setBorder(border3_5);
											}
										}
										 if(rd.roomno==306) {
											if(rd.status.equals("booked")) {
												window.TR6.setForeground(Color.red);
												Border border36=BorderFactory.createLineBorder(Color.red,2);
												window.TR6.setBorder(border36);
											}
											else {
												window.TR6.setForeground(Color.GREEN);
												Border border3_6=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR6.setBorder(border3_6);
											}
										}
										 if(rd.roomno==307) {
											if(rd.status.equals("booked")) {
												window.TR7.setForeground(Color.red);
												Border border37=BorderFactory.createLineBorder(Color.red,2);
												window.TR7.setBorder(border37);
											}
											else {
												window.TR7.setForeground(Color.GREEN);
												Border border3_7=BorderFactory.createLineBorder(Color.GREEN,2);
												window.TR7.setBorder(border3_7);
											}
										}
										exit=din.readBoolean();
									}
									}	
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
						 	}
						 });
//-----------------------------------------------------------------------Food Ordering---------------------------------------------------------------					
						window.btnOrderFood.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent me) {
								foodpanel.setVisible(true);
								
						 		window.btnBookARoom.setVisible(false);
						 		window.btnOrderFood.setVisible(false);
						 		window.TITLE.setVisible(false);
						 		window.hands1.setVisible(false);
						 		window.hands2.setVisible(false);
						 		window.lblNewLabel_1.setVisible(false);
								
						 		JLabel lblNewLabel_1 = new JLabel("< Menu >");
								lblNewLabel_1.setBackground(new Color(128, 0, 0));
								lblNewLabel_1.setForeground(new Color(218, 165, 32));
								lblNewLabel_1.setFont(new Font("MS PGothic", Font.BOLD, 21));
								lblNewLabel_1.setBounds(194, 11, 117, 28);
								foodpanel.add(lblNewLabel_1);
								
								lblNewLabel = new JLabel("");
								lblNewLabel.setBounds(0, 0, 898, 446);
								frame.getContentPane().add(lblNewLabel);
								ImageIcon icon=(new ImageIcon("C:\\Users\\karan\\Downloads\\images.jpeg"));
								Image img=icon.getImage();
								Image resizedImage=img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),java.awt.Image.SCALE_SMOOTH);
								lblNewLabel.setIcon(new ImageIcon(resizedImage));
								
								chckbxCrispy = new JCheckBox("Veg. Crispy : RS.230");
								chckbxCrispy.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxCrispy.setForeground(new Color(218, 165, 32));
								chckbxCrispy.setBackground(new Color(80, 0, 0));
								chckbxCrispy.setBounds(41, 64, 250, 27);
								foodpanel.add(chckbxCrispy);
								
								chckbxPaneerBhurji = new JCheckBox("Paneer Bhurji : RS.240");
								chckbxPaneerBhurji.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxPaneerBhurji.setForeground(new Color(218, 165, 32));
								chckbxPaneerBhurji.setBackground(new Color(80, 0, 0));
								chckbxPaneerBhurji.setBounds(41, 97, 250, 28);
								foodpanel.add(chckbxPaneerBhurji);
								
								chckbxVegManchurian = new JCheckBox("Veg. Manchurian : RS.190");
								chckbxVegManchurian.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxVegManchurian.setForeground(new Color(218, 165, 32));
								chckbxVegManchurian.setBackground(new Color(80, 0, 0));
								chckbxVegManchurian.setBounds(41, 130, 250, 28);
								foodpanel.add(chckbxVegManchurian);
								
								chckbxChineseBhel = new JCheckBox("Chinese Bhel : RS.130");
								chckbxChineseBhel.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxChineseBhel.setForeground(new Color(218, 165, 32));
								chckbxChineseBhel.setBackground(new Color(80, 0, 0));
								chckbxChineseBhel.setBounds(41, 163, 250, 28);
								foodpanel.add(chckbxChineseBhel);
								
								chckbxPaneerMalaiTikka = new JCheckBox("Paneer Malai Tikka : RS.250");
								chckbxPaneerMalaiTikka.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxPaneerMalaiTikka.setForeground(new Color(218, 165, 32));
								chckbxPaneerMalaiTikka.setBackground(new Color(80, 0, 0));
								chckbxPaneerMalaiTikka.setBounds(288, 64, 250, 28);
								foodpanel.add(chckbxPaneerMalaiTikka);
								
								chckbxPaneerSatay = new JCheckBox("Paneer Satay : RS.250");
								chckbxPaneerSatay.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxPaneerSatay.setForeground(new Color(218, 165, 32));
								chckbxPaneerSatay.setBackground(new Color(80, 0, 0));
								chckbxPaneerSatay.setBounds(288, 97, 250, 28);
								foodpanel.add(chckbxPaneerSatay);
								
								chckbxMushroomTikka = new JCheckBox("Mushroom Tikka : RS.250");
								chckbxMushroomTikka.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxMushroomTikka.setForeground(new Color(218, 165, 32));
								chckbxMushroomTikka.setBackground(new Color(80, 0, 0));
								chckbxMushroomTikka.setBounds(288, 130, 250, 28);
								foodpanel.add(chckbxMushroomTikka);
								
								chckbxCheesePineappleCherry = new JCheckBox("Cheese Pineapple Cherry : RS.160");
								chckbxCheesePineappleCherry.setFont(new Font("Tahoma", Font.PLAIN, 13));
								chckbxCheesePineappleCherry.setForeground(new Color(218, 165, 32));
								chckbxCheesePineappleCherry.setBackground(new Color(80, 0, 0));
								chckbxCheesePineappleCherry.setBounds(288, 163, 250, 28);
								foodpanel.add(chckbxCheesePineappleCherry);
								
								JButton btnOrder = new JButton("Order Food");
								btnOrder.setForeground(new Color(218, 165, 32));
								btnOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
								btnOrder.setBounds(573, 64, 106, 28);
								foodpanel.add(btnOrder);
								
								JButton btnCancelOrder = new JButton("Cancel Order");
								btnCancelOrder.setForeground(new Color(218, 165, 32));
								btnCancelOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
								btnCancelOrder.setBounds(562, 119, 128, 28);
								foodpanel.add(btnCancelOrder);

								btnCancelOrder.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent mm) {
										foodpanel.setVisible(false);
										cancelorderpanel.setVisible(true);
										JLabel lblNewLabel_1 = new JLabel("Enter Customer Name :");
										lblNewLabel_1.setForeground(new Color(218, 165, 32));
										lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
										lblNewLabel_1.setBounds(169, 31, 151, 14);
										cancelorderpanel.add(lblNewLabel_1);
										lblCustCancelName.setOpaque(false);
										lblCustCancelName.setForeground(new Color(218, 165, 32));
										lblCustCancelName.setFont(new Font("Tahoma", Font.PLAIN, 13));
										lblCustCancelName.setBounds(353, 24, 151, 30);
										cancelorderpanel.add(lblCustCancelName);
										
										JLabel foundOrder = new JLabel("");
										foundOrder.setForeground(new Color(218, 165, 32));
										foundOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
										foundOrder.setBounds(46, 111, 640, 25);
										cancelorderpanel.add(foundOrder);
										
										JButton btnSearchOrder = new JButton("Search Latest Order");
										btnSearchOrder.setForeground(new Color(218, 165, 32));
										btnSearchOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
										btnSearchOrder.setBounds(246, 75, 175, 25);
										cancelorderpanel.add(btnSearchOrder);
										btnSearchOrder.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent me) {
												try {
												DataOutputStream dout = new DataOutputStream(s.getOutputStream());
												dout.writeUTF("7");
												dout.writeUTF(lblCustCancelName.getText());
												DataInputStream din = new DataInputStream(s.getInputStream());
												if(din.readBoolean()) {
													String result = din.readUTF();
													result = "<html>"+result.replace("\t", "&emsp;")+"</html>";
													foundOrder.setText(result);
												}
												else
												{
													JOptionPane.showMessageDialog(frame, "No order found for given name !");
													foundOrder.setText("");
												}
												}
												catch(Exception e) {
													
												}
											}
										});
										
										JButton btnDeleteOrder = new JButton("Cancel This Order");
										btnDeleteOrder.setForeground(new Color(218, 165, 32));
										btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
										btnDeleteOrder.setBounds(246, 152, 175, 25);
										cancelorderpanel.add(btnDeleteOrder);
										btnDeleteOrder.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent me) {
											try {
												if(foundOrder.getText().contentEquals("")) {
													JOptionPane.showMessageDialog(frame, "Failed to delete orders !");
												}
												else
												{
											DataOutputStream dout = new DataOutputStream(s.getOutputStream());
											dout.writeUTF("8");
											dout.writeUTF(lblCustCancelName.getText());
											JOptionPane.showMessageDialog(frame, "Deletion Successful !");
											foundOrder.setText("");
											}
											}
											catch(Exception e) {}
											}
										});
									}
								});
								
								btnOrder.addMouseListener(new MouseAdapter() {			
									public void mouseClicked(MouseEvent arg0) {
										String fooditems[] = new String[50];
										int quantity[] = new int[50];
										int cnt=0;
										if(chckbxCrispy.isSelected()) {
											fooditems[cnt] = chckbxCrispy.getText();
											cnt++;
										}
										if(chckbxPaneerBhurji.isSelected()) {
											fooditems[cnt] = chckbxPaneerBhurji.getText();
											cnt++;
										}
										if(chckbxVegManchurian.isSelected()) { 
											fooditems[cnt] = chckbxVegManchurian.getText();
											cnt++;
										}
										if(chckbxChineseBhel.isSelected()) { 
											fooditems[cnt] = chckbxChineseBhel.getText();
											cnt++;
										}
										if(chckbxPaneerMalaiTikka.isSelected()) { 
											fooditems[cnt] = chckbxPaneerMalaiTikka.getText();
											cnt++;
										}
										if(chckbxPaneerSatay.isSelected()) { 
											fooditems[cnt] = chckbxPaneerSatay.getText();
											cnt++;
										}
										if(chckbxMushroomTikka.isSelected()) { 
											fooditems[cnt] = chckbxMushroomTikka.getText();
											cnt++;
										}
										if(chckbxCheesePineappleCherry.isSelected()) { 
											fooditems[cnt] = chckbxCheesePineappleCherry.getText();
											cnt++;
										}
										JFrame qtyFoodFrame = new JFrame();
										qtyFoodFrame.setLocationRelativeTo(frame);
										qtyFoodFrame.setBounds(200, 100, 700, 446);
										qtyFoodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										qtyFoodFrame.getContentPane().setLayout(null);
										qtyFoodFrame.setUndecorated(true);
										
										JPanel qtypanel = new JPanel();
										qtypanel.setBorder(new LineBorder(new Color(218, 165, 32),3));
										qtypanel.setBackground(new Color(80, 0, 0));
										qtypanel.setBounds(0, 0, 700, 446);
										qtyFoodFrame.getContentPane().add(qtypanel);
										qtypanel.setLayout(null);
										
										JLabel item1 = new JLabel("");
										item1.setForeground(new Color(218, 165, 32));
										item1.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item1.setBackground(new Color(80, 0, 0));
										item1.setBounds(36, 60, 250, 27);
										qtypanel.add(item1);
										
										JLabel item2 = new JLabel("");
										item2.setForeground(new Color(218, 165, 32));
										item2.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item2.setBackground(new Color(80, 0, 0));
										item2.setBounds(36, 93, 250, 28);
										qtypanel.add(item2);
										
										JLabel item3 = new JLabel("");
										item3.setForeground(new Color(218, 165, 32));
										item3.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item3.setBackground(new Color(80, 0, 0));
										item3.setBounds(36, 126, 250, 28);
										qtypanel.add(item3);
										
										JLabel item4 = new JLabel("");
										item4.setForeground(new Color(218, 165, 32));
										item4.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item4.setBackground(new Color(80, 0, 0));
										item4.setBounds(36, 159, 250, 28);
										qtypanel.add(item4);
										
										JLabel item5 = new JLabel("");
										item5.setForeground(new Color(218, 165, 32));
										item5.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item5.setBackground(new Color(80, 0, 0));
										item5.setBounds(36, 195, 250, 28);
										qtypanel.add(item5);
										
										JLabel item6 = new JLabel("");
										item6.setForeground(new Color(218, 165, 32));
										item6.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item6.setBackground(new Color(80, 0, 0));
										item6.setBounds(36, 228, 250, 28);
										qtypanel.add(item6);
										
										JLabel item7 = new JLabel("");
										item7.setForeground(new Color(218, 165, 32));
										item7.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item7.setBackground(new Color(80, 0, 0));
										item7.setBounds(36, 261, 250, 28);
										qtypanel.add(item7);
										
										JLabel item8 = new JLabel("");
										item8.setForeground(new Color(218, 165, 32));
										item8.setFont(new Font("Tahoma", Font.PLAIN, 13));
										item8.setBackground(new Color(80, 0, 0));
										item8.setBounds(36, 294, 250, 28);
										qtypanel.add(item8);
										
										JTextField txtitem1 = new JTextField("");
										txtitem1.setForeground(new Color(218, 165, 32));
										txtitem1.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem1.setBackground(new Color(80, 0, 0));
										txtitem1.setBounds(405, 60, 250, 27);
										qtypanel.add(txtitem1);
										
										JTextField txtitem2 = new JTextField("");
										txtitem2.setForeground(new Color(218, 165, 32));
										txtitem2.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem2.setBackground(new Color(80, 0, 0));
										txtitem2.setBounds(405, 93, 250, 28);
										qtypanel.add(txtitem2);
										
										JTextField txtitem3 = new JTextField("");
										txtitem3.setForeground(new Color(218, 165, 32));
										txtitem3.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem3.setBackground(new Color(80, 0, 0));
										txtitem3.setBounds(405, 126, 250, 28);
										qtypanel.add(txtitem3);
										
										JTextField txtitem4 = new JTextField("");
										txtitem4.setForeground(new Color(218, 165, 32));
										txtitem4.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem4.setBackground(new Color(80, 0, 0));
										txtitem4.setBounds(405, 159, 250, 28);
										qtypanel.add(txtitem4);
										
										JTextField txtitem5 = new JTextField("");
										txtitem5.setForeground(new Color(218, 165, 32));
										txtitem5.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem5.setBackground(new Color(80, 0, 0));
										txtitem5.setBounds(405, 195, 250, 28);
										qtypanel.add(txtitem5);
										
										JTextField txtitem6 = new JTextField("");
										txtitem6.setForeground(new Color(218, 165, 32));
										txtitem6.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem6.setBackground(new Color(80, 0, 0));
										txtitem6.setBounds(405, 228, 250, 28);
										qtypanel.add(txtitem6);
										
										JTextField txtitem7 = new JTextField("");
										txtitem7.setForeground(new Color(218, 165, 32));
										txtitem7.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem7.setBackground(new Color(80, 0, 0));
										txtitem7.setBounds(405, 261, 250, 28);
										qtypanel.add(txtitem7);
										
										JTextField txtitem8 = new JTextField("");
										txtitem8.setForeground(new Color(218, 165, 32));
										txtitem8.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtitem8.setBackground(new Color(80, 0, 0));
										txtitem8.setBounds(405, 294, 250, 28);
										qtypanel.add(txtitem8);
										
										JLabel lblFoodItem = new JLabel("Food Item");
										lblFoodItem.setForeground(new Color(218, 165, 32));
										lblFoodItem.setFont(new Font("Tahoma", Font.BOLD, 16));
										lblFoodItem.setBackground(new Color(80, 0, 0));
										lblFoodItem.setBounds(118, 22, 168, 27);
										qtypanel.add(lblFoodItem);
										
										JLabel lblQuantity = new JLabel("Quantity");
										lblQuantity.setForeground(new Color(218, 165, 32));
										lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
										lblQuantity.setBackground(new Color(80, 0, 0));
										lblQuantity.setBounds(487, 22, 168, 27);
										qtypanel.add(lblQuantity);
										
										JLabel lblRoomNumber = new JLabel("Room Number : ");
										lblRoomNumber.setForeground(new Color(218, 165, 32));
										lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
										lblRoomNumber.setBackground(new Color(80, 0, 0));
										lblRoomNumber.setBounds(171, 346, 128, 28);
										qtypanel.add(lblRoomNumber);
										
										JTextField txtRoomNumber = new JTextField("");
										txtRoomNumber.setForeground(new Color(218, 165, 32));
										txtRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
										txtRoomNumber.setBackground(new Color(80, 0, 0));
										txtRoomNumber.setBounds(347, 347, 128, 28);
										qtypanel.add(txtRoomNumber);
										
										JButton btnConfirmOrder = new JButton("Confirm Order");
										btnConfirmOrder.setForeground(new Color(218, 165, 32));
										btnConfirmOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
										btnConfirmOrder.setBounds(237, 397, 150, 27);
										qtypanel.add(btnConfirmOrder);
									
										btnConfirmOrder.addMouseListener(new MouseAdapter() {
										public void mouseClicked(MouseEvent me) {
											qtyFoodFrame.dispose();
											JOptionPane.showMessageDialog(frame, "Order Placed Successfully !");
											try {
												JFrame billFrame = new JFrame();
												billFrame.setBounds(100, 100, 449, 295);
												billFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												billFrame.getContentPane().setLayout(null);
												billFrame.setUndecorated(true);
												
												JPanel billPanel = new JPanel();
												billPanel.setBorder(new LineBorder(new Color(218, 165, 32), 2));
												billPanel.setBackground(new Color(80, 0, 0));
												billPanel.setBounds(0, 0, 449, 295);
												billFrame.getContentPane().add(billPanel);
												billPanel.setLayout(null);
												
												JLabel lblNewLabel_1 = new JLabel("< Bill >");
												lblNewLabel_1.setForeground(new Color(218, 165, 32));
												lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 17));
												lblNewLabel_1.setBounds(185, 27, 78, 29);
												billPanel.add(lblNewLabel_1);
												
												JLabel billCustName = new JLabel("Name of Customer :");
												billCustName.setForeground(new Color(218, 165, 32));
												billCustName.setFont(new Font("Tahoma", Font.PLAIN, 13));
												billCustName.setBounds(51, 92, 123, 14);
												billPanel.add(billCustName);
												
												JLabel billCustNameVal = new JLabel("");
												billCustNameVal.setBackground(new Color(80, 0, 0));
												billCustNameVal.setForeground(new Color(218, 165, 32));
												billCustNameVal.setFont(new Font("Tahoma", Font.PLAIN, 13));
												billCustNameVal.setBounds(185, 93, 164, 14);
												billPanel.add(billCustNameVal);
												
												JLabel billfood = new JLabel ("");
												billfood.setBackground(new Color(80, 0, 0));
												billfood.setForeground(new Color(218, 165, 32));
												billfood.setBounds(185, 127, 185, 81);
												billfood.setOpaque(true);
												
												JLabel lblOrderedFood = new JLabel("Ordered Food :");
												lblOrderedFood.setForeground(new Color(218, 165, 32));
												lblOrderedFood.setFont(new Font("Tahoma", Font.PLAIN, 13));
												lblOrderedFood.setBounds(79, 140, 97, 14);
												billPanel.add(lblOrderedFood);
												
												JLabel lblTotal = new JLabel("Total :");
												lblTotal.setForeground(new Color(218, 165, 32));
												lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
												lblTotal.setBounds(127, 232, 49, 14);
												billPanel.add(lblTotal);

												JLabel billTotal = new JLabel("");
												billTotal.setForeground(new Color(218, 165, 32));
												billTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
												billTotal.setBackground(new Color(80, 0, 0));
												billTotal.setBounds(185, 232, 164, 14);
												billPanel.add(billTotal);
												
												JLabel lblExitBill = new JLabel("X");
												lblExitBill.setForeground(new Color(218, 165, 32));
												lblExitBill.setFont(new Font("Tahoma", Font.BOLD, 18));
												lblExitBill.setBounds(427, 5, 12, 22);
												billPanel.add(lblExitBill);
												lblExitBill.addMouseListener(new MouseAdapter() {
												public void mouseClicked(MouseEvent me) {
													billFrame.dispose();
													qtyFoodFrame.dispose();
												}
												});

												JScrollPane scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
												billFrame.setLocationRelativeTo(frame);
												billFrame.getContentPane().add(scroll);
												billFrame.setVisible(true);
												DataOutputStream dout = new DataOutputStream(s.getOutputStream());
												dout.writeUTF("6");
												int index = 0;
												if(!txtitem1.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem1.getText());
													index++;
												}
												if(!txtitem2.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem2.getText());
													index++;
												}
												if(!txtitem3.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem3.getText());
													index++;
												}
												if(!txtitem4.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem4.getText());
													index++;
												}
												if(!txtitem5.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem5.getText());
													index++;
												}
												if(!txtitem6.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem6.getText());
													index++;
												}
												if(!txtitem7.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem7.getText());
													index++;
												}
												if(!txtitem8.getText().equals("")) {
													quantity[index]= Integer.parseInt(txtitem8.getText());
													index++;
												}

												cust_food_order cfo = new cust_food_order(fooditems,quantity,Integer.parseInt(txtRoomNumber.getText()));
												ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
												out.writeObject(cfo);
												try {
												ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
													cust_food_order cfoin = (cust_food_order)oin.readObject();
													billCustNameVal.setText(cfoin.cust_name);
													String temp="<html>"+cfoin.food_str.replace(",", "<br></br>")+"</html>";
													billfood.setText(temp);
													JScrollPane jsp = new JScrollPane(billfood);
													jsp.setBounds(185, 127, 185, 81);
													jsp.setBackground(new Color(80, 0, 0));
													billPanel.add(jsp);
													billTotal.setText(""+cfoin.bill);
												} catch (ClassNotFoundException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										});

										JLabel lblCloseQty = new JLabel("X");
										lblCloseQty.setForeground(new Color(218, 165, 32));
										lblCloseQty.setFont(new Font("Tahoma", Font.BOLD, 18));
										lblCloseQty.setBounds(678, 11, 12, 22);
										lblCloseQty.addMouseListener(new MouseAdapter() {			
											public void mouseClicked(MouseEvent arg0) {
												qtyFoodFrame.dispose();
											}
										});
										qtypanel.add(lblCloseQty);
										item1.setVisible(false);
										txtitem1.setVisible(false);
										item2.setVisible(false);
										txtitem2.setVisible(false);
										item3.setVisible(false);
										txtitem3.setVisible(false);
										item4.setVisible(false);
										txtitem4.setVisible(false);
										item5.setVisible(false);
										txtitem5.setVisible(false);
										item6.setVisible(false);
										txtitem6.setVisible(false);
										item7.setVisible(false);
										txtitem7.setVisible(false);
										item8.setVisible(false);
										txtitem8.setVisible(false);
										switch(cnt) {
										case 1 :item1.setVisible(true);
												txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
												qtyFoodFrame.setVisible(true);
												break;
										case 2 :item1.setVisible(true);
										 		txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
										 		item2.setVisible(true);
										 		txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
												qtyFoodFrame.setVisible(true);
										 		break;
										case 3 :item1.setVisible(true);
								 				txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
								 				item2.setVisible(true);
								 				txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
								 				item3.setVisible(true);
								 				txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
												qtyFoodFrame.setVisible(true);
								 				break;
										case 4 :item1.setVisible(true);
						 						txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
						 						item2.setVisible(true);
						 						txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
						 						item3.setVisible(true);
						 						txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
						 						item4.setVisible(true);
						 						txtitem4.setVisible(true);
												item4.setText("4)"+fooditems[3]);
						 						qtyFoodFrame.setVisible(true);
						 						break;
										case 5 :item1.setVisible(true);
												txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
												item2.setVisible(true);
												txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
												item3.setVisible(true);
												txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
												item4.setVisible(true);
												txtitem4.setVisible(true);
												item4.setText("4)"+fooditems[3]);
												item5.setVisible(true);
												txtitem5.setVisible(true);
												item5.setText("5)"+fooditems[4]);
												qtyFoodFrame.setVisible(true);
												break;
										case 6 :item1.setVisible(true);
												txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
												item2.setVisible(true);
												txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
												item3.setVisible(true);
												txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
												item4.setVisible(true);
												txtitem4.setVisible(true);
												item4.setText("4)"+fooditems[3]);
												item5.setVisible(true);
												txtitem5.setVisible(true);
												item5.setText("5)"+fooditems[4]);
												item6.setVisible(true);
												txtitem6.setVisible(true);
												item6.setText("6)"+fooditems[5]);
												qtyFoodFrame.setVisible(true);
												break;
										case 7 :item1.setVisible(true);
												txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
												item2.setVisible(true);
												txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
												item3.setVisible(true);
												txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
												item4.setVisible(true);
												txtitem4.setVisible(true);
												item4.setText("4)"+fooditems[3]);
												item5.setVisible(true);
												txtitem5.setVisible(true);
												item5.setText("5)"+fooditems[4]);
												item6.setVisible(true);
												txtitem6.setVisible(true);
												item6.setText("6)"+fooditems[5]);
												item7.setVisible(true);
												txtitem7.setVisible(true);
												item7.setText("7)"+fooditems[6]);
												qtyFoodFrame.setVisible(true);
												break;
										case 8 :item1.setVisible(true);
												txtitem1.setVisible(true);
												item1.setText("1)"+fooditems[0]);
												item2.setVisible(true);
												txtitem2.setVisible(true);
												item2.setText("2)"+fooditems[1]);
												item3.setVisible(true);
												txtitem3.setVisible(true);
												item3.setText("3)"+fooditems[2]);
												item4.setVisible(true);
												txtitem4.setVisible(true);
												item4.setText("4)"+fooditems[3]);
												item5.setVisible(true);
												txtitem5.setVisible(true);
												item5.setText("5)"+fooditems[4]);
												item6.setVisible(true);
												txtitem6.setVisible(true);
												item6.setText("6)"+fooditems[5]);
												qtyFoodFrame.setVisible(true);
												item7.setVisible(true);
												txtitem7.setVisible(true);
												item7.setText("7)"+fooditems[6]);
												item8.setVisible(true);
												txtitem8.setVisible(true);
												item8.setText("8)"+fooditems[7]);
												qtyFoodFrame.setVisible(true);
												break;
										default:qtyFoodFrame.dispose();
												JOptionPane.showMessageDialog(frame, "No food items were selected !");
										}
										chckbxCrispy.setSelected(false);
										chckbxCheesePineappleCherry.setSelected(false);
										chckbxMushroomTikka.setSelected(false);
										chckbxPaneerSatay.setSelected(false);
										chckbxPaneerMalaiTikka.setSelected(false);
										chckbxChineseBhel.setSelected(false);
										chckbxVegManchurian.setSelected(false);
										chckbxPaneerBhurji.setSelected(false);
									}
								});
							}
						});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientGUI() {
//		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 898, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);

		cancelorderpanel = new JPanel();
		cancelorderpanel.setBackground(new Color(80, 0, 0));
		cancelorderpanel.setBounds(86, 125, 727, 196);
		frame.getContentPane().add(cancelorderpanel);
		cancelorderpanel.setLayout(null);
		
		foodpanel = new JPanel();
		foodpanel.setBackground(new Color(80, 0, 0));
		foodpanel.setBounds(86, 125, 727, 196);
		frame.getContentPane().add(foodpanel);
		foodpanel.setLayout(null);
		 lblNewLabel_3 = new JLabel("");
		 lblNewLabel_3.setBounds(5, 5, 56, 49);
		 frame.getContentPane().add(lblNewLabel_3);
		 ImageIcon icon4=(new ImageIcon("C:\\Users\\karan\\Downloads\\newhome.png"));
		 Image img4=icon4.getImage();
		 Image resizedImage4=img4.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(),java.awt.Image.SCALE_SMOOTH);
		 lblNewLabel_3.setIcon(new ImageIcon(resizedImage4));
		 
		 TITLE = new JLabel("WELCOME TO HOTEL ROYAL");
		 TITLE.setHorizontalAlignment(SwingConstants.CENTER);
		 TITLE.setForeground(new Color(218, 165, 32));
		 TITLE.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		 TITLE.setBounds(283, 232, 350, 30);
		 
		 hands1 = new JLabel("");
		 hands1.setBounds(260, 232, 34, 30);
		 frame.getContentPane().add(hands1);
		 ImageIcon handimg = new ImageIcon("C:\\Users\\karan\\Downloads\\hands.jpg");
		 Image imghnd = handimg.getImage();
		 Image resizedimg = imghnd.getScaledInstance(hands1.getWidth(), hands1.getHeight(), java.awt.Image.SCALE_SMOOTH);
		 hands1.setIcon(new ImageIcon(resizedimg));
		 
		 hands2 = new JLabel("");
		 hands2.setBounds(622, 232, 34, 30);
		 frame.getContentPane().add(hands2);
		 hands2.setIcon(new ImageIcon(resizedimg));
		 
		 frame.getContentPane().add(TITLE);
		 panel = new JPanel();
		panel.setBounds(86, 123, 727, 198);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		first= new JLabel("1st FLOOR");
		first.setHorizontalAlignment(SwingConstants.CENTER);
		first.setBounds(10, 27, 71, 29);
		panel.add(first);
		
		 second = new JLabel("2nd FLOOR");
		 second.setHorizontalAlignment(SwingConstants.CENTER);
		second.setBounds(10, 86, 71, 29);
		panel.add(second);
		
		 third = new JLabel("3rd FLOOR");
		 third.setHorizontalAlignment(SwingConstants.CENTER);
		third.setBounds(10, 145, 71, 29);
		panel.add(third);
		
		FR1 = new JLabel("101");
		FR1.setHorizontalAlignment(SwingConstants.CENTER);
		FR1.setBounds(128, 27, 45, 29);
		panel.add(FR1);
		FR2 = new JLabel("102");
		FR2.setHorizontalAlignment(SwingConstants.CENTER);
		FR2.setBounds(212, 27, 45, 29);
		panel.add(FR2);
		
		FR3 = new JLabel("103");
		FR3.setHorizontalAlignment(SwingConstants.CENTER);
		FR3.setBounds(291, 27, 45, 29);
		panel.add(FR3);
		
		FR4 = new JLabel("104");
		FR4.setHorizontalAlignment(SwingConstants.CENTER);
		FR4.setBounds(369, 27, 45, 29);
		panel.add(FR4);
		
		FR5 = new JLabel("105");
		FR5.setHorizontalAlignment(SwingConstants.CENTER);
		FR5.setBounds(447, 27, 45, 29);
		panel.add(FR5);
		
		SR1 = new JLabel("201");
		SR1.setHorizontalAlignment(SwingConstants.CENTER);
		SR1.setBounds(128, 86, 45, 29);
		panel.add(SR1);
		
		SR2 = new JLabel("202");
		SR2.setHorizontalAlignment(SwingConstants.CENTER);
		SR2.setBounds(212, 86, 45, 29);
		panel.add(SR2);
		 
		 SR3 = new JLabel("203");
		 SR3.setHorizontalAlignment(SwingConstants.CENTER);
		 SR3.setBounds(291, 86, 45, 29);
		 panel.add(SR3);
		 
		 SR4 = new JLabel("204");
		 SR4.setHorizontalAlignment(SwingConstants.CENTER);
		 SR4.setBounds(369, 86, 45, 29);
		 panel.add(SR4);
		 
		 SR5 = new JLabel("205");
		 SR5.setHorizontalAlignment(SwingConstants.CENTER);
		 SR5.setBounds(447, 86, 45, 29);
		 panel.add(SR5);
		 
		 TR1 = new JLabel("301");
		 TR1.setHorizontalAlignment(SwingConstants.CENTER);
		 TR1.setBounds(128, 145, 45, 29);
		 panel.add(TR1);
		 
		 TR2 = new JLabel("302");
		 TR2.setHorizontalAlignment(SwingConstants.CENTER);
		 TR2.setBounds(212, 145, 45, 29);
		 panel.add(TR2);
		 
		 TR3 = new JLabel("303");
		 TR3.setHorizontalAlignment(SwingConstants.CENTER);
		 TR3.setBounds(291, 145, 45, 29);
		 panel.add(TR3);
		 
		 TR4 = new JLabel("304");
		 TR4.setHorizontalAlignment(SwingConstants.CENTER);
		 TR4.setBounds(369, 145, 45, 29);
		 panel.add(TR4);
		 
		 TR5 = new JLabel("305");
		 TR5.setHorizontalAlignment(SwingConstants.CENTER);
		 TR5.setBounds(447, 145, 45, 29);
		 panel.add(TR5);
		 
		 FR6 = new JLabel("106");
		 FR6.setHorizontalAlignment(SwingConstants.CENTER);
		 FR6.setBounds(535, 27, 45, 29);
		 panel.add(FR6);
		 
		 FR7 = new JLabel("107");
		 FR7.setHorizontalAlignment(SwingConstants.CENTER);
		 FR7.setBounds(623, 27, 45, 29);
		 panel.add(FR7);
		 
		 SR6 = new JLabel("206");
		 SR6.setHorizontalAlignment(SwingConstants.CENTER);
		 SR6.setBounds(535, 86, 45, 29);
		 panel.add(SR6);
		 
		 SR7 = new JLabel("207");
		 SR7.setHorizontalAlignment(SwingConstants.CENTER);
		 SR7.setBounds(623, 86, 45, 29);
		 panel.add(SR7);
		 
		 TR6 = new JLabel("306");
		 TR6.setHorizontalAlignment(SwingConstants.CENTER);
		 TR6.setBounds(535, 145, 45, 29);
		 panel.add(TR6);
		 
		 TR7 = new JLabel("307");
		 TR7.setHorizontalAlignment(SwingConstants.CENTER);
		 TR7.setBounds(623, 145, 45, 29);
		 panel.add(TR7);
			
			lblSelectDate = new JLabel("select date");
			lblSelectDate.setForeground(new Color(218, 165, 32));
			lblSelectDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSelectDate.setBounds(395, 221, 121, 34);
			frame.getContentPane().add(lblSelectDate);
			
		btnPickDate = new JButton("Pick Date");
			btnPickDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnPickDate.setBounds(528, 221, 97, 34);
			btnPickDate.setForeground(new Color(218, 165, 32));
			frame.getContentPane().add(btnPickDate);
			
			lblEnterHowMany = new JLabel("Enter how many days you will be staying :");
			lblEnterHowMany.setForeground(new Color(218, 165, 32));
			lblEnterHowMany.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEnterHowMany.setBounds(59, 221, 324, 34);
			frame.getContentPane().add(lblEnterHowMany);
			
			lblNameOfCustomer = new JLabel("Name of customer :");
			lblNameOfCustomer.setForeground(new Color(218, 165, 32));
			lblNameOfCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNameOfCustomer.setBounds(203, 137, 141, 28);
			frame.getContentPane().add(lblNameOfCustomer);
			
			txtName = new JTextField();
			txtName.setBounds(375, 135, 263, 34);
			frame.getContentPane().add(txtName);
			txtName.setColumns(10);
			
			lblViewContactDetails = new JLabel("Contact Details :");
			lblViewContactDetails.setForeground(new Color(218, 165, 32));
			lblViewContactDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblViewContactDetails.setBounds(228, 180, 121, 28);
			frame.getContentPane().add(lblViewContactDetails);
			
			txtContact = new JTextField();
			txtContact.setColumns(10);
			txtContact.setBounds(375, 178, 263, 34);
			frame.getContentPane().add(txtContact);
			
			btnConfirmBooking = new JButton("Confirm Booking");
			btnConfirmBooking.setFont(new Font("Swis721 Lt BT", Font.BOLD, 15));
			 btnConfirmBooking.setForeground(new Color(218, 165, 32));
			btnConfirmBooking.setBounds(302, 275, 172, 34);
			frame.getContentPane().add(btnConfirmBooking);
			lblNameOfCustomer.setVisible(false);
			lblViewContactDetails.setVisible(false);
			lblEnterHowMany.setVisible(false);
			lblSelectDate.setVisible(false);
			btnPickDate.setVisible(false);
			txtName.setVisible(false);
			txtContact.setVisible(false);
			btnConfirmBooking.setVisible(false);
			
		 
		 FR1.addMouseListener(this);
			FR2.addMouseListener(this);
			FR3.addMouseListener(this);
			FR4.addMouseListener(this);
			FR5.addMouseListener(this);
			FR6.addMouseListener(this);
			FR7.addMouseListener(this);
			
			SR1.addMouseListener(this);
			SR2.addMouseListener(this);
			SR3.addMouseListener(this);
			SR4.addMouseListener(this);
			SR5.addMouseListener(this);
			SR6.addMouseListener(this);
			SR7.addMouseListener(this);

			TR1.addMouseListener(this);
			TR2.addMouseListener(this);
			TR3.addMouseListener(this);
			TR4.addMouseListener(this);
			TR5.addMouseListener(this);
			TR6.addMouseListener(this);
			TR7.addMouseListener(this);

		 
		 btnBookARoom = new JButton("BOOK A ROOM / CHECKOUT");
		 btnBookARoom.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		 btnBookARoom.setForeground(new Color(218, 165, 32));
		 btnBookARoom.setBounds(180, 273, 249, 30);
		 frame.getContentPane().add(btnBookARoom);
		 
		 btnOrderFood = new JButton("ORDER FOOD / CANCEL ORDER");
		 btnOrderFood.setForeground(new Color(218, 165, 32));
		 btnOrderFood.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		 btnOrderFood.setBounds(510, 273, 249, 30);
		 frame.getContentPane().add(btnOrderFood);
		 
		 lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setBounds(387, 125, 126, 103);
		 frame.getContentPane().add(lblNewLabel_1);
		 ImageIcon icon2= (new ImageIcon("C:\\Users\\karan\\Downloads\\royal.jpg"));
		 Image img2=icon2.getImage();
		 Image resizedImage2=img2.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),java.awt.Image.SCALE_SMOOTH);
		 lblNewLabel_1.setIcon(new ImageIcon(resizedImage2));
		 
		 lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(0, 0, 898, 446);
		 frame.getContentPane().add(lblNewLabel);
		 ImageIcon icon=(new ImageIcon("C:\\Users\\karan\\Downloads\\images.jpeg"));
		 Image img=icon.getImage();
		 Image resizedImage=img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),java.awt.Image.SCALE_SMOOTH);
		 lblNewLabel.setIcon(new ImageIcon(resizedImage));
	
		 panel.setVisible(false);
		 lblNewLabel_3.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent me) {
				panel.setVisible(false);
				lblNameOfCustomer.setVisible(false);
				lblViewContactDetails.setVisible(false);
				lblEnterHowMany.setVisible(false);
				lblSelectDate.setVisible(false);
				btnPickDate.setVisible(false);
				txtName.setVisible(false);
				txtContact.setVisible(false);
				btnConfirmBooking.setVisible(false);
				btnBookARoom.setVisible(true);
				btnOrderFood.setVisible(true);
				lblNewLabel_1.setVisible(true);
				TITLE.setVisible(true);
				hands1.setVisible(true);
				hands2.setVisible(true);
				foodpanel.setVisible(false);
				cancelorderpanel.setVisible(false);
				lblCustCancelName.setText("");
				chckbxCheesePineappleCherry.setSelected(false);
				chckbxChineseBhel.setSelected(false);
				chckbxCrispy.setSelected(false);
				chckbxMushroomTikka.setSelected(false);
				chckbxPaneerBhurji.setSelected(false);
				chckbxPaneerMalaiTikka.setSelected(false);
				chckbxPaneerSatay.setSelected(false);
				chckbxVegManchurian.setSelected(false);
			 }
		});
		
	}

	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		if(me.getComponent()==FR1) {
			roomno= FR1.getText();
		}
		else if(me.getComponent()==FR2) {
			roomno= FR2.getText();
		}
		else if(me.getComponent()==FR3) {
			roomno= FR3.getText();
		}
		else if(me.getComponent()==FR4) {
			roomno= FR4.getText();
		}
		else if(me.getComponent()==FR5) {
			roomno= FR5.getText();
		}
		else if(me.getComponent()==FR6) {
			roomno= FR6.getText();
		}
		else if(me.getComponent()==FR7) {
			roomno= FR7.getText();
		}
		else if(me.getComponent()==SR1) {
			roomno= SR1.getText();
		}
		else if(me.getComponent()==SR2) {
			roomno= SR2.getText();
		}
		else if(me.getComponent()==SR3) {
			roomno= SR3.getText();
		}
		else if(me.getComponent()==SR4) {
			roomno= SR4.getText();
		}
		else if(me.getComponent()==SR5) {
			roomno= SR5.getText();
		}
		else if(me.getComponent()==SR6) {
			roomno= SR6.getText();
		}
		else if(me.getComponent()==SR7) {
			roomno= SR7.getText();
		}
		else if(me.getComponent()==TR1) {
			roomno= TR1.getText();
		}
		else if(me.getComponent()==TR2) {
			roomno= TR2.getText();
		}
		else if(me.getComponent()==TR3) {
			roomno= TR3.getText();
		}
		else if(me.getComponent()==TR4) {
			roomno= TR4.getText();
		}
		else if(me.getComponent()==TR5) {
			roomno= TR5.getText();
		}
		else if(me.getComponent()==TR6) {
			roomno= TR6.getText();
		}
		else if(me.getComponent()==TR7) {
			roomno= TR7.getText();
		}
		
		try {
			DataOutputStream dout;
			dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("2");
			dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF(roomno);
			ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
			 try {
				OccupantDetails opd=(OccupantDetails)oin.readObject();
				if(opd.status.equals("booked")) {
					//JOptionPane.showMessageDialog(frame,roomno+" isn't available");
					dout = new DataOutputStream(s.getOutputStream());
					dout.writeUTF("3");
					
				}
				else if(opd.status.equals("available")) {
					//JOptionPane.showMessageDialog(frame,roomno+" is available");
					dout = new DataOutputStream(s.getOutputStream());
					dout.writeUTF("3");
					
				}
				final JFrame rdetails = new JFrame();
				rdetails.setUndecorated(true);
				rdetails.setLocationRelativeTo(frame);
				rdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				rdetails.setBounds(250, 100, 520, 573);
				JPanel contentPane = new JPanel();
				contentPane.setBackground(new Color(80, 0, 0));
				contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				rdetails.setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel label = new JLabel("< Room Details >");
				label.setForeground(new Color(255, 165, 32));
				label.setBackground(Color.WHITE);
				label.setFont(new Font("Square721 BT", Font.BOLD, 23));
				label.setBounds(150, 24, 210, 37);
				contentPane.add(label);
				
				JLabel lblRoomNumber = new JLabel("Room Number :");
				lblRoomNumber.setForeground(new Color(255, 165, 32));
				lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblRoomNumber.setBounds(49, 95, 134, 22);
				contentPane.add(lblRoomNumber);
				
				JLabel lblCurrentCustomer = new JLabel("Current Customer :");
				lblCurrentCustomer.setForeground(new Color(255, 165, 32));
				lblCurrentCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblCurrentCustomer.setBounds(28, 146, 142, 22);
				contentPane.add(lblCurrentCustomer);
				
				JLabel lblContactDetails = new JLabel("Contact Details :");
				lblContactDetails.setForeground(new Color(255, 165, 32));
				lblContactDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblContactDetails.setBounds(49, 197, 142, 22);
				contentPane.add(lblContactDetails);
				
				JLabel lblRoomStatus = new JLabel("Room Status :");
				lblRoomStatus.setForeground(new Color(255, 165, 32));
				lblRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblRoomStatus.setBounds(64, 248, 142, 22);
				contentPane.add(lblRoomStatus);
				
				JButton btnBooking = new JButton("Book");
				btnBooking.setForeground(new Color(255, 165, 32));
				btnBooking.setFont(new Font("Tahoma", Font.PLAIN, 17));
				btnBooking.setBounds(113, 519, 97, 31);
				contentPane.add(btnBooking);
				
				JButton btnCancel = new JButton("Go Back");
				btnCancel.setForeground(new Color(255, 165, 32));
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
				btnCancel.setBounds(269, 519, 97, 31);
				contentPane.add(btnCancel);
				
				final JLabel lblValRoomNumber = new JLabel("");
				lblValRoomNumber.setForeground(new Color(255, 165, 32));
				lblValRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValRoomNumber.setBounds(224, 95, 134, 22);
				contentPane.add(lblValRoomNumber);
				
				JLabel lblValCurrentCustomer = new JLabel("");
				lblValCurrentCustomer.setForeground(new Color(255, 165, 32));
				lblValCurrentCustomer.setHorizontalAlignment(SwingConstants.TRAILING);
				lblValCurrentCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValCurrentCustomer.setBounds(152, 146, 109, 22);
				contentPane.add(lblValCurrentCustomer);
				
				JLabel lblValContactDetails = new JLabel("");
				lblValContactDetails.setForeground(new Color(255, 165, 32));
				lblValContactDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValContactDetails.setBounds(224, 197, 142, 22);
				contentPane.add(lblValContactDetails);
				
				JLabel lblValRoomStatus = new JLabel("");
				lblValRoomStatus.setForeground(new Color(255, 165, 32));
				lblValRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValRoomStatus.setBounds(224, 248, 142, 22);
				contentPane.add(lblValRoomStatus);
				
				JLabel lblClose = new JLabel("X");
				lblClose.setForeground(new Color(255, 165, 32));
				lblClose.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0) {
						rdetails.dispose();
					}
				});
				lblClose.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				lblClose.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 24));
				lblClose.setBounds(486, 13, 22, 31);
				contentPane.add(lblClose);
				
				JLabel lblRoomType = new JLabel("Room Type :");
				lblRoomType.setForeground(new Color(255, 165, 32));
				lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblRoomType.setBounds(78, 398, 142, 22);
				contentPane.add(lblRoomType);
				
				JLabel lblRoomFair = new JLabel("Room Fair (1 day ) :");
				lblRoomFair.setForeground(new Color(255, 165, 32));
				lblRoomFair.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblRoomFair.setBounds(28, 451, 159, 22);
				contentPane.add(lblRoomFair);
				
				JLabel lblValRoomType = new JLabel("");
				lblValRoomType.setForeground(new Color(255, 165, 32));
				lblValRoomType.setName("");
				lblValRoomType.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValRoomType.setBounds(228, 398, 142, 22);
				contentPane.add(lblValRoomType);
				
				final JLabel lblValRoomFair = new JLabel("");
				lblValRoomFair.setForeground(new Color(255, 165, 32));
				lblValRoomFair.setName("");
				lblValRoomFair.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValRoomFair.setBounds(228, 455, 142, 22);
				contentPane.add(lblValRoomFair);
				
				JLabel lblBill = new JLabel("Bill :");
				lblBill.setForeground(new Color(255, 165, 32));
				lblBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblBill.setBounds(135, 295, 53, 22);
				contentPane.add(lblBill);
				
				JLabel lblValBill = new JLabel("");
				lblValBill.setForeground(new Color(255, 165, 32));
				lblValBill.setName("");
				lblValBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValBill.setBounds(228, 295, 142, 22);
				contentPane.add(lblValBill);
				
				JLabel lblNumberOfDays = new JLabel("Number of days :");
				lblNumberOfDays.setForeground(new Color(255, 165, 32));
				lblNumberOfDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNumberOfDays.setBounds(47, 352, 159, 22);
				contentPane.add(lblNumberOfDays);
				
				JLabel lblValDays = new JLabel("");
				lblValDays.setForeground(new Color(255, 165, 32));
				lblValDays.setName("");
				lblValDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblValDays.setBounds(228, 352, 142, 22);
				contentPane.add(lblValDays);
				
				JButton btnCheckOut = new JButton("Check Out");
				btnCheckOut.setForeground(new Color(255, 165, 32));
				btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
				btnCheckOut.setBounds(101, 519, 123, 31);
				contentPane.add(btnCheckOut);
				btnCheckOut.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent mev) {
						lblNameOfCustomer.setVisible(false);
						lblViewContactDetails.setVisible(false);
						lblEnterHowMany.setVisible(false);
						lblSelectDate.setVisible(false);
						btnPickDate.setVisible(false);
						txtName.setVisible(false);
						txtContact.setVisible(false);
						btnConfirmBooking.setVisible(false);
						rdetails.setVisible(false);
						panel.setVisible(true);
						DataOutputStream dout;
					try {						
						dout = new DataOutputStream(s.getOutputStream());
						dout.writeUTF("5");
						dout = new DataOutputStream(s.getOutputStream());
						dout.writeUTF(roomno);
						System.out.println("into checkout"+roomno+"vxvx");
						try {
							choice="1";
					 		room_detail rd=new room_detail();
							System.out.println("eneterd");
						 	 dout.writeUTF(choice);
						 	DataInputStream din = new DataInputStream(s.getInputStream());
							boolean exit=din.readBoolean();
							if(exit) {
								JOptionPane.showMessageDialog(null,"XYZ");
							}
							else {
								while(!exit) {							
									ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
									 rd=(room_detail)oin.readObject();
								System.out.print(rd.roomno);
								if(rd.roomno==101) {
									if(rd.status.equals("booked")) {
										FR1.setForeground(Color.red);
										Border border11=BorderFactory.createLineBorder(Color.red, 2);
										
										FR1.setBorder(border11);
									}
									else {
										FR1.setForeground(Color.GREEN);
										Border border1_1=BorderFactory.createLineBorder(Color.GREEN, 2);
										FR1.setBorder(border1_1);
									
									}
								}
								 if(rd.roomno==102) {
									if(rd.status.equals("booked")) {
										FR2.setForeground(Color.red);
										Border border12=BorderFactory.createLineBorder(Color.red,2);
										FR2.setBorder(border12);
									}
									else {
										FR2.setForeground(Color.GREEN);
										Border border1_2=BorderFactory.createLineBorder(Color.GREEN,2);
										FR2.setBorder(border1_2);											
									}
								}
								 if(rd.roomno==103) {
									if(rd.status.equals("booked")) {
										FR3.setForeground(Color.red);
										Border border13=BorderFactory.createLineBorder(Color.red,2);
										FR3.setBorder(border13);
									}
									else {
										FR3.setForeground(Color.GREEN);
										Border border1_3=BorderFactory.createLineBorder(Color.GREEN,2);
										FR3.setBorder(border1_3);
									}
								}
								 if(rd.roomno==104) {
									if(rd.status.equals("booked")) {
										FR4.setForeground(Color.red);
										Border border14=BorderFactory.createLineBorder(Color.red,2);
										FR4.setBorder(border14);
									}
									else {
										FR4.setForeground(Color.GREEN);
										Border border1_4=BorderFactory.createLineBorder(Color.GREEN,2);
										FR4.setBorder(border1_4);
									}
								}
								 if(rd.roomno==105) {
									if(rd.status.equals("booked")) {
										FR5.setForeground(Color.red);
										Border border15=BorderFactory.createLineBorder(Color.red,2);
										FR5.setBorder(border15);
									}
									else {
										FR5.setForeground(Color.GREEN);
										Border border1_5=BorderFactory.createLineBorder(Color.GREEN,2);
										FR5.setBorder(border1_5);
									}
								}
								 if(rd.roomno==106) {
									if(rd.status.equals("booked")) {
										FR6.setForeground(Color.red);
										Border border16=BorderFactory.createLineBorder(Color.red,2);
										FR6.setBorder(border16);
									}
									else {
										FR6.setForeground(Color.GREEN);
										Border border1_6=BorderFactory.createLineBorder(Color.GREEN,2);
										FR6.setBorder(border1_6);										
									}
								}
								 if(rd.roomno==107) {
									if(rd.status.equals("booked")) {
										FR7.setForeground(Color.red);
										Border border17=BorderFactory.createLineBorder(Color.red,2);
										FR7.setBorder(border17);											
									}
									else {
										FR7.setForeground(Color.GREEN);
										Border border1_7=BorderFactory.createLineBorder(Color.GREEN,2);
										FR7.setBorder(border1_7);										
									}
								}
								 if(rd.roomno==201) {
									if(rd.status.equals("booked")) {
										SR1.setForeground(Color.red);
										Border border21=BorderFactory.createLineBorder(Color.red,2);
										SR1.setBorder(border21);
									
									}
									else {
										SR1.setForeground(Color.GREEN);
										Border border2_1=BorderFactory.createLineBorder(Color.GREEN,2);
										SR1.setBorder(border2_1);
									}
								}
								 if(rd.roomno==202) {
									if(rd.status.equals("booked")) {
										SR2.setForeground(Color.red);
										Border border22=BorderFactory.createLineBorder(Color.red,2);
										SR2.setBorder(border22);
									}
									else {
										SR2.setForeground(Color.GREEN);
										Border border2_2=BorderFactory.createLineBorder(Color.GREEN,2);
										SR2.setBorder(border2_2);
									}
								}
								 if(rd.roomno==203) {
									if(rd.status.equals("booked")) {
										SR3.setForeground(Color.red);
										Border border23=BorderFactory.createLineBorder(Color.red,2);
										SR3.setBorder(border23);
									}
									else {
										SR3.setForeground(Color.GREEN);
										Border border2_3=BorderFactory.createLineBorder(Color.GREEN,2);
										SR3.setBorder(border2_3);
									}
								}
								 if(rd.roomno==204) {
									if(rd.status.equals("booked")) {
										SR4.setForeground(Color.red);
										Border border24=BorderFactory.createLineBorder(Color.red,2);
										SR4.setBorder(border24);
									}
									else {
										SR4.setForeground(Color.GREEN);
										Border border2_4=BorderFactory.createLineBorder(Color.GREEN,2);
										SR4.setBorder(border2_4);
									}
								}
								 if(rd.roomno==205) {
									if(rd.status.equals("booked")) {
										SR5.setForeground(Color.red);
										Border border25=BorderFactory.createLineBorder(Color.red,2);
										SR5.setBorder(border25);
									}
									else {
										SR5.setForeground(Color.GREEN);
										Border border2_5=BorderFactory.createLineBorder(Color.GREEN,2);
										SR5.setBorder(border2_5);
									}
								}
								 if(rd.roomno==206) {
									if(rd.status.equals("booked")) {
										SR6.setForeground(Color.red);
										Border border26=BorderFactory.createLineBorder(Color.red,2);
										SR6.setBorder(border26);
									}
									else {
										SR6.setForeground(Color.GREEN);
										Border border2_6=BorderFactory.createLineBorder(Color.GREEN,2);
										SR6.setBorder(border2_6);
									}
								}
								 if(rd.roomno==207) {
									if(rd.status.equals("booked")) {
										SR7.setForeground(Color.red);
										Border border27=BorderFactory.createLineBorder(Color.red,2);
										SR7.setBorder(border27);
									}
									else {
										SR7.setForeground(Color.GREEN);
										Border border2_7=BorderFactory.createLineBorder(Color.GREEN,2);
										SR7.setBorder(border2_7);
									}
								}
								 if(rd.roomno==301) {
									if(rd.status.equals("booked")) {
										TR1.setForeground(Color.red);
										Border border31=BorderFactory.createLineBorder(Color.red,2);
										TR1.setBorder(border31);
									}
									else {
										TR1.setForeground(Color.GREEN);
										Border border3_1=BorderFactory.createLineBorder(Color.GREEN,2);
										TR1.setBorder(border3_1);
									}
								}
								 if(rd.roomno==302) {
									if(rd.status.equals("booked")) {
										TR2.setForeground(Color.red);
										Border border32=BorderFactory.createLineBorder(Color.red,2);
										TR2.setBorder(border32);
									}
									else {
										TR2.setForeground(Color.GREEN);
										Border border3_2=BorderFactory.createLineBorder(Color.GREEN,2);
										TR2.setBorder(border3_2);
									}
								}
								 if(rd.roomno==303) {
									if(rd.status.equals("booked")) {
										TR3.setForeground(Color.red);
										Border border33=BorderFactory.createLineBorder(Color.red,2);
										TR3.setBorder(border33);
									}
									else {
										TR3.setForeground(Color.GREEN);
										Border border3_3=BorderFactory.createLineBorder(Color.GREEN,2);
										TR3.setBorder(border3_3);
									}
								}
								 if(rd.roomno==304) {
									if(rd.status.equals("booked")) {
										TR4.setForeground(Color.red);
										Border border34=BorderFactory.createLineBorder(Color.red,2);
										TR4.setBorder(border34);
									}
									else {
										TR4.setForeground(Color.GREEN);
										Border border3_4=BorderFactory.createLineBorder(Color.GREEN,2);
										TR4.setBorder(border3_4);
									}
								}
								
								 if(rd.roomno==305) {
									if(rd.status.equals("booked")) {
										TR5.setForeground(Color.red);
										Border border35=BorderFactory.createLineBorder(Color.red,2);
										TR5.setBorder(border35);
									}
									else {
										TR5.setForeground(Color.GREEN);
										Border border3_5=BorderFactory.createLineBorder(Color.GREEN,2);
										TR5.setBorder(border3_5);
									}
								}
								 if(rd.roomno==306) {
									if(rd.status.equals("booked")) {
										TR6.setForeground(Color.red);
										Border border36=BorderFactory.createLineBorder(Color.red,2);
										TR6.setBorder(border36);
									}
									else {
										TR6.setForeground(Color.GREEN);
										Border border3_6=BorderFactory.createLineBorder(Color.GREEN,2);
										TR6.setBorder(border3_6);
									}
								}
								 if(rd.roomno==307) {
									if(rd.status.equals("booked")) {
										TR7.setForeground(Color.red);
										Border border37=BorderFactory.createLineBorder(Color.red,2);
										TR7.setBorder(border37);
									}
									else {
										TR7.setForeground(Color.GREEN);
										Border border3_7=BorderFactory.createLineBorder(Color.GREEN,2);
										TR7.setBorder(border3_7);
									}
								}
								 exit=din.readBoolean();
							}
							}	
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				});
				btnCancel.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent me) {
						rdetails.dispose();
					}
				});
				if(opd.status.equals("booked"))
				{
					btnBooking.setVisible(false);
					btnCheckOut.setVisible(true);
				}
				else
				{
					btnBooking.setVisible(true);
					btnCheckOut.setVisible(false);
				}
				
				rdetails.setVisible(true);
				
				lblValRoomFair.setText(""+opd.cost);
				lblValRoomNumber.setText(roomno);
				lblValRoomStatus.setText(opd.status);
				lblValRoomType.setText(opd.room_type);
				lblValContactDetails.setText(opd.cust_contact);
				lblValCurrentCustomer.setText(opd.cust_name);
				lblValBill.setText(""+opd.cust_bill);
				lblValDays.setText(""+opd.cust_days);
				
				btnBooking.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me) {
						rdetails.dispose();
						panel.setVisible(false);
						
						
						lblNameOfCustomer.setVisible(true);
						lblViewContactDetails.setVisible(true);
						lblEnterHowMany.setVisible(true);
						lblSelectDate.setVisible(true);
						btnPickDate.setVisible(true);
						txtName.setVisible(true);
						txtContact.setVisible(true);
						btnConfirmBooking.setVisible(true);
						SwingUtilities.updateComponentTreeUI(frame);
						btnPickDate.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent me) {
								lblSelectDate.setText(new DatePicker(frame).setPickedDate());
							}
						});
						btnConfirmBooking.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent me) {
								try {
								Date date = new Date();
								
									Date userdate = new SimpleDateFormat("dd-MM-yyyy").parse(lblSelectDate.getText().toString());
									
									long daysBetween = userdate.getTime()-date.getTime();
									int days = (int) (daysBetween/(1000*60*60*24))+1;
									int bill = Integer.parseInt(lblValRoomFair.getText())*days;
									//JOptionPane.showMessageDialog(frame, "For "+days+" days, bill will be "+bill);
									
									NewCustomer newcust = new NewCustomer(txtName.getText(), txtContact.getText(), Integer.parseInt(lblValRoomNumber.getText()), days, bill);
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("4");
									ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
									oout.writeObject(newcust);
									DataInputStream din = new DataInputStream(s.getInputStream());
									if(din.readBoolean())
									{
										JOptionPane.showMessageDialog(frame, "Room has been booked, Your bill will be "+bill+"/-");
										lblNameOfCustomer.setVisible(false);
										lblViewContactDetails.setVisible(false);
										lblEnterHowMany.setVisible(false);
										lblSelectDate.setVisible(false);
										btnPickDate.setVisible(false);
										txtName.setVisible(false);
										txtContact.setVisible(false);
										btnConfirmBooking.setVisible(false);
										panel.setVisible(true);
										try {
											choice="1";
									 		room_detail rd=new room_detail();
											System.out.println("eneterd");
										 	 dout.writeUTF(choice);
											din = new DataInputStream(s.getInputStream());
											boolean exit=din.readBoolean();
											if(exit) {
												JOptionPane.showMessageDialog(null,"XYZ");
											}
											else {
												while(!exit) {							
													ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
													 rd=(room_detail)oin.readObject();
												System.out.print(rd.roomno);
												if(rd.roomno==101) {
													if(rd.status.equals("booked")) {
														FR1.setForeground(Color.red);
														Border border11=BorderFactory.createLineBorder(Color.red, 2);
														
														FR1.setBorder(border11);
													}
													else {
														FR1.setForeground(Color.GREEN);
														Border border1_1=BorderFactory.createLineBorder(Color.GREEN, 2);
														FR1.setBorder(border1_1);
													
													}
												}
												 if(rd.roomno==102) {
													if(rd.status.equals("booked")) {
														FR2.setForeground(Color.red);
														Border border12=BorderFactory.createLineBorder(Color.red,2);
														FR2.setBorder(border12);
													}
													else {
														FR2.setForeground(Color.GREEN);
														Border border1_2=BorderFactory.createLineBorder(Color.GREEN,2);
														FR2.setBorder(border1_2);											
													}
												}
												 if(rd.roomno==103) {
													if(rd.status.equals("booked")) {
														FR3.setForeground(Color.red);
														Border border13=BorderFactory.createLineBorder(Color.red,2);
														FR3.setBorder(border13);
													}
													else {
														FR3.setForeground(Color.GREEN);
														Border border1_3=BorderFactory.createLineBorder(Color.GREEN,2);
														FR3.setBorder(border1_3);
													}
												}
												 if(rd.roomno==104) {
													if(rd.status.equals("booked")) {
														FR4.setForeground(Color.red);
														Border border14=BorderFactory.createLineBorder(Color.red,2);
														FR4.setBorder(border14);
													}
													else {
														FR4.setForeground(Color.GREEN);
														Border border1_4=BorderFactory.createLineBorder(Color.GREEN,2);
														FR4.setBorder(border1_4);
													}
												}
												 if(rd.roomno==105) {
													if(rd.status.equals("booked")) {
														FR5.setForeground(Color.red);
														Border border15=BorderFactory.createLineBorder(Color.red,2);
														FR5.setBorder(border15);
													}
													else {
														FR5.setForeground(Color.GREEN);
														Border border1_5=BorderFactory.createLineBorder(Color.GREEN,2);
														FR5.setBorder(border1_5);
													}
												}
												 if(rd.roomno==106) {
													if(rd.status.equals("booked")) {
														FR6.setForeground(Color.red);
														Border border16=BorderFactory.createLineBorder(Color.red,2);
														FR6.setBorder(border16);
													}
													else {
														FR6.setForeground(Color.GREEN);
														Border border1_6=BorderFactory.createLineBorder(Color.GREEN,2);
														FR6.setBorder(border1_6);										
													}
												}
												 if(rd.roomno==107) {
													if(rd.status.equals("booked")) {
														FR7.setForeground(Color.red);
														Border border17=BorderFactory.createLineBorder(Color.red,2);
														FR7.setBorder(border17);											
													}
													else {
														FR7.setForeground(Color.GREEN);
														Border border1_7=BorderFactory.createLineBorder(Color.GREEN,2);
														FR7.setBorder(border1_7);										
													}
												}
												 if(rd.roomno==201) {
													if(rd.status.equals("booked")) {
														SR1.setForeground(Color.red);
														Border border21=BorderFactory.createLineBorder(Color.red,2);
														SR1.setBorder(border21);
													
													}
													else {
														SR1.setForeground(Color.GREEN);
														Border border2_1=BorderFactory.createLineBorder(Color.GREEN,2);
														SR1.setBorder(border2_1);
													}
												}
												 if(rd.roomno==202) {
													if(rd.status.equals("booked")) {
														SR2.setForeground(Color.red);
														Border border22=BorderFactory.createLineBorder(Color.red,2);
														SR2.setBorder(border22);
													}
													else {
														SR2.setForeground(Color.GREEN);
														Border border2_2=BorderFactory.createLineBorder(Color.GREEN,2);
														SR2.setBorder(border2_2);
													}
												}
												 if(rd.roomno==203) {
													if(rd.status.equals("booked")) {
														SR3.setForeground(Color.red);
														Border border23=BorderFactory.createLineBorder(Color.red,2);
														SR3.setBorder(border23);
													}
													else {
														SR3.setForeground(Color.GREEN);
														Border border2_3=BorderFactory.createLineBorder(Color.GREEN,2);
														SR3.setBorder(border2_3);
													}
												}
												 if(rd.roomno==204) {
													if(rd.status.equals("booked")) {
														SR4.setForeground(Color.red);
														Border border24=BorderFactory.createLineBorder(Color.red,2);
														SR4.setBorder(border24);
													}
													else {
														SR4.setForeground(Color.GREEN);
														Border border2_4=BorderFactory.createLineBorder(Color.GREEN,2);
														SR4.setBorder(border2_4);
													}
												}
												 if(rd.roomno==205) {
													if(rd.status.equals("booked")) {
														SR5.setForeground(Color.red);
														Border border25=BorderFactory.createLineBorder(Color.red,2);
														SR5.setBorder(border25);
													}
													else {
														SR5.setForeground(Color.GREEN);
														Border border2_5=BorderFactory.createLineBorder(Color.GREEN,2);
														SR5.setBorder(border2_5);
													}
												}
												 if(rd.roomno==206) {
													if(rd.status.equals("booked")) {
														SR6.setForeground(Color.red);
														Border border26=BorderFactory.createLineBorder(Color.red,2);
														SR6.setBorder(border26);
													}
													else {
														SR6.setForeground(Color.GREEN);
														Border border2_6=BorderFactory.createLineBorder(Color.GREEN,2);
														SR6.setBorder(border2_6);
													}
												}
												 if(rd.roomno==207) {
													if(rd.status.equals("booked")) {
														SR7.setForeground(Color.red);
														Border border27=BorderFactory.createLineBorder(Color.red,2);
														SR7.setBorder(border27);
													}
													else {
														SR7.setForeground(Color.GREEN);
														Border border2_7=BorderFactory.createLineBorder(Color.GREEN,2);
														SR7.setBorder(border2_7);
													}
												}
												 if(rd.roomno==301) {
													if(rd.status.equals("booked")) {
														TR1.setForeground(Color.red);
														Border border31=BorderFactory.createLineBorder(Color.red,2);
														TR1.setBorder(border31);
													}
													else {
														TR1.setForeground(Color.GREEN);
														Border border3_1=BorderFactory.createLineBorder(Color.GREEN,2);
														TR1.setBorder(border3_1);
													}
												}
												 if(rd.roomno==302) {
													if(rd.status.equals("booked")) {
														TR2.setForeground(Color.red);
														Border border32=BorderFactory.createLineBorder(Color.red,2);
														TR2.setBorder(border32);
													}
													else {
														TR2.setForeground(Color.GREEN);
														Border border3_2=BorderFactory.createLineBorder(Color.GREEN,2);
														TR2.setBorder(border3_2);
													}
												}
												 if(rd.roomno==303) {
													if(rd.status.equals("booked")) {
														TR3.setForeground(Color.red);
														Border border33=BorderFactory.createLineBorder(Color.red,2);
														TR3.setBorder(border33);
													}
													else {
														TR3.setForeground(Color.GREEN);
														Border border3_3=BorderFactory.createLineBorder(Color.GREEN,2);
														TR3.setBorder(border3_3);
													}
												}
												 if(rd.roomno==304) {
													if(rd.status.equals("booked")) {
														TR4.setForeground(Color.red);
														Border border34=BorderFactory.createLineBorder(Color.red,2);
														TR4.setBorder(border34);
													}
													else {
														TR4.setForeground(Color.GREEN);
														Border border3_4=BorderFactory.createLineBorder(Color.GREEN,2);
														TR4.setBorder(border3_4);
													}
												}
												
												 if(rd.roomno==305) {
													if(rd.status.equals("booked")) {
														TR5.setForeground(Color.red);
														Border border35=BorderFactory.createLineBorder(Color.red,2);
														TR5.setBorder(border35);
													}
													else {
														TR5.setForeground(Color.GREEN);
														Border border3_5=BorderFactory.createLineBorder(Color.GREEN,2);
														TR5.setBorder(border3_5);
													}
												}
												 if(rd.roomno==306) {
													if(rd.status.equals("booked")) {
														TR6.setForeground(Color.red);
														Border border36=BorderFactory.createLineBorder(Color.red,2);
														TR6.setBorder(border36);
													}
													else {
														TR6.setForeground(Color.GREEN);
														Border border3_6=BorderFactory.createLineBorder(Color.GREEN,2);
														TR6.setBorder(border3_6);
													}
												}
												 if(rd.roomno==307) {
													if(rd.status.equals("booked")) {
														TR7.setForeground(Color.red);
														Border border37=BorderFactory.createLineBorder(Color.red,2);
														TR7.setBorder(border37);
													}
													else {
														TR7.setForeground(Color.GREEN);
														Border border3_7=BorderFactory.createLineBorder(Color.GREEN,2);
														TR7.setBorder(border3_7);
													}
												}
																			exit=din.readBoolean();
											}
											}	
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									else
									{
										JOptionPane.showMessageDialog(frame,"Error occured !");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
					}
				});
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class DatePicker {
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JFrame parent) {
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}