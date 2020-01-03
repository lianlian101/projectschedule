<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/color.css">
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    function addTab() {
        $("#tabs").tabs("add", {
            title:"工作计划列表", 
            content: createFrame("<%=basePath%>/projectschedule/projectschedule.jsp"), 
            closable:false, 
            fit:true, 
            width:$("#mainFrame").width(), 
            height:$("#mainFrame").height()
        });
    }
    function createFrame(url) {
        return `<iframe name="mainFrame" scrolling="auto" frameborder="0" src="` + url + `" style="width:100%;height:100%;"></iframe>`;
    }
</script>
</head>
<body class="easyui-layout">
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
        <a href="javascript:void(0);" style="display:block; margin:5px auto" class="easyui-linkbutton" onclick="addTab()">工作计划表</a>
    </div>
    <div id="content" data-options="region:'center',title:'内容'" style="padding:5px; background:#eee;">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false"></div>
    </div>
</body>
</html>