package com.trungtamjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
@WebFilter(urlPatterns = "/admin/*")
public class SecurityFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req1 = (HttpServletRequest) req;
		HttpServletResponse resp1 = (HttpServletResponse) resp;
		//doc session ra
		HttpSession session=req1.getSession();
		System.out.println(session.getId()); 
		if(session.getAttribute("loginUser") != null){
			User loginUser = (User) session.getAttribute("loginUser");
			System.out.println("Login" + loginUser.getName());
			if(loginUser.getRole().equals("ROLE_ADMIN")){
				 chain.doFilter(req, resp);
			}else{
				// het session quay ve dang nhap
				resp1.sendRedirect(req1.getContextPath() + "/access-deny");
			}
		}else{
			// het session quay ve dang nhap
			resp1.sendRedirect(req1.getContextPath() + "/login-admin");
	}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
