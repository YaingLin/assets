<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${pageContext.request.contextPath}${requestScope.record ==null ?'/car/car_scrap/insert' :'/car/car_scrap/update' }"
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
				<label>报废人：</label> <select class="conbox" name="scraper">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.scraper?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>报废日期：</label> <input type="text" name="scraperdate"
					class="required date" value="${requestScope.record.scraperdate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>

			<p>
				<label>报废备注：</label> <input name="scrapremarks" class="required"
					maxlength="200" type="text"
					value="${requestScope.record.scrapremarks }" placeholder="请输入报废备注" />
			</p>

 			<p>
				<label>状态：</label> 
				<input type="radio" name="status" value="1" ${requestScope.record.status==1 ? 'checked="checked"' :'' } />申请
				<input type="radio" name="status" value="2" ${requestScope.record.status==2 ? 'checked="checked"' :'' } />准许
				<input type="radio" name="status" value="3" ${requestScope.record.status==3 ? 'checked="checked"' :'' } />拒绝
			</p>

			<p>
				<label>审批人：</label> <select class="conbox" name="approver">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.approver?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>审批意见：</label> <input name="approvalremarks" class="required"
					maxlength="200" type="text"
					value="${requestScope.record.approvalremarks }" placeholder="请输入审批意见" />
			</p>

			<p>
				<label>申请日期：</label> <input type="text" name="approvaldate"
					class="required date" value="${requestScope.record.approvaldate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
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
