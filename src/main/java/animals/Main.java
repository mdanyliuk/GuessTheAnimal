package animals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import communication.Dialog;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        String fileFormat = "";
        List<String> argsList = Arrays.asList(args);
        int typeIndex = argsList.indexOf("-type");
        if (typeIndex != -1) {
            String typeParameter = argsList.get(typeIndex + 1);
            if (typeParameter.equalsIgnoreCase("xml")) {
                fileFormat = "XML";
            } else if (typeParameter.equalsIgnoreCase("yaml")) {
                fileFormat = "YAML";
            }
        }
        ObjectMapper objectMapper;
        String fileName = "animals";
        String lang = Locale.getDefault().getLanguage();
        if (!lang.equals("en")) {
            fileName = fileName + "_" + lang;
        }
        switch (fileFormat) {
            case "XML": {
                objectMapper = new XmlMapper();
                fileName = fileName + ".xml";
                break;
            }
            case "YAML": {
                objectMapper = new YAMLMapper();
                fileName = fileName + ".yaml";
                break;
            }
            default: {
                objectMapper = new JsonMapper();
                fileName = fileName + ".json";
                break;
            }
        }

        Node root;
        try {
            root = objectMapper.readValue(new File(fileName), Node.class);
        } catch (IOException e) {
            root = new Node(null);
        }

        ResourceBundle messages = ResourceBundle.getBundle("resourcebundle.MessageResource");

        Dialog dialog = new Dialog(messages);
        AnimalExpertSystem animalExpertSystem = new AnimalExpertSystem(root, dialog);
        animalExpertSystem.launch();

        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
