package ee.itcollege.praktikum2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SortableList<T extends Comparable<T>> extends ArrayList<T> {

//	public static <T extends Comparable<? super T>> void sort(List<T> list);
	
	public void sort() {
		Collections.sort(this);
	}
	
}
