void consultarHistorial() {
    int clienteId;
    printf("Ingrese ID del cliente para consultar historial: ");
    scanf("%d", &clienteId);

    printf("\nHISTORIAL DE TRANSACCIONES DEL CLIENTE %d\n", clienteId);
    printf("========================================\n");
    for (int i = 0; i < numTransacciones; i++) {
        if (transacciones[i].clienteId == clienteId) {
            printf("ID Transaccion: %d\n", transacciones[i].id);
            printf("Descripcion: %s\n", transacciones[i].descripcion);
            printf("Monto: %.2f\n", transacciones[i].monto);
            printf("-------------------------\n");
        }
    }
}
