import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class dbGUI implements ActionListener{

	/* class variables for the GUI */
	private JFrame f;
	private Label l;
	private TextField queryfield;
	private Button b;

	public dbGUI(){

		Database db = new Database("jdbc:mysql://localhost:3306/practice","root","zach"); /* connect to a database */

		f = new JFrame("DB Interface"); /* creates JFrame for the GUI */
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(600,600); /* set the size of the GUI */
		f.setLayout(new FlowLayout()); /* use flow layout */

		l= new Label("Enter Query: "); /* create a label for the JFrame */
		f.add(l); /* add label to the JFrame */

		TextField queryfield = new TextField("",50); /* create a text field for the query that the user will enter */
		f.add(queryfield); /* add it to the JFrame */

		Button b = new Button("Submit"); /* create a button for the JFrame */
		f.add(b);
	}

	public void actionPerformed(ActionEvent ev){

	}

	public static void main(String[] args){
		dbGUI gui = new dbGUI();
	}
}
