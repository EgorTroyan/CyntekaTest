package matcher;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу с данными:");
        File file = new File(scanner.nextLine());
        scanner.close();

        String[] in1;
        String[] in2;
        String[] out;

        try {
            ReaderInputFileWithData readerInputFileWithData = new ReaderInputFileWithData(file);
            in1 = readerInputFileWithData.getFirstPartData();
            in2 = readerInputFileWithData.getSecondPartData();
            Matcher matcher = new Matcher();
            out = matcher.getMatches(in1, in2);
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("Указан неверный путь к файлу или файл не существует");
            return;
        } catch (Exception exception){
            System.out.println("Данные во входном файле не соответствуют формату");
            return;
        }

        String pathOut = file.getParent() + "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut))){
            for (String s : out) {
                writer.write(s);
                writer.write("\n");
            }
            System.out.println("Результат записан в файл:\n " + pathOut);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
