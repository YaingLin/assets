<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>样例管理后台</title>
<jsp:include page="inc/dwz.jsp" />
</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<!-- navMenu begin -->
			<div class="headerNav">
				<img alt="" src="${pageContext.request.contextPath}/statics/images/logo.png" height="50" />
				<ul class="nav">
					<li style="color: black;">欢迎您（${sessionScope.user.name}）！&nbsp;当前时间： <span id="time"></li>
					<li><a href="javascript:" style="color: black;">${userNo}</a></li>
					<!-- 	<li><a href="pms_userViewOwnInfo.action" target="dialog" width="500" height="400" style="color: #fff;">帐号信息</a></li>
                <li><a href="pms_userChangeOwnPwdUI.action" target="dialog" width="550" height="300" style="color: #fff;">修改密码</a></li> -->
					<%--   <li><a href="logout" title="退出登录确认" width="300" height="200" style="color: #fff;">退出</a></li>--%>
					<li><a href="${pageContext.request.contextPath}/toLogout" target="dialog" width="300" height="200" mask="true" style="color: #fff;">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default">
						<div class="selected">蓝色</div>
					</li>
					<li theme="green">
						<div>绿色</div>
					</li>
					<li theme="purple">
						<div>紫色</div>
					</li>
					<li theme="silver">
						<div>银色</div>
					</li>
					<li theme="azure">
						<div>天蓝</div>
					</li>
				</ul>
			</div>
			<!-- navMenu end -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
				
				
					<c:forEach items="${menu}" var="item">
					<c:if test="${item.level==1}">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>${item.name }
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<c:forEach items="${menu}" var="item2">
							<c:if test="${item.id == item2.pid}">
							<li><a href="${pageContext.request.contextPath}${item2.url }" target="navTab" rel="${pageContext.request.contextPath}${item2.url }" fresh="true">${item2.name }</a></li>
							</c:if>
							</c:forEach>
						</ul>
					</div>
					</c:if>
					</c:forEach>




					<div class="accordionHeader">
						<h2>
							<span>Folder</span>设备管理
						</h2>
					</div>
					<div class="accordionContent">						
						<ul class="tree treeFolder">
							<li><a href="${pageContext.request.contextPath}/device/device/list" target="navTab" rel="${pageContext.request.contextPath}/device/device/list" fresh="true">设备明细</a></li>						
							<li><a href="${pageContext.request.contextPath}/device/device_receive/list" target="navTab" rel="${pageContext.request.contextPath}/device/device_receive/list" fresh="true">设备领用</a></li>						
							<li><a href="${pageContext.request.contextPath}/device/device_scrap/list" target="navTab" rel="${pageContext.request.contextPath}/device/device_scrap/list" fresh="true">设备报废</a></li>					
							<li><a href="${pageContext.request.contextPath}/device/device_repair/list" target="navTab" rel="${pageContext.request.contextPath}/device/device_repair/list" fresh="true">设备维修</a></li>						
							<li><a href="${pageContext.request.contextPath}/device/device_type/list" target="navTab" rel="${pageContext.request.contextPath}/device/device_type/list" fresh="true">设备类型</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>家具图书管理
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="${pageContext.request.contextPath}/book/furniture_book/list" target="navTab" rel="${pageContext.request.contextPath}/book/furniture_book/list" fresh="true">家具图书明细</a></li>
							<li><a href="${pageContext.request.contextPath}/book/furniture_books_receive/list" target="navTab" rel="${pageContext.request.contextPath}/book/furniture_books_receive/list" fresh="true">家具图书领用</a></li>
							<li><a href="${pageContext.request.contextPath}/book/furniture_books_repair/list" target="navTab" rel="${pageContext.request.contextPath}/book/furniture_books_repair/list" fresh="true">家具图书维修</a></li>
							<li><a href="${pageContext.request.contextPath}/book/furniture_books_scrap/list" target="navTab" rel="${pageContext.request.contextPath}/book/furniture_books_scrap/list" fresh="true">家具图书报废</a></li>
							<li><a href="${pageContext.request.contextPath}/book/furniture_books_type/list" target="navTab" rel="${pageContext.request.contextPath}/book/furniture_books_type/list" fresh="true">家具图书类型</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>车辆管理
						</h2>
					</div>
					<div class="accordionContent">

						<ul class="tree treeFolder">
							<li><a
								href="${pageContext.request.contextPath}/car/car/list"
								target="navTab"
								rel="${pageContext.request.contextPath}/car/car/list"
								fresh="true">汽车管理</a></li>
						</ul>
						<ul class="tree treeFolder">
							<li><a
								href="${pageContext.request.contextPath}/car/car_receive/list"
								target="navTab"
								rel="${pageContext.request.contextPath}/car/car_receive/list"
								fresh="true">车辆领用管理</a></li>
						</ul>
						<ul class="tree treeFolder">
							<li><a
								href="${pageContext.request.contextPath}/car/car_repair/list"
								target="navTab"
								rel="${pageContext.request.contextPath}/car/car_repair/list"
								fresh="true">车辆维修管理</a></li>
						</ul>
						<ul class="tree treeFolder">
							<li><a
								href="${pageContext.request.contextPath}/car/car_scrap/list"
								target="navTab"
								rel="${pageContext.request.contextPath}/car/car_scrap/list"
								fresh="true">车辆报废管理</a></li>
						</ul>
						<ul class="tree treeFolder">
							<li><a
								href="${pageContext.request.contextPath}/car/car_type/list"
								target="navTab"
								rel="${pageContext.request.contextPath}/car/car_type/list"
								fresh="true">车辆类型管理</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<div class="tabsRight">right</div>
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<p>
								<span>权限管理后台</span>
							</p>
						</div>
						<div class="pageFormContent" layoutH="60" style="margin-right: 230px"></div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2017 JKOSS</div>

</body>
<script type="text/javascript">
	//创建一个日期对象
	function show() {
		var d = new Date();
		//获取年份
		//var nian=d.getYear();//2016  //16
		var nian = d.getFullYear();//2016
		//获取月
		var yue = d.getMonth() + 1;//6   july 7月   0-11
		//获取星期几
		var xq = d.getDay();//5    0-6    0:星期天
		//获取几号
		var dd = d.getDate();//1    1-31
		//获取小时
		var h = d.getHours();// 16下午4点     24小时制
		//获取分钟
		var m = d.getMinutes();//31分
		//获取描述
		var s = d.getSeconds();//50秒
		document.getElementById("time").innerHTML = nian + "-" + yue + "-" + dd + " " + h + ":" + m + ":" + s;
	}
	setInterval("show()", 1000);
</script>
</html>