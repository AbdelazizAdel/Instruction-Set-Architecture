
public class Main {
	public static void main(String[] args) {
		InstructionMemory instructionMemory = new InstructionMemory(6);
		instructionMemory.fillMem();
		MemoryAccess memoryAccess = new MemoryAccess();
		RegisterFile registerFile = new RegisterFile();
		registerFile.fillRegisterFile();
		for(int i = 0; i < 6; i++) {
			registerFile.printRegisters();
			System.out.println("After clock cycle " + i +"\n");
			String ins = InstructionFetch.instFetch(ProgramCounter.getPC());
			int[] ins_decode = InstructionDecode.instDecode(ins);
			int readData1 = ins_decode[0], readData2 = ins_decode[1], immediate = ins_decode[2];
			int write_reg = ins_decode[3], OPCode = ins_decode[4];
			int[] aluOutput = Execute.execute(readData1, readData2, immediate, OPCode, write_reg);
			int[] control_signals = ControlUnit.generateControlSignals(OPCode);
			if(control_signals[3] == 1 && aluOutput[1] == 1)
				ProgramCounter.setPC(immediate);
			else if(control_signals[8] == 1)
				ProgramCounter.setPC(readData1);
			int wordRead = MemoryAccess.memAccess(aluOutput[0], readData2, aluOutput[0], OPCode, write_reg);
			int writeData = control_signals[6] == 0?aluOutput[0]:wordRead;
			WriteBack.writeBack(Integer.toBinaryString(write_reg), writeData, OPCode);
			System.out.println("-----------------------------------------------------------");
		}
		
	}
}
