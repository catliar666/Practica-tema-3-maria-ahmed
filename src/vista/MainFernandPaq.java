package vista;

import modelos.*;
import utils.Utils;

import java.util.Scanner;

public class MainFernandPaq {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        int op, telefonoTeclado;
        String emailTeclado, claveTeclado, provinciaTeclado, nombreTeclado, direccionTeclado, localidadTeclado, seguimientoTeclado;
        Usuarios userLogueadoDestinatario, userLogueadoConductor;
        Paquetes paqueteModificar = null;

        //Inicio MOCK
        Usuarios u1 = new Usuarios("maria@gmail.com", "1234", "Maria", 625178025);
        Usuarios u2 = null;
        Administrador jefe = new Administrador("admin@gmail.com", "admin", "Elisa");
        Usuarios conductor1 = new Usuarios("conductor1@gmail.com", "1234", "Jaén", "Paco", 666666666);
        Usuarios conductor2 = null;
        Usuarios conductor3 = null;
        Destinatarios destinatario = new Destinatarios(u1, u2);
        Conductor conductor = new Conductor(conductor1, conductor2, conductor3);
        //Fin MOCK
        System.out.println("""
                --  .+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.\s
                -- (                                                                         )
                --  )                                                                       (\s
                -- (                                                                         )
                --  )                                                                       (\s
                -- (            ___________  _  _____   _  _____  ___   ___  ____            )
                --  )          / __/ __/ _ \\/ |/ / _ | / |/ / _ \\/ _ | / _ |/ __ \\          (\s
                -- (          / _// _// , _/    / __ |/    / ___/ __ |/ __ / /_/ /           )
                --  )        /_/ /___/_/|_/_/|_/_/ |_/_/|_/_/  /_/ |_/_/ |_\\___\\_\\          (\s
                -- (                                                                         )
                --  )                                                                       (\s
                -- (                                                                         )
                --  )                                                                       (\s
                -- (                                                                         )
                --  "+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"+.+"\s""");
        do {
            //Creamos un menú con opcion de crear una cuenta o iniciar sesión
            System.out.print("""
                                        
                    Bienvenido a FernanPaaq ¿qué d e s e a hacer?
                    1) Iniciar Sesión.
                    2) Crear una cuenta.
                    3) Seguimiento de un paquete con número de referencia.
                    4) Salir.
                    Elige una opción:""");
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1: //Preguntas para iniciar sesión
                    System.out.println("Introduzca su email");
                    emailTeclado = s.nextLine();
                    System.out.println("Introduzca su clave");
                    claveTeclado = s.nextLine();
                    //Aquí comprueba si existe algun usuario con los valores indicados, si no hay ninguno el resultado es null
                    userLogueadoDestinatario = destinatario.verificarInicioSesion(emailTeclado, claveTeclado);
                    userLogueadoConductor = conductor.verificarInicioSesion(emailTeclado, claveTeclado);

                    if (userLogueadoDestinatario != null) {
                        //Menú del usuario normal
                        do {
                            System.out.printf("""
                                    Bienvenido %s. Siga sus envíos de FernanPaaq
                                    1. Seguir mis envíos
                                    2. Modificar mis datos de entrega para un envío
                                    3. Ver mi perfil
                                    4. Modificar mi perfil
                                    5. Cerrar sesión
                                    Elige una opción:
                                    """, userLogueadoDestinatario.getNombre());
                            op = Integer.parseInt(s.nextLine());
                            switch (op) {
                                case 1: //Muestra los envios que tiene adjudicados a su cuenta
                                    System.out.println(userLogueadoDestinatario.mostrarEnvios());
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 2: //Modifica los datos de un paquete
                                    do {
                                        System.out.println("""
                                                ===Modificar un paquete===
                                                1. Nombre de destinatario
                                                2. Dirección
                                                3. Localidad
                                                4. Salir
                                                Elija una opción a modificar:""");
                                        op = Integer.parseInt(s.nextLine());
                                        System.out.println("Introduce el número de seguimiento del paquete a modificar");
                                        seguimientoTeclado = s.nextLine();
                                        paqueteModificar = userLogueadoDestinatario.comprobacionSeguimiento(seguimientoTeclado);
                                        switch (op) {
                                            case 1:
                                                if (paqueteModificar != null) {
                                                    System.out.println("Introduce el nombre modificado");
                                                    nombreTeclado = s.nextLine();
                                                    paqueteModificar.cambiaNombre(nombreTeclado);
                                                }
                                                break;
                                            case 2:
                                                if (paqueteModificar != null) {
                                                    System.out.println("Introduce la dirección modificada");
                                                    direccionTeclado = s.nextLine();
                                                    paqueteModificar.cambiaDireccion(direccionTeclado);
                                                }
                                                break;
                                            case 3:
                                                if (paqueteModificar != null) {
                                                    System.out.println("Introduce la localidad modificada");
                                                    localidadTeclado = s.nextLine();
                                                    paqueteModificar.cambiaLocalidad(localidadTeclado);
                                                }
                                                break;
                                            case 4:
                                                Utils.salirOpcion();
                                                break;
                                            default:
                                                System.out.println("No existe esa opción, por favor elija la correcta");
                                                break;
                                        }
                                    } while (op != 4);
                                    break;
                                case 3: //Muestra la información de su perfil
                                    System.out.println(userLogueadoDestinatario.infoUsuarioLogueado());
                                    Utils.pulsaParaContinuar();
                                    break;
                                case 4:
                                    do {
                                        System.out.println("""
                                                ===Modificar mi perfil===
                                                1. Nombre
                                                2. Clave
                                                3. Telefono
                                                4. Salir
                                                Elija la opción que desea modificar:""");
                                        op = Integer.parseInt(s.nextLine());
                                        switch (op) {
                                            case 1: //Cambia el nombre
                                                System.out.println("Introduce tu nuevo nombre");
                                                nombreTeclado = s.nextLine();
                                                System.out.println(userLogueadoDestinatario.cambiaNombre(nombreTeclado));
                                                break;
                                            case 2: //Cambia la clave
                                                System.out.println("Introduce tu nueva clave");
                                                claveTeclado = s.nextLine();
                                                System.out.println(userLogueadoDestinatario.cambiaClave(claveTeclado));
                                                break;
                                            case 3: //Cambia el número de telefono
                                                System.out.println("Introduce tu nuevo número de teléfono");
                                                telefonoTeclado = Integer.parseInt(s.nextLine());
                                                System.out.println(userLogueadoDestinatario.cambiaTelefono(telefonoTeclado));
                                                break;
                                            case 4: //Sale de este menú
                                                Utils.salirOpcion();
                                            default:
                                                System.out.println("No existe esa opción");
                                        }
                                    } while (op != 4);
                                    break;
                                case 5: //Cierra sesion y limpia pantalla
                                    Utils.cerrarSesion();
                                    Utils.limpiarPantalla();
                                    break;
                                default:
                                    System.out.println("Esa opción no existe, por favor elija otra.");
                                    Utils.pulsaParaContinuar();
                                    break;
                            }
                        } while (op != 5);
                    } else if (userLogueadoConductor != null) {
                        //Menú del conductor
                        do {
                            System.out.printf("""
                                    Bienvenido %s. Gestione sus envios asignados.
                                    1. Ver la información de mis envíos.
                                    2. Cambiar el estado de un envío.
                                    3. Ver el histórico de paquetes entregados.
                                    4. Modificar mi perfil.
                                    5. Cerrar sesión.
                                    Elige una opción:""", userLogueadoConductor.getNombre());
                            op = Integer.parseInt(s.nextLine());
                            switch (op) {
                                case 1:
                                    //Muestra la informacion de los envios que no ha entregado todavia
                                    System.out.println(userLogueadoConductor.mostrarEnvios());
                                    Utils.pulsaParaContinuar();
                                    Utils.limpiarPantalla();
                                    break;
                                case 2:
                                    //Cambia el estado de un envio
                                    System.out.println("===Actualización de estado de envíos===");
                                    System.out.println(userLogueadoConductor.pintaPaqConductor() /* TODO: Poner un pinta envios*/ + "Seleccione el envío a modificar: ");
                                    op = Integer.parseInt(s.nextLine());
                                    switch (op) {
                                        case 1:
                                            paqueteModificar = userLogueadoConductor.getPaq1();
                                            break;
                                        case 2:
                                            paqueteModificar = userLogueadoConductor.getPaq2();
                                            break;
                                        case 3:
                                            Utils.salirOpcion();
                                            break;
                                        default:
                                            System.out.println("Elija un envio correcto");
                                            break;
                                    }
                                    if (paqueteModificar != null) {
                                        System.out.printf("""
                                                === Estado del pedido %s===
                                                1. En oficina
                                                2. En almacén
                                                3. En reparto
                                                4. Entregado
                                                Elija una opción:""", paqueteModificar.getNumeroSeguimiento());
                                        int opEstado = Integer.parseInt(s.nextLine());
                                        paqueteModificar.actualizarEstado(opEstado);
                                        switch (op){
                                            case 1:
                                                paqueteModificar = userLogueadoConductor.getPaq1();
                                                break;
                                            case 2:
                                                paqueteModificar = userLogueadoConductor.getPaq1();
                                                break;
                                        }
                                        System.out.println("El paquete " + paqueteModificar.getNumeroSeguimiento() + "está " + paqueteModificar.getEstado());
                                        Utils.pulsaParaContinuar();
                                    }
                                    break;
                                case 3:
                                    System.out.println("===HISTORICO DE PAQUETES ENTREGADOS===");
                                    System.out.println(userLogueadoConductor.pintaHistoricoConductor());
                                    System.out.println("=============================================");
                                    Utils.pulsaParaContinuar();
                                    //Muestra todos los pedidos que tienen de estado "Entregado"
                                    break;
                                case 4:
                                    do {
                                        System.out.println("""
                                                ===Modificar mi perfil===
                                                1. Nombre
                                                2. Clave
                                                3. Telefono
                                                4. Provincia de referencia
                                                5. Salir
                                                Elija la opción que desea modificar:""");
                                        op = Integer.parseInt(s.nextLine());
                                        switch (op) {
                                            case 1: //Cambia el nombre
                                                System.out.println("Introduce tu nuevo nombre");
                                                nombreTeclado = s.nextLine();
                                                System.out.println(userLogueadoConductor.cambiaNombre(nombreTeclado));
                                                break;
                                            case 2: //Cambia la clave
                                                System.out.println("Introduce tu nueva clave");
                                                claveTeclado = s.nextLine();
                                                System.out.println(userLogueadoConductor.cambiaClave(claveTeclado));
                                                break;
                                            case 3: //Cambia el número de telefono
                                                System.out.println("Introduce tu nuevo número de teléfono");
                                                telefonoTeclado = Integer.parseInt(s.nextLine());
                                                System.out.println(userLogueadoConductor.cambiaTelefono(telefonoTeclado));
                                                break;
                                            case 4: //Cambia la provincia
                                                System.out.println("Introduce tu nueva provincia de referencia");
                                                provinciaTeclado = s.nextLine();
                                                System.out.println(userLogueadoConductor.cambiaProvincia(provinciaTeclado));
                                                break;
                                            case 5: //Sale de este menú
                                                Utils.salirOpcion();
                                                Utils.limpiarPantalla();
                                                op++;
                                                break;
                                            default:
                                                System.out.println("No existe esa opción");
                                                break;
                                        }
                                    } while (op != 6);
                                    break;
                                case 5: //Cierra sesion y limpia pantalla
                                    Utils.cerrarSesion();
                                    Utils.limpiarPantalla();
                                    break;
                                default:
                                    System.out.println("No existe esa opción, por favor elija otra");
                                    Utils.pulsaParaContinuar();
                                    break;
                            }
                        } while (op != 5);
                    } else if (jefe.verificarInicioSesion(emailTeclado, claveTeclado)) {
                        //Menú del admin
                        do {
                            System.out.printf("""
                                    Bienvenido %s. Administración FernanPaaq. Tiene %d envíos por asignar.
                                    1. Registrar un nuevo envío.
                                    2. Asignar un envío a un conductor.
                                    3. Ver los datos de todos los usuarios registrados.
                                    4. Ver los datos de todos los envíos.
                                    5. Ver los datos de todos los conductores.
                                    6. Modificar el perfil.
                                    7. Cerrar sesión.
                                    Elige una opción:""", jefe.getNombre(), jefe.incrementaContador());
                            op = Integer.parseInt(s.nextLine());
                            switch (op) {
                                case 1: //Registra un nuevo paquete
                                    if (jefe.huecoPaquetes()) {
                                        System.out.println("===Registro de un nuevo envío===");
                                        System.out.println("Introduce el email del destinatario");
                                        emailTeclado = s.nextLine();
                                        if (destinatario.comprobarEmailCreacion(emailTeclado)) {
                                            System.out.println("Introduce el nombre del destinatario");
                                            nombreTeclado = s.nextLine();
                                            System.out.println("Introduce la dirección del destinatario");
                                            direccionTeclado = s.nextLine();
                                            System.out.println("Introduce la localidad");
                                            localidadTeclado = s.nextLine();
                                            System.out.println("Introduce la provincia");
                                            provinciaTeclado = s.nextLine();
                                            jefe.addPaquete(emailTeclado, nombreTeclado, direccionTeclado, localidadTeclado, provinciaTeclado);
                                            jefe.cambiaInfo();
                                            if (conductor.asignarPaquetesAutoConductor(jefe.getPaq1()) && destinatario.registrarPaqueteAuto(jefe.getPaq1())) {
                                                jefe.liberarPaquetes();
                                                jefe.cambiaInfo();
                                            }
                                            if (conductor.asignarPaquetesAutoConductor(jefe.getPaq2()) && destinatario.registrarPaqueteAuto(jefe.getPaq2())) {
                                                jefe.liberarPaquetes();
                                                jefe.cambiaInfo();
                                            }
                                            if (conductor.asignarPaquetesAutoConductor(jefe.getPaq3()) && destinatario.registrarPaqueteAuto(jefe.getPaq3())) {
                                                jefe.liberarPaquetes();
                                                jefe.cambiaInfo();
                                            }
                                            if (conductor.asignarPaquetesAutoConductor(jefe.getPaq4()) && destinatario.registrarPaqueteAuto(jefe.getPaq4())) {
                                                jefe.liberarPaquetes();
                                                jefe.cambiaInfo();
                                            }
                                            System.out.println("Paquete creado correctamente");
                                            Utils.pulsaParaContinuar();
                                            Utils.limpiarPantalla();

                                        } else {
                                            System.out.println("ERROR: El email indicado a alcanzado su límite de paquetes.");
                                            Utils.pulsaParaContinuar();
                                    }
                                    }
                                    break;
                                case 2:
                                    //Asigna un envio a un conductor si este no ha podido ubicarse en uno
                                    System.out.println(jefe.pintaPaquetesParaAsignar());
                                    if (!(jefe.pintaPaquetesParaAsignar().equals("No hay paquetes para mostrar"))) {
                                        System.out.print("Seleccione el envío a asignar: ");
                                        op = Integer.parseInt(s.nextLine());
                                        switch (op) {
                                            case 1:
                                                if (jefe.getPaq1().getNombreConductor() == null) paqueteModificar = jefe.getPaq1();
                                                break;
                                            case 2:
                                                if (jefe.getPaq2().getNombreConductor() == null) paqueteModificar = jefe.getPaq2();
                                                break;
                                            case 3:
                                                if (jefe.getPaq3().getNombreConductor() == null) paqueteModificar = jefe.getPaq3();
                                                break;
                                            case 4:
                                                if (jefe.getPaq4().getNombreConductor() == null) paqueteModificar = jefe.getPaq4();
                                                break;
                                            default:
                                                paqueteModificar = null;
                                                System.out.println("Error al seleccionar un envío");
                                                break;
                                        }
                                        System.out.println(conductor.pintaHistoricoConductor1());
                                        System.out.println(conductor.pintaHistoricoConductor2());
                                        System.out.println(conductor.pintaHistoricoConductor3());
                                        System.out.println("Seleccione un conductor: ");
                                        int opConductor = Integer.parseInt(s.nextLine());
                                        if (!(conductor.pintaHistoricoConductor1().equals("No hay conductores disponibles"))) {
                                            switch (opConductor) {
                                                case 1:
                                                    userLogueadoConductor = conductor.seleccionarConductor(opConductor);
                                                    break;
                                                case 2:
                                                    userLogueadoConductor = conductor.seleccionarConductor(opConductor);
                                                    break;
                                                case 3:
                                                    userLogueadoConductor = conductor.seleccionarConductor(opConductor);
                                                    break;
                                                default:
                                                    System.out.println("ERROR: No se ha podido seleccionar al conductor");
                                                    break;
                                            }
                                            if (userLogueadoConductor != null) {
                                                System.out.print("Asignado a " + userLogueadoConductor.getNombre() + ", indica los dias aproximados para realizar la entrega: ");
                                                userLogueadoConductor.addPaqueteConductor(paqueteModificar);
                                                if (paqueteModificar != null)
                                                    paqueteModificar.addNombreConductor(userLogueadoConductor.getNombre());
                                                int diasEntrega = Integer.parseInt(s.nextLine());
                                                if (paqueteModificar != null) {
                                                    paqueteModificar.setDiasEntrega(diasEntrega);
                                                    System.out.println("La entrega estimada será: " + paqueteModificar.fechaEntregaEstimada(diasEntrega));
                                                    jefe.liberarPaquetes();
                                                    jefe.cambiaInfo();
                                                }

                                            }
                                        } else System.out.println("ERROR: No hay conductores para asignar su envío");
                                    } Utils.pulsaParaContinuar();
                                    break;
                                case 3:
                                    System.out.println("===Información de los usuarios registrados===");
                                    System.out.println(destinatario.pintaUsuarios());
                                    System.out.println("=================================================");
                                    Utils.pulsaParaContinuar();
                                    //Compueba los datos de todos los usuarios registrados
                                    break;
                                case 4:
                                    System.out.println("===Información de los paquetes registrados===");
                                    if (!(jefe.pintaPaqAdmin().equals("No hay paquetes para mostrar"))){
                                        System.out.println(jefe.pintaPaqAdmin());
                                    }
                                    if (conductor.getConductor() != null) {
                                        System.out.println(conductor.pintaPaquetesCon1());
                                    }
                                    if (conductor.getConductor2() != null) {
                                        System.out.println(conductor.pintaPaquetesCon2());
                                    }
                                    if (conductor.getConductor3() != null) {
                                        System.out.println(conductor.pintaPaquetesCon3());
                                    }
                                    if (!(jefe.pintaPaqAdmin().equals("No hay paquetes para mostrar")) && (conductor.getConductor() != null)){
                                        System.out.println("no hay paquetes para mostrar");
                                    }

                                    System.out.println("=================================================");
                                    Utils.pulsaParaContinuar();

                                    //Comprueba los datos de todos los envios
                                    break;
                                case 5:
                                    System.out.println("===Información de los conductores registrados===");
                                    System.out.println(conductor.pintaConductores());
                                    System.out.println("=================================================");
                                    Utils.pulsaParaContinuar();
                                    Utils.limpiarPantalla();
                                    //Comprueba todos los datos de los conductores
                                    break;
                                case 6: //Modifica el perfil del admin
                                    System.out.println("""
                                            ===Modificar mi perfil===
                                            1. Modificar clave
                                            2. Modificar nombre
                                            3. Salir
                                            Elija la opción que desee:""");
                                    op = Integer.parseInt(s.nextLine());
                                    switch (op) {
                                        case 1: //Cambia la clave
                                            System.out.println("Introduce tu nueva clave");
                                            claveTeclado = s.nextLine();
                                            System.out.println(jefe.cambiaClave(claveTeclado));
                                            break;
                                        case 2:
                                            System.out.println("Introduce tu nuevo nombre");
                                            nombreTeclado = s.nextLine();
                                            System.out.println(jefe.cambiaNombre(nombreTeclado));
                                            break;
                                        case 3: //Sale y se dirige al menú de login del admin
                                            Utils.salirOpcion();
                                            break;
                                        default:
                                            System.out.println("No existe esa opción");
                                            break;
                                    }
                                    break;
                                case 7: //Para cerrar sesión, se limpia la pantalla
                                    Utils.cerrarSesion();
                                    Utils.limpiarPantalla();
                                    break;
                                default: //Por si elije otra opción que no esté en el menú
                                    System.out.println("No existe esa opción. Por favor elija otra.");
                                    Utils.pulsaParaContinuar();
                                    break;
                            }
                        } while (op != 7);
                    } else { //Si la validación no ha funcionado bien se le indica que ha introducido un login incorrecto
                        System.out.println("Inicio de sesión incorrecto.");
                        Utils.pulsaParaContinuar();
                    }
                    break;
                case 2:
                    //Menú para crear un usuario

                    //Primero le preguntamos que tipo de cuenta desea crear
                    System.out.print(""" 
                            ¿Qué cuenta desea crear?
                            1) Usuario normal
                            2) Conductor
                            Introduce una opción:""");
                    op = Integer.parseInt(s.nextLine());
                    switch (op) {
                        case 1: //Si ha elegido la opción uno comprobamos si hay hueco y creamos la cuenta
                            if (destinatario.quedaHueco()) {
                                System.out.println("Introduce un email");
                                emailTeclado = s.nextLine();
                                System.out.println("Introduce una clave (podrás cambiarla más adelante)");
                                claveTeclado = s.nextLine();
                                System.out.println("Introduce tu nombre");
                                nombreTeclado = s.nextLine();
                                System.out.println("Introduce tu número de telefono");
                                telefonoTeclado = Integer.parseInt(s.nextLine());
                                System.out.println(destinatario.insertarUsuario(emailTeclado, claveTeclado, nombreTeclado, telefonoTeclado));
                                Utils.pulsaParaContinuar();
                            } else {
                                System.out.println("ERROR: Limite de cuentas alcanzado.");
                                Utils.pulsaParaContinuar();
                            }
                            break;
                        case 2: //Si ha elegido la opción dos comprobamos si hay hueco y creamos la cuenta
                            if (conductor.hayHueco()) {
                                System.out.println("Introduce un email");
                                emailTeclado = s.nextLine();
                                System.out.println("Introduce una clave (podrás cambiarla más adelante)");
                                claveTeclado = s.nextLine();
                                System.out.println("Introduce tu provincia de referencia");
                                provinciaTeclado = s.nextLine();
                                System.out.println("Introduce un nombre");
                                nombreTeclado = s.nextLine();
                                System.out.println("Introduce un número de teléfono");
                                telefonoTeclado = Integer.parseInt(s.nextLine());
                                System.out.println(conductor.insertarConductor(emailTeclado, claveTeclado, provinciaTeclado, nombreTeclado, telefonoTeclado));
                                Utils.pulsaParaContinuar();
                            } else {
                                System.out.println("ERROR: Limite de cuentas alcanzado.");
                                Utils.pulsaParaContinuar();
                            }
                            break;
                        default:
                            System.out.println("Esa opción no existe");
                            break;
                    }
                    break;
                case 3:
                    //Seguimiento de un paquete sin iniciar sesión
                    System.out.println("=== Seguimiento sin registro de usuario ===");
                    System.out.println("Introduce el número de seguimiento del paquete");
                    seguimientoTeclado = s.nextLine();
                    if (destinatario.getU1() != null) {
                        paqueteModificar = destinatario.getU1().comprobacionSeguimiento(seguimientoTeclado);
                    } else if (destinatario.getU2() != null) {
                        paqueteModificar = destinatario.getU2().comprobacionSeguimiento(seguimientoTeclado);
                    }
                    if (paqueteModificar != null) {
                        System.out.println(paqueteModificar.pintaSeguimientoSinRegistro());
                    } else {
                        System.out.println("ERROR: No se ha encontrado el paquete");
                    }
                    break;
                case 4:
                    Utils.saliendoPrograma();
                    break;
                default:
                    System.out.println("Esa opción no existe. Por favor elija otra");
                    break;
            }
        } while (op != 4);
    }
}