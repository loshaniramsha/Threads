/*
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}*/
class  Q{
    int num;
    boolean valueSet=false;

    //    wait() method
    public synchronized void putNum(int num){
        while (valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("put :"+num);
        this.num=num;
        valueSet=true;
        notify();
    }
    public synchronized void getNum(){
        while (!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("get :"+num);
        valueSet=false;
    }
}

class Producer implements Runnable {
    Q q;
    public Producer(Q q){
        Thread t = new Thread(this,"Producer");
        t.start();

        this.q=q;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            q.putNum(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable {
    Q q;
    public Consumer(Q q){
        Thread t = new Thread(this,"Consumer");
        t.start();
        this.q=q;
    }
    @Override
    public void run() {
        while (true){
            q.getNum();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class interTread {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);


    }
}