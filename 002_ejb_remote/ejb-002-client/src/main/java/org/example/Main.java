package org.example;


import org.example.models.Productos;
import org.example.service.EJBServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        EJBServiceRemote service = null;


        System.out.println("Hello world!");
        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");

        env.put("jboss.naming.client.ejb.context", true);

        try{
            InitialContext ctx = new InitialContext(env);

            service = (EJBServiceRemote) ctx.lookup("ejb:/ejb-002-remote/ServiceEBJ!org.example.service.EJBServiceRemote");
            String respuesta = service.hello("Hola desde el cliente");
            String respuesta2 = service.hello("Hola desde el cliente 2");

            System.out.println(respuesta);
            System.out.println(respuesta2);

            Productos producto = service.crear(new Productos("Producto 4"));
            System.out.println(producto);

            service.listarProductos().forEach(System.out::println);



        }catch (NamingException e){
            e.printStackTrace();
        }

    }
}