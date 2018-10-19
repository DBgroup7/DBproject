import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;

public class dbGUI implements ActionListener{

	/* class variables for the GUI */
	private JFrame f;
	private Label l;
	private Button b;
	private TextField queryfield;
	private String queryString;
	private Database db;

	public dbGUI(){

		f = new JFrame("DB Interface"); /* creates JFrame for the GUI */
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(600,600); /* set the size of the GUI */
		f.setLayout(new FlowLayout()); /* use flow layout */

		l= new Label("Enter Query: "); /* create a label for the JFrame */
		f.add(l); /* add label to the JFrame */

		queryfield = new TextField("",50); /* create a text field for the query that the user will enter */
		f.add(queryfield); /* add it to the JFrame */

		Button b = new Button("Submit"); /* create a button for the JFrame */
		b.addActionListener(this); /* adds an action listener to the submit button */
		f.add(b);


		String url = JOptionPane.showInputDialog(f, "Enter url: ");
		String username = JOptionPane.showInputDialog(f, "Enter username: ");
		String password = JOptionPane.showInputDialog(f, "Enter password: ");
		db = new Database("jdbc:mysql://" + url, username, password); /* connect to a database */
	}


	/* Action performed when the submit button is clicked */
	public void actionPerformed(ActionEvent ev){
		queryString = queryfield.getText(); /* String in the text field is stored */

		ResultSet result = db.query(queryString); /* Execute the query and store result in a ResultSet */
		db.printResult(result); /* print the result */
	}

	public static void main(String[] args){
		dbGUI gui = new dbGUI(); /* run an instance of the database GUI */
	}
}
