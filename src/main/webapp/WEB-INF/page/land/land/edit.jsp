<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/land/land/insert' :'/land/land/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<c:if test="${requestScope.record ==null}">
				<input type="hidden" name="status" value="0"/>
			</c:if>
			<p>
				<label>土地性质：</label> 
				<input name="property" class="required" maxlength="100" type="text" value="${requestScope.record.property }" placeholder="土地性质" />
			</p>
			<p>
				<label>土地位置：</label> 
				<input name="address" class="required" maxlength="100" type="text" value="${requestScope.record.address }" placeholder="土地位置" />
			</p>
			<p>
				<label>土地面积：</label> 
				<input name="area" class="required"  maxlength="10" type="text" value="${requestScope.record.area }" placeholder="土地面积" />
			</p>
			<p>
				<label>使用期限：</label> 
				<input name="service_life" class="required date" type="text" readonly="readonly" value="${requestScope.record.service_life }" placeholder="使用期限" />
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>备注信息：</label> 
				<input name="remarks" class="required" maxlength="200" type="text" value="${requestScope.record.remarks }" placeholder="备注信息" />
			</p>
			<c:if test="${requestScope.record !=null}">
				<p>
				<label>土地状态：</label> 
				<input type="radio" name="status" value="0" ${requestScope.record.status==0 ? 'checked="checked"' :'' } />闲置
				<input type="radio" name="status" value="1" ${requestScope.record.status==1 ? 'checked="checked"' :'' } />已分配
				<input type="radio" name="status" value="2" ${requestScope.record.status==2 ? 'checked="checked"' :'' } />其他
				</p>
			</c:if>
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
