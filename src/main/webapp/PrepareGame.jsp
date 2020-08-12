<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="time" scope="application" class="GameObjects.PlayersWaiting"/>
<html>
<head>
    <title>World Navigator</title>
    <link rel="stylesheet" type="text/css" href="Style/prepare.css">
    <script type="text/javascript">
        var waitingtime = "<%=time.getTimerSeconds()%>";
    </script>
    <script type="text/javascript" src="Script/prepare.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

</head>
<body>
<div class="container">
    <h1>Game will start in <%=time.getTimerSeconds()%> seconds</h1>
    <h1>Player names</h1>
    <ol>
        <c:forEach var="playername" items="${names}">
            <li> <c:out value="${playername}"/> </li>
        </c:forEach>
    </ol>
</div>
</body>
</html>
