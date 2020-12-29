
public class PermanentEmployee extends Employee implements EmployeeOperations {

	@Override
	public double calculateBonus() {
		return (50000*20)/100;
	}

	@Override
	public double calculatePF() {
		return (50000*10)/100;
	}

}
