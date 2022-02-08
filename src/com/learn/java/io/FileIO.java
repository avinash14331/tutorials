package com.learn.java.io;


import java.io.*;

public class FileIO {

    public static void main(String[] args) {
        fileio();
    }
    static void byteIO(){
        try {
            // create a writer
            FileOutputStream fos = new FileOutputStream("output.dat");

            // write data to file
            fos.write("Hey, there!".getBytes());
            fos.write("\n".getBytes());
            fos.write("See you soon.".getBytes());

            // close the writer
            fos.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // create a reader
            FileInputStream fis = new FileInputStream("output.dat");

            // read until end of file
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }

            // close the reader
            fis.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    static void fileio(){
        try {
            // create a writer
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            // write text to file
            bw.write("Hey, there!");
            bw.newLine();
            bw.write("See you soon.");

            // close the writer
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            // create a reader
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));

            // read until end of file
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // close the reader
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
