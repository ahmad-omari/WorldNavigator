<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/endgame.css">
    <script type="text/javascript" src="Script/endgame.js"></script>
</head>
<body>
<div class="container">
    <div id="winner"></div>
    <h1>game over</h1>
    <h1>winner is <%=request.getSession().getAttribute("usename").toString()%></h1>
    <button type="button" class="button" id="playagain">Play again</button>
    <button type="button" class="exitbtn" id="logout">Exit</button>
</div>
</body>
</html>
