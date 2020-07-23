function logout() {
    if (window.confirm("Do you really want to exit game?")) {
        window.location.href = "LogoutServlet";
    }
}