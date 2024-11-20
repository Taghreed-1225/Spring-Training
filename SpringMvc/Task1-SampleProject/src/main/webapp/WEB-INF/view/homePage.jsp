<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('https://img.freepik.com/free-vector/minimal-doodle-frame-background-social-story-highlight-vector_53876-136677.jpg?semt=ais_hybrid');
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 500px;
            border: 2px solid #8B4513; /* بني */
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
            font-family: 'Arial', sans-serif;
            color: #8B4513; /* لون بني للعناوين */
        }

        .form-group label {
            font-weight: bold;
            color: #444;
        }

        .form-control,
        .form-select {
            border: 2px solid #8B4513; /* بني */
            border-radius: 20px; /* حواف مستديرة */
            padding: 10px;
            font-size: 1rem;
        }

        .form-control:focus,
        .form-select:focus {
            box-shadow: 0 0 5px #8B4513;
            border-color: #8B4513;
        }

        .btn {
            width: 100%;
            background-color: #8B4513; /* بني */
            color: white;
            border: none;
            padding: 10px;
            font-size: 1rem;
            border-radius: 20px; /* زرار مستدير */
        }

        .btn:hover {
            background-color: #6A3310; /* درجة أغمق */
        }

        .text-danger {
            color: #dc3545; /* لون الخطأ */
            font-size: 0.9em;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Welcome to the App</h2>
        <form:form action="processForm" modelAttribute="userModel">
            <div class="form-group">
                <label>Username</label>
                <form:input type="text" placeholder="Enter your username" path="username" class="form-control" />
                <form:errors path="username"  cssClass="error" />
            </div>
            <div class="form-group">
                <label>Password</label>
                <form:input type="password" placeholder="Enter your password" path="password" class="form-control" />
            </div>
            <div class="form-group">
                <label>Salary</label>
                <form:input type="text" placeholder="Enter your salary" path="salary" class="form-control" />
                <form:errors path="salary" cssClass="error" />
            </div>
            <div class="form-group">
                <label>Email</label>
                <form:input type="email" placeholder="Enter your email" path="email" class="form-control" />
                <form:errors path="email" cssClass="error" />
            </div>
            <div class="form-group">
                <label>Country</label>
                <form:select path="country" class="form-select">
                    <form:option value="Egypt" label="Egypt" />
                    <form:option value="Brazil" label="Brazil" />
                    <form:option value="Saudi Arabia" label="Saudi Arabia" />
                </form:select>
            </div>
            <div class="form-group">
                <label>Programming Language</label><br />
                Java <form:radiobutton path="programmingLanguage" value="Java" />
                C# <form:radiobutton path="programmingLanguage" value="C#" />
                PHP <form:radiobutton path="programmingLanguage" value="PHP" />
                Ruby <form:radiobutton path="programmingLanguage" value="Ruby" />
            </div>
            <div class="form-group">
                <label>Operating System</label><br />
                Linux <form:checkbox path="operatingSystem" value="Linux" />
                Mac OS <form:checkbox path="operatingSystem" value="Mac OS" />
                MS Windows <form:checkbox path="operatingSystem" value="MS Windows" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>

