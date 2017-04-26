<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Customer Registration form</legend>
			
			<c:if test="${not empty error}">
				<div class="alert-danger">${error}</div>
			</c:if>
			
			<c:if test="${message}">
				<div class="alert-info">${message}</div>
			</c:if>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Role Name</label>
				<div class="col-md-5">
					<input id="name" name="name" placeholder=""
						class="form-control input-md" required="" type="text">

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
