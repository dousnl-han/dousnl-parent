<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringBoot+WebSocket+广播式</title>
<script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>  
<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>  
<%-- <script type="text/javascript" src="${ctx}/resources/static/js/sockjs.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/static/js/stomp.js"/></script> --%>
<script type="text/javascript" src="${ctx}/resources/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
     var stompClient=null;
     function setConnect(connected){
    	 document.getElementById('connect').disabled=connected;
    	 document.getElementById('disconnect').disabled=!connected;
    	 document.getElementById('conversationDiv').style.visibility=connected ? 'visible' : 'hidden';
    	 $("#response").html();
     }
     function connect(){
    	 var socket=new SockJS("/endpointWisely");
    	 stompClient=Stomp.over(socket);
    	 stompClient.connect({},function (frame){
    		 setConnect(true);
    		 console.log("Connected开始:"+frame);
    		 stompClient.subscribe('/topic/getResponse',function(response){
    			 showResponse(JSON.parse(response.body).responseMessage);
    		 });
    	 });
     }
     function disconnect(){
    	 if(stompClient !=null){
    		 stompClient.disconnect();
    	 }
    	 setConnect(false);
    	 console.log("disConnected");
     }
     function sendName(){
       var name=$("#name").val(); 
   	   stompClient.send("/welcome",{},JSON.stringify({'name':name}));
     }
     function showResponse(message){
    	var response=$("#response");
    	response.html(message);
     }
</script>
</head>
<body onload="disconnect()">
<div>
   <div>
      <button id="connect" onclick="connect();">连接</button>
      <button id="disconnect" disabled="disabled" onclick="disconnect();">断开</button>
   </div>
   <div id="conversationDiv">
      <label>输入你的名字</label><input type="text" id="name" />
      <button id="sendName" onclick="sendName();">发送</button>
      <p id="response"></p>
   </div>
</div>


</body>
</html>