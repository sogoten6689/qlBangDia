package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.PhieuDat;

public class DsPhieuDat {
	ArrayList<PhieuDat> dsPhieuDat = new ArrayList<PhieuDat>();
	PhieuDat PhieuDat;

	public ArrayList<PhieuDat> taiPhieuDat() {
		dsPhieuDat.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from PhieuDat";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuDat = rs.getString(1);
				String maTieuDe = rs.getString(2);
				String maKH = rs.getString(3);
				int soNgay = rs.getInt(4);
				int trangThai = rs.getInt(5);
				float gia = rs.getFloat(6);
				PhieuDat phieuMoi = new PhieuDat(maPhieuDat,maTieuDe,maKH,soNgay,trangThai,gia);
				dsPhieuDat.add(phieuMoi);

			}
			return dsPhieuDat;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean taoPhieuDat(PhieuDat PhieuDatThem) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into PhieuDat values (?,?,?,?,?,?)");
			stmt.setString(1, PhieuDatThem.getMaPhieuDat());
			stmt.setString(2, PhieuDatThem.getMaTieuDe());
			stmt.setString(3, PhieuDatThem.getMaKH());
			stmt.setInt(4, PhieuDatThem.getSoNgayThue());
			stmt.setInt(5, PhieuDatThem.getTrangThai());
			stmt.setFloat(6, PhieuDatThem.getGia());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e+"DSAFASDf");
		} finally {

		}
		System.out.println("loi tao phieu tre "+ n);
		return n > 0;
	}

	public boolean CapNhatPhieuDatXong(String ma) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {

				stmt = con.prepareStatement("UPDATE PhieuDat SET trangThai = 1 where maPhieuDat=?");
		
				stmt.setString(1, ma);
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
