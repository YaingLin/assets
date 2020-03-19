<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/device/device_receive/insert' :'/device/device_receive/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<%-- <p>
				<label>序列号：</label> <input name="sno" class="required" type="text" maxlength="30"  value="${requestScope.deviceServicelist.sno }" alt="请输入序列号" />
			</p> --%>
			<p>
				<label>序列号：</label>
			<select class="combox" name="did"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.deviceServicelist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.did?'selected':''}>${item.sno}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>单据号：</label> <input name="receipt" class="required" type="text" maxlength="9" value="${requestScope.record.receipt }" alt="请输入单据号" />
			</p>
			<%-- <p>
				<label>领用人：</label> <input name="recipients" class="required" type="text" value="${requestScope.record.recipients }" alt="请输入领用人"  maxlength="30" />
			</p> --%>
			<p>
				<label>领用人：</label>
			<select class="combox" name="recipients"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userlist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.recipients?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>领取时间：</label>  <input name="receivedate" type="text" class="required date" maxlength="32" value="${requestScope.record.receivedate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>归还日期：</label>  <input name="returndate" type="text" class="required date" maxlength="32" value="${requestScope.record.returndate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>状态 1-领用、2-归还：</label> <input name="status" class="required" maxlength="1" type="text" value="${requestScope.record.status }" alt="请输入状态" oninput="this.value=this.value.replace(/[^\-?\d.]/g,'')" />
			</p>
			<p>
				<label>领用备注：</label> <input name="receiveremarks" class="required" maxlength="200" type="text" value="${requestScope.record.receiveremarks }" alt="请输入领用备注"  />
			</p>
			<p>
				<label>归还备注：</label> <input name="returnremarks" class="required" maxlength="200" type="text" value="${requestScope.record.returnremarks }" alt="请输入归还备注"  />
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
