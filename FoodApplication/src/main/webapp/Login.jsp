<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background: url('https://preview.redd.it/top-25-indian-foods-of-all-time-according-to-indian-food-v0-d3aj15dnvgjc1.png?auto=webp&s=b72e67e8996ede9b7d6dfcc275dbc40114eb1b51') no-repeat center center fixed;
        background-size: cover;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }
    .login-container h1 {
        margin-bottom: 24px;
        font-size: 24px;
        color: #333;
        text-align: center;
    }
    .login-container input[type="text"], .login-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0 20px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .login-container input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        border: none;
        border-radius: 4px;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }
    .login-container input[type="submit"]:hover {
        background-color: #218838;
    }
</style>		
</head>
<body>

<div class="login-container">
    <h1>Login</h1>
    <form action="Login">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" placeholder="Enter your email"><br>
        
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password"><br>
        
        <input type="submit" value="Login"><br>
        
    </form>
    <div class="register-link">
    <p>Don't have an account?<a href="Register.jsp">Register here</a>
    </div>
</div>

</body>
</html>
