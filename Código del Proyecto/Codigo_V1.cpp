#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_CLIENTES 100
#define MAX_TRANSACCIONES 100

typedef struct {
    int id;
    char nombre[50];
    char correo[50];
} Cliente;

typedef struct {
    int id;
    int idCliente;
    double monto;
    char fecha[20];
} Transaccion;

Cliente clientes[MAX_CLIENTES];
Transaccion transacciones[MAX_TRANSACCIONES];
int contadorClientes = 0;
int contadorTransacciones = 0;

void registrarCliente();
void gestionarTransacciones();
void generarReportes();
void verHistorialTransacciones();
void buscarCliente();

int main() {
    int opcion;

    do {
        printf("\n--- Sistema de Gestion de Clientes ---\n");
        printf("1. Registrar Cliente\n");
        printf("2. Gestionar Transacciones\n");
        printf("3. Generar Reportes\n");
        printf("4. Ver Historial de Transacciones\n");
        printf("5. Buscar Cliente\n");
        printf("6. Salir\n");
        printf("Elija una opcion: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                gestionarTransacciones();
                break;
            case 3:
                generarReportes();
                break;
            case 4:
                verHistorialTransacciones();
                break;
            case 5:
                buscarCliente();
                break;
            case 6:
                printf("Saliendo...\n");
                break;
            default:
                printf("Opcion invalida. Por favor, intente de nuevo.\n");
        }
    } while (opcion != 6);

    return 0;
}

void registrarCliente() {
    if (contadorClientes >= MAX_CLIENTES) {
        printf("Se ha alcanzado el limite de clientes.\n");
        return;
    }

    Cliente nuevoCliente;
    nuevoCliente.id = contadorClientes + 1;
    printf("Ingrese el nombre del cliente: ");
    scanf("%s", nuevoCliente.nombre);
    printf("Ingrese el correo del cliente: ");
    scanf("%s", nuevoCliente.correo);

    clientes[contadorClientes++] = nuevoCliente;
    printf("Cliente registrado exitosamente con ID: %d\n", nuevoCliente.id);
    return;
}

void gestionarTransacciones() {
    if (contadorTransacciones >= MAX_TRANSACCIONES) {
        printf("Se ha alcanzado el limite de transacciones.\n");
        return;
    }

    Transaccion nuevaTransaccion;
    printf("Ingrese el ID del cliente: ");
    scanf("%d", &nuevaTransaccion.idCliente);

    int clienteExiste = 0;
    for (int i = 0; i < contadorClientes; i++) {
        if (clientes[i].id == nuevaTransaccion.idCliente) {
            clienteExiste = 1;
            break;
        }
    }

    if (!clienteExiste) {
        printf("ID de cliente no encontrado.\n");
        return;
    }

    nuevaTransaccion.id = contadorTransacciones + 1;
    printf("Ingrese el monto de la transaccion: ");
    scanf("%lf", &nuevaTransaccion.monto);
    printf("Ingrese la fecha de la transaccion (AAAA-MM-DD): ");
    scanf("%s", nuevaTransaccion.fecha);

    transacciones[contadorTransacciones++] = nuevaTransaccion;
    printf("Transaccion registrada exitosamente con ID: %d\n", nuevaTransaccion.id);
    return;
}

void generarReportes() {
    double ingresosTotales = 0, egresosTotales = 0;
    for (int i = 0; i < contadorTransacciones; i++) {
        if (transacciones[i].monto > 0) {
            ingresosTotales += transacciones[i].monto;
        } else {
            egresosTotales += transacciones[i].monto;
        }
    }

    printf("\n--- Reporte Financiero ---\n");
    printf("Ingresos Totales: $%.2lf\n", ingresosTotales);
    printf("Egresos Totales: $%.2lf\n", egresosTotales);
    printf("Balance Neto: $%.2lf\n", ingresosTotales + egresosTotales);
    return;
}

void verHistorialTransacciones() {
    int idCliente;
    printf("Ingrese el ID del cliente: ");
    scanf("%d", &idCliente);

    printf("\n--- Historial de Transacciones para el Cliente ID: %d ---\n", idCliente);
    for (int i = 0; i < contadorTransacciones; i++) {
        if (transacciones[i].idCliente == idCliente) {
            printf("ID de Transaccion: %d, Monto: $%.2lf, Fecha: %s\n",
                   transacciones[i].id, transacciones[i].monto, transacciones[i].fecha);
        }
    }
    return;
}

void buscarCliente() {
    char nombre[50];
    printf("Ingrese el nombre del cliente a buscar: ");
    scanf("%s", nombre);

    printf("\n--- Resultados de Busqueda ---\n");
    for (int i = 0; i < contadorClientes; i++) {
        if (strstr(clientes[i].nombre, nombre) != NULL) {
            printf("ID del Cliente: %d, Nombre: %s, Correo: %s\n",
                   clientes[i].id, clientes[i].nombre, clientes[i].correo);
        }
    }
    return;
}


