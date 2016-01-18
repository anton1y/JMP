package jmp.classloading.console;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarClassLoader extends ClassLoader {

    private JarFile jarFile;

    /**
     * This constructor is used to set the parent ClassLoader
     */
    public JarClassLoader(File file) {
        try {
            this.jarFile = new JarFile(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = getClass(name);

        if (result == null)
            result = super.findSystemClass(name);
        return result;
    }

    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', '/') + ".class";
        byte[] b = null;
        try {
            b = loadClassFileData(file);
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] loadClassFileData(String name) throws IOException {
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) entries.nextElement();
            if (name.equals(jarEntry.getName())) {
                byte[] data = new byte[(int) jarEntry.getSize()];
                InputStream in = jarFile.getInputStream(jarEntry);
                in.read(data);
                return data;
            }
        }
        return null;
    }
}
