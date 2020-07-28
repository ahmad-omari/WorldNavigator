window.onload = function () {
    var logoutButton = document.getElementById('logout');
    var playButton = document.getElementById('playagain');

    if (logoutButton) {
        logoutButton.addEventListener('click', logout);
    }

    if (playButton) {
        playButton.addEventListener('click', play);
    }

    function logout() {
        window.location.href = "LogoutServlet";
    }

    function play() {
        window.location.href = "GameLoaderServlet";
    }
}