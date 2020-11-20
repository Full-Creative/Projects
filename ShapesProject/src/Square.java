/**
 * @author Vaishnavi R
 * @since   06-11-2020
 * @summary Square class implements shape interface
 **/

public class Square implements Shape {
	
    /**
	* This method is used to draw shapes using *
	* @param rows Number of rows the shape is
	* @return String returns result string
	*/
	public String draw(int rows) {
		StringBuilder result=new StringBuilder();
 		for(int i = 0; i < rows; i++) {
			
			for(int j = 0; j < rows; j++) {
	 		//	System.out.print("*");
	 			result.append("*");
	 		}
	
			//System.out.println();
			result.append("\n");
		}
 		return String.valueOf(result);
	}
}
