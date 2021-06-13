package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subor {

    private List<String> readFile(){
        List<String> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("source/subor.txt"));
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                String line = scanner.nextLine();
                Pattern p = Pattern.compile("([0-3]{1}[0-9]{1}[.][0-3]{1}[0-9]{1}[.][2][0-9]{1}[0-9]{1}[0-9]{1}[ ]{1}[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}[ ]{1}[1-9]?[0-9]{1})");//. represents single character
                Matcher m = p.matcher(line);
                boolean b = m.matches();
                if(b){
                    list.add(line);
                }
                System.out.println(b);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Data> allData() throws ParseException {
        List<String> list = readFile();
        List<Data> list2 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            String[] pole = list.get(i).split(" ", 3);
            String datum = pole[0];
            String cas = pole[1];
            String teplota = pole[2];
            String upravenyDatum = "";
            //dame pomlcky namiesto bodiek
            for(int j = 0; j < datum.length(); j++){
                if(datum.charAt(j) == '.'){
                    upravenyDatum += '-';
                }else{
                    upravenyDatum += datum.charAt(j);
                }
            }
            SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date date1=formatter1.parse(upravenyDatum + " " + cas);

            Data data = new Data(date1, Integer.parseInt(teplota));
            list2.add(data);
        }
        return list2;
    }


}
