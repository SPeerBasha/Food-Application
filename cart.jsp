<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.HashMap"%>
<%@ page import="com.FoodApp.UserModel.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Details</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('background-image.jpg') no-repeat center center fixed; /* Replace with your image URL */
            background-size: cover;
            margin: 0;
            padding: 20px;
        }
        .cart-container {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 8px;
            padding: 20px;
            max-width: 800px;
            margin: auto;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .cart-item {
            background-color: #fff;
            border-radius: 8px;
            padding: 15px;
            margin: 10px 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .cart-item p {
            margin: 5px 0;
            color: #333;
        }
        .cart-item p span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <%
        HashMap<Integer, CartItem> map = (HashMap<Integer, CartItem>) session.getAttribute("cart");
        for (CartItem item : map.values()) {
        %>
        <div class="cart-item">
            <p><span>ItemId:</span> <%= item.getItemId() %></p>
            <p><span>RestaurantId:</span> <%= item.getRestaurantId() %></p>
            <p><span>Name:</span> <%= item.getName() %></p>
            <p><span>Quantity:</span> <%= item.getQuantity() %></p>
            <p><span>Price:</span> ₹<%= item.getPrice() %></p>
        </div>
        <% } %>
    </div>
</body>
</html>
