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
