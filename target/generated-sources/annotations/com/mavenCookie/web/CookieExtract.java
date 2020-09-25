package com.mavenCookie.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieExtract extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieExtract() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletConfig sc = this.getServletConfig();
		String charset = sc.getInitParameter("charset");
		
		res.setContentType("text/html;charset=" + charset);
		PrintWriter out = res.getWriter();
		
		Cookie[] list = req.getCookies();

		// 삭제 여부 - 판별
		if ( list != null ) {
			out.print("유지 상태<br/>");
		}else
		{
			out.print("삭제 완료<br/>");
		}
		
		// 쿠키 찾기(seq방식)
		out.println("쿠키 검색1<br/>");
		
		for ( int i = 0; list != null && i < list.length; i++ ) {
			out.println( list[i].getName() + ":value=" + list[i].getValue() + "<br/>" );
		}
		
		// for 문 - 응용2
		out.println("쿠키 검색2<br/>");
		
		int i = 0;
		for( Cookie cookie : list) {
			out.println( list[i].getName() + ":value=" + list[i].getValue() + "<br/>" );
			i++;
		}
		
		out.println("<a href=\"index.jsp\">이전</a>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}
