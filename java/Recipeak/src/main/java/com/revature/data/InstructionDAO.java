package com.revature.data;

import java.util.List;

import com.revature.beans.Instruction;
import com.revature.beans.Recipe;

public interface InstructionDAO {
	public Instruction addInstruction(Instruction instruction);
	public Instruction getInstructionById(int id);
	public Instruction updateInstruction(Instruction instruction);
	public void deleteInstruction(Instruction instruction);
	public List<Instruction> getInstructionsByRecipe(Recipe r);
}
