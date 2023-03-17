package DesignPatterns.ChainOfResponsibility;

public class HiringManager extends Managers {
    public HiringManager(int approvalLimit, String name) {
        super(approvalLimit,name);
//        this.approvalLimit = approvalLimit;
//        this.name = name;
    }

    @Override
    protected void processSalary(int employeeSalary) {
        System.out.println(this.name + " has approved the salary at level 1, for salary amount " + employeeSalary);
    }
}
