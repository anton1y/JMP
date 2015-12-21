package jmp.structuralPatterns.facade;

public class App {
    public static void main(String[] args) {
        PersonExpensesFacade personExpensesFacade = new PersonExpensesFacade("d:/Task4-5-Facade");
        double sum = personExpensesFacade.getExpensesForPersonId(1);

        System.out.println("user expenses:" + sum);
    }
}
