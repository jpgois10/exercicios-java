package entities;

public class Company extends TaxPayer {
    private Integer totalEmployees;

    public Company() {}

    public Company(String name, Double annualIncome, int totalEmployees) {
        super(name, annualIncome);
        this.totalEmployees = totalEmployees;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    @Override
    public Double tax() {
        if (totalEmployees > 10) {
            return (getAnnualIncome() * 0.14);
        }

        return (getAnnualIncome() * 0.16);
    }
}
