/**
 * 
 */

/**
 * @author User
 *
 */
public class CommandLineReader {
	public String readCommandLine(String[] args) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			result.append(args[i]);
			result.append(" ");
		}
		return String.valueOf(result);	
	}

}
