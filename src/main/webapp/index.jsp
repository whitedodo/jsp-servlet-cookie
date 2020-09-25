<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>Cookie 태스트</title>
	<style>
		
		a{
			text-decoration:none;
		}
	
	</style>
</head>
<body>

<h2>Hello World!</h2>

<h3>이클립스 웹에서는 확인 불가</h3>
<a href="CookieTest1Servlet">쿠키 생성</a><br/>
<a href="CookieExtract">쿠키 추출</a><br/>
<a href="CookieAllRemove">쿠키 전체 삭제</a><br/>
<a href="CookieModify">쿠키 변경(결론: 불가능)</a><br/>
<div style="width:400px; height:200px; background-color:#e2e2e2">
	<h5>참고로 웹 브라우저에서 쿠키를 제거하는 옵션을 켜버리면 유지 자체에 의미가 없어짐.</h5>

</div>
</body>
</html>
