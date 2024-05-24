import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
class Animal {
    private int identificador;
    private String nombre;
    private double peso;
    private TipoAnimal tipo;
    private Date fechaNacimiento;

    public Animal(int identificador, String nombre, double peso, TipoAnimal tipo, Date fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.peso = peso;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public long calcularEdadEnDias() {
        Date hoy = new Date();
        long diffInMillis = hoy.getTime() - this.fechaNacimiento.getTime();
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}