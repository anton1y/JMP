package jmp.classloading.console;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import jmp.classloading.common.PluginInterface;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws Exception {

        String pluginFolder = args[0];
        PluginLoader pluginLoader = new PluginLoader();
        List<PluginInterface> plugins = pluginLoader.loadPlugins(pluginFolder);

        logger.info("Choose plugin to execute");
        logger.info("-------------------------\n");
        int i = 0;
        for (PluginInterface plugin : plugins) {
            logger.info("" + (i++) + " - " + plugin.getName());
        }
        logger.info("Choose option:");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        plugins.get(selection).doSomething();

        logger.info("Bye");
    }
}
