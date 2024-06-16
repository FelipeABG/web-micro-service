package augusto.felipe.webmicroservice;

import java.io.*;
import java.util.Enumeration;

import entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

@MultipartConfig
@WebServlet("/user")
public class HelloServlet extends HttpServlet {

    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);

        this.userService.addNewUser(user);

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {}



}