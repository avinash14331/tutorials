package com.learn.java.design_pattern.structural.facade;

public class Report {
    ReportHeader header;
    ReportFooter footer;
    ReportData body;
    public ReportHeader getHeader() {
        return header;
    }

    public void setHeader(ReportHeader header) {
        System.out.println("Setting Report Header");
        this.header = header;
    }

    public ReportFooter getFooter() {
        return footer;
    }

    public void setFooter(ReportFooter footer) {
        System.out.println("Setting Report Footer");
        this.footer = footer;
    }

    public ReportData getBody() {
        return body;
    }

    public void setBody(ReportData body) {
        System.out.println("Setting Report Body");
        this.body = body;
    }



}
