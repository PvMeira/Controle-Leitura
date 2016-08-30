package com.senac.cl.loginAplication.filtros;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senac.cl.modelos.Pessoa;

@WebFilter(filterName = "FiltroNormal",value="/normal")
public class FiltroNormal implements Filter {

	@Inject
	private Pessoa pessoaLogada;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (pessoaLogada == null) {
			resp.sendRedirect(req.getServletContext().getContextPath() + "/Login.xhtml");
		} else if (pessoaLogada.isLogado()) {
			if (pessoaLogada.isNormal() == true) {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}

}