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
        h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 1.5rem;
        }
        h3 {
            color: #495057;
            font-size: 1.1rem;
        }
        .container {
            background: #ffffff;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
        }
        .info {
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Hello to Employee App</h2>
        <div class="info">
            <h3>Username is: ${userModel.username}</h3>
        </div>
        <div class="info">
            <h3>Email is: ${userModel.email}</h3>
        </div>
        <div class="info">
            <h3>Password is: ${userModel.password}</h3>
        </div>
    </div>
</body>
</html>
