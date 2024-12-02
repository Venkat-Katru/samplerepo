package com.Project.core.servlets;



import com.google.gson.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
        Constants.SERVICE_DESCRIPTION + "=Resource Based Servlet Example",
        "sling.servlet.resourceTypes=example/components/content/resourcebased", 
        "sling.servlet.methods=GET", 
        "sling.servlet.extensions=json" 
    }
)
public class ResourceServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("name", request.getResource().getName());
        jsonResponse.addProperty("resourcePath", request.getResource().getPath());
        jsonResponse.addProperty("resourceType", request.getResource().getResourceType());
        
        jsonResponse.addProperty("Name", "Venkat Katru");
        jsonResponse.addProperty("Age", "23");

        
        response.getWriter().write(jsonResponse.toString());
    }
}
