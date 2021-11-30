public class SpecialPurposeRegister {

    /*
     * code base first instruction
     * code counter last instruction
     *
     */


    byte[] SPR = new byte[16];
    Memory memory = Memory.createMemoryReadDisplay(true,false);


    public static SpecialPurposeRegister createSPR(boolean isDisplay) {
        if (!isDisplay) return new SpecialPurposeRegister();
        else return new SpecialPurposeRegister(true);
    }


    private SpecialPurposeRegister() {

    }

    private SpecialPurposeRegister(boolean isDisplay) {
        SPR[0] = 0;
        for (int i = 1; i < SPR.length; i++) {
            SPR[i] = 0;
        }
        /*
         *SPR[9] is Program Counter
         *Initially it will point to index 0
         */
        SPR[9] = 0;

        /*
         *SPR[10] is Instruction Register
         *Initially IR will have data at index 0
         */
        SPR[10] = (byte) memory.getMemoryByte(SPR[9]);

        if (isDisplay) displaySPR();

    }

    public void setProgramCounter(int position) {
        SPR[9] = (byte) position;
    }

    public short getProgramCounter() {
        return SPR[9];
    }

    public void incrementProgramCounter() {
        SPR[9]++;
    }

    public void setInstructionRegister(byte value) {
        SPR[10] = value;
    }

    public byte getInstructionRegister() {
        return (byte) SPR[10];
    }

    public void incrementInstructionRegister(int times) {
        if (times == 4) {
            for (int i = 0; i < times; i++)
                SPR[10]++;
        }
        if (times == 1) SPR[10]++;
    }


    //DisplaySPR
    public void displaySPR() {
        System.out.println("--------Special Purpose Register----------");
        for (int i = 0; i < SPR.length; i++) {

            switch (i) {
                case 0:
                    System.out.print("Value at CodeBase: ");
                    System.out.println(SPR[i]);
                    break;
                case 1:
                    System.out.print("Value at CodeLimit: ");
                    System.out.println(SPR[i]);
                    break;
                case 2:
                    System.out.print("Value at CodeCounter: ");
                    System.out.println(SPR[i]);
                    break;
                case 3:
                    System.out.print("Value at DataBase: ");
                    System.out.println(SPR[i]);
                    break;
                case 4:
                    System.out.print("Value at DataLimit: ");
                    System.out.println(SPR[i]);
                    break;
                case 5:
                    System.out.print("Value at DataCounter: ");
                    System.out.println(SPR[i]);
                    break;
                case 6:
                    System.out.print("Value at StackBase: ");
                    System.out.println(SPR[i]);
                    break;
                case 7:
                    System.out.print("Value at StackCounter: ");
                    System.out.println(SPR[i]);
                    break;
                case 8:
                    System.out.print("Value at StackLimit: ");
                    System.out.println(SPR[i]);
                    break;
                case 9:
                    System.out.print("Value at ProgramCounter: ");
                    System.out.println(SPR[i]);
                    break;
                case 10:
                    System.out.print("Value at InstructionRegister: ");
                    System.out.println(SPR[10]);
                    break;
            }
        }
    }

}
