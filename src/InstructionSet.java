public class InstructionSet {
    //Methods of InstructionSet
    //opcode =16
    public void MOV(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 23);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        gpr.insertGPR((short) (contentofRegister2), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    //At Opcode = 17 - Reg to Reg Add
    public void ADD(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 23);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        gpr.insertGPR((short) (contentOfRegister1 + contentofRegister2), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    //Opcode = 18
    public void SUB(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 23);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        gpr.insertGPR((short) (contentOfRegister1 - contentofRegister2), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();

    }

    //opcode = 19
    public void MUL(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 25);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        gpr.insertGPR((short) (contentOfRegister1 * contentofRegister2), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    //opcode = 1A
    public void DIV(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 23);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        gpr.insertGPR((short) (contentOfRegister1 / contentofRegister2), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    //1b
    public void AND(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 27);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        int anned = contentOfRegister1 & contentofRegister2;

        gpr.insertGPR((short) (anned), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    //1c
    public void OR(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 28);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int reg2 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        //fetch from gpr
        int contentOfRegister1 = gpr.GPR[reg1];
        int contentofRegister2 = gpr.GPR[reg2];

        int orred = contentOfRegister1 | contentofRegister2;

        gpr.insertGPR((short) (orred), reg1);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    //30
    public void MOVI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        //R1 <-- num
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        gpr.insertGPR((short) ((short) content1 + content2), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void ADDI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 31
        //R1 <-- R1 + num
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        gpr.insertGPR((short) ((short) R1 + num), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void SUBI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 32
        //R1 <-- R1 - num
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        gpr.insertGPR((short) ((short) R1 - num), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void MULI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 33
        //R1 <-- R1 * num
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        gpr.insertGPR((short) ((short) R1 * num), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void DIVI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 34
        //R1 <-- R1 / num
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        gpr.insertGPR((short) ((short) R1 / num), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }


    //35
    public void ANDI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        //R1 <-- R1 && num
        //
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;

        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        R1 = R1 & num;
        gpr.insertGPR((short) ((short) (R1)), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    //36
    public void ORI(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        //R1 <-- R1 && num
        //
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int num = content1 + content2;

        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        R1 = R1 | num;
        gpr.insertGPR((short) ((short) (R1)), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    //51
    public void MOVL(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        //Load Reg <--- mem[database +imm]
        //81,1,0,5
        //reg1 <-- mem[database+5]
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int imm = content1 + content2;
        //load from memory into gpr
        gpr.insertGPR(((short) mem.memory[spr.SPR[3] + imm]), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();

    }

    public void MOVR(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        //Store memory [ data.base + imm]  Register
        //82,1,0,5

        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content1 = mem.memory[spr.getProgramCounter()];
        spr.incrementProgramCounter();
        int content2 = mem.memory[spr.getProgramCounter()];
        int imm = content1 + content2;
        //store in memory from gpr
        mem.memory[spr.SPR[3] + imm] = (byte) gpr.getGPR(regIndex);

        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();

    }


    //71
    public void SHL(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 113);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg = mem.memory[spr.getProgramCounter()];
//110
        //1100

        //move left every bit = number multiply by two
        String num = Integer.toBinaryString(gpr.GPR[reg]);
        num = num + "0";
        gpr.insertGPR((byte) Integer.parseInt(num, 2), reg);
        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    public void RTL(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 115);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg = mem.memory[spr.getProgramCounter()];
        String data = Integer.toBinaryString(gpr.GPR[reg]);

        String firstChar = data.substring(0, 1);
        //110
        //101

        //lmb is shifted to rmb
        //move every bit to left to make space for lmb which is shifted to rightmostbit
        String newStr = "";
        for (int i = 1; i < data.length(); i++) {
            newStr = newStr + data.charAt(i);
        }

        String finalStr = newStr + firstChar;
        int len = data.length();
        int count = 0;
        gpr.insertGPR((byte) Integer.parseInt(finalStr, 2), reg);
        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    public void RTR(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 116);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        //110
        //011

        //rmb in lmb

        int reg = mem.memory[spr.getProgramCounter()];
        String data = Integer.toBinaryString(gpr.GPR[reg]);
        int len = data.length();
        String last = data.substring(len - 1, len);
        String newStr = "";
        for (int i = 0; i < data.length() - 1; i++) {
            newStr = newStr + data.charAt(i);
        }
        String val = last + newStr;
        //int decimal = Integer.parseInt(val, 2);
        gpr.insertGPR((byte) Integer.parseInt(val, 2), reg);
        spr.displaySPR();


        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    public void SHR(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        spr.setInstructionRegister((byte) 115);
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int reg = mem.memory[spr.getProgramCounter()];
        //0111
        //0011

        //shift every bit right
        //divide by 2
        String num = Integer.toBinaryString(gpr.GPR[reg]);
        num = "0" + num;

        int len = num.length();
        String no = num.substring(0, len - 1);
        //int data = Integer.parseInt(no, 2);
        gpr.insertGPR((byte) Integer.parseInt(no, 2), reg);
        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();
    }

    public void INC(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 75
        //R1 <-- R1 + 1
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        R1 = R1 + 1;
        gpr.insertGPR((short) ((short) (R1)), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void DEC(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: 76
        //R1 <-- R1 - 1
        //spr.setInstructionRegister((byte) mem.HexToDec("48"));
        spr.setProgramCounter(position);
        spr.incrementProgramCounter();
        int regIndex = mem.memory[spr.getProgramCounter()];
        //fetch from gpr
        int R1 = gpr.GPR[regIndex];
        R1 = R1 - 1;
        gpr.insertGPR((short) ((short) (R1)), regIndex);


        spr.displaySPR();
        System.out.println("-----UPDATED-----");
        gpr.displayRegister();


    }

    public void END(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: F3
        //R1 <-- Terminate process
        System.exit(1);
    }

    public void NOOP(Memory mem, GeneralPurposeRegister gpr, SpecialPurposeRegister spr, int position) {
        // Opcode: F2
        //R1 <-- No Operation
    }

}
