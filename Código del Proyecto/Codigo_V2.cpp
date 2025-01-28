#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    int id;
    char nombre[50];
    char telefono[15];
} Cliente;

typedef struct {
    int id;
    int clienteId;
    char descripcion[100];
    float monto;
} Transaccion;

Cliente clientes[100];
Transaccion transacciones[100];
int numClientes = 0;
int numTransacciones = 0;

int autenticarUsuario();
void registrarCliente();
void registrarTransaccion();
void generarReporte();
void consultarHistorial();
void gestionarPermisos();
void menuPrincipal();

int main() {
    if (autenticarUsuario()) {
        menuPrincipal();
    } else {
        printf("\nAutenticacion fallida. Saliendo del programa.\n");
    }
    return 0;
}

int autenticarUsuario() {
    char usuario[20], password[20];
    printf("Ingrese usuario: ");
    scanf("%s", usuario);
    printf("Ingrese contrasena: ");
    scanf("%s", password);

    if (strcmp(usuario, "admin") == 0 && strcmp(password, "admin123") == 0) {
        printf("\nAutenticacion exitosa.\n");
        return 1;
    }
    return 0;
}

void menuPrincipal() {
    int opcion;
    do {
        printf("\nMENU PRINCIPAL\n");
        printf("1. Registrar cliente\n");
        printf("2. Registrar transaccion financiera\n");
        printf("3. Generar reportes\n");
        printf("4. Consultar historial de transacciones\n");
        printf("5. Gestionar permisos\n");
        printf("6. Salir\n");
        printf("Seleccione una opcion: ");
        scanf("%d", &opcion);

        if (opcion == 1) {
            registrarCliente();
        } else if (opcion == 2) {
            registrarTransaccion();
        } else if (opcion == 3) {
            generarReporte();
        } else if (opcion == 4) {
            consultarHistorial();
        } else if (opcion == 5) {
            gestionarPermisos();
        } else if (opcion == 6) {
            printf("Saliendo del programa...\n");
        } else {
            printf("Opcion invalida. Intente nuevamente.\n");
        }
    } while (opcion != 6);
}

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

void gestionarPermisos() {
    printf("Gestion de permisos aun no implementada.\n");
}

