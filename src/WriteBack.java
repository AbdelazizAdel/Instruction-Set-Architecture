
public class WriteBack {
	
	public static void writeBack(String write_reg, int data, int OPCode) {
		int[] controlSignals = ControlUnit.generateControlSignals(OPCode);
		int memToReg = controlSignals[1];
		System.out.printf("WriteBack\n\n");
		if(memToReg == 0) {
			return;
		}
		RegisterFile.writeIntoRegister(Integer.parseInt(write_reg, 2), data);
	}
}
