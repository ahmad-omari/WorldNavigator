<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/index.css">
    <script type="text/javascript" src="Script/index.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<div class="container">
    <h1>World Navigator Game</h1>

    <h3>Register here</h3>
    <form method="post" action="Controller.RegisterServlet">
        <input type="text" placeholder="Username" name="uname" id="regname">
        <input type="password" placeholder="Password" name="password" id="regpassword">
        <button type="submit" href="" class="button" id="regsubmit">Register Now</button>
    </form>
    <%    if(request.getAttribute("message") != null) {  %>
            <%=  "<h5>" + request.getAttribute("message") + "</h5>" %>
    <%    }  %>


    <h3 class="separate">Or</h3>

    <a class="button" id="button">Login</a>
    <%    if(request.getAttribute("invalid") != null) {  %>
    <%=  "<h5 style=\"color: red\">" + request.getAttribute("invalid") + "</h5>" %>
    <%    }  %>
</div>
<div class="popup">
    <div class="popup-content">
        <h3>Login User</h3>
        <form method="post" action="Controller.LoginServlet">
            <img src="icons/close.png" id="close" alt="Close" class="close">
            <input type="text" placeholder="Username" name="uname" id="logname">
            <input type="password" placeholder="Password" name="password" id="logpassword">
            <button type="submit" class="button">Login</button>
        </form>
    </div>
</div>

</body>
</html>
