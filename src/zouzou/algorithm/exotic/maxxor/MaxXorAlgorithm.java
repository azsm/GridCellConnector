package zouzou.algorithm.exotic.maxxor;


import java.util.stream.IntStream;

public class MaxXorAlgorithm {

    public int[] getMaxXor(int[] inputs, int[] comparingVal) {
        NumPrefixTree numPrefixTree = new NumPrefixTree();
        for(int input : inputs) numPrefixTree.insert(input);

        return IntStream.of(comparingVal)
                .map(i -> numPrefixTree.getXorMax(i))
                .toArray();
    }

}
