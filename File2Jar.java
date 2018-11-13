import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class File2Jar 
{

    private static final String INPUT_FILE = "C:/CONFIG.txt";
    private static final String OUTPUT_FILE = "C:/Users/POLO/Desktop/SERVEUR.jar";

    public File2Jar(File inputFile, String zipFilePath) 
    {
       try 
       {
         FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
         ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

         ZipEntry zipEntry = new ZipEntry(inputFile.getName());
         zipOutputStream.putNextEntry(zipEntry);

         FileInputStream fileInputStream = new FileInputStream(inputFile);
         byte[] buf = new byte[1024];
         int bytesRead;

         while ((bytesRead = fileInputStream.read(buf)) > 0)
         {
           zipOutputStream.write(buf, 0, bytesRead);
         }

         zipOutputStream.closeEntry();
         zipOutputStream.close();
         fileOutputStream.close();

         System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :"+zipFilePath);

       } catch (IOException e) {}
    }
    
    public static void main(String[] args) 
    {
    	new File2Jar(new File(INPUT_FILE), OUTPUT_FILE);
    }

}