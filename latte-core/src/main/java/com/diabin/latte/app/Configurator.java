package com.diabin.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.WeakHashMap;//WeakHashMap的机制是：当内部的键值对不在被系统引用的时候自行进行清除和回收，但该Configurator中的配置项是伴随着整个app的生命周期的存在而存在的。

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public class Configurator {
    private static final HashMap<String,Object> LATTE_CONFIGS=new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS=new ArrayList<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(),false);
    }

    final HashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    private static class Holder{

        private static final Configurator INSTANCE=new Configurator();
    }
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(),host);
        return this;
    }

    private void initIcons(){
        if (ICONS.size()>0){
            final Iconify.IconifyInitializer initializer=Iconify.with(ICONS.get(0));
            for (int i = 1; i <ICONS.size() ; i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady= (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configurator is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTE_CONFIGS.get(key);
//        return (T) LATTE_CONFIGS.get(key.name());
    }
}
