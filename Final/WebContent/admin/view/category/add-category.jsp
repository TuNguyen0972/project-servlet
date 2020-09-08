<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">


	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);
	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<c:url value="/static/admin/css/bootstrap.css" var="bootstrap"></c:url>
<link href="${bootstrap}" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<c:url value="/static/admin/css/style.css" var="style"></c:url>
<link href="${style}" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<c:url value="/static/admin/js/jquery-2.1.1.min.js" var="jquery"></c:url>
<script src="${jquery}"></script>
<!--icons-css-->
<c:url value="/static/admin/css/font-awesome.css" var="fontAwesome"></c:url>
<link href="${fontAwesome}" rel="stylesheet">
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css'>
<!--static chart-->
<c:url value="/static/admin/js/Chart.min.js" var="chart"></c:url>
<script src="${chart}"></script>
<!--//charts-->
<!-- geo chart -->
<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
	|| document
		.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<c:url value="/static/admin/js/chartinator.js" var="chartinator"></c:url>
<script src="${chartinator}"></script>
<script type="text/javascript">
	jQuery(function($) {

		var chart3 = $('#geoChart').chartinator(
			{
				tableSel : '.geoChart',

				columns : [ {
					role : 'tooltip',
					type : 'string'
				} ],

				colIndexes : [ 2 ],

				rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
					[ 'France - 2015' ], [ 'Italy - 2015' ],
					[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
					[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
					[ 'Russia - 2015' ], [ 'Spain - 2015' ],
					[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],

				ignoreCol : [ 2 ],

				chartType : 'GeoChart',

				chartAspectRatio : 1.5,

				chartZoom : 1.75,

				chartOffset : [ -12, 0 ],

				chartOptions : {
					width : null,

					backgroundColor : '#fff',

					datalessRegionColor : '#F5F5F5',

					region : 'world',

					resolution : 'countries',

					legend : 'none',

					colorAxis : {
						colors : [ '#679CCA', '#337AB7' ]
					},
					tooltip : {
						trigger : 'focus',

						isHtml : true
					}
				}
			});
	});
</script>
<!--geo chart-->

<!--skycons-icons-->
<c:url value="/static/admin/js/skycons.js" var="skycons"></c:url>
<script src="${skycons}"></script>
<!--//skycons-icons-->
<c:url value="/static/admin/css/add-user.css" var="addUser"></c:url>
<link href="${addUser}" rel="stylesheet" type="text/css" media="all">
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<jsp:include page="/static/include/header-main.jsp"></jsp:include>
				<div class="inner-block">


					<div class="signup-block bg">
						<h2 id="ha">Add Category</h2>
						<c:url value="/admin/category/add" var="addCate"></c:url>
						<form action="${addCate}" method="post" id="ha">
							<label for="exampleInputName">Name</label> 
							<input type="text" name="name" placeholder="Name" required=""> 
							<label for="exampleInputUsername">Description</label> 
							<textarea name="des" placeholder="Description" required="" rows="5" cols="48"></textarea>
							<br>
							<input type="submit" value="Submit"> </br>
						</form>
					</div>
				</div>
				<jsp:include page="/static/include/copyright.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="/static/include/menu.jsp"></jsp:include>
		<div class="clearfix"></div>
	</div>
	<jsp:include page="/static/include/script.jsp"></jsp:include>

</body>
</html>