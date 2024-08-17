window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function volverEmpleado() {
    window.location.href = '../empleados.html';
}

async function guardarEmpleado(){
    if (document.getElementById('contraseñaEmployee').value !== "") {
            oculto = document.getElementById('contraseñaEmployee').value;
        } else {
                oculto= null;
    }

    if (document.getElementById('codDepartamentoEmployee').value === "" ) {
        datos = {
                fullname: document.getElementById('nombreEmployee').value,
                phone: document.getElementById('telefonoEmployee').value,
        		email: document.getElementById('emailEmployee').value,
        		dadmission: document.getElementById('fAltaEmployee').value,
        		salary: document.getElementById('salarioEmployee').value,
        		position: document.getElementById('responsableEmployee').value,
        		password: oculto
            };
    } else {
        datos = {
                fullname: document.getElementById('nombreEmployee').value,
                phone: document.getElementById('telefonoEmployee').value,
        		email: document.getElementById('emailEmployee').value,
        		dadmission: document.getElementById('fAltaEmployee').value,
        		salary: document.getElementById('salarioEmployee').value,
        		position: document.getElementById('responsableEmployee').value,
        		password: oculto,
        		departaments: {cdepartament: document.getElementById('codDepartamentoEmployee').value}
            };
    }

    console.dir(datos);
   //alert();

    const cadena = JSON.stringify(datos);
    console.dir(cadena);

    try {
        const request = await fetch(`employees`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            body: cadena // Aquí pasamos la cadena JSON
        });

        alert('Cambio realizado.');

        } catch (error) {
                         console.error('Error fetching data:', error);
                }
				
	window.location.href = '../index.html';
}
