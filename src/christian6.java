import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.LineNumberReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Scanner;

public class christian6 {

        public static void main (String args[]) throws Exception {

            System.out.println ("The amount of words in the file are:");
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream("src/exercise.txt")));
            BufferedReader br = new BufferedReader (reader);
            String line = br.readLine ();
            int count = 0;
            while (line != null) {
                String []parts = line.split(" ");
                for( String words : parts)
                {
                    count++;
                }
                line = br.readLine();
            }
            System.out.println(count);
        }
    }
