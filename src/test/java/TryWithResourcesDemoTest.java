import org.junit.jupiter.api.*;


import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


public class TryWithResourcesDemoTest {

    private TryWithResourcesDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new TryWithResourcesDemo();
    }

    @Test
    public void testReadFile_Success() throws IOException {
        // Создаем временный файл для теста
        File tempFile = File.createTempFile("test", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Hello, World!");
        }

        // Читаем файл
        String content = demo.readFile(tempFile.getAbsolutePath());

        // Проверяем, что содержимое прочитано правильно
        assertEquals("Hello, World!" + System.lineSeparator(), content);

        // Удаляем временный файл
        tempFile.delete();
    }

    @Test
    public void testWriteFile_Success() throws IOException {
        // Создаем временный файл для записи
        File tempFile = File.createTempFile("testWrite", ".txt");

        // Записываем в файл
        demo.writeFile(tempFile.getAbsolutePath(), "Hello, World!");

        // Читаем содержимое файла
        String content = demo.readFile(tempFile.getAbsolutePath());

        // Проверяем, что содержимое записано правильно
        assertEquals("Hello, World!" + System.lineSeparator(), content);

        // Удаляем временный файл
        tempFile.delete();
    }

    @Test
    public void testReadFile_FileNotFound() {
        String content = demo.readFile("non_existent_file.txt");
        assertEquals("", content); // Ожидаем пустую строку при ошибке
    }

    @Test
    public void testWriteFile_FileNotFound() {
        // Пытаемся записать в файл, на который нет прав доступа или который не существует
        assertDoesNotThrow(() -> demo.writeFile("/protected/path/destination.txt", "Hello, World!"));
    }
}
