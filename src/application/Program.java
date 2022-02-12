package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String arrg[]) {
		

		String path = "c:\\Temp\\Orders.csv";

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer quantity = Integer.parseInt(vect[2]);
				
				Product product = new Product(name, price, quantity);
				list.add(product);
				
				line = br.readLine();
			}
			
			for(Product p : list) {
				System.out.println(p);
				
			}
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		String pathOut = "c:\\Temp\\Out.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))){
			
			for(Product p : list) {
				
				Double total = p.getPrice() * p.getQuantity();
				
				bw.write(p.getName() + "," + total);
				bw.newLine();
				
			}
						
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			
		}
		
		

	}

}