document.getElementById('deleteForm').addEventListener('submit', function (event) {
    event.preventDefault();
    //Obtener el id del checkbox
    let id = document.querySelector('input[name="options"]:checked').value;
    console.log(id)
    fetch('http://localhost:8080/api/v1/empleado/' + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id })
    }).then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            if (data) {
                window.location.href = "crud.html"
            }
        })
})