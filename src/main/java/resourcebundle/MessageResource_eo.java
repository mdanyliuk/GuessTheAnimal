package resourcebundle;

import java.util.ListResourceBundle;

public class MessageResource_eo extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"greeting.morning", "Bonan matenon!"},
                {"greeting.afternoon", "Bonan posttagmezon!"},
                {"greeting.evening", "Bonan vesperon!"},
                {"bye", new String[]{
                        "Ĝis!",
                        "Ĝis revido!",
                        "Estis agrable vidi vin!"
                }},
                {"askFavoriteAnimal", "Mi volas lerni pri bestoj.\n" +
                        "Kiun beston vi plej ŝatas?"},
                {"welcome", "bonvenon al la sperta sistemo de la besto!"},
                {"definiteArticle", "la "},
                {"indefiniteArticle", ""},
                {"indefiniteArticleAn", ""},
                {"whatDoYouWant", "Kion vi volas fari:"},
                {"menu", "1. Ludi la divenludon\n" +
                        "2. Listo de ĉiuj bestoj\n" +
                        "3. Serĉi beston\n" +
                        "4. Kalkuli statistikon\n" +
                        "5. Presu la Scion-Arbon\n" +
                        "0. Eliri"},
                {"wrongOption", "Nesubtenata ago"},
                {"thinkOfAnimal", "vi pensu pri besto, kaj mi divenos ĝin.\n" +
                        "premu enen kiam vi pretas."},
                {"playAgain", "Ĉu vi ŝatus ludi denove?"},
                {"yes", new String[]{
                        "j",
                        "jes",
                        "certe"
                }},
                {"no", new String[]{
                        "n",
                        "ne",
                        "negativa"
                }},
                {"clarifyYesOrNo", new String[]{
                        "Mi ne certas, ke mi kaptis vin: ĉu jes aŭ ne?",
                        "Ĉu vi povus simple diri jes aŭ ne?"
                }},
                {"isIt", "Ĉu ĝi estas"},
                {"iWin", "Mi gajnas"},
                {"giveUp", "mi rezignas. kiun beston vi havas en la kapo?"},
                {"fact.specify", "indiku fakton, kiu distingas %s de %s.\n"},
                {"fact.format", "La frazo estu en la formato: 'Ĝi povas/havas/estas ...'."},
                {"fact.pattern", "ĝi \\w.*"},
                {"fact.examples", "La ekzemploj de deklaro:\n" +
                        " - Ĝi povas flugi\n" +
                        " - Ĝi havas kornon\n" +
                        " - Ĝi estas mamulo"},
                {"fact.clarify", "ĉu la aserto ĝustas por la %s?\n"},
                {"can.pattern", "ĝi povas \\w.*"},
                {"has.pattern", "ĝi havas \\w.*"},
                {"can.verb", "povas"},
                {"can.ask", "Ĉu ĝi povas "},
                {"can.negative", "ne povas"},
                {"has.verb", "havas"},
                {"has.ask", "Ĉu ĝi havas "},
                {"has.negative", "ne havas"},
                {"is.verb", ""},
                {"is.ask", "Ĉu ĝi "},
                {"is.negative", "ne"},
                {"it", "ĝi"},
                {"learned", "Mi lernis la jenajn faktojn pri bestoj:"},
                {"distinguish", "Mi povas distingi ĉi tiujn bestojn farante la demandon:"},
                {"here", "Jen la bestoj, kiujn mi konas:"},
                {"enter", "Enigu la beston:"},
                {"nofact", "Neniuj faktoj pri "},
                {"factsabout", "Faktoj pri "},
                {"stats", "la statistiko de la Scio-Arbo"},
                {"stats1", "- radika nodo                   "},
                {"stats2", "- totala nombro de nodoj        "},
                {"stats3", "- totala nombro de bestoj       "},
                {"stats4", "- totala nombro de deklaroj     "},
                {"stats5", "- alteco de la arbo             "},
                {"stats6", "- minimuma profundo de besto    "},
                {"stats7", "- averaĝa profundo de besto     "}
        };
    }
}
