/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Víctor
 */
public record Profesores(String nombre, String DNI, String tipoPersonal, String puesto, boolean horarioPersonal, LocalDate fechaAlta, LocalDate fechaBaja, LocalTime horaInicial, String totalHoras, String activo   ) {

}
