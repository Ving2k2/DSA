package Week2.SPOJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class changeIntoParagraph {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/vinh/Desktop/Ký 1 Năm 3/Data Structures and Algorithms /Code/src/Week2/SPOJ/Inputs");
        Scanner scanner = new Scanner(file);
        StringBuilder s = new StringBuilder();
        String str;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            s.append(str).append(" ");
        }
        System.out.println(s
        );
    }
}
