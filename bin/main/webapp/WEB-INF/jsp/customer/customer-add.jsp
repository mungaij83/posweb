<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
	<c:if test="${not empty message}">
		<div class="alert alert-info">${message}</div>
	</c:if>
	<form class="form-horizontal" action="/customer/add" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend class="text-center">Customer Registration form</legend>

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
				<label class="col-md-4 control-label" for="customerEmail">Email
					Address</label>
				<div class="col-md-5">
					<input id="customerEmail" name="customerEmail" placeholder=""
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

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="cardNumber">Card
					Number</label>
				<div class="col-md-5">
					<input id="cardNumber" name="creditCard" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="expireDate">Expire
					Date</label>
				<div class="col-md-5">
					<input id="expire_date" name="expireDate" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="csv">CSV </label>
				<div class="col-md-5">
					<input id="csv" name="csv" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="register"></label>
				<div class="col-md-4">
					<button id="register" name="register" class="btn btn-success">Register
						Customer</button>
				</div>
			</div>

		</fieldset>
	</form>

</div>

<%@include file="/WEB-INF/jsf/footer.jsp"%>
