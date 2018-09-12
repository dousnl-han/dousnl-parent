<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@page isELIgnored="false"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="${ctx}/resources/static/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/resources/static/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/static/css/animate-custom.css" />
    </head>
    <script src="${ctx}/resources/static/js/jquery-1.11.1.js"></script>
    <script src="${ctx}/resources/static/js/layer/layer.js"></script>
    <script type="text/javascript">
    var ctx = "${ctx}";
    function layerOpen(){
    	layer.open({
		  type: 1,
		  area: ['600px', '360px'],
		  shadeClose: true, //点击遮罩关闭
		  content: '\<\div style="padding:20px;">自定义内容\<\/div>'
		  });
    }
       $("#sing-up").click(function(){
    	   alert(1)
    	   /* layer.open({
				  type: 1,
				  area: ['600px', '360px'],
				  shadeClose: true, //点击遮罩关闭
				  content: '\<\div style="padding:20px;">自定义内容\<\/div>'
				  }); */
       })
    </script>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="">
                    <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
                </a>
                ${ctx}
                <span class="right">
                    <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
                        <strong>Back to the Codrops Article</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>登录 和 注册 来自 <span> HTML5 and CSS3</span></h1>
                <a href="${ctx}/logOut">点我注销</a>
				<nav class="codrops-demos">
					<span>点击 <strong>"加入我们"</strong> 看更多的模版Demo</span>
					<a href="${ctx}/index" class="current-demo">Demo 1</a>
					<a href="${ctx}/index2">Demo 2</a>
					<a href="${ctx}/index3">Demo 3</a>
				</nav>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="${ctx}/loginUser" method="post"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 你的 邮箱 或 用户名 </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 你的 密码 </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <ul>
									<li class="user_main_text">验证码:</li>
									<li class="user_main_input">
									<input type="text" class="TxtcodeCssClass" id="checkCode" name="checkCode" onblur="resetErrorMsg()" onkeydown="if(event.keyCode==13) return false;"/>
									</li>
									<li><!-- <img id="imgObj" alt="验证码" src="getCheckCode" style="margin-top: 5px"/> --></li>
								</ul>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">记住我</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="登录" id="sing-up" /> 
								</p>
                                <p class="change_link">
									忘记密码 ?
									<a href="#toregister" class="to_register">加入我们</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">你的用户名</label>
                                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > 你的邮箱</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">你的密码 </label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">请确认你的密码 </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="button" value="Sign up" id="sing-up-2"/> 
								</p>
                                <p class="change_link">  
									已经注册 ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>