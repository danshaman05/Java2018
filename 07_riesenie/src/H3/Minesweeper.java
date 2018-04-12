import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Minesweeper {


    public static void main(String[] args) {
        char [][] pole;
        List<String> lst = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(new File("minesweeper.in")));
            String line;
            while ((line = br.readLine()) != null){
                lst.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(lst.size());
        System.out.println(lst.get(0).length());

        pole = new char[lst.size()][lst.get(0).length()];
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(0).length(); j++) {
                if (lst.get(i).charAt(j) == '.'){
                    pole[i][j] = 'B';
                }else {
                    pole[i][j] = '.';
                }
            }
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(
                    new FileWriter(new File("minesweeper.out")));

            for (int i = 0; i < lst.size(); i++) {
                for (int j = 0; j < lst.get(0).length(); j++) {
                    bw.write(pole[i][j]);
                }
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
