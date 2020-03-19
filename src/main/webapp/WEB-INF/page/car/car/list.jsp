<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);"
		action="${pageContext.request.contextPath}/car/car/list"
		method="post">
		<!-- 分页表单参数 -->
		<%@include file="/WEB-INF/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>姓名：<input type="text" name="name"
						value="${requestScope.dwzPageBean.countResultMap.name}" size="30"
						alt="姓名" />
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
			<li><a class="add"
				href="${pageContext.request.contextPath}/car/car/toInsert"
				rel="insert" target="dialog" mask="true"><span>添加</span></a></li>
			<li><a class="edit"
				href="${pageContext.request.contextPath}/car/car/toUpdate?id={id}"
				rel="update" target="dialog" warn="请选择一条记录" mask="true"><span>修改</span></a></li>
			<li><a class="delete"
				href="${pageContext.request.contextPath}/car/car/delete?id={id}"
				target="ajaxTodo" title="确定要删除吗？" warn="请选择一条记录" mask="true"><span>删除</span></a></li>
			<li><a class="delete"
				href="${pageContext.request.contextPath}/car/car/delete"
				target="selectedTodo" rel="id" title="确定要删除吗？" warn="请最小选择一条记录"
				mask="true"><span>批量删除</span></a></li>

		</ul>
	</div>
	<table class="table" targetType="navTab" asc="asc" desc="desc"
		width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="id"
					class="checkboxCtrl"></th>
				<th>车辆类型名字</th>
				<th>车辆流水号</th>
				<th>净残值率</th>
				<th>使用年限</th>
				<th>净值</th>
				<th>原值</th>
				<th>状态</th>
				<th>生产日期</th>
				<th>登记人</th>
				<th>登记时间</th>
				<th>购买人</th>
				<th>购买日期</th>
				<th>序列号</th>
				<th>创建时间</th>
				<th>修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:if
				test="${requestScope.dwzPageBean != null &&  requestScope.dwzPageBean.recordList != null }">
				<c:forEach var="record"
					items="${requestScope.dwzPageBean.recordList}" varStatus="status">
					<tr target="id" rel="${record.id}">
						<td><input name="id" value="${record.id}" type="checkbox"></td>
						<td>${record.name }</td>
						<td>${record.code }</td>
						<td>${record.residualrate }</td>
						<td>${record.useyear }</td>
						<td>${record.residual }</td>
						<td>${record.original }</td>
						<td>
							<c:if test="${record.status==1}">
								入库 
							</c:if> <c:if test="${record.status==2}">
								出库中 
							</c:if> <c:if test="${record.status==3}">
								出库 
							</c:if> <c:if test="${record.status==4}">
								领用
							</c:if> <c:if test="${record.status==5}">
								报修
							</c:if></td>
						<td>${record.proddate }</td>
						<td>${record.creatorName }</td>
						<td>${record.createtime }</td>
						<td>${record.buyerName }</td>
						<td>${record.bugdate }</td>
						<td>${record.sno }</td>
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