window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    await cargarEmpleados();
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function cargarEmpleados() {
    try {
        const request = await fetch('employees', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const empleados = await request.json();

        let listadoHTML = '';
        for (let empleado of empleados) {
            let botonEliminar = '<a href="#" onclick="eliminarEmpleado(' + empleado.nemployee + ')" class="btn btn-danger btn-circle btn-sm" title="Borrar"><i class="fas fa-trash"></i></a>';
            let botonEditar = '<a href="#" onclick="editarEmpleado(' + empleado.nemployee + ')" class="btn btn-info btn-circle btn-sm" title="Editar"><i class="fas fa-info-circle"></i></a>';

            let empleadoHTML = '<tr><td>' + empleado.nemployee + '</td><td>'
                                          + empleado.fullname + '</td><td>'
                                          + empleado.phone + '</td><td>'
                                          + empleado.email + '</td><td>'
                                          + empleado.dadmission + '</td><td>'
                                          + botonEliminar + '  ' + botonEditar + '</td></tr>';

            listadoHTML += empleadoHTML;
        }

        document.querySelector('tbody').outerHTML = listadoHTML;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function eliminarEmpleado(nemployee) {
    if (!confirm('ATENCIÓN - ¿Desea eliminar este Empleado?')) {
        return;
    }

    try {
        const request = await fetch(`employees/${nemployee}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            }
        });

        location.reload();
    } catch (error) {
        console.error('Error deleting employee:', error);
    }
}

async function editarEmpleado(nemployee) {
    window.location.href = '../editempleados.html?codigo=' + encodeURIComponent(nemployee);
}