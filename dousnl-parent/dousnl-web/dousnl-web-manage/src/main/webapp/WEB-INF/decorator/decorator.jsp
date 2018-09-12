<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>装饰器页面</title>
<sitemesh:write property='head' />
</head>
<body>
    <header>header</header>
    <hr />
    demo.html的title将被填充到这儿：
    <sitemesh:write property='title' /><br />
    demo.html的body将被填充到这儿：
    <sitemesh:write property='body' />
    <hr />
    <footer>footer</footer>
</body>
</html>