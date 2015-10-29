<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<tiles:insertDefinition name="defaultTemplate">
	 <tiles:putAttribute name="menu">
        <div id="wrapper" class="active">
			<div id="sidebar-wrapper">
				<ul id="sidebar_menu" class="sidebar-nav">
					<li class="sidebar-brand">Config Master Tables</li>
				</ul>
				<ul class="sidebar-nav" id="sidebar">
				<c:forEach var="master" items="${listMasters}">
		        	<li><a href="#" ng-click="getMasterData('${master.masterName}')">${master.masterName}</a></li>
				</c:forEach>
				</ul>
			</div>	
		</div>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="body">
		    <div>
			  <strong>Data Length:</strong> {{ gridOptions.data.length | number }}
			  <br>
			  <strong>Last Cell Edited:</strong> {{msg.lastCellEdited}}
			  <br>
			  <button type="button" id="addData" class="btn btn-success" ng-click="addNewRecord()">Add New Record</button>
			  <button type="button" id="saveData" class="btn btn-success" ng-click="saveGridData()">Save</button>
			  <div ui-grid="gridOptions" ui-grid-edit ui-grid-cellnav class="grid"></div>
			</div>
        </div>
   		<script src="<c:url value="/resources/script/app.js" />"></script>
   		<script src="<c:url value="/resources/script/GridColumnDef.js" />"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>
