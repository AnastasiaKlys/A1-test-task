package com.company.a1.secondTask;

//Задание 2 "Стремится к нулю или к бесконечности?"
//        (n! обозначает factorial(n))
//        Будет ли выражение вида:
//        un = (1 / n!) * (1! + 2! + 3! + ... + n!)
//        стремится к 0 или к бесконечности?
//        Реализуйте функцию, которая расчитывает значение un для целочисленных n > 1
//        (с точностью не хуже 6 знаков после запятой).


import java.util.Scanner;

import static com.company.a1.secondTask.Limit.limit;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите число n для вычисления выражения: un = (1 / n!) * (1! + 2! + 3! + ... + n!)");
        int n = in.nextInt();

        System.out.println(limit(n));
    }
}