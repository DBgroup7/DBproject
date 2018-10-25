package players;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class players extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterdata_0;
	private JTextField txtEnterdata;
	private JTextField txtEnterdata_1;
	private JTextField txtEnterdata_2;
	private JTextField txtEnterdata_3;
	private JTextField txtEnterdata_4;
	private JTextField txtEnterdata_5;
	
	static String name;
	static String playerID;
	static String team_name;
	static String pos;
	static String touchdowns;
	static String total_yards;
	static String salary;
	public String sql;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					players frame = new players();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public players() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Players Table");
		Title.setBounds(207, 11, 89, 30);
		contentPane.add(Title);
		
		JLabel lblGameid = new JLabel("Name");
		lblGameid.setBounds(40, 50, 46, 14);
		contentPane.add(lblGameid);
		
		JLabel lblgameDate = new JLabel("playerID");
		lblgameDate.setBounds(40, 100, 59, 14);
		contentPane.add(lblgameDate);
		
		JLabel lblStadium = new JLabel("team_name");
		lblStadium.setBounds(40, 150, 86, 14);
		contentPane.add(lblStadium);
		
		JLabel lblResult = new JLabel("pos");
		lblResult.setBounds(40, 200, 46, 14);
		contentPane.add(lblResult);
		
		JLabel lblAttendance = new JLabel("touchdowns");
		lblAttendance.setBounds(40, 250, 59, 14);
		contentPane.add(lblAttendance);
		
		JLabel lblTicketrev = new JLabel("total_yards");
		lblTicketrev.setBounds(40, 300, 70, 14);
		contentPane.add(lblTicketrev);
		
		txtEnterdata_0 = new JTextField();
		txtEnterdata_0.setText("enterData");
		txtEnterdata_0.setBounds(191, 47, 86, 20);
		contentPane.add(txtEnterdata_0);
		txtEnterdata_0.setColumns(10);
		
		txtEnterdata = new JTextField();
		txtEnterdata.setText("enterData");
		txtEnterdata.setBounds(191, 97, 86, 20);
		contentPane.add(txtEnterdata);
		txtEnterdata.setColumns(10);
		
		txtEnterdata_1 = new JTextField();
		txtEnterdata_1.setText("enterData");
		txtEnterdata_1.setBounds(191, 147, 86, 20);
		contentPane.add(txtEnterdata_1);
		txtEnterdata_1.setColumns(10);
		
		txtEnterdata_2 = new JTextField();
		txtEnterdata_2.setText("enterData");
		txtEnterdata_2.setBounds(191, 197, 86, 20);
		contentPane.add(txtEnterdata_2);
		txtEnterdata_2.setColumns(10);
		
		txtEnterdata_3 = new JTextField();
		txtEnterdata_3.setText("enterData");
		txtEnterdata_3.setBounds(191, 247, 86, 20);
		contentPane.add(txtEnterdata_3);
		txtEnterdata_3.setColumns(10);
		
		txtEnterdata_4 = new JTextField();
		txtEnterdata_4.setText("enterData");
		txtEnterdata_4.setBounds(191, 297, 86, 20);
		contentPane.add(txtEnterdata_4);
		txtEnterdata_4.setColumns(10);
		
		
		JLabel lblSalary = new JLabel("salary");
		lblSalary.setBounds(40, 350, 46, 14);
		contentPane.add(lblSalary);
		
		txtEnterdata_5 = new JTextField();
		txtEnterdata_5.setText("enterData");
		txtEnterdata_5.setBounds(191, 347, 86, 20);
		contentPane.add(txtEnterdata_5);
		txtEnterdata_5.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(393, 346, 89, 23);
		contentPane.add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				name = txtEnterdata_0.getText();
				
				playerID = txtEnterdata.getText();
								
				team_name = txtEnterdata_1.getText();
				
				pos = txtEnterdata_2.getText();
				
				touchdowns = txtEnterdata_3.getText();
				
				total_yards = txtEnterdata_4.getText();
				
				salary = txtEnterdata_5.getText();
				
				sql = "insert into players values (\'" + name + "\', " + playerID + ", \'"
						+ team_name + "\', \'" + pos + "\', " + touchdowns + ", "
						+ total_yards + ", " + salary + ");";
				
				System.out.println(sql);
				
			}
		});	
	}
}
