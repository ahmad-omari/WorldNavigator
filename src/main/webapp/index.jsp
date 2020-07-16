<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/index.css">
</head>
<body>

<div class="container">
    <h1>World Navigator</h1>

    <h3>Register here</h3>
    <form method="post">
        <input type="text" placeholder="Username" name="uname">
        <input type="password" placeholder="Password" name="password">
        <button type="submit" href="#" class="button">Register Now</button>
    </form>

    <h3 class="separate">Or</h3>

    <a href="#" class="button" id="button">Login</a>
</div>

<div class="popup">
    <div class="popup-content">
        <h3>Login User</h3>
        <form method="post">
            <img src="icons/close.png" id="close" alt="Close" class="close">
            <input type="text" placeholder="Username" name="uname">
            <input type="password" placeholder="Password" name="password">
            <button type="submit" href="#" class="button">Login</button>
        </form>
    </div>
</div>

<script>
    document.getElementById("button").addEventListener("click", function () {
        document.querySelector(".popup").style.display = "flex";
    })

    document.getElementById("close").addEventListener("click", function () {
        document.querySelector(".popup").style.display = "none";
    })
</script>

</body>
</html>
