package org.nvadiga.objects;

/**
 * Created by nvadiga on 12/6/2017.
 */
public class BrowserAction {
    private String action;
    private Data data;

    public BrowserAction(String action, Data data){
        this.action = action;
        this.data = data;
    }

    public String getAction(){
        return action;
    }

    public Data getData(){
        return data;
    }
}
