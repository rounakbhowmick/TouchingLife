package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modal.Donor;

public class UserInput {

	SignUpValidator signup = new SignUpValidator();

	// signup.sign(obj);
	void input(Donor obj) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		/********************************** Name ***********************************/

		while (true) {
			System.out.println("Enter your first name");
			String firstName = sc.readLine();
			obj.setFirstName(firstName);
			System.out.println("Enter your surname");
			String LastName = sc.readLine();
			obj.setLastName(LastName);
			// Validation of name
			Boolean name = signup.name(obj.getFirstName(), obj.getLastName());
			if (name)
				break;
		}

		/************************************* Age ***********************************/

		// Input and Validation of age
		while (true) {
			try {
				System.out.println("Enter your age");
				int age = Integer.parseInt(sc.readLine());
				obj.setAge(age);
				signup.agecheck(obj.getAge());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter your correct age");

			}
		}

		/************************************* Weight *********************************/

		while (true) {
			try {
				System.out.println("Enter your weight");
				int weight = Integer.parseInt(sc.readLine());
				obj.setWeight(weight);
				signup.weightcheck(obj.getWeight());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter your correct weight");
			}
		}

		/*********************************** Blood Group ******************************/

		while (true) {
			System.out.println("Enter your bloodGroup");
			String bloodGroup = sc.readLine();
			obj.setBloodGroup(bloodGroup);
			Boolean bloodgroupcheck = signup.bloodgroup(obj.getBloodGroup());
			if (bloodgroupcheck)
				break;
			else
				System.out.println("Wrong value entered");
		}

		/********************************* Phone Number *******************************/

		while (true) {
			System.out.println("Enter your phone number");
			String phoneNumber = sc.readLine();
			obj.setphonenumber(phoneNumber);
			Boolean phoneNumbercheck = signup.phoneNumbercheck(obj.getphonenumber());
			if (phoneNumbercheck)
				break;
			else
				System.out.println("Please enter your correct 10 digit phone number");
		}

		/********************************* City *******************************/

		while (true) {
			System.out.println("Enter your City");
			String city = sc.readLine();
			obj.setCity(city);
			Boolean citycheck = signup.cityvalidate(obj.getCity());
			if (citycheck)
				break;
		}
		/*************************** Availability ***********************************/

		while (true) {
			System.out.println("Are you available for Blood Donation?\n\nType YES if you are available else type NO\n");
			String availablestatus = sc.readLine().toUpperCase();
			if ((availablestatus.equals("YES") || (availablestatus.equals("NO")))) {
				obj.setAvailable(availablestatus);
				break;
			}
		}

		/************************** ID Generation *********************/

		String id = signup.ID(obj.getFirstName());
		obj.setUserID(id);

		/************************** Password Generation *********************/

		String newpassword = signup.password();
		obj.setPassword(newpassword);

		/************ Display Login Credentials ******************/

		System.out.println(
				"\n\nSuccessfully Registered.\n\nThank you for enrolling to donate blood.\n\n\nYour donations will make a big difference in the lives of many patients.\n\nYOUR LOGIN CREDENTIALS\n\n"
						+ "USER ID: " + obj.getUserID() + "\n\n" + "Your default password : " + obj.getPassword()
						+ "\n");
	}

}