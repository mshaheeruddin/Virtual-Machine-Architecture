public class RunVirtualMachine {
    public static void main(String[] args) {
        Memory memory = new Memory();
        GeneralPurposeRegister gpr = new GeneralPurposeRegister(false);
        gpr.updateGPR();
        SpecialPurposeRegister spr = new SpecialPurposeRegister(false);
        //InstructionSet ir = new InstructionSet();
        //gpr.displayRegister();
        //spr.displaySPR();



        //spr.displaySPR();


    }

}