<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}${requestScope.record ==null ?'/book/furniture_book/insert' :'/book/furniture_book/update' }" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			
			<p>
				<label>品牌/出版社：</label> 
				<select class="select" size="1" name="fbtid">
							    <option value="">请选择</option>
							    <c:forEach items="${requestScope.product_types}" var="recode">
									<option value="${recode.id }" ${requestScope.record.fbtid==recode.id?'selected':'' }>${recode.brand }</option>
								</c:forEach>
				</select>
			</p>
			<p>
				<label>家具图书流水号：</label> <input name="code" class="required" maxlength="50" type="text" value="${requestScope.record.code }" />
			</p>
			<p>
				<label>姓名：</label> <input name="name" class="required" maxlength="50" type="text" value="${requestScope.record.name }" />
			</p>
				
			<p>
				<label>状态：</label> <input name="status" class="required" type="text" maxlength="50" value="${requestScope.record.status}"  />
			</p>
			<p>
				<label>净残值率：</label> <input name="residualrate" class="required" type="text" maxlength="3" value="${requestScope.record.residualrate}"  />
			</p>
			<p>
				<label>使用年限：</label> <input name="useyear" class="required" type="text" maxlength="2" value="${requestScope.record.useyear}"  />
			</p>
			<p>
				<label>净值：</label> <input name="residual" class="required" type="text" maxlength="16" value="${requestScope.record.residual}"  />
			</p>
			<p>
				<label>原值：</label> <input name="original" class="required" type="text" maxlength="16" value="${requestScope.record.original}"  />
			</p>
			
			<p>
				<label>生产日期：</label> <input type="text" name="proddate" class="required date" value="${requestScope.record.proddate}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>

			<p>
				<label>登记人：</label> <input type="text" name="creator" class="required"  value="${requestScope.record.creator}" />
			</p>
			<p>
				<label>登记时间：</label> <input type="text" name="createtime" class="required date" value="${requestScope.record.createtime}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>购买人：</label> <input name="buyer" class="required" type="text" maxlength="50" value="${requestScope.record.buyer}"  />
			</p>
			<p>
				<label>购买日期：</label> <input type="text" name="bugdate" class="required date" value="${requestScope.record.bugdate}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>序列号：</label> <input name="sno" class="required" type="text" maxlength="50" value="${requestScope.record.sno}"  />
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
