public class ExceptionDemo {
    public static void main(String[] args) {
        //ArithmeticException
        try {
            int result = divide(10, 0); // Деление на ноль
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль! " + e.getMessage());
        } finally {
            System.out.println("Завершение выполнения блока try-catch.");
        }

        //ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Элемент массива: " + numbers[5]); // Выход за пределы массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Индекс выходит за пределы массива! " + e.getMessage());
        } finally {
            System.out.println("Завершение выполнения блока try-catch.");
        }
    }

    // Метод для деления
    public static int divide(int a, int b) {
        return a / b; // Здесь может возникнуть ArithmeticException
    }
}
