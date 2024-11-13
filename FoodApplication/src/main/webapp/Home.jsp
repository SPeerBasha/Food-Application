<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.FoodApp.UserModel.User"%>
<%@ page import="com.FoodApp.UserModel.Restaurant"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 20px;
}

.welcome {
	font-size: 24px;
	margin-bottom: 20px;
	color: #333;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.card {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 16px;
	margin: 8px;
	flex: 1 0 30%;
	box-sizing: border-box;
	transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
}

.card:hover {
	transform: scale(1.05);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.card h3 {
	margin-top: 0;
	color: #333;
}

.card p {
	margin: 4px 0;
	color: #666;
}
/* Different background colors for each card */
.card:nth-child(3n+1) {
	background-color: #ffdddd;
}

.card:nth-child(3n+2) {
	background-color: #ddffdd;
}

.card:nth-child(3n) {
	background-color: #ddddff;
}
</style>
</head>
<body>
<%
ArrayList<Restaurant> list = (ArrayList<Restaurant>)session.getAttribute("restaurantList"); 
for (Restaurant r : list) {
%>
    <div class="card">
        <!-- Updated form action using scriptlet to insert restaurantId -->
        <form action="ViewMenu" method="get">
            <h3>
                <%= r.getName() %>
            </h3>
            <p>
                <strong>Restaurant ID:</strong>
                <%= r.getRestaurantId() %>
            </p>
            <p>
                <strong>Cuisine Type:</strong>
                <%= r.getCuisaneType() %>
            </p>
            <p>
                <strong>Address:</strong>
                <%= r.getAddress() %>
            </p>
            <p>
                <strong>Ratings:</strong>
                <%= r.getRatings() %>
            </p>
            <p>
                <strong>Delivery Time:</strong>
                <%= r.getDeliveryTime() %>
            </p>
            <p>
                <strong>Is Inactive:</strong>
                <%= r.getInactive() %>
            </p>

            <!-- Adding restaurantId as a hidden field -->
            <input type="text" name="restId" value="<%= r.getRestaurantId() %>" hidden>
            <input type="submit" value="ViewMenu">
        </form>
    </div>

<% } %>

</body>
</html>