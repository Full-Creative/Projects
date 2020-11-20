package package2;

import package1.*;

public class NonSubClass {
	public void Accessable() {
		A obj = new A();
		System.out.println("Different package non sub class");
		System.out.println(obj.publicName);
		// System.out.println(obj.name);
		System.out.println("default not accessable");

		System.out.println("private not accessable");

		// System.out.println(obj.protectedName);
		System.out.println("protected not accessable");

	}
}
