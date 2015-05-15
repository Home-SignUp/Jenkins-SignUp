package com;

/**
 * Created by alexandr on 13.05.15.
 */
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
public class UserCheckFilter implements Filter {
    private String LOGIN_ACTION_URI;

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        LOGIN_ACTION_URI = fConfig.getInitParameter("loginActionURI");
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession    session = req.getSession();
        User              user = (User) session.getAttribute("user");

        if (user == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())){
            RequestDispatcher rd = req.getRequestDispatcher("/login");
            rd.forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }
}