document.getElementById('registroform').addEventListener('submit', function (event) {
    event.preventDefault();
    let nombre = document.getElementById('nombre').value;
    let turno = document.getElementById('turno').value;
    let salario = document.getElementById('salario').value;

    fetch('http://localhost:8080/api/v1/empleado/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, turno, salario })

    }).then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            if (data) {
                window.location.href = "crud.html"
            }
        })
})