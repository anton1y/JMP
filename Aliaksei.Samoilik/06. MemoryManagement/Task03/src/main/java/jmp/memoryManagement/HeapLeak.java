package jmp.memoryManagement;


public class HeapLeak {

    public static void main(String[] args) throws Exception {
        StringBuffer buffer = new StringBuffer();
        while(true){
            buffer.append("string");
        }
    }
}
