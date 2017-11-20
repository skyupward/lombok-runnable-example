package skyupward.lombok;

import lombok.Cleanup;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author SkyUpward
 * Created at 2017/11/12 20:49
 */
public class CleanupExample {

    public static void main(String[] args) throws IOException {
        CleanupExample cleanupExample = new CleanupExample();
        List inOut = cleanupExample.readAndWrite();
        //java.io.IOException: Stream Closed thrown
        Assertions.assertThrows(IOException.class, () -> ((InputStream)inOut.get(0)).read());
        Assertions.assertThrows(IOException.class, () -> ((OutputStream)inOut.get(1)).write(1));
    }

    public List readAndWrite() throws IOException {
        @Cleanup InputStream in = new FileInputStream("readAndWrite.txt");
        @Cleanup OutputStream out = new FileOutputStream("readAndWrite.txt");
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
        return Arrays.asList(in, out);
    }
}
