$(document).ready(function () {
  let btnRegistrar = document.getElementById("btnRegistrar");
  let btnUpdate = document.getElementById("btnUpdate");
  btnUpdate.style.display = "none";

  tabla();
});

async function tabla() {
  const response = await fetch("api/usuarios", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  const res = await response.json();

  let listadoHtml = "";

  for (let usuario of res) {
    let botonEliminar =
      '<a href="#" onclick="deleteUser(' +
      usuario.id +
      ')" class="btn btn-danger btn-circle btn-sm"> ELIMINAR</a>';

    let botonEditar =
      '<a onclick="usuario(' +
      usuario.id +
      ')" class="btn btn-warning btn-circle btn-sm">ACTUALIZAR</a>';

    let usuarioHtml =
      "<tr><td>" +
      usuario.id +
      "</td><td> " +
      usuario.name +
      " </td><td> " +
      usuario.lastname +
      "</td><td>" +
      usuario.email +
      "</td><td> " +
      usuario.telephone +
      " </td><td>" +
      botonEliminar +
      botonEditar;
    (" </td></tr>");

    listadoHtml += usuarioHtml;
  }
  document.querySelector("#tabla tbody").outerHTML = listadoHtml;

  //captulamos el elemtno html a la que le vamos agregar los datos
}

async function deleteUser(id) {
  if (!confirm("¿Desea eliminar este Usuario?")) {
    return;
  }
  const response = await fetch("api/usuarios/" + id, {
    method: "DELETE",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  location.reload();
}
var idUser = "";

async function usuario(id) {
  btnUpdate.style.display = "block";
  btnRegistrar.style.display = "none";
  idUser = id;
  const response = await fetch("api/usuario/" + id, {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  const res = await response.json();

  document.getElementById("txtName").value = res.name;
  document.getElementById("txtLastName").value = res.lastname;
  document.getElementById("txtEmail").value = res.email;
  document.getElementById("txtTelephone").value = res.telephone;
  document.getElementById("btnRegistrarUpdate").onclick = update();

  // let btnRegistrar = document.getElementById("btnRegistrar");
  // let btnUpdate = document.getElementById("btnUpdate");
  Event.preventDefault();
}

async function update() {
  if (
    document.getElementById("txtName").value === "" ||
    document.getElementById("txtLastName").value == "" ||
    document.getElementById("txtEmail").value == "" ||
    document.getElementById("txtTelephone").value == ""
  ) {
    alert("tienes que llenar todos los campos");
  } else {
    let datos = {};
    datos.name = document.getElementById("txtName").value;
    datos.lastname = document.getElementById("txtLastName").value;
    datos.email = document.getElementById("txtEmail").value;
    datos.telephone = document.getElementById("txtTelephone").value;

    let IdUsers = idUser;

    const response = await fetch("api/usuario/" + IdUsers, {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(datos),
    });
    Event.preventDefault();

    // const res = await response.json();
  }
}

async function registrarUsuario() {
  if (
    document.getElementById("txtName").value === "" ||
    document.getElementById("txtLastName").value == "" ||
    document.getElementById("txtEmail").value == "" ||
    document.getElementById("txtTelephone").value == ""
  ) {
    alert("tienes que llenar todos los campos");
  } else {
    let datos = {};
    datos.name = document.getElementById("txtName").value;
    datos.lastname = document.getElementById("txtLastName").value;
    datos.email = document.getElementById("txtEmail").value;
    datos.telephone = document.getElementById("txtTelephone").value;

    const response = await fetch("api/usuarios", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(datos),
    });

    document.getElementById("txtName").value = "";
    document.getElementById("txtLastName").value = "";
    document.getElementById("txtEmail").value = "";
    document.getElementById("txtTelephone").value = "";
    location.reload();
    Event.preventDefault();
  }
}
