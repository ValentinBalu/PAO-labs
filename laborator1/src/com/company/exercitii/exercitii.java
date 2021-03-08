package com.company.exercitii;

import java.util.Scanner;

public class exercitii {
    public static void main (String args[]){
        //ex1
        //Scrieti un program care sa afișeze toate numerele pare din intervalul [0,n], unde n este un numar citit de la
        //tastatura.
        // The Scanner class is useful when reading values, as it has utility methods for most primitives.
        Scanner scanner;

        // It can be set to read from the System console.
        scanner = new Scanner(System.in);
        System.out.println("Read int for ex1: ");
        int n = scanner.nextInt();

        for(int i=0 ; i<=n ;i++)
            if(i%2==0)
            {
                System.out.println(i);
            }

        //ex2
        //Scrieți un program care sa compare doua numere a și b citite de la tastatura si sa afiseze numarul mai
        //mare.
        System.out.println("ex2");
        System.out.println("Read a:");
        int a = scanner.nextInt();
        System.out.println("Read b:");
        int b = scanner.nextInt();
        if(a>=b)
            System.out.println(a);
        else
            System.out.println(b);

        //ex3
        //Scrieți o metoda care sa calculeze factorialul unui numar n citit de la tastatura.

        System.out.println("Read nr for factorial(ex3)");
        int x=scanner.nextInt();
        int p=1;
        for(int i=1;i<=x;i++)
            p*=i;
        System.out.println(p);

        //ex4
        //Fiind dat un numar n, scrieti o metoda care insumeaza toti multiplii de 3 si 5 pana la n (inclusiv).

        System.out.println("Read nr for ex4");
        int y=scanner.nextInt();
        int s=0;
        for(int i =1;i<=y;i++)
            if(i%3==0 || i%5==0)
                s+=i;
        System.out.println(s);

        //ex5
        //Cititi de la tastatura n numere. Elementele citite vor fi organizate in doi vectori diferiti, in functie de
        //paritate (de ex: elementele pare in vectorul x, iar cele impare in vectorul y).

        System.out.println("Read n for ex5");
        int m = scanner.nextInt();
        int[] v1 = new int[m];
        int[] v2 = new int[m];
        int n_v1=0;
        int n_v2=0;
        for(int i=1;i<=m;i++)
        {
            int w=scanner.nextInt();
            if(w%2==0){
                n_v1++;
                v1[n_v1]=w;
            }
            else{
                n_v2++;
                v2[n_v2]=w;
            }
        }
        System.out.println("Elementele primului vector:");
        for(int i=1;i<=n_v1;i++)
            System.out.print(v1[i]+" ");
        System.out.println();
        System.out.println("Elementele celui de-al doilea vector:");
        for(int i=1;i<=n_v2;i++)
            System.out.print(v2[i]+" ");

        System.out.println();

        //ex6
        //Cititi de la tastatura n note, numere intregi, intr-un vector. Cand cititi valoarea -1 de la tastatura, citirea
        //notelor se opreste si programul afiseaza media acestora.

        System.out.println("Read number of grades:");
        int nr = scanner.nextInt();
        System.out.println("Read grades:");
        int g = scanner.nextInt();
        double nr_g = 1;
        double s_g=0;
        while(g!=-1 && nr!=0){
            s_g+=g;
            nr_g+=1;
            nr-=1;
            g = scanner.nextInt();
        }
        System.out.println("Media este :" + (s_g/nr_g));

        //ex7
        //Sa se afiseze al n-lea termen din seria Fibonacci, unde n este citit de la tastatura.
        System.out.println("Read n for Fibonacci");
        int n_fib = scanner.nextInt();
        int rez=0;
        if(n_fib==0)
            rez=0;
        else
        {
            if(n_fib==1 || n_fib==2)
                rez=1;
            else {
                int fib_1 = 0, fib_2 = 1, tmp = 0, i = 2;
                while (i <= n_fib) {
                    tmp = fib_1 + fib_2;
                    fib_1 = fib_2;
                    fib_2 = tmp;
                    i += 1;
                }
                rez = tmp;
            }
        }

        System.out.println("Al n-lea termen din sirul fibonacci este :" + rez);
    }
}
