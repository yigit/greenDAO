package de.greenrobot.daogenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Model class for an Annotation that can be attached to classses, properties or methods
 * @author yigit@path.com
 */
public class Annotation {
    private String name;
    private Map<String, String> parameters = new HashMap<String, String>();
    public static Pattern QUOTE = Pattern.compile("\"");

    //we use this if Annotation has only 1 parameter
    public static final String NO_NAME = "__no_name";
    public static final String NULL = "null";

    public Annotation(String name, String... params) {
        this.name = name;
        this.parameters = new HashMap<String, String>();
        if(params.length > 1 && params.length % 2 != 0) {
            throw new RuntimeException("annotation parameters should be key value pairs");
        }
        if(params.length == 1) {
            this.parameters.put(NO_NAME, params[0] == null ? NULL : params[0]);
        } else {
            for(int i = 0; i < params.length; i += 2) {
                this.parameters.put(params[i], params[i + 1] == null ? NULL : params[i + 1]);
            }
        }
    }

    public Annotation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
