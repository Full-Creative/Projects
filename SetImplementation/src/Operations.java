import java.util.*;

public class Operations {
	long start, end;
	int limit = 10000;

	public void insert(Set<Integer> s) {
		start = System.currentTimeMillis();
		for (int i = 0; i < limit; i++)
			s.add(i);
		end = System.currentTimeMillis();
		System.out.println(s.getClass() + " " + (end - start));
	}

	public void traverseIterator(Set<Integer> s) {
		start = System.currentTimeMillis();
		Iterator<Integer> itr = s.iterator();
		while (itr.hasNext())
			itr.next();
		end = System.currentTimeMillis();
		System.out.println(s.getClass() + " " + (end - start));
	}

	public void traverseEnhancedForLoop(Set<Integer> s) {
		Integer x;
		start = System.currentTimeMillis();
		for (Integer i : s)
			x = i + 1;
		end = System.currentTimeMillis();
		System.out.println(s.getClass() + " " + (end - start));
	}

	public void search(Set<Integer> s) {
		start = System.currentTimeMillis();
		s.contains(limit / 2);
		end = System.currentTimeMillis();
		System.out.println(s.getClass() + " " + (end - start));
	}

	public void remove(Set<Integer> s) {
		start = System.currentTimeMillis();
		s.remove(limit -1);
		end = System.currentTimeMillis();
		System.out.println(s.getClass().getName() + " " + (end - start));

	}
}
