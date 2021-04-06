package misservlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Productos() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Hola Mundo </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<table class='default'>");
		
		out.println("<tr>");
		out.println("<th> Golosinas </th>");
		out.println("<th> Precio Unitario </th>");
		out.println("<th> Cantidad </th>");
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td>");
		//Nombre de Golosinas
		out.println("</td>");
		
		out.println("<td>");
		//Precio de las golosinas
		out.println("</td>");
		
		out.println("<td>");
		//Cantidad editable por el usuario
		out.println("<input type='text' name='cantidad'>");
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<input type='submit' value='Facturar'>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

}
