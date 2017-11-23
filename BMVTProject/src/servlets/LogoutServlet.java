package servlets;

import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Bulat Murtazin on 20.11.2017 -> 0:46
 * KPFU ITIS 11-601
 **/


@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logout(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static void login(HttpServletRequest request, User user) {
        request.getSession().setAttribute("current_user", user);
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        login(request, null);
    }
}

