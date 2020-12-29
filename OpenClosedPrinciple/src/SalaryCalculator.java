
public class SalaryCalculator {
public static void main(String[] args) {
	PermanentEmployee permanent=new PermanentEmployee();
	permanent.setName("Jason");
	permanent.setAge(35);
	System.out.println("The bonus of "+permanent.getName()+" is "+permanent.calculateBonus());
	
	TemporaryEmployee temporary=new TemporaryEmployee();
	temporary.setName("Paul");
	temporary.setAge(30);
	System.out.println("The bonus of "+temporary.getName()+" is "+temporary.calculateBonus());
}
}
