
public class MemoryAccess {
	private static Cache cache = new Cache();
	public static int memAccess(int idx, int readData2, int ALUResult, int OPCode, int write_reg) {
		int[] controlSignals = ControlUnit.generateControlSignals(OPCode);
		int memRead = controlSignals[4], memWrite = controlSignals[5];
		int writeData = controlSignals[6] == 0?ALUResult:readData2;
		System.out.printf("Memory access:"
				+ "\nALU result: %d"
				+ "\nmemory word read: %s"
				+ "\nrt/rd field: %d"
				+ "\nWB controls: MemToReg: %d, RegWrite: %d\n\n",
				ALUResult, (memRead == 0?"don't care":cache.read(idx, 1)),
				write_reg, controlSignals[6], controlSignals[1]);
		if(memRead == 0 && memWrite == 1)
			return cache.writeMem(idx, writeData, 1);
		else if(memRead == 1 && memWrite == 0)
			return cache.read(idx, 1);
		return -1;
	}
}
