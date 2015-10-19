package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Signup {

	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/checking1", "root", "admin");
		Statement stmt = (Statement) con.createStatement();
		//Statement stmt = con.createStatement();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		// Scanner keyboard = new Scanner(System.in);


		do {
			System.out.println("1.SIGNUP:");
			System.out.println("2.SIGN IN:");
			System.out.println("3.LISTUSER:");
			System.out.println("4.EXIT:");
			System.out.println("Enter the value:");
			int i = Integer.parseInt(br.readLine());

			switch (i) {
			case 1: {
				do {
					System.out.println("Enter your  Name");
					String userName = br.readLine();

					System.out.println("Enter your passWord");
					String passWord = br.readLine();

					System.out.println("Enter your email ");
					String email = br.readLine();

					System.out.println("sex");
					String sex = br.readLine();

					System.out.println("Enter your phoneNo ");
					String phoneNo = br.readLine();

					System.out.println("------------------------");
					System.out.println("Your Details are following.");

					System.out.println("Name :" + " " + userName);
					System.out.println("Phone :" + " " + passWord);
					System.out.println("Email :" + " " + email);
					System.out.println("City :" + " " + sex);
					System.out.println("phoneNo :" + " " + phoneNo);

					stmt.executeUpdate("insert into empdetails1(userName,passWord,email,sex,phoneNo) values('"
							+ userName
							+ "','"
							+ passWord
							+ "','"
							+ email
							+ "','" + sex + "','" + phoneNo + "')");
					System.out.println("do you continue:y/n");
					String s = br.readLine();
					if (s.startsWith("n")) {
						break;
					}
				} while (true);

				break;
			}

			case 2: {
				
				System.out.println("Enter your  Name");
				String name = br.readLine();

				System.out.println("Enter your passWord");
				String pass = br.readLine();
				int a=1;
				
				//for(int x=0;x<1;x++)
				//{
				
				String sql = "SELECT  * from empdetails1 ";
				ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {

					String User1 = rs.getString("userName");
					String Pass1 = rs.getString("passWord");
					
					
										
					
					
					
					
					if ((User1.equals(name)) && (Pass1.equals(pass))) {
						System.out.println("sucess");
						a=a+1;
				                 if(a==2)
				                 {
						do {
							System.out.println("1.UPDATE:");
							System.out.println("2.DELETE:");
							System.out.println("3.LOGOUT:");
							int i2 = Integer.parseInt(br.readLine());
							switch (i2) {
							case 1: {
							
								System.out.println("enter the changing userId");
								int f = Integer.parseInt(br.readLine());
								System.out.println("enter the userId");
								int u = Integer.parseInt(br.readLine());
								System.out.println("enter the user userName");
								String n = br.readLine();
								System.out.println("enter the user password");
								String p = br.readLine();
								System.out.println("enter the user email");
								String e = br.readLine();
								System.out.println("enter the user sex");
								String s = br.readLine();
								System.out.println("enter the user phoneNo");
								String t = br.readLine();

								String query = "UPDATE empdetails1 SET userid='"
										+ u
										+ "',userName='"
										+ n
										+ "',passWord='"
										+ p
										+ "',email='"
										+ e
										+ "',sex='"
										+ s
										+ "',phoneNo='"
										+ t
										+ "' where userId=" + f;
								Statement stmt2 = (Statement) con
										.createStatement();
								int rs1 = stmt2.executeUpdate(query);
								
								
							
							}

								break;
							
							case 2: {
								
								System.out.println("which row can be deleted");
								int d = Integer.parseInt(br.readLine());
								String query = "delete from checking1.empdetails1 where userId="
										+ d;
								stmt.executeUpdate(query);
								
								
							
							}
								break;
							
							case 3: {
								System.out.println("logout sucess");
								break;
							}
							}
							System.out.println("do you continue:y/n");
							String s2 = br.readLine();
							if (s2.startsWith("n")) {
								break;
							}
						}

						while (true);
				                 }
					} else {
						//System.out.println("not sucess");
					}
					}
				
					if(a==1)
					{
						System.out.println("not sucess");
					}

					
					
					
					
					
					
					
					//
					
								
				
				break;
			}
			case 3: {
				System.out.println("user List");
				String sql = "select * from empdetails1";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int userId = rs.getInt("userId");
					String userName = rs.getString("userName");
					String passWord = rs.getString("password");
					String email = rs.getString("email");
					String sex = rs.getString("sex");
					String phoneNo = rs.getString("phoneNo");
					System.out.println(" " + userId + " " + userName + " "
							+ passWord + " " + email + " " + sex + " "
							+ phoneNo);

				}

				break;
			}

			case 4: {

				System.out.println("logout");

				break;
			}
			}

			System.out.println("do you continue:y/n");
			String s1 = br.readLine();

			if (s1.startsWith("n")) {
				break;
			}
			
		} while (true);

		con.close();
	}
}
