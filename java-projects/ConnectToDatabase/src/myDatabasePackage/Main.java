package myDatabasePackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
		File myFile = new File("C:\\Users\\Manfred\\Dropbox\\dynamic (for dropbox)\\vacation housekeeping (no images)\\new zealand 2015\\4B1W","Wortliste_189000_Original.txt");
		BufferedReader myBufferedReader = new BufferedReader(new FileReader(myFile));
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/javatest","root","741eba1b741EBA!b");
		Statement stmt = con.createStatement();

		String myCommand = new String("insert into javatest.wordslowercase(rownumber,word,wordCapitalLetters) values(?,?,?);");
		PreparedStatement prepStmt = con.prepareStatement(myCommand);
		
		stmt.executeUpdate("truncate table javatest.wordslowercase");
		String line;
		int count = 1;
		while ((line=myBufferedReader.readLine())!=null) {
			prepStmt.setInt(1, count);
			prepStmt.setString(2, line);
			prepStmt.setString(3, line.toUpperCase());
			prepStmt.executeUpdate();
			count++;
		}
				
	}

}
