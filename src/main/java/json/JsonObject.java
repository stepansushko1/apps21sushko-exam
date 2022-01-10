package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private final HashMap<String, Json> jsonStuff = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        int i = 0;
        while (i != jsonPairs.length) {
            jsonStuff.put(jsonPairs[i].key, jsonPairs[i].value); i++;
        }
    }

    @Override
    public String toJson() {
        String output = "{";
        int i = 0;
        for (HashMap.Entry<String, Json> e : jsonStuff.entrySet()) {
            output += new JsonString(e.getKey()).toJson() + ": " + e.getValue().toJson();
            if (i != jsonStuff.size() - 1) {
                output += ", ";
            }
            i++;
        }
        return output + '}';
    }

    public void add(JsonPair jsonPair) {
        jsonStuff.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return jsonStuff.get(name);
    }

    public JsonObject projection(String... names) {

        JsonObject obj = new JsonObject();

        for (int i = 0; i < names.length; i++) {
            if (!this.jsonStuff.containsKey(names[i])) {
                continue;
            }
            else {
                obj.add(new JsonPair(names[i], this.jsonStuff.get(names[i])));
            }
        }

        return obj;
    }
}
