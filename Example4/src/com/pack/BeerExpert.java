package com.pack;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
public List<String> getBrands(String color)
{
	List<String> brands=new ArrayList<String>();
	if(color.equals("amber"))
	{
		brands.add("xx");
		//brands.add("yy");
	}
	if(color.equals("light"))
	{
		brands.add("aa");
		//brands.add("bb");
	}
	if(color.equals("brown"))
	{
		brands.add("cc");
		//brands.add("dd");
	}
	if(color.equals("dark"))
	{
		brands.add("ee");
		//brands.add("ff");
	}
	return (brands);
	
	
	 	
}
}
