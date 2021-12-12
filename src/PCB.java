import java.util.HashMap;

public class PCB {
    public String processID;
    public int processPriority;
    public int codeSegmentSize;
    public int dataSegmentSize;
    public int processSize;
    public String fileName;
    GeneralPurposeRegister gpr;
    SpecialPurposeRegister spr;
    HashMap<Integer,Integer> pageTable = new HashMap<>();

    PCB (String processID,int processPriority,int codeSegmentSize
        ,int dataSegmentSize,String fileName,GeneralPurposeRegister gpr,
         SpecialPurposeRegister spr,HashMap pageTable
         ) {
         this.processID = processID;
         this.processPriority = processPriority;
         this.codeSegmentSize = codeSegmentSize;
         this.dataSegmentSize = dataSegmentSize;
         this.processSize = codeSegmentSize+dataSegmentSize;
         this.fileName = fileName;
         this.gpr = gpr;
         this.spr = spr;
         this.pageTable = pageTable;
    }

}