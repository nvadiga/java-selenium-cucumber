package org.nvadiga.objects;

/**
 * Created by nvadiga on 11/6/2017.
 */
public class Data {

    private String name;
    private String value;
    private String type;
    private String identifier;

    public Data(String name, String value, String type, String identifier){
        this.name = name;
        this.value = value;
        this.type = type;
        this.identifier = identifier;
    }

    public String getValue(){
        return value;
    }

    public String getType(){
        return type;
    }

    public String getIdentifier(){
        return identifier;
    }
}
