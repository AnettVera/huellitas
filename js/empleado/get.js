document.addEventListener('DOMContentLoaded', function () {
    fetchAllEmployees();
});

function fetchAllEmployees() {
    fetch('http://localhost:8080/api/v1/empleado/')
        .then(response => response.json())
        .then(data => {
            displayEmployees(data);
        })
        .catch(error => console.error('Error al obtener los registros:', error));
}

function displayEmployees(employees) {
    let tableBody = document.querySelector('.table tbody');

    tableBody.innerHTML = '';

    employees.forEach(employee => {
        let row = tableBody.insertRow();

        // Celdas de la fila
        let checkboxCell = row.insertCell(0);
        let idCell = row.insertCell(1);
        let nameCell = row.insertCell(2);
        let turnCell = row.insertCell(3);
        let salaryCell = row.insertCell(4);

        // Contenido de las celdas
        checkboxCell.innerHTML = `<span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox${employee.id_e}" name="options" value="${employee.id_e}">
                                    <label for="checkbox${employee.id_e}"></label>
                                  </span>`;
        idCell.textContent = employee.id_e;
        nameCell.textContent = employee.nombre;
        turnCell.textContent = employee.turno;
        salaryCell.textContent = employee.salario;
    });
}
