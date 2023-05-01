package Synchronization.ThreadCreationMethods;

public class MainClass {
    public static void main(String args[]) {

        //setting the name of the thread
    Thread t1=new Thread1("Ahad");
    t1.start();
    Thread t2=new Thread2("Samad");
    t2.start();

    // using runnable interface,we are setting the name of the thread
    Thread t3=new Thread(new Thread3(),"Samad");
    t3.start();

        Thread t4=new Thread(new Thread4(),"Samad4");
        t4.start();

    //start is async method,immediately nhi start hota hai pr it tell jvm jab free hona to start krdena thread ko aur run method call krdena
    }
}
