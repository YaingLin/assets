<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">

<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/system/permission/list" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/WEB-INF/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>权限名：<input type="text" name="name" value="${requestScope.name}" size="30" placeholder="权限名" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">查询</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<shiro:hasPermission name="/system/permission/toInsert">
			<li><a class="add" href="${pageContext.request.contextPath}/system/permission/toInsertRoot" target="ajax" rel="jbsxBox" mask="true" ><span>添加根节点</span></a></li>
			<li><a class="add" onclick="add('${pageContext.request.contextPath}/system/permission/toInsert')" href="javascript:;" mask="true"><span>添加子节点</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="/system/permission/toUpdate">
			<li><a class="edit" onclick="update('${pageContext.request.contextPath}/system/permission/toUpdate')" href="javascript:;" warn="请选择一条记录" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="/system/permission/delete">
			<li><a class="delete" onclick="del('${pageContext.request.contextPath}/system/permission/delete')" href="javascript:;" title="确定要删除吗？" warn="请选择一条记录" mask="true"><span>删除</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/system/permission/delete" target="selectedTodo" rel="id" title="确定要删除吗？" warn="请最小选择一条记录" mask="true"><span>批量删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<div>
	
				<div layoutH="146" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <ul id="treeDemo" class="ztree"></ul>
				</div>
				
				<div id="jbsxBox" class="unitBox" style="margin-left:246px;">
					<!--#include virtual="list1.html" -->
				</div>
	
			</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">
var setting = {
		 check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y" : "ps", "N" : "ps" }
		}, 
		data: {
			simpleData: {
				enable: true
			}
		},callback:{
			onClick:zTreeOnClick
		}};
//节点
var selectedId;
var selectedLevel;
function zTreeOnClick(event, treeId, treeNode) {
	selectedId=treeNode.id;
	selectedLevel=treeNode.level;
};
function add(url){
	//请求到某个地址
	$("#jbsxBox", navTab.getCurrentPanel()).loadUrl(url+"?pid="+selectedId+"&level="+selectedLevel,null,null);
};
function update(url){
	//请求到某个地址
	$("#jbsxBox", navTab.getCurrentPanel()).loadUrl(url+"?id="+selectedId+"&level="+selectedLevel,null,null);
};
function del(url){
	alertMsg.confirm("是否确认删除数据",{
		okCall:function(){//提示框确认时调用
			//请求后台删除数据
			ajaxTodo(url+"?id="+selectedId);
		}
	});
};
//zNodes就是后台获取的数据内容
var zNodes =${requestScope.json};

$(document).ready(function(){
	//ztree初始化  ztree 设置参数
	$.fn.zTree.init($("#treeDemo",	navTab.getCurrentPanel()), setting, zNodes);
});
</script>