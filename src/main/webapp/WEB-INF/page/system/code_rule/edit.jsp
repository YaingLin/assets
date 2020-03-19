<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/system/code_rule/insert' :'/system/code_rule/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>

			<p>
				<label>流水类型名：</label> <input name="name" class="required" maxlength="50" type="text" value="${requestScope.record.name }" placeholder="流水类型名" />
			</p>
			<p>
				<label>流水编码规则表：</label> <input name="rule" class="required" maxlength="50" type="text" value="${requestScope.record.rule }" placeholder="流水编码规则表" />
			</p>
			<p>
				<label>当前流水号：</label> <input name="current" class="required" maxlength="300" type="text" value="${requestScope.record.current }" placeholder="当前流水号" />
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
