import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class BestSellingFruits {
	
	public static void main(String[] args) {
		insert();
		System.out.println(sortByValues(fruits));
		addFruits("Orange");
		System.out.println(sortByValues(fruits));
		addFruits("Mango");
		System.out.println(sortByValues(fruits));
		addFruits("Pear");
		System.out.println(sortByValues(fruits));
	}

	static Map<String, Integer> fruits = new TreeMap<>(Collections.reverseOrder());
	
	public static void addFruits(String f) {
		if(!fruits.containsKey(f)) {
			fruits.put(f,1);
		}
		else {
			int num = fruits.get(f);
			num++;
			fruits.put(f,num);
		}
	}
	
	public static void insert() {
		fruits.put("Mango",5);
		fruits.put("Apple",2);
		fruits.put("Orange",6);
	}
	
	public static <K, V extends Comparable<V>> Map<K, V> 
    sortByValues(final Map<K, V> map) {
    
	Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k2).compareTo(map.get(k1));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
      };
      Map<K, V> sortedByValues = 
    	      new TreeMap<K, V>(valueComparator);
    	    sortedByValues.putAll(map);
    	    return sortedByValues;
    	  }
}
