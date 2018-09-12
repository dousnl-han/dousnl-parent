<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎${user.username }光临!请选择你的操作:</h1><br>
    <ul>
        <shiro:hasPermission name="user:add"><li>增加</li></shiro:hasPermission>
        <shiro:hasPermission name="user:delete"><li>删除</li></shiro:hasPermission>
        <shiro:hasPermission name="user:update"><li>修改</li></shiro:hasPermission>
        <shiro:hasPermission name="user:select"><li>查询</li></shiro:hasPermission>
    </ul>
        <a href="${pageContext.request.contextPath }/logOut">点我注销</a>
</body>
</html>