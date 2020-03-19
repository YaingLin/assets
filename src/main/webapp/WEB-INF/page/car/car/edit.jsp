<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${pageContext.request.contextPath}${requestScope.record ==null ?'/car/car/insert' :'/car/car/update' }"
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
				<label>车辆类型：</label> <select class="conbox" name="ctid">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.car_type}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.ctid?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
			</p>

			<p>
				<label>序列号：</label> <input name="sno" class="required" type="text"
					maxlength="32" value="${requestScope.record.sno}"
					placeholder="请输入车辆序列号" />
			</p>
			<p>
				<label>净残值率：</label> <input name="residualrate" class="required"
					type="text" maxlength="3"
					value="${requestScope.record.residualrate}" placeholder="请输入净残值率" />
			</p>
			<p>
				<label>原值：</label> <input name="original" class="required"
					type="text" maxlength="16" value="${requestScope.record.original}"
					placeholder="请输入原价" />
			</p>
			<p>
				<label>净值：</label> <input name="residual" class="required"
					type="text" maxlength="16" value="${requestScope.record.residual}"
					placeholder="请输入净值" />
			</p>
			<p>
				<label>状态：</label> 
				<input type="radio" name="status" value="1" ${requestScope.record.status==1 ? 'checked="checked"' :'' } />入库
				<input type="radio" name="status" value="2" ${requestScope.record.status==2 ? 'checked="checked"' :'' } />出库中
				<input type="radio" name="status" value="3" ${requestScope.record.status==3 ? 'checked="checked"' :'' } />出库
				<input type="radio" name="status" value="4" ${requestScope.record.status==4 ? 'checked="checked"' :'' } />领用
				<input type="radio" name="status" value="5" ${requestScope.record.status==5 ? 'checked="checked"' :'' } />报修
			</p>
			<p>
				<label>登记人：</label> <select class="conbox" name="creator">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.creator?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>使用年限：</label> <input name="useyear" class="required"
					type="text" maxlength="2" value="${requestScope.record.useyear}"
					placeholder="请输入使用年限" />
			</p>
			<p>
				<label>生产日期：</label> <input type="text" name="proddate"
					class="required date" value="${requestScope.record.proddate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>购买日期：</label> <input type="text" name="bugdate"
					class="required date" value="${requestScope.record.bugdate}" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>购买人：</label> <select class="conbox" name="buyer">
					<option value="">请选择</option>
					<c:forEach items="${requestScope.user}" var="item">
						<option value="${item.id}"
							${item.id==requestScope.record.buyer?'selected':''}>${item.name}</option>
					</c:forEach>
				</select>
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
