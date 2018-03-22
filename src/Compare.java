import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Compare {


    public static double CompareDataPoints(DataPoints point1, DataPoints point2){
        int counter = 0;
        double distance = 0;
        boolean foundone = false;
        for (DataReading x: point1.list) {
            for (DataReading y: point2.list) {
                if(x.macAddress.equals(y.macAddress)){
                    System.out.println(x.macAddress + " " + x.SignalStrength + " " + y.macAddress + " " + y.SignalStrength);
                    double z = x.SignalStrength-y.SignalStrength;
                    foundone = true;
                    counter++;
                    distance+= z;
                }
            }
            if(!foundone){
                distance+= 99;
            }
            foundone = false;
        }
        System.out.println("counter " + distance);
        return distance;
    }
}
