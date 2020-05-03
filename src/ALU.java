public class ALU {
	private static int Operand1;
	private static int Operand2;
	private static int Zero;
	private static int result;

	public static int[] Operate(int ALUOP, int Op1, int Op2) {
		Operand1 = Op1;
		Operand2 = Op2;
		switch (ALUOP) {
		case 0:
			sub();
			break;
		case 1:
			add();
			break;
		case 2:
			mult();
			break;
		case 3:
			OR();
			break;
		case 4:
			AND();
			break;
		case 5:
			shiftLeft();
			break;
		case 6:
			shiftRight();
			break;
		case 7:
			setOnLessThan();
			break;

		}
		Zero = result == 0 ? 1 : 0;
		int[] res = {result, Zero};
		return res;
	}

	private static void add() {
		result = Operand1 + Operand2;
	}

	private static void sub() {
		result = Operand1 - Operand2;
	}

	private static void mult() {
		result = Operand1 * Operand2;
	}

	private static void OR() {
		result = Operand1 | Operand2;
	}

	private static void AND() {
		result = Operand1 & Operand2;
	}

	private static void shiftLeft() {
		result = Operand1 << Operand2;
	}

	private static void shiftRight() {
		result = Operand1 >> Operand2;
	}

	private static void setOnLessThan() {
		result = Operand1 < Operand2 ? 1 : 0;
	}

//	public static int getResult() {
//		return result;
//	}
//
//	public static int isZero() {
//		return Zero;
//	}
}