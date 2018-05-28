package com.example.alex.myapplication;

/**
 * Created by Alex on 10/22/2017.
 */

//Molar Mass

import java.util.*;

public class MolarMass{
    public static String molarMass(String formula){
        //Variable Declaration
        Scanner myScanner = new Scanner(System.in);

        Analyze.analyze(formula);

        //Calculate Molar Mass
        double sum = 0;

        for(int i=0;i<Analyze.getElementsLength();i++){
            //Retrieves molar mass of element at index i in finalElements and multiplies it with the corresponding number at index i in finalNumbers to get mass
            double mass = TableElement.periodicTable.get(Analyze.getFinalElements(i)) * Analyze.getFinalNumbers(i);

            //Adds mass to sum
            sum += mass;
        }

        //Prints the molar mass

        return Double.toString(sum);

    }
}