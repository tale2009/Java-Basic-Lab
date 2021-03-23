import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KenhoClassLoader extends ClassLoader{
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        new KenhoClassLoader().findClass("SayHello").newInstance();
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file=new File("/Users/kirra/Desktop/project/Java-Basic-Lab/ByteCodeEncrypt/src/Encrypt"+name+".class");
        byte[] bytes=new byte[(int)file.length()];
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            fileInputStream.read(bytes);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<bytes.length;i++)
            bytes[i]= (byte) (bytes[i]-5);
        return defineClass(name, bytes, 0, bytes.length);
    }

}
