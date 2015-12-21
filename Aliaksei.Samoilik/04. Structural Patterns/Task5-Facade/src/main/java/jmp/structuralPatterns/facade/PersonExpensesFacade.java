package jmp.structuralPatterns.facade;

import java.util.List;

import jmp.creationalPatterns.facade.dao.DerbyExpensesDao;
import jmp.creationalPatterns.facade.dao.DerbyPersonDao;
import jmp.creationalPatterns.facade.models.Expense;
import jmp.creationalPatterns.facade.models.Person;
import services.CalculateExpensesService;

public class PersonExpensesFacade {

    DerbyPersonDao derbyPersonDao;
    DerbyExpensesDao derbyExpensesDao;
    CalculateExpensesService calculateExpensesService;

    public PersonExpensesFacade(String dbPath) {
        derbyPersonDao = new DerbyPersonDao(dbPath);
        derbyExpensesDao = new DerbyExpensesDao(dbPath);
        calculateExpensesService = new CalculateExpensesService();
    }

    public double getExpensesForPersonId(int id){
        Person person = derbyPersonDao.find(1);
        List<Expense> expenses = derbyExpensesDao.getExpensesByAccountNo(person.getAccountSystemNo());
        double sum = calculateExpensesService.calcExpenses(expenses);
        return sum;
    }
}
