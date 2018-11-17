package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.connectiongDB;
import model.ChiTietPhieuThue;

public class DsCtPhieuThue {
	ArrayList<ChiTietPhieuThue> dsCtPhieuThue = new ArrayList<ChiTietPhieuThue>();
	ChiTietPhieuThue chiTietPhieuThue;

	public ArrayList<ChiTietPhieuThue> taiDsCTPhieuThue() {
		dsCtPhieuThue.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from ChiTietPhieuThue";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				String maCT = rs.getString(1);
				String maPhieuThue = rs.getString(2);
				String maKH = rs.getString(3);
				Date ngayThue = rs.getDate(4);
				Date ngayTra = rs.getDate(5);
				int soNgayThue = rs.getInt(6);
				float gia = rs.getFloat(7);
				String maDia = rs.getString(8);
				int tinhTrang = rs.getInt(9);
				
				chiTietPhieuThue = new ChiTietPhieuThue(maCT, maPhieuThue, maKH, ngayThue,
						ngayTra, soNgayThue, gia,maDia, tinhTrang);
				dsCtPhieuThue.add(chiTietPhieuThue);
			}
			con.close();
			return dsCtPhieuThue;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Khong the lay danh sach chi tieu phieu thue");
			return null;
		}
	}

	public ArrayList<ChiTietPhieuThue> taiDsCTPhieuThueTra() {
		dsCtPhieuThue.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from ChiTietPhieuThue";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				int tinhTrang = rs.getInt(9);
				if(tinhTrang==0) {
					String maCT = rs.getString(1);
					String maPhieuThue = rs.getString(2);
					String maKH = rs.getString(3);
					Date ngayThue = rs.getDate(4);
//					Date ngayTra = rs.getDate(5);
					int soNgayThue = rs.getInt(6);
					float gia = rs.getFloat(7);
					String maDia = rs.getString(8);
					
					chiTietPhieuThue = new ChiTietPhieuThue(maCT, maPhieuThue, maKH, ngayThue,
							new Date(System.currentTimeMillis()), soNgayThue, gia,maDia, tinhTrang);
					dsCtPhieuThue.add(chiTietPhieuThue);
				
				}
			}
			con.close();
			return dsCtPhieuThue;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Khong the lay danh sach chi tieu phieu thue");
			return null;
		}
	}

	public ArrayList<ChiTietPhieuThue> taiDsCTPhieuThueTra(String sdt) {
		dsCtPhieuThue.clear();
		try {
			Connection con = connectiongDB.getConnection();
			String sql = "Select * from ChiTietPhieuThue where makh = '"+sdt+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				// take data from table Title
				int tinhTrang = rs.getInt(9);
				if(tinhTrang==0) {
					String maCT = rs.getString(1);
					String maPhieuThue = rs.getString(2);
					String maKH = rs.getString(3);
					Date ngayThue = rs.getDate(4);
//					Date ngayTra = rs.getDate(5);
					int soNgayThue = rs.getInt(6);
					float gia = rs.getFloat(7);
					String maDia = rs.getString(8);
					
					chiTietPhieuThue = new ChiTietPhieuThue(maCT, maPhieuThue, maKH, ngayThue,
							new Date(System.currentTimeMillis()), soNgayThue, gia,maDia, tinhTrang);
					dsCtPhieuThue.add(chiTietPhieuThue);
				
				}
			}
			con.close();
			return dsCtPhieuThue;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Khong the lay danh sach chi tieu phieu thue");
			return null;
		}
	}

	public boolean taoChiTietPhieuThue(ArrayList<ChiTietPhieuThue> dsThemCTPT) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		for(ChiTietPhieuThue chiTietPhieuThueThem : dsThemCTPT) {
			try {
				stmt = con.prepareStatement("Insert into ChiTietPhieuThue values (?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, chiTietPhieuThueThem.getMaCT());
				stmt.setString(2, chiTietPhieuThueThem.getMaPhieuThue());
				stmt.setString(3, chiTietPhieuThueThem.getMaKH());
				stmt.setDate(4, chiTietPhieuThueThem.getNgayThue());
				stmt.setDate(5, null);
				stmt.setInt(6, chiTietPhieuThueThem.getSoNgayThue());
				stmt.setFloat(7, chiTietPhieuThueThem.getGia());
				stmt.setString(8, chiTietPhieuThueThem.getMaDia());
				stmt.setInt(9, chiTietPhieuThueThem.getTrangThai());
				
				stmt.executeUpdate();
				n++;
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println(e);
			} finally {

			}
		}
		if(n!=dsThemCTPT.size()) {
			System.out.println("Co ve them danh sach KHONG DU!");
		}
		return n > 0;
	}
	
	public boolean taoChiTietPhieuThue(ChiTietPhieuThue chiTietPhieuThueThem) {

		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
			try {
				stmt = con.prepareStatement("Insert into ChiTietPhieuThue values (?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, chiTietPhieuThueThem.getMaCT());
				stmt.setString(2, chiTietPhieuThueThem.getMaPhieuThue());
				stmt.setString(3, chiTietPhieuThueThem.getMaKH());
				stmt.setDate(4, chiTietPhieuThueThem.getNgayThue());
				stmt.setDate(5, null);
				stmt.setInt(6, chiTietPhieuThueThem.getSoNgayThue());
				stmt.setFloat(7, chiTietPhieuThueThem.getGia());
				stmt.setString(8, chiTietPhieuThueThem.getMaDia());
				stmt.setInt(9, chiTietPhieuThueThem.getTrangThai());
				
				stmt.executeUpdate();
				n++;
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println(e);
			} finally {

			}
		
	
		return n > 0;
	}

	public boolean TraDia(String ma) {


		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {
		
			stmt = con.prepareStatement("UPDATE ChiTietPhieuThue SET tinhTrang = 1 where maCTPhieuThue=?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

		}

//		System.out.println("ChiTietPhieuThue ok"+n);
		return n > 0;
	}

	
	//	TraNoDia
	public boolean TraNoDia(String ma) {


		Connection con = connectiongDB.getConnection();
		PreparedStatement stmt = null;

		int n=-1;
		try {
		
			stmt = con.prepareStatement("UPDATE ChiTietPhieuThue SET soNgayThue = 1 , ngayThue=? where maCTPhieuThue=?");
			stmt.setString(2, ma);
			stmt.setDate(1, new Date(System.currentTimeMillis()));
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {

		}
//		System.out.println("loi"+n);
		return n > 0;
	}

	public DsCtPhieuThue() {
		// TODO Auto-generated constructor stub
	}

//	public boolean TraDia(String mactpt) {
//		// TODO Auto-generated method stub
//		return false;
//	};

}
