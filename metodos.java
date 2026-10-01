package Ejercicio2Colas;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class metodos {

    public int ValidarEentero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public int turno(Queue<ObjPaciente> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    public Queue<ObjPaciente> agregar(Queue<ObjPaciente> cola, Scanner sc, metodos m) {
        boolean continuar = true;

        while (continuar) {
            ObjPaciente o = new ObjPaciente();
            System.out.println("Ingrese la identificacion");
            o.setId(m.ValidarEentero(sc));
            System.out.println("Ingrese el nombre");
            o.setNombre(sc.next());
            System.out.println("Ingrese la edad");
            o.setEdad(m.ValidarEentero(sc));
            System.out.println("Ingrese el tipo de servicio que solicita 1)Medicina 2)Odontologia");
            o.setServicio(m.ValidarEentero(sc));
            System.out.println("Tiene condicion especial 1)Si 2)No");
            o.setPrioritario(m.ValidarEentero(sc));
            o.setTurno(m.turno(cola));
            o.setEstado(0);
            cola.offer(o);

            System.out.println("Desea agregar otro cliente 1)Si 2)No");
            int opt = sc.nextInt();

            if (opt == 2) {
                continuar = false;
            }
        }
        return cola;
    }

    public ObjPaciente[] pasarArreglo(Queue<ObjPaciente> cola) {
        ObjPaciente[] arreglo = new ObjPaciente[cola.size()];
        int i = 0;
        for (ObjPaciente o : cola) {
            arreglo[i] = o;
            i++;
        }
        return arreglo;
    }

    public void mostrarArreglo(ObjPaciente[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Turno: " + arreglo[i].getTurno());
            System.out.println("Id: " + arreglo[i].getId());
            System.out.println("Nombre: " + arreglo[i].getNombre());
            System.out.println("Edad: " + arreglo[i].getEdad());
            if (arreglo[i].getServicio() == 1) {
                System.out.println("Servicio: Medicina");
            } else {
                System.out.println("Servicio: Odontologia");
            }
            if (arreglo[i].getPrioritario() == 1) {
                System.out.println("Condicion especial: Si");
            } else {
                System.out.println("Condicion especial: No");
            }
            switch (arreglo[i].getEstado()) {
                case 0:
                    System.out.println("Estado: Pendiente");
                    break;
                case 1:
                    System.out.println("Estado: Atendido");
                    break;
                default:
                    System.out.println("Estado: Cancelado");
                    break;
            }
            System.out.println("--------------------------------");
        }
    }

    public String llamarSiguienteCliente(Queue<ObjPaciente> cola) {
        String mensaje = "";
        if (!cola.isEmpty()) {
            for (ObjPaciente o : cola) {
                if (o.getEstado() == 0 && o.getPrioritario() == 1) {
                    mensaje = "El siguiente cliente en pasar es: " + o.getNombre() + " Con el turno: " + o.getTurno()
                            + "Turno: Preferencial";
                    return mensaje;
                }
            }
            for (ObjPaciente o : cola) {
                if (o.getEstado() == 0) {
                    mensaje = "El siguiente cliente en pasar es: " + o.getNombre() + " Con el turno: " + o.getTurno()
                            + "Turno: Normal";
                    return mensaje;
                }
            }
            mensaje = "No hay clientes en espera a ser atendidos";
        } else {
            mensaje = "No hay clientes";
        }
        return mensaje;
    }

    public Queue<ObjPaciente> Atender(Queue<ObjPaciente> cola, Scanner sc) {
        if (!cola.isEmpty()) {
            System.out.println("Ingrese el turno que desea atender");
            int turno = sc.nextInt();
            for (ObjPaciente o : cola) {

                if (o.getTurno() == turno && o.getEstado() == 0) {
                    o.setEstado(1);
                    System.out.println("turno atendido");
                    return cola;
                }
            }
            System.out.println("No se encuentra ese turno");
        } else {
            System.out.println("No hay turnos por atender");
        }
        return cola;
    }

    public Queue<ObjPaciente> modificarServicio(Queue<ObjPaciente> cola, Scanner sc) {
        System.out.println("Ingrese el id del paciente al que le desea modificar el tipo de servicio");
        int id = sc.nextInt();
        for (ObjPaciente o : cola) {
            if (o.getId() == id) {
                System.out.println("Que servicio desea solicitar 1)Medicina 2)Odontologia");
                o.setServicio(sc.nextInt());
            }
        }
        return cola;
    }

    public Queue<ObjPaciente> cancelarTurno(Queue<ObjPaciente> cola, Scanner sc) {
        if (!cola.isEmpty()) {
            System.out.println("Ingrese el turno que desea cancelar");
            int turno = sc.nextInt();
            for (ObjPaciente o : cola) {
                if (o.getTurno() == turno) {
                    if (o.getEstado() == 0) {
                        o.setEstado(2);
                        System.out.println("Turno cancelado exitosamente");
                        return cola;
                    }
                }
            }
            System.out.println("Ese turno ya fue atendido o cancelado");
        } else {
            System.out.println("No hay turnos");
        }
        return cola;
    }

    public String estadoCliente(Queue<ObjPaciente> cola, Scanner sc) {
        String mensaje = "";
        System.out.println("Ingrese el id del cliente al que le desea consultar el estado");
        int id = sc.nextInt();
        for (ObjPaciente o : cola) {
            if (o.getId() == id) {
                switch (o.getEstado()) {
                    case 0:
                        mensaje = "Estado: Pendiente";
                        break;
                    case 1:
                        mensaje = "Estado: Atendido";
                        break;
                    default:
                        mensaje = "Estado: Cancelado";
                        break;
                }
            }
        }
        return mensaje;
    }

    public void atendidos(Queue<ObjPaciente> cola) {
        for (ObjPaciente o : cola) {
            if (o.getEstado() == 1) {
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Id: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                if (o.getServicio() == 1) {
                    System.out.println("Servicio: Medicina");
                } else {
                    System.out.println("Servicio: Odontologia");
                }
                if (o.getPrioritario() == 1) {
                    System.out.println("Condicion especial: Si");
                } else {
                    System.out.println("Condicion especial: No");
                }
                System.out.println("Estado: Atendido");
            }
        }
    }

    public void cancelados(Queue<ObjPaciente> cola) {
        for (ObjPaciente o : cola) {
            if (o.getEstado() == 2) {
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Id: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                if (o.getServicio() == 1) {
                    System.out.println("Servicio: Medicina");
                } else {
                    System.out.println("Servicio: Odontologia");
                }
                if (o.getPrioritario() == 1) {
                    System.out.println("Condicion especial: Si");
                } else {
                    System.out.println("Condicion especial: No");
                }
                System.out.println("Estado: Cancelado");
            }
        }
    }

    public void prioritarios(Queue<ObjPaciente> cola) {
        for (ObjPaciente o : cola) {
            if (o.getPrioritario() == 1) {
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Id: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                if (o.getServicio() == 1) {
                    System.out.println("Servicio: Medicina");
                } else {
                    System.out.println("Servicio: Odontologia");
                }
                if (o.getPrioritario() == 1) {
                    System.out.println("Condicion especial: Si");
                } else {
                    System.out.println("Condicion especial: No");
                }
                switch (o.getEstado()) {
                    case 0:
                        System.out.println("Estado: Pendiente");
                        break;
                    case 1:
                        System.out.println("Estado: Atendido");
                        break;
                    default:
                        System.out.println("Estado: Cancelado");
                        break;
                }
            }
        }
    }

    public Stack<ObjPaciente> pasarPila(Stack<ObjPaciente> pila, Queue<ObjPaciente> cola) {
        for (ObjPaciente o : cola) {
            if (o.getEstado() == 0) {
                pila.push(o);
            }
        }
        return pila;
    }

    public void mostrarPila(Stack<ObjPaciente> pila) {
        for (ObjPaciente o : pila) {
            System.out.println("Turno: " + o.getTurno());
            System.out.println("Id: " + o.getId());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Edad: " + o.getEdad());
            if (o.getServicio() == 1) {
                System.out.println("Servicio: Medicina");
            } else {
                System.out.println("Servicio: Odontologia");
            }
            if (o.getPrioritario() == 1) {
                System.out.println("Condicion especial: Si");
            } else {
                System.out.println("Condicion especial: No");
            }
            System.out.println("Estado: Pendiente");
        }
    }
}