package com.emergentes.modelo;

public class Inscripciones {
    private int id;
    private int id_curso;
    private int id_estudiante;
    private int nota_final;
    private String nombre;
    private String curso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "id=" + id + ", id_curso=" + id_curso + ", id_estudiante=" + id_estudiante + ", nota_final=" + nota_final + ", nombre=" + nombre + ", curso=" + curso + '}';
    }



    
    

}
