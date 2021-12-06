public class GeneralPurposeRegister {
    //Store executed instruction

    short[] GPR = new short[16];
    Memory memory = Memory.getInstance(false,false);
    Memory memoryWithRead = Memory.getInstance(true,false);
    SpecialPurposeRegister spr = SpecialPurposeRegister.getInstance(false);

    static private GeneralPurposeRegister instance;




    GeneralPurposeRegister() {
        for (int i = 0; i < GPR.length; i++) {
            GPR[i] = 0;
        }
        GPR[1] = 10;
        GPR[2] = 10;
    }

    public static GeneralPurposeRegister getInstance(boolean isDisplay) {
        if(instance==null) {
            if (isDisplay) instance = new GeneralPurposeRegister(isDisplay);
            instance = new GeneralPurposeRegister(!isDisplay);
        }
        return instance;
    }

    GeneralPurposeRegister(boolean displaying) {
        for (int i = 0; i < GPR.length; i++) {
            GPR[i] = 0;
        }
        GPR[1] = 10;
        GPR[2] = 10;

        if (displaying) displayRegister();
    }


    //displayInHex
    public void displayRegister() {
        System.out.println("-----GPR REGISTERS------");
        for (int i = 0; i < GPR.length; i++) {
            System.out.print("GPR Register " + i + ": ");
            System.out.println(GPR[i]);
        }
    }

    //read from memory
    public void updateGPR() {
        InstructionSet instructionSet = new InstructionSet();
        String[] hexInstruction = memory.getHexInstr(true);
        for (int i = 0; i < hexInstruction.length && hexInstruction[i] != null; i++) {
            switch (hexInstruction[i]) {
                case "16":
                    spr.setInstructionRegister((byte) 22);
                    instructionSet.MOV(memoryWithRead, GeneralPurposeRegister.getInstance(false), spr, i);
                    break;
                //ADD Reg-Reg
                case "17":
                    spr.setInstructionRegister((byte) 23);
                    instructionSet.ADD(memoryWithRead, GeneralPurposeRegister.getInstance(false), spr, i);
                    break;
                case "18":
                    spr.setInstructionRegister((byte) 24);
                    instructionSet.SUB(memoryWithRead, GeneralPurposeRegister.getInstance(false), spr, i);
                    break;
                case "19":
                    spr.setInstructionRegister((byte) 25);
                    instructionSet.MUL(memoryWithRead, GeneralPurposeRegister.getInstance(false), spr, i);
                    break;
                case "1a":
                    spr.setInstructionRegister((byte) 26);
                    instructionSet.DIV(memoryWithRead, GeneralPurposeRegister.getInstance(false), spr, i);
                    break;
                case "1b":
                    spr.setInstructionRegister((byte) 27);
                    instructionSet.AND(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "1c":
                    spr.setInstructionRegister((byte) 28);
                    instructionSet.OR(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "30":
                    spr.setInstructionRegister((byte) 48);
                    instructionSet.MOVI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "31":
                    spr.setInstructionRegister((byte) 49);
                    instructionSet.ADDI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "32":
                    spr.setInstructionRegister((byte) 50);
                    instructionSet.SUBI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "33":
                    spr.setInstructionRegister((byte) 51);
                    instructionSet.MULI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "34":
                    spr.setInstructionRegister((byte) 52);
                    instructionSet.DIVI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "35":
                    spr.setInstructionRegister((byte) 53);
                    instructionSet.ANDI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "36":
                    spr.setInstructionRegister((byte) 54);
                    instructionSet.ORI(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                    /*
                case "37":
                    spr.setInstructionRegister((byte) 55);
                    instructionSet.MOVI(new Memory(true,false),GeneralPurposeRegister.getInstance(true),spr,i);
                    break;
                case "38":
                    spr.setInstructionRegister((byte) 56);
                    instructionSet.MOVI(new Memory(true,false),GeneralPurposeRegister.getInstance(true),spr,i);
                    break;
                case "39":
                    spr.setInstructionRegister((byte) 57);
                    instructionSet.MOVI(new Memory(true,false),GeneralPurposeRegister.getInstance(true),spr,i);
                    break;
*/
                case "51":
                    spr.setInstructionRegister((byte) 81);
                    instructionSet.MOVL(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "52":
                    spr.setInstructionRegister((byte) 82);
                    instructionSet.MOVR(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                //Single Operand
                case "71":
                    spr.setInstructionRegister((byte) 113);
                    instructionSet.SHL(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "72":
                    spr.setInstructionRegister((byte) 114);
                    instructionSet.SHR(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "73":
                    spr.setInstructionRegister((byte) 115);
                    instructionSet.RTL(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "74":
                    spr.setInstructionRegister((byte) 116);
                    instructionSet.RTR(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "75":
                    spr.setInstructionRegister((byte) 117);
                    instructionSet.INC(memoryWithRead, GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "76":
                    spr.setInstructionRegister((byte) 118);
                    instructionSet.DEC(Memory.getInstance(true,false), GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "f2":
                    spr.setInstructionRegister((byte) 242);
                    instructionSet.NOOP(Memory.getInstance(true,false), GeneralPurposeRegister.getInstance(true), spr, i);
                    break;
                case "f3":
                    spr.setInstructionRegister((byte) 243);
                    instructionSet.END(Memory.getInstance(true,false), GeneralPurposeRegister.getInstance(true), spr, i);
                    break;


            }


        }

    }

    //Insert in GPR
    public void insertGPR(short data, int index) {
        GPR[index] = data;
    }

    //Get from GPR
    public short getGPR(int index) {
        return GPR[index];
    }

}
