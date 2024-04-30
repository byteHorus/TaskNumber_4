package src;

class ArabicNumbersCalculation {
    static void computationsArabic(int numberOne, String arifmeticOperation, int numberTwo) throws Exception {
        //Основной метод расчета Арабских чисел
        if (numberOne <= 10 && numberTwo <= 10) {
            int result;
            switch (arifmeticOperation) {
                case "-":
                    result = numberOne - numberTwo;
                    System.out.print(result);
                    break;
                case "+":
                    result = numberOne + numberTwo;
                    System.out.print(result);
                    break;
                case "/":
                    result = numberOne / numberTwo;
                    System.out.print(result);
                    break;
                case "*":
                    result = numberOne * numberTwo;
                    System.out.print(result);
                    break;
                default:
                    throw new Exception("There was an error in the calculations");
            }
        } else {
            throw new Exception("Error, incorrect value, available number options: from 1 to 10");
        }
    }
}