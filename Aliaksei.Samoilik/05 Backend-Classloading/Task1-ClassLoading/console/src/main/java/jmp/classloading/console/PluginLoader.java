package jmp.classloading.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
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
        List<String> pluginsList = new ArrayList<>();
        List<URL> jarURLList = new ArrayList<>();
        // get uri list of JAR
        List<URI> uriList = Files.walk(Paths.get(folder)).filter(path -> path.toString().endsWith("jar"))
                .map(p -> p.toUri()).collect(Collectors.toList());
        // Create URL Jar list for class loading and create list of available
        // plugins
        for (URI uri : uriList) {
            List<String> jarsPluginList = getPluginsList(uri.toURL().toString());
            jarURLList.add(uri.toURL());
            pluginsList.addAll(jarsPluginList);
        }
        // Load JARs from folder
        URL[] jars = jarURLList.toArray(new URL[0]);
        URLClassLoader child = new URLClassLoader(jars, this.getClass().getClassLoader());

        // Create list of plugins objects
        for (String pluginClass : pluginsList) {
            Class<?> clazz = Class.forName(pluginClass, true, child);
            PluginInterface plugin = (PluginInterface) clazz.getConstructor().newInstance();
            result.add(plugin);
        }

        return result;
    }

    /**
     * read a "plugins" file with the plugin list in JAR
     * "plugins" contains list of plugin classes in JAR
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
