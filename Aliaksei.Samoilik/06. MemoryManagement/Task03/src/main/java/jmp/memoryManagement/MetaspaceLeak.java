package jmp.memoryManagement;

public class MetaspaceLeak {

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0;; i++) {
            Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
            System.out.println(c.getName());
        }
    }
}
