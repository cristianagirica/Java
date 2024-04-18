package Test1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		
		//Cerinta 2
		ArrayList<Vehicle> vehicles = Vehicle.deserialize();
		
		int count = 0;
		int passengers = 0;
		for(Vehicle car:vehicles) {
			count += 1;
			passengers += car.getPassangers();
		}
		
		System.out.println("== Assignemnt 2 ==");
		System.out.println(count + " vehicles with " + passengers + " passengers");
		
		//Cerinta 3
		
        ArrayList<Vehicle> luxeVehicles = Vehicle.deserialize();
		
		int psg = 0;
		for(Vehicle car:luxeVehicles) {
			    if(car.isDeluxe()) {
			    psg += car.getPassangers();
			}
		}
		
		System.out.println(" ");
		System.out.println("== Assignemnt 3 ==");
		System.out.println("Luxe vehicles: " + psg + " passengers");
		System.out.println("Other vehicles: " + (passengers-psg) + " passengers");
		
		
		//Cerinta 4
		
		final double tax = 5;
		
		double cumulatedTax = 0;
		
		HashMap<String, Double> carsHashMap = new HashMap<>();
		
		
		
		for(Vehicle car : vehicles) {
			if(carsHashMap.containsKey(car.getCounty())){
				if(car.isDeluxe()) {
					cumulatedTax = carsHashMap.get(car.getCounty()) + (tax+tax*20/100);
					carsHashMap.put(car.getCounty(), cumulatedTax);
				} else {
					cumulatedTax = carsHashMap.get(car.getCounty()) + tax;
					carsHashMap.put(car.getCounty(), cumulatedTax);
				} 
				    
				} else {
					if(car.isDeluxe()) {
						carsHashMap.put(car.getCounty(), tax + tax*20/100);
					} else {
						carsHashMap.put(car.getCounty(), tax);
					}
					
			}
		}
		
		
		String[] list = new String[carsHashMap.size()];
		int i = 0;
		for(String a : carsHashMap.keySet()) {
			list[i] = a + "," + carsHashMap.get(a);
			System.out.println(list[i]);
			i++;
		}
		
			
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream("raportParcare.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter writer = new BufferedWriter(osw);
			
			for(String s : list) {
				writer.write(s);
				writer.write(System.lineSeparator());
			}
			
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		

	}

}
