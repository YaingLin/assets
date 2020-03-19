<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/system/user/insert' :'/system/user/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>姓名：</label> <input name="name" class="required" maxlength="50" type="text" value="${requestScope.record.name }" placeholder="请输入姓名" />
			</p>
			<p>
			<label>隶属：</label> 
			<select class="conbox" name="ogid" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.organization}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.ogid?'selected':''}>${item.name}</option>
					</c:forEach>
			</select>
			</p>
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
				<label>密码：</label> <input name="pwd" class="required" type="text" maxlength="50" value="${requestScope.record.pwd}" placeholder="请输入密码" />
			</p>
			<p>
				<label>性别：</label> <input type="radio" name="sex" value="1" ${requestScope.record.sex==1 ? 'checked="checked"' :'' } />男 <input type="radio" name="sex" value="2"
					${requestScope.record.sex==2 ? 'checked="checked"' :'' } />女
			</p>
			<p>
				<label>生日：</label> <input type="text" name="birth" readonly="readonly" class="required date" value="${requestScope.record.birth}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>

			<p>
				<label>手机：</label> <input type="text" name="phone" class="required phone" placeholder="请输入手机" value="${requestScope.record.phone}" />
			</p>
			<p>
				<label>邮件：</label> <input type="text" name="email" class="required email" maxlength="500" placeholder="请输入邮件" value="${requestScope.record.email}" />
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
