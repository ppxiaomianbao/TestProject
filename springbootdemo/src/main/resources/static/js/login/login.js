$(function () {
    $("#export").on("click",function () {
        exports();
    })

    $("#export1").on("click",function () {
        exports1();
    })
    //myWebsocket();
    
})

function myWebsocket() {
    //判断当前浏览器是否支持webSocket
    var ws;
    if('WebSocket' in window){
        ws = new WebSocket("ws://localhost:8080/demo/websocketTest");
    }else{
        alert('Not support websocket');
    }
    if (ws.readyState === 1) {
        ws.send("hello");//向服务器发送消息
    } else {
        //do something
    }
// 建立 web socket 连接成功触发事件
    ws.onopen = function() {
        // 使用 send() 方法发送数据
        ws.send('发送数据');
        alert('数据发送中...');
    };

// 接收服务端数据时触发事件
    ws.onmessage = function(evt) {
        var received_msg = evt.data;
        alert('数据已接收...');
    };

// 断开 web socket 连接成功触发事件
    ws.onclose = function() {
        alert('连接已关闭...');
    };
}

function exports() {
    var url = getPath() + "/login/exports";
    /*var html = "<from method='get' id='exportTest'></from>";
    $("#exportTest").attr("action",url);
    $("body").appendTo(html);
    $("#exportTest").submit();*/
    window.location.href=url;
}

function exports1() {
    debugger;
    var url = getPath() + "/login/exports1";
    var html = "<form method='get' id='exportTest'></form>";
    $("body").append(html);
    $("#exportTest").attr("action",url);
    $("#exportTest").submit();
    //window.location.href=url;
}

function getPath(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}