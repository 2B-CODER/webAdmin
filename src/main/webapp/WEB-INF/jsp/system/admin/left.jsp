<%
	String pathl = request.getContextPath();
	String basePathl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathl+"/";
%>
		<!-- 本页面涉及的js函数，都在head.jsp页面中     -->
		<div id="sidebar" class="menu-min">

				<div id="sidebar-shortcuts">

					<div id="sidebar-shortcuts-large">

						<button class="btn btn-small btn-success" onclick="changeMenu();" title="切换菜单"><i class="icon-pencil"></i></button>
						<button class="btn btn-small btn-danger" title="菜单管理" id="adminmenu" onclick="menu();"><i class="icon-folder-open"></i></button>

					</div>

				</div>

				<ul class="nav nav-list">
			<c:forEach items="${menuList}" var="menu">
				<li id="lm${menu.menuId }">
					  <a style="cursor:pointer;" class="dropdown-toggle" >
						<i class="${menu.menuIcon == null ? 'icon-desktop' : menu.menuIcon}"></i>
						<span>${menu.menuName }</span>
						<b class="arrow icon-angle-down"></b>
					  </a>
					  <ul class="submenu">
							<c:forEach items="${menu.subMenu}" var="sub">
								<c:choose>
									<c:when test="${not empty sub.menuUrl}">
									<li id="z${sub.menuId }">
									<a style="cursor:pointer;" target="mainFrame"  onclick="siMenu('z${sub.menuId }','lm${menu.menuId }','${sub.menuName }','${sub.menuUrl }')"><i class="icon-double-angle-right"></i>${sub.menuName }</a></li>
									</c:when>
									<c:otherwise>
									<li><a href="javascript:void(0);"><i class="icon-double-angle-right"></i>${sub.menuName }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
				  		</ul>
				</li>
			</c:forEach>

				</ul><!--/.nav-list-->

				<div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>

			</div><!--/#sidebar-->

