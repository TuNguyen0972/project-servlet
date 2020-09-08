<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<c:url value="/static/admin/js/jquery.nicescroll.js" var="nicescroll"></c:url>
		<script src="${nicescroll}"></script>
		<c:url value="/static/admin/js/scripts.js" var="scriptsjs"></c:url>
		<script src="${scriptsjs}s"></script>
		<!--//scrolling js-->
<c:url value="/static/admin/js/bootstrap.js" var="bootstrapjs"></c:url>
<script src="${bootstrapjs}"> </script>