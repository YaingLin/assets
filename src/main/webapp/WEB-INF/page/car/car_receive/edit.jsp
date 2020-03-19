<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${pageContext.request.contextPath}${requestScope.record ==null ?'/car/car_receive/insert' :'/car/car_receive/update' }"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			
			<p>
				<label>车辆流水号：</label> <select class="conbox" name="cid">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.car}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.cid?'selected':''}>${item.code}</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>领用人：</label> <select class="conbox" name="recipients">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.recipients?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>领取时间：</label> <input type="text" name="receivedate"
					class="required date" value="${requestScope.record.receivedate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>归还日期：</label> <input type="text" name="returndate"
					class="required date" value="${requestScope.record.returndate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>状态：</label> 
				<input type="radio" name="status" value="1" ${requestScope.record.status==1 ? 'checked="checked"' :'' } />领用
				<input type="radio" name="status" value="2" ${requestScope.record.status==2 ? 'checked="checked"' :'' } />归还
			</p>
			<p>
				<label>领用备注：</label> <input name="receiveremarks" class="required"
					maxlength="200" type="text"
					value="${requestScope.record.receiveremarks }" placeholder="领用备注" />
			</p>
			<p>
				<label>归还备注：</label> <input name="returnremarks" class="required"
					maxlength="200" type="text"
					value="${requestScope.record.returnremarks }" placeholder="归还备注" />
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
