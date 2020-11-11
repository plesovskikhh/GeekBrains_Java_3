package ru.GeekBrains.Java_3.lession_3;

import java.io.*;
import java.util.*;

//        1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//        2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
//        ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
//        3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//        Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//        Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.


public class Main_2 {


    public static void main(String[] args) {

        try {
            ArrayList <FileInputStream> al = new ArrayList<>();
            File f = new File("1.txt");
            File one = new File("one.txt");
            File two = new File("two.txt");
            File three = new File("three.txt");
            File four = new File("four.txt");
            File five = new File("five.txt");
            File journal = new File("journal.txt");
            File book = new File("book.txt");

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(journal)));
            al.add(new FileInputStream(one));
            al.add(new FileInputStream(two));
            al.add(new FileInputStream(three));
            al.add(new FileInputStream(four));
            al.add(new FileInputStream(five));

            SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(al));

            byte a[] = new byte[bis.available()];
            bis.read(a);
            bis.close();
            int x;
            while ((x=sin.read())!= -1){
                out.write(x);
            }
            sin.close();
            out.close();
            Book(book);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Book(File f) throws IOException {
        int t = 1;
        RandomAccessFile raf = new RandomAccessFile(f,"r");
        System.out.println("Для выхода из приложения введите 0");
        while (t!=0){
            System.out.println("Для чтения введите номер страницы");
            Scanner sc = new Scanner(System.in);
            t=sc.nextInt();
            if (t== 0){break;}
            read(t,raf);
        }
    }

    public static boolean read(int page, RandomAccessFile r) throws IOException {
        r.seek((page-1)*1800);
        if (r.read() == -1){
            System.out.println("такой страницы нет");
            return false;
        }
        else{

            for (int i = 0; i < 1800; i++) {
                System.out.print((char)r.read());
                if (i==1799){
                    System.out.println("\n");
                }
            }
        }
        return true;
    }
}
