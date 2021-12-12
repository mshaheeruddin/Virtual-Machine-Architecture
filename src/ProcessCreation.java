import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProcessCreation {
    public ArrayList<Integer> contentOfFile = new ArrayList<>();
    //Code Segment
    public int[] code;
    //Data Segment
    public int[] data;
    //Data page Table
    HashMap<Integer,Integer> dataPageTable = new HashMap<>();
    //Code page Table
    HashMap<Integer,Integer> codePageTable = new HashMap<>();
    //PCB of Process
    PCB pcb;
    //GPR of Process
    //GeneralPurposeRegister gpr = GeneralPurposeRegister.getInstance(false);
    //SPR of Process
    //SpecialPurposeRegister spr = SpecialPurposeRegister.getInstance(false);
    //pagesNeeded for code
    int noOfPageNeededForCode;
    //pagesNeeded for Data
    int noOfPageNeededForData;






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
        noOfPageNeededForCode = pageNeeded(code.length);
        noOfPageNeededForData = pageNeeded(data.length);
        System.out.println("Length of Code: "+code.length);
        System.out.println("Length of Data: "+data.length);
        System.out.println(noOfPageNeededForCode);
        System.out.println(noOfPageNeededForData);
    }

    public int pageNeeded(int size) {
        //Each page is of 128 Byte
        int mod = size % 128;

        if (mod == 0) {
            int multiple = size/128;

            return multiple;
        }
        else if (size < 128) return 1;
        else if (mod != 0) {
            int multiple = size/128;
            return multiple;
        }
        return 0;
    }



    public void segmentTable() {
        int codeSegmentSize = code.length;
        int dataSegmentSize = data.length;


    }


        public static void main(String[] args) {
                  ProcessCreation pc = new ProcessCreation();
                  pc.readFile("flags");
        }
    }

