package com.iashandyman.calculator.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator {

    public static Long horasCalculadas(Date startDate, Date endDate) throws ParseException {

        long diffHours = 1;
        long difference = endDate.getTime() - startDate.getTime();
        if (difference >= 0)
        {
            diffHours = difference / (60 * 60 * 1000);
        }
        return diffHours;
    }


}
