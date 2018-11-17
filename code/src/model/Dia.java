package model;

public class Dia {
	String maDia;
	String maTieuDe;
	int tinhTrang;
	public Dia(String maDia, String maTieuDe, int tinhTrang) {
		super();
		this.maDia = maDia;
		this.maTieuDe = maTieuDe;
		this.tinhTrang = tinhTrang;
	}
	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDia() {
		return maDia;
	}
	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}
	public String getMaTieuDe() {
		return maTieuDe;
	}
	public void setMaTieuDe(String maTieuDe) {
		this.maTieuDe = maTieuDe;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
