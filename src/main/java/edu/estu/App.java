package edu.estu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {


    private static void processSingleFile(Path path) {

        final String tag = path.getParent().getFileName().toString();

        KP01 kp01 = KP01.fromFile(path);

        IKS greedy = kp01.greedy();

        long greedyScore = greedy.totalValue();

        IKS random = kp01.random();

        System.out.printf("%s\t%s\t%s\n", tag, greedy.toString(), random.toString());

        //  System.out.printf("%s\t%d\t%d\n", tag, greedy.toString(), random.totalValue());

    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java -jar target/KP01.jar problemInstances/*/test.in");
            System.exit(1);
        }


        for (String testFilePath : args) {

            final Path path = Paths.get(testFilePath);

            if (Files.exists(path) && Files.isRegularFile(path)) {
                processSingleFile(path);
            } else
                System.err.println("cannot read/find file: " + testFilePath);

        }
    }
}
