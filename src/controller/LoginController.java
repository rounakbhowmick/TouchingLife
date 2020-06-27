package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import modal.Donor;

public class LoginController extends SignUpValidator {

	public void donorlogin(List<Donor> donors) throws IOException {
		LoginController login = new LoginController();
		// TODO Auto-generated method stub
		int i;
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		/**************************** Login User ID Check ***********************/

		System.out.println("Enter your userID");
		String id = sc.readLine();
		for (i = 0; i < donors.size(); i++) {
			if (donors.get(i).getUserID().equals(id))
				break;
		}
		if (i == donors.size()) {
			System.out.println("Login Failed\nUser id is incorrect or your account has not been setup in the system\n");
			return;
		}

		/**************************** Login User Password Check ***********************/

		System.out.println("Enter your password");
		String password = sc.readLine();
		if (!(donors.get(i).getPassword().equals(password))) {
			System.out.println("The password you entered is incorrect.Please try again");
			return;
		} else {
			System.out.println("Welcome " + donors.get(i).getFirstName());
		}

		/************************ Donors Menu Profile *************************/

		while (true) {
			System.out.println(
					"\n1.View your data\n2.Change your Password\n3.Change your Availability status\n4.Change your Age\n5.Change your Weight\n6.Change your Phone Number\n7.Change your City\n8.Delete your data\n9.Logout");
			int userinput = Integer.parseInt(sc.readLine());
			switch (userinput) {
			case 1:
				System.out.println(donors.get(i));
				break;
			case 2:
				while (true) {
					System.out.println("Enter your new password");
					String newpassword = sc.readLine();
					if (newpassword.length() < 4)
						System.out.println("Password length should be more than 5 characters");
					else {
						System.out.println(
								"Your password has been changed successfully!Thank you\nSession Expired.Try to relogin\n");
						donors.get(i).setPassword(newpassword);
						return;
					}
					break;
				}

				break;
			case 3:
				while (true) {
					System.out.println("Enter your new status");
					System.out.println(
							"Are you available for Blood Donation?\n\nType YES if you are available else type NO\n");
					String status = sc.readLine();
					if ((status.equals("YES") || (status.equals("NO")))) {
						donors.get(i).setAvailable(status);
						break;
					}
				}
				break;
			case 4:
				while (true) {
					try {
						System.out.println("Enter your new age");
						int age = Integer.parseInt(sc.readLine());
						donors.get(i).setAge(age);
						login.agecheck(donors.get(i).getAge());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Please enter your correct age");
					}
				}
				break;
			case 5:
				while (true) {
					try {
						System.out.println("Enter your new weight");
						int weight = Integer.parseInt(sc.readLine());
						donors.get(i).setWeight(weight);
						login.weightcheck(donors.get(i).getWeight());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Please enter your correct weight");
					}
				}
				break;
			case 6:
				while (true) {
					System.out.println("Enter your new phone number");
					String phoneNumber = sc.readLine();
					donors.get(i).setphonenumber(phoneNumber);
					Boolean phoneNumbercheck = login.phoneNumbercheck(donors.get(i).getphonenumber());
					if (phoneNumbercheck)
						break;
					else
						System.out.println("Please enter your correct 10 digit phone number");
				}
				break;
			case 7:
				while (true) {
					System.out.println("Enter your new City");
					String city = sc.readLine();
					donors.get(i).setCity(city);
					Boolean citycheck = login.cityvalidate(donors.get(i).getCity());
					if (citycheck)
						break;
				}
				break;
			case 8:
				while (true) {
					System.out.println("Are you sure?\n\nType YES if you are available else type NO\n");
					String deletetask = sc.readLine();
					if ((deletetask.equals("YES") || (deletetask.equals("NO")))) {
						System.out.println("Your data is deleted from our system\n");
						donors.remove(donors.get(i));
						return;
					}
					break;
				}
			case 9:
				System.out.println("You have been successfully logged out");
				return;
			default:
				System.out.println("Wrong Input");
			}
		}
	}
}
