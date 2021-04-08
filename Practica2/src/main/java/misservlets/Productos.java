package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Productos
 */
//@WebServlet("/Productos")

@WebServlet( urlPatterns = {"/Productos"},
initParams = {
@WebInitParam(name="chupetin", value="2"),
@WebInitParam(name="chocolate", value="2.3")
})
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	private Map<String, String> golosinas= new HashMap<String, String>();
	
    public Productos() {
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		
		golosinas.put("chupetin", config.getInitParameter("chupetin"));
		golosinas.put("chocolate", config.getInitParameter("chocolate"));
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estoy en Productos y doGet");
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		HttpSession sesion = request.getSession(true);
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Productos  </TITLE>");
		out.println("</HEAD>");
		
		out.println("<BODY>");
		out.println("<FORM action='/Practica2/Facturar' method='get'>");
		//out.println("<table class='default' border='1'>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<th  align='center'> Golosinas   </th>");
		out.println("<th align='center'> Precio Unitario   </th>");
		out.println("<th align='center'> Cantidad   </th>");
		out.println("</tr>");
		
		out.println("<tr>");
		
		
		for (String i : golosinas.keySet()) {
			out.println("<tr align='center'>");
				  System.out.println(i);
				  out.println("<td align='center'>");
				  out.print("<P>"+i+ "</P>");
				  out.println("</td>");
				  
				  System.out.println(golosinas.get(i));
				  out.println("<td align='center'>");
					//Precio de las golosinas
				  out.print("<P>$ "+golosinas.get(i)+ "</P>");
				  out.println("</td>");
					
				  out.println("<td >");
					//Cantidad editable por el usuario
				  out.println("<input type='number' name='cantidad'>");
				  out.println("</td>");
			  out.println("</tr>");
			}
		
		out.println("</TABLE>");
		
		out.println("<input type='submit' value='Facturar'>");
		
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
		
	}

}
