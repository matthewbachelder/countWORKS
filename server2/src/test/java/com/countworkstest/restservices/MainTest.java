
package com.countworkstest.restservices;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.countworks.restservices.Main;
import com.countworks.restservices.ClientRecord;
public class MainTest  {
	private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
       // server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
         //c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
        System.out.println(Main.BASE_URI);
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
       // server.shutdown();
    }

    
    @Test
    public void testCreateClientRecord() {
     	ClientRecord client = new ClientRecord();
    	client.setFirstName("Matthew");
    	client.setLastName("Bachelder");
    	client.setPhone("469-335-2909");
    	client.setPrimaryEmail("Matthewtbachelder@gmail.com");
    	client.setSitePassword("mb277378");
 
        Response responseMsg = target.path("client/create-new-client").request().post(Entity.json(client));
        System.out.println(responseMsg.toString());
        
        
    }
}
