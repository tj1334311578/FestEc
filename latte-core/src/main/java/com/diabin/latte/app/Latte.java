package com.diabin.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigrations().put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public  static HashMap<String,Object> getConfigrations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigrations().get(ConfigKeys.APPLICATION_CONTEXT.name());
    }


    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}
