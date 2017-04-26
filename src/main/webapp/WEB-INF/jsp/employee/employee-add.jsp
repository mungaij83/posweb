<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
	<c:if test="${not empty message}">
		<div class="alert alert-info">${message}</div>
	</c:if>

	<form class="form-horizontal" action="/employee/add" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Customer Registration form</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="firstName">First
					Name</label>
				<div class="col-md-5">
					<input id="firstName" name="firstName" placeholder=""
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="lastName">Last
					Name</label>
				<div class="col-md-5">
					<input id="lastName" name="lastName" placeholder=""
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">Email
					Address</label>
				<div class="col-md-5">
					<input id="email" name="email" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="phoneNumber">Phone
					Number</label>
				<div class="col-md-5">
					<input id="phoneNumber" name="phoneNumber" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="address">Address</label>
				<div class="col-md-5">
					<input id="address" name="address" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="role">Employee
					Role</label>
				<div class="col-md-5">
					<select id="role" name="role" class="form-control">
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="register"></label>
				<div class="col-md-4">
					<button id="register" name="register" class="btn btn-success">Register
						Employee</button>
				</div>
			</div>

		</fieldset>
	</form>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp"%>
