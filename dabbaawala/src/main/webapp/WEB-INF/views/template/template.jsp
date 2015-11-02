<!DOCTYPE html>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--css plugins-->
	<link rel="stylesheet" href="<c:url value="/resources/style/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/resources/style/ui-grid-unstable.css"/>" />
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid-unstable.css" type="text/css">
    <!--css custom-->
    <link rel="stylesheet" href="<c:url value="/resources/style/simple-sidebar.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/style/style.css" />" />
    
    <!--script plugins-->
	<script src="<c:url value="/resources/script/jquery.min.js"/>" ></script>
    <script src="<c:url value="/resources/script/bootstrap.min.js"/>" ></script>
	<script src="<c:url value="/resources/script/angular.js"/>" ></script>
    <script src="<c:url value="/resources/script/angular-touch.js"/>" ></script>
    <script src="<c:url value="/resources/script/angular-animate.js"/>" ></script>
    <script src="<c:url value="/resources/script/csv.js"/>" ></script>
    <script src="<c:url value="/resources/script/pdfmake.js"/>" ></script>
    <script src="<c:url value="/resources/script/vfs_fonts.js"/>" ></script>
    <script src="<c:url value="/resources/script/ui-grid-unstable.js"/>" ></script>
    
    <!--script custom-->
</head>
<style>
body {
        margin:0px;
        padding:0px;
        height:100%;
        overflow:hidden;
    }
 
    .page {
        min-height:100%;
        position:relative;
    }
     
    .header {
        padding:10px;
        width:100%;
        text-align:center;
    }
     
    .content {
            padding:10px;
            padding-bottom:20px; /* Height of the footer element */
            overflow:hidden;
    }
     
    .menu {
        padding:50px 10px 0px 10px;
        width:200px;
        float:left;
    }
 
    .body {
        margin:50px 10px 0px 250px;
    }
     
    .footer {
        clear:both;
        position:absolute;
        bottom:0;
        left:0;
        text-align:center;
        width:100%;
        height:20px;
    }
</style>

<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content" ng-app="app">
         	<div class="content" ng-controller="MasterDataCtrl">
            <tiles:insertAttribute name="menu" />
            <tiles:insertAttribute name="body" />
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>