<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/color.css">
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <div style="position:relative;overflow:auto;height:370px;border:1px solid #ddd">
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:10,top:10,inline:true">
            <p class="w-content">Window content</p>
        </div>
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:320,top:10,inline:true">
            <p class="w-content">Window content</p>
        </div>
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:630,top:10,inline:true">
            <p class="w-content">Window content</p>
        </div>
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:10,top:180,inline:true,border:false">
            <p class="w-content">Window content</p>
        </div>
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:320,top:180,inline:true,border:'thin'">
            <p class="w-content">Window content</p>
        </div>
        <div class="easyui-window" title="Window" data-options="width:300,height:150,left:630,top:180,inline:true,border:'thick'">
            <p class="w-content">Window content</p>
        </div>
    </div>
</body>
</html>