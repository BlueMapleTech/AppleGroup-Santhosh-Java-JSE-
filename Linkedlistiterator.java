

import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
public class Linkedlistiterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	LinkedList<String>l=new LinkedList<String>();
	l.add("aaaa");
	l.add("bbb");
	l.add("ccc");
	Iterator<String>itr1=l.iterator();
	while(itr1.hasNext())
	{
	System.out.println(itr1.next());	
	
	}
	ListIterator<String> itr=l.listIterator();
	while(itr.hasNext())
	{
	System.out.println(itr.next());
	}
	while(itr.hasPrevious())
	{
	System.out.println(itr.previous());
	}
	}

}
