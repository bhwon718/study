package Chapter01;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class P008Main {

    public static void main(String[] args) {


        String str =  "a a a\t\n\r vvvv";

        System.out.println(str);

        String result =str.replaceAll("\\s","");
        System.out.println(result);
    }
}