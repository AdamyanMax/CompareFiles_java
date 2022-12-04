import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareTextFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\MAX\\IdeaProjects\\FileComparison\\file1"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\MAX\\IdeaProjects\\FileComparison\\file2"));

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            // General cases, when files can't be equal
            if (line1 == null || line2 == null) {
                areEqual = false;
                break;
            } else if (!line1.equalsIgnoreCase(line2)) {
                areEqual = false;
                break;
            }

            line1 = br1.readLine();
            line2 = br2.readLine();

            lineNum++;
        }

        if (areEqual) {
            System.out.println("Two files have same content.");
        } else {
            System.out.println("Two files have different content. Difference found at line " + lineNum);
            System.out.println("File1 has " + "'" + line1 + "'" + " and File2 has "+ "'" + line2 + "'" + " at line " + lineNum);
        }

        br1.close();
        br2.close();
    }
}