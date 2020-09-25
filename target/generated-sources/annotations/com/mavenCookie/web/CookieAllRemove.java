package com.mavenCookie.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieAllRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public CookieAllRemove() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ServletConfig sc = this.getServletConfig();
		String charset = sc.getInitParameter("charset");
		
		res.setContentType("text/html;charset=" + charset);
		PrintWriter out = res.getWriter();
		
		Cookie[] list = req.getCookies();
		
		for ( int i = 0; list != null && i < list.length; i++ ) {
			
			// 만료처리 전
			out.print( "이전 list[" + i + "]: " + list[i].getName() );
			out.print( "<br/>" );
			
			// 유효시간 0으로 설정하면 만료처리됨.
			Cookie kc = new Cookie(list[i].getName(), null) ;
		    kc.setMaxAge(0) ;
		    kc.setPath("/");

			// 응답에 쿠키 추가
			res.addCookie(kc);
			kc = null;
			
		}
		
		out.println("<br/>");
		out.println("<a href=\"index.jsp\">이전</a>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}
