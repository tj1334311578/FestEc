package com.diabin.latte.app;

import android.content.Context;

import java.util.HashMap;
//import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public final class Latte {
    public static Configurator init(Context context){
        getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    private static HashMap<String,Object> getConfigurator(){
        return Configurator.getInstance().getLatteConfigs();
    }
    public static Context getApplication(){
        return (Context) getConfigurator().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
