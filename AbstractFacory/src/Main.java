public class Main {
    public interface Animal {
        String getAnimal();

        String makeSound();
    }

    public class Duck implements Animal {

        @Override
        public String getAnimal() {
            return "Duck";
        }

        @Override
        public String makeSound() {
            return "Squeks";
        }
    }

    public interface AbstractFactory<T> {
        T create(String animalType);
    }

    public class AnimalFactory implements AbstractFactory<Animal> {

        @Override
        public Animal create(String animalType) {
            if ("Dog".equalsIgnoreCase(animalType)) {
                return new Dog();
            } else if ("Duck".equalsIgnoreCase(animalType)) {
                return new Duck();
            }

            return null;
        }

    }

    public class FactoryProvider {
        public static AbstractFactory getFactory(String choice) {

            if ("Animal".equalsIgnoreCase(choice)) {
                return new AnimalFactory();
            } else if ("Color".equalsIgnoreCase(choice)) {
                return new ColorFactory();
            }

            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}