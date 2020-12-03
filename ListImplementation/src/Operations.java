import java.util.List;

public class Operations {
	long start, end;

	public void insertAtBeginning(List<Integer> a) {
		start = System.currentTimeMillis();
		a.add(0, 2);
		end = System.currentTimeMillis();
		System.out.println("Insert at beginning time: " + (end - start));
	}

	public void insertAtEnd(List<Integer> a) {
		start = System.currentTimeMillis();
		a.add(a.size() - 1, 2);
		end = System.currentTimeMillis();
		System.out.println("Insert at end: " + (end - start));
	}

	public void insertAtMiddle(List<Integer> a) {
		start = System.currentTimeMillis();
		a.add(a.size() / 2, 2);
		end = System.currentTimeMillis();
		System.out.println("Insert at middle time: " + (end - start));

	}

	public void removeAtBeginning(List<Integer> a) {
		start = System.currentTimeMillis();
		a.remove(0);
		end = System.currentTimeMillis();
		System.out.println("Remove at beginning time: " + (end - start));
	}

	public void removeAtEnd(List<Integer> a) {
		start = System.currentTimeMillis();
		a.remove(a.size() - 1);
		end = System.currentTimeMillis();
		System.out.println("Remove at end time: " + (end - start));

	}

	public void removeAtMiddle(List<Integer> a) {
		start = System.currentTimeMillis();
		a.remove(a.size() / 2);
		end = System.currentTimeMillis();
		System.out.println("Remove at middle time: " + (end - start));
	}

	public void traverse(List<Integer> a) {
		start = System.currentTimeMillis();
		for (int i = 0; i < a.size(); i++)
			a.get(i);
		end = System.currentTimeMillis();
		System.out.println("Traversal time: " + (end - start));
	}
	public void hasElement(List<Integer> a, int i) {
		start = System.currentTimeMillis();
			a.contains(i);
		end = System.currentTimeMillis();
		System.out.println("Contains time: " + (end - start));
	}

}