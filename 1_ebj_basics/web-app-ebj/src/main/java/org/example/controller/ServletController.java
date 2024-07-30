package org.example.controller;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.example.models.Productos;
import org.example.service.EJBServiceLocal;
import org.example.service.ServiceEBJ;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class ServletController  extends HttpServlet {
    //inyectamos el EJB
    /*@Inject
    private ServiceEBJ serviceEJB;

    @Inject
    private ServiceEBJ serviceEJB2;*/



    @Override
    protected void doGet(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {

        /*
        ServiceEBJ serviceEJB = null;
        ServiceEBJ serviceEJB2 = null;*/

        //local
        EJBServiceLocal serviceEJB = null;
        EJBServiceLocal serviceEJB2 = null;

        try {
            /**
             * JNDI InitialContext
             * .lookup es para buscar el archivo que esta como string
             * para darlo como refrencia del recurso
             */
            InitialContext initialContext = new InitialContext();
            serviceEJB = (ServiceEBJ) initialContext
                    .lookup("java:global/web-app-ebj/ServiceEBJ!org.example.service.EJBServiceLocal");
            serviceEJB2 = (ServiceEBJ) initialContext
                    .lookup("java:global/web-app-ebj/ServiceEBJ!org.example.service.EJBServiceLocal");
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

}
