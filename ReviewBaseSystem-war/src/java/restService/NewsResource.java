/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.NewsEntity;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("news")
@RequestScoped
public class NewsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NewsResource
     */
    public NewsResource() {
    }

    /**
     * Retrieves representation of an instance of restService.NewsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String result = null;
        JSONObject myResponse = null;
        String query_url = "http://newsapi.org/v2/top-headlines?country=in&apiKey=f14e8adede4044139ea49f208c73dcb8";
        //String json = "{ \"method\" : \"guru.test\", \"params\" : [ \"jinu awad\" ], \"id\" : 123 }";
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(5000);
//            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setRequestMethod("POST");
//            OutputStream os = conn.getOutputStream();
//            os.write(json.getBytes("UTF-8"));
//            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result= IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            myResponse = new JSONObject(result);
            System.out.println(myResponse);
//            System.out.println("jsonrpc- " + myResponse.getString("jsonrpc"));
//            System.out.println("id- " + myResponse.getInt("id"));
//            System.out.println("result- " + myResponse.getString("result"));
            in.close();
            conn.disconnect();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * PUT method for updating or creating an instance of NewsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
