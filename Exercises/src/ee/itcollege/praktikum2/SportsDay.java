package ee.itcollege.praktikum2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SportsDay {
	
	private static final String FILENAME = "athletes.dat";
	
	public static SortableList<Athlete> readList() {
		SortableList<Athlete> list;
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
			list = (SortableList<Athlete>) reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			list = new SortableList<Athlete>();
		}
		return list;
	}
	
	private static void saveList(SortableList<Athlete> list) {
		try {
			ObjectOutputStream saver = new ObjectOutputStream(
					new FileOutputStream(new File(FILENAME)));
			saver.writeObject(list);
			saver.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		
		SortableList<Athlete> list = readList();
		
		for (Athlete athlete : list) {
			System.out.println(athlete);
		}
		
		System.out.println("Insert name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Insert result");
		double result = scanner.nextDouble();
		scanner.close();
		
		list.add(new Athlete(name,  result));
		list.sort();
		saveList(list);
		
	}
}
