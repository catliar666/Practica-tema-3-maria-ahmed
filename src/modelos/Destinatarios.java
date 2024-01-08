package modelos;

public class Destinatarios {
    private static Usuarios u1;
    private static Usuarios u2;


    //Constructor

    public Destinatarios(Usuarios u1, Usuarios u2) {
        this.u1 = u1;
        this.u2 = u2;
    }

    public Usuarios getU1() {
        return u1;
    }

    public Usuarios getU2() {
        return u2;
    }

    //Otros métodos
    public boolean quedaHueco() {
        if (u1 == null) return true;
        if (u2 == null) return true;
        return false;
    }

    public boolean usuariosRegistrados() {
        if (u1 != null) return true;
        if (u2 != null) return true;
        return false;
    }


    public String insertarUsuario(String emailTeclado, String claveTeclado, String nombreTeclado, int telefonoTeclado) {
        if (u1 == null) {
            u1 = new Usuarios(emailTeclado, claveTeclado, nombreTeclado, telefonoTeclado);
            return "Usuario logueado correctamente";
        } else {
            if (u2 == null) {
                u2 = new Usuarios(emailTeclado, claveTeclado, nombreTeclado, telefonoTeclado);
                return "Usuario logueado correctamente";
            } else {
                return "";
            }
        }
    }

    //Registrar paquete en destinatario
    public boolean registrarPaqueteAuto(Paquetes paquete) {
        // Verificar si los correos electrónicos coinciden
        if (u1 != null) {
            if (paquete != null && paquete.getEmailDestinatario().equals(u1.getEmail())) {
                u1.addPaqueteUsuario(paquete);
                return true;
            }
        } else if (u2 != null) {
            if (paquete != null && paquete.getEmailDestinatario().equals(u2.getEmail())) {
                u2.addPaqueteUsuario(paquete);
                return true;
            }
        }
        return false;
    }

    public boolean comprobarEmailCreacion(String emailTeclado) {
        if ((u1 != null && u1.getEmail().equals(emailTeclado) && (u1.getPaq1() != null && u1.getPaq2() != null)) ||
            (u2 != null && u2.getEmail().equals(emailTeclado) && (u2.getPaq1() != null && u2.getPaq2() != null))) {
            return false;
        }
        return true;
    }

    //Método para comprobar el usuario
    public Usuarios verificarInicioSesion(String emailTeclado, String claveTeclado) {
        if (u1 != null) {
            if (u1.getEmail().equals(emailTeclado) && u1.getClave().equals(claveTeclado)) {
                return u1;
            } else if (u2 != null) {
                if (u2.getEmail().equals(emailTeclado) && u2.getClave().equals(claveTeclado)) return u2;
            }
        } else if (u2 != null) {
            if (u2.getEmail().equals(emailTeclado) && u2.getClave().equals(claveTeclado)) return u2;
        }
        return null;
    }

    //Según el email, si tiene espacio libre continua registrando el paquete
    public boolean sitioPaqEmail(String emailTeclado) {
        if (u1 != null && u1.getEmail() != null && u1.getEmail().equals(emailTeclado)) {
            if (u1.getPaq1() == null) return true;
            else if (u1.getPaq2() == null) return true;
        } else if (u2 != null && u2.getEmail() != null && u2.getEmail().equals(emailTeclado)) {
            if (u2.getPaq1() == null) return true;
            else if (u2.getPaq2() == null) return true;
        }
        return false;
    }

    //To String
    public String pintaUsuarios() {
        if (u2 != null) {
            u2.setContador(1);
        }
        if (u1 != null && u2 != null) return u1.getContador() + u1.infoUsuario() + "\n" + u2.getContador() + u2.infoUsuario();
        else if (u1 != null) return u1.getContador() + u1.infoUsuario();
        else if (u2 != null) return u2.getContador() + u2.infoUsuario();
        return "No hay usuarios para mostrar";
    }
}
