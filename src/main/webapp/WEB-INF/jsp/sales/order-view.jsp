<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<c:if test="${ empty order}">
		<div class="alert-info">Order number not found</div>
	</c:if>
	<c:if test="${not empty order}">
		<div class="panel panel-primary">
			<div class="panel-heading">Order Details [${order.orderId}]</div>
			<div class="panel-body">
				<table class="table table-responsive table-stripped">
					<tbody>
						<tr>
							<td>Order ID</td>
							<td>${order.orderId}</td>
						</tr>
						<tr>
							<td>Date Created</td>
							<td>${order.dateAdded}</td>
						</tr>
						<tr>
							<td>Total amount: $</td>
							<td>${order.total}</td>
						</tr>
						<tr>
							<td>Order status</td>
							<td><c:if test="${order.completed}">
								Completed
								</c:if> <c:if test="${not order.completed}">
								Canceled
								</c:if></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">
				<table class="table table-responsive">
					<thead>
						<tr>
							<th>Product Code</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>unit Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="{$order.items}" var="item">
							<tr>
								<td>${item.product.productCode}</td>
								<td>${item.product.name}</td>
								<td>${item.quantity}</td>
								<td>${item.product.sellingPrice}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp"%>
