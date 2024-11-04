package org.example.ejed;

import java.util.Objects;

/**
 * La clase Persona representa a una persona con atributos como nombre, apellidos y edad.
 * Proporciona métodos para obtener y establecer estos atributos, así como para comparar
 * instancias de la clase.
 */
public class Persona {
    private String nombre;     // Nombre de la persona
    private String apellidos;  // Apellidos de la persona
    private int edad;         // Edad de la persona

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param edad      La edad de la persona.
     */
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // Getters

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    // Setters

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Compara este objeto Persona con otro objeto.
     *
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica la identidad
        if (!(obj instanceof Persona)) return false; // Verifica el tipo
        Persona persona = (Persona) obj; // Realiza el cast
        return edad == persona.edad &&
                Objects.equals(nombre, persona.nombre) && // Manejar comparación segura ante null
                Objects.equals(apellidos, persona.apellidos); // Manejar comparación segura ante null
    }

    /**
     * Devuelve un código hash para este objeto Persona.
     *
     * @return Un entero que representa el código hash de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
