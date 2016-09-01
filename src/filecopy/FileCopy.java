/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abcd
 */
public class FileCopy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String srcFile = "srcFile.txt";
        String dstFile = "dstFile.txt";
        File src = new File(srcFile);
        File dst = new File(dstFile);
// try opening the source and destination file
// with FileReader and FileWriter
        try (BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream(dst));) {

            int ch = 0;
            // while there are characters to fetch, read the characters from
            // source stream and write them to the destination stream
            while ((ch = inputFile.read()) != -1) {
                // ch is of type int - convert it back to char before
                // writing it
                System.out.print((char) ch);
                outputFile.write((byte) ch);
            }
            // no need to call flush explicitly for outputFile - the close()
            // method will first call flush before closing the outputFile stream
        } catch (FileNotFoundException fnfe) {
            // the passed file is not found ...
            System.err.println("Cannot open the file " + fnfe.getMessage());
        } catch (IOException ioe) {
            // some IO error occurred when reading the file ...
            System.err.printf("Error when processing file; exiting ... ");
        }
// try-with-resources will automatically release FileReader object
    }
}
