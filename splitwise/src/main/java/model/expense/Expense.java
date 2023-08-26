package model.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.user.User;

import java.util.Map;


public class Expense {
    private String label;
    private ExpenseType expenseType;
    private double amount;
    private String payer;
    private Map<String, Double> owerAmountMap;
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Map<String, Double> getOwerAmountMap() {
        return owerAmountMap;
    }

    public void setOwerAmountMap(Map<String, Double> owerAmountMap) {
        this.owerAmountMap = owerAmountMap;
    }


    public Expense(String label, ExpenseType expenseType, double amount, String payer, Map<String, Double> owerAmountMap) {
        this.label = label;
        this.expenseType = expenseType;
        this.amount = amount;
        this.payer = payer;
        this.owerAmountMap = owerAmountMap;
    }


}
