

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hashmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<Integer,String>a=new HashMap<Integer,String>();
		a.put(1,"aa");
		a.put(2,"bb");
		a.put(3,"cc");
		Set set=a.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext())
		{
			Map.Entry m=(Map.Entry)itr.next();
			System.out.println("key is"+m.getKey()+" "+"value is"+m.getValue());
		}
		
	}

}
