package dbinterface;


/*
 * table.setModel(DbUtils.resultSetToTableModel(rs);
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class QueryInterface extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryInterface frame = new QueryInterface();
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
	public QueryInterface() {
		/* Create new database connection */
		String url="dbclass.cs.nmsu.edu:3306/cs482502fa18_zgarcia";
		String username="zgarcia";
		String password="kzR2_N9M";
		
		Database db = new Database("jdbc:mysql://"+url+"?useLegacyDatetimeCode=false&serverTimezone=America/New_York", username, password);
		
		/* Create JFrame */
		setTitle("Query Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* Add Enter Query label */
		JLabel lblEnterQuery = new JLabel("Enter Query: ");
		lblEnterQuery.setBounds(25, 12, 99, 15);
		contentPane.add(lblEnterQuery);
		
		/* Add scrollpane for query text field */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 39, 450, 111);
		contentPane.add(scrollPane);
		
		/* Add text field to type in query */
		JTextArea txtarea = new JTextArea();
		scrollPane.setViewportView(txtarea);
		
		/* Add execute query button */
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 203, 450, 273);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = txtarea.getText().toString();
				ResultSet r = db.query(q);
				//db.printResult(r);
				try {
					table.setModel(DbUtils.resultSetToTableModel(r));
				}
				catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		btnExecute.setAction(action);
		btnExecute.setBounds(201, 162, 99, 25);
		contentPane.add(btnExecute);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Execute");
			putValue(SHORT_DESCRIPTION, "Execute query");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
