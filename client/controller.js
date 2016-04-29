window.onload = function(){
  var label       = document.getElementById("status");
  var sequence_id = document.getElementById("sequence_id");
  var email       = document.getElementById("email");
  var password    = document.getElementById("password");

  var btnSend = document.getElementById("send");
  var btnStop = document.getElementById("stop");
    
    
  btnSend.onclick = function(){
      if( socket.readyState === WebSocket.OPEN){
          var message = {}
          message[ "type"] = "LOGIN_CUSTOMER";
          message[ "sequence_id"] = sequence_id.value;
          message[ "data"] = {
              "email"   : email.value,
              "password": password.value
          };
          socket.send( JSON.stringify( message));
      }
      console.log( "send pressed");
      
  };
  
    <!--
  var socket = new WebSocket( "ws://echo.websocket.org");
    -->
  var socket = new WebSocket( "ws://localhost:8080/echo");
    
  socket.onopen = function( evt){
      console.log( "Connection opened");
      label.innerHTML = "Connection opened";      
  };    
    
  socket.onclose = function( evt){
      console.log( "Connection closed");
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
  };
    
};

/*
1. поддержка WS браузерами
2. создание объекта
3. соединение с сервером
4. назначение обработчиков событий
5. обмен информацией с сервером
6. закрытие соединения
*/