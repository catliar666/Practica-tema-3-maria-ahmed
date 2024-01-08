package modelos;

public class Conductor {
    //Atributos
    private static Usuarios conductor;
    private static Usuarios conductor2;
    private static Usuarios conductor3;


    //Constructor

    public Conductor(Usuarios conductor, Usuarios conductor2, Usuarios conductor3) {
        this.conductor = conductor;
        this.conductor2 = conductor2;
        this.conductor3 = conductor3;
    }

    //Getter y setters


    public Usuarios getConductor() {
        return conductor;
    }

    public Usuarios getConductor2() {
        return conductor2;
    }

    public Usuarios getConductor3() {
        return conductor3;
    }

    //Método para ver si queda espacio para logear un conductor
    public boolean hayHueco() {
        if (conductor == null) {
            return true;
        } else if (conductor2 == null) {
            return true;
        } else if (conductor3 == null) {
            return true;
        }
        return false;
    }

    //Método para logear un conductor
    public String insertarConductor(String emailTeclado, String claveTeclado, String provinciaTeclado, String nombreTeclado, int telefonoTeclado) {
        if (conductor == null) {
            conductor = new Usuarios(emailTeclado, claveTeclado, provinciaTeclado, nombreTeclado, telefonoTeclado);
            return "Se ha logueado con exito";
        } else if (conductor2 == null) {
            conductor2 = new Usuarios(emailTeclado, claveTeclado, provinciaTeclado, nombreTeclado, telefonoTeclado);
            return "Se ha logueado con exito";
        } else if (conductor3 == null) {
            conductor3 = new Usuarios(emailTeclado, claveTeclado, provinciaTeclado, nombreTeclado, telefonoTeclado);
            return "Se ha logueado con exito";
        }
        return "Ha ocurrido un error";
    }

    //Método para verificar al conductor
    public Usuarios verificarInicioSesion(String emailTeclado, String claveTeclado) {
        if (conductor != null) {
            if (conductor.getEmail().equals(emailTeclado) && conductor.getClave().equals(claveTeclado)) {
                return conductor;
            } else if (conductor2 != null) {
                if (conductor2.getEmail().equals(emailTeclado) && conductor2.getClave().equals(claveTeclado))
                    return conductor2;
            }
        } else if (conductor2 != null) {
            if (conductor2.getEmail().equals(emailTeclado) && conductor2.getClave().equals(claveTeclado)) {
                return conductor2;
            } else if (conductor3 != null) {
                if (conductor3.getEmail().equals(emailTeclado) && conductor3.getClave().equals(claveTeclado))
                    return conductor2;
            }
        } else if (conductor3 != null) {
            if (conductor3.getEmail().equals(emailTeclado) && conductor2.getClave().equals(claveTeclado)) {
                return conductor2;
            }
        }
        return null;
    }

