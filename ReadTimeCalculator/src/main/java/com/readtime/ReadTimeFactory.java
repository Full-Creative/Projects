package com.readtime;

public class ReadTimeFactory {
	public ReadTime getReadType(String type){
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
