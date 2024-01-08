<%@page import="org.unibl.etf.models.dto.Advisor"%>
<%@page import="org.unibl.etf.models.dto.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="clientBean"
	type="org.unibl.etf.models.beans.ClientBean" scope="session"></jsp:useBean>
<jsp:useBean id="advisorBean" type="org.unibl.etf.models.beans.AdvisorBean" scope="session"></jsp:useBean>
<jsp:useBean id="tab" type="java.lang.Integer" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style/style.css">
<script src="js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

<script>
	function deleteClient(id) {
		let form = document.getElementById('deleteClientForm' + id);
		form.submit();
	}
	
	function deleteAdvisor(id) {
		let form = document.getElementById('deleteAdvisorForm' + id);
		form.submit();
	}
</script>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="pageContent">
		<h1>Users</h1>
		<div class="px-md-5">
			<ul class="nav nav-pills nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link <%= tab==1?"active":"" %> fw-bold fs-5 imageText "
						id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane"
						type="button" role="tab" aria-controls="home-tab-pane"
						aria-selected="true">
						<img src="images/clientIcon.png" />Clients
					</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link <%= tab==2?"active":"" %> fw-bold fs-5 imageText" id="profile-tab"
						data-bs-toggle="tab" data-bs-target="#profile-tab-pane"
						type="button" role="tab" aria-controls="profile-tab-pane"
						aria-selected="false">
						<img src="images/advisorIcon.png" />Advisors
					</button>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade <%= tab==1?"show active":"" %>" id="home-tab-pane"
					role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					<div class="container-fluid" style="margin-top: 30px">
						<div class="row gy-3">
							<div class="card m-0 p-0" style="border-radius: 20px;">
								<div class="card-body p-0">
									<div class="table-responsive"
										style="overflow-x: auto; border-radius: 20px;">
										<table class="table m-0" style="table-layout: fixed;">
											<thead class=" table-header">
												<tr>
													<th scope="col" class="col-1">ID</th>
													<th scope="col" class="col-2">Username</th>
													<th scope="col" class="col-2">Name</th>
													<th scope="col" class="col-2">Surname</th>
													<th scope="col" class="col-2">City</th>
													<th scope="col" class="col-2">Email</th>
													<th scope="col" class="col-2">Action</th>
												</tr>
											</thead>
											<tbody class=" table-body fw-semibold fs-5">
												<%
												for (Client c : clientBean.findAll()) {
												%>
												<tr>
													<td><%=c.getId()%></td>
													<td><%=c.getUsername()%></td>
													<td><%=c.getName()%></td>
													<td><%=c.getSurname()%></td>
													<td><%=c.getCity()%></td>
													<td><%=c.getEmail()%></td>
													<td>
														<form id="deleteClientForm<%=c.getId()%>" method="post"
															action="?action=<%=c.isStatus() ? "block_client" : "unblock_client"%>">
															<a href="javascript:deleteClient(<%=c.getId()%>)"
																data-bs-toggle="tooltip" data-bs-placement="top"
																data-bs-title="<%=c.isStatus() ? "Block" : "Unblock"%>">
																<img
																src=<%=c.isStatus() ? "images/lockIcon.png" : "images/unlockIcon.png"%> />
															</a> <input type="hidden" name="id" value=<%=c.getId()%>>
														</form>
													</td>
												</tr>
												<%
												}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="tab-pane fade <%= tab==2?"show active":"" %> " id="profile-tab-pane" role="tabpanel"
					aria-labelledby="profile-tab" tabindex="0">


					<div class="d-flex justify-content-end" style="margin-top: 30px">

						<button type="button" data-bs-toggle="modal"
							data-bs-target="#addAdvisorModal"
							class="btn btn-success btn-lg d-flex align-items-center gap-2 fw-bold fs-5 ">
							<img src="images/addButton.jpeg" />Add advisor
						</button>
					</div>


					<div class="container-fluid" style="margin-top: 30px">
						<div class="row gy-3">
							<div class="card m-0 p-0" style="border-radius: 20px;">
								<div class="card-body p-0">
									<div class="table-responsive"
										style="overflow-x: auto; border-radius: 20px;">
										<table class="table m-0" style="table-layout: fixed;">
											<thead class=" table-header">
												<tr>
													<th scope="col" class="col-1">ID</th>
													<th scope="col" class="col-2">Username</th>
													<th scope="col" class="col-2">Name</th>
													<th scope="col" class="col-2">Surname</th>
													<th scope="col" class="col-2">Email</th>
													<th scope="col" class="col-2">Action</th>
												</tr>
											</thead>
											<tbody class=" table-body fw-semibold fs-5">
											<% for(Advisor a: advisorBean.findAll()) { %>
												<tr>
													<td><%=a.getId() %></td>
													<td><%=a.getUsername() %></td>
													<td><%=a.getName() %></td>
													<td><%=a.getSurname() %></td>
													<td><%=a.getEmail() %></td>
													<td>
														<form id="deleteAdvisorForm<%=a.getId()%>" method="post"
															action="?action=<%=a.isStatus() ? "block_advisor" : "unblock_advisor"%>">
															<a href="javascript:deleteAdvisor(<%=a.getId()%>)"
																data-bs-toggle="tooltip" data-bs-placement="top"
																data-bs-title="<%=a.isStatus() ? "Block" : "Unblock"%>">
																<img
																src=<%=a.isStatus() ? "images/lockIcon.png" : "images/unlockIcon.png"%> />
															</a> <input type="hidden" name="id" value=<%=a.getId()%>>
														</form>
													</td>
												</tr>
											<%} %>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="Notification.jsp"></jsp:include>
	<jsp:include page="AddAdvisorDialog.jsp"></jsp:include>

</body>
</html>