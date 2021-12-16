package ec.edu.epn.practica.project;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<String> opciones = new ArrayList<>();
    private final Usuario usuario;
    private int eleccion;
    public Menu(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<String> generarListaGerente(){
        opciones.add("0. Salir");
        opciones.add("1. Crear producto");
        opciones.add("2. Actualizar producto");
        opciones.add("2. Eliminar producto");
        return opciones;
    }

    public boolean mostrarOpciones() {
        String tipoUsuario = this.usuario.getTipo();
        switch (tipoUsuario) {
            case "Gerente":
                if (opciones.isEmpty()) {
                    generarListaGerente();
                }
                System.out.print(this);
                break;
            case "Peluquero":
                System.out.println("Próximamente Peluquero");
                System.exit(0);
                return false;
            case "Asistente":
                System.out.println("Próximamente Asistente");
                System.exit(0);
                return false;
            default:
                System.out.println("No es un tipo de usuario valido");
                System.exit(0);
                return false;
        }
        return true;
    }

    public void escogerOpcion() {
        do {
            if(mostrarOpciones()){
                Scanner inputEleccion = new Scanner(System.in);
                try {
                    eleccion = inputEleccion.nextInt();
                }catch (Exception e){
                    System.out.println("Esa no es una opción valida");
                    System.exit(0);
                }

                String tipoUsuario = this.usuario.getTipo();
                switch (tipoUsuario) {
                    case "Gerente":
                        //desarrollarOpcionesGerente();
                        break;
                    case "Peluquero":
                        break;
                    case "Asistente":
                        break;
                    default:
                        System.out.println("No es un tipo de usuario valido");
                        System.exit(0);
                        break;
                }
            }
        }while(eleccion!=0);
    }

    public void createDividers(){
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");
    }

    public String[] validarObtenerDatos(String[] datos, boolean isPriceValid){
        return new String[]{};
    }
    @Override
    public String toString() {
        createDividers();
        System.out.println("\t\t\t\t\tMenú Principal\n");
        for(String opcion: opciones){
            System.out.println(opcion);
        }
        return "Seleccione el número de la opción que desee realizar: ";
    }
}

