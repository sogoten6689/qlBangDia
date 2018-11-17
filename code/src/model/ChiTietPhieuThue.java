package model;

import java.sql.Date;

public class ChiTietPhieuThue {
	String maCT;
	String maPhieuThue;
	String maKH;
	Date ngayThue;
	Date ngayTra;
	int soNgayThue;
	float gia;
	String maDia;
	int trangThai;
	public ChiTietPhieuThue(String maCT, String maPhieuThue, String maKH, Date ngayThue,Date ngayTra, int soNgayThue, float gia, String maDia,int trangThai) {
		super();
		this.maCT = maCT;
		this.maPhieuThue = maPhieuThue;
		this.maKH = maKH;
		this.ngayThue = ngayThue;
		this.ngayTra = ngayTra;
		this.soNgayThue = soNgayThue;
		this.gia = gia;
		this.maDia = maDia;
		this.trangThai = trangThai;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public ChiTietPhieuThue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaCT() {
		return maCT;
	}
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}
	public String getMaPhieuThue() {
		return maPhieuThue;
	}
	public void setMaPhieuThue(String maPhieuThue) {
		this.maPhieuThue = maPhieuThue;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public int getSoNgayThue() {
		return soNgayThue;
	}
	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getMaDia() {
		return maDia;
	}
	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}
	

}
