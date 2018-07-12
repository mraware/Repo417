package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


import com.revature.beans.Instruction;
import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;


@Component
public class InstructionHibernateDAO implements InstructionDAO, HibernateSession {
	private volatile Session session;
	Logger log = Logger.getLogger(InstructionHibernateDAO.class);

	@Override
	public Instruction addInstruction(Instruction instruction) {
		log.debug("Adding instruction " + instruction);
		session.save(instruction);
		return instruction;
		
	}

	@Override
	public Instruction getInstructionById(int id) {
		return (Instruction) session.get(Instruction.class, id);
	}

	@Override
	public Instruction updateInstruction(Instruction instruction) {
		session.update(instruction);
		return instruction;
		
	}

	@Override
	public void deleteInstruction(Instruction instruction) {
		session.delete(instruction);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Instruction> getInstructionsByRecipe(Recipe r) {
		Query<Instruction> query = session.createQuery("From com.revature.beans.Instruction i where i.recipe=:r");
		query.setParameter("r", r);
		return (List<Instruction>) query.list();
	}

}
