import java.util.*;

public class LinkedListImplementation {
	static int limit = 10000;

	public static int generateRandomNumbers(int max, int min) {
		int randomNum = new Random().nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void accessNumber(List<Integer> collectionOfNumbers) {
		for (int i = 0; i < limit; i++)
			collectionOfNumbers.get(i);
	}

	public static double averageAccessTime(List<Integer> a) {
		double time = 0;
		for (int i = 0; i < 100; i++) {
			long start = System.currentTimeMillis();
			accessNumber(a);
			long end = System.currentTimeMillis();
			time += end - start;
		}
		return time / 100;
	}

	public static void insertRandomValuesAtRandomIndeces(List<Integer> collectionOfNumbers) {
		for (int i = 0; i < limit; i++)
			collectionOfNumbers.add(limit / 2, i);
	}

	public static void removeRandomValuesAtRandomIndeces(List<Integer> collectionOfNumbers) {
		for (int i = 0; i < limit; i++)
			collectionOfNumbers.remove(i);
	}

	public static boolean searchForNumber(List<Integer> collectionOfNumbers, int numberToBeFound) {
		return collectionOfNumbers.contains(numberToBeFound);
	}

	public static void main(String[] args) {
		long start, end;
		List<Integer> al = new LinkedList<Integer>();
		for (int i = 0; i < limit; i++)
			al.add(i);

		start = System.currentTimeMillis();
		accessNumber(al);
		end = System.currentTimeMillis();

		System.out.println("0 to n traversal " + (end - start));

		start = System.currentTimeMillis();
		searchForNumber(al, 9999);
		end = System.currentTimeMillis();

		System.out.println("contains() search " + (end - start));

		start = System.currentTimeMillis();
		insertRandomValuesAtRandomIndeces(al);
		end = System.currentTimeMillis();
		System.out.println("Insert at n/2 " + (end - start));

		start = System.currentTimeMillis();
		removeRandomValuesAtRandomIndeces(al);
		end = System.currentTimeMillis();
		System.out.println("remove 10000 elemts   " + (end - start));
	}

}
