import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        DecorableTree christmasTree = new ChristmasTree();
        DecorableTree decoratedTree = new GurlandDecoratedTree(new BulbDecoratedTree(new CandyDecoratedTree(christmasTree)));

        decoratedTree.display();
        //christmasTree.display();
    }
}
interface DecorableTree {
    List<List<String>> getTree();
    void display();
}
class ChristmasTree implements DecorableTree {
    private List<List<String>> tree;
    private int size;
    public ChristmasTree() { this.size = 10; this.tree = getTree(); }
    public List<List<String>> getTree() {
        List<List<String>> tree = new ArrayList<>();
        List<String> row;
        for (int i = 0; i < size; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < size * 2; j++) {
                if (j == (size - i)) row.add("<");
                if (j == (size + i)) row.add(">");
                row.add(" ");
            }
            tree.add(Collections.unmodifiableList(row));
        }
        for (int i = 0; i < 3; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < size * 2; j++) {
                if (j == size - 2) row.add("|");
                if (j == size + 2) row.add("|");
                row.add(" ");
            }
            tree.add(Collections.unmodifiableList(row));
        }
        return Collections.unmodifiableList(tree);
    }
    public void display() {
        for (int i = 0; i < tree.size(); i++) {
            for (int j = 0; j < tree.get(i).size(); j++) {
                System.out.print(tree.get(i).get(j));
            }
            System.out.println();
        }
    }
}

abstract class DecoratedTree implements DecorableTree {
    private DecorableTree originalTree;
    private int decoratedRow;

    public DecoratedTree(DecorableTree originalTree, int decoratedRow){
        this.originalTree = originalTree;
        this.decoratedRow = decoratedRow;
    }

    @Override
    public List<List<String>> getTree() {
        List<List<String>> tree = originalTree.getTree();
        List<List<String>> decoratedTree = new ArrayList<>(tree);
        List<String> decorableRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = decorableRow.indexOf("<");
        int right = decorableRow.indexOf(">");

        for(int i = left+1; i < right; i++){
            decorableRow.set(i, getDecorShape());
        }

        decoratedTree.set(decoratedRow, decorableRow);
        return decoratedTree;
    }

    protected abstract String getDecorShape();

    @Override
    public void display() {
        List<List<String>> tree = getTree();
        for (List<String> row: tree){
            for(String cell : row){
                System.out.print(cell);
            }
            System.out.println();
        }
     }
}

class CandyDecoratedTree extends DecoratedTree implements DecorableTree{

    private static int decorRow = 3;

    public CandyDecoratedTree(DecorableTree tree){
        super(tree, decorRow);
    }

    @Override
    protected String getDecorShape() {
        return "C";
    }
}

class BulbDecoratedTree extends DecoratedTree implements DecorableTree {

    private static int decorRow = 5;

    public BulbDecoratedTree(DecorableTree candyDecoratedTree){
        super(candyDecoratedTree, decorRow);
    }

    @Override
    protected String getDecorShape() {
        return "B";
    }
}

class GurlandDecoratedTree extends DecoratedTree implements DecorableTree{

    private static int decoratedRow = 8;

    public GurlandDecoratedTree(DecorableTree tree){
        super(tree, decoratedRow);
    }

    @Override
    protected String getDecorShape() {
        return "G";
    }
}