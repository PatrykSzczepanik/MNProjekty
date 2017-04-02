package SinusH;

public class Szereg {
    public static void main(String []args) {
        String wynikString;
        String wynikString2;

/*
        //OBLICZANIE KAŻDEGO ELEMENTU ODDZIELNIE
        for (double i = 1; i<70; i+=2){
            SinusH.SinusHiperboliczny wynik = new SinusH.SinusHiperboliczny(168, i);
            wynik.wyliczajElementOddzielnie();
//            wynikString = String.valueOf(wynik.dodawajOdKonca());
//            wynikString = String.valueOf(wynik.dodawajOdPoczatku());
            wynikString = String.valueOf(wynik.bladWzgledny(Math.sinh(i), wynik.dodawajOdKonca()));

            System.out.println(wynikString.replace('.', ','));
        }
*/

/*        //OBLICZANIE WYKORZYSTUJAC BIBLIOTEKĘ
        for (double i = 710.30; i<=710.47; i+=0.01){
            wynikString = String.valueOf(Math.sinh(i));
            System.out.println(wynikString.replace('.', ','));
//            if (wynikString.equals("Infinity")) {
//                System.out.format("Maksymalny argument, dla ktorego mozna wyliczyc sinh funkcja biblioteczna, to %5.2f", i-0.01);
//                break;
//            }
        }*/


        //OBLICZANIE WZGLEDEM POPRZEDNIEGO ELEMENTU
        for (int i = 1; i<70; i+=2) {
            SinusHiperboliczny wynik = new SinusHiperboliczny(935, i);
            wynik.wyliczajElementWzgledemPoprzedniego();
//            wynikString = String.valueOf(wynik.dodawajOdKonca());
//            wynikString = String.valueOf(wynik.dodawajOdPoczatku());
            wynikString = String.valueOf(wynik.bladWzgledny(Math.sinh(i), wynik.dodawajOdKonca()));

            System.out.println(wynikString.replace('.', ','));
        }


/*
        //WYLICZ NAJKORZYSTNIEJSZE N
        int temp = 0;
        wynikString2 = "none";
        for (int i = 1; i < 1500; i+=2){        //liczba elementow = ceil(i/2)
            SinusH.SinusHiperboliczny wynik = new SinusH.SinusHiperboliczny(i, 710);
            wynik.wyliczajElementWzgledemPoprzedniego();
            wynikString = String.valueOf(wynik.dodawajOdKonca());
            if (wynikString.equals(wynikString2)){
                temp = i - 4;
                break;
            }
            wynikString2 = wynikString;
            System.out.println(i + " " + wynikString.replace('.', ','));
        }
        System.out.print("Maksymalna n: " + temp);
*/
    }
}
