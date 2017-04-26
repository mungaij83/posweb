<%@include file="/WEB-INF/jsf/header.jsp"%>
<div class="container-fluid">
	<p>Add new category of products to the inventory.</p>
	<form class="form-horizontal" method="post" action="/category/add">
		<fieldset>
			<!-- Form Name -->
			<legend class="text-center">Form Name</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Category
					Name</label>
				<div class="col-md-5">
					<input id="name" name="name" type="text" placeholder="Name"
						class="form-control input-md">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="description">Category
					Description(Optional)</label>
				<div class="col-md-4">
					<textarea class="form-control" id="description" name="description"></textarea>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<button id="submit" name="submit" class="btn btn-success">Add</button>
				</div>
			</div>

		</fieldset>
	</form>

</div>

<%@include file="/WEB-INF/jsf/footer.jsp"%>
