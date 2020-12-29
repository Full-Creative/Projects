
public class Employee {
	public String name;
	public int age;
	public int employeeID;
	//public String employeeType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
//	public double calculateBonus() {
//		if(this.employeeType.equals("Temporary"))
//			return 10/100;
//		else
//			return 20/100;
//	}
//	public double calculatePF() {
//	 return 12/100;	
//	}

}
