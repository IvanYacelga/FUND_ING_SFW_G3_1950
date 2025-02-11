void generarReporte() {
    printf("\nREPORTE DE INGRESOS Y EGRESOS\n");
    printf("================================\n");

    float totalIngresos = 0, totalEgresos = 0;
    for (int i = 0; i < numTransacciones; i++) {
        if (transacciones[i].monto > 0) {
            totalIngresos += transacciones[i].monto;
        } else {
            totalEgresos += transacciones[i].monto;
        }
    }

    printf("Total Ingresos: %.2f\n", totalIngresos);
    printf("Total Egresos: %.2f\n", totalEgresos);
}
S