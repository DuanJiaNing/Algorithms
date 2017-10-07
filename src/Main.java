import data.BinaryTree;
import util.Utils;

public class Main {

    public static void main(String[] args) {

        Integer[] vs = {1, 2, 3, 4, 5};
        BinaryTree<Integer> tree = new BinaryTree<>(vs);
        for (Integer v : tree) {
            Utils.P.accept(v + ".");
        }
    }


}