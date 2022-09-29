<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Customers Data</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <style>
      * {
        margin: 0px;
        padding: 0px;
      }

      .heading {
        padding: 20px;
        background: #00109f;
        color: white;
        text-align: center;
      }

      .mainLink {
        text-align: center;
        margin-top: 30px;
        font-size: 30px;
      }
    </style>

    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <header>
      <div class="heading">
        <h1>Customer Relationship Management</h1>
      </div>
    </header>
    <main>
      <div class="container">
        <hr />

          <a class="btn btn-success mb-2 mr-3" href="/Customer_Relationship_Management/addCustomer">Add Customer</a>


        <table class="table table-bordered table-striped">
          <thead class="thead-dark">
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            <c:forEach items="${crmData}" var="tempCustomerData">
              <tr>
                <td><c:out value="${tempCustomerData.fname}" /></td>
                <td><c:out value="${tempCustomerData.lname}" /></td>
                <td><c:out value="${tempCustomerData.email}" /></td>
                <td>
                  <!-- Add "update" button/link -->
                  <a
                    href="showUpdateCustomer/${tempCustomerData.id}"
                    class="btn btn-info btn-sm"
                  >
                    Update
                  </a>
                  <!-- Add "delete" button/link -->
                  <a
                    href="delete/${tempCustomerData.id}"
                    class="btn btn-danger btn-sm"
                    onclick="if (!(confirm('Are you sure you want to delete Cutsomer : `${tempCustomerData.fname} ${tempCustomerData.lname}`?'))) return false"
                  >
                    Delete
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </main>
    <footer>
    
    	<center><a class="btn btn-warning btn-sm" href="/Customer_Relationship_Management">Go To Home Page</a></center>
      <!-- place footer here -->
    </footer>
  </body>
