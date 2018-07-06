package com.revature.data;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.revature.beans.Instruction;


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

}
