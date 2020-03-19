<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/house/house/list" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/WEB-INF/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>房屋位置：<input type="text" name="address" value="${requestScope.address}" size="30" placeholder="房屋位置" />
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
		<shiro:hasPermission name="/house/house/toInsert">
			<li><a class="add" href="${pageContext.request.contextPath}/house/house/toInsert" rel="insert" target="dialog" mask="true"><span>添加</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="/house/house/toUpdate">
			<li><a class="edit" href="${pageContext.request.contextPath}/house/house/toUpdate?id={id}" rel="update" target="dialog" warn="请选择一条记录" mask="true"><span>修改</span></a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="/house/house/delete">
			<li><a class="delete" href="${pageContext.request.contextPath}/house/house/delete?id={id}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一条记录" mask="true"><span>删除</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/house/house/delete" target="selectedTodo" rel="id" title="确定要删除吗？" warn="请最小选择一条记录" mask="true"><span>批量删除</span></a></li>
		</shiro:hasPermission>
		</ul>
	</div>
	<table class="table" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="id" class="checkboxCtrl"></th>
				<th>房屋流水号</th>
				<th>房屋性质</th>
				<th>房屋位置</th>
				<th>屋主</th>
				<th>房屋面积</th>
				<th>使用期限</th>
				<th>备注信息</th>
				<th>房屋状态</th>
				<th>信息录入时间</th>
				<th>修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.dwzPageBean != null &&  requestScope.dwzPageBean.recordList != null }">
				<c:forEach var="record" items="${requestScope.dwzPageBean.recordList}" varStatus="status">
					<tr target="id" rel="${record.id}">
						<td><input name="id" value="${record.id}" type="checkbox"></td>
						<td>${record.code }</td>
						<td>${record.property }</td>
						<td>${record.address }</td>
						<td>${record.uName }</td>
						<td>${record.area }</td>
						<td>${record.service_life }</td>
						<td>${record.remarks }</td>
						<td>
							<c:if test="${record.status==0}">
								闲置
							</c:if>
							<c:if test="${record.status==1}">
								已分配
							</c:if>
							<c:if test="${record.status==2}">
								其他
							</c:if>
						</td>
						<td>${record.crtm }</td>
						<td>${record.mdtm }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/WEB-INF/page/inc/pageBar.jsp"%>
</div>