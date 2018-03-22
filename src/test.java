import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class test {

    public static void main(String argv[]) throws IOException {
        test();
    }

    public static void test() throws IOException {
        //DataPoints pointA = addstuff(151,32,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsA.csv");
        DataPoints pointB = addstuff(83,169,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsBravo.csv");
        DataPoints pointC = addstuff(86,371,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsCharlie.csv");
        DataPoints pointD = addstuff(85,500,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsDelta.csv");
        //DataPoints pointE = addstuff(32,658,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsE.csv");
        //DataPoints pointF = addstuff(89,869,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsF.csv");
        //DataPoints pointG = addstuff(87,991,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsG.csv");
        //DataPoints pointH = addstuff(84,1155,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsH.csv");
        DataPoints pointI = addstuff(226,278,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsIndia.csv");
        //DataPoints pointJ = addstuff(228,676,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsJ.csv");
        //DataPoints pointK = addstuff(228,1041,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsK.csv");
        DataPoints pointL = addstuff(364,170,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsLima.csv");
        DataPoints pointM = addstuff(365,327,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsMike.csv");
        DataPoints pointN = addstuff(326,446,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsNovember.csv");
        //DataPoints pointO = addstuff(378,665,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsO.csv");


        //DataPoints pointS = addstuff(358,1164,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsS.csv");
        //DataPoints pointT = addstuff(297,1279,"C:/Users/Jens Andersen/Desktop/Data/ApStrengthsT.csv");

        List<DataPoints> testlist = new ArrayList<>();

        //testlist.add(pointA);
        testlist.add(pointB);
        testlist.add(pointC);
        testlist.add(pointD);
        //testlist.add(pointE);
        //testlist.add(pointF);
        //testlist.add(pointG);
        //testlist.add(pointH);
        testlist.add(pointI);
        //testlist.add(pointJ);
        //testlist.add(pointK);
        testlist.add(pointL);
        testlist.add(pointM);
        testlist.add(pointN);
        //testlist.add(pointO);


        //testlist.add(pointS);
        //testlist.add(pointT);

        DataPoints TestPoint = addstuff(0,0,"C:/Users/Jens Andersen/Desktop/ApStrengthsFisk.csv");

        double smallestDist = 9000;
        int xx = 0;
        int yy = 0;

        for (DataPoints x: testlist) {
            double z = Compare.CompareDataPoints(TestPoint, x);
            System.out.println("hej" + z);
            if(z < smallestDist){
                smallestDist = z;
                xx = x.x;
                yy = x.y;
            }

        }

        System.out.println("STORFEDTEST" + xx + " " + yy);

        //System.out.println(Compare.CompareDataPoints(pointA, pointB));
    }

    public static DataPoints addstuff(int x, int y, String Path) throws IOException {
        DataPoints pointX = new DataPoints(x,y);

        String fName = Path;
        String thisLine;
        final int maxBeacons = 500;

        FileInputStream fis = new FileInputStream(fName);
        DataInputStream myInput = new DataInputStream(fis);
        int counter = 0;
        while ((thisLine = myInput.readLine()) != null) {
            if(counter == 0){
                counter++;
                continue;
            }
            String[] toppings = {"64:f6:9d:21:59", "64:f6:9d:36:85", "64:f6:9d:48:ab", "64:f6:9d:37:a9", "64:f6:9d:43:20",
                    "64:f6:9d:43:1b", "64:f6:9d:36:82", "64:f6:9d:37:a5", "64:f6:9d:3a:94", "64:f6:9d:37:a7",
                    "64:f6:9d:3a:8a", "64:f6:9d:3a:8f", "64:f6:9d:37:9d"};

            //Optional<DataReading> result2 = toppings.stream().filter(obj -> obj.macAddress.equals(result.get())).findAny();

            String strar[] = thisLine.split(",");
            String MacAdress = strar[1].replaceAll("\\s+","");
            MacAdress = MacAdress.substring(0, MacAdress.length()-3);

            int SignalStrenght = Integer.valueOf(strar[3].replaceAll("\\s+",""));

            //System.out.println(MacAdress);
            //ystem.out.println(toppings[1]);


            //System.out.println(MacAdress);
            if(Arrays.asList(toppings).contains(MacAdress)){
                //System.out.println(toppings[1]);
                //System.out.println(MacAdress);
                pointX.AddDataReading(MacAdress, SignalStrenght);
            }


            //System.out.println("#" + strar[1].replace(strar[1].substring(strar[1].length()-3), "") + " " + strar[3]);



            if(counter == maxBeacons){
                break;
            }
            counter++;
        }
        //System.out.println("----------");

        //System.out.println(pointX.list.size());

        return pointX;
    }
}
