import java.util.LinkedList;
import java.util.List;

public class LinkedListOperation {
	public static void main(String[] args) {
		Operations o = new Operations();
		List<Integer> a = new LinkedList<Integer>();
		for (int i = 1; i <= 100000; i++)
			a.add(i);
		o.traverse(a);
		o.insertAtBeginning(a);
		o.insertAtMiddle(a);
		o.insertAtEnd(a);
		o.removeAtBeginning(a);
		o.removeAtMiddle(a);
		o.removeAtEnd(a);
	}
}
