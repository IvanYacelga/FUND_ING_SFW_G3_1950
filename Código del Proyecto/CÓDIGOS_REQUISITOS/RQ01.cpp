void registrarCliente() {
    if (numClientes >= 100) {
        printf("No se pueden registrar mas clientes.\n");
        return;
    }

    Cliente nuevoCliente;
    nuevoCliente.id = numClientes + 1;
    printf("Ingrese nombre del cliente: ");
    scanf("%s", nuevoCliente.nombre);
    printf("Ingrese telefono del cliente: ");
    scanf("%s", nuevoCliente.telefono);

    clientes[numClientes] = nuevoCliente;
    numClientes++;

    printf("Cliente registrado exitosamente con ID %d.\n", nuevoCliente.id);
}