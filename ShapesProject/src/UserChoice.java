import java.util.*;
public class UserChoice {
	/**
	 * This method is used to get user choice
	 * 
	 * @param
	 * @return int returns choice
	 */
	public int getChoice() {
		int choice = 1;
		try {
			//InputReader inputReader = new InputReader();
			System.out.println("Choose a shape 1.Square \n 2.Triangle \n 3.Right Isoceles \n 4. Left Isoceles");
			Scanner sc = InputReader.getInstance();
			choice=sc.nextInt();
			if (choice > 4 || choice < 1) {
				throw new IllegalArgumentException("Choose between 1 and 4 please");
			}
			
		}

		catch (InputMismatchException e) {
			System.out.print("That’s not a valid integer. Try again: ");
		} 
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return choice;
	}

}
