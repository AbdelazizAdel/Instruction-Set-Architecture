
public class InstructionMemory {
	private static int size;
	private static String[] mem;
	
	public InstructionMemory(int s) {
		size = s;
		mem = new String[size];
	}
	
	public static int getSize() {
		return size;
	}

	public static void writeInstruction(int idx, String ins) {
		mem[idx] = ins;
	}
	
	public static String getInstruction(int addr) {
		return mem[addr];
	}
	
	public void fillMem() {
		writeInstruction(0, "00010000000000000000110000100010");
		writeInstruction(1, "01011111111111111111110010100011");
		writeInstruction(2, "10010000000000000011110011000100");
		writeInstruction(3, "10000000000000000011110011000100");
		writeInstruction(4, "10110000000011111111110101000000");
		writeInstruction(5, "11010000000000000000000111100000");
	}
}
