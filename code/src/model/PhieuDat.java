package model;

public class PhieuDat {
	String maPhieuDat;
	String maTieuDe;
	String maKH;
	int trangThai;
	int soNgayThue;
	float gia;
	public PhieuDat(String maPhieuDat, String maTieuDe, String maKH, int soNgayThue, int trangThai,float gia) {
		super();
		this.maPhieuDat = maPhieuDat;
		this.maTieuDe = maTieuDe;
		this.maKH = maKH;
		this.soNgayThue = soNgayThue;
		this.trangThai=trangThai;
		this.gia = gia;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public PhieuDat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPhieuDat() {
		return maPhieuDat;
	}
	public void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
	}
	public String getMaTieuDe() {
		return maTieuDe;
	}
	public void setMaTieuDe(String maTieuDe) {
		this.maTieuDe = maTieuDe;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
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
	

}
