package com.mavenCookie.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletConfig sc = this.getServletConfig();
		String charset = sc.getInitParameter("charset");
		
		res.setContentType("text/html;charset=" + charset);
		
		PrintWriter out = res.getWriter();
		
		// 1. 쿠키 생성 - 기본 시간(브라우저 종료시 전송받은 쿠키 사라짐)
		Cookie c1 = new Cookie("id", "userID");
		c1.setPath("/");
		res.addCookie(c1);		
		
		// 2. 쿠키 생성 - 쿠키 3시간 설정(60sec * 60Min * 3Hour)
		Cookie c2 = new Cookie("mymy", "1234");
		c2.setMaxAge(60 * 60 * 3);
		c2.setPath("/");
		res.addCookie(c2);
		
		// 3. 쿠키 생성 - 쿠키 5일 설정(60sec * 60Min * 24Hour * 5Day)
		Cookie c3 = new Cookie("subject", "zaza");
		c3.setMaxAge(60 * 60 * 24 * 5);
		c3.setPath("/");			// 경로는 루트로 지정함.
		res.addCookie(c3);
		
		out.println("쿠키 전송 완료<br/>");
		out.println("<a href=\"index.jsp\">이전</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}
