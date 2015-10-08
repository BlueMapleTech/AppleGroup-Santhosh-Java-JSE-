

import java.util.HashSet;

public class Hashset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet<String>h=new HashSet<String>();
		h.add("aa");
		//h.add("dd");
		h.add("bb");
		h.add("cc");
		//h.add("aa");
		
		h.add("null");
		System.out.println("hash set are"+h);
		HashSet<Integer>b=new HashSet<Integer>();
		b.add(3);
		b.add(4);
		System.out.println(b);

	}

}
