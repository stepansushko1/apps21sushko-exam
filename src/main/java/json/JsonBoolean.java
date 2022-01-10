package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    Boolean genBoolean;

    public JsonBoolean(Boolean bool) {
        this.genBoolean = bool;
    }

    @Override
    public String toJson() {
        return genBoolean.toString();
    }
}
