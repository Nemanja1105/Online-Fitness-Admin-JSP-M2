<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="updateCategoryAttributeModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h1 class="modal-title w-100 fs-4 d-flex justify-content-center"
					id="exampleModalLabel">
					<div class="d-flex align-items-center gap-2">
						Update attribute <img src="images/categoryIcon.jpeg"></img>
					</div>
				</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form class="mt-2 needs-validation" method="post"
					action="?action=update_attribute" novalidate>
					<div class="mb-4">
						<div class="form-floating">
							<input required type="text" class="form-control form-control-lg"
								id="typeEmailX" placeholder="name@example.com" name="name">
							<label for="typeEmailX">Name</label>
							<div class="invalid-feedback">Please enter a name.</div>
						</div>
					</div>
					<input type="hidden" id="categoryId" name="id">
					<div class="d-flex justify-content-center gap-2">
						<button type="submit" class="btn btn-success imageText fw-bold">
							<img src="images/addButton.jpeg"> Update Attribute
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