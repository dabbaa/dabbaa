<div id="wrapper" class="active">
	<div id="sidebar-wrapper">
		<ul id="sidebar_menu" class="sidebar-nav">
			<li class="sidebar-brand"><a id="menu-toggle" href="#">Menu<span id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
		</ul>
		<ul class="sidebar-nav" id="sidebar">
			<li class="sidebar-brand"><a href="#"> ARP Enterprises </a></li>
			<li><a href="#">Dashboard<span class="sub_icon glyphicon glyphicon-glass"></span></a></li>
			<li><a href="#">Reports<span class="sub_icon glyphicon glyphicon-signal"></span></a></li>
			<li><a href="#">Employees<span class="sub_icon glyphicon glyphicon-th"></span></a></li>
			<li><a href="#">Salary<span class="sub_icon glyphicon glyphicon-euro"></span></a></li>
			<li><a href="#">Attendance<span class="sub_icon glyphicon glyphicon-calendar"></span></a></li>
			<li><a href="#">Inventory<span class="sub_icon glyphicon glyphicon-list-alt"></span></a></li>
			<li><a href="#">Orders<span class="sub_icon glyphicon glyphicon-shopping-cart"></span></a></li>
			<li><a href="#">Clients<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
			<li><a href="#">Users<span class="sub_icon glyphicon glyphicon-user"></span></a></li>
			<li><a href="ConfigurationMaster">Config Master Management<span class="sub_icon glyphicon glyphicon-user"></span></a></li>
		</ul>
	</div>

</div>

<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("active");
	});
</script>