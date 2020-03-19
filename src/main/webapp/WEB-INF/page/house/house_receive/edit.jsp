<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/house/house_receive/insert' :'/house/house_receive/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="ohid" value="${requestScope.ohid}">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
			<label>房屋位置：</label> 
			<select class="conbox" name="hid" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.house}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.hid?'selected':''}>${item.address}</option>
					</c:forEach>
			</select>
			</p>
			<p>
			<label>所属单位：</label> 
			<select class="conbox" name="oid" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.organization}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.oid?'selected':''}>${item.name}</option>
					</c:forEach>
			</select>
			</p>
			<p>
			<label>登记人：</label> 
			<select class="conbox" name="creator" >
				<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.creator?'selected':''}>${item.name}</option>
					</c:forEach>
			</select>
			</p>
			<p>
				<label>使用期限：</label> 
				<input type="text" name="service_life" readonly="readonly" class="required date" value="${requestScope.record.service_life}" />
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>备注：</label> <input name="remarks" class="required" maxlength="200" type="text" value="${requestScope.record.remarks }" placeholder=备注 />
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
