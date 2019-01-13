package zouzou.algorithm.exotic.maxxor;

public class NumPrefixTree extends NumPrefixTreeNode {
    private static final int BIGGER_BIT = Integer.SIZE - 1;

    protected void insert(int input) {
        int bitCurrentPosition = BIGGER_BIT;

        int indexNode = getCorrespondingIndexNode(input, bitCurrentPosition);
        if(getNodes()[indexNode] == null) {
            getNodes()[indexNode] = new NumPrefixTreeNode();
        }
        getNodes()[indexNode].insert(input, bitCurrentPosition - 1);
    }

    protected boolean contains(int input) {
        int bitCurrentPosition = BIGGER_BIT;
        int indexNode = getCorrespondingIndexNode(input, bitCurrentPosition);
        return getNodes()[indexNode] != null && getNodes()[indexNode].contains(input, bitCurrentPosition - 1);
    }

    protected int getXorMax(int xorInput) {
        return getXorMax(xorInput, 0, BIGGER_BIT);
    }

    public void displayAllWorld() {
        if(getNodes()[0] != null) {
            getNodes()[0].displaySubWorld(0, BIGGER_BIT - 1);
        }
        if(getNodes()[1] != null) {
            getNodes()[1].displaySubWorld(Math.pow(2, BIGGER_BIT), BIGGER_BIT - 1);
        }
    }
}
