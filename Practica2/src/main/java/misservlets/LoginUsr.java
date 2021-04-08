package misservlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebInitParam;
/**
 * Servlet implementation class LoginUsr
 */

@WebServlet( urlPatterns = {"/LoginUsr"},
initParams = {
@WebInitParam(name="usuario1", value="1234"),
@WebInitParam(name="usuario2", value="admin")
})

public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Hashtable logins=new Hashtable();
	public Map<String, String> logins= new HashMap<String, String>();
	
	



 
    public LoginUsr() {
        
    }


	public void init(ServletConfig config) throws ServletException {
		
		logins.put("usuario1", config.getInitParameter("usuario1"));
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(logins);
		
		if((logins.containsKey(user)) && (logins.get(user).equals(password))) {
			//redireccionar al servelet productos  
			System.out.println("Autenticacion correcta");
			response.sendRedirect("Productos");
		}else {
			//redireccionar de nuevo a login.html
			System.out.println("Fallo la auteticacion");
			response.sendRedirect("/Practica2");
		}
	}

}
