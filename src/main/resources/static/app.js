const endpoints = {
	productos: "/productos",
	clientes: "/clientes",
	pedidos: "/pedidos"
};

const formatCurrency = new Intl.NumberFormat("es-AR", {
	style: "currency",
	currency: "ARS"
});

async function fetchJson(url, options) {
	const response = await fetch(url, options);

	if (!response.ok) {
		throw new Error("Error al comunicarse con el servidor");
	}

	return response.json();
}

function renderEmpty(tbody, columns, message) {
	tbody.innerHTML = `<tr><td class="empty" colspan="${columns}">${message}</td></tr>`;
}

function renderProductos(productos) {
	const tbody = document.querySelector("#productos-tabla");
	document.querySelector("#total-productos").textContent = productos.length;

	if (productos.length === 0) {
		renderEmpty(tbody, 3, "No hay productos cargados.");
		return;
	}

	tbody.innerHTML = productos.map(producto => `
		<tr>
			<td>${producto.nombre}</td>
			<td>${formatCurrency.format(producto.precio)}</td>
			<td><span class="tag">${producto.disponible ? "Disponible" : "No disponible"}</span></td>
		</tr>
	`).join("");
}

function renderClientes(clientes) {
	const tbody = document.querySelector("#clientes-tabla");
	document.querySelector("#total-clientes").textContent = clientes.length;

	if (clientes.length === 0) {
		renderEmpty(tbody, 3, "No hay clientes cargados.");
		return;
	}

	tbody.innerHTML = clientes.map(cliente => `
		<tr>
			<td>${cliente.nombre}</td>
			<td>${cliente.telefono}</td>
			<td><span class="tag">${cliente.frecuente ? "Frecuente" : "Comun"}</span></td>
		</tr>
	`).join("");
}

function renderPedidos(pedidos) {
	const tbody = document.querySelector("#pedidos-tabla");
	document.querySelector("#total-pedidos").textContent = pedidos.length;

	if (pedidos.length === 0) {
		renderEmpty(tbody, 4, "No hay pedidos creados.");
		return;
	}

	tbody.innerHTML = pedidos.map(pedido => `
		<tr>
			<td>${pedido.id}</td>
			<td>${pedido.cliente?.nombre ?? "Sin cliente"}</td>
			<td><span class="tag">${pedido.estado}</span></td>
			<td>${pedido.items?.length ?? 0}</td>
		</tr>
	`).join("");
}

async function cargarDatos() {
	const [productos, clientes, pedidos] = await Promise.all([
		fetchJson(endpoints.productos),
		fetchJson(endpoints.clientes),
		fetchJson(endpoints.pedidos)
	]);

	renderProductos(productos);
	renderClientes(clientes);
	renderPedidos(pedidos);
}

document.querySelector("#producto-form").addEventListener("submit", async event => {
	event.preventDefault();

	const form = event.currentTarget;
	const data = new FormData(form);

	await fetchJson(endpoints.productos, {
		method: "POST",
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify({
			nombre: data.get("nombre"),
			descripcion: data.get("descripcion"),
			precio: Number(data.get("precio")),
			disponible: data.get("disponible") === "on"
		})
	});

	form.reset();
	form.disponible.checked = true;
	await cargarDatos();
});

document.querySelector("#cliente-form").addEventListener("submit", async event => {
	event.preventDefault();

	const form = event.currentTarget;
	const data = new FormData(form);

	await fetchJson(endpoints.clientes, {
		method: "POST",
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify({
			nombre: data.get("nombre"),
			telefono: data.get("telefono"),
			frecuente: data.get("frecuente") === "on"
		})
	});

	form.reset();
	await cargarDatos();
});

cargarDatos().catch(error => {
	console.error(error);
});

