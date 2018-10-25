package dbinterface;

/* Database class file, each database instance will have a url, username, password, and connection 
When a database object is instantiated, it connects to a database with the given url. 
After connecting to the database, a query function can be used to execute querys */


import java.sql.*;

public class Database {

/* each database object has these attributes */
private String url;
private String username;
private String password;
private Connection conn;

/* constructor, takes url, username, and password as parameters */
/* and then connects to the database */
public Database(String u, String usrnm, String pword){
	try
	{	
		url = u; username = usrnm; password=pword;
		System.out.println("Connecting...");
		conn=DriverManager.getConnection(u,usrnm,pword); /* create new connection with appropriate parameters */
		System.out.println("Connected Successfully");
	}
	catch(Exception e)
	{
		System.out.println(e); /* error if connection fails */
	}
}

/* function to execute a query on a database */
/* it takes 1 parameter which is the query to be executed and returns a result set*/
public ResultSet query(String q){
	try 
	{
		Statement stmt = conn.createStatement(); /* create a statement */
		ResultSet rset = stmt.executeQuery(q); /* execute the query */
		return rset;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}

/* Method to return connection */
public Connection getConn() {
	return conn;
}
/* function to print a result set */
/* takes one parameter which is the result set to be printed */
public void printResult(ResultSet rset){
	try{
		ResultSetMetaData metadata = rset.getMetaData(); /* get metadata of result set */
		int columnCount = metadata.getColumnCount(); /* use metadata to get number of columns in result */
		/* loop through all the rows of the result */
		while(rset.next()) {
			/* loop through all the columns in each row */ 
			for(int i=1; i<=columnCount; i++){
				System.out.print(rset.getString(i) + ", "); /* print data in each column */
			}
			System.out.println();
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
}
