
public class TemporaryEmployee extends Employee implements EmployeeOperations {

	@Override
	public double calculateBonus() {
		return (30000*10) / 100;
	}

	@Override
	public double calculatePF() {
		return (30000*8)/100;
	}

}
