package src;

import java.util.Scanner;

class ReadingData {
    //Класс получения и обработки вводимых значений
    static void toGetData() throws Exception {
        Scanner src = new Scanner(System.in);
        // Получение всей строки данных
        String inputLine = src.nextLine();

        // Разделение строки на элементы по пробелам
        String[] inputs = inputLine.split("\\s+");

        //Подсчитать количество элементов после удаления пробелов
        if(inputs.length > 3){
            throw new Exception("Error, you entered incorrect data");
        }
        // Получение первого элемента
        String inputOne = inputs[0];
        boolean atemptOne = false;
        int numberOne = 0;
        if (isNumeric(inputOne)) {
            numberOne = Integer.parseInt(inputOne);
            atemptOne = true;
        } else if (isRomanNumber(inputOne)) {
            atemptOne = true;
        } else {
            throw new Exception("Invalid input: Expected three elements (operand1 operator operand2)");
        }
        // Получение арифметической операции
        String arifmeticOperation = inputs[1];
        boolean resultArifmetic = false;
        switch (arifmeticOperation){
                case "-":
                    resultArifmetic = true;
                    break;
                case "+":
                    resultArifmetic = true;
                    break;
                case "/":
                    resultArifmetic = true;
                    break;
                case "*":
                    resultArifmetic = true;
                    break;
                default:
                    throw new Exception("Error in second statement");
            }

        // Получение второго элемента
        String inputTwo = inputs[2];
        boolean atemptTwo = false;
        int numberTwo = 0;
        if (isNumeric(inputTwo)) {
            numberTwo = Integer.parseInt(inputTwo);
            atemptTwo = true;
        } else if (isRomanNumber(inputTwo)) {
            atemptTwo = true;
        }else{
            throw new Exception("Invalid input: Expected three elements (operand1 operator operand2)");
        }
        // Переход -> к выполнению вычислений для Арабских символов
        if (isNumeric(inputTwo) && isNumeric(inputOne) && arifmeticOperation != null) {
            ArabicNumbersCalculation.computationsArabic(numberOne, arifmeticOperation, numberTwo);
        } else if (isRomanNumber(inputTwo) && isRomanNumber(inputOne)) {
        // Переход -> к выполнению вычислений для Римских символов
            RomCalculation.calculateRomanNumbers(inputOne,arifmeticOperation,inputTwo);
        }else{
            throw new Exception("Different number systems are used");
            // В случае если используются разные системы счислений
        }
    }
    // Метод для проверки, сможем ли мы входящее значение пребразовать в число
    static boolean isNumeric(String stringNum) {
        try {
            int number = Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    //Метод проверки Римских символов в диапазоне от 1 до 10
    static boolean isRomanNumber(String numberRom) {
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