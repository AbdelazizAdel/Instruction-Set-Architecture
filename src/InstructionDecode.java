
public class InstructionDecode {
	
	public static String signExtend(String immediate) {
		String signBit = immediate.charAt(0)+"";
		while(immediate.length() < 32)
			immediate = signBit + immediate;
		return immediate;
	}
	
	public static int[] contUnit(int i) {
		return ControlUnit.generateControlSignals(i);
	}
	
	public static int[] instDecode(String ins) {
		String OPCode = ins.substring(0, 4), rs = ins.substring(22, 27), rt = ins.substring(27), rd = ins.substring(17, 22);
		String shamt = ins.substring(4, 17), immediate = signExtend(ins.substring(4, 22));
		
		int[] controlSignals = contUnit(Integer.parseInt(OPCode, 2));
		int immediate_int = (int) Long.parseLong(immediate, 2);
		int readData1 = RegisterFile.getRegisterValue(Integer.parseInt(rs, 2));
		int readData2 = RegisterFile.getRegisterValue(Integer.parseInt(rt, 2));
		int write_reg = controlSignals[0]==0?Integer.parseInt(rt, 2):Integer.parseInt(rd, 2);
		int[] res = {readData1, readData2, immediate_int, write_reg, Integer.parseInt(OPCode, 2)};
		System.out.printf("Instruction decode:"
				+ "\nread data 1: %d"
				+ "\nread data 2: %d"
				+ "\nsign-extend: %s"
				+ "\nNext PC: %d"
				+ "\nrs: %s"
				+ "\nrt: %s"
				+ "\nrd: %s"
				+ "\nWB controls: MemToReg: %d, RegWrite: %d"
				+ "\nMEM controls: MemRead: %d, MemWrite: %d, Branch: %d, Jump: %d"
				+ "\nEX controls: RegDest: %d, ALUOp: %d, ALUSrc: %d\n\n", readData1, readData2,
				immediate, ProgramCounter.getPC(), rs, rt, (controlSignals[0] == 0?"don't care":rd),
				controlSignals[6], controlSignals[1], controlSignals[4], controlSignals[5], controlSignals[3],
				controlSignals[8], controlSignals[0], controlSignals[7], controlSignals[2]);
		
		return res;
	}
}
