<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/device/device_repair/list" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/WEB-INF/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>报修人：<input type="text" name="dname" value="${requestScope.dwzPageBean.countResultMap.damager }" size="30" alt="报修人" />
					</td>
					<td>维修人：<input type="text" name="rname" value="${requestScope.dwzPageBean.countResultMap.repairer }" size="30" alt="维修人" />
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
			<li><a class="add" href="${pageContext.request.contextPath}/device/device_repair/toInsert" rel="insert" target="dialog" mask="true"><span>添加</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/device/device_repair/toUpdate?id={id}" rel="update" target="dialog" warn="请选择一条记录" mask="true"><span>修改</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/device/device_repair/delete?id={id}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一条记录" mask="true"><span>删除</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/device/device_repair/delete" target="selectedTodo" rel="id" title="确定要删除吗？" warn="请最小选择一条记录" mask="true"><span>批量删除</span></a></li>

		</ul>
	</div>
	<table class="table" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="id" class="checkboxCtrl"></th>
				<th>设备名称</th>
				<th>报修人</th>
				<th>报修时间</th>
				<th>报修备注</th>
				<th>维修时间</th>
				<th>维修人</th>
				<th>维修备注</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.dwzPageBean != null &&  requestScope.dwzPageBean.recordList != null }">
				<c:forEach var="record" items="${requestScope.dwzPageBean.recordList}" varStatus="status">
					<tr target="id" rel="${record.id}">
						<td><input name="id" value="${record.id}" type="checkbox"></td>
						<td>${record.did }</th>
						<td>${record.dname }</th>
						<td>${record.damagedate }</th>
						<td>${record.damageremarks }</th>
						<td>${record.repairdate }</th>
						<td>${record.rname }</th>
						<td>${record.repairremarks }</th>
						<td>
							<c:if test="${record.status==1}">
								 报修
							</c:if>
							<c:if test="${record.status==2}">
								维修
							</c:if>
						</th>
						<td>${record.crtm }</th>
						<td>${record.mdtm }</th>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<!-- 分页条 -->
	<%@include file="/WEB-INF/page/inc/pageBar.jsp"%>
</div>