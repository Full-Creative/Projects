import java.util.Scanner;

/**
 * 
 */

/**
 * @author User
 *
 */
public class InputReader 
{ 
	//private static InputReader obj = new InputReader(); 
	public  static Scanner s;
    private InputReader() 
    {
    }
    public static Scanner getInstance() 
    { 
    	if(s==null)
    		s=new Scanner(System.in);
        return s; 
    } 
} 