package com.ai.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.spi.CalendarDataProvider;

@Controller
public class IndexController {

    @RequestMapping("/sos")
    @ResponseBody
    public Integer get(@RequestParam("month") Integer month) {
        return month;
    }

    @GetMapping("/calender")
    public String hello(Model model) {
        Calendar calendar = Calendar.getInstance();
calendar.set(2020,Calendar.APRIL,01);
int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
System.out.println(dayOfWeek);
        List<List> month = new ArrayList<List>();
        List<Integer> week = new ArrayList<Integer>();
        for(int j=1;j <= dayOfWeek-1;j++){
            week.add(0);
        }
        for (int i = 1; i <= 31; i++) {
            week.add(i);
            if (i % 7 == 0 + dayOfWeek) {
                month.add(new ArrayList(week));
                week.clear();
            }
        }
        month.add(new ArrayList(week));
        model.addAttribute("month", month);
        return "calender";
    }



    @RequestMapping("/text1")
    @ResponseBody
    public String text1() {
        return "HELLO WORLD!";

    }

}
