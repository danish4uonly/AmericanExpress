import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 1A 3C 2B 40G 5A
 * 
*/
public class Solution_AirplanSeatAllocation {
	
	public static void main(String[] args) {
		System.out.println(solution(2, "1A 2F 1C"));
	}
	
	public static int solution(int N, String S) {
		
		 int result = 0;
		 
		 Map<Integer, List<List<Integer>>> allSeatMap = new HashMap<>();
		 String[] splitted = null;
		 if (S.trim().length() > 0) {
			 splitted = S.split(" ");
			 Arrays.sort(splitted);
		 }
		 for (int rowCount = 1; rowCount <= N; rowCount++) {
			 
			 List<List<Integer>> row = new ArrayList<>(3);
			 
			 List<Integer> c1 = new ArrayList<>(3);
			 c1.add(0);
			 c1.add(0);
			 c1.add(0);
			 
			 List<Integer> c2 = new ArrayList<>(4);
			 c2.add(0);
			 c2.add(0);
			 c2.add(0);
			 c2.add(0);
			
			 List<Integer> c3 = new ArrayList<>(3);
			 c3.add(0);
			 c3.add(0);
			 c3.add(0);
			
			 row.add(c1);
			 row.add(c2);
			 row.add(c3);
			
			 allSeatMap.put(rowCount, row);
			 if (S.trim().length() > 0) {
				 for (int j = 0; j < splitted.length; j++) {
					 String code = splitted[j];
			
					 String subC = code.substring(1);
			
					 int currRow = Integer.parseInt(code.substring(0, 1));
					 if (currRow == rowCount) {
						 
						 switch (subC) {
						 
							 case "A":
								 allSeatMap.get(rowCount).get(0).set(0, 1);
								 break;
							 case "B":
								 allSeatMap.get(rowCount).get(0).set(1, 1);
								 break;
							 case "C":
								 allSeatMap.get(rowCount).get(0).set(2, 1);
								 break;
							 case "D":
								 allSeatMap.get(rowCount).get(1).set(0, 1);
								 break;
							 case "E":
								 allSeatMap.get(rowCount).get(1).set(1, 1);
								 break;
							 case "F":
								 allSeatMap.get(rowCount).get(1).set(2, 1);
								 break;
							 case "G":
								 allSeatMap.get(rowCount).get(1).set(3, 1);
								 break;
							 case "H":
								 allSeatMap.get(rowCount).get(2).set(0, 1);
								 break;
							 case "J":
								 allSeatMap.get(rowCount).get(2).set(1, 1);
								 break;
							 case "K":
								 allSeatMap.get(rowCount).get(2).set(2, 1);
								 break;
						 }
					 }
				 }
			 }
		 }
		
		 for (int rowCount = 1; rowCount <= N; rowCount++) {
			 if (!allSeatMap.get(rowCount).get(0).contains(1)) {
				 /**System.out.println(rowCount + "C1");*/
				 result++;
			 }
			 
			 if (!allSeatMap.get(rowCount).get(1).contains(1)) {
				 /**System.out.println(rowCount + "C2");*/
				 result++;
			 } else if (allSeatMap.get(rowCount).get(1).get(1) == 0 && allSeatMap.get(rowCount).get(1).get(2) == 0) {
				 if (allSeatMap.get(rowCount).get(1).get(0) == 0 || allSeatMap.get(rowCount).get(1).get(3) == 0) {
					 /**System.out.println(rowCount + "c2");*/
					 result++;
				 }
			 }
		
			 if (!allSeatMap.get(rowCount).get(2).contains(1)) {
				 /**System.out.println(rowCount + "C3");*/
				 result++;
			 }
		}
		return result;
	}
}