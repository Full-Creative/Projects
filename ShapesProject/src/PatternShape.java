import java.util.*;

/**
 * @author Vaishnavi R
 * @since 06-11-2020
 * @summary PatternShape class has the main method
 **/
public class PatternShape {

	public static void main(String[] args) {
		int choice, rows = 3;
		try {
			UserChoice userchoice = new UserChoice();
			choice = userchoice.getChoice();// input
			RowData rowData = new RowData();
			rows = rowData.getRows();// input
			ShapeFactory shapeFactory = new ShapeFactory();
			Shape shape1 = shapeFactory.getShape(choice);
			System.out.print(shape1.draw(rows));
			InputReader.getInstance().close();
		} catch (InputMismatchException e) {
			System.out.print("That’s not an integer. Try again: ");
		} catch (NullPointerException e) {
			System.out.print("Invalid input. Try again: ");
		}

	}
}