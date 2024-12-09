package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private String email;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBithDate() {
        return birthDate;
    }

    public void setBithDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name +
                "(" + DATE_FORMATTER.format(birthDate) + ") - " +
                email;

    }
}
