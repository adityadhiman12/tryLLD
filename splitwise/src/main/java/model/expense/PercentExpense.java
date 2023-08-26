package model.expense;

import model.enums.EXPENSE_TYPE;
import service.ExpenseBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentExpense extends ExpenseType {
    public PercentExpense() {
        super(EXPENSE_TYPE.PERCENTAGE);
    }


    @Override
    public Map<String, Double> getOweAmount(ExpenseBuilder expenseBuilder) {
        List<String> userIds = expenseBuilder.getParticipants();
        Map<String, Double> oweMap = new HashMap<>();
        for (int i = 0; i < userIds.size(); i++) {
            oweMap.put(userIds.get(i), expenseBuilder.getAmount() * (expenseBuilder.getDivisions().get(i) / 100));
        }
        return oweMap;
    }
}
