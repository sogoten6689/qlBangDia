package model;

import java.sql.Date;

public class PhieuThue {
	String maPhieuThue;
	String maKh;
	Date ngayThue;
	float tongTien;
	public PhieuThue(String maPhieuThue, String maKh, Date ngayThue, float tongTien) {
		super();
		this.maPhieuThue = maPhieuThue;
		this.maKh = maKh;
		this.ngayThue = ngayThue;
		this.tongTien = tongTien;
	}
	public PhieuThue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPhieuThue() {
		return maPhieuThue;
	}
	public void setMaPhieuThue(String maPhieuThue) {
		this.maPhieuThue = maPhieuThue;
	}
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
