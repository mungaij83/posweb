<%@include file="/WEB-INF/jsf/header.jsp"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 top-bar">
			<ul class="nav nav-pills">
				<li class="active"><a href="/product/add">New
						Product</a></li>
				<li><a data-toggle="tab" href="">Other1</a></li>
				<li><a data-toggle="tab" href="">Other2</a></li>
			</ul>
		</div>
		<div class="col-md-8 search-bar">
			<input type="text" class="form-input input-md">
		</div>
		<div class="col-md-8">
			<c:if test="${not empty products}">
			<table class="table table-responsive table-stripped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Product Code</th>
						<th>Category</th>
						<th>Sub-Category</th>
						<th>Date Added</th>
						<th>Quantity</th>
						<th>Buying Price</th>
						<td>Selling Price</td>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="p">
						<tr>
							<td>${p.name}</td>
							<td>${p.productCode}</td>
							<td>${cat.category}</td>
							<td>${cat.subCategory}</td>
							<td>${cat.dateAdded}</td>
							<td>${cat.buyingPrice}</td>
							<td>${cat.sellingPrice}</td>
							<td><Button>Delete</Button></td>
							<td><button>Update</button></td>
							<td><a href="/category/view/${cat.categoryId}">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${not empty product}">
					<table class="table table-responsive">
						<tbody>
							<tr>
								<td>Name</td>
								<td>${product.name}</td>
							</tr>
							<tr>
								<td>Product Code</td>
								<td>${product.productCode}</td>
							</tr>
							<tr>
								<td>Category</td>
								<td>${category.category}</td>
							</tr>
						</tbody>
					</table>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsf/footer.jsp" %>
