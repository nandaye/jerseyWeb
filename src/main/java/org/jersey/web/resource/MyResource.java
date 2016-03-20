package org.jersey.web.resource;

import org.jersey.web.entity.Inform;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by nandaye on 2016/3/12 12:27.
 */
@Path("/jersey")
public class MyResource {

    @Autowired private Inform inform;
    @Context
    private HttpHeaders headers;
    @Context
    private HttpServletResponse response;
    @Context
    private HttpServletRequest request;
    @Context
    private UriInfo info;
    @Context
    private ServletContext servletContext;
    @Context
    private ServletConfig servletConfig;

    @GET
    @Produces("text/plain")
    public String get()
    {
        StringBuffer strb=new StringBuffer();
        strb.append("Now ,you will see all informatiopn:"+"\n");
        strb.append("headers: "+headers+"\n");
        strb.append("servletConfig: "+servletConfig+"\n");
        strb.append("servletContext: "+servletContext+"\n");
        strb.append("request: "+request+"\n");
        strb.append("request: "+response+"\n");
        return strb.toString();
    }

    @GET
    @Path("/rs/{name}")
    @Produces("text/plain")
    public String getName(@PathParam("name") String name)
    {
        StringBuffer strb=new StringBuffer();
        strb.append("Hi,name:"+name);
        return strb.toString();
    }

    @GET
    @Path("/inform/{inform_name}")
    @Produces("text/html")
    public String getInform(@PathParam("inform_name") String inform_name,
                            @QueryParam("name") String name)
    {
        StringBuffer strb=new StringBuffer();
        if (inform == null) {
            strb.append("inform 注入失败！"+"\n");
            inform=new Inform("no title",inform_name);
            strb.append("now,inform is:"+inform+"]\n");
        }
        else
        {
            strb.append("inform :"+inform+"\n");
        }
        strb.append("pathparam:"+inform_name+"\n");
        strb.append("queryparam:"+name);
        return strb.toString();
    }

}
