# Solution 1
/** The read4 API is defined in the parent class Reader4. int read4(char[] buf); */
 
public class Solution extends Reader4 {
/**
* @param buf 　Destination buffer
* @param n　　　Maximum number of characters to read
* @return　    The number of characters read
*/
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = read4(buffer);
            if (sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz);
            // buffer /* src */, 0 /* srcPos */,　buf /* dest */, readBytes /* destPos */, bytes /* length */;
            System.arraycopy(buffer, 0,　buf, readBytes, bytes);
            readBytes += bytes;
        }
        return readBytes;
    }
}

# Solution 2
/* The read4 API is defined in the parent class Reader4. int read4(char[] buf); */
 
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int charsRead = 0;
        char[] buf4 = new char[4];
         
        while (!eof && charsRead < n) {
            int size = read4(buf4);
            if (size < 4) {
                eof = true;
            }
             
            if (charsRead + size > n) {
                size = n - charsRead;
            }
             
            System.arraycopy(buf4, 0, buf, charsRead, size);
            charsRead += size;
        }
         
        return charsRead;
    }
}
