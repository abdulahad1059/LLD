package DesignPatterns.ChainOfResponsibility;

public class SeniorManager extends Managers{

    public SeniorManager(int approvalLimit, String name) {
        super(approvalLimit,name);
    }

    @Override
    protected void processSalary(int employeeSalary) {
        System.out.println(this.name + " has approved the salary at level 2, for salary amount "+ employeeSalary );
    }
}
