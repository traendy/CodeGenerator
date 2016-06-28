package gen;

import CPP.*;
import CPP.Absyn.*;

/**
 * evalute the R and A
 * @author soenke
 *
 */


public class CompileStm implements Stm.Visitor<String, String>{
/**
 * a lot of functions which are mostly similar to themselfs and compileExp funtctions
 * String work 
 */
	@Override
	public String visit(SExp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SExp");

		Compiler.eval(p.exp_);
		return null;
	}

	
	/**
	 * Todo Special case
	 */
	@Override
	public String visit(SDecls p, String arg) {
		System.out.println("Visit SDecls");
		//for(int i =0; i< p.listid_.size(); i++)
		//Compiler.eval(p.listid_.get(i));
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SInit p, String arg) {
		System.out.println("Visit SInit");
		// TODO Auto-generated method stub
		Module.buildString("%" + p.id_);
		Module.buildString(" " + " = " + " ");
		Module.buildString("alloca ");
		Module.getType(p.type_.toString());
		Module.buildString(", allign 4 \n");
		Module.buildString("store i32 ");
		Module.lastId = p.id_;	
		Compiler.eval(p.exp_);
		Module.buildString(". allign 4");
		return null;
	}

	@Override
	public String visit(SReturn p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SReturn");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public String visit(SReturnVoid p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SReturnVoid");
		return null;
	}

	@Override
	public String visit(SWhile p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit SWhile");
		
		Module.buildString("%condition =");
		Compiler.eval(p.exp_);
		Module.buildString("\nbr " + "while1 %condition, label %cond_true, label %cond_false\n" );
		Module.buildString("cond_true: \n");
		Compiler.eval(p.stm_);
		Module.buildString("cond_false: ");
		return null;
	}

	@Override
	public String visit(SBlock p, String arg) {
		System.out.println("Visit SBlock");
		// TODO Auto-generated method stub
		for(int i=0; i<p.liststm_.size(); i++){
			Compiler.eval(p.liststm_.get(i));
			
		}
		
		return null;
	}

	@Override
	public String visit(SIfElse p, String arg) {
		
		System.out.println("Visit SIfElse");
		Compiler.eval(p.exp_);
		Compiler.eval(p.stm_1);
		Compiler.eval(p.stm_2);
		return null;
	}

}
