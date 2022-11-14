package com.bridgelabz;

public class EmployeeWage {
    static final int fullTime = 1;
    static final int partTime = 2;

    static void calculateWage(String company, int wagePerHr, int daysPerMonth, int workHrPerMonth) {

        int empHrs;
        int totalHours = 0;
        int dailyWage;
        int day = 0;
        int totalWage = 0;

        while ((totalHours < workHrPerMonth) && (day < daysPerMonth)) {

            int attendance = (int) (Math.floor(Math.random() * 10)) % 3;

            switch (attendance) {
                case fullTime:
                    empHrs = 8;
                    break;
                case partTime:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
                    break;
            }
            totalHours = totalHours + empHrs;
            dailyWage = wagePerHr * empHrs;
            totalWage = totalWage + dailyWage;
            day++;
            System.out.println("Day " + day + " Emp work hour " + empHrs + " wage is " + dailyWage);
        }
        System.out.println("Total work hours is: " + totalHours);
        System.out.println("Total work days are: " + day);
        System.out.println("Total Wage of company " + company + " is " + totalWage);
    }

    public static void main(String[] args) {
        calculateWage("Bajaj", 50, 20, 100);
        System.out.println("---------------------------------");
        calculateWage("HeroHonda", 60, 28, 90);
        System.out.println("---------------------------------");
        calculateWage("Yamaha", 80, 30, 80);
    }
}
