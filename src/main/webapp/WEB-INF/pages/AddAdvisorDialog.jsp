<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="addAdvisorModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h1 class="modal-title w-100 fs-4 d-flex justify-content-center"
					id="exampleModalLabel">
					<div class="d-flex align-items-center gap-2">
						Add advisor <img src="images/advisorIcon.png"></img>
					</div>
				</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form class="mt-2 needs-validation" method="post"
					action="?action=insert_advisor" novalidate>
					<div class="mb-4">
						<div class="form-floating">
							<input required type="text" class="form-control form-control-lg"
								id="typeEmailX" placeholder="Username" name="username">
							<label for="typeEmailX">Username</label>
							<div class="invalid-feedback">Please enter a username.</div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input required type="password" class="form-control form-control-lg"
								id="typePassword" placeholder="Password" name="password">
							<label for="typePassword">Password</label>
							<div class="invalid-feedback">Please enter a password.</div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input required type="text" class="form-control form-control-lg"
								id="typeName" placeholder="Name" name="name">
							<label for="typeName">Name</label>
							<div class="invalid-feedback">Please enter a name.</div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input required type="text" class="form-control form-control-lg"
								id="typeSurname" placeholder="Surname" name="surname">
							<label for="typeSurname">Surname</label>
							<div class="invalid-feedback">Please enter a surname.</div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input required  type="email" class="form-control form-control-lg"
								id="typeEmail" placeholder="Email" name="email">
							<label for="typeEmail">Email</label>
							<div class="invalid-feedback">Please enter a valid email.</div>
						</div>
					</div>
					
					<div class="d-flex justify-content-center gap-2">
						<button type="submit" class="btn btn-success imageText fw-bold">
							<img src="images/addButton.jpeg"> Add Advisor
						</button>
						<button type="button" class="btn btn-danger imageText fw-bold"
							data-bs-dismiss="modal">
							<img src="images/closeIcon.jpeg" class="img24"> Close
						</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
	<script>
        (() => {
            const forms = document.querySelectorAll('.needs-validation')
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
        })()
    </script>