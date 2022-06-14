package animals;

import communication.Dialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class AnimalExpertSystem {

    private Scanner scanner = new Scanner(System.in);
    private Node rootNode;
    private Dialog dialog;

    public AnimalExpertSystem(Node rootNode, Dialog dialog) {
        this.rootNode = rootNode;
        this.dialog = dialog;
    }

    public void launch() {
        dialog.sayHi();

        if (rootNode.getData() == null) {
            String animal1 = dialog.ask("askFavoriteAnimal", scanner);
            rootNode.setData(dialog.withIndefiniteArticle(animal1));
        }
        System.out.println(dialog.getMessage("welcome"));
        menu();
        dialog.sayBye();
    }

    private void menu() {
        System.out.println();
        System.out.println(dialog.getMessage("whatDoYouWant"));
        System.out.println();
        String option = dialog.ask("menu", scanner);
        switch (option) {
            case "1" : {
                Game game = new Game(rootNode, dialog, scanner);
                game.play();
                menu();
                break;
            }
            case "2" : {
                printListOfAllAnimals();
                menu();
                break;
            }
            case "3" : {
                searchForAnimal();
                menu();
                break;
            }
            case "4" : {
                calculateStatistics();
                menu();
                break;
            }
            case "5" : {
                printTree();
                menu();
                break;
            }
            case "0" : {
                break;
            }
            default:  {
                System.out.println(dialog.getMessage("wrongOption"));
                menu();
            }
        }
    }

    private void printListOfAllAnimals() {
        ArrayList<String> list = new ArrayList<>();
        getAnimalsToList(rootNode, list);
        Collections.sort(list);
        System.out.println(dialog.getMessage("here"));
        for (String str : list) {
            System.out.println(" - " + str);
        }
    }

    private void getAnimalsToList(Node node, ArrayList<String> list) {
        if (node.getNo() != null) {
            getAnimalsToList(node.getNo(), list);
        }
        if (node.isLeaf()) {
            list.add(dialog.withoutArticle(node.getData()));
        }
        if (node.getYes() != null) {
            getAnimalsToList(node.getYes(), list);
        }
    }

    private void searchForAnimal() {
        String animalToSearchFor = dialog.ask("enter", scanner);
        animalToSearchFor = dialog.withoutArticle(animalToSearchFor);
        Stack<Node> stack = search(animalToSearchFor);
        if (stack.isEmpty() || stack.size() == 1) {
            System.out.println(dialog.getMessage("nofact") + dialog.withDefiniteArticle(animalToSearchFor));
        } else {
            Stack<String> facts = new Stack<>();
            Node prev = stack.pop();
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                if (current.getYes() == prev) {
                    facts.add(current.getPositiveStatement());
                } else if (current.getNo() == prev) {
                    facts.add(current.getNegativeStatement());
                }
                prev = current;
            }
            System.out.println(dialog.getMessage("factsabout") + dialog.withDefiniteArticle(animalToSearchFor) + ":");
            while (!facts.isEmpty()) {
                System.out.println(facts.pop());
            }
        }
    }

    private Stack<Node> search(String animal) {
        Stack<Node> stack = new Stack<>();
        if (rootNode == null) {
            return stack;
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
                    if (dialog.withoutArticle(current.getData()).equalsIgnoreCase(animal)) {
                        return stack;
                    }
                    stack.pop();
                }

            }
            else if (current.getNo() == prev) {
                if (current.getYes() != null)
                    stack.push(current.getYes());
                else {
                    if (dialog.withoutArticle(current.getData()).equalsIgnoreCase(animal)) {
                        return stack;
                    }
                    stack.pop();
                }

            }
            else if (current.getYes() == prev) {
                if (dialog.withoutArticle(current.getData()).equalsIgnoreCase(animal)) {
                    return stack;
                }
                stack.pop();
            }

            prev = current;
        }
        return stack;
    }

    private void calculateStatistics() {
        TreeStatistic statistic = new TreeStatistic(rootNode);
        System.out.println(dialog.getMessage("stats"));
        System.out.println();
        String root = "";
        if (rootNode.isLeaf()) {
            root = dialog.withDefiniteArticle(rootNode.getData());
        } else {
            root = rootNode.getPositiveStatement();
        }
        System.out.println(dialog.getMessage("stats1") + root);
        System.out.println(dialog.getMessage("stats2") + statistic.getNumberOfNodes());
        System.out.println(dialog.getMessage("stats3") + statistic.getNumberOfAnimals());
        System.out.println(dialog.getMessage("stats4") + statistic.getNumberOfStatements());
        System.out.println(dialog.getMessage("stats5") + statistic.getHeight());
        System.out.println(dialog.getMessage("stats6") + statistic.getMinDepth());
        System.out.println(dialog.getMessage("stats7") + String.format("%.1f", statistic.getAverageDepth()));
    }
    private void printTree() {
        if (rootNode == null) {
            return;
        }
        printNode(rootNode, "└ ", " ");
    }

    private void printNode(Node node, String prefix, String childPrefix) {
        if (node == null) {
            return;
        }
        String str = node.isLeaf() ? dialog.withIndefiniteArticle(node.getData()) : node.getData();
        System.out.println(prefix + str);
        if (node.getNo() == null) {
            printNode(node.getYes(), childPrefix + "└ ", childPrefix + " " );
        } else {
            printNode(node.getYes(), childPrefix + "├ ", childPrefix + "│" );
            printNode(node.getNo(), childPrefix + "└ ", childPrefix + " " );
        }
    }

}
