<%@include file="/WEB-INF/jsf/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 top-bar">
			<ul class="nav nav-pills">
				<li class="active"><a href="/category/add">New Category</a></li>
				<li><a data-toggle="tab" href="">Other1</a></li>
				<li><a data-toggle="tab" href="">Other2</a></li>
			</ul>
		</div>

		<div class="col-md-8">
			<c:if test="${not empty categories}">
				<div class="search-bar">
					<input type="text" id="search-bar" class="form-input input-md"
						onkeyup="searchCat()" placeholder="Seach Category">
				</div>
				<table class="table table-responsive table-stripped" id="category">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Date Added</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categories}" var="cat">
							<tr>
								<td>${cat.name}</td>
								<td>${cat.description}</td>
								<td>${cat.dateAdded}</td>
								<td><Button>Delete</Button></td>
								<td><button>Update</button></td>
								<td><a href="/category/view/${cat.categoryId}">View</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<script>
					$(function() {
						function searchCat() {
							// Declare variables
							var input, filter, table, tr, td, i;
							input = document.getElementById("search-bar");
							filter = input.value.toUpperCase();
							table = document.getElementById("category");
							tr = table.getElementsByTagName("tr");

							// Loop through all table rows, and hide those who don't match the search query
							for (i = 0; i < tr.length; i++) {
								td = tr[i].getElementsByTagName("td")[0];
								if (td) {
									if (td.innerHTML.toUpperCase().indexOf(
											filter) > -1) {
										tr[i].style.display = "";
									} else {
										tr[i].style.display = "none";
									}
								}
							}
						}
					});
				</script>
			</c:if>
			<c:if test="${not empty category}">
				<table class="table table-responsive">
					<tbody>
						<tr>
							<td>Name</td>
							<td>${category.name}</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>${category.description}</td>
						</tr>
						<tr>
							<td>Date added</td>
							<td>${category.dateAdded}</td>
						</tr>
					</tbody>
				</table>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp"%>
