package inter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface idcheckCommand {

	public boolean idcheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException; 
	
	
}
