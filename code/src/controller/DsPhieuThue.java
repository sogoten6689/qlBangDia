package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.PhieuThue;

public class DsPhieuThue {
	ArrayList<PhieuThue> dsPhieuThue = new ArrayList<PhieuThue>();
	PhieuThue phieuThue;

	public ArrayList<PhieuThue> taiPhieuThue() {
		dsPhieuThue.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from PhieuThue";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuThue = rs.getString(1);
				String maKH = rs.getString(2);
				Date ngayThue = rs.getDate(3);
				float tongTien = rs.getFloat(4);
				PhieuThue phieuMoi = new PhieuThue( maPhieuThue, maKH, ngayThue, tongTien);
				dsPhieuThue.add(phieuMoi);

			}
			return dsPhieuThue;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean taoPhieuThue(String maPhieuThue, String maKh, Date ngayThue, float tongTien) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into PhieuThue values (?,?,?,?)");
			stmt.setString(1, maPhieuThue);
			stmt.setString(2, maKh);
			stmt.setDate(3, ngayThue);
			stmt.setFloat(4, tongTien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}

		return n > 0;
	}
	public boolean taoPhieuThue(PhieuThue phieuThueThem) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into PhieuThue values (?,?,?,?)");
			stmt.setString(1, phieuThueThem.getMaPhieuThue());
			stmt.setString(2, phieuThueThem.getMaKh());
			stmt.setDate(3, phieuThueThem.getNgayThue());
			stmt.setFloat(4, phieuThueThem.getTongTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}

		return n > 0;
	}
}
