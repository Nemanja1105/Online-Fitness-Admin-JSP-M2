<%@page import="org.unibl.etf.models.dto.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="statisticBean" type="org.unibl.etf.models.beans.StatisticsBean" scope="session"></jsp:useBean>
<jsp:useBean id="currentPage" type="java.lang.Integer" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style/style.css">
<script src="js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Statistics</title>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="pageContent">
		<h1>Statistics</h1>
		<div class="container-fluid" style="margin-top: 30px">
			<div class="row gy-3">
				<div class="table-responsive-md"
					style="overflow-x: auto; border-radius: 20px;">
					<table class="table m-0">
						<thead class="table-header-stat">
							<tr>
								<th scope="col" class="col-1">Level</th>
								<th scope="col" class="col-2">Time</th>
								<th scope="col" class="col-">Description</th>
							</tr>
						</thead>
						<tbody class="table-body-stat fw-semibold fs-5">
						<% for(Log l:statisticBean.findAll(currentPage)) {%>
							<tr>
								<td><span class="badge text-bg-<%=l.getLevel().getColor()%>"><%=l.getLevel() %></span></td>
								<td><%=l.getDate() %></td>
								<td><%=l.getDescription() %></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-end">
						
						<%for(int i=1;i<=statisticBean.numOfPages();i++) {%>
						<li class="page-item <%=currentPage==i?"active":""%>"><a class="page-link" href="?page=<%=i%>"><%=i%></a></li>
					
						<%}%>
						
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>