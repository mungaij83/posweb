<%@include file="/WEB-INF/jsf/header.jsp"%>
<div class="container-fluid">
	<c:if test="${empty transactions}">
		<div class="alert-info">There is no recent transactions</div>
	</c:if>
	<c:if test="${not empty transactions}">
		<table class="table table-responsive table-stripped">
			<thead>
				<tr>
					<th>Payment ID</th>
					<th>Payment Method</th>
					<th>Order ID</th>
					<th>T status</th>
					<td>Amount</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transactions}" var="tran">
					<tr>
						<td>${tran.paymentId }</td>
						<td>${tran.paymentMethod}</td>
						<td>${tran.order.orderId}</td>
						<td>
							<c:if test="${tran.completed}">Completed</c:if>
							<c:if test="${not tran.completed}">Completed</c:if>
						</td>
						<td>${tran.amount}</td>
						<td><a href="/order/view/${tran.order.Id}" class="btn btn-info">View Order</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

<%@include file="/WEB-INF/jsf/footer.jsp"%>
