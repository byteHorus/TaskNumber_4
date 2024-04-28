import java.util.Scanner;

public class ReadingData {
    //Класс получения и обработки вводимых значений
    public static void toGetData() throws Exception {
        Scanner src = new Scanner(System.in);
        // Ввод первого элемента
        String inputOne = src.next();
        int numberOne = 0;
        if (isNumeric(inputOne)) {
            numberOne = Integer.parseInt(inputOne);
        }
        // Ввод арифметической операции
        String arifmeticOperation = src.next();

        // Ввод второго элемента
        String inputTwo = src.next();
        int numberTwo = 0;
        if (isNumeric(inputTwo)) {
            numberTwo = Integer.parseInt(inputTwo);
        }
        // Переход к выполнению вычислений для Арабских символов
        if (isNumeric(inputTwo) && isNumeric(inputOne) && arifmeticOperation != null) {
            ArabicNumbersCalculation.computationsArabic(numberOne, arifmeticOperation, numberTwo);
        } else if (isRomanNumber(inputTwo) && isRomanNumber(inputOne)) {
            // Переход -> к выполнению вычислений для Римских символов
            RomCalculation.calculateRomanNumbers(inputOne,arifmeticOperation,inputTwo);
        }else{
            throw new Exception("Invalid numeral");
            // В случае если используются разные системы счислений
        }
    }
    // Метод для проверки, сможем ли мы входящее значение пребразовать в число
    public static boolean isNumeric(String stringNum) {
        try {
            int number = Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    //Метод проверки Римских символов в диапазоне от 1 до 10
    public static boolean isRomanNumber(String numberRom) {
        boolean logicResult = false;
        String[] array = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int a = 0; a < array.length; a++) {
            if ((!logicResult) && numberRom.equalsIgnoreCase(array[a])) {
                logicResult = true;
                break;
            }
            if (!logicResult) {
                logicResult = false;
            }
        }
        return logicResult;
    }
}