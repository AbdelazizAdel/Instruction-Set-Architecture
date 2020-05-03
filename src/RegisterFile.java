
public class RegisterFile {
	private static int[] registers;
	
	public RegisterFile() {
		registers = new int[32];
	}
	
	public static int getRegisterValue(int reg_num) {
		return registers[reg_num];
	}
	
	public static void writeIntoRegister(int reg_num, int data) {
		registers[reg_num] = data;
	}
	
	public void fillRegisterFile() {
		for(int i = 1; i < 32; i++)
			registers[i] = (int) (Math.random()*101);
	}
	
	public static void printRegisters() {
		String res = "[";
		for(int i = 0; i < 32; i++)
			res+=registers[i]+(i==31?"]":", ");
		System.out.println(res);
	}
}
