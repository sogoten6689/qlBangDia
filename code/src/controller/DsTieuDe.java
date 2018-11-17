package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import connection.connectiongDB;
import model.TieuDe;

public class DsTieuDe {
	ArrayList<TieuDe> lsTitle = new ArrayList<TieuDe>();
	
	TieuDe title;

	public ArrayList<TieuDe> loadData() {
		lsTitle.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from TieuDe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String idTitle = rs.getString(1);
				String name = rs.getString(2);
				String noiDung = rs.getString(3);
				int replica = rs.getInt(4);
				int rented = rs.getInt(5);
				float price = rs.getFloat(6);
				title = new TieuDe(idTitle, name, noiDung, replica, rented, price);
				lsTitle.add(title);
			}
			con.close();
			return lsTitle;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Don't take data from table Title!");
			return null;
		}

	}

	public ArrayList<TieuDe> loadData(String text) {
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from TieuDe where ten like '%" + text + "%'";
//			String sql = "Select * from Title where Ten like '%" + text+"% or Ten like '" + text+"% or Ten like '%"+ text+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String idTitle = rs.getString(1);
				String name = rs.getString(2);
				String noiDung = rs.getString(3);
				int replica = rs.getInt(4);
				int rented = rs.getInt(5);
				float price = rs.getFloat(6);
				title = new TieuDe(idTitle, name, noiDung, replica, rented, price);
				lsTitle.add(title);
			}
			con.close();
			return lsTitle;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Don't take data from table Title!");
			return null;
		}

	}
	
	public boolean CapNhatTieuDeDaThue(String ma) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {
			Statement statement = con.createStatement();
			String sql = "Select * from TieuDe where IdTieuDe= '"+ma+"'";
			ResultSet ketqua = statement.executeQuery(sql);

			int daThue = 10;
			while(ketqua.next()) {
				daThue = ketqua.getInt(5);
				stmt = con.prepareStatement("UPDATE TieuDe SET DaThue = ? where IdTieuDe=?");
				stmt.setInt(1, daThue+1);
				stmt.setString(2, ma);
				n = stmt.executeUpdate();
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

		}
		return n > 0;
	}

	public boolean CapNhatTieuDeDaTra(String ma) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {
			Statement statement = con.createStatement();
			String sql = "Select * from TieuDe where IdTieuDe= '"+ma+"'";
			ResultSet ketqua = statement.executeQuery(sql);

			int daThue = 10;
			while(ketqua.next()) {
				daThue = ketqua.getInt(5);
				if(daThue>0)
					daThue--;
//				System.out.println(daThue);
				stmt = con.prepareStatement("UPDATE TieuDe SET DaThue = ? where IdTieuDe=?");
				stmt.setInt(1, daThue);
				stmt.setString(2, ma);
				n = stmt.executeUpdate();
			} 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

		}

//		System.out.println("TieuDe ok"+n);
		return n > 0;
	}

	public ArrayList<TieuDe> loadDataTra() {
		lsTitle.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from TieuDe where DaThue != 0 and BangSao !=0";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String idTitle = rs.getString(1);
				String name = rs.getString(2);
				String noiDung = rs.getString(3);
				int replica = rs.getInt(4);
				int rented = rs.getInt(5);
				float price = rs.getFloat(6);
				title = new TieuDe(idTitle, name, noiDung, replica, rented, price);
				lsTitle.add(title);
			}
			con.close();
			return lsTitle;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Don't take data from table Title!");
			return null;
		}

	}

	public ArrayList<TieuDe> loadDataTra(String text) {
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from TieuDe where DaThue != 0 and BangSao !=0 and ten like '%" + text + "%'";
//			String sql = "Select * from Title where Ten like '%" + text+"% or Ten like '" + text+"% or Ten like '%"+ text+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String idTitle = rs.getString(1);
				String name = rs.getString(2);
				String noiDung = rs.getString(3);
				int replica = rs.getInt(4);
				int rented = rs.getInt(5);
				float price = rs.getFloat(6);
				title = new TieuDe(idTitle, name, noiDung, replica, rented, price);
				lsTitle.add(title);
			}
			con.close();
			return lsTitle;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Don't take data from table Title!");
			return null;
		}

	}
	
	public DsTieuDe() {
		// TODO Auto-generated constructor stub
	}

}
