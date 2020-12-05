package package2;
import package1.*;
public class DextendsA extends A {
	public void Accessable() {
		System.out.println("Different package sub class");
		System.out.println(publicName);
		System.out.println(protectedName);
		//System.out.println(obj.name);
		System.out.println("default not accessable");
		System.out.println("private not accessable");
	
		protectedMethod();
	}
}
