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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/darkly.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div class="container m-5">
      <div class="card">
        <div class="card-header">
          <h1>Save Travels</h1>
        <div class="card-body">
            <table class="table border">
              <thead>
                <tr>
                  <th>Expense</th>
                  <th>Vendor</th>
                  <th class="text-center">Amount</th>
                  <th class="text-center">Actions</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="expense" items="${expenses}">
                  <tr>
                    <td>
                      <a href="/expenses/show/${expense.id}">
                        <c:out value="${expense.name}"></c:out>
                      </a>
                    </td>
                    <td>
                      <c:out value="${expense.vendor}"></c:out>
                    </td>
                    <td class="text-center">
                      $<c:out value="${expense.amount}"></c:out>
                    </td>
                    <td>
                      <div class="d-flex justify-content-center gap-3">
                        <a href="/expenses/edit/${expense.id}">Edit</a>
                        <form action="/expenses/${expense.id}" method="post">
                          <input type="hidden" name="_method" value="delete">
                          <input style="background-color:red" type="submit" value="Delete">
                                            </form>
                      </div>
                                        </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
        </div>
        </div>
      </div>
      <div class="card mt-5">
        <div class="card-header">
          <h1>Add an Expense:</h1>
        </div>
        <div class="card-body">
          <form:form action="/expenses" method="post" modelAttribute="expense" class="form-control mb-3">
            <form:label class="form-label" path="name"><h4>Expense Name: </h4></form:label>
            <form:errors path="name" style="color:red"/>
            <form:input path="name" type="text" class="form-control mb-3" />
            <form:label class="form-label" path="vendor"><h4>Vendor</h4></form:label>
            <form:errors path="vendor" style="color:red"/>
            <form:input path="vendor" type="text" class="form-control mb-3" />
            <form:label class="form-label" path="amount"><h4>Amount</h4></form:label>
            <form:errors path="amount" style="color:red"/>
            
            <form:input path="amount" type="number" step="0.01" class="form-control mb-3" />
            <form:label class="form-label" path="description"><h4>Description</h4></form:label>
            <form:errors path="description" style="color:red"/>
            <form:textarea path="description" type="text" rows="5" class="form-control mb-3" />
            <div class="d-flex justify-content-end">
              <button class="btn btn-primary m-3" type="submit">
                Submit
              </button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
