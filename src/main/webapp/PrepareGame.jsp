<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Date" %>
<%@ page import="GameObjects.PlayersWaiting" %>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/prepare.css">
    <script type="text/javascript" src="Script/prepare.js"></script>
</head>
<body>
<% response.setHeader("Refresh", "1"); %>
<%
    HashSet<String> names = new HashSet<>();
    if(request.getSession(false)!=null){
        names = (HashSet<String>) request.getSession().getAttribute("names");
    }

    if (PlayersWaiting.getTimerSeconds() == 0){
        response.sendRedirect("WorldNavigatorGame.jsp");
    }
%>

<div class="container">
    <h1>Game will start in <%=PlayersWaiting.getTimerSeconds()%> seconds</h1>
    <h1>Number of players <%=names.size()%></h1><br>

    <h1>Player names</h1>
    <ol>
    <%
        for (String s : names) {%>
            <%= "<li>"+ s +"</li> <br>"%>
     <% }   %>
    </ol>
</div>

</body>
</html>
