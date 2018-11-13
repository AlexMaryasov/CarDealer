import com.sun.org.apache.regexp.internal.RE;
import entity.Car;
import service.CarDealer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Program {
    private static final CarDealer DEALER = new CarDealer("MyDealer");
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static int cs = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Chose option:\n" +
                "1. Add car;\n" +
                "2. All car list;\n" +
                "3. Car list by make;\n" +
                "4. Car list by make with limit;\n" +
                "5. Car update;\n" +
                "6. Remove car;\n" +
                "7. Remove all car by make;\n" +
                "8. Car list by year (from - to);\n" +
                "9. Car list by price (from - to);\n" +
                "10. Car list by volume (from - to);\n\n" +
                "Enter \"menu\" for menu.\n" +
                "Enter \"exit\" for end.\n\n" +
                "Make your chose:");
        while (true) {

            switch (READER.readLine()) {
                case "1":
                    cs = 1;
                    addCar();
                    break;
                case "2":
                    cs = 2;
                    printAll();
                    break;
                case "3":
                    cs = 3;
                    getAllByMake();
                    break;
                case "4":
                    cs = 4;
                    getAllByMake();
                    break;
                case "5":
                    cs = 5;
                    update();
                    break;
                case "6":
                    cs = 6;
                    remove();
                    break;
                case "7":
                    cs = 7;
                    removeAllByMake();
                    break;
                case "8":
                    cs = 8;
                    getAllByYear();
                    break;
                case "9":
                    cs = 9;
                    getAllByPrice();
                    break;
                case "10":
                    cs = 10;
                    getAllByVolume();
                    break;

                case "exit":
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("There is no such option");
            }
        }
    }

    public static void addCar() throws IOException {
        System.out.println("Enter make: ");
        String make = READER.readLine();
        System.out.println("Enter model: ");
        String model = READER.readLine();
        System.out.println("Enter year: ");
        Integer year = Integer.valueOf(READER.readLine());
        System.out.println("Enter volume: ");
        Double volume = Double.valueOf(READER.readLine());
        System.out.println("Enter price: ");
        Integer price = Integer.valueOf(READER.readLine());
        Car car = new Car(make, model, year, price, volume);
//        Car car = new Car(make, model, 456, 4444, 3);
        if (DEALER.addCar(car)) {
            System.out.println("car added");
        } else {
            System.out.println("car " + car + " already exists");
        }
    }

    public static void printAll() {
        if (DEALER.getCars().isEmpty()) {
            System.out.println("There is no cars");
            return;
        }
        for (Car car : DEALER.getCars()) {
            System.out.println(car);
        }


    }

    public static void getAllByMake() throws IOException {
        if (DEALER.getCars().isEmpty()) {
            System.out.println("There is no cars");
            return;
        }
        System.out.println("Enter make: ");
        String make = READER.readLine();


        if (cs == 4) {
            System.out.println("Enter limit: ");
            int lim = Integer.valueOf(READER.readLine());
            for (Car m : DEALER.getAllByMake(make, lim)) {
                if (make.equals(m.getMake())) {
                    System.out.println(m);
                }
            }
        } else {
            for (Car m : DEALER.getAllByMake(make)) {
                if (make.equals(m.getMake())) {
                    System.out.println(m);
                }
            }
        }
    }

    public static void update() throws IOException {
        if (!DEALER.getCars().isEmpty()) {
            System.out.println("Create new car: ");
            System.out.println("Enter make: ");
            String make = READER.readLine();
            System.out.println("Enter model: ");
            String model = READER.readLine();
            System.out.println("Enter year: ");
            Integer year = Integer.valueOf(READER.readLine());
            System.out.println("Enter volume: ");
            Double volume = Double.valueOf(READER.readLine());
            System.out.println("Enter price: ");
            Integer price = Integer.valueOf(READER.readLine());
            Car car = new Car(make, model, year, price, volume);

            for (Car m : DEALER.getCars()) {
                if (car.equals(m)) {
                    System.out.println("car " + car + " already exists");
                    break;
                }
                Car car2 = DEALER.update(m);

                if (DEALER.addCar(car)) {
                    System.out.println("Random car:\n" + car2 +
                            "\nRemoved!\n\n" +
                            "New car:\n" + car +
                            "\nAdded!");
                    break;
                }

            }
        } else {
            System.out.println("There is no cars");
        }
    }


    public static void remove() throws IOException {
        System.out.println("Chose car for remove: ");
        for (Car car : DEALER.getCars()) {
            System.out.println(car);
        }
        int re = 0;
        System.out.println("Enter make: ");
        String make = READER.readLine();
        for (Car m : DEALER.getCars()) {
            if (make.equals(m.getMake())) {
                System.out.println(m);
                re = 1;
            }
        }
        if (re != 1) {
            System.out.println("We dont have that car.");
            return;
        }
        System.out.println("Enter model: ");
        String model = READER.readLine();
        for (Car m : DEALER.getCars()) {
            if (make.equals(m.getMake()) && model.equals(m.getModel())) {
                System.out.println(m);
                re = 2;
            }
        }
        if (re != 2) {
            System.out.println("We dont have that car.");
            return;
        }
        System.out.println("Enter year: ");
        Integer year = Integer.valueOf(READER.readLine());
        for (Car m : DEALER.getCars()) {
            if (make.equals(m.getMake()) && model.equals(m.getModel()) && year.equals(m.getYear())) {
                System.out.println(m);
                re = 3;
            }
        }
        if (re != 3) {
            System.out.println("We dont have that car.");
            return;
        }
        System.out.println("Enter volume: ");
        Double volume = Double.valueOf(READER.readLine());
        for (Car m : DEALER.getCars()) {
            if (make.equals(m.getMake()) && model.equals(m.getModel()) && year.equals(m.getYear()) && volume.equals(m.getVolume())) {
                System.out.println(m);
                re = 4;
            }
        }
        if (re != 4) {
            System.out.println("We dont have that car.");
            return;
        }
        System.out.println("Enter price: ");
        Integer price = Integer.valueOf(READER.readLine());
        for (Car m : DEALER.getCars()) {
            if (make.equals(m.getMake()) && model.equals(m.getModel()) && year.equals(m.getYear()) && volume.equals(m.getVolume()) && price.equals(m.getPrice())) {
                System.out.println(m);
                re = 5;
            }
        }
        if (re != 5) {
            System.out.println("We dont have that car.");
            return;
        }
        Car car = new Car(make, model, year, price, volume);

        if (DEALER.remove(car)) System.out.println("Car removed");
    }

    public static void removeAllByMake() throws IOException {
        System.out.println("Chose make for remove: ");
        int a = 0;
        for (Car car : DEALER.getCars()) {

            System.out.println(++a + ". " + car.getMake() + ";");

        }
        System.out.println("Enter make: ");
        String make = READER.readLine();

        if (DEALER.removeAllByMake(make)) System.out.println("Cars removed");
    }

    public static void getAllByVolume() throws IOException {
        if (DEALER.getCars().isEmpty()) {
            System.out.println("There is no cars");
            return;
        }
        System.out.println("Enter from what Volume: ");
        int from = Integer.valueOf(READER.readLine());
        System.out.println("Enter to what Volume: ");
        int to = Integer.valueOf(READER.readLine());

        for (Car m : DEALER.getAllByVolume(from, to)) {
            System.out.println(m);
        }
    }
        public static void getAllByPrice() throws IOException {
            if (DEALER.getCars().isEmpty()) {
                System.out.println("There is no cars");
                return;
            }
            System.out.println("Enter from what Price: ");
            int from = Integer.valueOf(READER.readLine());
            System.out.println("Enter to what Price: ");
            int to = Integer.valueOf(READER.readLine());

            for (Car m : DEALER.getAllByPrice(from, to)) {
                System.out.println(m);
            }
        }

    public static void getAllByYear() throws IOException {
        if (DEALER.getCars().isEmpty()) {
            System.out.println("There is no cars");
            return;
        }
        System.out.println("Enter from what Year: ");
        int from = Integer.valueOf(READER.readLine());
        System.out.println("Enter to what Year: ");
        int to = Integer.valueOf(READER.readLine());

        for (Car m : DEALER.getAllByYear(from, to)) {
            System.out.println(m);
        }
    }

    }
