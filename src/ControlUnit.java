
public class ControlUnit {
	private static int RegDst, RegWrite, ALUSrc, Branch, MemRead, MemWrite, MemToReg, ALUOp, Jump;
	
	public static int[] generateControlSignals(int OPCode) {
		switch(OPCode) {
		case 0: //Sub
			RegDst = 1;RegWrite = 1;ALUSrc = 0;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 0;
			break;
		case 1: //Add
			RegDst = 1;RegWrite = 1;ALUSrc = 0;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 1;
			break;
		case 2: //Add immediate
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 1;
			break;
		case 3: //Multiply
			RegDst = 1;RegWrite = 1;ALUSrc = 0;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 2;
			break;
		case 4: //Or
			RegDst = 1;RegWrite = 1;ALUSrc = 0;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 3;
			break;
		case 5: //And immediate
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 4;
			break;
		case 6: //Shift right logical
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 6;
			break;
		case 7: //Shift left logical
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 5;
			break;
		case 8: //Load word
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 1;MemWrite = 0;MemToReg = 1;Jump = 0;ALUOp = 1;
			break;
		case 9: //Store word
			RegDst = 0;RegWrite = 0;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 1;MemToReg = 0;Jump = 0;ALUOp = 1;
			break;
		case 10: //Branch on equal
			RegDst = 0;RegWrite = 0;ALUSrc = 0;Branch = 1;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 0;
			break;
		case 11: //Branch on less than
			RegDst = 0;RegWrite = 0;ALUSrc = 0;Branch = 1;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 0;
			break;
		case 12: //Set on less than immediate
			RegDst = 0;RegWrite = 1;ALUSrc = 1;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 0;ALUOp = 7;
			break;
		case 13: //Jump register
			RegDst = 0;RegWrite = 0;ALUSrc = 0;Branch = 0;
			MemRead = 0;MemWrite = 0;MemToReg = 0;Jump = 1;ALUOp = 0;
			break;
		}
	int[] res = {RegDst, RegWrite, ALUSrc, Branch, MemRead, MemWrite, MemToReg, ALUOp, Jump};
	return res;
	}
}