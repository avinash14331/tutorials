package com.learn.java.design_pattern.structural.facade;

public class ReportWriter {
    public void writeHtmlReport(Report report, String location){
        System.out.println("Writing HTML report");
    }
    public void writePDFReport(Report report, String location){
        System.out.println("Writing PDF report");
    }
}
