<html>

<body>

<h1>Register Page</h1>

Hello ${firstName}
<form method="GET" action="/indexSubmit">
    <br>
    <label for="FirstName">First Name</label>
    <input id="FirstName" type="text" name="FirstName" placeholder="Enter Your First Name" required>
    <br>
    <label for="LastName">Last Name</label>
    <input id="LastName" type="text" name="LastName" placeholder="Enter Your Last Name" required>
    <br>
    <label for="Email">Email</label>
    <input id="Email" type="email" name="Email" placeholder="Enter Your Email" required>
    <br>
    <label for="Password">Password</label>
    <input id="Password" type="password" name="Password" placeholder="Enter Your Password" required>
    <br>
    <label for="Confirm">Confirm Password</label>
    <input id="Confirm" type="password" name="Confirm" placeholder="Confirm Your Password" required>
    <br>
    Gender
    <input type="radio" id="female" name="Gender" value="female" required>
    <label for="female">Female</label>
    <input type="radio" id="male" name="Gender" value="male" required>
    <label for="male">Male</label>
    <br>
    <label for="DOB">Date of Birth</label>
    <input type="date" id="DOB" name="DOB" required>
    <br>
    Habits
    <%--    include name attribute--%>
    <input type="checkbox" id="sports" value="sports" name="sports">
    <label for="sports">You like sports</label>
    <input type="checkbox" id="eat" value="eat" name="eat">
    <label for="eat">You like to eat</label>
    <input type="checkbox" id="sleep" value="sleep" name="sleep">
    <label for="sleep">You like to sleep</label>
    <br>
    <input type="submit" value="Register">
</form>
</body>

</html>

