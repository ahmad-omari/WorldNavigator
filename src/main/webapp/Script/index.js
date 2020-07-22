window.onload = function () {
    var buttonLogin = document.getElementById("button");
    var buttonClose = document.getElementById("close");


    if (buttonLogin) {
        buttonLogin.addEventListener('click', login);
    }

    if (buttonClose) {
        buttonClose.addEventListener('click', close);
    }

    function login() {
        document.querySelector(".popup").style.display = "flex";
    }

    function close() {
        document.querySelector(".popup").style.display = "none";
    }
}