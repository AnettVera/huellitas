document.getElementById("consultarempleado").addEventListener("submit", function (event) {
    event.preventDefault();
    var id_e = document.getElementById("id_e").value;

    fetch("http://localhost:8080/api/v1/empleado/" + id_e, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(data => {

            document.getElementById("nombre").value = data.nombre;
            document.getElementById("turno").value = data.turno;
            document.getElementById("salario").value = data.salario;
         
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

document.getElementById("update_form").addEventListener("submit", function (event) {
    event.preventDefault();
    var id_e = document.getElementById("id_e").value;
    var nombre = document.getElementById("nombre").value;
    var turno = document.getElementById("turno").value;
    var salario = document.getElementById("salario").value;
   
    fetch("http://localhost:8080/api/v1/empleado/", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ id_e,nombre,turno,salario})
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