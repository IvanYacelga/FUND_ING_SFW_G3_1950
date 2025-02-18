void gestionarPermisos() {
    char usuario[20];
    int opcion;

    printf("Ingrese el nombre del usuario para gestionar permisos: ");
    scanf("%s", usuario);

    // Verificar si el usuario es 'admin'
    if (strcmp(usuario, "admin") != 0) {
        printf("Solo el usuario 'admin' puede gestionar permisos.\n");
        return;  // Salir de la funcion sin mostrar las opciones
    }

    printf("\nGestion de permisos para %s\n", usuario);
    printf("1. Asignar permisos de administrador\n");
    printf("2. Revocar permisos de administrador\n");
    printf("3. Salir\n");
    printf("Seleccione una opcion: ");
    scanf("%d", &opcion);

    if (opcion == 1) {
        printf("Permisos de administrador asignados a %s.\n", usuario);
    } else if (opcion == 2) {
        printf("Permisos de administrador revocados a %s.\n", usuario);
    } else if (opcion == 3) {
        printf("Saliendo de la gestion de permisos...\n");
    } else {
        printf("Opcion invalida. Intente nuevamente.\n");
    }
}

