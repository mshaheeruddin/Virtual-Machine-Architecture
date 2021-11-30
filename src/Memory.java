import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Memory {



    //array of memory 64000 size type is byte
    //Memory array
    public byte[] memory = new byte[65536];
    //Code counter initially at 0
    private int codeCounter = 0;
    //hex array
    String[] hexInstr = new String[12];



    public static Memory createMemory() {
        return new Memory();
    }

    public static Memory createMemoryReadDisplay(boolean isRead, boolean isDisplay) {
        return new Memory(isRead,isDisplay);
    }






    private Memory() {
        readFile();
        displayMemory();

    }

    private Memory(boolean fileReading, boolean displayingMemoryArray) {
        if (fileReading) readFile();
        if (displayingMemoryArray) displayMemory();
    }
    //File Reading
    public void readFile() {
        try {
            File myFile = new File("C:\\Users\\Muhammad Shaheer\\Desktop\\IBA\\Fifth Semester\\OS\\ProjectPhase1\\src\\p1.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(",");
                for (String token : result) {
                    //Allocating data into memory
                    memory[codeCounter] = (byte) Integer.parseInt(token);
                    codeCounter++;
                }
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //get memory content as hexadecimal array converted from decimal
    public String[] getHexInstr(boolean readingFile) {
        if (readingFile) readFile();
        String[] check = DecToHex(memory);
        return check;
    }


//Convert to hex (Array version)

    public String[] DecToHex(byte memory[]) {
        int counter = 0;
        for (byte aByte : memory) {
            hexInstr[counter] = String.format("%02x", aByte);
            counter++;
            if (codeCounter == counter) break;
        }
        return hexInstr;
    }

    //DexToHex One value

    public String DecToHex(byte memory) {
        int res = memory & 0xFF;
        Integer.toHexString(res);
        return Integer.toHexString(res);
    }

    //HexToDex

    public int HexToDec(String memory) {
        int decimal = 0;
        try {
            decimal = Integer.parseInt(String.valueOf(memory.charAt(0) + memory.charAt(1)), 16);
        } catch (NullPointerException e) {

        }

        return decimal;
    }

    //get memory data at index
    public int getMemoryByte(int index) {
        return memory[index];
    }

//get hex value at index
    public String getHexValue(int index) {
        return hexInstr[index];
    }

    //get code counter
    public int getCodeCounter() {
        return codeCounter;
    }

    public void displayMemory() {
        System.out.println("--------MEMORY-----------");
        for (int i = 0; i < memory.length; i++) {
            System.out.print("Memory at index  " + i + ": ");
            System.out.println(memory[i]);
            if (memory[i] == -13) break;
        }
    }


}

