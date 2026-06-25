import java.util.*;

class Car {
    String make;
    String model;
    int year;
    int doors;
    String fuel;

    Car(String make, String model, int year, int doors, String fuel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.doors = doors;
        this.fuel = fuel;
    }

    void showInfo() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Doors: " + doors);
        System.out.println("Fuel: " + fuel);
    }
}

class ManagedCar extends Car {
    int km;
    boolean rented;
    double rate;
    int nextServiceKm;
    String loc;

    ManagedCar(String make, String model, int year, int doors, String fuel,
               int km, boolean rented, double rate, int nextServiceKm, String loc) {
        super(make, model, year, doors, fuel);
        this.km = km;
        this.rented = rented;
        this.rate = rate;
        this.nextServiceKm = nextServiceKm;
        this.loc = loc;
    }

    void showManageInfo() {
        System.out.println("Manage Info:");
        System.out.println("Rented: " + (rented ? "Yes" : "No"));
        System.out.println("Rate: " + rate);
        System.out.println("Mileage: " + km + " km");
        System.out.println("Next Service At: " + nextServiceKm + " km");
        System.out.println("Location: " + loc);
    }
}

class ElectricCar extends ManagedCar {
    int battery;
    int rangeKm;
    int charge;

    ElectricCar(String make, String model, int year, int doors,
                int km, boolean rented, double rate, int nextServiceKm, String loc,
                int battery, int rangeKm, int charge) {
        super(make, model, year, doors, "electric", km, rented, rate, nextServiceKm, loc);
        this.battery = battery;
        this.rangeKm = rangeKm;
        this.charge = charge;
    }

    void showElectricInfo() {
        System.out.println("Electric Info:");
        System.out.println("Battery: " + battery + " kWh");
        System.out.println("Range: " + rangeKm + " km");
        System.out.println("Charge: " + charge + "%");
    }
}

public class CarManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter make:");
        String make = sc.nextLine();

        System.out.println("Enter model:");
        String model = sc.nextLine();

        System.out.println("Enter year:");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter doors:");
        int doors = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter fuel:");
        String fuel = sc.nextLine();

        System.out.println("Enter mileage (km):");
        int km = sc.nextInt();
        sc.nextLine();

        System.out.println("Is it rented? (yes/no):");
        String r = sc.nextLine();
        boolean rented = r.equalsIgnoreCase("yes") || r.equalsIgnoreCase("y");

        System.out.println("Enter daily rate:");
        double rate = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter next service at (km):");
        int nextServiceKm = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter location:");
        String loc = sc.nextLine();

        if (fuel.equalsIgnoreCase("electric")) {
            System.out.println("Enter battery (kWh):");
            int battery = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter range per charge (km):");
            int rangeKm = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter charge level (%):");
            int charge = sc.nextInt();
            sc.nextLine();

            ElectricCar e = new ElectricCar(make, model, year, doors, km, rented, rate, nextServiceKm, loc, battery, rangeKm, charge);
            System.out.println();
            e.showInfo();
            e.showManageInfo();
            e.showElectricInfo();
        } else {
            ManagedCar m = new ManagedCar(make, model, year, doors, fuel, km, rented, rate, nextServiceKm, loc);
            System.out.println();
            m.showInfo();
            m.showManageInfo();
        }

        sc.close();
    }
}
