package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*Strings son "referenced types" en Java
         A pesar de no usar el método constructor (new String("")) estamos creando un objeto.
         Estos objetos String son especiales, pued se crean en un espacio especial de la memoria Heap llamado
         Java String Pool.

         Este espacio de memoria existe solo para Strings por 2 razones:
            1. Son los objetos más usados.
            2. Los Strings son inmutables, esto quiere decir, que no pueden cambiar.

         */

        /*Qué significa que un String es inmutable? Veamoslo*/
        System.out.println("IMMUTABLE STRING");
        ImmutableString.run();
        System.out.println("=============");
        String otherString= "hello ";
        String s1 = new String("hello ");
        String s2 = "world";

        //Si imprimimos lo siguiente, por qué obtenemos falso?

        if (s1==otherString){
            System.out.println("s1 es igual a otherString");
        }else{
            System.out.println("s1 no es igual a otherString");
        }
        //al estar instanciados en distintos espacios de memoria, la comparación con == está
        // preguntando por la igualdad en las referencias, no en el contenido.


        //Por qué con el siguiente código obtenemos verdadero?
        if (otherString=="hello "){
            System.out.println("otherString es hello ");
        }else{
            System.out.println("otherString no es hello ");
        }

        //La forma recomendada de comparar Strings es usando el método .equals()
        if (s1.equals(otherString)){
            System.out.println("s1 es igual a otherString");
        }
        System.out.println("=============");

        //Ahora, veamos algunos de los métodos útiles
        System.out.println("TRIM EXAMPLE");
        //Trim() Example
        StringTrimExample.run();
        System.out.println("=============");
        System.out.println("UPPER EXAMPLE");
        //StringUpperExample
        StringUpperExample.run();
        System.out.println("=============");
        System.out.println("LOWER EXAMPLE");
        //LowerExample
        StringLowerExample.run();
        System.out.println("=============");
        System.out.println("INDEXOF EXAMPLE");
        //IndexOfExample
        IndexOfExample5.run();
        System.out.println("=============");
        System.out.println("SPLIT EXAMPLE");
        //SplitExample
        SplitExample.run();
        System.out.println("=============");
        System.out.println("REPLACE EXAMPLE");
        //ReplaceExample
        ReplaceExample3.run();
        System.out.println("=============");
        System.out.println("JOIN EXAMPLE");
        //stringJoin
        StringJoinExample2.run();
        System.out.println("=============");


        System.out.println("EXCEPTION EXAMPLE");

        ExcepTest.run();
        System.out.println("=============");

        System.out.println("STRING MATCHING EXAMPLE");
        StringMatcherExample.run();
        System.out.println("=============");

    }

    public static class ImmutableString {
        public static void run() {
            String str = "Learning String";
            manipulateString(str);
            System.out.println(str);//will print Learning String because strings are immutable objects

            StringBuilder str2 = new StringBuilder("Learning String");
            manipulateString(str2);
            System.out.println(str2);//will print Learning String By Doing because stringbuilder object is mutable

            str = str.concat(" By Doing");

            System.out.println(str);

        }


        private static void manipulateString(String str) {
            str.concat(" By Doing");//concat() method appends the string at the end  but returns a new String.
        }

        private static void manipulateString(StringBuilder str) {
            str.append(" By Doing");//append() method appends the string at the end }
        }


    }

    public static class ExcepTest {

        public static void run() {
            int a[] = new int[2];
            try {
                System.out.println("Access element three :" + a[3]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception thrown  :" + e);
            }finally {
                a[0] = 6;
                System.out.println("First element value: " + a[0]);
                System.out.println("The finally statement is executed");
            }
        }
    }



    public static class StringTrimExample{
        public static void run(){
            String s1 ="  hello java string   ";
            System.out.println(s1.length());
            System.out.println(s1); //Without trim()
            String tr = s1.trim();
            System.out.println(tr.length());
            System.out.println(tr); //With trim()
        }}


    public static class StringUpperExample{
        public static void run(){
            String s1="hello string";
            String s1upper=s1.toUpperCase();
            System.out.println(s1upper);
        }}

    public static class StringLowerExample{
        public static void run (){
            String s1="HELLO stRIng";
            String s1lower=s1.toLowerCase();
            System.out.println(s1lower);
        }}

    public static class IndexOfExample5
    {
        // main method
        public static void run()
        {

            String str = "Welcome to Java";
            int count = 0;
            int startFrom = 0;
            int index=0;
            while (index!=-1)
            {

                index = str.indexOf('o', startFrom);

                if(index >= 0)
                {
// match found. Hence, increment the count
                    count = count + 1;

// start looking after the searched index
                    startFrom = index + 1;
                }



            }

            System.out.println("In the String: "+ str);
            System.out.println("The 'o' character has come "+ count + " times");
        }
    }

    public static class SplitExample{
        public static void run(){
            String s1="java string split method";
            String[] words=s1.split("\\s");//splits the string based on whitespace
//using java foreach loop to print elements of string array
            for(String w:words){
                System.out.println(w);
            }
        }}

    public static class ReplaceExample3 {
        public static void run() {
            String str = "oooooo-hhhh-oooooo";
            String rs = str.replace("h","s"); // Replace 'h' with 's'
            System.out.println(rs);
            rs = rs.replace("s","h"); // Replace 's' with 'h'
            System.out.println(rs);
        }
    }
    public static class StringJoinExample2 {
        public static void run() {
            String date = String.join("/","25","06","2018");
            System.out.print(date);
            String time = String.join(":", "12","10","10");
            System.out.println(" "+time);
        }
    }

    public static class StringMatcherExample  {

        // Main driver method
        public static void run()
        {

            // Declaring and initializing a string
            // Input string
            String str = "rita2004@gmail.com";
            String str2 = "Manuel2254?.com";
            //https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285
            String pattern = "^([a-z0-9_\\.\\+-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
            // Display message for better readability
            System.out.print(
                    "Does String " + str +" contains pattern: ");
            // Testing if regex is present or not
            System.out.println(str.matches(pattern));

            System.out.print(
                    "Does String " + str2 +" contains pattern: ");
            // Testing if regex is present or not
            System.out.println(str2.matches(pattern));


        }
    }
}
