package modal;

public class Donor {

	private String FirstName, LastName, email, Available, BloodGroup, City, password, phonenumber;
	private int age, weight;
	String userID;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String id) {
		this.userID = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvailable() {
		return Available;
	}

	public void setAvailable(String available) {
		Available = available;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getphonenumber() {
		return phonenumber;
	}

	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/******************** Output ******************************/
//	public String toString() {
//		return String.format(
//				"\n\nThank you for enrolling to donate blood.\n\nYour donations will make a big difference in the lives of many patients.\n\n\n\n\nYour credentials:\n\nName: %s\n\nAge: %d\n\nWeight: %d\n\nBlood Group: %s\n\nPhone Number: %s\n\nCity: %s\n\nAvailable: %s\n\n\n\n\n\nYour USER ID: %s\n\nYour Password is: %s\n\n\n\n\n\n",
//				FirstName + " " + LastName, age, weight, BloodGroup, phonenumber, City, Available, userID, password);
//	}
	public String toString() {
		return String.format(
				"\n\nName: %s\n\nAge: %d\n\nWeight: %d\n\nBlood Group: %s\n\nPhone Number: %s\n\nCity: %s\n\nAvailable: %s\n\n\n\n\n",
				FirstName + " " + LastName, age, weight, BloodGroup, phonenumber, City, Available);
	}
}
