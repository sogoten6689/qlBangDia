package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.Dia;

public class DsDia {
	ArrayList<Dia> arrayList = new ArrayList<Dia>();
	Dia Dia;

	public ArrayList<Dia> taiDsDia() {
		arrayList.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from Dia";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String maDia = rs.getString(1);
				String maTieuDe = rs.getString(2);
				int tinhTrang = rs.getInt(3);
				Dia = new Dia(maDia, maTieuDe, tinhTrang);
				arrayList.add(Dia);
			}
			con.close();
			return arrayList;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("LOIIII! - Khong Lay dc danh sach dia!");
			return null;
		}

	}

	public ArrayList<Dia> taiDsDiaRanh() {
		arrayList.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from Dia ";
//			where maTieuDe = '"+maTieuDe+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String maTieuDe = rs.getString(2);
				int tinhTrang = rs.getInt(3);
				if(tinhTrang!=0) {
					String maDia = rs.getString(1);
					Dia = new Dia(maDia, maTieuDe, tinhTrang);
					arrayList.add(Dia);
				}
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

	
	public boolean CapNhatDiaDaThue(String ma,int daThue) {
		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n=-1;
		try {
			stmt = con.prepareStatement("UPDATE Dia SET tinhTrang = ? where maDia=?");
			stmt.setInt(1, daThue);
			stmt.setString(2, ma);
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
