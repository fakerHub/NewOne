package cws.newtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Map<Integer, String> map;
	static {
		map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");

	}
	public static void main(String[] args)  {

		int[] a = { 9 };
		System.out.println(stageOne(a));
	}

	public static List<String> stageOne(int[] inputs) {
		List<String> temp = new ArrayList<String>();
		if (inputs.length == 1) {
			temp = exchangeInput(inputs[0]);
		} else {
		   List<String> inputLoop = exchangeInput(inputs[0]);
           for(int i=1;i<inputs.length;i++) {
        	   inputLoop=combinate(inputLoop,exchangeInput(inputs[i]));
           }
           temp=inputLoop;
		}
		return temp;
	}
	
	private static List<String> exchangeInput(int i){
		List<String> temp = new ArrayList<String>();
		String abs = (String) map.get(i);
		temp = Arrays.asList(abs.split(""));
		return  temp;
	}
	
	private static List<String> combinate(List<String> region,List<String> next){
		List<String> temp = new ArrayList<String>();
		for(String item : region) {			
			for(String nextItem :next) {
				StringBuilder sb = new StringBuilder();
				sb.append(item).append(nextItem);
				temp.add(sb.toString());
			}
		}
		return temp;
	}
}
