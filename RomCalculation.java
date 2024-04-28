
public class RomCalculation {
    static int correctFirstPoma = 0;
    static int correctSecondPoma = 0;
    static int result = 0;
    public static void calculateRomanNumbers(String inputOne,String arifmeticOperation,String inputTwo) throws Exception {
        searchFirstNumberPom(inputOne);
        searchSecondNumberPom(inputTwo);
        calculationPomNumber(correctFirstPoma,arifmeticOperation,correctSecondPoma);
        parseIntResultCalculating(result);

    }
    public static int searchFirstNumberPom(String inputOne) throws Exception {
        //Парсим первое значение строки
        RomaNumberEnum[] romaNumberEnum = RomaNumberEnum.values();
        for(int a = 0; a < romaNumberEnum.length; a ++){
            if(romaNumberEnum[a].name().equalsIgnoreCase(inputOne)){
                correctFirstPoma = romaNumberEnum[a].ordinal() + 1;
            }
        }
        return correctFirstPoma;
    }
    public static int searchSecondNumberPom(String inputTwo) throws Exception {
        //Парсим второе значение строки
        RomaNumberEnum[] romaNumberEnum = RomaNumberEnum.values();
        for(int a = 0; a < romaNumberEnum.length; a ++){
            if(romaNumberEnum[a].name().equalsIgnoreCase(inputTwo)) {
                correctSecondPoma = romaNumberEnum[a].ordinal() + 1;
            }
        }
        return correctSecondPoma;
    }

    public static int calculationPomNumber(int correctFirstPoma, String arifmeticOperation, int correctSecondPoma) throws Exception{
        //После того, как распарсили римские числа, производим арифметические операции с ними
        switch (arifmeticOperation){
            case "-":
                result = correctFirstPoma - correctSecondPoma;
                if (result <= 0){
                    throw new Exception("Invalid numeral");
                }
                break;
            case "+":
                result = correctFirstPoma + correctSecondPoma;
                if (result <= 0){
                    throw new Exception("Invalid numeral");
                }
                break;
            case "/":
                result = correctFirstPoma / correctSecondPoma;
                if (result <= 0){
                    throw new Exception("Invalid numeral");
                }
                break;
            case "*":
                result = correctFirstPoma * correctSecondPoma;
                if (result <= 0){
                    throw new Exception("Invalid numeral");
                }
                break;
        }
        return result;
    }
    public static void parseIntResultCalculating(int result){
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