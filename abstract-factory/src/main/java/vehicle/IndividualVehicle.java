package vehicle;

import interfaces.Customer;
import interfaces.Vehicle;

public class IndividualVehicle implements Vehicle {

    private String name;
    private Customer customer;

    public IndividualVehicle(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public void pickUp() {
        System.out.printf("%s está buscando %s", name, customer.getName());
    }

}
