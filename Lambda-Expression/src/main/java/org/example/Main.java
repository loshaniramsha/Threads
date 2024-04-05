package org.example;

public class Main {
    public static void main(String[] args){
        Runnable obj1;
        Runnable obj2;
        Thread t1 = new Thread(() -> {
            for (int i=1;i<=5;i++){
                System.out.println("one");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=1;i<=5;i++){
                System.out.println("Two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
        t2.start();
    }

}