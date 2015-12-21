package jmp.creationalPatterns.facade.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jmp.creationalPatterns.facade.models.Expense;

public class DerbyExpensesDao extends BaseDerbyDao {

    public DerbyExpensesDao(String dbPath) {
        super(dbPath);
    }

    public List<Expense> getExpensesByAccountNo(String accountNo) {
        Connection conn = null;
        List<Expense> expenses = new ArrayList<>();
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EXPENSES where NO_ACCOUNTSYSTEM ='" + accountNo + "'");
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("ID"));
                expense.setExpense(rs.getDouble("EXPENSE"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return expenses;
    }
}
