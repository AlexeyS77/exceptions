import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionDemoTest {

    @Test
    public void testDivideByZero() {
        // Проверяем, что деление на ноль вызывает ArithmeticException
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                ExceptionDemo.divide(10, 0);
            }
        };

        Exception exception = assertThrows(ArithmeticException.class, executable);
        assertEquals("/ by zero", exception.getMessage());
    }

}
