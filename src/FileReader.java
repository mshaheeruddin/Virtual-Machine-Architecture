import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {
    public ArrayList<Integer> contentOfFile = new ArrayList<>();
    //Code Segment
    public int[] code;
    //Data Segment
    public int[] data;


    public void readFile(String fileName) {
        String inputFile = "C:\\Users\\Muhammad Shaheer\\Desktop\\IBA\\Fifth Semester\\OS\\ProjectPhase1\\src\\"+fileName;
        try (
                InputStream inputStream = new FileInputStream(inputFile);
        )
        {
            String dataSize = "";
            int idataSize;
            int byteRead;
            int bytesInFile = 0;
            while ((byteRead = inputStream.read()) != -1) {
                contentOfFile.add(bytesInFile,byteRead);
                bytesInFile++;
                System.out.println(byteRead);
            }

            dataSize = dataSize.concat(String.valueOf(contentOfFile.get(3)));
            dataSize = dataSize.concat(String.valueOf(contentOfFile.get(4)));
            idataSize = Integer.parseInt(dataSize);

            data = new int[idataSize];
            //Load Data Segment
            int lastDataIndex = 0;
            for (int i = 0;i< idataSize;i++) {
                        data[i] = contentOfFile.get(i+8);
                        lastDataIndex = i+8;
            }

             code = new int[contentOfFile.size()-idataSize-8];
            //Load Code Segment
            for (int i = lastDataIndex+1;i< contentOfFile.size()-idataSize-8;i++) {
                code[i-lastDataIndex-1] = contentOfFile.get(i);
            }
            System.out.println("Data Segment");
            System.out.println(Arrays.toString(data));
            System.out.println("Code Segment");
            System.out.println(Arrays.toString(code));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }



        public static void main(String[] args) {
                  FileReader fr = new FileReader();
                  fr.readFile("p5");
        }
    }

