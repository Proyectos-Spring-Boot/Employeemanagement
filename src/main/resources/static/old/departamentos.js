window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    await cargarDepartamentos();
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function cargarDepartamentos() {
    try {
        const request = await fetch('departaments', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const departamentos = await request.json();

        let listadoHTML = '';
        for (let departamento of departamentos) {
            let botonEliminar = '<a href="#" onclick="eliminarDepartamento(' + departamento.cdepartament + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
            let botonEditar = '<a href="#" onclick="editarDepartamento(' + departamento.cdepartament + ')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>';

            let departamentoHTML = '<tr><td>' + departamento.cdepartament + '</td><td>' + departamento.departament + '</td><td>' + botonEliminar + '  ' + botonEditar + '</td></tr>';

            listadoHTML += departamentoHTML;
        }

        document.querySelector('tbody').outerHTML = listadoHTML;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function eliminarDepartamento(cdepartament) {
    if (!confirm('ATENCIÓN - ¿Desea eliminar este Departamento?')) {
        return;
    }

    try {
        const request = await fetch(`departaments/${cdepartament}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            }
        });

        location.reload();
    } catch (error) {
        console.error('Error deleting department:', error);
    }
}

async function editarDepartamento(cdepartament) {
    numero = Number(cdepartament)
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



        try {
            console.dir(registro);
            window.location.href = '../editdepartamentos.html?codigo=' + encodeURIComponent(code) + '&nombre=' + encodeURIComponent(name) + '&descripcion=' + encodeURIComponent(descrip);
        } catch (error) {
            console.error('Error loading the web page editdepartamentos.html:', error);
        }
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}
