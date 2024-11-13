<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .registration-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }
    .registration-container h1 {
        margin-bottom: 24px;
        font-size: 24px;
        color: #333;
        text-align: center;
    }
    .registration-container label {
        font-size: 14px;
        color: #333;
    }
    .registration-container input[type="text"], 
    .registration-container input[type="email"],
    .registration-container input[type="password"],
    .registration-container input[type="tel"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .registration-container input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }
    .registration-container input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="registration-container">
    <h1>Register</h1>
    <form action="RegisterServlet" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required><br>
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required><br>
        
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required><br>
        
        <label for="mobile">Mobile Number</label>
        <input type="tel" id="mobile" name="mobile" placeholder="Enter your mobile number" required><br>
        
        <input type="submit" value="Register"><br>
    </form>
</div>

</body>
</html>
