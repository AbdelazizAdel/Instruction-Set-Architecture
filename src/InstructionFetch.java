
public class InstructionFetch {
	
	public static void progCount() {
		ProgramCounter.setPC(ProgramCounter.getPC()+1);
	}
	
	public static String instFetch(int pc) {
		String ins = InstructionMemory.getInstruction(pc);
		progCount();
		System.out.printf("Instruction Fetch:\nNext PC: %d\nInstruction: %s\n\n", ProgramCounter.getPC(), ins);
		return ins;
	}
}
