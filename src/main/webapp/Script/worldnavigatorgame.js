window.onload = function () {
    var logoutButton = document.getElementById('logout');

    var forwardButton = document.getElementById('forward');
    var backwardButton = document.getElementById('backward');
    var leftButton = document.getElementById('left');
    var rightButton = document.getElementById('right');

    var lookButton = document.getElementById('look');
    var checkButton = document.getElementById('check');
    var openButton = document.getElementById('open');
    var useFlashlightButton = document.getElementById('useflashlight');
    var useKeyButton = document.getElementById('usekey');
    var switchLightButton = document.getElementById('switchlight');
    var playerStatusButton = document.getElementById('playerstatus');
    var tradeButton = document.getElementById('trade');

    var buyButton = document.getElementById('buy');
    var sellButton = document.getElementById('sell');
    var finishTradeButton = document.getElementById('finish');

    if (forwardButton) {
        forwardButton.addEventListener('click', makeForward);
    }
    if (backwardButton) {
        backwardButton.addEventListener('click', makeBackward);
    }
    if (leftButton) {
        leftButton.addEventListener('click', turnLeft);
    }
    if (rightButton) {
        rightButton.addEventListener('click', turnRight);
    }

    if (lookButton) {
        lookButton.addEventListener('click', makeLook);
    }
    if (checkButton) {
        checkButton.addEventListener('click', makeCheck);
    }
    if (openButton) {
        openButton.addEventListener('click', open);
    }
    if (useFlashlightButton) {
        useFlashlightButton.addEventListener('click', useFlashlight);
    }
    if (useKeyButton) {
        useKeyButton.addEventListener('click', useKey);
    }
    if (switchLightButton) {
        switchLightButton.addEventListener('click', switchLight);
    }
    if (playerStatusButton) {
        playerStatusButton.addEventListener('click', playerStatus);
    }
    if (tradeButton) {
        tradeButton.addEventListener('click', makeTrade);
    }

    if (buyButton) {
        buyButton.addEventListener('click', buyItem);
    }
    if (sellButton) {
        sellButton.addEventListener('click', sellItem);
    }
    if (finishTradeButton) {
        finishTradeButton.addEventListener('click', finishTrade);
    }

    if (logoutButton) {
        logoutButton.addEventListener('click', logout);
    }


    function makeForward() {
        commandRequest("forward");
    }
    function makeBackward() {
        commandRequest("backward");
    }
    function turnLeft() {
        commandRequest("left");
    }
    function turnRight() {
        commandRequest("right");
    }

    function makeLook() {
        commandRequest("look");
    }

    function makeCheck() {
        commandRequest("check");
    }
    function open() {
        commandRequest("open");
    }
    function useFlashlight() {
        commandRequest("useflashlight");
    }
    function useKey() {
        commandRequest("usekey");
    }
    function switchLight() {
        commandRequest("switchlight");
    }
    function playerStatus() {
        commandRequest("playerstatus");
    }
    function makeTrade() {
        commandRequest("trade");
    }

    function buyItem() {
        var itemsbuy = document.getElementById('itemsbuy');
        var selecteditem = "buy "+itemsbuy.options[itemsbuy.selectedIndex].value;
        commandRequest(selecteditem);
    }
    function sellItem() {
        var itemssell = document.getElementById('itemssell');
        var selecteditem = "sell "+itemssell.options[itemssell.selectedIndex].value;
        commandRequest(selecteditem);
    }
    function finishTrade() {
        commandRequest("finish");
    }

    function logout() {
        if (window.confirm("Do you really want to leave the game?")) {
            window.location.href = "LogoutServlet";
        }
    }

    function commandRequest(cmd) {
        $.ajax({
                url:'CommandRequestServlet',
                data:{command:cmd,IDPlayer:playerID,gameID:mapID},
                type:'get',
                cache:false,
                success:function(data){
                    $('#somediv').text(data);
                    if (cmd=='forward' || cmd=='backward' || cmd=='left' || cmd=='right') {
                        location.reload();
                    }
                },
                error:function(){
                    alert('error');
                }
            }
        );
    }
}
