<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fabian
  Date: 10/08/2022
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/solve/main">Strona główna</a>
<a href="/solve/all">All Solves</a>
<a href="/pll/main">Algorithm's PLL</a>

<table border="1">
  <thead>
    <tr>
      <td>ID</td>
      <td>Scramble alg</td>
      <td>Time of solve</td>
      <td>Pll Algorithm</td>
      <td>Delete solve</td>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${solves}" var="solve">
      <tr>
        <td>${solve.solveId}</td>
        <td>${solve.scrambleAlg}</td>
        <td>${solve.timeValue}</td>
        <td>${solve.pll.pllAlgorithm}</td>
        <td><a href="/solve/delete/${solve.solveId}">Delete solve</a></td>
        <td><a href="/solve/addPll/${solve.solveId}">add PLL</a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
