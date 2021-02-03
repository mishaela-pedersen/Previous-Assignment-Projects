import org.json.simple.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Formatter;

/**
 * Control Class based on JSONExample2 and JSONExample3
 * @author mishaelapedersen
 * 2/3/2021
 *
 */
public class CharacterCreator {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        JSONObject obj=new JSONObject();
        JSONObject c=new JSONObject();
        JSONArray list = new JSONArray();

        obj.put("database:", "characters");
        c.put("name","Haruto Kudo");
        c.put("age",16);
        c.put("gender","Male");
        c.put("creator", "Mishaela");
        c.put("desc", "One of the leading characters of the fan game Danganronpa: Suffering's Symphony");
        c.put("fanmade", true);
        list.add(c);
        c=new JSONObject();
        c.put("name","Lucas Carter");
        c.put("age",17);
        c.put("gender","Male");
        c.put("creator", "Mishaela");
        c.put("desc", "The co-protagonist of the visual novel, Twisted Clocks.");
        c.put("fanmade", false);
        list.add(c);
        obj.put("characters:", list);
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        System.out.print(jsonText);

        Formatter output = new Formatter("characters2.json");
        output.format("%s", jsonText);
        output.close();
    }

}