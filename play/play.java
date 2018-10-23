package play;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class play extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterdata;
	private JTextField txtEnterdata_1;
	static String playerID;
	static String gameID;
	/**
	 * @wbp.nonvisual location=-1,259
	 */
	private final Button button = new Button("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					play frame = new play();
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
	public play() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Title = new JLabel("Play Table");
		Title.setBounds(207, 11, 89, 30);
		contentPane.add(Title);
		
		JLabel lblGameid = new JLabel("gameID");
		lblGameid.setBounds(40, 50, 46, 14);
		contentPane.add(lblGameid);
		
		JLabel lblgameDate = new JLabel("playerID");
		lblgameDate.setBounds(40, 100, 59, 14);
		contentPane.add(lblgameDate);
		
		txtEnterdata = new JTextField();
		txtEnterdata.setText("enterData");
		txtEnterdata.setBounds(185, 47, 86, 20);
		contentPane.add(txtEnterdata);
		txtEnterdata.setColumns(10);
		
		txtEnterdata_1 = new JTextField();
		txtEnterdata_1.setText("enterData");
		txtEnterdata_1.setBounds(185, 97, 86, 20);
		contentPane.add(txtEnterdata_1);
		txtEnterdata_1.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gameID = txtEnterdata.getText();
				
				playerID = txtEnterdata_1.getText();
				
			}
		});	
		btnDone.setBounds(345, 96, 89, 23);
		contentPane.add(btnDone);
		
		
	}
}
