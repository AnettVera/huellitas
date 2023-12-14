document.getElementById("consultarperson").addEventListener("submit", function (event) {
    event.preventDefault();
    var id = document.getElementById("id").value;

    fetch("http://localhost:8080/api/v1/person/" + id, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {

        document.getElementById("nombre").value=data.nombre;
        document.getElementById("ape1").value=data.ape1;
        document.getElementById("ape2").value=data.ape2;
        document.getElementById("mail").value=data.mail;
        document.getElementById("tel").value=data.tel;
        document.getElementById("rol").value =data.rol;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

document.getElementById("update_form").addEventListener("submit", function (event) {
    event.preventDefault();
    var id = document.getElementById("id").value;
    var nombre = document.getElementById("nombre").value;
    var ape1 = document.getElementById("ape1").value;
    var ape2 = document.getElementById("ape2").value;
    var mail = document.getElementById("mail").value;
    var tel = document.getElementById("tel").value;
    var rol= document.getElementById("rol").value;
    fetch("http://localhost:8080/api/v1/person/", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({id,nombre,ape1,ape2,mail,tel,rol})
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("response").innerHTML = JSON.stringify(data);
        if (data) {
            window.location.href = "crud.html"
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});