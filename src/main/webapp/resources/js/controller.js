<!-- controller -->
var label       ;
var sequence_id ;
var email       ;
var password    ;

var btnSend  ;
var btnStop  ;
var btnStart ;
var socket   ;


$(document).ready(function() {
    label       = document.getElementById("status");
    sequence_id = document.getElementById("sequence_id");
    email       = document.getElementById("email");
    password    = document.getElementById("password");

    btnSend  = document.getElementById("send");
    btnStop  = document.getElementById("stop");
    btnStart = document.getElementById("start");

    $( "#send").addClass( "disabled");
    $( "#stop").addClass( "disabled");

    btnSend.onclick = function() {
        if (socket.readyState === WebSocket.OPEN) {
            var message = {}
            message["type"] = "LOGIN_CUSTOMER";
            message["sequence_id"] = sequence_id.value;
            message["data"] = {
                "email": email.value,
                "password": password.value
            };
            socket.send(JSON.stringify(message));
        }
        successNoty("Сообщение отправлено");
    }

    btnStop.onclick = function() {

        $("#send" ).addClass(    "disabled");
        $("#stop" ).addClass(    "disabled");
        $("#start").removeClass( "disabled");
        socket.close();
        successNoty( "Сессия закрыта")
    };

    btnStart.onclick = function() {

        $( "#send" ).removeClass( "disabled");
        $( "#stop" ).removeClass( "disabled");
        $( "#start").addClass( "disabled");


        socket = new WebSocket( "ws://localhost:8080/fasten/echo");

        socket.onopen = function( evt){
            successNoty("Открыто соединение");
            label.innerHTML = "Connection opened";
        };



        socket.onclose = function( evt){
            successNoty("Закрыто соединение");
            label.innerHTML = "Connection closed";
            var code = evt.code;
            var reason = evt.reason;
            var wasClean = event.wasClean;
            if( wasClean)
            {
                label.innerHTML = "Closed correctly";
            }
            else{
                label.innerHTML = "Closed UNcorrectly";
            };
        };


        socket.onmessage = function( evt){
            if( typeof evt.data === 'string')  {
                label.innerHTML = evt.data;
            }
            successNoty( "Получено сообщение");
        };
    }



});




<!-- Noty -->
function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + errorInfo,
        type: 'error',
        layout: 'bottomRight'
    });
}


function mfailNoty( message) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + message,
        type: 'error',
        layout: 'bottomRight'
    });
}