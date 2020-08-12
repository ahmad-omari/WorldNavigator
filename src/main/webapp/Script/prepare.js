window.onload = function () {
    $(document).ready(function() {
        setInterval(function() {
            cache_clear()
        }, 1000);
    });

    function cache_clear() {
        window.location.reload(true);
        // window.location.reload(); use this if you do not remove cache
    }
    if(waitingtime <= 1){
        window.location.href = "Controller.MapsServlet";
    }
}
function logout() {
    if (window.confirm("Do you really want to exit game?")) {
        window.location.href = "LogoutServlet";
    }
}