<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Welcome</title>

	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="css/custom.css"
		rel="stylesheet">
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="js/custom.js"></script>
</head>
<body>
        <form:form method="POST"
          action="/submitLogin" modelAttribute="user">
             <table>
                <tr>
                    <td><form:label path="userId">User</form:label></td>
                    <td><form:input path="userId"/></td>
                </tr>

                                <tr>
                                    <td><form:label path="clientId">clientId</form:label></td>
                                    <td><form:input path="clientId"/></td>
                 </tr>
                                                 <tr>
                                                     <td><form:label path="serverId">SDK Key</form:label></td>
                                                     <td><form:input path="serverId"/></td>
                                  </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>
