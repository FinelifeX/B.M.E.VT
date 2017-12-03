package helpers;

import entities.User;
import entities.UserLoginData;
import globals.GlobalUser;
import globals.GlobalUserLoginData;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by Bulat Murtazin on 03.12.2017 -> 15:58
 * KPFU ITIS 11-601
 **/


public class AuthHelper {

    public static void login(HttpServletRequest request, User user) {
        request.getSession().setAttribute("current_user", user);
    }

    public static boolean isLogin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("current_user");
        //TODO Проверка наличия такого юзера в БД
        //Заглушка
       if (user == null) {
           return false;
       }
       else {
           if (user.getUsername().equals(GlobalUser.username)) {
               return true;
           }
           else {
               return false;
           }
       }
    }

    public static void rememberUser(HttpServletResponse response, User user) {
        UUID uuid = UUID.randomUUID();
        String login = user.getUsername();
        addCookie(response, "token", uuid.toString());
//        TODO Написать обновление токена у юзера
//        Заглушка
        user.setToken(uuid.toString());
        GlobalUser.token = uuid.toString();
    }

    public static void addCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void removeCookies(HttpServletRequest request,
                                     HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        login(request, null);
        removeCookies(request, response);
    }
}
