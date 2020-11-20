import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author User
 *
 */
public class FileReader {

	public String readFile() {
		StringBuilder str = new StringBuilder();
		try {
			File myObj = new File("C:\\Users\\User.DESKTOP-SAM078B\\Desktop\\Sample.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				str.append(myReader.nextLine());
				str.append(" ");
			}
			myReader.close();
			return String.valueOf(str);
		}

		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		} catch (NullPointerException e) {
			System.out.println("NullPointerException..");
		}
		return String.valueOf(str);
	}

}
