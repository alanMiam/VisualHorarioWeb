package Modelo;

import java.sql.Time;

public class Sesion {
    int idSesion;
    Time horaInicio;//Agregar selector de hora limitado a horas sin minutos y entre 7:00-20:00 
    Time horaFin;//Agregar selector de hora limitado a horas sin minutos y entre 8:00-21:00
    int dia;//*Crear select en la interfaz* (1:Lunes, 2:Martes, 3:Miercoles, 4:Jueves, 5:Viernes)
    int ID;//ID de la clase a la que pertenece esta sesión
//------------------------------------------------------------------------------

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    

}
