package org.example;

import dao.SplitWiseDaoImpl;
import model.expense.EqualExpense;
import model.expense.ExactExpense;
import model.expense.PercentExpense;
import model.user.User;
import service.ExpenseManager;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager(SplitWiseDaoImpl.getInstance());
        expenseManager.addUser(new User("u1", "Aditya Dhiman", "adityadhiman12@gmail.com", "9996099683"));
        expenseManager.addUser(new User("u2", "Simranjeet Kaur", "rishu@gmail.com", "9729275430"));
        expenseManager.addUser(new User("u3", "Abhishek Dhiman", "adnaruto@gmail.com", "7876098885"));
        expenseManager.addUser(new User("u4", "Nawasha Dhariwal", "dnawasha@gmail.com", "9896809002"));

        ArrayList<String> users = new ArrayList<>();
        users.add("u1");
        users.add("u2");
        users.add("u3");
        users.add("u4");
        expenseManager.addExpense("u1", "Meghna", (double)1000, users, new EqualExpense());
        expenseManager.showBalances("u4");
        expenseManager.showBalances("u1");
        users.clear();
        users.add("u2");
        users.add("u3");
        List<Double> expenseVar = new ArrayList<>();
        expenseVar.add((double) 370);
        expenseVar.add((double) 880);
        expenseManager.addExpense("u1", "Sapna", (double) 1250, users, new ExactExpense(), expenseVar);
        expenseManager.showBalances();
        users.clear();
        users.add("u1");
        users.add("u2");
        users.add("u3");
        users.add("u4");
        expenseVar.clear();
        expenseVar.add((double) 40);
        expenseVar.add((double) 20);
        expenseVar.add((double) 20);
        expenseVar.add((double) 20);
        expenseManager.addExpense("u4", "kfc",(double) 1200, users, new PercentExpense(), expenseVar);
        expenseManager.showBalances("u1");
        expenseManager.showBalances();
    }
}