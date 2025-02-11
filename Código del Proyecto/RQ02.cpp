void registrarTransaccion() {
    if (numTransacciones >= 100) {
        printf("No se pueden registrar mas transacciones.\n");
        return;
    }

    Transaccion nuevaTransaccion;
    nuevaTransaccion.id = numTransacciones + 1;
    printf("Ingrese ID del cliente: ");
    scanf("%d", &nuevaTransaccion.clienteId);

    int clienteEncontrado = 0;
    for (int i = 0; i < numClientes; i++) {
        if (clientes[i].id == nuevaTransaccion.clienteId) {
            clienteEncontrado = 1;
            break;
        }
    }

    if (!clienteEncontrado) {
        printf("Cliente no encontrado.\n");
        return;
    }

    printf("Ingrese descripcion de la transaccion: ");
    scanf("%s", nuevaTransaccion.descripcion);
    printf("Ingrese monto de la transaccion: ");
    scanf("%f", &nuevaTransaccion.monto);

    transacciones[numTransacciones] = nuevaTransaccion;
    numTransacciones++;

    printf("Transaccion registrada exitosamente con ID %d.\n", nuevaTransaccion.id);
}