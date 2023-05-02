package de.lbbw;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
/**
 * Hello world!
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
        try {
            System.out.println( "Starting Jetty server" );
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
