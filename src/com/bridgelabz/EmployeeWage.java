package com.bridgelabz;

public class EmployeeWage {

    public final int fullTime = 1;
    public final int partTime = 2;

    String company;
    int wagePerHr;
    int daysPerMonth;
    int workHrPerMonth;
    int totalWage;

    public EmployeeWage(String company, int wagePerHr, int daysPerMonth, int workHrPerMonth) {
        this.company = company;
        this.wagePerHr = wagePerHr;
        this.daysPerMonth = daysPerMonth;
        this.workHrPerMonth = workHrPerMonth;
    }

    @Override
    public String toString() {
        return "Total employee wage for " + company + " is " + totalWage;
    }

    void calculateWage() {

        int empHrs;
        int totalHours = 0;
        int dailyWage;
        int day = 0;

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
        }
        System.out.println("Total work hours is: " + totalHours);
        System.out.println("Total work days are: " + day);
    }

    public static void main(String[] args) {

        EmployeeWage Bajaj = new EmployeeWage("Bajaj", 50, 20, 100);
        EmployeeWage HeroHonda = new EmployeeWage("HeroHonda", 60, 28, 90);
        EmployeeWage Yamaha = new EmployeeWage("Yamaha", 80, 30, 80);
        Bajaj.calculateWage();
        System.out.println(Bajaj);
        HeroHonda.calculateWage();
        System.out.println(HeroHonda);
        Yamaha.calculateWage();
        System.out.println(Yamaha);
    }
}