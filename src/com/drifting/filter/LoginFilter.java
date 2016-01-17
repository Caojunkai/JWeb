package com.drifting.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String charset = config.getInitParameter("charset");
        if (charset == null){
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);
        HttpSession session = request.getSession();
        String noFilterPath = config.getInitParameter("noFilterPath");
        if (noFilterPath != null){

            String[] nfpArr = noFilterPath.split(";");
            for (int i = 0; i < nfpArr.length; i++){
                if (nfpArr[i] == null || "".equals(nfpArr[i]))
                    continue;
                if (request.getRequestURI().contains(nfpArr[i])){
                    chain.doFilter(req, resp);
                    return;
                }
            }
        }
        if (session.getAttribute("username") != null || request.getRequestURI().contains(".css") || request.getRequestURI().contains(".js")){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
