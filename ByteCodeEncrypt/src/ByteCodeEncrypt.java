import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCodeEncrypt extends ClassLoader {
    public static void main(String args[]) throws IOException {
        File file=new File("/Users/kirra/Desktop/project/Java-Basic-Lab/ByteCodeEncrypt/src/SayHello.class");
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray); //read file into bytes[]
        fis.close();
        for(int i=0;i<bytesArray.length;i++)
        {
            bytesArray[i]= (byte) (bytesArray[i]+5);
        }
        File kenhofile=new File("/Users/kirra/Desktop/project/Java-Basic-Lab/ByteCodeEncrypt/src/EncryptSayHello.class");
        if(!kenhofile.exists())
            kenhofile.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(kenhofile);
        fileOutputStream.write(bytesArray);
        fileOutputStream.close();

    }
}
