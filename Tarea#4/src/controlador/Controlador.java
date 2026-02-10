/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;
import vista.Vista;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Controlador {
    private Vista vista;
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    
    public Controlador(Vista vista) {
        this.vista = vista;
    }
    
    /**
    * Muestra el menú principal del sistema y ejecuta la acción correspondiente
    * según la opción seleccionada por el usuario. Permite crear y gestionar
    * estudiantes, profesores y cursos, realizar matrículas, asignaciones y 
    * mostrar información registrada. El menú se mantiene activo de forma 
    * recursiva hasta que el usuario elige salir.
    */
    public void menuInicio() {
        int opcion = vista.opcionMenu();
        String nombre = "";
        int edad;
        String carnet = "";
        String carrera = "";
        String codigoEmpleado = "";
        String especialidad = "";
        String curso = "";
        int creditos;
        
        int indice;
        Estudiante e;
        Profesor p;
        Curso c;
        
        switch(opcion) {
            case 1:
                curso = vista.pedirString("el curso");
                nombre = vista.pedirString("el nombre del curso");
                creditos = vista.pedirInt("los creditos");
                Curso nuevoCurso = new Curso(curso, nombre, creditos);
                cursos.add(nuevoCurso);
                vista.mostrarEvento("Curso creado");
                menuInicio();
                break;
            case 2:
                nombre = vista.pedirString("el nombre");
                edad = vista.pedirInt("la edad");
                carnet = vista.pedirString("el carnet");
                carrera = vista.pedirString("la carrera");
                Estudiante nuevoEstudiante = new Estudiante(nombre, edad, carnet, carrera);
                estudiantes.add(nuevoEstudiante);
                vista.mostrarEvento("Estudiante creado");
                menuInicio();
                break;
            case 3:
                nombre = vista.pedirString("el nombre");
                edad = vista.pedirInt("la edad");
                codigoEmpleado = vista.pedirString("el código de empleado");
                especialidad = vista.pedirString("la especialidad");
                Profesor nuevoProfesor = new Profesor(nombre, edad, codigoEmpleado, especialidad);
                profesores.add(nuevoProfesor);
                vista.mostrarEvento("Profesor creado");
                menuInicio();
                break;
            case 4:
                if(estudiantes.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un estudiante");
                    menuInicio();
                    break;
                } else if(cursos.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un curso");
                    menuInicio();
                    break;
                }
                
                carnet = "Lista de carnets de estudiantes\n";
                for(int i = 0; i < estudiantes.size(); i++) {
                    indice = i + 1;
                    carnet += indice + ". " + estudiantes.get(i).getCarnet() + "\n";
                }
                vista.mostrarEvento(carnet);
                opcion = vista.pedirInt("el indice del carnet del estudiante que quiere matricular");
                if(opcion < estudiantes.size() || estudiantes.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                e = estudiantes.get(opcion - 1);
                
                curso = "Lista de códigos de cursos\n";
                for(int i = 0; i < cursos.size(); i++) {
                    indice = i + 1;
                    curso += indice + ". " + cursos.get(i).getCurso() + "\n";
                }
                vista.mostrarEvento(curso);
                opcion = vista.pedirInt("el indice del codigo del curso que quiere matricular");
                if(opcion < cursos.size() || cursos.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                c = cursos.get(opcion - 1);
                e.matricularCurso(c);
                vista.mostrarEvento("Estudiante matriculado correctamente");
                menuInicio();
                break;
            case 5:
                if(profesores.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un profesor");
                    menuInicio();
                    break;
                } else if(cursos.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un curso");
                    menuInicio();
                    break;
                }
                
                codigoEmpleado = "Lista de codigos de empleados de profesores\n";
                for(int i = 0; i < profesores.size(); i++) {
                    indice = i + 1;
                    codigoEmpleado += indice + ". " + profesores.get(i).getCodigoEmpleado() + "\n";
                }
                vista.mostrarEvento(codigoEmpleado);
                opcion = vista.pedirInt("el indice del codigo del profesor que quiere asignarle");
                if(opcion < profesores.size() || profesores.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                p = profesores.get(opcion - 1);
                
                curso = "Lista de códigos de cursos\n";
                for(int i = 0; i < cursos.size(); i++) {
                    indice = i + 1;
                    curso += indice + ". " + cursos.get(i).getCurso() + "\n";
                }
                vista.mostrarEvento(curso);
                opcion = vista.pedirInt("el indice del codigo del curso que quiere matricular");
                if(opcion < cursos.size() || cursos.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                c = cursos.get(opcion - 1);
                p.asignarCurso(c);
                vista.mostrarEvento("Curso asignado a profesor correctamente");
                menuInicio();
                break;
            case 6:
                if(estudiantes.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un estudiante");
                    menuInicio();
                    break;
                }
                
                carnet = "Lista de carnets de estudiantes\n";
                for(int i = 0; i < estudiantes.size(); i++) {
                    indice = i + 1;
                    carnet += indice + ". " + estudiantes.get(i).getCarnet() + ", Curso matriculado: " + estudiantes.get(i).getCurso().getCurso() + "\n";
                }
                vista.mostrarEvento(carnet);
                opcion = vista.pedirInt("el indice del carnet del estudiante que quiere desmatricular");
                if(opcion < estudiantes.size() || estudiantes.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                e = estudiantes.get(opcion - 1);
                e.retirarCurso();
                vista.mostrarEvento("Curso retirado correctamente");
                menuInicio();
                break;
            case 7:
                if(profesores.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un profesor");
                    menuInicio();
                    break;
                }
                
                codigoEmpleado = "Lista de códigos de empleados de profesores\n";
                for(int i = 0; i < profesores.size(); i++) {
                    indice = i + 1;
                    codigoEmpleado += indice + ". " + profesores.get(i).getCodigoEmpleado() + ", Curso impartido: " + profesores.get(i).getCursoImpartido().getCurso() + "\n";
                }
                vista.mostrarEvento(codigoEmpleado);
                opcion = vista.pedirInt("el indice del codigo de empleado del profesor que quiere desasignar");
                if(opcion < profesores.size() || profesores.size() < opcion) {
                    vista.mostrarEvento("Indice fuera de rango");
                    menuInicio();
                    break;
                }
                p = profesores.get(opcion - 1);
                p.retirarCurso();
                vista.mostrarEvento("Curso retirado correctamente");
                menuInicio();
                break;
            case 8:
                if(estudiantes.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un estudiante");
                    menuInicio();
                    break;
                }
                
                carnet = "ESTUDIANTES\n";
                for(int i = 0; i < estudiantes.size(); i++) {
                    indice = i + 1;
                    carnet += indice + ". " + estudiantes.get(i).toString() + "\n";
                }
                vista.mostrarEvento(carnet);
                menuInicio();
                break;
            case 9:
                if(profesores.isEmpty()) {
                    vista.mostrarEvento("Debe crear almenos un profesor");
                    menuInicio();
                    break;
                }
                
                codigoEmpleado = "PROFESORES\n";
                for(int i = 0; i < profesores.size(); i++) {
                    indice = i + 1;
                    codigoEmpleado += indice + ". " + profesores.get(i).toString() + "\n";
                }
                vista.mostrarEvento(codigoEmpleado);
                menuInicio();
                break;
            case 10:
                break;
            default:
                menuInicio();
                break;
        }
    }
}
