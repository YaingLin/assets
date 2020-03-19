<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/device/device/insert' :'/device/device/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>设备名称：</label>
			<select class="combox" name="dtid"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.Device_typelist}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.dtid?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<%-- <p>
				<label>设备流水号：</label> <input name="code" class="required" type="text" maxlength="7" value="${requestScope.record.code }" alt="请输入设备流水号" />
			</p> --%>
			<p>
				<label>净残值率：</label> <input name="residualrate" class="required" type="text" value="${requestScope.record.residualrate }" alt="请输入净残值率"  οnkeypress="if((event.keyCode<48 || event.keyCode>57) && event.keyCode!=46 || /\.\d\d{2}$/.test(value))event.returnValue=false"  maxlength="6" />
			</p>
			<p>
				<label>使用年限：</label> <input name="useyear" class="required" type="text"   maxlength="2" value="${requestScope.record.useyear }" alt="请输入使用年限" oninput="this.value=this.value.replace(/[^\-?\d.]/g,'')" />
			</p>

			<p>
				<label>净值：</label>  <input  name="residual" class="required" maxlength="16" type="text" value="${requestScope.record.residual }" alt="请输入净值"  oninput="this.value=this.value.replace(/[^\-?\d.]/g,'')" />
			</p>
			<p>
				<label>原值：</label> <input name="original" class="required" maxlength="16" type="text" value="${requestScope.record.original }" alt="请输入原值" oninput="this.value=this.value.replace(/[^\-?\d.]/g,'')" />
			</p>
			<p>
				<label>状态：</label> <input name="status" class="required" maxlength="32" type="text" value="${requestScope.record.status }" alt="请输入状态" oninput="this.value=this.value.replace(/[^\-?\d.]/g,'')" />
			</p>
			<p>
				<label>生产日期：</label>  <input name="proddate" type="text" maxlength="32" class="required date" value="${requestScope.record.proddate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>登记人：</label>
			<select class="combox" name="creator"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userList}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.creator?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
<%-- 		<p>
				<label>登记人：</label> <input name="creator" class="combox" maxlength="32" type="text" value="${requestScope.record.creator }" alt="请输入登记人" />
			</p> --%>
			<p>
				<label>登记时间：</label>  <input name="createtime" type="text" maxlength="32" class="required date" value="${requestScope.record.createtime }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<%-- <p>
				<label>购买人：</label> <input name="buyer" class="required" maxlength="32" type="text" value="${requestScope.record.buyer }" alt="请输入购买人" />
			</p> --%>
			<p>
				<label>购买人：</label>
			<select class="combox" name="buyer"  >
				<option value="">请选择</option>
				<c:forEach items="${requestScope.userList}" var="item">
						<option value="${item.id}" ${item.id==requestScope.record.buyer?'selected':''}>${item.name}</option>
				</c:forEach>
			</select>
			</p>
			<p>
				<label>购买时间：</label>  <input name="bugdate" type="text" class="required date" maxlength="32" value="${requestScope.record.bugdate }" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>序列号：</label> <input name="sno" class="required" maxlength="32" type="text" value="${requestScope.record.sno }" alt="请输入序列号" οninput="value=value.replace(/[^a-zA-Z0-9]+$/,'')">
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
