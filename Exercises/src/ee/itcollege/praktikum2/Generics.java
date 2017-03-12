package ee.itcollege.praktikum2;

public class Generics {
	
	public static void main(String[] args) {
		
		SortableList<Athlete> list = new SortableList<Athlete>();
		list.add(new Athlete("Mati", 12.));
		list.add(new Athlete("Kati", 1.5));
		list.add(new Athlete("Tom", 122.));
		
		list.sort();
		
		for (Athlete athlete : list) {
			System.out.println(athlete);
		}
		
		// to stream
		list.stream()
			.filter(t -> t.getResult() > 10)
			.map(a -> a.getName())
			.forEach(Generics::handle);
	}
	
	private static void handle(String a) {
		// TODO Auto-generated method stub
		System.out.println(a);
	}
	
}
