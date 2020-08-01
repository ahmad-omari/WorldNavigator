window.onload = function () {
    var buttonLogin = document.getElementById("button");
    var buttonLoginSubmit = document.getElementById("loginuser");
    var buttonClose = document.getElementById("close");
    var buttonRegister = document.getElementById("regsubmit");


    if (buttonLogin) {
        buttonLogin.addEventListener('click', login);
    }

    if (buttonLoginSubmit) {
        buttonLoginSubmit.addEventListener('click', loginUser);
    }

    if (buttonClose) {
        buttonClose.addEventListener('click', close);
    }

    if (buttonRegister) {
        buttonRegister.addEventListener('click', register);
    }

    function login() {
        document.querySelector(".popup").style.display = "flex";
    }

    function close() {
        document.querySelector(".popup").style.display = "none";
    }

    function register() {
        $.ajax({
                url:'Controller.RegisterServlet',
                data:{uname:$('#regname').val(),pass:$('#regpassword').val()},
                type:'post',
                cache:false,
                success:function(data){
                    $('#registerdiv').text(data);
                },
                error:function(){
                    alert('error');
                }
            }
        );
    }

    function loginUser() {
        $.ajax({
                url:'Controller.LoginServlet',
                data:{uname:$('#logname').val(),pass:$('#logpassword').val()},
                type:'post',
                cache:false,
                success:function(data){
                    if(data === 'True'){
                        window.location.href = 'GameLoaderServlet';
                    }else{
                        $('#logindiv').text(data);
                    }
                },
                error:function(){
                    alert('error');
                }
            }
        );
    }
}