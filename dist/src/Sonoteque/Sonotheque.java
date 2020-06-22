package Sonoteque;


import Code.Son;
import Code.note;

public class Sonotheque {

    String Path =System.getProperty("user.dir");
    Son son;
    public note Note;
    private final String newPath = "\\src\\Sonoteque\\";
   
    public int length;
    public int frequence;
    
    public Sonotheque(String name) {
        this.son = new Son(Path+newPath, name);
        this.length = son.donnees().length;
        this.frequence = son.frequence();
        System.out.println("(P)Ruta:"+Path+newPath+name);
        switch (name)
        {
            case "A0.wav":
                Note=new note("LA",27.5,1);
                break;
            case "A1.wav":         
                 Note=new note("LA",55,13);
                 break;
            case "A2.wav":
                Note=new note("LA",110,25);
                break;
            case "A3.wav":
                Note=new note("LA",220,37);
                break;
            case "A4.wav":
                Note=new note("LA",440,49);
                break;
            case "A5.wav":
                Note=new note("LA",880,61);
                break;
            case "A6.wav":
                Note=new note("LA",1760,73);
                break;
            case "A7.wav":
                Note=new note("LA",35.20,85);
                break;
            case "B0.wav":
                Note=new note("SI",30.8677,3);
                break;
            case "B1.wav":
                 Note=new note("SI",61.7354,15);
                 break;
            case "B2.wav":
                 Note=new note("SI",123.471,27);
                break;
            case "B3.wav":
                 Note=new note("SI",246.942,39);
                break;
            case "B4.wav":
                 Note=new note("SI",494.883,51);
                break;
            case "B5.wav":
                 Note=new note("SI",987.767,63);
                break;
            case "B6.wav":
                 Note=new note("SI",1975.53,75);
                break;
            case "B7.wav":
                 Note=new note("SI",3951.07,87);
                break;
            case "C1.wav":
                 Note=new note("DO",32.7032,4);
                break;
            case "C2.wav":
                 Note=new note("DO",65.4064,16);
                break;
            case "C3.wav":
                 Note=new note("DO",130.813,28);
                break;
            case "C4.wav":
                 Note=new note("DO",261.626,40);
                break;
            case "C5.wav":
                 Note=new note("DO",523.251,52);
                break;
            case "C6.wav":
                Note=new note("DO",1046.5,64);
                break;
            case "C7.wav":
                Note=new note("DO",2093,76);
                break;
            case "C8.wav":
                Note=new note("DO",4186.01,88);
                break;
            case "D1.wav":
                Note=new note("RE",36.7081,6);
                break;
            case "D2.wav":
                Note=new note("RE",73.4162,18);
                break;
            case "D3.wav":
                Note=new note("RE",146.832,30);
                break;
            case "D4.wav":
                Note=new note("RE",293.665,42);
                break;
            case "D5.wav":
                Note=new note("RE",587.33,54);
                break;
            case "D6.wav":
                Note=new note("RE",1174.66,66);
                break;
            case "D7.wav":
                Note=new note("RE",2349.32,78);
                break;
            case "E1.wav":
                Note=new note("MI",41.2035,8);
                break;
            case"E2.wav":
                Note=new note("MI",82.4069,20);
                break;
            case "E3.wav":
                Note=new note("MI",164.814,32);
                break;
            case "E4.wav":
                  Note=new note("MI",329.628,44);
                break;
            case "E5.wav":
                  Note=new note("MI",659.255,56);
                break;
            case "E6.wav":
                  Note=new note("MI",1318.51,68);
                break;
            case "E7.wav":
                  Note=new note("MI",2637.02,80);
                break;
            case "F1.wav":
                  Note=new note("FA",43,9);
                break;
            case "F2.wav":
                Note=new note("FA",87.3071,21);
                break;
            case "F3.wav":
                Note=new note("FA",174.614,33);
                break;
            case "F4.wav":
                Note=new note("FA",349.228,45);
                break;
            case "F5.wav":
                Note=new note("FA",698.456,57);
                break;
            case "F6.wav":
                Note=new note("FA",1396.91,69);
                break;
            case "F7.wav":
                Note=new note("FA",2793,81);
                break;
            case "G1.wav":
                Note=new note("SOL",48.9995,11);
                break;
            case "G2.wav":
                Note=new note("SOL",97,23);
                break;
            case "G3.wav":
                Note=new note("SOL",195.998,35);
                break;
            case "G4.wav":
                Note=new note("SOL",391.995,47);
                break;
            case "G5.wav":
                Note=new note("SOL",783.991,59);
                break;
            case "G6.wav":
                Note=new note("SOL",1567.98,71);
                break;
            case "G7.wav":
                Note=new note("SOL",3135.96,83);
                break;
        }
    }
    
    
 }
