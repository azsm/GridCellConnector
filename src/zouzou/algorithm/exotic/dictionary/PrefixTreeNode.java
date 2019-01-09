package zouzou.algorithm.exotic.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrefixTreeNode {
    private char currentVal;
    private List<PrefixTreeNode> nodes = new ArrayList<>();

    public PrefixTreeNode(char currentVal) {
        this.currentVal = currentVal;
    }

    public char getCurrentVal() {
        return currentVal;
    }

    public List<PrefixTreeNode> getNodes() {
        return nodes;
    }

    public void insert(String world) {
        if (world.isEmpty()) {
            return;
        }

        char firstChar = world.charAt(0);
        Optional<PrefixTreeNode> firstCharNode = nodes.stream()
                .filter(n -> n.getCurrentVal() == firstChar)
                .findFirst();

        firstCharNode.orElseGet(() -> {
            PrefixTreeNode newNode = new PrefixTreeNode(firstChar);
            nodes.add(newNode);
            return newNode;
        }).insert(world.substring(1));
    }


    public boolean contains(String world) {
        if (world.isEmpty()) {
            return true;
        }

        char firstChar = world.charAt(0);
        Optional<PrefixTreeNode> firstCharNode = nodes.stream()
                .filter(n -> n.getCurrentVal() == firstChar)
                .findFirst();

        return firstCharNode.isPresent() && firstCharNode.get().contains(world.substring(1));
    }

    public void displaySubWorld(String prefix) {
        String newPrefix = prefix + getCurrentVal();
        if(nodes.isEmpty()) {
            System.out.println(newPrefix);
        }
        else {
            nodes.forEach(n -> n.displaySubWorld(newPrefix));
        }
    }
}
