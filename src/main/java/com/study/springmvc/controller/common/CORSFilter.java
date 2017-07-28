package com.study.springmvc.controller.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (httpRequest.getHeader("Origin") != null) {
			httpResponse.addHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
		}
		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, DELETE, OPTIONS");
		httpResponse.addHeader("Access-Control-Max-Age", "3600");
		httpResponse.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, token, access-token, Content-Type, id-token");
		if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}