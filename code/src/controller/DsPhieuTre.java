package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.PhieuTre;

public class DsPhieuTre {
	ArrayList<PhieuTre> dsPhieuTre = new ArrayList<PhieuTre>();
	PhieuTre PhieuTre;

	public ArrayList<PhieuTre> taiPhieuTre() {
		dsPhieuTre.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from PhieuTre";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuTre = rs.getString(1);
				String maKH = rs.getString(2);
				String maDia = rs.getString(3);
				float tienTre = rs.getFloat(4);
				PhieuTre phieuMoi = new PhieuTre( maPhieuTre, maKH, maDia, tienTre);
				dsPhieuTre.add(phieuMoi);

			}
			return dsPhieuTre;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean taoPhieuTre(String maPhieuTre, String maKh, String maDia, float tienTre) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into PhieuTre values (?,?,?,?)");
			stmt.setString(1, maPhieuTre);
			stmt.setString(2, maKh);
			stmt.setString(3, maDia);
			stmt.setFloat(4, tienTre);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}

		return n > 0;
	}
	public boolean taoPhieuTre(PhieuTre PhieuTreThem) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into PhieuTre values (?,?,?,?)");
			stmt.setString(1, PhieuTreThem.getMaTre());
			stmt.setString(2, PhieuTreThem.getMaKH());
			stmt.setString(3, PhieuTreThem.getDia());
			stmt.setFloat(4, PhieuTreThem.getTienTre());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {

		}
//		System.out.println("loi tao phieu tre "+ n);
		return n > 0;
	}
}
