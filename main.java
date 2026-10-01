package Ejercicio2Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ObjPaciente o = new ObjPaciente();
        metodos m = new metodos();

        Queue<ObjPaciente> cola = new LinkedList<>();
        Stack<ObjPaciente> pila = new Stack<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido a la EPS");
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1) Registrar cliente");
            System.out.println("2) Mostrar pacientes registrados");
            System.out.println("3) Llamar al siguiente cliente");
            System.out.println("4) Atender cliente");
            System.out.println("5) Modificar servicio");
            System.out.println("6) Cancelar turno");
            System.out.println("7) Consultar estado del cliente");
            System.out.println("8) Mostrar pacientes pendientes");
            System.out.println("9) Mostrar pacientes atendidos");
            System.out.println("10) Mostrar pacientes cancelados");
            System.out.println("11) Mostrar pacientes prioritarios");
            System.out.println("12) Salir");

            int opt = m.ValidarEentero(sc);

            switch (opt) {
                case 1:
                    cola = m.agregar(cola, sc, m);
                    break;
                case 2:
                    ObjPaciente[] arreglo = m.pasarArreglo(cola);
                    m.mostrarArreglo(arreglo);
                    break;
                case 3:
                    System.out.println(m.llamarSiguienteCliente(cola));
                    break;
                case 4:
                    cola = m.Atender(cola, sc);
                    break;
                case 5:
                    cola = m.modificarServicio(cola, sc);
                    break;
                case 6:
                    cola = m.cancelarTurno(cola, sc);
                    break;
                case 7:
                    System.out.println(m.estadoCliente(cola, sc));
                    break;
                case 8:
                    pila = m.pasarPila(pila, cola);
                    m.mostrarPila(pila);
                    break;
                case 9:
                    m.atendidos(cola);
                    break;
                case 10:
                    m.cancelados(cola);
                    break;
                case 11:
                    m.prioritarios(cola);
                    break;
                case 12:
                    System.out.println("Gracias por visitarnos");
                    continuar = false;
                    break;

                default:
                    System.out.println("Esa opcion no existe");
                    break;
            }
        }
    }
}
