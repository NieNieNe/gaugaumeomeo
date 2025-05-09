<%--
  Created by IntelliJ IDEA.
  User: FPT SHOP
  Date: 12/5/2024
  Time: 3:08 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Care - Register</title>
    <link rel="stylesheet" href="css/register.css?v=1.0">
</head>
<body>
<div class="register-container">
    <img src="https://via.placeholder.com/120" alt="Pet Care Logo">
    <h2>Create Your Account</h2>
    <p class="register-intro">Join Pet Care to get the best services for your furry friends!</p>
    <form action="register" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="text" name="fullname" placeholder="Full Name" required>
        <input type="number" name="petsCount" placeholder="Number of Pets" min="0" required>
        <input type="text" name="phoneNumber" placeholder="Phone Number" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="password" name="confirmPassword" placeholder="Confirm Password" required>


        <input type="date" name="dateofBirth" placeholder="Enter your date of birth" required>
        <button type="submit">Register</button>
    </form>
    <div class="footer-text">
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</div>
</body>
</html>

