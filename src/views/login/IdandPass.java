package views.login;

import java.util.HashMap;

public class IdandPass {
    
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public IdandPass() {
        loginInfo.put("admin", "titok");
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
