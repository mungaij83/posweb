<%@include file="/WEB-INF/jsf/header.jsp"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 top-bar">
			<ul class="nav nav-pills">
				<li class="active"><a href="/category/add">New Employee</a></li>
				<li><a data-toggle="tab" href="">Active</a></li>
				<li><a data-toggle="tab" href="">Deleted</a></li>
				<li><a data-toggle="tab" href="">Deleted</a></li>
			</ul>
		</div>
		<div class="col-md-8 search-bar">
			<input type="text" class="form-input input-md">
		</div>
		<div class="col-md-8">
			<c:if test="${not empty customers}">
				<div class="alert-info">Your Customers list</div>
				<table class="table table-responsive table-stripped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Date Registered</th>
							<th>Email</th>
							<th>Active</th>
							<th>Authentication</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customers}" var="cust">
							<tr>
								<td>${cust.firstName}</td>
								<td>${cust.lastName}</td>
								<td>${cust.registered}</td>
								<td>${cust.customerEmail}</td>
								<c:if test="${cust.deleted}">
								<td><span class="alert-success">Active</span></td>
								</c:if>
								<c:if test="${not cust.deleted}">
								<td><span class="alert-dange">Inactive</span></td>
								</c:if>
		
								<td><Button>Delete</Button></td>
								<td><button>Update</button></td>
								<td><a href="/customer/view/${cust.customerId}">View</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${not empty customer}">
				<table class="table table-responsive">
					<tbody>
						<tr>
							<td>Name</td>
							<td>${customer.firstName} ${employee.lastName}</td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td>${customer.customerEmail}</td>
						</tr>
						<tr>
							<td>Date added</td>
							<td>${customer.registered}</td>
						</tr>
					</tbody>
				</table>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp" %>
