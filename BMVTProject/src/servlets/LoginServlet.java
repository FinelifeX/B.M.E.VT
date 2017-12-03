package servlets;

import entities.User;
import entities.UserLoginData;
import globals.GlobalUser;
import freemarker.Freemarker;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import globals.GlobalUserLoginData;
import helpers.AuthHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 23:24
 * KPFU ITIS 11-601
 **/


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean isRemember = "on".equals(request.getParameter("isRemember"));

        User user = new User();
        UserLoginData data = new UserLoginData();
        data.setPassword("user");
        user.setUsername("user");
        user.setLoginData(data);

        if (login.equals(GlobalUser.username) && password.equals(GlobalUserLoginData.password)) {
            AuthHelper.login(request, user);
            if (isRemember) {
                AuthHelper.rememberUser(response, user);
            }
            response.sendRedirect("/main");
        }
        else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Template template = Freemarker.getCfg().getTemplate("login.html");
        HashMap<String, Object> root = new HashMap<>();
        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
