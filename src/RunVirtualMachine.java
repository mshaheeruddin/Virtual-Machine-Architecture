public class RunVirtualMachine {
    public static void main(String[] args) {
        Memory memory = Memory.createMemory();
        GeneralPurposeRegister gpr = GeneralPurposeRegister.getInstance(false);
        gpr.updateGPR();
        SpecialPurposeRegister spr = SpecialPurposeRegister.getInstance(false);
        //InstructionSet ir = new InstructionSet();
        //gpr.displayRegister();
        //spr.displaySPR();



        //spr.displaySPR();


    }

}
