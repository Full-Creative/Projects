/**
 * 
 */

/**
 * @author User
 *
 */
public class ReadTimeFactory {
	   /**
		 * @param type
		 * @return ReadTime
		 */
		public ReadTime getReadTime(String type){
		      if(type.equals("child"))
		    	  return new ChildReadTime();
		      else if(type.equals("average"))
		    	  return new AverageReadTime();
		      else if(type.equals("executive"))
		    	  return new ExecutiveReadTime();
		      else
		    	  return null;		
		
		   }

}
