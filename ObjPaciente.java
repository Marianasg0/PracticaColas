package Ejercicio2Colas;

public class ObjPaciente {
    
    private int Turno;
    private int Id;
    private String Nombre;
    private int Edad;
    private int Servicio;
    private int Estado;
    private int Prioritario;

    public ObjPaciente() {
    }

    public ObjPaciente(int turno, int id, String nombre, int edad, int servicio, int estado, int prioritario) {
        Turno = turno;
        Id = id;
        Nombre = nombre;
        Edad = edad;
        Servicio = servicio;
        Estado = estado;
        Prioritario = prioritario;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getServicio() {
        return Servicio;
    }

    public void setServicio(int servicio) {
        Servicio = servicio;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public int getPrioritario() {
        return Prioritario;
    }

    public void setPrioritario(int prioritario) {
        Prioritario = prioritario;
    }

    
}
