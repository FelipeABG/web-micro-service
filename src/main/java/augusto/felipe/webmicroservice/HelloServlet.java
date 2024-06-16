package augusto.felipe.webmicroservice;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/user")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {}



}