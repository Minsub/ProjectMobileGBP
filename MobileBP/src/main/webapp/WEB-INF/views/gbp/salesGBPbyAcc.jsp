<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function eventLeftSwipe() {
		//$("#grid").submit();
		//$.get("salesGBP", { week: "38", diff: "1" })
	}
</script>
<div>
	<h3>byAccount (${trade}/${bound}/${route})</h3>
	
	<form class="form-inline" id="grid" name="grid" method="post" action="salesGBP">
		<table class="table table-hover">
			<tr>
	            <th class="head_week" colspan="2" >Account</th>
				<th class="head_week col_wk1" colspan="2" >${week1}</th>
				<th class="head_week col_wk2" colspan="2" >${week2}</th>
				<th class="head_week col_wk3" colspan="2" >${week3}</th>
	        </tr> 
			<tr>
				<th>Code</th>
				<th>Description</th>
				<!-- Week1 -->
				<th class="col_wk1">BKG</th>
				<th class="col_wk1">BP</th>
				<!-- Week2 -->
				<th class="col_wk2">BKG</th>
				<th class="col_wk2">BP</th>
				<!-- Week3 -->
				<th class="col_wk3">BKG</th>
				<th class="col_wk3">BP</th>
	        </tr> 
			<c:forEach var="item" items="${items}">
	            <tr>
	            	<td> <c:out value="${item.acc}" /></td>
	            	<td> <c:out value="${item.desc}" /></td>
	                <!-- week1 --> 
	                <td class="col_wk1 col_bkg"> <c:out value="${item.wk1_bkg}" /></td> 
	                <td class="col_wk1 col_bp"> <c:out value="${item.wk1_bp}" /></td> 
	                <!-- week2 --> 
	                <td class="col_wk2 col_bkg"> <c:out value="${item.wk2_bkg}" /></td> 
	                <td class="col_wk2 col_bp"> <c:out value="${item.wk2_bp}" /></td> 
	                <!-- week3 --> 
	                <td class="col_wk3 col_bkg"> <c:out value="${item.wk3_bkg}" /></td> 
	                <td class="col_wk3 col_bp"> <c:out value="${item.wk3_bp}" /></td> 
	            </tr>   
	        </c:forEach>
	    </table>
	</form>
</div>	
