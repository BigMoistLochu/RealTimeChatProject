$(document).ready(function(){
    $('#action_menu_btn').click(function(){
        $('.action_menu').toggle();
    });
});


var client = null;
var color;


function showMessage(value, user, userColor) {
    // Tworzenie głównego diva <div class="d-flex justify-content-start mb-4">
    var mainDiv = document.createElement('div');
    mainDiv.classList.add('d-flex', 'justify-content-start', 'mb-4');

    // Tworzenie diva <div class="img_cont_msg">
    var imgDiv = document.createElement('div');
    imgDiv.classList.add('img_cont_msg');

    // Tworzenie <img> dla obrazka
    var img = document.createElement('img');
    img.src = "https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg";
    img.classList.add('rounded-circle', 'user_img_msg');

    // Tworzenie diva <div class="msg_cotainer">
    var msgDiv = document.createElement('div');
    msgDiv.classList.add('msg_cotainer');

    // Tworzenie treści wiadomości
    var messageContent = document.createTextNode(value);



    // Ustawienie koloru tekstu w divie <div class="msg_cotainer">


    // Składanie elementów razem
    imgDiv.appendChild(img);
    msgDiv.appendChild(messageContent);

    mainDiv.appendChild(imgDiv);
    mainDiv.appendChild(msgDiv);

    // Pobranie elementu <div> o id "chat"
    var chatContainer = document.getElementById('chat');

    // Dodanie nowego bloku odpowiedzi do kontenera "chat"
    chatContainer.appendChild(mainDiv);
}



function connect() {
    client = Stomp.client('ws://localhost:8080/chat');

    client.connect({}, function (frame) {
        client.subscribe("/topic/messages", function(message){
            showMessage(JSON.parse(message.body).value, JSON.parse(message.body).user, JSON.parse(message.body).userColor)
        });
    })
}

function sendMessage() {

    var messageToSend = document.getElementById('messageToSend').value;
    // var user = document.getElementById('user').value;
    // 'user': user,
    client.send("/app/chat", {}, JSON.stringify({'value': messageToSend}) );
    document.getElementById('messageToSend').value = "";
}
