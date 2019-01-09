package zouzou.algorithm.exotic.dictionary;

public class PrefixTree extends PrefixTreeNode {
    public PrefixTree() {
        super(Character.MIN_VALUE);
    }

    @Override
    public void displaySubWorld(String prefix) {
        throw new UnsupportedOperationException();
    }

    public void displayAllWorld() {
        if(getNodes().isEmpty()) {
            System.out.println();
        }
        else {
            getNodes().forEach(n -> n.displaySubWorld(""));
        }
    }
}
