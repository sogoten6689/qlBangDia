package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.KhachHang;
import model.PhieuThue;


public class DsKhachHang {
	ArrayList<KhachHang> arrayList = new ArrayList<KhachHang>();
	KhachHang khachHang;
	
	public ArrayList<KhachHang> taiDsKhachHang(){

		arrayList.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String maKH = rs.getString(1);
				String diaChi = rs.getString(2);
				String tenKH = rs.getString(3);
				String soDT = rs.getString(4);
				khachHang= new KhachHang(maKH,diaChi,tenKH,soDT);
				arrayList.add(khachHang);
			}
			 con.close();
			return arrayList;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("LOIIII! - Khong Lay dc danh sach khach hang!");
			return null;
		}
		
	}

	public boolean taoKhachHang(KhachHang kHang) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into KhachHang values (?,?,?,?)");
			stmt.setString(2, kHang.getdiaChi());
			stmt.setString(1, kHang.getMaKh());
			stmt.setString(3, kHang.gettenKH());
			stmt.setString(4, kHang.getsoDT());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}

		return n > 0;
	}

	public boolean CapNhatKH(String ma,String ten, String diaChi) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {
		
				stmt = con.prepareStatement("UPDATE KhachHang SET tenKH = ?, diaChi = ? where maKH=?");
				stmt.setString(1, ten);
				stmt.setString(2, diaChi);
				stmt.setString(3, ma);
				n = stmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

		}
		return n > 0;
	}

}
