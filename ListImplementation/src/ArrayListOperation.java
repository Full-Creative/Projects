import java.util.*;

public class ArrayListOperation {
	public static void main(String[] args) {
		Operations o = new Operations();
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 1; i <= 1000000; i++)
			a.add(i);
		o.traverse(a);
		o.insertAtBeginning(a);
		o.insertAtMiddle(a);
		o.insertAtEnd(a);
		o.removeAtBeginning(a);
		o.removeAtMiddle(a);
		o.removeAtEnd(a);
		o.hasElement(a, 200);
		
		
		System.out.println("\nLinkedList");
		System.out.println("Linked List traversal takes more time than arraylist");
		List<Integer> al = new LinkedList<Integer>();
		for (int i = 1; i <= 1000000; i++)
			al.add(i);
		// o.traverse(al);
		
		o.insertAtBeginning(al);
		o.insertAtMiddle(al);
		o.insertAtEnd(al);
		o.removeAtBeginning(al);
		o.removeAtMiddle(al);
		o.removeAtEnd(al);
		o.hasElement(al, 20000);

	}
}
