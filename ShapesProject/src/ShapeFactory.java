
/**
 * @author Vaishnavi R
 * @since 07-11-2020
 * @summary ShapeFatory class used to create different shape objects
 **/
public class ShapeFactory {
	 /**
	 * @param choice
	 * @return Shape
	 */
	public Shape getShape(int choice){
	      if(choice == 1)
	    	  return new Square();
	      else if(choice == 2)
	    	  return new Triangle();
	      else if(choice == 3)
	    	  return new RightIsosceles();
	      else if(choice == 4)
	    	  return new LeftIsosceles();
	      else
	    	  return null;		
	
	   }
}
