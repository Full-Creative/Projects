import java.io.IOException;  
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;  
  
public class MyFilter implements Filter{  
FilterConfig config;  
  
public void init(FilterConfig config) throws ServletException {  
    this.config=config;  
}  
 @Override
public void doFilter(ServletRequest req, ServletResponse resp,  
    FilterChain chain) throws IOException, ServletException {  
   /*   
    PrintWriter out=resp.getWriter();  
          
    String s=config.getInitParameter("construction");  
          
    if(s.equals("yes")){  
         out.print("This page is under construction");  
    }  
    else{  
         chain.doFilter(req, resp);//sends request to next resource  
    }  
          */
	 HttpServletRequest httpRequest = (HttpServletRequest) req;
	 httpRequest.getHeader("user");
	    Enumeration<String> headerNames = httpRequest.getHeaderNames();
	    List<String> a=new ArrayList<String>();
	    
	    if (headerNames != null) {
	            while (headerNames.hasMoreElements()) {
	                    System.out.println(" Header: " + httpRequest.getHeader(headerNames.nextElement()));
	            }
	           // if(a.contains("document"))
	    	    chain.doFilter(httpRequest, resp);
	    }
System.out.println();
	    //doFilter
		
	 //   chain.doFilter(httpRequest, resp);
}  
public void destroy() {}  
}  
