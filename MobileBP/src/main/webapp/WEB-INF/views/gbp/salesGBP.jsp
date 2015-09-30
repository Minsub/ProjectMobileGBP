<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	/* $(document).ready(function() {  
		$("#mainDiv").swiperight(function() {  
			 alert("rightttt");
	   	});  
		$("#mainDiv").swipeleft(function() {  
			 alert("lefttttt");
	  });  
	});   */
	
	/* $(function(){
	    $("#mainDiv").bind("swipeleft", function(){
	        alert("aaaa");
	    });
	    $("#mainDiv").bind("swiperight", function(){
	    	alert("bbbb");
	    });
	});  */
	
	function eventLeftSwipe() {
		//$("#grid").submit();
		$.post("salesGBP", { week: "38", diff: "1" })
	}
</script>
<div>
	<h3>by Route ${week}</h3>
	
	<form class="form-inline" id="grid" name="grid" method="post" action="">
		<table class="table table-hover">
			<input type="hidden" name="week" value="test" />
			<tr>
	            <td>Trade</td>
				<td>Bound</td>
				<td>Route</td>
				<td>ALLO.</td>
				<td>BKG</td>
				<td>BP</td>
	        </tr> 
			<c:forEach var="item" items="${items}">
	            <tr>
	            	<td align="center" ><c:out value="${item.trade}" /></td>
	            	<td align="center" ><c:out value="${item.bound}" /></td>
	                <td align="center" ><a href="/cntr/gbp/byRoute?route=<c:out value="${item.route}" />"><c:out value="${item.route}" /></a></td> 
	                <td align="center" ><c:out value="${item.wk1_alo}" /></td> 
	                <td align="center" ><c:out value="${item.wk1_bkg}" /></td> 
	                <td align="center" ><c:out value="${item.wk1_bp}" /></td> 
	            </tr>   
	        </c:forEach>
	    </table>
	</form>
</div>	
