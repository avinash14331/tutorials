package com.learn.java.multithreading.defog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {
    public static void main(String[] args) {

    }
    public String birthDate(int userId){
        Date date = new Date();
        final SimpleDateFormat formatter = ThreadFormatter.dateFormat.get();
        return formatter.format(date);
    }
}
class ThreadFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() ->  new SimpleDateFormat("yyyy-MM-dd"));
//    public static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        public SimpleDateFormat initialValue() {
//            return  new SimpleDateFormat("yyyy-MM-dd");
//        }
//        @Override
//        public SimpleDateFormat get(){
//            return super.get();
//        }
//    };
}
