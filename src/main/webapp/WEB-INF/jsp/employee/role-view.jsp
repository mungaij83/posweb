<%@include file="/WEB-INF/jsf/header.jsp"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container-fluid">
		<c:if test="${empty roles}">
			<div class="alert-info">No roles added</div>
		</c:if>
		<c:if test="${ not empty roles}">
			<table class="table table-responsive">
				<thead>
					<tr>
						<th>Name</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>${role.name}</th>
						<td><button id="deleteRole" class="btn btn-danger">Delete</button></td>
						<td><button id="deleteRole" class="btn btn-danger">Update</button></td>
					</tr>
				</tbody>
			</table>
		</c:if>
	</div>
<%@include file="/WEB-INF/jsf/footer.jsp" %>
