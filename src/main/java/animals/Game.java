package animals;

import communication.Dialog;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    Node rootNode;
    Dialog dialog;
    Scanner scanner;

    public Game(Node rootNode, Dialog dialog, Scanner scanner) {
        this.rootNode = rootNode;
        this.dialog = dialog;
        this.scanner = scanner;
    }

    public void play() {
        boolean playAgain = true;
        while (playAgain) {
            dialog.ask("thinkOfAnimal", scanner);
            playNode(rootNode);
            playAgain = dialog.yesOrNo(dialog.ask("playAgain", scanner), scanner);
        }
    }

    private void playNode(Node node) {
        if (node.isLeaf()) {
            boolean guess = dialog.yesOrNo(dialog.askStr(dialog.getMessage("isIt")  + " " + dialog.withIndefiniteArticle(node.getData()) + "?", scanner), scanner);
            if (guess) {
                System.out.println(dialog.getMessage("iWin"));
            } else {
                String newAnimal = dialog.ask("giveUp", scanner);
                handleNewAnimal(node.getData(), newAnimal, node);
            }
        } else {
            boolean answer = dialog.yesOrNo(dialog.askStr(node.getData(), scanner), scanner);
            if (answer) {
                playNode(node.getYes());
            } else {
                playNode(node.getNo());
            }
        }
    }

    private void handleNewAnimal(String animal1, String animal2, Node node) {
        System.out.printf(dialog.getMessage("fact.specify"),
                dialog.withIndefiniteArticle(animal1),
                dialog.withIndefiniteArticle(animal2));
        System.out.println(dialog.getMessage("fact.format"));
        String answer = scanner.nextLine().trim();

        Pattern pattern = Pattern.compile(dialog.getMessage("fact.pattern"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(answer);

        if (matcher.matches()) {
            System.out.printf(dialog.getMessage("fact.clarify"), dialog.withIndefiniteArticle(animal2));
            boolean correctForSecond = dialog.yesOrNo(scanner.nextLine(), scanner);

            Pattern patternCan = Pattern.compile(dialog.getMessage("can.pattern"), Pattern.CASE_INSENSITIVE);
            Pattern patternHas = Pattern.compile(dialog.getMessage("has.pattern"), Pattern.CASE_INSENSITIVE);
            //Pattern patternIs = Pattern.compile("It is \\w+}", Pattern.CASE_INSENSITIVE);
            String verb = "";
            String statement = "";
            String askVerb = "";
            String negativeVerb = "";
            if (patternCan.matcher(answer).matches()) {
                verb = dialog.getMessage("can.verb");
                statement = answer.substring(dialog.getMessage("it").length() + dialog.getMessage("can.verb").length() + 2);
                askVerb = dialog.getMessage("can.ask");
                negativeVerb = dialog.getMessage("can.negative");
            } else if (patternHas.matcher(answer).matches()) {
                verb = dialog.getMessage("has.verb");
                statement = answer.substring(dialog.getMessage("it").length() + dialog.getMessage("has.verb").length() + 2);
                askVerb = dialog.getMessage("has.ask");
                negativeVerb = dialog.getMessage("has.negative");
            } else {
                verb = dialog.getMessage("is.verb");
                statement = answer.substring(dialog.getMessage("it").length() + dialog.getMessage("is.verb").length() + (dialog.getMessage("is.verb").length() == 0 ? 1 : 2));
                askVerb = dialog.getMessage("is.ask");
                negativeVerb = dialog.getMessage("is.negative");
            }

            Node nodeNo = new Node(correctForSecond ? animal1 : animal2);
            Node nodeYes = new Node(correctForSecond ? animal2 : animal1);

            node.setData(dialog.fromCap(askVerb) + statement + "?");
            node.setNo(nodeNo);
            node.setYes(nodeYes);
            node.setPositiveStatement(dialog.fromCap(dialog.getMessage("it") + " " + verb + (verb.length() == 0 ? "" : " ") + statement + "."));
            node.setNegativeStatement(dialog.fromCap(dialog.getMessage("it") + " " + negativeVerb + " " + statement + "."));

            System.out.println(dialog.fromCap(dialog.getMessage("learned")));
            System.out.println(dialog.fromCap(dialog.withDefiniteArticle(animal1)) + " " + (correctForSecond ? negativeVerb : verb) + " " + statement + ".");
            System.out.println(dialog.fromCap(dialog.withDefiniteArticle(animal2)) + " " + (correctForSecond ? verb : negativeVerb) + " " + statement + ".");
            System.out.println(dialog.fromCap(dialog.getMessage("distinguish")));
            System.out.println(dialog.fromCap(askVerb) + statement + "?");
        } else {
            System.out.println(dialog.getMessage("fact.examples"));
            handleNewAnimal(animal1, animal2, node);
        }

    }
}
