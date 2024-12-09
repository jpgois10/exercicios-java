package entities;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(Double price, String name, LocalDate manufactureDate) {
        super(price, name);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        return getName() + " (used) " + " $ " +
                String.format("%.2f", getPrice()) +
                " (Manufacture date: " +
                DATE_FORMATTER.format(manufactureDate) +
                ")";
    }
}
