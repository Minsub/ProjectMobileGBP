<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	
	function eventLeftSwipe() {
		document.getElementById("diff").value = "1";
		document.getElementById("grid").submit();
	}
	function eventRightSwipe() {
		document.getElementById("diff").value = "-1";
		document.getElementById("grid").submit();
		
	}
</script>
<div>
	<h3>by Route ${week}</h3>
	
	<form class="form-inline" id="grid" id="grid" method="GET" action="salesGBP">
		<table class="table table-hover">
			<input type="hidden" name="week" value="${week1}" />
			<input type="hidden" id="diff" name="diff" value="1" />
		
			<tr>
	            <th rowspan="2" >Trade</th>
				<th rowspan="2" >Bound</th>
				<th rowspan="2" >Route</th>
				<th class="head_week col_wk1" colspan="3" >${week1}</th>
				<th class="head_week col_wk2" colspan="3" >${week2}</th>
				<th class="head_week col_wk3" colspan="3" >${week3}</th>
	        </tr> 
			<tr>
				<!-- Week1 -->
				<th class="col_wk1">ALLO.</th>
				<th class="col_wk1">BKG</th>
				<th class="col_wk1">BP</th>
				<!-- Week2 -->
				<th class="col_wk2">ALLO.</th>
				<th class="col_wk2">BKG</th>
				<th class="col_wk2">BP</th>
				<!-- Week3 -->
				<th class="col_wk3">ALLO.</th>
				<th class="col_wk3">BKG</th>
				<th class="col_wk3">BP</th>
	        </tr> 
			<c:forEach var="item" items="${items}">
	            <tr>
	            	<td> <c:out value="${item.trade}" /></td>
	            	<td> <c:out value="${item.bound}" /></td>
	                <td> <a href="/cntr/gbp/salesGBPbyAcc?trade=<c:out value="${item.trade}"/>&bound=<c:out value="${item.bound}"/>&route=<c:out value="${item.route}"/>&week=<c:out value="${week1}"/>"><c:out value="${item.route}" /></a></td>
	                <!-- week1 --> 
	                <td class="col_wk1 col_allo"> <c:out value="${item.wk1_alo}" /></td> 
	                <td class="col_wk1 col_bkg"> <c:out value="${item.wk1_bkg}" /></td> 
	                <td class="col_wk1 col_bp"> <c:out value="${item.wk1_bp}" /></td> 
	                <!-- week2 --> 
	                <td class="col_wk2 col_allo"> <c:out value="${item.wk2_alo}" /></td> 
	                <td class="col_wk2 col_bkg"> <c:out value="${item.wk2_bkg}" /></td> 
	                <td class="col_wk2 col_bp"> <c:out value="${item.wk2_bp}" /></td> 
	                <!-- week3 --> 
	                <td class="col_wk3 col_allo"> <c:out value="${item.wk3_alo}" /></td> 
	                <td class="col_wk3 col_bkg"> <c:out value="${item.wk3_bkg}" /></td> 
	                <td class="col_wk3 col_bp"> <c:out value="${item.wk3_bp}" /></td> 
	            </tr>   
	        </c:forEach>
	    </table>
	</form>
</div>	
