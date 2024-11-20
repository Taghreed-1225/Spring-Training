<html>
<head>
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
<h2>Hello to Student App </h2>
<h3>username is : ${userModel.username}</h3>
<h3>password is : ${userModel.password}</h3>
<h3>salary is : ${userModel.salary}</h3>
<h3>email is : ${userModel.email}</h3>
<h3>country is : ${userModel.country}</h3>
<h3>programmingLanguage  is : ${userModel.programmingLanguage} </h3>
<h3>operating system is : ${userModel.operatingSystem} </h3>
</body>
</html>
