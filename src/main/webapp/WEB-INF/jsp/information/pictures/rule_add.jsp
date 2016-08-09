<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
	<%@ include file="../../system/admin/top.jsp"%>

	<!--查看图片插件 -->
	<link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/zoomimage.css" />
	<link rel="stylesheet" media="screen" type="text/css" href="plugins/zoomimage/css/custom.css" />
	<script type="text/javascript" src="plugins/zoomimage/js/jquery.js"></script>
	<script type="text/javascript" src="plugins/zoomimage/js/eye.js"></script>
	<script type="text/javascript" src="plugins/zoomimage/js/utils.js"></script>
	<script type="text/javascript" src="plugins/zoomimage/js/zoomimage.js"></script>
	<script type="text/javascript" src="plugins/zoomimage/js/layout.js"></script>
	<!--查看图片插件 -->

</head>
<body>
<div class="container-fluid" id="main-container">


	<div id="page-content" class="clearfix">

		<div class="row-fluid">

			<div class="row-fluid">

				<form action="consumeScoreRule/${saveMethod}.do" name="Form" id="Form" method="post" enctype="multipart/form-data">
					<input type="hidden" name="id" id="id" value="${info.id}"/>
					<div id="zhongxin">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<th>消费最小值:</th>
								<td><input type="text" name="consumeMin" id="consumeMin" value="${info.consumeMin}" maxlength="32" style="width:95%;" placeholder="这里输入消费最小值" title="消费最小值"/></td>
							</tr>
							<tr>
								<th>消费最大值:</th>
								<td><input type="text" name="consumeMax" id="consumeMax" value="${info.consumeMax}" maxlength="32" placeholder="消费最大值" title="消费最大值"/></td>
							</tr>
							<tr>
								<th>积分数:</th>
								<td><input type="text" name="gainScore" id="gainScore" value="${info.gainScore}" maxlength="32" style="width:95%;" placeholder="积分数" title="积分数"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="2">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
					</div>

					<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>

				</form>
			</div>




			<!-- PAGE CONTENT ENDS HERE -->
		</div><!--/row-->

	</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->


<!-- 引入 -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<!-- 引入 -->



<script type="text/javascript">

	$(top.hangge());

	//检索
	function search(){
		top.jzts();
		$("#Form").submit();
	}

	//新增
	function add(){
		top.jzts();
		var diag = new top.Dialog();
		diag.Drag=true;
		diag.Title ="新增";
		diag.URL = '<%=basePath%>consumeScoreRule/add.do';
		diag.Width = 800;
		diag.Height = 490;
		diag.CancelEvent = function(){ //关闭事件
			if('${page.currentPage}' == '0'){
				top.jzts();
				setTimeout("self.location=self.location",100);
			}else{
				nextPage(${page.currentPage});
			}
			diag.close();
		};
		diag.show();
	}

	//删除
	function del(Id){

		if(confirm("确定要删除?")){
			top.jzts();
			var url = "<%=basePath%>consumeScoreRule/delete.do?id="+Id+"&tm="+new Date().getTime();
			$.get(url,function(data){
				nextPage(${page.currentPage});
			});
		}
	}

	//修改
	function edit(Id){
		top.jzts();
		var diag = new top.Dialog();
		diag.Drag=true;
		diag.Title ="编辑";
		diag.URL = '<%=basePath%>consumeScoreRule/edit.do?id='+Id;
		diag.Width = 600;
		diag.Height = 465;
		diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				nextPage(${page.currentPage});
			}
			diag.close();
		};
		diag.show();
	}
</script>

<script type="text/javascript">

	//全选 （是/否）
	function selectAll(){
		var checklist = document.getElementsByName ("ids");
		if(document.getElementById("zcheckbox").checked){
			for(var i=0;i<checklist.length;i++){
				checklist[i].checked = 1;
			}
		}else{
			for(var j=0;j<checklist.length;j++){
				checklist[j].checked = 0;
			}
		}
	}



	//批量操作
	function makeAll(msg){

		if(confirm(msg)){

			var str = '';
			for(var i=0;i < document.getElementsByName('ids').length;i++)
			{
				if(document.getElementsByName('ids')[i].checked){
					if(str=='') str += document.getElementsByName('ids')[i].value;
					else str += ',' + document.getElementsByName('ids')[i].value;
				}
			}
			if(str==''){
				alert("您没有选择任何内容!");
				return;
			}else{
				if(msg == '确定要删除选中的数据吗?'){
					top.jzts();
					$.ajax({
						type: "POST",
						url: '<%=basePath%>pictures/deleteAll.do?tm='+new Date().getTime(),
						data: {DATA_IDS:str},
						dataType:'json',
						//beforeSend: validateData,
						cache: false,
						success: function(data){
							$.each(data.list, function(i, list){
								nextPage(${page.currentPage});
							});
						}
					});
				}
			}
		}
	}

	//导出excel
	function toExcel(){
		window.location.href='<%=basePath%>pictures/excel.do';
	}
</script>
<style type="text/css">
	li {list-style-type:none;}
</style>
<ul class="navigationTabs">
	<li><a></a></li>
	<li></li>
</ul>
</body>
</html>

