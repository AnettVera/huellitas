
document.addEventListener('DOMContentLoaded', function() {
   
    fetchAllBranches();
});


function fetchAllBranches() {
    fetch('http://localhost:8080/api/v1/person/') 
        .then(response => response.json())
        .then(data => {
           
            displayBranches(data);
        })
        .catch(error => console.error('Error al obtener sucursales:', error));
}

function displayBranches(branches) {
    let tableBody = document.querySelector('.table tbody');

 
    tableBody.innerHTML = '';

    branches.forEach(branch => {
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
        nameCell.textContent = person.nombre+" "+person.ape1+" "+person.ape2;
        numberCell.textContent = person.tel; 
        rolCell.textContent= person.tel;


    });
}
