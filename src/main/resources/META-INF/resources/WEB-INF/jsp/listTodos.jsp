<%@ include file="common/header.jsp" %>
	<body>
        <%@ include file="common/navigation.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h2 class="mt-4 text-primary">${name} Your Todos</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <table class="table table-striped mt-4">
                        <thead class="table-dark">
                            <tr>
                                <th>Description</th>
                                <th>Target Date</th>
                                <th>is Done?</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${todos}" var="todo">
                                <tr class="text-white">
                                    <td class="text-white">${todo.description}</td>
                                    <td class="text-white">${todo.targetDate}</td>
                                    <td class="text-white">${todo.done}</td>
                                    <td>
                                        <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                                    </td>
                                     <td>
                                        <a href="update-todo?id=${todo.id}" class="btn btn-warning ms-2">Update</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="add-todo" class="btn btn-success">Add Todo</a>
                </div>
            </div>
        </div>
<%@ include file="common/footer.jsp" %>
