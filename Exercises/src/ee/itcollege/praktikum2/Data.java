package ee.itcollege.praktikum2;

public class Data<T extends Number> {

	T object;
	
	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	// kui tahad edastada klassi tüüpi
	public void doSmthg (Class<? extends T> clazz) {
		try {
			T newInst = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// tüübi definaarimine meetodi tagastusele ja parameetrile
	public <A extends String> A doSmthg2 (A str) {
		return str;
	}
	
}
