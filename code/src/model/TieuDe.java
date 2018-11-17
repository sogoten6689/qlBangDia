package model;

public class TieuDe {
	String IdTitle;
	String Name;
	String NoiDung;
	int Replica;
	int Rented;
	float Price;
	
	

	public String getIdTitle() {
		return IdTitle;
	}



	public void setIdTitle(String idTitle) {
		IdTitle = idTitle;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getNoiDung() {
		return NoiDung;
	}



	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}



	public int getReplica() {
		return Replica;
	}



	public void setReplica(int replica) {
		Replica = replica;
	}



	public int getRented() {
		return Rented;
	}



	public void setRented(int rented) {
		Rented = rented;
	}



	public float getPrice() {
		return Price;
	}



	public void setPrice(float price) {
		Price = price;
	}



	public TieuDe(String idTitle, String name, String noiDung, int replica, int rented, float price) {
		super();
		IdTitle = idTitle;
		Name = name;
		NoiDung = noiDung;
		Replica = replica;
		Rented = rented;
		Price = price;
	}



	public TieuDe() {
		// TODO Auto-generated constructor stub
	}

}
