window.addEventListener('DOMContentLoaded', async event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
    const params = new URLSearchParams(window.location.search);

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }

        const codigo = params.get('codigo');

        await cargarUnEmpleado(codigo);
});

async function cargarUnEmpleado(cadenaEmpleado) {
    numero = Number(cadenaEmpleado)
      try {
            const request = await fetch(`employees/${numero}`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });
            const registro = await request.json();
            console.dir(registro);
            //alert('Me paro aqui');

            let codEmpleado = registro.nemployee;
            let nombre = registro.fullname;
            let telefono = registro.phone;
			let email = registro.email;
			let fAlta = registro.dadmission;
			let salario = registro.salary;
			let contraseña = registro.password;
			let responsable = registro.position;
			if (registro.departaments === null) {
			    codDepartamento = "";
			    } else {
			            codDepartamento = registro.departaments.cdepartament;
			}

            document.getElementById('codigoEmployee').value = codEmpleado;
	        document.getElementById('nombreEmployee').value = nombre;
	        document.getElementById('telefonoEmployee').value = telefono;
			document.getElementById('emailEmployee').value = email;
			document.getElementById('fAltaEmployee').value = fAlta;
			document.getElementById('salarioEmployee').value = salario;
			document.getElementById('contraseñaEmployee').value = contraseña;
			document.getElementById('responsableEmployee').value = responsable;
			document.getElementById('codDepartamentoEmployee').value = codDepartamento;

	        console.dir(registro);

      } catch (error) {
                    console.error('Error fetching data:', error);
           }
}

async function volverEmpleado() {
    window.location.href = '../empleados.html';
}

async function guardarEmpleado(){
    if (document.getElementById('contraseñaEmployee').value !== null) {
            oculto = document.getElementById('contraseñaEmployee').value;
        } else {
                oculto= null;
    }

    if (document.getElementById('codDepartamentoEmployee').value === "" ) {
        datos = {
                nemployee: document.getElementById('codigoEmployee').value,
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
                nemployee: document.getElementById('codigoEmployee').value,
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

    numero = Number(document.getElementById('codigoEmployee').value)

    try {
        const request = await fetch(`employees/${numero}`, {
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
