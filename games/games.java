package games;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;

public class games extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterdata_0;
	private JTextField txtEnterdata;
	private JTextField txtEnterdata_1;
	private JTextField txtEnterdata_2;
	private JTextField txtEnterdata_3;
	private JTextField txtEnterdata_4;
	
	static String gameID;
	static String gameDate;
	static String stadium;
	static String result;
	static String attendance;
	static String ticketRev;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					games frame = new games();
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
	public games() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Games Table");
		Title.setBounds(207, 11, 70, 30);
		contentPane.add(Title);
		
		JLabel lblGameid = new JLabel("gameID");
		lblGameid.setBounds(40, 50, 46, 14);
		contentPane.add(lblGameid);
		
		JLabel lblgameDate = new JLabel("gameDate");
		lblgameDate.setBounds(40, 100, 59, 14);
		contentPane.add(lblgameDate);
		
		JLabel lblStadium = new JLabel("stadium");
		lblStadium.setBounds(40, 150, 59, 14);
		contentPane.add(lblStadium);
		
		JLabel lblResult = new JLabel("result");
		lblResult.setBounds(40, 200, 46, 14);
		contentPane.add(lblResult);
		
		JLabel lblAttendance = new JLabel("attendance");
		lblAttendance.setBounds(40, 250, 75, 14);
		contentPane.add(lblAttendance);
		
		JLabel lblTicketrev = new JLabel("ticketRev");
		lblTicketrev.setBounds(40, 300, 59, 14);
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
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(391, 296, 89, 23);
		contentPane.add(btnDone);
		
btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gameID = txtEnterdata_0.getText();
				
				gameDate = txtEnterdata.getText();
								
				stadium = txtEnterdata_1.getText();
				
				result = txtEnterdata_2.getText();
				
				attendance = txtEnterdata_3.getText();
				
				ticketRev = txtEnterdata_4.getText();
				
				
				
				System.out.println(gameID);
				System.out.println(gameDate);
				System.out.println(stadium);
				System.out.println(result);
				System.out.println(attendance);
				System.out.println(ticketRev);
				
			}
		});
	}
}
