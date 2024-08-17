window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
    const params = new URLSearchParams(window.location.search);

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }

        const codigo = params.get('codigo');

        await cargarUnDepartamento(codigo);
});

async function cargarUnDepartamento(cadenaDepartamento) {
    numero = Number(cadenaDepartamento)
      try {
            const request = await fetch(`departaments/${numero}`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });
            const registro = await request.json();

            let code = registro.cdepartament;
            let name = registro.departament;
            let descrip = registro.description;

            document.getElementById('codigoDepartament').value = code;
	        document.getElementById('nombreDepartament').value = name;
	        document.getElementById('descripcionDepartament').value = descrip;

	        console.log(document.getElementById('codigoDepartament'));
            console.log(document.getElementById('nombreDepartament'));
            console.log(document.getElementById('descripcionDepartament'));

      } catch (error) {
                    console.error('Error fetching data:', error);
           }
}

async function volverDepartamento() {
    window.location.href = '../departamentos.html';
}

async function guardarDepartamento(){
    const datos = {
        cdepartament: document.getElementById('codigoDepartament').value,
        departament: document.getElementById('nombreDepartament').value,
        description: document.getElementById('descripcionDepartament').value
    };

    console.log(datos);

    const cadena = JSON.stringify(datos);

    numero = Number(document.getElementById('codigoDepartament').value)

    try {
        const request = await fetch(`departaments/${numero}`, {
            method: 'PUT',
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
}
