<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/device/device_scrap/insert' :'/device/device_scrap/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>设备id：</label> <input name="did" class="required" type="text" maxlength="30"  value="${requestScope.record.did }" alt="请输入设备id" />
			</p>
			<%-- <p>
				<label>报废人：</label> <input name="scraper" class="required" maxlength="30" type="text" value="${requestScope.record.scraper }" alt="请输入报废人" />
			</p> --%>
			<p>
				<label>报废人：</label>
			<select class="combox" name="scraper"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userlist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.scraper?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>报废日期：</label>  <input name="scrapremarks" type="text" maxlength="30" class="required date" value="${requestScope.record.scrapremarks }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>报废备注：</label> <input name="scrapremarks" class="required" maxlength="200" type="text" value="${requestScope.record.scrapremarks }" alt="请输入报废备注" />
			</p>
			<p>
				<label>状态: 1-申请、2-准许、3-拒绝</label> <input name="status" class="required" maxlength="1" type="text" value="${requestScope.record.status }" alt="请输入状态" />
			</p>
			<%-- <p>
				<label>审批人：</label> <input name="approver" class="required" maxlength="30" type="text" value="${requestScope.record.approver }" alt="请输入审批人" />
			</p> --%>
			<p>
				<label>审批人：</label>
			<select class="combox" name="approver"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userlist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.approver?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>审批意见：</label> <input name="approvalremarks" class="required" maxlength="200" type="text" value="${requestScope.record.approvalremarks }" alt="请输入审批意见" />
			</p>
			<p>
				<label>申请日期：</label>  <input name="approvaldate" type="text" maxlength="30" class="required date" value="${requestScope.record.approvaldate }" /><a class="inputDateButton" href="javascript:;">选择</a>
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
