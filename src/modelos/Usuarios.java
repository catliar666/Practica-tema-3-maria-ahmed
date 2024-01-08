package modelos;

public class Usuarios {
    //Atributos
    private String email;
    private String clave;
    private String provincia;
    private String nombre;
    private int telefono;
    private int contador;
    private Paquetes paq1;
    private Paquetes paq2;


    //Constructor

    //Para el admin
    public Usuarios(String email, String clave, String nombre) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
    }

    //Para el conductor
    public Usuarios(String email, String clave, String provincia, String nombre, int telefono) {
        this.email = email;
        this.clave = clave;
        this.provincia = provincia;
        this.nombre = nombre;
        this.telefono = telefono;
        contador++;
    }

    //Para el usuario normal
    public Usuarios(String email, String clave, String nombre, int telefono) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        contador++;
    }

    //Constructor vacio
    public Usuarios() {
    }
    //Getters

    public String getEmail() {
        if (email == null) email = "";
        return email;
    }

    public String getClave() {
        if (clave == null) clave = "";
        return clave;
    }

    public String getNombre() {
        if (nombre == null) nombre = "";
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public Paquetes getPaq1() {
        return paq1;
    }

    public Paquetes getPaq2() {
        return paq2;
    }

    public String getProvincia() {
        return provincia;
    }

    //Setters

    public void setPaq1(Paquetes paq1) {
        this.paq1 = paq1;
    }

    public void setPaq2(Paquetes paq2) {
        this.paq2 = paq2;
    }

    public void setContador(int add) {
        this.contador = contador + add;
    }
    //Otros métodos

    //Modificar nombre
    public String cambiaNombre(String nombreNuevo) {
        nombre = nombreNuevo;
        return "Modificado con éxito";
    }

    //Modificar clave
    public String cambiaClave(String claveNueva) {
        clave = claveNueva;
        return "Modificado con éxito";
    }

    //Modificar telefono
    public String cambiaTelefono(int telefonoNuevo) {
        telefono = telefonoNuevo;
        return "Modificado con éxito";
    }

    //Modificar provincia
    public String cambiaProvincia(String provinciaTeclado) {
        provincia = provinciaTeclado;
        return "Modificado con éxito";
    }

    //Comprueba si hay sitio en las variables paquete
    public boolean sitioPaquete() {
        if (paq1 == null) return true;
        if (paq2 == null) return true;
        return false;
    }


    //Comprueba si hay sitio en conductor y añade un paquete
    public void addPaqueteConductor(Paquetes paquete) {
        if (paq1 == null) {
            paq1 = paquete;
            paq1.setDiasEntrega(3);
        } else if (paq2 == null) {
            paq2 = paquete;
            paq1.setDiasEntrega(3);
        }
    }

    //Método para añadir un paquete al usuario
    public void addPaqueteUsuario(Paquetes paquete) {
        if (paq1 == null) paq1 = paquete;
        else if (paq2 == null) paq2 = paquete;
    }


    //Metodo para saber qué paquete quiere seleccionar el cliente
    public Paquetes comprobacionSeguimiento(String seguimientoTeclado) {
        if (paq1 != null && paq1.getNumeroSeguimiento().equals(seguimientoTeclado)) return paq1;
        else if (paq2 != null && paq2.getNumeroSeguimiento().equals(seguimientoTeclado)) return paq2;
        return null;
    }

    //ToString para mostrar en el main

    public String infoUsuario() { //Pinta la info del usuario
        return " - " + email + " - " + nombre + " - " + telefono + "\n";
    }
    public String infoUsuarioLogueado() { //Pinta la info del usuario logueado
        return "====INFORMACIÓN DEL USUARIO====" + "\n" +
               "Email:" + email + "\n" +
               "Nombre: " + nombre + "\n" +
               "Télefono: " + telefono + "\n";
    }

    public String mostrarEnvios() {
        return (paq1 != null) ? paq1.pintaSeguimientoRegistro() + "\n" : (paq2 != null) ? paq2.pintaSeguimientoRegistro() : "No hay envios para mostrar";
    }

    public String pintaHistoricoConductor() {
        return (paq1 != null && paq1.getEstado().equals("Entregado")) ? paq1.pintaEntregado() + "\n" : (paq2 != null && paq2.getEstado().equals("Entregado")) ? paq2.pintaEntregado() : "No hay envios para mostrar";
    }

    public String pintaConductor() {
        return nombre + " - " + provincia + " - " + telefono + "\n";
    }
    public String pintaPaqConductor(){
        return (paq1 != null) ? paq1.pintaPaqueteinfo() + "\n" : (paq2 != null) ? paq2.pintaPaqueteinfo() : "No hay envios para mostrar";
    }


}
