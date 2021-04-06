package misservlets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
@WebListener
public class InicializaStock implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializaStock() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	
    	ServletContextListener.super.contextInitialized(sce);
    	
    	ServletContext contexto=sce.getServletContext();
    	String archCatalago= contexto.getInitParameter("archivoCatalago");
    	BufferedReader cat=null;
    	Hashtable catalogo=new Hashtable();
    	try {
	    	cat=new BufferedReader (new InputStreamReader(contexto.getResourceAsStream(archCatalago)));
	    	// Parsea el archivo y construye una lista de productos en el objeto catalogo
	    	contexto.setAttribute("stock",catalogo);//posible linea a replicar para multiple elementos
	    	contexto.log("lista de Productos creada ");
    	}catch(Exception e) {contexto.log("Ocurrió una excepción mientras….",e);
    	}finally{
    		if (cat!=null) {
    			try{cat.close();}
    			catch(Exception e) {}
    		}
    	}
    }
   
	
}
