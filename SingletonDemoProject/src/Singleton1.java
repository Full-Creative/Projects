

public class Singleton1 {
	static Singleton1 obj = null;
	public String s;
	public Singleton1 getInstance() {
		if (obj == null)
			obj = new Singleton1();
		return obj;
	}
}