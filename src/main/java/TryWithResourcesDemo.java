import java.io.*;

public class TryWithResourcesDemo {

    public static void main(String[] args) {
        TryWithResourcesDemo demo = new TryWithResourcesDemo();
        String content = demo.readFile("src/main/resources/exeptions/source.txt");
        demo.writeFile("src/main/resources/exeptions/destination.txt", content);
    }

    public String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        return content.toString();
    }
    public void writeFile(String filePath, String content) {
        File destinationFile = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            bufferedWriter.write(content);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}