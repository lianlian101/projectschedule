<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css"
        href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.7.0/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript"
        src="<%=basePath%>/static/js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
    <!-- 数据列表 -->
    <table id="dg" class="easyui-datagrid" style="width:auto; height:450px;padding:5px"></table>
    <!-- 更新数据 -->
    <div id="dd" style="display: none">
        <form id="ff" method="post">
            <div>
                              编号:<input class="easyui-textbox" type="text" name="id" data-options="required:true"/>
            </div>
		    <div>
		              名字:<input class="easyui-textbox" type="text" name="scheduleName" data-options="required:true" />
		    </div>
		    <div>
		              描述:<input class="easyui-textbox" type="text" name="scheduleDescribe" data-options="required:true" />
		    </div>
		    <div>
                             发起人:<input class="easyui-textbox" type="text" name="scheduleInitiator" data-options="required:true" />
            </div>
            <div>
                             发起时间:<input class="easyui-datetimebox" name="scheduleStartTime" data-options="required:true,showSeconds:false" style="width:150px">
            </div>
            <div>
                             完成人:<input class="easyui-textbox" type="text" name="consummator" data-options="required:true" />
            </div>
            <div>
                             完成时间:<input class="easyui-datetimebox" name="completeTime" data-options="required:true,showSeconds:false" style="width:150px">
            </div>
		</form>
    </div>
    <!-- 添加 -->
    <div id="dd2" style="display: none">
        <form id="ff2" method="post">
            <div>
                             名字:<input class="easyui-textbox" type="text" name="scheduleName" data-options="required:true" />
            </div>
            <div>
                             描述:<input class="easyui-textbox" type="text" name="scheduleDescribe" data-options="required:true" />
            </div>
            <div>
                             发起人:<input class="easyui-textbox" type="text" name="scheduleInitiator" data-options="required:true" />
            </div>
            <div>
                             发起时间:<input class="easyui-datetimebox" name="scheduleStartTime" data-options="required:true,showSeconds:false" style="width:150px">
            </div>
            <div>
                             完成人:<input class="easyui-textbox" type="text" name="consummator" data-options="required:true" />
            </div>
            <div>
                             完成时间:<input class="easyui-datetimebox" name="completeTime" data-options="showSeconds:false" style="width:150px">
            </div>
        </form>
    </div>

    <script type="text/javascript">
        $('#dg').datagrid({
            url: '<%=basePath%>/projectschedule/listAllPage',
            loadFilter: function (data) { // 过滤数据
                let rows = data.data.list;
                let total = data.data.total;
                return { "rows": rows, "total": total };
            },
            pagination: true, // 显示分页按钮
            //fitColumns: true, // 使列宽适应内容
            //singleSelect: true, // 只能选择一行
            //scrollOnSelect: false, // 自动定位到行所在的位置
            checkOnSelect: false, // 如果为false，当用户仅在点击该复选框的时候才会呗选中或取消
            striped: true, // 开启各行变色
            //rownumbers: true, // 显示行号
            emptyMsg: "暂无数据", // 当表格的内容为空时显示的消息
            toolbar: [{
		        iconCls: 'icon-edit',
		        handler: function(){add()}
		    },'-',{
		        iconCls: 'icon-remove',
		        handler: function(){del()}
		    }],
            columns: [[
            	{ field: 'cb', checkbox: true},
                { field: 'id', title: '编号' , width: '10%'},
                { field: 'scheduleName', title: '名字' , width: '10%'},
                { field: 'scheduleDescribe', title: '说明' , width: '10%'},
                {
                    field: 'scheduleType', title: '类型', width: '10%',
                    formatter: function (value, row, index) {
                        if (row.scheduleTyle == 0) {
                            return "前端";
                        } else {
                            return "后端";
                        }
                    }
                },
                { field: 'scheduleInitiator', title: '发起人' , width: '10%'},
                { field: 'scheduleStartTime', title: '发起时间' , width: '10%'},
                {
                    field: 'completeStatus', title: '完成度', width: '10%',
                    formatter: function (value, row, index) {
                        let completeStatus = row.completeStatus;
                        if (completeStatus == 1) {
                            return "完成";
                        } else if (completeStatus == 2) {
                            return "重改";
                        } else {
                            return "未完成";
                        }
                    }
                },
                { field: 'consummator', title: '完成人' , width: '10%'},
                { field: 'completeTime', title: '完成时间' , width: '10%'},
                {
                    field: '#', title: '数据操作', width: '10%',
                    formatter: function (value, row, index) {
                        let completeStatus = row.completeStatus;
                        if (completeStatus == 0 || completeStatus == 2) {
                            return `
                                <a href="javascript:void(0);" onclick="update(`+ row.id + `)">修改</a>
                                <a href="javascript:void(0);" onclick="done(`+ row.id + `)">完成</a>
                            `
                        } else if (completeStatus == 1) {
                            return `
                                <a href="javascript:void(0);" onclick="update(`+ row.id + `)">修改</a>
                                <a href="javascript:void(0);" onclick="anew(`+ row.id + `)">重改</a>
                            `
                        }
                    }
                }
            ]]
        });
        // 完成
        function done(id) {
            $.messager.confirm('提示', '确认完成', function (r) {
                if (r) {
                    $.ajax({
                        url: '<%=basePath%>/projectschedule/update',
                        data: { id: id, completeStatus: 1 },
                        success: function (data) {
                            if (data.code == 0) {
                                messageShow("操作成功");
                                $('#dg').datagrid('reload');
                            } else {
                                messageShow("操作失败");
                            }
                        }
                    });
                }
            });
        }
        // 重改
        function anew(id) {
            $.messager.confirm('提示', '确认重改', function (r) {
                if (r) {
                    $.ajax({
                        url: '<%=basePath%>/projectschedule/update',
                        data: { id: id, completeStatus: 2 },
                        success: function (data) {
                            if (data.code == 0) {
                                messageShow("操作成功");
                                $('#dg').datagrid('reload');
                            } else {
                                messageShow("操作失败");
                            }
                        }
                    });
                }
            });
        }
        // 修改信息
        function update(id) {
            $.ajax({
            	url: '<%=basePath%>/projectschedule/selectOne',
            	data: {id: id},
                success: function(data){
                	if(data.code == 0){
                		$('#ff').form('load', data.data);
                	}else{
                		messageShow("获取详情失败");
                	}
                }
            });
            $('#dd').dialog({
                title: '信息详情',
                width: 400,
                height: 400,
                cache: false,
                modal: true,
                buttons:[{
                    text:'确定',
                    handler:function(){
                    	// 提交form表单
                    	$('#ff').form('submit', {
                    	    url: '<%=basePath%>/projectschedule/update',
                    	    success:function(data){
                    	    	var data = JSON.parse(data);
                    	    	if(data.code == 0){
                    	    		$('#dd').window('close');
                    	    		messageShow("操作成功");
                    	    		$('#dg').datagrid('reload');
                    	    	}else{
                    	    		messageShow("操作失败");
                    	    	}
                    	    }
                    	});
                    }
                },{
                    text:'取消',
                    handler:function(){
                    	$('#dd').window('close');             	
                    }
                }]
            });
        }
        // 添加
        function add(){
        	$('#dd2').dialog({
                title: '添加记录',
                width: 400,
                height: 400,
                cache: false,
                modal: true,
                buttons:[{
                    text:'确定',
                    handler:function(){
                        // 提交form表单
                        $('#ff2').form('submit', {
                            url: '<%=basePath%>/projectschedule/add',
                            success:function(data){
                                var data = JSON.parse(data);
                                if(data.code == 0){
                                    $('#dd2').window('close');
                                    messageShow("操作成功");
                                    $('#dg').datagrid('reload');
                                }else{
                                    messageShow("操作失败");
                                }
                            }
                        });
                    }
                },{
                    text:'取消',
                    handler:function(){
                        $('#dd2').window('close');               
                    }
                }]
            });
        }
        // 删除
        function del(){
            var datas = $('#dg').datagrid('getChecked');
        	if(datas.length > 0){
                var ids = [];
        		datas.forEach((el, index) => {
        			ids.push(el.id);
                });
                if(ids != []){
                    $.ajax({
                        url: '<%=basePath%>/projectschedule/del',
                        data: {ids: ids},
                        type: 'post',
                        success: function(data){
                            if(data.code == 0){
                                if(data.data != null){
                                    messageShow("操作成功,失败的个数为->"+data.data);
                                    $('#dg').datagrid('reload');
                                }else{
                                    messageShow("操作成功");
                                    $('#dg').datagrid('reload');
                                }
                            }else{
                                messageShow("操作失败");
                            }
                        }
                    });
                }
        	}
        }
        // 通用，显示消息
        function messageShow(msg) {
            // $.messager.show({
            //     title: '提示',
            //     msg: msg,
            //     showType: 'fade',
            //     timeout: 1000
            // });
            $.messager.alert('提示', msg, 'info');
        }
        // easyui Datagrid百分比显示宽度
        function fixWidth(percent) {
            return document.body.clientWidth * percent;//根据自身情况更改

        } 
    </script>
</body>

</html>