package animals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class TreeStatistic {
    private int numberOfAnimals = 0;
    private int numberOfStatements = 0;
    private ArrayList<Integer> listDepth = new ArrayList<>();

    public TreeStatistic(Node rootNode) {
        Stack<Node> stack = new Stack<>();
        if (rootNode == null) {
            return;
        }
        stack.push(rootNode);
        Node prev = null;
        while (!stack.isEmpty()) {
            Node current = stack.peek();

            if (prev == null || prev.getNo() == current || prev.getYes() == current) {
                if (current.getNo() != null)
                    stack.push(current.getNo());
                else if (current.getYes() != null)
                    stack.push(current.getYes());
                else {
                    numberOfAnimals++;
                    listDepth.add(stack.size() - 1);
                    stack.pop();
                }

            }
            else if (current.getNo() == prev) {
                if (current.getYes() != null)
                    stack.push(current.getYes());
                else {
                    if (current.isLeaf()) {
                        numberOfAnimals++;
                        listDepth.add(stack.size() - 1);
                    } else {
                        numberOfStatements++;
                    }
                    stack.pop();
                }

            }
            else if (current.getYes() == prev) {
                if (current.isLeaf()) {
                    numberOfAnimals++;
                    listDepth.add(stack.size() - 1);
                } else {
                    numberOfStatements++;
                }
                stack.pop();
            }

            prev = current;
        }
    }

    public int getNumberOfNodes() {
        return numberOfAnimals + numberOfStatements;
    }

    public int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public int getNumberOfStatements() {
        return numberOfStatements;
    }

    public int getHeight() {
        return Collections.max(listDepth);
    }

    public int getMinDepth() {
        return Collections.min(listDepth);
    }

    public double getAverageDepth() {
        if (listDepth.size() == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i : listDepth) {
            sum += i;
        }
        return (double) sum / listDepth.size();
    }
}
