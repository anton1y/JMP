package jmp.classloading.plugin2;

import org.apache.log4j.Logger;

import jmp.classloading.common.PluginInterface;

public class Plugin2Impl implements PluginInterface {

    final static Logger logger = Logger.getLogger(Plugin2Impl.class);

    @Override
    public void doSomething() {
        logger.info("plugin 2 does something");

    }

    @Override
    public String getName() {
        return "Plugin2";
    }

}