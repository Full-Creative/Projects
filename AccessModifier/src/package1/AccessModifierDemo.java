package package1;

import package2.*;

public class AccessModifierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BextendsA obj = new BextendsA();
		obj.Accessable();
		System.out.println();
		System.out.println("Same package non sub class");
		System.out.println("Private name not accessable");
		System.out.println(new A().name);
		System.out.println(new A().publicName);
		System.out.println(new A().protectedName);
		// System.out.println(new A().privateName);
		System.out.println();
		DextendsA d = new DextendsA();
		d.Accessable();
		System.out.println();
		NonSubClass c = new NonSubClass();
		c.Accessable();

	}

}
