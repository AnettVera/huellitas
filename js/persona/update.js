document.getElementById("consultabranch").addEventListener("submit", function (event) {
    event.preventDefault();
    var id_branch = document.getElementById("id_branch").value;

    fetch("http://localhost:8080/api/v1/branch/" + id_branch, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {

        document.getElementById("code").value = data.code;
        document.getElementById("address").value = data.address;
        document.getElementById("name").value = data.name;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

document.getElementById("actualizarBranch").addEventListener("submit", function (event) {
    event.preventDefault();
    var id_branch = document.getElementById("id_branch").value;
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;
    var code = document.getElementById("code").value;

    fetch("http://localhost:8080/api/v1/branch/", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({id_branch, name, address, code })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("response").innerHTML = JSON.stringify(data);
        if (data) {
            window.location.href = "index.html"
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});