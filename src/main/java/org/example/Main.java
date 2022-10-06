package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("¡Programación funcional con Java!");

        Alumno al1 = new Alumno("Juan", "DAM", 20);
        Alumno al2 = new Alumno("Pedro", "DAW", 22);
        Alumno al3 = new Alumno("Laura", "DAM", 23);
        alumnos.add(al1);
        alumnos.add(al2);
        alumnos.add(al3);

        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<String> cursos = new ArrayList<>();
        cursos.add("DAM");
        cursos.add("DAW");
        cursos.add("ASIR");
        Profesor p1 = new Profesor("Alfonso", cursos);
        Profesor p2 = new Profesor("Jose Luis", cursos);
        profesores.add(p1);
        profesores.add(p2);

        // TODO .forEach()
        alumnos.stream()
                //.forEach(alumno -> System.out.println(alumno));
                .forEach(System.out::println); // TODO Cuando el arg de lambda (alumno) == lo que queremos pintar (alumno), se puede simplicar con ::


        // TODO .map() & .collect() -- foreach para almacenar en una nueva List
        // .map -- editar el objeto; Es una operación intermedia
        // .collect -- recoger el objeto editado por el .map y guardarlo en una List

        List<Alumno> alumnos2years =
                alumnos.stream()
                        .map(alumno -> new Alumno(
                                alumno.getNombre(),
                                alumno.getCurso(),
                                alumno.getEdad() + 2
                        ))
                        .collect(Collectors.toList());
        System.out.println(alumnos2years);

        //TODO .filter() -- filtrar - Operación intermedia

        List<Alumno> alumnosFilter =
                alumnos.stream()
                        .filter(alumno -> alumno.getCurso().equals("DAM"))
                        .map(alumno -> new Alumno(
                                alumno.getNombre(),
                                alumno.getCurso(),
                                alumno.getEdad() + 5
                        ))
                        .collect(Collectors.toList());
        System.out.println(alumnosFilter + " son los rials de DAM");

        // TODO .findFirst()
        Alumno firstAlumno =
                alumnos.stream()
                        .filter(alumno -> alumno.getCurso().equals("DAM"))
                        .map(alumno -> new Alumno(
                                alumno.getNombre(),
                                alumno.getCurso(),
                                alumno.getEdad() + 5
                        ))
                        .findFirst()    // Hay posibilidad de null por lo tanto .orElse()
                        .orElse(null);

        System.out.println("El primer alumno de DAM es : " + firstAlumno);


        // TODO .flatmap()
        String curso = profesores.stream()
                .map(profesor -> profesor.getCursos())
                //.flatMap(strings -> strings.stream())
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));  // juntar en una misma linea y separarlos por ","

        System.out.println(curso);

        // TODO ShortCircuit: .skip() .limit()

        List<Alumno> listLimitada =
                alumnos.stream()
                        .skip(1)
                        .limit(1)
                        .collect(Collectors.toList());

        System.out.println(listLimitada);

        //TODO Finite data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


        // TODO Min or Max

        Alumno alumno_max_edad= alumnos.stream()
                .max(Comparator.comparing(Alumno::getEdad))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(alumno_max_edad);

        // TODO .reduce
        int total_edad =
                alumnos.stream()
                        .map(Alumno::getEdad)
                        .reduce(0,Integer::sum);
        System.out.println(".reduce : "+total_edad);


    }
}