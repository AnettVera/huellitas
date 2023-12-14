document.getElementById('registroform').addEventListener('submit',function(event){
    event.preventDefault();
    let nombre = document.getElementById('nombre').value;
    let ape1= document.getElementById('ape1').value;
    let ape2= document.getElementById('ape2').value;
    let mail= document.getElementById('mail').value;
    let tel= document.getElementById('tel').value;
    let rol= document.getElementById('rol').value;

    fetch('http://localhost:8080/api/v1/person/',{
        method:'POST',
        headers:{
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify({nombre,ape1,ape2,mail,tel,rol})

    }).then(response => response.json())
    .then(data =>{
        document.getElementById('response').innerHTML = JSON.stringify(data);
        if(data){
            window.location.href ="crud.html"
        }
    })
})