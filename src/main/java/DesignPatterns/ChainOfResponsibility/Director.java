package DesignPatterns.ChainOfResponsibility;

public class Director extends Managers {

    public Director(int approvalLimit, String name) {
        super(approvalLimit,name);
    }

    @Override
    protected void processSalary(int employeeSalary) {
        System.out.println(this.name + " has approved the salary at level 3, for salary amount "+ employeeSalary );
    }
}
