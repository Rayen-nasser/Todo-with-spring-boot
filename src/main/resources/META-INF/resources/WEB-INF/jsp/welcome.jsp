<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Welcome to App Todos</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<style>
			body {
				padding-top: 20px;
				padding-bottom: 20px;
				background-image: url("https://wallpapercave.com/wp/wp9764009.jpg");
				background-size: cover;
				background-position: center;
				color: white;
				text-align: center;
				font-size: 24px;
			}
			.container {
				max-width: 400px;
				background-color: rgba(0, 0, 0, 0.5);
				border-radius: 5px;
				padding: 20px;
				margin: 100px auto;
			}
			a {
				color: white;
				text-decoration: underline;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1>${name}, Welcome to App Todos</h1>
			<div>
				<a href="list-todos">Manage</a> Your todos
			</div>
		</div>
<%@ include file="common/footer.jsp" %>
