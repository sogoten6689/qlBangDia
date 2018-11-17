package model;

public class KhachHang {
	String maKh;
	String diaChi;
	String tenKH;
	String soDT;
	public KhachHang(String maKh, String diaChi, String tenKH, String soDT) {
		super();
		this.maKh = maKh;
		this.diaChi = diaChi;
		this.tenKH = tenKH;
		this.soDT = soDT;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public String getdiaChi() {
		return diaChi;
	}
	public void setdiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String gettenKH() {
		return tenKH;
	}
	public void settenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getsoDT() {
		return soDT;
	}
	public void setsoDT(String soDT) {
		this.soDT = soDT;
	}
	

}
