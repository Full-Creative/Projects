import java.util.*;
public class BextendsA extends A {
	public BextendsA(int a) {
		super(a);
	}

	HashMap<Integer, Integer> init(int capacity, float load) {
		return new LinkedHashMap<Integer, Integer>(capacity, load);
	}
}
