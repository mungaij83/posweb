<%@include file="/WEB-INF/jsf/header.jsp"%>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 top-bar">
			<ul class="nav nav-pills">
				<li class="active"><a href="/employee/add">New Employee</a></li>
				<li><a data-toggle="tab" href="">Active</a></li>
				<li><a data-toggle="tab" href="">Deleted</a></li>
				<li><a data-toggle="tab" href="">Deleted</a></li>
			</ul>
		</div>
		<div class="col-md-8 search-bar">
			<input type="text" class="form-input input-md">
		</div>
		<div class="col-md-8">
			<c:if test="${not empty employees}">
				<table class="table table-responsive table-stripped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							
							<th>Date Employed</th>
							<th>Email</th>
							<th>Active</th>
							<th>Authentication</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="emp">
							<tr>
								<td>${emp.firstName}</td>
								<td>${emp.lastName}</td>
								<td>${emp.employed}</td>
								<td>${emp.email}</td>
								<c:if test="${emp.active}">
								<td><span class="alert-success">Active</span></td>
								</c:if>
								<c:if test="${not emp.active}">
								<td><span class="alert-dange">Inactive</span></td>
								</c:if>
								<c:if test="${emp.canLogin}">
								<td><span class="alert-success">Can Authenticate</span></td>
								</c:if>
								<c:if test="${not emp.active}">
								<td><span class="alert-success">Cannot Authenticate</span></td>
								</c:if>
								<td><Button>Delete</Button></td>
								<td><button>Update</button></td>
								<td><a href="/category/view/${emp.employeeId}">View</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${not empty employee}">
				<table class="table table-responsive">
					<tbody>
						<tr>
							<td>Name</td>
							<td>${employee.firstName} ${employee.lastName}</td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td>${employee.email}</td>
						</tr>
						<tr>
							<td>Date added</td>
							<td>${employee.employed}</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp" %>
