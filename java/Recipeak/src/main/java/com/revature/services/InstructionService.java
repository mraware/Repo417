package com.revature.services;

import java.util.List;
import com.revature.beans.Instruction;
import com.revature.beans.Recipe;

public interface InstructionService {
	public List<Instruction> getInstructionsByRecipe(Recipe r); 

}
