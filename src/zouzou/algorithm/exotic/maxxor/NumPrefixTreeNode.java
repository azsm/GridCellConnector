package zouzou.algorithm.exotic.maxxor;

public class NumPrefixTreeNode {
    private NumPrefixTreeNode[] nodes = new NumPrefixTreeNode[2];

    public NumPrefixTreeNode[] getNodes() {
        return nodes;
    }

    protected void insert(int input, int bitCurrentPosition) {
        if (bitCurrentPosition < 0) return;

        int indexNode = getCorrespondingIndexNode(input, bitCurrentPosition);
        if (nodes[indexNode] == null) {
            nodes[indexNode] = new NumPrefixTreeNode();
        }

        nodes[indexNode].insert(input, bitCurrentPosition - 1);
    }

    protected boolean contains(int input, int bitCurrentPosition) {
        if (bitCurrentPosition < 0) {
            return true;
        }

        int indexNode = getCorrespondingIndexNode(input, bitCurrentPosition);
        return nodes[indexNode] != null && nodes[indexNode].contains(input, bitCurrentPosition - 1);

    }

    protected int getCorrespondingIndexNode(int input, int bitCurrentPosition) {
        return (input & (1 << bitCurrentPosition)) != 0 ? 1 : 0;
    }

    protected int getInverseIndexNode(int input, int bitCurrentPosition) {
        return (input & (1 << bitCurrentPosition)) != 0 ? 0 : 1;
    }

    protected int getXorMax(int xorInput, double sum, int bitCurrentPosition) {
        if (getNodes()[0] == null && getNodes()[1] == null) {
            return (int) sum;
        }

        int indexNode = getInverseIndexNode(xorInput, bitCurrentPosition);
        if (getNodes()[indexNode] != null) {
            return getNodes()[indexNode].getXorMax(xorInput, sum + Math.pow(2, bitCurrentPosition), bitCurrentPosition - 1);
        }
        int otherIndex = indexNode == 1 ? 0 : 1;
        return getNodes()[otherIndex].getXorMax(xorInput, sum, bitCurrentPosition - 1);

    }

    protected void displaySubWorld(double sum, int bitCurrentPosition) {
        if (getNodes()[0] == null && getNodes()[1] == null) {
            System.out.println(sum);
        }
        if (getNodes()[0] != null) {
            getNodes()[0].displaySubWorld(sum, bitCurrentPosition - 1);
        }
        if (getNodes()[1] != null) {
            getNodes()[1].displaySubWorld(sum + Math.pow(2, bitCurrentPosition), bitCurrentPosition - 1);
        }
    }
}
