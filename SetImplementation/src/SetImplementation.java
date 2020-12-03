import java.util.*;

public class SetImplementation {
	public static void main(String[] args) {
		Set<Integer> s=new HashSet<Integer>();
		Set<Integer> lhs=new LinkedHashSet<Integer>();
		Set<Integer> ts=new TreeSet<Integer>();
		Operations o=new Operations();
		
		System.out.println("Insertion");
		o.insert(s);
		o.insert(lhs);
		o.insert(ts);
		
		System.out.println("\nTraverse Iterator");
		o.traverseIterator(s);
		o.traverseIterator(lhs);
		o.traverseIterator(ts);
		
		System.out.println("\nTraverse For each");
		o.traverseEnhancedForLoop(s);
		o.traverseEnhancedForLoop(lhs);
		o.traverseEnhancedForLoop(ts);
		
		System.out.println("\nContains");
		o.search(s);
		o.search(lhs);
		o.search(ts);
		
		System.out.println("\nRemove");
		o.remove(s);
		o.remove(lhs);
		o.remove(ts);
		
		//System.out.println(s.toString());
		//System.out.println(lhs.toString());
		//System.out.println(ts.toString());
		
	}

}



   
