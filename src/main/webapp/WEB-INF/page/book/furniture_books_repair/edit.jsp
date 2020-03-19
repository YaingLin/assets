<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/book/furniture_books_repair/insert' :'/book/furniture_books_repair/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>流水号：</label> 
				<select class="select" size="1" name="fbid">
							    <option value="">请选择</option>
							    <c:forEach items="${requestScope.product_types}" var="recode">
									<option value="${recode.id }" ${requestScope.record.fbid==recode.id?'selected':'' }>${recode.code }</option>
								</c:forEach>
				</select>
			</p>
			<p>
				<label>报修人：</label> <input name="damager" class="required" maxlength="50" type="text" value="${requestScope.record.damager }" />
			</p>

			<p>
				<label>报修时间：</label> <input type="text" name="damagedate" class="required date" value="${requestScope.record.damagedate}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>报修备注：</label> <input name="damageremarks" class="required" type="text" maxlength="50" value="${requestScope.record.damageremarks}"  />
			</p>
			
			<p>
				<label>维修时间：</label> <input type="text" name="repairdate" class="required date" value="${requestScope.record.repairdate}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>维修人：</label> <input name="repairer" class="required" maxlength="50" type="text" value="${requestScope.record.repairer }" />
			</p>
			<p>
				<label>维修备注：</label> <input name="repairremarks" class="required" type="text" maxlength="50" value="${requestScope.record.repairremarks}"  />
			</p>
			<p>
				<label>状态：		</label> <input name="status" class="required" type="text" maxlength="50" value="${requestScope.record.status}"  />
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
