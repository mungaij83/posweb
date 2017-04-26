<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<c:if test="${ empty orders}">
		<div class="alert-info">No orders placed</div>
	</c:if>
	<c:if test="${not empty orders}">

		<table class="table table-responsive table-stripped">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Date created</th>
					<th>Total</th>
					<th>Order status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.dateAdded}</td>
						<td>${order.total}</td>
						<td><c:if test="${order.completed}">
								Completed
								</c:if> <c:if test="${not order.completed}">
								Canceled
								</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp"%>