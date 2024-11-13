<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.FoodApp.UserModel.Menu" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background: url('https://th.bing.com/th/id/R.4224a25a4f0fd9056d1ca614970d25a0?rik=zNhArRrADL46jw&riu=http%3a%2f%2fdeelz.me%2fwp-content%2fuploads%2f2018%2f10%2f3991_Fusion-collection-dubai-DEELZme.png&ehk=7%2f5n0hvISi7I7i3k7oleaq7t9xMFAe7ZLmvz2URKeWc%3d&risl=&pid=ImgRaw&r=0') no-repeat center center fixed; /* Replace with your food image URL */
        background-size: cover;
        margin: 0;
        padding: 20px;
    }
    .menu-container {
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 8px;
        padding: 20px;
        margin: 20px auto;
        max-width: 800px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .menu-item {
        background-color: #fff;
        border-radius: 8px;
        padding: 20px;
        margin: 10px 0;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
    }
    .menu-item:hover {
        transform: scale(1.05);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }
    .menu-item h3 {
        margin-top: 0;
        color: #333;
    }
    .menu-item p {
        margin: 4px 0;
        color: #666;
    }
    .menu-item img {
        max-width: 100%;
        border-radius: 4px;
    }
    .price {
        font-weight: bold;
        color: #d9534f;
    }
    /* Different background colors for each card */
    .menu-item:nth-child(4n+1) {
        background-color: #ffdddd;
    }
    .menu-item:nth-child(4n+2) {
        background-color: #ddffdd;
    }
    .menu-item:nth-child(4n+3) {
        background-color: #ddddff;
    }
    .menu-item:nth-child(4n) {
        background-color: #ffffdd;
    }
</style>
</head>
<body>
    <div class="menu-container">
        <h1>Menu List</h1>
        <% ArrayList<Menu> list = (ArrayList<Menu>) session.getAttribute("menuList");
        for (Menu m : list) { %>
        <div class="menu-item">
            <h3><%= m.getName() %></h3>
            <p><strong>Menu ID:</strong> <%= m.getMenuId() %></p>
            <p><strong>Restaurant ID:</strong> <%= m.getRestaurantId() %></p>
            <p><strong>Description:</strong> <%= m.getDescription() %></p>
            <p class="price"><strong>Price:</strong> ₹<%= m.getPrice() %></p>
            <p><strong>Rating:</strong> <%= m.getRating() %>/10</p>
            <p><strong>Available:</strong> <%= m.getIsAvailable() %></p>
            <img src="<%= m.getImage() %>" alt="<%= m.getName() %> Image">
        </div>
        <% } %>
    </div>
</body>
</html>
