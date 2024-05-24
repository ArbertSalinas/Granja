import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
class Granja {
    private List<Animal> animales;

    public Granja() {
        this.animales = new ArrayList<>();
    }

    public void registrarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarCantidadPorTipo() {
        int gallinas = 0;
        int vacas = 0;
        int cerdos = 0;

        for (Animal animal : animales) {
            switch (animal.getTipo()) {
                case GALLINA:
                    gallinas++;
                    break;
                case VACA:
                    vacas++;
                    break;
                case CERDO:
                    cerdos++;
                    break;
            }
        }

        System.out.println("Cantidad de Gallinas: " + gallinas);
        System.out.println("Cantidad de Vacas: " + vacas);
        System.out.println("Cantidad de Cerdos: " + cerdos);
    }

    public static void main(String[] args) {
        Granja granja = new Granja();

        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.JANUARY, 1);
        Animal gallina1 = new Animal(1, "Gallina1", 2.5, TipoAnimal.GALLINA, cal.getTime());

        cal.set(2021, Calendar.FEBRUARY, 15);
        Animal vaca1 = new Animal(2, "Vaca1", 150.0, TipoAnimal.VACA, cal.getTime());

        cal.set(2020, Calendar.MARCH, 10);
        Animal cerdo1 = new Animal(3, "Cerdo1", 100.0, TipoAnimal.CERDO, cal.getTime());

        granja.registrarAnimal(gallina1);
        granja.registrarAnimal(vaca1);
        granja.registrarAnimal(cerdo1);

        System.out.println("Edad de Gallina1 en días: " + gallina1.calcularEdadEnDias());
        System.out.println("Edad de Vaca1 en días: " + vaca1.calcularEdadEnDias());
        System.out.println("Edad de Cerdo1 en días: " + cerdo1.calcularEdadEnDias());

        granja.mostrarCantidadPorTipo();
    }
}