public class StringCompareDemo {
	public static void main(String args[]) {
		String a = "Java";
		String b = "C++";
		String c = "Scala";
// let's see what happen when we compare String for equality using // == operator, it will return true if both String point to same // object e.g. interned String or String literal, otherwise it // will return false, even if two String contains same characters // and has same length. 
		if (a == "Java") {
			System.out.println("String literal can be compared using == operator");
		}
// content is same but different object , == will return false
		String d = "Java";
		if (a != d) {
			System.out.println("String liternal and new String should not be " + "compared using == operator");
		}
// two String object created using new also should not be // compared using == operator, it will return false // even if they have same content
		String e = new String("JavaScript");
		String f = new String("JavaScript");
		if (e != f) {
			System.out.println("Two String has same content but pointing to different object");
		}
// Right way to compare String in Java // if you want to check if two Strings are equal then use // equals() method 
		if (a.equals("Java")) {
			System.out.println("Both Strings contains same characters");
		}
// when you use equals() method with literal, it's better to // call equals() on String literal, this will help you to // avoid NullPointerException
		if ("Java".equals(a)) {
			System.out.println("Right way of using equals() method with String literal");
		}
// If you want to perform case insensitive comparison between // two String, then use equalsIgnoreCase() method of String class // it will return true if those contains same characters but in // different case e.g. Java and JAVA will be equal if you use // equalsIgnoreCase() method
		String g = "JAVA";
		if (a.equalsIgnoreCase(g)) {
			System.out.println("equalsIgnoreCase is used to perform case insensitive comparison");
		}
// Now if you want to compare String to check their alphabetical order then // you should use compareTo() method. This method returns positive, negative and 0 if the // String on which it is called is greater than, less than or equal to // passed String as parameter.
		if (a.compareTo(b) > 1) {
			System.out.println(a + " comes after " + b + " in alphabetical order");
		} else if (a.compareTo(b) < -1) {
			System.out.println(a + " comes before " + b + " in alphabetical order");
		} else {
			System.out.println(a + " and " + b + " are equal to each other");
		}
	}
}
