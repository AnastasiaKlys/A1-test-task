package com.company.a1.firstTask;

//IpV4 адрес состоит из 4 октетов, значит его можно хранить в переменной типа int32.
//        Реализуйте пару функций, которые однозначно преобразуют строковое представление
//        IpV4 адрес (вида "127.0.0.1") в значение типа int32 и наоборот.
//
//        Примеры:

//        2147483647
//        2149583360 ==> "128.32.10.0"
//        255         ==> "0.0.0.255"

//Задание реализовать невозможно при условии хранения IpV4 в переменной типа int32.
// Для этой задачи подойдет long, так как верхняя граница ip в одночисленном десятичном представлении достигается в 4294967295L.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.a1.firstTask.IpV4Converter.transformDecimalNumberToDotDecimalIpV4;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите строковое представление IpV4 адрес (вида 127.0.0.1)");
        String stringIp = in.nextLine();
        System.out.println(IpV4Converter.transformDotDecimalIpV4ToDecimalNumber(stringIp));


        System.out.println("Введите числовое представление IpV4 (вида 2149583360)");
        long decimalIp = in.nextLong();
        System.out.println(transformDecimalNumberToDotDecimalIpV4(decimalIp));

    }
}
