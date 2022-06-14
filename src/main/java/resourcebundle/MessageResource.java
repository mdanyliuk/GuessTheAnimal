package resourcebundle;

import java.util.ListResourceBundle;

public class MessageResource extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"greeting.morning", "Good morning!"},
                {"greeting.afternoon", "Good afternoon!"},
                {"greeting.evening", "Good evening!"},
                {"bye", new String[]{
                        "Bye!",
                        "Good bye!",
                        "See you soon!"
                }},
                {"askFavoriteAnimal", "I want to learn about animals.\n" +
                        "Which animal do you like most?"},
                {"welcome", "Welcome to the animal expert system!"},
                {"definiteArticle", "the "},
                {"indefiniteArticle", "a "},
                {"indefiniteArticleAn", "an "},
                {"whatDoYouWant", "What do you want to do:"},
                {"menu", "1. Play the guessing game\n" +
                        "2. List of all animals\n" +
                        "3. Search for an animal\n" +
                        "4. Calculate statistics\n" +
                        "5. Print the Knowledge Tree\n" +
                        "0. Exit"},
                {"wrongOption", "Unsupported action"},
                {"thinkOfAnimal", "You think of an animal, and I guess it.\n" +
                        "Press enter when you're ready."},
                {"playAgain", "Would you like to play again?"},
                {"yes", new String[]{
                        "y",
                        "yes",
                        "yeah",
                        "yep",
                        "sure",
                        "right",
                        "affirmative",
                        "correct",
                        "indeed",
                        "you bet",
                        "exactly",
                        "you said it"
                }},
                {"no", new String[]{
                        "n",
                        "no",
                        "no way",
                        "nah",
                        "nope",
                        "negative",
                        "i don't think so",
                        "yeah no"
                }},
                {"clarifyYesOrNo", new String[]{
                        "I'm not sure I caught you: was it yes or no?",
                        "Funny, I still don't understand, is it yes or no?",
                        "Oh, it's too complicated for me: just tell me yes or no.",
                        "Could you please simply say yes or no?",
                        "Oh, no, don't try to confuse me: say yes or no."
                }},
                {"isIt", "Is it"},
                {"iWin", "I win!"},
                {"giveUp", "I give up. What animal do you have in mind?"},
                {"fact.specify", "Specify a fact that distinguishes %s from %s.\n"},
                {"fact.format", "The sentence should be of the format: 'It can/has/is ...'."},
                {"fact.pattern", "It (can|has|is) \\w.*"},
                {"fact.examples", "The examples of a statement:\n" +
                        " - It can fly\n" +
                        " - It has horn\n" +
                        " - It is a mammal"},
                {"fact.clarify", "Is the statement correct for %s?\n"},
                {"can.pattern", "It can \\w.*"},
                {"has.pattern", "It has \\w.*"},
                {"can.verb", "can"},
                {"can.ask", "can it "},
                {"can.negative", "can't"},
                {"has.verb", "has"},
                {"has.ask", "does it have "},
                {"has.negative", "doesn't have"},
                {"is.verb", "is"},
                {"is.ask", "is it "},
                {"is.negative", "isn't"},
                {"it", "it"},
                {"learned", "I have learned the following facts about animals:"},
                {"distinguish", "I can distinguish these animals by asking the question:"},
                {"here", "Here are the animals I know:"},
                {"enter", "Enter the animal:"},
                {"nofact", "No facts about "},
                {"factsabout", "Facts about "},
                {"stats", "The Knowledge Tree stats"},
                {"stats1", "- root node                    "},
                {"stats2", "- total number of nodes        "},
                {"stats3", "- total number of animals      "},
                {"stats4", "- total number of statements   "},
                {"stats5", "- height of the tree           "},
                {"stats6", "- minimum animal's depth       "},
                {"stats7", "- average animal's depth       "}
        };
    }
}
