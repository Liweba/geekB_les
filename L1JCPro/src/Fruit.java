public class Fruit {

    private float size;
    private int count;

    public Fruit( float size, int count) {
        this.size = size;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public float getSize() {
        return size;
    }

    public float getWeight(){
        return (count * size);
    }
}
