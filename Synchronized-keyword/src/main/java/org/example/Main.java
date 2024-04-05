package org.example;
class Calculation{
    int num;
    public synchronized void increment(){
        num++;
        /*System.out.println("Count:"+num);*/
    }



    }

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Calculation c=new Calculation();
      /* c.increment();
        c.increment();
        c.increment();*/
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=1000;i++){
                    c.increment();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=1000;i++){
                    c.increment();
                }
            }
        });

       t1.start();
       t2.start();
       t1.join();
       t2.join();
        System.out.println("Count:"+c.num);
    }
}