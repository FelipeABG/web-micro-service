package augusto.felipe.webmicroservice;

import java.io.*;
import java.util.Enumeration;

import com.google.gson.Gson;
import entity.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

@MultipartConfig
@WebServlet("/user")
public class HelloServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String userId = request.getParameter("userId");

        if(userId == null) {
            User user = new User(username, password, email);
            this.userService.addNewUser(user);

            response.setContentType("text/plain");

            PrintWriter out = response.getWriter();
            out.println("User created successfully");
        }else{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Long id = Long.parseLong(request.getParameter("userId"));
            User u = this.userService.getUserById(id);
            String jsonUser = gson.toJson(u);

            PrintWriter out = response.getWriter();
            out.println(jsonUser);
            out.flush();
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String userId = request.getParameter("userId");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (this.userService.getUserById(Long.parseLong(userId)) == null) {
            out.println("User not found");
        }
        else{
            User user = new User(username, password, email);
            this.userService.updateUser(user);
            out.println("User updated successfully");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Long id = Long.parseLong(request.getParameter("userId"));
        if (this.userService.getUserById(id) == null) {
            out.println("User not found");
        }
        else {
            this.userService.deleteUser(id);
            out.println("User deleted successfully");
        }
    }



}