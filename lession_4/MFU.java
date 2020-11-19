package ru.GeekBrains.Java_3.lession_4;


//2. Создать MFU c функциями, сканирования, печати и ксерокопирования


public class MFU {
    public static void main(String[] args) {
            MFU mfu = new MFU();
            Thread t1 = new Thread(()->mfu.print(10));
            Thread t2 = new Thread(()->mfu.scan(10));
            Thread t3 = new Thread(()->mfu.scanToNet(10));
            t1.start();
            t2.start();
            t3.start();
        }

        private Object lock1 = new Object();
        private Object lock2 = new Object();
        private Object lock3 = new Object();

        void print ( int pages){
            synchronized (lock1) {
                try {
                    for (int i = 0; i < pages; i++) {
                        Thread.sleep(50);
                        System.out.println("Отпечатано " + (i + 1) + " страниц");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void scan ( int pages){
            synchronized (lock2) {
                try {
                    for (int i = 0; i < pages; i++) {
                        Thread.sleep(50);
                        System.out.println("Отсканировано " + (i + 1) + " страниц");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    void scanToNet ( int pages){
        synchronized (lock3) {
            try {
                for (int i = 0; i < pages; i++) {
                    Thread.sleep(50);
                    System.out.println("Отсканировано в сеть " + (i + 1) + " страниц");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }