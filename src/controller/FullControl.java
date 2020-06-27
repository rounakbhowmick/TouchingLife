package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modal.Donor;
import service.DonorExcelGeneration;
import service.Search;

public class FullControl {
	static List<Donor> donors = new ArrayList<Donor>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		while (true) {
			System.out.println("1.BECOME A DONOR  --- SIGN UP\n2.Login\n3.Search\n4.Display all the donors\n5.Exit");
			Scanner sc = new Scanner(System.in);
			/// Exception handling is used to prevent from String inputs
			try {
				int main_input = sc.nextInt();
				switch (main_input) {
				case 1:
					DonorExcelGeneration excel = new DonorExcelGeneration();
					UserInput obj1 = new UserInput();
					Donor obj = new Donor();
					obj1.input(obj);
					donors.add(obj);
					// excel.createExcel((List<Donor>) donors.get(0));
					excel.createExcel(donors);
					// System.out.println(obj);
					break;
				case 2:
					LoginController login = new LoginController();
					login.donorlogin(donors);
					break;
				case 3:
					Search search = new Search();
					search.searchdonors(donors);
					break;
				case 4:
					if (donors.size() != 0) {
						for (int i = 0; i < donors.size(); i++)
							System.out.println(donors.get(i));
					} else
						System.out.println("No donors found");
					break;
				case 5:
					System.out.println("THANK YOU FOR YOUR INTEREST IN BECOMING A VOLUNTEER");
					System.exit(0);

				default:
					System.out.println("Wrong Input");
				}
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println("Please Enter only numeric value\n\n");
			}
		}

	}
}