package Test;

class Communicate {
    public static void main(String[] args) {
        Producer obj1 = new Producer();
        Consumer obj2 = new Consumer(obj1); 
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}

class Producer extends Thread {
    StringBuffer sb;

    Producer() {
        sb = new StringBuffer();
    }

    public void run() {
        synchronized (sb) {
            for (int i = 0; i <= 10; i++) {
                try {
                    sb.append(i + ":");
                    Thread.sleep(100);
                    System.out.println("appending");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sb.notify();
        }
    }
}

class Consumer extends Thread {
    Producer prod;

    Consumer(Producer prod) {
        this.prod = prod;
    }

    public void run() {
        synchronized (prod.sb) { 
            try {
                prod.sb.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(prod.sb);
        }
    }
}