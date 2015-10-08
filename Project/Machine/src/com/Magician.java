package com;

import java.io.BufferedReader;

public class Magician {
	
		public static void main(String args[])throws Exception
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the test case");
		int u=Integer.parseInt(br.readLine());
		for(int z=1;z<=u;z++)
		{
		int N = 4;
		String y = ",";
		String s = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16";
		String[] c = s.split(y);
		int[][] m = new int[4][4];
		int l = 0;
		for (int i = 0; i < N; i++)
		{
		    for (int j = 0; j < N; j++,l++)
		{ 
		 m[i][j] = Integer.valueOf(c[l]);
		System.out.print("  "+m[i][j]);
		 }
		System.out.println();
		}
		System.out.println("enter the row ");
		int a=Integer.parseInt(br.readLine());
				 int N1=4;
		int l1=0;
		String s1="1,6,5,12,2,7,10,13,3,8,15,14,4,9,11,16";
		String[] d=s1.split(y);
		int[][] m1=new int[4][4];
		System.out.println(" ");
		for (int i = 0; i < N1; i++)
		{
		    for (int j = 0; j < N1; j++,l1++)
		{ 

		 m1[i][j] = Integer.valueOf(d[l1]);
		System.out.print(" "+m1[i][j]);
		 }
		System.out.println();
		}
		System.out.println("enter the row");
		int b=Integer.parseInt(br.readLine());
		int x=0;
		int p=0;
		System.out.println("the result is");
		for(int i=0;i<N1;i++)
		{
		for(int j=0;j<N1;j++)
		{
		if(m[a][i]==m1[b][j])
		{
		x=x+1;

		p=i;
		}
		}
		}
		if(x==1)
		{
		System.out.println("realize the no is"+" "+m[a][p]);
		}
		else
		if(1<x)
		{
		System.out.println("Bad magician");
		}
		else
		if(x==0)
		{
		System.out.println("volunteer cheated");
		}
		}
		 }
		 }
}
