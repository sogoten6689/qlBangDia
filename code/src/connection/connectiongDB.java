package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connectiongDB {
	private static Connection conn=null;
	public static Connection getConnection() {
		// TODO Auto-generated constructor stub
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BangDia","sa","1");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"ket noi that bai",null, JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	} 
	
}
