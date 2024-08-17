window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function volverDepartamento() {
    window.location.href = '../departamentos.html';
}

async function guardarDepartamento(){
    const datos = {
        departament: document.getElementById('nombreDepartament').value,
        description: document.getElementById('descripcionDepartament').value
    };

    console.dir(datos);

    const cadena = JSON.stringify(datos);
	
	console.dir(cadena);

    try {
        const request = await fetch(`departaments`, {
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
