import java.util.InputMismatchException;
import java.util.*;
/**
 * @author Vaishnavi R
 * @since 06-11-2020
 * @summary RowData class responsible for setting number of rows
 **/
public class RowData {
	/**
	 * This method is used to get number of rows
	 * 
	 * @param
	 * @return int returns number of rows
	 */
	public int getRows() {
		int rows = 3;
		try {
			System.out.println("Enter rows");
			Scanner sc = InputReader.getInstance();
			rows=sc.nextInt();
			if (rows < 0) {
				throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
			}
		}
		catch (InputMismatchException e) {
			System.out.print("That’s not a valid integer. Try again: ");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}
}
