<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/system/permission/insert' :'/system/permission/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="150">
			<input name="pid" type="hidden" value="${requestScope.pid }" />
			<input name="level" type="hidden" value="${requestScope.level }"/>
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>权限名：</label> <input name="name" class="required" maxlength="50" type="text" value="${requestScope.record.name }" placeholder="权限名" />
			</p>
			<p>
				<label>权限：</label> <input name="url" class="required" maxlength="500" type="text" value="${requestScope.record.url }" placeholder="权限" />
			</p>
			<p>
				<label>备注：</label> <input name="remarks" class="required" maxlength="200" type="text" value="${requestScope.record.remarks }" placeholder="备注" />
			</p>
			<p>
				<label>排序：</label> <input name="sort" class="required" maxlength="10" type="text" value="${requestScope.record.sort }" placeholder="排序" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
