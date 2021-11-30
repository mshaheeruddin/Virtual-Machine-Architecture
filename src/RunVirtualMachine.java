public class RunVirtualMachine {
    public static void main(String[] args) {
        Memory memory = Memory.createMemory();
        GeneralPurposeRegister gpr = GeneralPurposeRegister.createGPR(false);
        gpr.updateGPR();
        SpecialPurposeRegister spr = SpecialPurposeRegister.createSPR(false);
        //InstructionSet ir = new InstructionSet();
        //gpr.displayRegister();
        //spr.displaySPR();



        //spr.displaySPR();


    }

}
