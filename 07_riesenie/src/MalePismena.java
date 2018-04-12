import java.io.*;
import java.util.Collections;
import java.util.Vector;

/** Tato trieda len obsahuje staticku metodu main(), kedze nepotrebujeme ziadne ine triedy/objekty */
public class MalePismena {

       /** 
        * Metoda nekontroluje vynimky: ak nastanu, tak sa uzivatelovi vypise chyba 
        * a v nasom pripade nepotrebujeme zachranovat ziadne ine rozrobene procesy...
        * @param args program nevyuziva argumenty prikazoveho riadku
        */
       public static void main(String[] args) throws IOException
       {
               // na citanie textoveho suboru po riadkoch je najpraktickejsia tato kombinacia...
               BufferedReader f = new BufferedReader(new FileReader("PISMENA.TXT"));
               // vytvor vystupny subor
               PrintStream g = new PrintStream("KOLKO.TXT");
               
               do
               {
                       String ln = f.readLine();  // precitaj dalsi riadok
                       if (ln == null) break;     // na konci suboru readLine() vrati null
                       g.println(ln);			  // zapis riadok do vystupneho suboru
                       int count = 0;             // pocitadlo
                       for (int i = 0; i < ln.length(); i++)   // zrataj pocet malych pismen
                    	   if (Character.isLowerCase(ln.charAt(i))) count++;
                       g.println(count);
               } while (true);

               f.close();  // zatvor vstupny subor
               g.close();  // zatvor vystupny subor
       }
}


