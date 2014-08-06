<%@include file="header.jsp" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All list registered devices</title>
</head>

<body>
<center>
    <h1>${message}</h1>
</center>


<table class="table">

    <thead>
    <tr>
        <th>Faculty</th>
        <th>Group</th>
        <th>DateTime</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${collection}" var="thisItem">
        <tr>
            <td>${thisItem.faculty}</td>
            <td>${thisItem.groupName}</td>
            <td>${thisItem.dataTime}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>