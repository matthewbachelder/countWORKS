package com.countworks.restservice.countworks_restservice;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;



public class Main {

	public static final String BASE_URI = "http://0.0.0.0:8280/countworks-restservice/";
    

	/**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.javarticles.rest.JaxRsPathExample package
        final ResourceConfig rc = new ResourceConfig().packages("com.countworks.restservice.countworks_restservice");
        rc.register(CORSFilter.class);
        
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
 
    
    public static void main(String[] args) throws IOException {
        // Grizzly 2 initialization
    	final HttpServer server = startServer(); //server started
    	
    	
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
       
        System.in.read();
        server.shutdown();
    }    
}
