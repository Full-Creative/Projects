import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WorkAround {
public static void main(String[] args) {
	List<Integer> a=new ArrayList<Integer>();
	a.add(1);
//	a.add("Hello");
	a.add(null);
	a.add(null);
	a.add(3);
//	Collections.sort(a);
	System.out.println(a);
	BextendsA child=new BextendsA(2);
	
	Map<Integer,Integer> lhm=new TreeMap<Integer, Integer>();
	HashMap<Integer,Integer> hm=new HashMap();
	StringBuilder str=new StringBuilder();
	System.out.println(hm.size());
	for(int i=0;i<10;i++)
	{
	//	lhm.put(i, i*2);
		//hm.put(i, i*2);
	}
	hm.put(1, 123);
	hm.put(2,321);
	hm.put(3, 100);
	System.out.println(hm.get(1));
	//System.out.println(lhm);
	Queue<Integer> q=new PriorityQueue<Integer>();
	q.add(3);
	q.add(5);
	q.add(1);
	q.add(1);
	System.out.print(q);
	Set<String> s=new HashSet<String>();

	s.add("James");
	s.add(new String("James"));
	s.add("Karthik");
	s.add("James");
	System.out.println(s);

	/* for (Map.Entry<Integer,Integer> entry : hm.entrySet())  
         System.out.println("Key = " + entry.getKey() + 
                          ", Value = " + entry.getValue()); 
	*/
}
}
