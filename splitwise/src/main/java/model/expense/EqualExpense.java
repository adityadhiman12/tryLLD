package model.expense;

import model.enums.EXPENSE_TYPE;
import service.ExpenseBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualExpense extends ExpenseType {

    public EqualExpense() {
        super(EXPENSE_TYPE.EQUAL);
    }


    @Override
    public Map<String, Double> getOweAmount(ExpenseBuilder expenseBuilder) {
        List<String> userIds = expenseBuilder.getParticipants();
        Map<String, Double> oweMap = new HashMap<>();
        for (String userId : userIds) {
            oweMap.put(userId, expenseBuilder.getAmount() / userIds.size());
        }
        return oweMap;
    }
}
