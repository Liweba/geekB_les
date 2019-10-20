import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Box box1 = new Box<Fruit>(new Orange(12));
        Box box2 = new Box<Fruit>(new Orange(12));
        Box box3 = new Box<Fruit>(new Orange(13));
        Box box4 = new Box<Fruit>(new Apple(12));
        Box box5 = new Box<Fruit>(new Apple(12));
        Box box6 = new Box<Fruit>(new Apple(18));
        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box3));
        System.out.println(box4.compare(box5));
        System.out.println(box4.compare(box6));
        System.out.println(box2.compare(box6));


        Integer[] arrInteget = {1,2,3,4,5};
        String[] arrString = {"1","2","3","4","5"};
        changeOfPosition(arrInteget, 1, 2);
        changeOfPosition(arrString, 3, 4);
        arrToArrayList(arrInteget);
    }

    public static void changeOfPosition(Object[] arr, int p1, int p2){
        p1 = p1-1; p2 = p2-1;
        Object saveP1 = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = saveP1;
        System.out.println(Arrays.toString(arr));
    }
    public static ArrayList arrToArrayList(Object[] arr){
        ArrayList arrList = new ArrayList();
        arrList.addAll(Arrays.asList(arr));
        System.out.println(arrList);
        return arrList;
    }
}
