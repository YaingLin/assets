<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/device/device_type/insert' :'/device/device_type/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>名字：</label> <input name="name" class="required" maxlength="50" type="text" value="${requestScope.record.name }" alt="请输入名字" />
			</p>
			<p>
				<label>品牌：</label> <input name="brand" class="required" maxlength="100" type="text" value="${requestScope.record.brand }" alt="请输入品牌" />
			</p>
			<p>
				<label>国际编号：</label> <input name="intlcode" class="required" maxlength="100" type="text" value="${requestScope.record.intlcode }" alt="请输入国际编号" />
			</p>
			<p>
				<label>型号：</label> <input name="model" class="required" maxlength="100" type="text" value="${requestScope.record.model }" alt="请输入型号" />
			</p>
			<p>
				<label>备注：</label> <input name="remarks" class="required" maxlength="100" type="text" value="${requestScope.record.remarks }" alt="请输入备注" />
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
