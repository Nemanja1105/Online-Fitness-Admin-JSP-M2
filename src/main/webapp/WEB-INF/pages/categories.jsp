<%@page import="org.unibl.etf.models.dto.CategoryAttribute"%>
<%@page import="org.unibl.etf.models.dto.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<jsp:useBean id="categoryBean"
	type="org.unibl.etf.models.beans.CategoryBean" scope="session"></jsp:useBean>
<jsp:useBean id="categoryAttributeBean"
	type="org.unibl.etf.models.beans.CategoryAttributeBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Categories</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

</head>

<script>

	function deleteCategory(id) {
		let form = document.getElementById('deleteCategoryForm' + id);
		$('#confirmDeleteBtn').click(function() {
		
			form.submit();
		});
		$('#confirmDeleteModal').modal('show');
	}

	function openUpdateCategoryModal(categoryId, categoryName) {
		const modal = $('#updateCategoryModal');
		modal.find('.modal-body #typeEmailX').val(categoryName);
		modal.find('.modal-body #categoryId').val(categoryId);
		modal.modal('show');
	}

	function openAddAtributeDialog(categoryId) {
		const modal = $('#addCategoryAttributeModal');
		modal.find('.modal-body #categoryId').val(categoryId);
		modal.modal('show');
	}

	function deleteCategoryAttribute(id) {
		let form = document.getElementById('deleteAttributeForm' + id);
		$('#confirmDeleteBtn').click(function() {
			form.submit();
		});
		$('#confirmDeleteModal').modal('show');
	}

	function openUpdateCategoryAttributeModal(attributeId, attributeName) {
		const modal = $('#updateCategoryAttributeModal');
		modal.find('.modal-body #typeEmailX').val(attributeName);
		modal.find('.modal-body #categoryId').val(attributeId);
		modal.modal('show');
	}
</script>

<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="pageContent">
		<div class="startEndComp">
			<h1>Categories</h1>
			<button type="button" data-bs-toggle="modal"
				data-bs-target="#addCategoryModal"
				class="btn btn-success btn-lg d-flex align-items-center gap-2 fw-bold fs-5 ">
				<img src="images/addButton.jpeg" />Add category
			</button>
		</div>
		<div class="container-sm mt-4">
			<div class="row gy-3">
				<%
				for (Category c : categoryBean.findAll()) {
				%>
				<div class="card rounded-3 shadow px-0">
					<div class="card-header startEndComp p-3" style="height: 70px">
						<div class="d-flex gap-2 align-items-center">
							<a data-bs-toggle="collapse"
								href="#collapseCategory<%=c.getId()%>" role="button"
								aria-expanded="false" aria-controls="collapseCategory"> <img
								src="images/downIcon.png" />
							</a>
							<h4 class="mb-0"><%=c.getName()%></h4>
						</div>
						<div class="d-flex gap-3 align-items-center">
							<a
								href="javascript:openUpdateCategoryModal(<%=c.getId()%>,'<%=c.getName()%>')"
								data-bs-toggle="tooltip" data-bs-placement="top"
								title="Edit category"><img src="images/editIcon.png"></img></a>
							<form method="post" action="?action=delete"
								id="deleteCategoryForm<%=c.getId()%>">
								<input type="hidden" name="id" value=<%=c.getId()%>> <a
									href="javascript:deleteCategory(<%=c.getId()%>)"
									data-bs-toggle="tooltip" data-bs-placement="top"
									title="Delete category"><img src="images/deleteIcon.jpeg"></img></a>
							</form>
						</div>
					</div>
					<div class="collapse" id="collapseCategory<%=c.getId()%>">
						<div
							class="card-body overflow-auto d-flex justify-content-center	
							style="max-height: 250px">
							<ul class="list-group" style="width: 95%">
								<%
								for (CategoryAttribute a : categoryAttributeBean.findAll(c.getId())) {
								%>
								<li class="list-group-item startEndComp">
									<h5 class="mb-0"><%=a.getName()%></h5>
									<div class="d-flex gap-3 align-items-center">
										<a
											href="javascript:openUpdateCategoryAttributeModal(<%=a.getId()%>,'<%=a.getName()%>')"
											data-bs-toggle="tooltip" data-bs-placement="top"
											title="Edit attribute"><img class="img24"
											src="images/editIcon.png"></img></a>
										<form action="?action=delete_attribute" method="post"
											id="deleteAttributeForm<%=a.getId()%>">
											<input type="hidden" name="id" value=<%=a.getId()%>>
											<a href="javascript:deleteCategoryAttribute(<%=a.getId()%>)"
												data-bs-toggle="tooltip" data-bs-placement="top"
												title="Delete attribute"><img class="img24"
												src="images/deleteIcon.jpeg"></img></a>
										</form>
									</div>
								</li>
								<%
								}
								%>
								<li class="list-group-item d-flex justify-content-center ">
									<a
									class="d-flex gap-2 align-items-center text-success fw-bold fs-5 text-decoration-none"
									href="javascript:openAddAtributeDialog(<%=c.getId()%>)"
									type="button"> <img src="images/addButton.jpeg" /> Add
										attribute
								</a>
								</li>
							</ul>

						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>

			<jsp:include page="YesNoDialog.jsp"></jsp:include>
			<jsp:include page="AddCategoryDialog.jsp"></jsp:include>
			<jsp:include page="UpdateCategoryDialog.jsp"></jsp:include>
			<jsp:include page="AddCategoryAttributeDialog.jsp"></jsp:include>
			<jsp:include page="UpdateCategoryAttributeDialog.jsp"></jsp:include>
			<jsp:include page="Notification.jsp"></jsp:include>
		</div>
</body>

</html>