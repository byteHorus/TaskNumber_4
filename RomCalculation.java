
class RomCalculation {
    //Класс получения/ обработки и вычисления римских символов
    static int correctFirstPoma = 0;
    static int correctSecondPoma = 0;
    static int result = 0;
    static void calculateRomanNumbers(String inputOne,String arifmeticOperation,String inputTwo) throws Exception {
        //Основной метод по запуску парсинга и вычисления итогового значения римских символов
        searchFirstNumberPom(inputOne);
        searchSecondNumberPom(inputTwo);
        calculationPomNumber(correctFirstPoma,arifmeticOperation,correctSecondPoma);
        parseIntResultCalculating(result);

    }
    static int searchFirstNumberPom(String inputOne) throws Exception {
        //Парсим первое значение inputOne
        RomaNumberEnum[] romaNumberEnum = RomaNumberEnum.values();
        for(int a = 0; a < romaNumberEnum.length; a ++){
            if(romaNumberEnum[a].name().equalsIgnoreCase(inputOne)){
                correctFirstPoma = romaNumberEnum[a].ordinal() + 1;
            }
        }
        return correctFirstPoma;
    }
    static int searchSecondNumberPom(String inputTwo) throws Exception {
        //Парсим второе значение inputTwo
        RomaNumberEnum[] romaNumberEnum = RomaNumberEnum.values();
        for(int a = 0; a < romaNumberEnum.length; a ++){
            if(romaNumberEnum[a].name().equalsIgnoreCase(inputTwo)) {
                correctSecondPoma = romaNumberEnum[a].ordinal() + 1;
            }
        }
        return correctSecondPoma;
    }

    static int calculationPomNumber(int correctFirstPoma, String arifmeticOperation, int correctSecondPoma) throws Exception{
        //После того, как распарсили римские числа, получили арабские, производим арифметические операции с ними
        switch (arifmeticOperation){
            case "-":
                result = correctFirstPoma - correctSecondPoma;
                if (result <= 0){
                    throw new Exception("invalid operation, Roman numbers cannot be negative");
                }
                break;
            case "+":
                result = correctFirstPoma + correctSecondPoma;
                if (result <= 0){
                    throw new Exception("invalid operation, Roman numbers cannot be negative");
                }
                break;
            case "/":
                result = correctFirstPoma / correctSecondPoma;
                if (result <= 0){
                    throw new Exception("invalid operation, Roman numbers cannot be negative");
                }
                break;
            case "*":
                result = correctFirstPoma * correctSecondPoma;
                if (result <= 0){
                    throw new Exception("invalid operation, Roman numbers cannot be negative");
                }
                break;
        }
        return result;
    }
    static void parseIntResultCalculating(int result){
        //После выполнения арифметических действий, ищем результат в enum и показываем его
        String resultRomNumber;
        RomaNumberEnum [] romaNumberEnum = RomaNumberEnum.values();
        for (int a = 0; a < romaNumberEnum.length; a ++) {
            if(result == romaNumberEnum[a].ordinal() + 1){
                resultRomNumber = romaNumberEnum[a].name();
                System.out.println(resultRomNumber);
                break;
            }
        }
    }
}