package jmp.creationalPatterns.facade.models;

public class Expense {
    private int id;
    private String accountSystemNo;
    private Double expense;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountSystemNo() {
        return accountSystemNo;
    }

    public void setAccountSystemNo(String accountSystemNo) {
        this.accountSystemNo = accountSystemNo;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
