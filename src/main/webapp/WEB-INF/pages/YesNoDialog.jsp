<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="confirmDeleteModal" tabindex="-1"
	role="dialog" aria-labelledby="confirmDeleteModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-backgrop" role="document">
		<div class="modal-content">
			<div class="modal-header">
			<div class="w-100 d-flex justify-content-center gap-2 align-items-center">
				<img src="images/deleteIcon.jpeg"></img>
				<h3 class="fs-4 m-0">Delete</h3>
				</div>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
					
			</div>
			<div class="modal-body text-center fw-semibold fs-5">Are you sure you want to delete?</div>
			<div class="modal-footer d-flex justify-content-center">
			<button type="button" class="btn btn-success" id="confirmDeleteBtn" style="width:90px">Yes</button>
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal"
					aria-label="Close" style="width:90px">No</button>
			</div>
		</div>
	</div>
</div>