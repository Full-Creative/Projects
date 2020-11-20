/**
 * @author Vaishnavi R
 * @since 06-11-2020
 * @summary Triangle class implements shape interface
 **/

public class Triangle implements Shape {
	/**
	 * This method is used to draw shapes using *
	 * 
	 * @param rows Number of rows the shape is
	 * @return void This does not return anything
	 */
	@Override
	public String draw(int rows) {
		int i, j;
		StringBuilder result=new StringBuilder();
		for (i = 0; i < rows; i++) {

			for (j = 0; j < rows - i; j++) {
				// System.out.print(" ");
				 result.append(" ");	
				}

			for (j = 0; j <= 2 * i; j++) {
				//System.out.print("*");
				result.append("*");
			}

			//System.out.println();
			result.append("\n");
		}
		return String.valueOf(result);
	}
}
