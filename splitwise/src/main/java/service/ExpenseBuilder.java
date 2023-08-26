package service;

import java.util.List;

public class ExpenseBuilder {
    private Double amount;
    private List<String> participants;
    private List<Double> divisions;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<Double> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Double> divisions) {
        this.divisions = divisions;
    }


    public ExpenseBuilder(Double amount, List<String> participants, List<Double> divisions) {
        this.amount=amount;
        this.participants=participants;
        this.divisions=divisions;
    }
    public ExpenseBuilder(Double amount, List<String> participants) {
        this.amount=amount;
        this.participants=participants;
    }
}
