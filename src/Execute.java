
public class Execute {
	
	public static int[] execute(int readData1, int readData2, int immediate_extended, int OPCode, int write_reg) {
		int[] controlSignals = ControlUnit.generateControlSignals(OPCode);
		int op2 = controlSignals[2]==0?readData2:immediate_extended;
		int[] res = ALU.Operate(controlSignals[7], readData1, op2);
		System.out.printf("Execute:"
				+ "\nZero flag: %d"
				+ "\nBranch address: %d"
				+ "\nJump address: %d"
				+ "\nALU result/address: %d"
				+ "\nRegister value to write to memory: %d"
				+ "\nrt/rd register: %d"
				+ "\nWB controls: MemToReg: %d, RegWrite: %d"
				+ "\nMEM controls: MemRead: %d, MemWrite: %d, Branch: %d, Jump: %d\n\n",
				res[1], immediate_extended, readData1, res[0], readData2, write_reg, controlSignals[6], 
				controlSignals[1], controlSignals[4], controlSignals[5], controlSignals[3],
				controlSignals[8]);
		
		return res;
	}
}
