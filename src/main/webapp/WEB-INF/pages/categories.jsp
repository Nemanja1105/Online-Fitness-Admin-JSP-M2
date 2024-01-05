<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Categories</title>
<link rel="stylesheet" href="css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style/style.css">
<script src="js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
</head>

<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="pageContent">
	<div class="startEndComp">
		<h1>Categories</h1>
		<button type="button" class="btn btn-success btn-lg d-flex align-items-center gap-2 fw-bold fs-5 "><img src="images/addButton.jpeg" />Add category</button>
		</div>
		<div class="container-sm mt-4">
			<div class="row gy-3">
				<div class="card rounded-3 shadow px-0">
					<div class="card-header startEndComp p-3" style="height:70px">
						<div class="d-flex gap-2 align-items-center">
							<a data-bs-toggle="collapse" href="#collapseCategory"
								role="button" aria-expanded="false"
								aria-controls="collapseCategory"> <img
								src="images/downIcon.png" />
							</a>
							<h4 class="mb-0">Naziv kategorije</h4>
						</div>
						<div class="d-flex gap-3 align-items-center">
							<a data-bs-toggle="tooltip" data-bs-placement="top"
								title="Edit category"><img src="images/editIcon.png" href=""></img></a>
							<a data-bs-toggle="tooltip" data-bs-placement="top"
								title="Delete category"><img src="images/deleteIcon.jpeg"
								href=""></img></a>
						</div>
					</div>
					<div class="collapse" id="collapseCategory">
						<div
							class="card-body overflow-auto d-flex justify-content-center	
							style="max-height: 250px">
							<ul class="list-group" style="width: 95%">
								<%
								for (int i = 0; i < 5; i++) {
								%>
								<li class="list-group-item startEndComp">
									<h5 class="mb-0">Naziv atributa</h5>
									<div class="d-flex gap-3 align-items-center">
										<a data-bs-toggle="tooltip" data-bs-placement="top"
											title="Edit attribute"><img class="img24"
											src="images/editIcon.png" href=""></img></a> <a
											data-bs-toggle="tooltip" data-bs-placement="top"
											title="Delete attribute"><img class="img24"
											src="images/deleteIcon.jpeg" href=""></img></a>
									</div>
								</li>
								<%
								}
								%>
								<li class="list-group-item d-flex justify-content-center ">
									<a
									class="d-flex gap-2 align-items-center text-success fw-bold fs-5 text-decoration-none"
									href="#" type="button"> <img src="images/addButton.jpeg" />
										Add attribute
								</a>
								</li>
							</ul>

						</div>
					</div>
				</div>
				<div class="card rounded-3 shadow px-0">
					<div class="card-header startEndComp p-3" style="height:70px">
						<div class="d-flex gap-2 align-items-center">
							<a data-bs-toggle="collapse" href="#collapseCategory1"
								role="button" aria-expanded="false"
								aria-controls="collapseCategory"> <img
								src="images/downIcon.png" />
							</a>
							<h4 class="mb-0">Naziv kategorije</h4>
						</div>
						<div class="d-flex gap-3 align-items-center">
							<a data-bs-toggle="tooltip" data-bs-placement="top"
								title="Edit category"><img src="images/editIcon.png" href=""></img></a>
							<a data-bs-toggle="tooltip" data-bs-placement="top"
								title="Delete category"><img src="images/deleteIcon.jpeg"
								href=""></img></a>
						</div>
					</div>
					<div class="collapse" id="collapseCategory1">
						<div
							class="card-body overflow-auto d-flex justify-content-center	
							style="max-height: 250px">
							<ul class="list-group" style="width: 95%">
								<%
								for (int i = 0; i < 5; i++) {
								%>
								<li class="list-group-item startEndComp">
									<h5 class="mb-0">Naziv atributa</h5>
									<div class="d-flex gap-3 align-items-center">
										<a data-bs-toggle="tooltip" data-bs-placement="top"
											title="Edit attribute"><img class="img24"
											src="images/editIcon.png" href=""></img></a> <a
											data-bs-toggle="tooltip" data-bs-placement="top"
											title="Delete attribute"><img class="img24"
											src="images/deleteIcon.jpeg" href=""></img></a>
									</div>
								</li>
								<%
								}
								%>
								<li class="list-group-item d-flex justify-content-center ">
									<a
									class="d-flex gap-2 align-items-center text-success fw-bold fs-5 text-decoration-none"
									href="#" type="button"> <img src="images/addButton.jpeg" />
										Add attribute
								</a>
								</li>
							</ul>

						</div>
					</div>
				</div>
			</div>
		</div>
</body>

</html>