package com.revature.data;

import com.revature.beans.Instruction;

public interface InstructionDAO {
	public Instruction addInstruction(Instruction instruction);
	public Instruction getInstructionById(int id);
	public Instruction updateInstruction(Instruction instruction);
	public void deleteInstruction(Instruction instruction);
}
