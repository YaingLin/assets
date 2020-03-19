<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/system/role_permission/insert' :'/system/role_permission/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
			<label>职位：</label> 
			<select class="conbox" name="rid" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.role}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.rid?'selected':''}>${item.name}</option>
					</c:forEach>
			</select>
			</p>
			<p>
			<label>权限：</label> 
			<select class="conbox" name="pid" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.permission}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.pid?'selected':''}>${item.name}</option>
					</c:forEach>
			</select>
			</p>
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
