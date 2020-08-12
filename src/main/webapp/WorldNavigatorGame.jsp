<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="GameObjects.PlayerInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="path" class="GameObjects.ImagesPath"></jsp:useBean>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/WorldNavigatorGame.css">
    <script type="text/javascript">
        var playerID = "<%=request.getSession(false).getId()%>";
        var playerName = "<%=(String)request.getSession(false).getAttribute("name")%>";
        var mapID = "<%=PlayerInfo.getJSONObject(request.getSession(false).getId()).get("gameID")%>";
        var isGameFinished = false;
    </script>
    <script type="text/javascript" src="Script/worldnavigatorgame.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="centerAll">
    <h1>World Navigator Game</h1> <br>
    <h3>Game ID:<%=PlayerInfo.getJSONObject(request.getSession(false).getId()).get("gameID")%></h3>
    <h3>Game time: 2 Hours</h3>
    <h3>Number of rooms:<%=PlayerInfo.getJSONObject(request.getSession(false).getId()).get("numberOfRooms")%></h3>
    <h3>Number of players:<%=(int) request.getSession(false).getAttribute("numberofplayers")%></h3>
    <h3>Room number:<%=PlayerInfo.getJSONObject(request.getSession(false).getId()).get("roomNumber")%></h3>
    <hr>
    <table class="center">
        <tr>
            <th colspan="5"><img src=<%=path.getPath(PlayerInfo.getJSONObject(request.getSession(false).getId()).get("northSide").toString())%>></th>
        </tr>
        <tr>
            <th rowspan="3"><img src=<%=path.getPath(PlayerInfo.getJSONObject(request.getSession(false).getId()).get("eastSide").toString())%>></th>
            <th colspan="3"><img src=<%=path.getArrowPath((int)PlayerInfo.getJSONObject(request.getSession(false).getId()).get("direction"),"north")%>></th>
            <th rowspan="3"><img src=<%=path.getPath(PlayerInfo.getJSONObject(request.getSession(false).getId()).get("westSide").toString())%>></th>
        </tr>
        <tr>
            <th><img src=<%=path.getArrowPath((int)PlayerInfo.getJSONObject(request.getSession(false).getId()).get("direction"),"east")%>></th>
            <th><h1><%=(String)request.getSession(false).getAttribute("name") %></h1></th>
            <th><img src=<%=path.getArrowPath((int)PlayerInfo.getJSONObject(request.getSession(false).getId()).get("direction"),"west")%>></th>
        </tr>
        <tr>
            <th colspan="3"><img src=<%=path.getArrowPath((int)PlayerInfo.getJSONObject(request.getSession(false).getId()).get("direction"),"south")%>></th>
        </tr>
        <tr>
            <th colspan="5"><img src=<%=path.getPath(PlayerInfo.getJSONObject(request.getSession(false).getId()).get("southSide").toString())%>></th>
        </tr>
    </table>
    <hr>
    <br>
    <button type="button" name="forward" value="forward" class="button" id="forward">Forward</button> <br>
    <button type="button" name="left" value="left" class="button" id="left">Left</button>
    <button type="button" name="right" value="right" class="button" id="right">Right</button> <br>
    <button type="button" name="backward" value="backward" class="button" id="backward">Backward</button>
    <br>
</div>

<div class="commands">
    <h3>Result:</h3>
    <p><%=PlayerInfo.getJSONObject(request.getSession(false).getId()).get("result")%></p>
    <div id="somediv"></div>
    <button type="button" name="look" value="look" class="button" id="look">Look</button>
    <button type="button" name="check" value="check" class="button" id="check">Check</button>
    <button type="button" name="open" value="open" class="button" id="open">Open</button>
    <button type="button" name="useflash" value="useflashlight" class="button" id="useflashlight">Use Flashlight</button>
    <button type="button" name="usekey" value="usekey" class="button" id="usekey">Use Key</button>
    <button type="button" name="switchlight" value="switchlight" class="button" id="switchlight">Switch Light</button>
    <button type="button" name="playerstatus" value="playerstatus" class="button" id="playerstatus">Player Status</button><br> <br>
    <button type="button" name="trade" value="trade" class="button" id="trade">Trade</button> <br>

    <label for="itemsbuy">Choose Seller items:</label>
    <select name="itemtobuy" id="itemsbuy">
        <option value="empty"></option>
        <option value="flashlight">Flashlight</option>
        <option value="goldenkey">Golden Key</option>
        <option value="magickey">Magic Key</option>
        <option value="silverkey">Silver Key</option>
    </select>
    <button type="button" name="buy" value="buy" class="button" id="buy">Buy</button> <br>

    <label for="itemssell">Choose from your items:</label>
    <select name="itemtosell" id="itemssell">
        <option value="empty"></option>
        <option value="flashlight">Flashlight</option>
        <option value="goldenkey">Golden Key</option>
        <option value="magickey">Magic Key</option>
        <option value="silverkey">Silver Key</option>
    </select>
    <button type="button" name="sell" value="sell" class="button" id="sell">Sell</button> <br>
    <button type="button" name="finish" value="finish" class="button" id="finish">Finish Trade</button> <br> <br>
    <button type="button" class="exitbtn" id="logout">Log Out</button>
    <br> <br>
</div>

</body>
</html>
