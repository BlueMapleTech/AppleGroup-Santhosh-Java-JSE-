package com.bluemapletech.app.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.ArrayList;

import com.bluemapletech.app.model.UserModel;
import com.bluemapletech.app.service.UserService;

public class UserController {

	public static void main(String args[]) throws Exception {
		UserService us = new UserService();
		UserModel um = new UserModel();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		do {
			System.out.println("Menu");

			System.out.println("              1.login");
			System.out.println("              2.signup");
			System.out.println("              3.listofuser");
			System.out.println("              4.logout");
			System.out.println("choose the menu which u want");
			int a = Integer.parseInt(br.readLine());

			switch (a) {

			case 1:

			{

				System.out.println("enter username and password for login");
				System.out.println("enter your username");
				String uname = br.readLine();
				System.out.println("enter your password");
				String upass = br.readLine();
				um.setUserName(uname);
				us.login1(um);
				int a2 = 1;
				if (uname.equals(um.getUserName())
						&& upass.equals(um.getPassword())) {
					a2 = a2 + 1;
					System.out.println("log sucess");
					do {
						System.out.println("MENU");
						System.out.println("         1.Update");
						System.out.println("         2.Delete");
						System.out.println("         3.exit");
						System.out.println("enter your choice");
						int a1 = Integer.parseInt(br.readLine());
						switch (a1) {
						case 1: {

							System.out.println("update your detail");
							String username = uname;
							System.out.println("enter your id");
							int id = Integer.parseInt(br.readLine());

							System.out.println("Enter your passWord");
							String password = br.readLine();

							System.out.println("Enter your email ");
							String email = br.readLine();

							System.out.println("sex");
							String sex = br.readLine();

							System.out.println("Enter your phoneNo ");
							String phoneno = br.readLine();
							um.setId(id);
							um.setUserName(username);
							um.setPassword(password);
							um.setEmail(email);
							um.setSex(sex);
							um.setContactNo(phoneno);
							us.update(um);

						}
							break;
						case 2: {
							String username = uname;
							um.setUserName(username);
							us.delete(um);
						}
						case 3: {

						}
							break;
						}
						System.out
								.println("do u want to continue in login menu   :   y/n");
						String a3 = br.readLine();
						if (a3.startsWith("n")) {
							break;
						}
					} while (true);

				}
				if (a2 == 1) {
					System.out.println("login unsucess");
				}
			}
				break;
			case 2: {
				System.out.println("Register your details");
				System.out.println("Enter your  Name");
				String username = br.readLine();

				System.out.println("Enter your passWord");
				String password = br.readLine();

				System.out.println("Enter your email ");
				String email = br.readLine();

				System.out.println("sex");
				String sex = br.readLine();

				System.out.println("Enter your phoneNo ");
				String phoneno = br.readLine();

				um.setUserName(username);
				um.setPassword(password);
				um.setEmail(email);
				um.setSex(sex);
				um.setContactNo(phoneno);

				us.add(um);

				System.out.println("database stored sucessfully");

			}
				break;

			case 3: {

				System.out.println("the list of the table is:...");
				ArrayList<UserModel> user = (ArrayList<UserModel>) us
						.activity1();
				for (int k = 0; k < user.size(); k++) {

					System.out.print("the list: " + user.get(k).toString());
					System.out.println("    ");
				}
			}
				break;
			case 4:

			{
				System.out
						.println("****************************BYE********************************");
				break;
			}
			}
			System.out.println("if u want exit click  :  y/n");
			String a4 = br.readLine();
			if (a4.startsWith("y")) {
				break;
			}

		} while (true);
	}

}
