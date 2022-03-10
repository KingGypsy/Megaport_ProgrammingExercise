package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.SortAlphabetically(main.OpenInputFile("InputFile.txt"));
    }

    //Read .txt file and add data to List
    public List<String> OpenInputFile(String fileName) throws Exception{
        File file = new File(fileName);
        List<String> inputList = new ArrayList<String>();
        if(file.exists()){
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(file));
            }catch (IOException ex) {
                throw new IOException(ex);
            }finally{
                String line;
                while ((line = br.readLine()) != null){
                    inputList.add(line);
                }
            }
            br.close();
            return inputList;
        }else{
            throw new IOException("File not found.");
        }
    }

    public List<String> SortAlphabetically (List<String> nameList) throws Exception{
        //sort list alphabetically
        java.util.Collections.sort(nameList);
        String outputFileName = "names-sorted.txt";

        //Create the output file
        CreateOutputFile(outputFileName);

        //Write sorted list to file
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFileName), "utf-8"))) {
            System.out.println();
            for (String string : nameList) {
                System.out.println(string);
                writer.write(string + "\n");
            }
        }
        return nameList;
    }


    public void CreateOutputFile (String outputFileName) {
        //Create an output file to output the sorted list
        try {
            File myObj = new File(outputFileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}