package dbinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.awt.Dialog;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class QueryInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String q;
	private ResultSet r;
	private ResultSetMetaData rmd;
	private String[] colNames;
	private int colCount;
	private int pageSize = 10;

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
		setBounds(100, 100, 501, 557);
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
		
		/* Add scrollpane and jtable within the scrollpane */
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 203, 450, 273);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		/* Add execute button and update table with result when the button is clicked */
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int colCount=0;
				
				q = txtarea.getText().toString(); /* Read the string from the text field */
				try {
					Statement stmt =  db.getConn().createStatement();
					r=stmt.executeQuery(q);
					//r = db.query(q); /* execute the query */
				}
				catch(Exception e1) {
					System.out.println(e1);
					String eMessage = e1.getMessage();
					JOptionPane.showMessageDialog(QueryInterface.this, eMessage, "Error", JOptionPane.ERROR_MESSAGE);
				}
				/* get metadata for resultset*/
				try {
					rmd = r.getMetaData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/* get columncount from result set metadata */
				try {
					colCount = rmd.getColumnCount();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/* store column names into table model */
				String[] colNames = new String[colCount];
				for(int i=0; i<colCount; i++) {
					try {
						colNames[i]=rmd.getColumnName(i+1);
					}
					catch (SQLException el) {
						el.printStackTrace();
					}
				}
				
				/* update table model with column names*/
				DefaultTableModel model = new DefaultTableModel(colNames, 0);
				
				/* Store 1 page of row from result set and add it to the table model */
				try {
					for(int i=0; i < pageSize && r.next(); i++) {
						Object[] rowdata = new Object[colCount];

						for(int j=0; j<colCount; j++) {
							rowdata[j]=r.getObject(j+1);	
						}
						model.addRow(rowdata);
					}
				}
				
				catch(SQLException el) {
					el.printStackTrace();
				}
				
				table.setModel(model);
				//table.setModel(DbUtils.resultSetToTableModel(r)); /* set the table model to the data from the result set */
				
				
			}
		});
		btnExecute.setBounds(201, 162, 99, 25);
		contentPane.add(btnExecute);
		
	}
}
