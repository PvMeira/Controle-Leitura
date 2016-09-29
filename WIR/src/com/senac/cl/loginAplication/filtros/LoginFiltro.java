package com.senac.cl.loginAplication.filtros;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omnifaces.filter.HttpFilter;
import org.omnifaces.util.Servlets;

@WebFilter("/paginas/*")
public class LoginFiltro extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain)
        throws ServletException, IOException
    {
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        }
        else {
            Servlets.facesRedirect(request, response, "Login.xhtml");
        }
    }
}