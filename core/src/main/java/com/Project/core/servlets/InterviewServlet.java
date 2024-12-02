package com.Project.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

// @Component(service = Servlet.class)
// @SlingServletPaths(value = {"/bin/conf"})
// public class InterviewServlet extends SlingSafeMethodsServlet{

//     @Override
//     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
//             throws ServletException, IOException {
//                 response.getWriter().write("get ready for interview");
//     }
    
// }

@Component(service = Servlet.class

        //   , property = {
        //     //Constants.SERVICE_DESCRIPTION+ "=Resource based servlet",-----------optional-------------
        //                 "sling.servlet.resourceTypes=/bin/venkat",
        //                 "sling.servlet.methods=GET",
        //                 "sling.servlet.extensions=txt",
        //                 "sling.servlet.selectors=s4",
                    
        //                 }
        )
        @SlingServletResourceTypes(resourceTypes = { "/bin/venkat" })
public class InterviewServlet extends SlingSafeMethodsServlet{

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("resource based -v-");
    }
    


}