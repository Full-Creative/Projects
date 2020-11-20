
public class SingletonDemo {

	public static void main(String[] args) {
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();

		Singleton1 a = new Singleton1();
		Singleton1 b = new Singleton1();

		System.out.println((x == y) + " checking for x==y");
		System.out.println(x.equals(y) + " checking for x equals y");
		
		System.out.println((a == b) + " checking for a==b");
		System.out.println(a.equals(b) + " checking for a equals b");

	}

}
