package misservlets;

import java.io.IOException;
import java.util.Hashtable;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Hashtable logins=new Hashtable();


 
    public LoginUsr() {
        
    }


	public void init(ServletConfig config) throws ServletException {
		logins.put("usuario1", config.getInitParameter("usuario1"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(logins.get("usuario1")!=null) {
			//redireccionar al servelet productos  
			response.sendRedirect("/compras/productos");
		}else {
			//redireccionar de nuevo a login.html
		}
	}

}
