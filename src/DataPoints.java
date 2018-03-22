import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataPoints{
    int x;
    int y;
    List<DataReading> list;

    DataPoints(int _x, int _y){
        x = _x;
        y =_y;
        list = new ArrayList<>();
    }

    public void AddDataReading(String MAC, int SS){
        //System.out.println("*"+MAC+"*");
        //System.out.println(list.size());

        Optional<DataReading> result = list.stream().filter(obj -> obj.macAddress.equals(MAC)).findAny();


        //System.out.println(result.isPresent());
        if(result.isPresent()){
            System.out.println("skip");
            return;
        }

        list.add(new DataReading(MAC,SS));
    }
}