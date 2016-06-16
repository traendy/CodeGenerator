package gen;

import CPP.Absyn.*;

public class Compiler {
	public static void eval(Exp e){
		//System.out.println(e.accept(new CheckExp(), null)+"------------");// retruned null klären
		 e.accept(new CompileExp(), null);
		return ;
	}
	
	public static void eval(Stm s){
		 s.accept(new CompileStm(), null);
		return ;
	}
	
	public static void eval(Arg a){
		 a.accept(new CompileArg(), null);
		return ;
	}
	
	public static void eval(Def d){
		 d.accept(new CompileDef(), null);
		return ;
	}
	
	public static void eval(Program p){
		 p.accept(new CompileProgram(),null);
		return;
	}
	
	
	
}
