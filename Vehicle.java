package Test1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Vehicle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String iD;
	private String brand;
	private int passangers;
	
	public Vehicle(String iD, String brand, int passangers) {
		super();
		this.iD = iD;
		this.brand = brand;
		this.passangers = passangers;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPassangers() {
		return passangers;
	}

	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}
	
	
	public static List<String> deluxeBrands;
	
	static {
		deluxeBrands = new ArrayList<>();
		deluxeBrands.add("Mercedes");
		deluxeBrands.add("Audi");
		deluxeBrands.add("Bmw");
	}
	
	public boolean isDeluxe() {
		if (deluxeBrands.contains(this.getBrand())) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static ArrayList<Vehicle> deserialize() {
		try {
			FileInputStream fis = new FileInputStream("parcare.txt");
			InputStreamReader osr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(osr);
			
			ArrayList<Vehicle> vehicles = new ArrayList<>();
			String line = "";
			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String ID = parts[0];
				String brand = parts[1];
				int passengers = Integer.parseInt(parts[2]);
				vehicles.add(new Vehicle(ID, brand, passengers));
			}
			reader.close();
			return vehicles;
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public String getCounty() {
		String iD = this.getiD();
		String[] parts = iD.split("-");
		String county = parts[0];
		return county;
	}

}
