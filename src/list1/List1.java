/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list1;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class List1 {
    
    private static final HashMap<Integer,String> BASENUMBERS = new HashMap<Integer,String>()
        {
            {
                put(0,"zero");
                put(1,"");
                put(2,"dwa");
                put(3,"trzy");
                put(4,"cztery");
                put(5,"pięć");
                put(6,"sześć");
                put(7,"siedem");
                put(8,"osiem");
                put(9,"dziewięć");
                put(10,"dziesięć");
                put(11,"jedenaście");
                put(12,"dwanaście");
                put(13,"trzynaście");
                put(14,"czternaście");
                put(15,"piętnaście");
                put(16,"szesnaście");
                put(17,"siedemnaście");
                put(18,"osiemnaście");
                put(19,"dziewiętnaście");
            }
        };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int toDisplay;
        for (String arg : args) 
        {
            String output = "";
            try
            {
                toDisplay = Integer.parseInt(arg);
                if(toDisplay < 0)
                {
                    toDisplay = 0 - toDisplay;
                    output += "minus ";
                }
                output += getBillions(toDisplay);
                output += getMillions(toDisplay);
                output += getThousands(toDisplay);
                output += getHundreds(toDisplay);
            }
            catch(NumberFormatException e)
            {
                
            }
            System.out.println(output);
        }
        System.out.println("vollo illo");
    }
    
    private static String getBillions(int arg)
    {
        String ret;
        arg = arg/1000000000;
        switch (arg) {
            case 0:
                ret = "";
                break;
            case 1:
                ret = " miliard ";
                break;
            default:
                ret = getHundreds(arg);
                if(arg%10 < 5 && arg%10 > 1 && (arg < 10 || arg > 20)) ret += " miliardy ";
                else ret += " miliardów ";
                break;
        }
        return ret;
    }
    
    private static String getMillions(int arg)
    {
        String ret;
        arg = (arg%1000000000)/1000000;
        switch (arg) {
            case 0:
                ret = "";
                break;
            case 1:
                ret = " milion ";
                break;
            default:
                ret = getHundreds(arg);
                if(arg%10 < 5 && arg%10 > 1 && (arg < 10 || arg > 20)) ret += " miliony ";
                else ret += " milionów ";
                break;
        }
        return ret;
    }
    
    private static String getThousands(int arg)
    {
        String ret;
        arg = (arg%1000000)/1000;
        switch (arg) {
            case 0:
                ret = "";
                break;
            case 1:
                ret = " tysiąc ";
                break;
            default:
                ret = getHundreds(arg);
                if(arg%10 < 5 && arg%10 > 1 && (arg < 10 || arg > 20)) ret += " tysiące ";
                else ret += " tysięcy ";
                break;
        }
        return ret;
    }
    
    private static String getHundreds(int arg)
    {
        String ret = "";
        arg = arg%1000;
        if(arg >= 100)
        {
            Integer base = arg/100;
            if(base == 2) ret += "dwieście";
            else
            {
                ret += BASENUMBERS.get(base);
                if(base == 1) ret += "sto";
                else if(base < 5) ret += "sta";
                else ret += "set";
            }
        }
        ret += getTens(arg);
        return ret;
    }
    
    private static String getTens(int arg)
    {
        String ret = "";
        arg = arg%100;
        if(arg < 20)
        {
            ret += BASENUMBERS.get(arg);
        }
        else
        {
            int base = arg/10;
            if(base > 0)
            {
                 ret += BASENUMBERS.get(base);
                if(base == 2) ret += "dzieścia";
                else if(base < 5)
                {
                    ret = ret.substring(0,ret.length() - 1);
                    ret += "dzieści";
                }
                else ret += "dziesiąt";
            }
            base = arg%10;
            if(base > 0) ret += BASENUMBERS.get(base);
        }
        if("".equals(ret)) ret += BASENUMBERS.get(0);
        return ret;
    }
    
}
