 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

 <html>
 <head>
     <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
     <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
     <style>
         body {
             background-color: #f8f9fa;
             font-family: Arial, sans-serif;
             padding: 2rem;
         }
         .form-container {
             background: #ffffff;
             padding: 2rem;
             border-radius: 8px;
             box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
             max-width: 600px;
             margin: auto;
         }
         h2 {
             text-align: center;
             color: #343a40;
             margin-bottom: 1.5rem;
         }
         h4 {
             color: #495057;
         }
         .error {
             color: red;
             font-size: 0.9rem;
         }
         input[type="submit"] {
             width: 100%;
             background-color: #007bff;
             color: #ffffff;
             padding: 0.75rem;
             border: none;
             border-radius: 4px;
             font-size: 1rem;
         }
         input[type="submit"]:hover {
             background-color: #0056b3;
         }
     </style>
 </head>
 <body>
     <div class="form-container">
         <h2>Employee Registration Form</h2>
         <form:form action="processForm" modelAttribute="userModel">
             <h4>Username</h4>
             <form:input type="text" placeholder="username" path="username" class="form-control"/>
             <form:errors path="username" cssClass="error"/>
             <br><br>
             <h4>Email address</h4>
             <form:input type="email" placeholder="email" path="email" class="form-control"/>
             <form:errors path="email" cssClass="error"/>
             <br><br>
             <h4>Password</h4>
             <form:input type="password" placeholder="password" path="password" class="form-control"/>
             <form:errors path="password" cssClass="error"/>
             <br><br>
             <h4>Confirm Password</h4>
             <form:input type="password" placeholder="confirm password" path="confirmrpassword" class="form-control"/>
             <form:errors path="confirmrpassword" cssClass="error"/>
             <form:errors path="" cssClass="error"/>
             <br><br>
             <input type="submit"/>
         </form:form>
     </div>
 </body>
 </html>
