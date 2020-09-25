package com.mavenCookie.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieModify
 */
public class CookieModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieModify() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletConfig sc = this.getServletConfig();
		String charset = sc.getInitParameter("charset");
		
		res.setContentType("text/html;charset=" + charset);
		PrintWriter out = res.getWriter();
		
		Cookie[] list = req.getCookies();
		
		for ( Cookie cookie : list  ) {
			
			if ( cookie.getName().equals("id")) {
				cookie.setValue("haha");
				res.addCookie(cookie);
			}
			
			
		}

		out.println("<br/>");
		out.println("<a href=\"index.jsp\">이전</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}
