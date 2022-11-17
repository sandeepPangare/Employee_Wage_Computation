package com.bridgelabz;

import java.util.Arrays;
import java.util.Scanner;

public class EmpWageBuilderArray {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWagesArray;

    public EmpWageBuilderArray(){
        companyEmpWagesArray = new CompanyEmpWage[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){
        companyEmpWagesArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        numOfCompany++;
    }
    private void computeEmpWage(){
        for (int i=0; i<numOfCompany; i++){
            companyEmpWagesArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWagesArray[i]));
            System.out.println(companyEmpWagesArray[i]);
        }
    }
    private int computeEmpWage(CompanyEmpWage companyEmpWage){
        //variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        //Computation
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck){
                case IS_PART_TIME:
                        empHrs=4;
                        break;
                case IS_FULL_TIME:
                    empHrs=8;
                    break;
                default:
                    empHrs=0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }
        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    public static void main(String[] args) {
        EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
        empWageBuilder.addCompanyEmpWage("DMart",20,5,24);
        empWageBuilder.addCompanyEmpWage("Reliance",10, 24, 200);
        empWageBuilder.computeEmpWage();
    }
}
