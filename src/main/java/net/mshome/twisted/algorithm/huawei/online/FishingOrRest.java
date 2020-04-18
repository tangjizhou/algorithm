package net.mshome.twisted.algorithm.huawei.online;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * 小明从1990-01-01开始，三天打鱼连天晒网，输入一个日期，求当天小明是在打鱼还是晒网
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/18
 */
public class FishingOrRest {


    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner in = new Scanner(System.in);
        Date currentDate = null;
        Date beginDate = null;
        while (in.hasNext()) {
            String dateStr = in.nextLine();
            try {
                // simple validate ...
                LocalDate.parse(dateStr);
                beginDate = dateFormat.parse("1990-01-01");
                currentDate = dateFormat.parse(dateStr);
            } catch (Exception e) {
                System.out.println("Invalid input");
                continue;
            }

            long beginDateTime = beginDate.getTime();
            long currentDateTime = currentDate.getTime();
            long intervalMills = currentDateTime - beginDateTime;

            // validate range
            if (intervalMills < 0) {
                System.out.println("Invalid input");
                continue;
            }

            // calc result
            long intervalDays = intervalMills / (60 * 1000 * 60 * 24);
            if (intervalDays % 5 < 3) {
                System.out.println("He is working");
            } else {
                System.out.println("He is having a rest");
            }
        }
    }


}
