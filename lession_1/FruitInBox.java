package ru.GeekBrains.Java_3.lession_1;

public class FruitInBox {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        System.out.println("The apple weighs: " + apple1.getWeight());
        System.out.println("The orange weighs: " + orange1.getWeight());
        System.out.println();

        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);

        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);
        orangeBox1.addFruit(orange3);

        System.out.println("Weight of the first box of apples: " + appleBox1.getWeightBox());
        System.out.println("Weight of the second box of oranges: " + orangeBox1.getWeightBox());
        if (appleBox1.compare(orangeBox1)) System.out.println("The weight of the boxes is the same");
        System.out.println("the weight of the boxes does not match");
        System.out.println();

        Box<Apple> appleBox2 = new Box<>(apple1);

        System.out.println("Weight of the second box of apples: " + appleBox2.getWeightBox());
        System.out.println();

        System.out.println("Transferring apples from the first box to the second");
        System.out.println();
        appleBox1.replaceAllFruitsToOtherBox(appleBox2);
        System.out.println("Weight of the first box of apples: " + appleBox1.getWeightBox());
        System.out.println("Weight of the second box of apples: " + appleBox2.getWeightBox());


    }
}
