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
	<h3>byAccount (${trade}/${bound}/${route})</h3>
	
	<form class="form-inline" id="grid" method="GET" action="salesGBPbyAcc">
		<!-- input parameter -->
		<input type="hidden" name="week" value="${week1}" />
		<input type="hidden" id="diff" name="diff" value="1" />
		<input type="hidden" name="trade" value="${trade}" />
		<input type="hidden" name="bound" value="${bound}" />
		<input type="hidden" name="route" value="${route}" />
		
		
		<table class="table table-hover">
			<tr>
	            <th class="head_week" colspan="2" >Account</th>
				<th class="head_week col_wk1" colspan="2" >${week1}</th>
				<th class="head_week col_wk2" colspan="2" >${week2}</th>
				<th class="head_week col_wk3" colspan="2" >${week3}</th>
	        </tr> 
			<tr>
				<th >Code</th>
				<th >Description</th>
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
	            	<td font-size="12px"> <c:out value="${item.desc}" /></td>
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
