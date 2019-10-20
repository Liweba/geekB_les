
public class Box<T extends Fruit> {
    private String nameFruit;
    private float size;
    private int count;

    public Box(T obj) {
        this.nameFruit = obj.getClass().getName();
        this.size = obj.getWeight();
        this.count = obj.getCount();
    }

    public boolean compare(Box obj){
        valide(obj);
        Boolean status = (size == obj.size) ? true : false;
        return status;
    }
    public void valide(Box obj){
         if(nameFruit == obj.nameFruit) {
             System.out.println("Одинаковые фрукты");
         }else{
             System.out.println("Разные фрукты");
         };
    }
}
