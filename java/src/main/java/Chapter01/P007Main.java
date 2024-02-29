package Chapter01;

import lombok.extern.java.Log;

public class P007Main {


    private static final String TO_INT = "453";
    private static final String TO_LONG = "451231231243";
    private static final String TO_FLOAT = "453.213F";
    private static final String TO_DOUBLE = "453.123123";

    public static void main(String[] args) {
        int toInt = Integer.parseInt(TO_INT);
        long toLong = Long.parseLong(TO_LONG);
        float toFloat = Float.parseFloat(TO_FLOAT);
        double toDouble = Double.parseDouble(TO_DOUBLE);


        try {
            Integer.valueOf("112wd");
        }catch (NumberFormatException nfe){
            System.err.println(nfe);
        }


    }

}
