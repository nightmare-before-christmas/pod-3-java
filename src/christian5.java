import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.LineNumberReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class christian5 {

    public static void main(String args[]){
        BufferedReader br = null;
        String strLine = "";
        try {
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream("src/exercise.txt")));
            while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= 5){
                System.out.println(strLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }
}