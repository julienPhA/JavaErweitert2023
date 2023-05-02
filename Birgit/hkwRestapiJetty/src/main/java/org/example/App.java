package org.example;

import java.util.HashMap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.example.MessageResource;

import org.example.ofen.OfenController;

/**
 * Simple application that starts a Jetty server instance
 * that serves some REST endpoints
 *
 */
public class App 
{
	
    static ServletContextHandler createRESTContextHandler() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(MessageResource.class);
        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig)), "/api/*");
        
        return handler;
    }
	
    public static void main( String[] args ) throws Exception
    {
        ServletContextHandler handler = createRESTContextHandler();
        Server server = new Server(8080);
        server.setHandler(handler);
        
		OfenController controller = new OfenController();
		HashMap<String,String> brennelementliste = controller.erzeugeBrennelementliste();

		
        try {
            System.out.println( "Starting Jetty server" );
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
