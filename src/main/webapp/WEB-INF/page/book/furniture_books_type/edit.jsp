<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/book/furniture_books_type/insert' :'/book/furniture_books_type/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>类型：</label> <input name="type" class="required" maxlength="50" type="text" value="${requestScope.record.type }" />
			</p>

			<p>
				<label>名字：</label> <input name="name" class="required" type="text" maxlength="50" value="${requestScope.record.name}"  />
			</p>
			<p>
				<label>品牌/出版社：</label> <input name="brand" class="required" type="text" maxlength="50" value="${requestScope.record.brand}"  />
			</p>
			
			<p>
				<label>国际编号：</label> <input name="intlcode" class="required" maxlength="50" type="text" value="${requestScope.record.intlcode }" />
			</p>
			<p>
				<label>备注：</label> <input name="remarks" class="required" type="text" maxlength="50" value="${requestScope.record.remarks}"  />
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
