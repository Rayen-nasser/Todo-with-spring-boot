<%@ include file="common/header.jsp" %>
	<body >
        <%@ include file="common/navigation.jsp" %>
		<div class="container container-box">
			<div class="text-center">
				<h1 class="mt-4">Update Todo</h1>
				<pre class="text-danger">${error}</pre>
			</div>
			<form:form method="post" modelAttribute="todo">

				<div class="mb-3">
					<label class="form-label" path="description">Description:</label>
					<form:input type="text" class="form-control"  path="description"/>
					<form:errors path="description"  cssClass="text-danger"/>

					<label  class="form-label" path="targetDate">Target Date:</label>
					<form:input type="text" class="form-control" path="targetDate"/>

					<div class="form-check">
                      <form:checkbox class="form-check-input" path="done"  id="flexCheckDefault"/>
                      <label class="form-check-label" for="flexCheckDefault">
                        Done
                      </label>
                    </div>

					<form:hidden path="id"/>
					<form:hidden path="done"/>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
<%@ include file="common/footer.jsp" %>
