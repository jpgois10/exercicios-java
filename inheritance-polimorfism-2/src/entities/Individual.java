package entities;

public class Individual extends TaxPayer {
    private Double healthExpenses;

    public Individual() {}

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double tax() {
        if (getAnnualIncome() < 20000.00) {
            return (getAnnualIncome() * 0.15) - (healthExpenses * 0.5);
        }

        return (getAnnualIncome() * 0.25) - (healthExpenses * 0.5);
    }
}
