package org.example.controller;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.models.Productos;
import org.example.service.EJBServiceLocal;
import org.example.service.ServiceEBJ;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.io.IOException;


/**
 * Escenario 1 con JDNI
 */
/*@WebServlet("/index")
public class ServletController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //local    
        EJBServiceLocal serviceEJB = null;
        EJBServiceLocal serviceEJB2 = null;

        try {
            
             //JNDI InitialContext
             //.lookup es para buscar el archivo que esta como string
             //para darlo como refrencia del recurso
               
            System.out.println("*********** Escenario 1 JDNI ************");  
             
            InitialContext initialContext = new InitialContext();
            
            // lista todos los jdni
            NamingEnumeration<NameClassPair> list = initialContext.list("java:global");
            while (list.hasMore()) {
                System.out.println(list.next().getName());
            }
            
            serviceEJB = (EJBServiceLocal) initialContext.lookup(
            	    "java:global/ejb-001-basics/ServiceEBJ!org.example.service.EJBServiceLocal");
            serviceEJB2 = (EJBServiceLocal) initialContext.lookup(
            	    "java:global/ejb-001-basics/ServiceEBJ!org.example.service.EJBServiceLocal");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        //Productos
        Productos producto = serviceEJB.crear(new Productos("Producto Nuevo"));

        System.out.println("Service si es igual a service2: " + serviceEJB.equals(serviceEJB2));
        req.setAttribute("message2", serviceEJB2.hello(" from Servlet 2"));
        req.setAttribute("message", serviceEJB.hello(" from Servlet"));
        req.setAttribute("listado", serviceEJB.listarProductos());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}*/


/**
 * Escenario 2 de inyeccion con CDI
 */

/*import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@WebServlet("/index") //RUTA
@Named
@RequestScoped
public class ServletController extends HttpServlet {

    @Inject
    private EJBServiceLocal serviceEJB;

    @Inject
    private EJBServiceLocal serviceEJB2;

    @Override
    protected void doGet(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
            
            
		System.out.println("*********** Escenario 2 CDI ************");
        Productos producto = serviceEJB.crear(new Productos("Producto Nuevo"));

        System.out.println("Service si es igual a service2: " + serviceEJB.equals(serviceEJB2));
        req.setAttribute("message2", serviceEJB2.hello(" from Servlet 2"));
        req.setAttribute("message", serviceEJB.hello(" from Servlet"));
        req.setAttribute("listado", serviceEJB.listarProductos());

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}*/


/**
 * Escenario 3 inyeccion con @EJB
 */
@WebServlet("/index")
public class ServletController extends HttpServlet {

    // Inyección con @EJB (forma tradicional para EJBs)
    @EJB
    private EJBServiceLocal serviceEJB;

    @EJB
    private EJBServiceLocal serviceEJB2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	
    	System.out.println("*********** Escenario 3 @EJB ************");
        // Productos - el EJB ya está inyectado y listo para usar
        Productos producto = serviceEJB.crear(new Productos("Producto Nuevo"));

        System.out.println("Service si es igual a service2: " + serviceEJB.equals(serviceEJB2));
        req.setAttribute("message2", serviceEJB2.hello(" from Servlet 2"));
        req.setAttribute("message", serviceEJB.hello(" from Servlet"));
        req.setAttribute("listado", serviceEJB.listarProductos());
        
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

