package org.example;

import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private ArrayList<String> cursos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    public Profesor(String nombre, ArrayList<String> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }
}
