package jmp.classloading.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import jmp.classloading.common.PluginInterface;

public class PluginLoader {
    final static Logger logger = Logger.getLogger(PluginLoader.class);

    public List<PluginInterface> loadPlugins(String folder) throws Exception {
        List<PluginInterface> result = new ArrayList<>();
        // get uri list of JAR
        List<File> fileList = Files.walk(Paths.get(folder)).filter(path -> path.toString().endsWith("jar"))
                .map(p -> p.toFile()).collect(Collectors.toList());
        // Create URL Jar list for class loading and create list of available
        // plugins
        for (File file : fileList) {
            JarClassLoader jarClassLoader = new JarClassLoader(file);
            List<String> jarsPluginList = getPluginsList(file.toURI().toURL().toString());
            for (String pluginClass : jarsPluginList) {
                Class<?> clazz = Class.forName(pluginClass, true, jarClassLoader);
                PluginInterface plugin = (PluginInterface) clazz.getConstructor().newInstance();
                result.add(plugin);
            }
        }
        return result;
    }

    /**
     * read a "plugins" file with the plugin list in JAR "plugins" contains list
     * of plugin classes in JAR
     * 
     * @param jarURI
     * @return
     */
    private List<String> getPluginsList(String jarURI) {
        List<String> result = new ArrayList<>();
        URL url = null;
        InputStream is = null;

        try {
            url = new URL("jar:" + jarURI + "!/plugins");
            is = url.openStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = null;

            while ((line = in.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            logger.error("error", e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error("error", e);
            }
        }
        return result;
    }
}
