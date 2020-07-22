window.onload = function () {
    var logoutButton = document.getElementById('logout');

    if (logoutButton) {
        logoutButton.addEventListener('click', logout);
    }

    function logout() {
        if (window.confirm("Do you really want to leave the game?")) {
            window.location.href = "LogoutServlet"
        }
    }
}
