document.addEventListener('DOMContentLoaded', function() {
    fetchAllPeople(); 
});

function fetchAllPeople() {
    fetch('http://localhost:8080/api/v1/person/') 
        .then(response => response.json())
        .then(data => {
            displayPeople(data);
        })
        .catch(error => console.error('Error al obtener los registros:', error));
}

function displayPeople(people) {
    let tableBody = document.querySelector('.table tbody');

    tableBody.innerHTML = '';

    people.forEach(person => {
        let row = tableBody.insertRow(); 

        // Celdas de la fila
        let checkboxCell = row.insertCell(0);
        let idCell = row.insertCell(1);
        let nameCell = row.insertCell(2);
        let numberCell = row.insertCell(3);
        let rolCell = row.insertCell(4);

        // Contenido de las celdas
        checkboxCell.innerHTML = `<span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox${person.id}" name="options[]" value="${person.id}">
                                    <label for="checkbox${person.id}"></label>
                                  </span>`;
        idCell.textContent = person.id; 
        nameCell.textContent = person.nombre;
        numberCell.textContent = person.tel; 
        rolCell.textContent= person.rol; // Corregido a person.rol
    });
}
