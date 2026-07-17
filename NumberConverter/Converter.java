package NumberConverter;

import java.util.Scanner;

public class Converter {
    private int sourceBase;
    private int targetBase;


    public Converter(){}

    public Converter(int sourceBase, int targetBase){
        setSourceBase(sourceBase);
        setTargetBase(targetBase);
    }

    public int getSourceBase(){
        return sourceBase;
    }

    public int getTargetBase(){
        return targetBase;
    }

    public void setSourceBase(int sourceBase){
        if(!spBase(sourceBase)){
            throw new IllegalArgumentException("Source base must be one of: 2, 10, 16");
        }
        this.sourceBase = sourceBase;
    }

    public void setTargetBase(int targetBase){
        if(!spBase(targetBase)){
            throw new IllegalArgumentException("Target base must be one of: 2, 10, 16");
        }
        this.targetBase = targetBase;
    }

    public boolean spBase(int base){
        return base == 2 || base == 10 || base == 16;
    }

// Convert
    public boolean isValidNumber(String input){
        for(int i = 0; i < input.length(); i++){
            int digit = Character.digit(input.charAt(i), sourceBase);
            if(digit == -1){
                return false;
            }
        }
        return true;
    }

    public String formatNumber(String number){
        if(number == null){
            return "";
        }
        return number.trim().toUpperCase();
    }

    public int toDecimal(String number){
        int result = 0;
        for(int i = 0; i < number.length(); i++){
            int digit = Character.digit(number.charAt(i), sourceBase);
            result = result * sourceBase + digit;
        }
        return result;
    }

    public String fromDecimal(int decimalValue){
        if(decimalValue == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while(decimalValue > 0){
            int digit = decimalValue % targetBase;
            if(digit <= 9){
                result.append(digit);
            }else{
                result.append((char) ('A' + digit - 10));
            }
            decimalValue = decimalValue / targetBase;
        }
        return result.reverse().toString();
    }

    public String convert(String number){
        number = formatNumber(number);
        if(number.length() == 0){
            System.out.println("Invalid Number");
            return "Invalid Number";
        }
        if(!isValidNumber(number)){
            System.out.println("Invalid Number for base " + sourceBase);
            return "Invalid Number";
        }
        int decimalValue = toDecimal(number);
        return fromDecimal(decimalValue);
    }

// Input
    public static boolean isInteger(String input){
        if(input.length() <= 0){
            return false;
        }
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) > '9' || input.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }

    public static int checkBase(Scanner sc, String mess){
        while(true){
            System.out.print(mess);
            String input = sc.nextLine().trim();
            if(!isInteger(input)){
                System.out.println("Please enter Integer!");
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    public static int readBase(Scanner sc, String mess){
        System.out.println();
        System.out.println(mess);
        System.out.println("1. Binary (base 2)");
        System.out.println("2. Decimal (base 10)");
        System.out.println("3. Hexadecimal (base 16)");
        int choice;
        do{
            choice = checkBase(sc, "Enter choice: ");
            if(choice > 3 || choice < 1){
                System.out.println("Choice must between (1, 3)!");
            }
        }while(choice > 3 || choice < 1);
        if(choice == 1){
            return 2;
        }else if(choice == 2){
            return 10;
        }else {
            return 16;
        }
    }

    public static Converter inputBase(Scanner sc){
        int sourceBase = readBase(sc, "Choose Source Base");
        int targetBase = readBase(sc, "Choose Target Base");
        
        return new Converter(sourceBase, targetBase);
    }

    public void display(Scanner sc){
        System.out.print("Enter number to convert: ");
        String number = sc.nextLine();

        String result = convert(number);
        System.out.println("Result: " + result);
    }
}
