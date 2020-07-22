<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/WorldNavigatorGame.css">
    <script type="text/javascript" src="Script/worldnavigatorgame.js"></script>
</head>
<body>
<%
    String userName = null;

    if(request.getSession(false)!=null){
        userName = (String)request.getSession().getAttribute("name");
    }

    if(userName == null) response.sendRedirect("index.jsp");
%>
<div class="centerAll">
    <h1>World Navigator Game</h1> <br>
    <h3>Number of players:</h3> <br>
    <h3>Game time:</h3> <br>
    <h3>timer:</h3> <br>
    <h3>Gold:</h3> <br>
    <h3>Room number:</h3> <br>

    <hr>

    <table class="center">
        <tr>
            <th colspan="5"><img src="icons/chestimg.png"></th>
        </tr>
        <tr>
            <th rowspan="3"><img src="icons/doorimg.png"></th>
            <th colspan="3"><img src="icons/uparrow.png"></th>
            <th rowspan="3"><img src="icons/mirrorimg.png"></th>
        </tr>
        <tr>
            <th><img src="icons/leftarrow.png"></th>
            <th><%=userName %></th>
            <th><img src="icons/rightarrow.png"></th>
        </tr>
        <tr>
            <th colspan="3"><img src="icons/downarrow.png"></th>
        </tr>
        <tr>
            <th colspan="5"><img src="icons/plainwallimg.png"></th>
        </tr>
    </table>
    <br>
    <hr>
    <br>

    <button type="button" name="forward" value="forward" class="button">Forward</button> <br>
    <button type="button" name="left" value="left" class="button">Left</button>
    <button type="button" name="right" value="right" class="button">Right</button> <br>
    <button type="button" name="backward" value="backward" class="button">Backward</button>
    <br> <br>
</div>

<div class="commands">
    <h3>Result:</h3>
    <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
    <button type="button" name="look" value="look" class="button">Look</button>
    <button type="button" name="check" value="check" class="button">Check</button>
    <button type="button" name="open" value="open" class="button">Open</button>
    <button type="button" name="useflash" value="useflashlight" class="button" >Use Flashlight</button>
    <button type="button" name="usekey" value="usekey" class="button" >Use Key</button>
    <button type="button" name="switchlight" value="switchlight" class="button" >Switch Light</button>
    <button type="button" name="playerstatus" value="playerstatus" class="button" >Player Status</button><br> <br>
    <button type="button" name="trade" value="trade" class="button" >Trade</button> <br>

    <label for="itemsbuy">Choose Seller items:</label>
    <select name="items" id="itemsbuy">
        <option value="empty"></option>
        <option value="flashlight">Flashlight</option>
        <option value="golden">Golden Key</option>
        <option value="magic">Magic Key</option>
        <option value="silver">Silver Key</option>
    </select>
    <button type="button" name="buy" value="buy" class="button" disabled>Buy</button> <br>

    <label for="itemssell">Choose from your items:</label>
    <select name="items" id="itemssell">
        <option value="empty"></option>
        <option value="flashlight">Flashlight</option>
        <option value="golden">Golden Key</option>
        <option value="magic">Magic Key</option>
        <option value="silver">Silver Key</option>
    </select>
    <button type="button" name="sell" value="sell" class="button" disabled>Sell</button> <br>
    <button type="button" name="finish" value="finish" class="button" disabled>Finish Trade</button> <br> <br>
    <button type="button" class="exitbtn" id="logout">Log Out</button>
    <br> <br>
</div>

</body>
</html>
