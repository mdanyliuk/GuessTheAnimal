package communication;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Dialog {
    private ResourceBundle messages;

    public Dialog(ResourceBundle messages) {
        this.messages = messages;
    }

    public void sayHi() {
        LocalTime localTime = LocalTime.now();
        if (localTime.isBefore(LocalTime.of(5, 0))) {
            System.out.println(getMessage("greeting.evening"));
        } else if (localTime.isBefore(LocalTime.of(12, 0))) {
            System.out.println(getMessage("greeting.morning"));
        } else if (localTime.isBefore(LocalTime.of(18, 0))) {
            System.out.println(getMessage("greeting.afternoon"));
        } else {
            System.out.println(getMessage("greeting.evening"));
        }
    }

    public void sayBye() {
        System.out.println(getRandomMessage("bye"));
    }

    public String ask(String key, Scanner scanner) {
        return askStr(getMessage(key), scanner);
    }

    public String askStr(String question, Scanner scanner) {
        System.out.println(question);
        return scanner.nextLine().trim().toLowerCase();
    }

    public String withIndefiniteArticle(String answer) {
        String definiteArticle = messages.getString("definiteArticle").trim();
        String indefiniteArticle = messages.getString("indefiniteArticle").trim();
        String indefiniteArticleAn = messages.getString("indefiniteArticleAn").trim();
        String[] arr = answer.split(" ");
        if (arr.length > 1) {
            if (arr[0].equalsIgnoreCase(definiteArticle)) {
                answer = answer.substring(definiteArticle.length() + 1);
            } else if(arr[0].equalsIgnoreCase(indefiniteArticle) || arr[0].equalsIgnoreCase(indefiniteArticleAn)) {
                return answer;
            }
        }
        return addIndefiniteArticle(answer);
    }

    public String addIndefiniteArticle(String word) {
        String indefiniteArticle = messages.getString("indefiniteArticle");
        String indefiniteArticleAn = messages.getString("indefiniteArticleAn");
        return (isVowel(word.charAt(0)) ? indefiniteArticleAn : indefiniteArticle) + word;
    }

    public String withDefiniteArticle(String answer) {
        String definiteArticle = messages.getString("definiteArticle").trim();
        String indefiniteArticle = messages.getString("indefiniteArticle").trim();
        String indefiniteArticleAn = messages.getString("indefiniteArticleAn").trim();
        String[] arr = answer.split(" ");
        if (arr.length > 1) {
            if (arr[0].equalsIgnoreCase(definiteArticle)) {
                return answer;
            } else if(arr[0].equalsIgnoreCase(indefiniteArticle)) {
                return "the " + answer.substring(indefiniteArticle.length() + 1);
            } else if(arr[0].equalsIgnoreCase(indefiniteArticleAn)) {
                return "the " + answer.substring(indefiniteArticleAn.length() + 1);
            }
        }
        return definiteArticle + " " + answer;
    }

    public String withoutArticle(String answer) {
        String definiteArticle = messages.getString("definiteArticle").trim();
        String indefiniteArticle = messages.getString("indefiniteArticle").trim();
        String indefiniteArticleAn = messages.getString("indefiniteArticleAn").trim();
        String[] arr = answer.split(" ");
        if (arr.length > 1) {
            if (arr[0].equalsIgnoreCase(definiteArticle)) {
                return answer.substring(definiteArticle.length() + 1);
            } else if(arr[0].equalsIgnoreCase(indefiniteArticle)) {
                return answer.substring(indefiniteArticle.length() + 1);
            } else if(arr[0].equalsIgnoreCase(indefiniteArticleAn)) {
                return answer.substring(indefiniteArticleAn.length() + 1);
            }
        }
        return answer;
    }
    public boolean yesOrNo(String answer, Scanner scanner) {
        if (isYes(answer)) {
            return true;
        }
        if (isNo(answer)) {
            return false;
        }
        System.out.println(getRandomMessage("clarifyYesOrNo"));
        answer = scanner.nextLine();
        return yesOrNo(answer, scanner);
    }

    private boolean isYes(String str) {
        str = deletePunctuation(str);
        String[] arr = messages.getStringArray("yes");
        return List.of(arr).contains(str.toLowerCase());
    }

    private boolean isNo(String str) {
        str = deletePunctuation(str);
        String[] arr = messages.getStringArray("no");
        return List.of(arr).contains(str.toLowerCase());
    }

    public String fromCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private String deletePunctuation(String str) {
        if (str.length() == 0) {
            return str;
        }
        if (str.charAt(str.length() - 1) == '.' || str.charAt(str.length() - 1) == '!') {
            return str.substring(0, str.length() - 1);
        } else {
            return str;
        }
    }

    private boolean isVowel(char ch) {
        String str = "aeiouAEIOU";
        return str.indexOf(ch) != -1;
    }

    public String getMessage(String key) {
        return messages.getString(key);
    }

    private String getRandomMessage(String key) {
        String[] arr = messages.getStringArray(key);
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }

}
