<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Show Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/darkly.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container m-5">
      <div class="card mt-5">
        <div class="card-header d-flex justify-content-between">
          <h1>Expense Details</h1>
          <a href="/">Go Back</a>
        </div>
        <div class="card-body">
          <h5>Expense Name:  ${expense.name}</h5>
          <h5>Description:  ${expense.description}</h5>
          <h5>Vendor:  ${expense.vendor}</h5>
          <h5>Amount Spent:  ${expense.amount}</h5>
        </div>
      </div>
    </div>
  </body>
</html>
