/*

DAY : 8
 ASSIGNMENT NO : 5 
   
Sometimes you have a file that you would like to put on a floppy disk but it is too big.
Perhaps you want to copy the file from one computer to another and USB’s are your only
means of transfer. It would be useful to split the long file into several short files that each
fit on a USB. After transfer to the other computer the short files can be concatenated into
a copy of the original.
Hint: The command line for this program is given as follows.
java fileSplit bigFile baseName chunkSize bigFile is the name of the big, existing file. Each small file will be named baseName
with a number appended in the end. For example, if baseName is chop then the small
files will be chop0, chop1, chop2, and so on for as many as are needed. chunkSize
is the size in bytes of each small file, except for the last one.
For testing, use any file for bigFile, no matter of whatever size, and similarly any size
for chunkSize. Use the file concatenation program to put the file together again. See
if there are any changes with a file comparison program.


*/

package net.texala.main;

import java.io.*;

public class FileSplitter {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java FileSplitter bigFile baseName chunkSize");
            return;
        }

        String bigFileName = args[0];
        String baseName = args[1];
        int chunkSize = Integer.parseInt(args[2]);

        try (FileInputStream fis = new FileInputStream(bigFileName)) {
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int count = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String chunkFileName = baseName + count;
                try (FileOutputStream fos = new FileOutputStream(chunkFileName)) {
                    fos.write(buffer, 0, bytesRead);
                }
                count++;
            }

            System.out.println("File split successfully into " + count + " chunks.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


