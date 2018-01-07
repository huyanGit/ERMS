package utils;

import com.google.gson.*;

import java.lang.reflect.Type;

class StringConverter implements JsonSerializer<String>,
        JsonDeserializer<String> {
    public JsonElement serialize(String src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        if (src == null) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src.toString());
        }
    }

    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context)
            throws JsonParseException {
        return json.getAsJsonPrimitive().getAsString();
    }
}

public class IJsonHelper {


    private static Gson gson;

    private IJsonHelper() {
        super();
    }

    /**
     *获取识别null的gson
     * @return
     */
    public static Gson getGsonSerizeNull() {
        if (gson == null) {
            synchronized (IJsonHelper.class) {
                if (gson == null) {
                    gson = new GsonBuilder()
                            .serializeNulls()
                            .create();
//                    GsonBuilder gb = new GsonBuilder().serializeNulls();
////                    gb.registerTypeAdapter(String.class,new StringConverter());
//                    gson = gb.create();
                }
            }
        }
        return gson;
    }


}
