/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_data_loader.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiran
 */
public class FileHelper {

    
    
    public static List<String> readline(String filename) throws FileNotFoundException, IOException{
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String line="";
        List<String> lines=new ArrayList<>();
        
        while((line=reader.readLine())!=null){
            lines.add(line);    
        }
        reader.close();
        return lines;
}
    
}
