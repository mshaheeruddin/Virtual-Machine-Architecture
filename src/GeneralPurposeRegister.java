public class GeneralPurposeRegister {
    //Store executed instruction

    short[] GPR = new short[16];
    Memory memory = new Memory(false, false);
    SpecialPurposeRegister spr = new SpecialPurposeRegister(false);

    GeneralPurposeRegister() {
        for (int i = 0; i < GPR.length; i++) {
            GPR[i] = 0;
        }
        GPR[1] = 10;
        GPR[2] = 10;
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
                    instructionSet.MOV(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(false), new SpecialPurposeRegister(false), i);
                    break;
                //ADD Reg-Reg
                case "17":
                    spr.setInstructionRegister((byte) 23);
                    instructionSet.ADD(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(false), new SpecialPurposeRegister(false), i);
                    break;
                case "18":
                    spr.setInstructionRegister((byte) 24);
                    instructionSet.SUB(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(false), new SpecialPurposeRegister(false), i);
                    break;
                case "19":
                    spr.setInstructionRegister((byte) 25);
                    instructionSet.MUL(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(false), new SpecialPurposeRegister(false), i);
                    break;
                case "1a":
                    spr.setInstructionRegister((byte) 26);
                    instructionSet.DIV(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(false), new SpecialPurposeRegister(false), i);
                    break;
                case "1b":
                    spr.setInstructionRegister((byte) 27);
                    instructionSet.AND(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "1c":
                    spr.setInstructionRegister((byte) 28);
                    instructionSet.OR(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "30":
                    spr.setInstructionRegister((byte) 48);
                    instructionSet.MOVI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "31":
                    spr.setInstructionRegister((byte) 49);
                    instructionSet.ADDI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "32":
                    spr.setInstructionRegister((byte) 50);
                    instructionSet.SUBI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "33":
                    spr.setInstructionRegister((byte) 51);
                    instructionSet.MULI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "34":
                    spr.setInstructionRegister((byte) 52);
                    instructionSet.DIVI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "35":
                    spr.setInstructionRegister((byte) 53);
                    instructionSet.ANDI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "36":
                    spr.setInstructionRegister((byte) 54);
                    instructionSet.ORI(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                    /*
                case "37":
                    spr.setInstructionRegister((byte) 55);
                    instructionSet.MOVI(new Memory(true,false),new GeneralPurposeRegister(true),new SpecialPurposeRegister(false),i);
                    break;
                case "38":
                    spr.setInstructionRegister((byte) 56);
                    instructionSet.MOVI(new Memory(true,false),new GeneralPurposeRegister(true),new SpecialPurposeRegister(false),i);
                    break;
                case "39":
                    spr.setInstructionRegister((byte) 57);
                    instructionSet.MOVI(new Memory(true,false),new GeneralPurposeRegister(true),new SpecialPurposeRegister(false),i);
                    break;
*/
                case "51":
                    spr.setInstructionRegister((byte) 81);
                    instructionSet.MOVL(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "52":
                    spr.setInstructionRegister((byte) 82);
                    instructionSet.MOVR(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                //Single Operand
                case "71":
                    spr.setInstructionRegister((byte) 113);
                    instructionSet.SHL(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "72":
                    spr.setInstructionRegister((byte) 114);
                    instructionSet.SHR(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "73":
                    spr.setInstructionRegister((byte) 115);
                    instructionSet.RTL(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "74":
                    spr.setInstructionRegister((byte) 116);
                    instructionSet.RTR(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "75":
                    spr.setInstructionRegister((byte) 117);
                    instructionSet.INC(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "76":
                    spr.setInstructionRegister((byte) 118);
                    instructionSet.DEC(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "f2":
                    spr.setInstructionRegister((byte) 242);
                    instructionSet.NOOP(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
                    break;
                case "f3":
                    spr.setInstructionRegister((byte) 243);
                    instructionSet.END(Memory.createMemoryReadDisplay(true,false), new GeneralPurposeRegister(true), new SpecialPurposeRegister(false), i);
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
