package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.SignUpValidator;
import modal.Donor;

public class Search extends SignUpValidator {

	public void searchdonors(List<Donor> donors) throws IOException {
		int i;
		boolean flag = true;
		String bloodGroupsearch, citySearch;
		Search search = new Search();
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n1.Search with Blood Group\n2.Search with city");

		/******************* Search by Blood Group *****************/

		try {
			int searchinput = Integer.parseInt(sc.readLine());
			if (searchinput == 1) {
				while (true) {
					System.out.println("Enter Blood group");
					bloodGroupsearch = sc.readLine();
					Boolean bloodgroupcheck = search.bloodgroup(bloodGroupsearch);
					if (bloodgroupcheck)
						break;
					else
						System.out.println("Wrong value entered");
				}
				for (i = 0; i < donors.size(); i++) {
					if ((donors.get(i).getBloodGroup().equals(bloodGroupsearch))
							&& (donors.get(i).getAvailable().equals("YES"))) {
						flag = false;
						System.out.println("Name : " + donors.get(i).getFirstName() + " " + donors.get(i).getLastName()
								+ "  " + "City : " + donors.get(i).getCity() + "  " + "Phone Number : "
								+ donors.get(i).getphonenumber() + "  " + "Blood Group : "
								+ donors.get(i).getBloodGroup());
					}
					System.out.println("\n\n");
				}
				if (flag) {
					System.out.println("No Donors available for this particluar blood group");
					return;
				}
			}

			/******************* Search by City Name *****************/

			else if (searchinput == 2) {
				while (true) {
					System.out.println("Enter City name");
					citySearch = sc.readLine();
					Boolean citycheck = search.cityvalidate(citySearch);
					if (citycheck)
						break;
					else
						System.out.println("Enter your correct city name");
				}
				for (i = 0; i < donors.size(); i++) {
					if ((donors.get(i).getCity().equals(citySearch)) && (donors.get(i).getAvailable().equals("YES"))) {
						flag = false;
						System.out.println("Name : " + donors.get(i).getFirstName() + " " + donors.get(i).getLastName()
								+ "  " + "City : " + donors.get(i).getCity() + "  " + "Phone Number : "
								+ donors.get(i).getphonenumber() + "  " + "Blood Group : "
								+ donors.get(i).getBloodGroup());
					}
					System.out.println("\n\n");
				}
				if (flag) {
					System.out.println("No Donors available with the given city name");
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Please Enter only numeric value");
		}

	}
}
