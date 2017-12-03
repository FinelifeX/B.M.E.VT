package filters;

import entities.User;
import entities.UserLoginData;
import globals.GlobalUser;
import globals.GlobalUserLoginData;
import helpers.AuthHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Bulat Murtazin on 03.12.2017 -> 18:28
 * KPFU ITIS 11-601
 **/


@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (AuthHelper.isLogin(req)) {
            chain.doFilter(request, response);
        } else {
            Cookie tokenCookie = AuthHelper.getCookie(req, "token");
            if (tokenCookie != null) {
                User user = new User();
                user.setUsername(GlobalUser.username);
                user.setToken(GlobalUser.token);
                UserLoginData data = new UserLoginData();
                data.setPassword(GlobalUserLoginData.password);
                user.setLoginData(data);
                AuthHelper.login(req, user);
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect("/login");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}

