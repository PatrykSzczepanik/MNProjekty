package SinusH;

public class SinusHiperboliczny {
    private double potegi;
    private double silnia;
    private double []skladniki;
    private double wynik;
    private int n;
    private double z;

    public SinusHiperboliczny(int n, double z){
        skladniki = new double[(int)(n/2)+1];
        potegi = z;
        silnia = 1;
        wynik = 0;
        this.n = n;
        this.z = z;
    }

    public void wyliczajElementOddzielnie(){
        int it=0;
        for (int i = 1; i <= this.n; i+=2){
            skladniki[it++] = potegi/silnia;
            potegi *= z;
            potegi *= z;
            silnia *= (i+1);
            silnia *= (i+2);
//            System.out.println("Silnia dla i = " + i + "\t\t= " + silnia);
        }
    }

    public void wyliczajElementWzgledemPoprzedniego(){
        int it=1;
        double kwadrat = z*z;
        int mianownik;
        skladniki[0] = z;
        for (int i = 1; i < this.n; i+=2){
            mianownik = (i+1)*(i+2);
            skladniki[it] = skladniki[it-1] * (kwadrat/mianownik);
            it++;
        }
    }

    public double dodawajOdPoczatku(){
        wynik = 0;
        for (int i =0; i<skladniki.length; i++){
            wynik += skladniki[i];
        }
        return wynik;
    }

    public double dodawajOdKonca(){
        wynik = 0;
        for (int i = skladniki.length; i>0; i--){
            wynik += skladniki[i-1];
        }
        return wynik;
    }

    public double bladWzgledny(double x, double x2){
        return Math.abs(x - x2)/x;
    }
    public double getResult(){
        return wynik;
    }
}
