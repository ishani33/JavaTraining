import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RTO {
	
	public static void main(String[] args) {
		String[] input = new String[]{"KA-55-AB-4555", "KA-01-EF-4444", "KA-04-AB-9000", "KA-56-200", "KA-50-T-3111", "KA-02-AG-9243"};
		insert();
		List<String> ouput = sorted(Arrays.asList(input));
		System.out.println(ouput);
	}
	
	static Map<String, String> codes = new HashMap<>();

	public static void insert() {
		codes.put("KA-01","Koramangala");
		codes.put("KA-02","Rajajinagar");
		codes.put("KA-03","Indiranagar");
		codes.put("KA-04","Yeshwanthpur");
		codes.put("KA-05","Jayanagar");
		codes.put("Ka-50","Yelahanka");
		codes.put("KA-51","Electronics City");
		codes.put("KA-52","Nelamangala");
		codes.put("KA-53","K.R.Puram");
		codes.put("KA-54","Nagamangala");
		codes.put("KA-55","Mysore East");
		codes.put("KA-56","Basavakalyan");
		codes.put("KA-57","Shantinagar");
	}
	
	public static List<String> sorted(List<String> regNo) {
		List<String> areas=new ArrayList<>();
		List<String> tmp=new ArrayList<>();
		for(String s: regNo) {
			tmp.add(s.substring(0,5));
		}
		for(String s: tmp) {
			if(codes.containsKey(s)) {
				areas.add(codes.get(s));
			}
		}
		Collections.sort(areas);
		return areas;
		
	}

	
}
