package Week2.ThucHanh;

public class MyCollection {
    private int[] data;
    SortAlgorithm algorithm;

    public MyCollection() {
        this.data = null;
        this.algorithm = null;
    }

    public MyCollection(int[] data) {
        this.data = data;
        this.algorithm = null;
    }

    public MyCollection(int[] data, SortAlgorithm algorithm) {
        this.data = data;
        this.algorithm = algorithm;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void setAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public SortAlgorithm getAlgorithm() {
        return algorithm;
    }

    public int[] performAl() {
        return this.data = this.algorithm.sort(this.data);
    }

    public static void display(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void print() {
        for (int i : this.data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
