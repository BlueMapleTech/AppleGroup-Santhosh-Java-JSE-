class Test
    {
         public static void main(String args[])throws Exception
             {
                 int c=0;
	Scanner s=new Scanner(System.in);
	String str=s.nextLine();
	System.out.println("enter string is"+" "+str);
	char ch[]=new char[str.length()];
	for(int i=0;i<str.length();i++)
	      {
	          ch[i]=str.charAt(i);
	           c++;
	      }
	          System.out.println("the word count is"+" "+c);
	          int a=c;
                             
                           for(int j=0;j<a;j++)
                              {
                                  int f=c;
                                 //  a=a-1;
                                  while(c>0)
                                     {
                                         System.out.print(" ");
                                          c--;
                                          
                                      }
                                          f=f-1;
                                          c=f;
                                          for(int l=0;l<=j;l++)
                                             {
			ch[l]=str.charAt(l);
			System.out.print(" "+ch[l]);
		            }
			System.out.println("");
                                                     
	       }

		int t=0;
		int k=str.length()-1;
		int p=k+k;
		int g=k;
		for(int x=k;x<p;x++)
		    {
			t=t+1;
			for(int y=0;y<=t;y++)
		                     {
				System.out.print(" ");
			     }
				for(int z=0;z<g;z++)
					{
						ch[z]=str.charAt(z);
						System.out.print(" "+ch[z]);
					}
						g=g-2;
						System.out.println("");
		     }
               }
}