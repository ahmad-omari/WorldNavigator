<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="GameObjects.PlayerInfo" %>
<%@ page import="GameObjects.ImagesPath" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String userName = null;
    String playerid = null;
    int numberOfPlayers = 0;
    JSONObject jsonObject=null;
    if(request.getSession(false)!=null){
        userName = (String)request.getSession().getAttribute("name");
        numberOfPlayers = (int) request.getSession().getAttribute("numberofplayers");
        jsonObject = PlayerInfo.getJSONObject(request.getSession().getId());
        playerid = request.getSession().getId();
    }
    if(userName == null) response.sendRedirect("index.jsp");
%>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/WorldNavigatorGame.css">
    <script type="text/javascript">
        var playerID = "<%=playerid%>";
        var mapID = "<%=jsonObject.get("gameID")%>";
    </script>
    <script type="text/javascript" src="Script/worldnavigatorgame.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<div class="centerAll">
    <h1>World Navigator Game</h1> <br>
    <h3>Game ID:<%=jsonObject.get("gameID")%></h3> <br>
    <h3>Number of rooms:<%=jsonObject.get("numberOfRooms")%></h3> <br>

    <h3>Number of players:<%=numberOfPlayers%></h3> <br>
    <h3>Game time: 2 Hours</h3> <br>
    <h3>Room number:<%=jsonObject.get("roomNumber")%></h3> <br>
    <hr>
    <table class="center">
        <tr>
            <th colspan="5"><img src=<%=ImagesPath.getPath(jsonObject.get("northSide").toString())%>></th>
        </tr>
        <tr>
            <th rowspan="3"><img src=<%=ImagesPath.getPath(jsonObject.get("eastSide").toString())%>></th>
            <th colspan="3"><img src=<%=ImagesPath.getArrowPath((int)jsonObject.get("direction"),"north")%>></th>
            <th rowspan="3"><img src=<%=ImagesPath.getPath(jsonObject.get("westSide").toString())%>></th>
        </tr>
        <tr>
            <th><img src=<%=ImagesPath.getArrowPath((int)jsonObject.get("direction"),"east")%>></th>
            <th><%=userName %></th>
            <th><img src=<%=ImagesPath.getArrowPath((int)jsonObject.get("direction"),"west")%>></th>
        </tr>
        <tr>
            <th colspan="3"><img src=<%=ImagesPath.getArrowPath((int)jsonObject.get("direction"),"south")%>></th>
        </tr>
        <tr>
            <th colspan="5"><img src=<%=ImagesPath.getPath(jsonObject.get("southSide").toString())%>></th>
        </tr>
    </table>
    <br>
    <hr>
    <br>
    <button type="button" name="forward" value="forward" class="button" id="forward">Forward</button> <br>
    <button type="button" name="left" value="left" class="button" id="left">Left</button>
    <button type="button" name="right" value="right" class="button" id="right">Right</button> <br>
    <button type="button" name="backward" value="backward" class="button" id="backward">Backward</button>
    <br> <br>
</div>

<div class="commands">
    <h3>Result:</h3>
    <p><%=jsonObject.get("result")%></p>
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
