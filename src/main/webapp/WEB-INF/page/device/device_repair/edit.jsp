<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/device/device_repair/insert' :'/device/device_repair/update' }" class="pageForm required-validate"
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
				<label>报修人：</label> <input name="damager" class="required" type="text" maxlength="307" value="${requestScope.record.damager }" alt="请输入报修人" />
			</p> --%>
			<p>
				<label>报修人：</label>
			<select class="combox" name="damager"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userlist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.damager?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>报修时间：</label>  <input name="damagedate" type="text" class="required date" maxlength="30" value="${requestScope.record.damagedate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>报修备注：</label> <input name="damageremarks" class="required" type="text" maxlength="200" value="${requestScope.record.damageremarks }" alt="请输入报修备注" />
			</p>
			<p>
				<label>维修时间：</label>  <input name="repairdate" type="text" class="required date" maxlength="30" value="${requestScope.record.repairdate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>维修人：</label>
			<select class="combox" name="repairer"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userlist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.repairer?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
<%-- 			<p>
				<label>维修人：</label> <input name="repairer" class="required" type="text" maxlength="30" value="${requestScope.record.repairer }" alt="请输入维修人" />
			</p> --%>
			<p>
				<label>维修备注：</label> <input name="repairremarks" class="required" type="text" maxlength="200" value="${requestScope.record.repairremarks }" alt="请输入维修备注" />
			</p>
			<p>
				<label>状态 1-报修、2-维修：</label> <input name="status" class="required" type="text" maxlength="1" value="${requestScope.record.status }" alt="请输入状态" />
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
