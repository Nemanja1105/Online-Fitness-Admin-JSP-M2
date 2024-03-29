<jsp:useBean id="active" type="java.lang.String" scope="session"></jsp:useBean>

	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#6c5ce7">
  <div class="container-fluid">
    <a class="navbar-brand text-light fs-4 fw-bold" href="#">Admin</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class=" offcanvas offcanvas-end" style="background-color:rgba(162, 155, 254,0.9)" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title text-light text-center" id="offcanvasNavbarLabel">Admin menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-lg-center align-items-center fs-5 fw-bold flex-grow-1 pe-3">
          <li class="nav-item mx-2">
            <a class="nav-link <%=active.equals("Categories")?"active":"" %> centerIconText" aria-current="page" href="Categories"><img src="images/categoryIcon.jpeg"></img>Categories</a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link <%=active.equals("Users")?"active":"" %> centerIconText" href="Users"><img src="images/usersIcon.jpeg"></img>Users</a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link <%=active.equals("Statistics")?"active":"" %> centerIconText" href="Statistics"><img src="images/statisticIconAdmin.jpeg"></img>Statistics</a>
          </li>
        </ul>
        <div class="d-flex justify-content-center fs-5 fw-bold text-light">
        	<a class="nav-link centerIconText" href="Login?action=logout"><img src="images/logoutIcon.jpeg"> Logout</img></a>
        </div>
      </div>
    </div>
  </div>
</nav>
