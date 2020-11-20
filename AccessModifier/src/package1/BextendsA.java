package package1;

public class BextendsA extends A {
	public void Accessable() {
		System.out.println("Same package subclass");
		System.out.println("private not accessable");
		System.out.println(publicName);
		System.out.println(protectedName);
		System.out.println(name);
		// System.out.println(privateName);
	}
}
