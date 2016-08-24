
package com.countworks.restservices;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;



import java.io.IOException;
import java.net.URI;



public class Main {

	public static final String BASE_URI = "http://0.0.0.0:8280/countworks-restservices/";
    

	/**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.countworks.restservices");
        rc.register(CORSFilter.class);
        
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
 
    
    public static void main(String[] args) throws IOException {
    	final HttpServer server = startServer(); //server started
    	
    	
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
       
        System.in.read();
        server.shutdown();
    }    
}
