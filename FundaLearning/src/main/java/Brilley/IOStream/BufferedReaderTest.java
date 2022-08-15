package Brilley.IOStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-08-09 23:40
 */
public class BufferedReaderTest {
    public static void bufferedReaderTest1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str);
    }
}
