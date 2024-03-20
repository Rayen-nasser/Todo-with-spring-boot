<%@ include file="common/header.jsp" %>
	<body>
	    <%@ include file="common/navigation.jsp" %>
		<div class="container container-box">
			<div class="text-center">
				<h1 class="mt-4">Add Todo</h1>
				<pre class="text-danger">${error}</pre>
			</div>
			<form:form method="post" modelAttribute="todo">

				<div class="mb-3">
					<label for="description" class="form-label">Description:</label>
					<form:input type="text" class="form-control" id="description" path="description"/>
					<form:errors path="description"  cssClass="text-danger"/>

					<label for="targetDate" class="form-label">Target Date:</label>
                    <form:input type="text" class="form-control" id="targetDate" path="targetDate"/>
                    <form:errors path="targetDate"  cssClass="text-danger"/>

					<form:hidden path="id"/>
					<form:hidden path="done"/>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>
<%@ include file="common/footer.jsp" %>
