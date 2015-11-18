


import java.util.ArrayList;

public class Arraylist {
	public static void main(String args[])
	{
		ArrayList<String>obj=new ArrayList<String>();
		
	obj.add("santhosh");
	obj.add("sathiesh");
	obj.add("pandi");
	obj.add("santhosh");
	obj.add("dsds");
	obj.add("cdcsd");
	
	
	System.out.println("the array list are"+obj);
	obj.remove("pandi");
	obj.add(2,"aaa");
	
	System.out.println("modify array list"+obj);
	obj.set(1,"sdcsd" );
	System.out.println("array list are "+obj);
	String str=obj.get(2);
	System.out.println(str);
	int pos=obj.indexOf("ds");
	System.out.println(pos);
	int no=obj.size();
	System.out.println(no);
	boolean a=obj.contains("aa");
	System.out.println(a);
	//obj.clear();
	//System.out.println("the array list is empty"+obj);
	ArrayList<Integer>b=new ArrayList<Integer>();
	b.add(2);
	b.add(5);
	System.out.println(b);
	}

}
