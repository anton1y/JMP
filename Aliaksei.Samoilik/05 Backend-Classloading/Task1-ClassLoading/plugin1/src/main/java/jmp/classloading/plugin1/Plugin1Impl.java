package jmp.classloading.plugin1;

import org.apache.log4j.Logger;

import jmp.classloading.common.PluginInterface;

public class Plugin1Impl implements PluginInterface {

    final static Logger logger = Logger.getLogger(Plugin1Impl.class);

    @Override
    public void doSomething() {
        logger.info("plugin 1 does something");
    }

    @Override
    public String getName() {
        return "Plugin1";
    }

}