    //Asigna los paquetes sin conductor automáticamente a los conductores según su provincia
    public boolean asignarPaquetesAutoConductor(Paquetes paquete) {
        if (conductor != null && conductor.sitioPaquete() && (paquete != null && paquete.getProvincia().equalsIgnoreCase(conductor.getProvincia()))) {
            if (conductor.getPaq1() == null) {
                conductor.setPaq1(paquete);
                paquete.setNombreConductor(conductor.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            } else if (conductor.getPaq2() == null) {
                conductor.setPaq2(paquete);
                paquete.setNombreConductor(conductor.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            }
        } else if (conductor2 != null && conductor2.sitioPaquete() && (paquete != null && paquete.getProvincia().equalsIgnoreCase(conductor2.getProvincia()))) {
            if (conductor2.getPaq1() == null) {
                conductor2.setPaq1(paquete);
                paquete.setNombreConductor(conductor2.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            } else if (conductor2.getPaq2() == null) {
                conductor2.setPaq2(paquete);
                paquete.setNombreConductor(conductor2.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            }
        } else if (conductor3 != null && conductor3.sitioPaquete() && (paquete != null && paquete.getProvincia().equalsIgnoreCase(conductor3.getProvincia()))) {
            if (conductor3.getPaq1() == null) {
                conductor3.setPaq1(paquete);
                paquete.setNombreConductor(conductor3.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            } else if (conductor3.getPaq2() == null) {
                conductor3.setPaq2(paquete);
                paquete.setNombreConductor(conductor3.getNombre());
                paquete.fechaEntregaEstimada(4);
                return true;
            }
        }
        return false;
    }

    public Usuarios seleccionarConductor(int opcion) {
        if (conductor != null) {
            if (opcion == 1) return conductor;
        } else if (conductor2 != null) {
            if (opcion == 2) return conductor2;
        } else if (conductor3 != null) {
            if (opcion == 3) return conductor3;
        }
        return null;
    }

    //ToString
    public String pintaHistoricoConductor1() {
        if (conductor != null) {
            if (conductor.sitioPaquete()) return conductor.getContador() + " - " + conductor.pintaConductor();
            else return conductor.getNombre() + " no está disponible";
        }
        return "No hay conductores disponibles";
    }

    public String pintaHistoricoConductor2() {
        if (conductor2 != null) {
            if (conductor2.sitioPaquete()) return conductor2.getContador() + 1 + " - " + conductor2.pintaConductor();
            else return conductor2.getNombre() + " no está disponible";
        }
        return " ";
    }

    public String pintaHistoricoConductor3() {
        if (conductor3 != null) {
            if (conductor3.sitioPaquete()) return conductor3.getContador() + 2 + " - " + conductor3.pintaConductor();
            else return conductor3.getNombre() + " no está disponible";
        }
        return " ";
    }

    public String pintaConductores() {
        if (conductor != null && conductor2 != null && conductor3 != null)
            return conductor.infoUsuario() + "\n" + conductor2.infoUsuario() + "\n" + conductor3.infoUsuario() + "\n";
        else if (conductor != null && conductor2 != null && conductor3 == null)
            return conductor.infoUsuario() + "\n" + conductor2.infoUsuario();
        else if (conductor == null && conductor2 != null && conductor3 != null)
            return conductor2.infoUsuario() + "\n" + conductor3.infoUsuario();
        else if (conductor != null && conductor2 == null && conductor3 == null) return conductor.infoUsuario();
        else if (conductor == null && conductor2 != null && conductor3 == null) return conductor2.infoUsuario();
        else if (conductor == null && conductor2 == null && conductor3 != null) return conductor3.infoUsuario();
        return "No hay conductores para mostrar";
    }

    public String pintaPaquetesCon1() {
        if (conductor.getPaq1() != null && conductor.getPaq2() != null) {
            return conductor.getPaq1().pintaPaqueteinfo() + conductor.getPaq2().pintaPaqueteinfo();
        } else if (conductor.getPaq1() != null && conductor.getPaq2() == null) {
            return conductor.getPaq1().pintaPaqueteinfo();
        } else if (conductor.getPaq1() == null && conductor.getPaq2() != null) {
            return conductor.getPaq2().pintaPaqueteinfo();
        }
        return " ";
    }

    public String pintaPaquetesCon2() {
        if (conductor2.getPaq1() != null && conductor2.getPaq2() != null) {
            return conductor2.getPaq1().pintaPaqueteinfo() + conductor2.getPaq2().pintaPaqueteinfo();
        } else if (conductor2.getPaq1() != null && conductor2.getPaq2() == null) {
            return conductor2.getPaq1().pintaPaqueteinfo();
        } else if (conductor2.getPaq1() == null && conductor2.getPaq2() != null) {
            return conductor2.getPaq2().pintaPaqueteinfo();
        }
        return " ";
    }

    public String pintaPaquetesCon3() {
        if (conductor3.getPaq1() != null && conductor3.getPaq2() != null) {
            return conductor3.getPaq1().pintaPaqueteinfo() + conductor3.getPaq2().pintaPaqueteinfo();
        } else if (conductor3.getPaq1() != null && conductor3.getPaq2() == null) {
            return conductor3.getPaq1().pintaPaqueteinfo();
        } else if (conductor3.getPaq1() == null && conductor3.getPaq2() != null) {
            return conductor3.getPaq2().pintaPaqueteinfo();
        }
        return " ";
    }
}
