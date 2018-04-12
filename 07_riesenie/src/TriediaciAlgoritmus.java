import java.io.*;
import java.util.Collections;
import java.util.Vector;

/** Tato trieda len obsahuje staticku metodu main(), kedze nepotrebujeme ziadne ine triedy/objekty */
public class TriediaciAlgoritmus {

       /** 
        * Metoda nekontroluje vynimky: ak nastanu, tak sa uzivatelovi vypise chyba 
        * a v nasom pripade nepotrebujeme zachranovat ziadne ine rozrobene procesy...
        * @param args program nevyuziva argumenty prikazoveho riadku
        */
       public static void main(String[] args) throws IOException
       {
               // na citanie textoveho suboru po riadkoch je najpraktickejsia tato kombinacia...
               BufferedReader f = new BufferedReader(new FileReader("vstup.txt"));

               // cisla zo suboru nacitame do vektora, ten sa lahko da striedit a nafukovat podla potreby
               Vector<Integer> v = new Vector<Integer>();

               do
               {
                       String ln = f.readLine();  // precitaj dalsi riadok
                       if (ln == null) break;     // na konci suboru readLine() vrati null
                       v.add(Integer.parseInt(ln)); // pridaj cislo do vektora
               } while (true);

               f.close();  // zatvor vstupny subor

               Collections.sort(v);  // utried vektor cisel v pamati

               // vytvor vystupny subor
               PrintStream g = new PrintStream("vystup.txt");
               for (Integer i : v)   // vypis cisla na standardny vystup a do suboru
               {
                       g.println(i);
                       System.out.println(i);
               }
               
               g.close();  // subor sa zatvori automaticky pri zruseni objektu g, 
                           // ale je slusne ho zavriet explicitne
       }
}