package gen;
import CPP.*;
import CPP.Absyn.*;

import org.jllvm.LLVMConstant;
import org.jllvm.LLVMConstantInteger;
import org.jllvm.LLVMInstructionBuilder;
import org.jllvm.LLVMValue;


/**
 * Find the R, and A attributes I dont know them now
 * @author soenke
 *
 */
public class CompileExp implements Exp.Visitor<LLVMValue, String>{
/**
 * Most of the functions are her always return the appended string that schould be it
 */
	
	
	@Override
	public LLVMValue visit(ETrue p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETrue");
		
		return null;
	}

	@Override
	public LLVMValue visit(EFalse p, String arg) {
		System.out.println("Visit EFalse");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LLVMValue visit(EInt p, String arg) {
		System.out.println("Visit EInt");
		Module.buildString(Module.lastId);
		Module.buildString(". i32* ");
		Module.buildString(p.integer_.toString()+ " ");
		return null;
	}

	@Override
	public LLVMValue visit(EDouble p, String arg) {
		System.out.println("Visit Double");
		//return LLVMConstant.getValue(p.double_);
		return null;
	}

	@Override
	public LLVMValue visit(EString p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EString");
		return null;
	}

	@Override
	public LLVMValue visit(EId p, String arg) {
		// TODO Auto-generated method stub
		Module.buildString(p.id_+ " ");
		System.out.println("Visit EId");
		
		
		return null;
	}

	@Override
	public LLVMValue visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		
		//Module.buildString("store i32 ");
		//Module.buildString(Module.lastId);
		//Module.buildString(". i32* ");
		Module.buildString("call @"+p.id_+"(");
		
		for(int index = 0; index < p.listexp_.size(); index++)
		Compiler.eval(p.listexp_.get(index));
		Module.buildString(")");
		return null;
	}

	@Override
	public LLVMValue visit(EPIncr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EPIncr");
		Compiler.eval(p.exp_);

		return null;
	}

	@Override
	public LLVMValue visit(EPDecr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EPDecr");
		Compiler.eval(p.exp_);

		return null;
	}

	@Override
	public LLVMValue visit(EIncr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EIncr");
		Module.buildString("%");
		Compiler.eval(p.exp_);
		Module.buildString("= add %");
		Compiler.eval(p.exp_);
		Module.buildString(" i32 1");

		return null;
	}

	@Override
	public LLVMValue visit(EDecr p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EDecr");
		Compiler.eval(p.exp_);
		return null;
	}

	@Override
	public LLVMValue visit(ETimes p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETimes");
		Module.buildString("mul ");
		Compiler.eval(p.exp_1);
		Module.buildString(", ");
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EDiv p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EDiv");
		Module.buildString("div ");
		Compiler.eval(p.exp_1);
		Module.buildString(", ");
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EPlus p, String arg) {
		
		System.out.println("Visit EPlus");
		Module.buildString("add ");
		
		Compiler.eval(p.exp_1);
		Module.buildString(", ");
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EMinus p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EMinus");
		Module.buildString("sub ");
		Compiler.eval(p.exp_1);
		Module.buildString(", ");
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(ELt p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ELt");
		Module.buildString(" fcmp olt ");
		Compiler.eval(p.exp_1);
		Module.buildString(", ");
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EGt p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EGt");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(ELtEq p, String arg) {
		System.out.println("Visit ELtEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LLVMValue visit(EGtEq p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EGtEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EEq p, String arg) {
		System.out.println("Visit EEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LLVMValue visit(ENEq p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ENEq");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EAnd p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EAnd");
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		return null;
	}

	@Override
	public LLVMValue visit(EOr p, String arg) {
		System.out.println("Visit EOr");
		// TODO Auto-generated method stub
		Compiler.eval(p.exp_1);
		Compiler.eval(p.exp_2);
		
		return null;
	}

	@Override
	public LLVMValue visit(EAss p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EAss");
		Module.buildString("%" );
		Compiler.eval(p.exp_1);
		Module.buildString(" = ");
		Compiler.eval(p.exp_2);
		
		return null;
	}

	@Override
	public LLVMValue visit(ETyped p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETyped");
		return null;
	}
	
}
