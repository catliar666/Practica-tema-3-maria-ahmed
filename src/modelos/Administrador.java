package modelos;

public class Administrador {
    //Atributos
    private Paquetes paq1;
    private Paquetes paq2;
    private Paquetes paq3;
    private Paquetes paq4;
    private String email;
    private String clave;
    private String nombre;
    //Constructor

    public Administrador(String email, String clave, String nombre) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
    }


    //Getter y setters

    public String getNombre() {
        return nombre;
    }

    public Paquetes getPaq1() {
        return paq1;
    }

    public Paquetes getPaq2() {
        return paq2;
    }

    public Paquetes getPaq3() {
        return paq3;
    }

    public Paquetes getPaq4() {
        return paq4;
    }
    //Otros métodos


    //Creación de paquete y asignacion segun comprobacion a conductor y usuario
    public void addPaquete(String emailDestinatario, String nombreDestinatario, String direccionEntrega, String localidad, String provincia) {
        Paquetes paquete = new Paquetes(emailDestinatario, nombreDestinatario, direccionEntrega, localidad, provincia);
        addPaqueteAdmin(paquete);
    }

    private void addPaqueteAdmin(Paquetes paquete) {
        if (paq1 == null) paq1 = paquete;
        else if (paq4 == null) paq4 = paquete;
    }

    public String cambiaNombre(String nombreNuevo) {
        nombre = nombreNuevo;
        return "Modificado con éxito";
    }

    //Modificar clave
    public String cambiaClave(String claveNueva) {
        clave = claveNueva;
        return "Modificado con éxito";
    }

    public boolean huecoPaquetes() {
        if (paq1 == null) return true;
        else if (paq2 == null) return true;
        else if (paq3 == null) return true;
        else if (paq4 == null) return true;
        else return false;
    }

    public boolean verificarInicioSesion(String emailTeclado, String claveTeclado) {
        if (email != null && clave != null) {
            if (email.equals(emailTeclado) && clave.equals(claveTeclado)) return true;

        }
        return false;
    }

    public void liberarPaquetes() {
        if (paq1 != null && paq1.getNombreConductor() != null) paq1 = null;
        if (paq2 != null && paq2.getNombreConductor() != null) paq2 = null;
        if (paq3 != null && paq3.getNombreConductor() != null) paq3 = null;
        if (paq4 != null && paq4.getNombreConductor() != null) paq4 = null;
    }

    public void cambiaInfo() {
        if (paq1 == null && paq2 != null && paq3 != null && paq4 != null) {
            paq1 = paq2;
            paq2 = paq3;
            paq3 = paq4;
            paq4 = null;
        } else if (paq1 != null && paq2 == null && paq3 != null && paq4 != null) {
            paq2 = paq3;
            paq3 = paq4;
            paq4 = null;
        } else if (paq1 != null && paq2 != null && paq3 == null && paq4 != null) {
            paq3 = paq4;
            paq4 = null;
        }
    }

    public int incrementaContador() {
        int contadorPaquetesSinAsignacion = 0;
        if (paq1 != null && paq1.getNombreConductor() == null) contadorPaquetesSinAsignacion++;
        if (paq1 == null && contadorPaquetesSinAsignacion >= 1) contadorPaquetesSinAsignacion--;
        if (paq2 != null && paq2.getNombreConductor() == null) contadorPaquetesSinAsignacion++;
        if (paq2 == null && contadorPaquetesSinAsignacion > 1) contadorPaquetesSinAsignacion--;
        if (paq3 != null && paq3.getNombreConductor() == null) contadorPaquetesSinAsignacion++;
        if (paq3 == null && contadorPaquetesSinAsignacion > 2) contadorPaquetesSinAsignacion--;
        if (paq4 != null && paq4.getNombreConductor() == null) contadorPaquetesSinAsignacion++;
        if (paq4 == null && contadorPaquetesSinAsignacion > 3) contadorPaquetesSinAsignacion--;
        return contadorPaquetesSinAsignacion;
    }


    public String pintaPaquetesParaAsignar() {
        if ((paq1 != null && paq1.getNombreConductor() == null) && (paq2 != null && paq2.getNombreConductor() == null)
            && (paq3 != null && paq3.getNombreConductor() == null) && (paq4 != null && paq4.getNombreConductor() == null)) {
            return incrementaContador() + " - " + paq1.pintaParaAsignacion() + incrementaContador() + " - " + paq2.pintaParaAsignacion() +
                   incrementaContador() + " - " + paq3.pintaParaAsignacion() + incrementaContador() + " - " + paq4.pintaParaAsignacion();
        } else if ((paq1 != null && paq1.getNombreConductor() == null) && (paq2 != null && paq2.getNombreConductor() == null)
                   && (paq3 != null && paq3.getNombreConductor() == null) && paq4 == null) {
            return incrementaContador() + " - " + paq1.pintaParaAsignacion() + incrementaContador() + " - " + paq2.pintaParaAsignacion() +
                   incrementaContador() + " - " + paq3.pintaParaAsignacion();
        } else if ((paq1 != null && paq1.getNombreConductor() == null) && (paq2 != null && paq2.getNombreConductor() == null)
                   && (paq3 == null) && (paq4 == null)) {
            return incrementaContador() + " - " + paq1.pintaParaAsignacion() + incrementaContador() + " - " + paq2.pintaParaAsignacion();
        } else if ((paq1 != null && paq1.getNombreConductor() == null) && (paq2 == null) && (paq3 == null) && (paq4 == null)) {
            return incrementaContador() + " - " + paq1.pintaParaAsignacion();
        }
        return "No hay paquetes para mostrar";
    }
    public String pintaPaqAdmin(){
        if (paq1 != null && paq2 != null && paq3 != null && paq4 != null) {
            return paq1.pintaPaqueteinfo() + paq2.pintaPaqueteinfo() + paq3.pintaPaqueteinfo() + paq4.pintaPaqueteinfo();
        }
        if (paq1 != null && paq2 != null && paq3 != null && paq4 == null) {
            return paq1.pintaPaqueteinfo() + paq2.pintaPaqueteinfo() + paq3.pintaPaqueteinfo();
        }
        if (paq1 != null && paq2 != null && paq3 == null && paq4 == null) {
            return paq1.pintaPaqueteinfo() + paq2.pintaPaqueteinfo();
        }
        if (paq1 != null && paq2 == null && paq3 == null && paq4 == null) {
            return paq1.pintaPaqueteinfo();
        }
        return "No hay paquetes para mostrar";
    }
}
