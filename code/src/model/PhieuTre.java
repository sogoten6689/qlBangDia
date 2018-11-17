package model;

public class PhieuTre {
	String maTre;
	String maKH;
	String Dia;
	float tienTre;
	public PhieuTre(String maTre, String maKH, String dia, float tienTre) {
		super();
		this.maTre = maTre;
		this.maKH = maKH;
		this.Dia = dia;
		this.tienTre = tienTre;
	}
	public PhieuTre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaTre() {
		return maTre;
	}
	public void setMaTre(String maTre) {
		this.maTre = maTre;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getDia() {
		return Dia;
	}
	public void setDia(String dia) {
		Dia = dia;
	}
	public float getTienTre() {
		return tienTre;
	}
	public void setTienTre(float tienTre) {
		this.tienTre = tienTre;
	}
	

}
