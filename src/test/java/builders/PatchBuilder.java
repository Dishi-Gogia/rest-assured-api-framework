package builders;

import java.util.HashMap;
import java.util.Map;

public class PatchBuilder {

    private final Map<String, Object> patchData = new HashMap<>();

    public PatchBuilder addField(String key, Object value) {

        patchData.put(key, value);
        return this;
    }

    public Map<String, Object> build() {

        return patchData;
    }
}