<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/statics/ztree/css/zTreeStyle/zTreeStyle.css"	type="text/css">
<div class="pageContent">
	<form method="post"	action="${pageContext.request.contextPath}${requestScope.record ==null ?'/system/role/authorize' :'/system/role/update' }"
		class="pageForm required-validate">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<ul id="treeDemo1" class="ztree"></ul>
			<!-- 角色id -->
			<input type="hidden" name="rid" value="${requestScope.rid}">
			<!--权限id -->
			
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/ztree/js/jquery.ztree.excheck.min.js"></script>
<script>
	var zTreeObj;

	var selectedid;

	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : 0
			}
		},
		callback : {
			onClick : zTreeOnClick
		},
		check : {
			enable : true,
			chkStyle : "checkbox",
			chkboxType : {
				"Y" : "ps",
				"N" : "s"
			}
		}
	};
	function zTreeOnClick(event, treeId, treeNode) {
		selectedid = treeNode.id;
	};

	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	//json
	var zNodes = ${zNodes};
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#treeDemo1", $.pdialog.getCurrent()), setting, zNodes);
	});
	
	$("form", $.pdialog.getCurrent()).submit(function(){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo1");//获取树状图的实例
		var nodes = treeObj.getCheckedNodes();//获取选择的节点
		for(var i = 0 ; i<nodes.length ;i++){
			$(this).append('<input type="hidden" name="pid" value="'+nodes[i].id+'">');
		}
		return validateCallback(this, dialogAjaxDone);
	});
	
	
</SCRIPT>
