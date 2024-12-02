package com.Project.core.servlets;

import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Random;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;


@Component(service = Servlet.class,
           property = {
               Constants.SERVICE_DESCRIPTION + "=Path based servlet",
               "sling.servlet.paths=" + "/bin/randomGeneratorServlet"
           })
public class Word extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(Word.class);
    
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String sessionParam = request.getParameter("session");
        String randomParam = request.getParameter("random");

        if (sessionParam != null) {
            String randomWord = generateRandomWord(6);
            response.getWriter().write("Session: " + randomWord);
        } else if (randomParam != null) {
            String randomDigits = generateRandomDigits(6);
            response.getWriter().write("Random Digits: " + randomDigits);
        } 
         else {
            response.getWriter().write("Please provide 'session' or 'random' parameter.");
        }
    }

    private String generateRandomWord(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }
    private String generateRandomDigits(int length) {
        String digits = "0123456789"; 
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            sb.append(digits.charAt(random.nextInt(digits.length())));
        }
        
        return sb.toString();
    }
}
