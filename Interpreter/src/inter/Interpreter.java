package inter;

import CPP.Absyn.*;
/**
 * The interpreter class to start the visitor pattern
 * 
 * @author soenke
 *
 */
public class Interpreter {
	
	/**
	 * here is prob the context updating what is most important but maybe also the extensions 
	 * @param e
	 */
	public static void eval(Exp e){
		//System.out.println(e.accept(new CheckExp(), null)+"------------");// retruned null klären
		 e.accept(new InferExp(), null);
		return;
	}
	/**
	 * here has to take place a lot of contexts extensions
	 * @param s
	 */
	public static void eval(Stm s){
		 s.accept(new CheckStm(), null);
		return ;
	}
	/**
	 * Here has to take place a lot of contexts extensions
	 * @param a
	 */
	public static void eval(Arg a){
		 a.accept(new CheckArg(), null);
		return ;
	}
	/**
	 * this porb just has to go through or see comment at eval(programm)
	 * @param d
	 */
	public static void eval(Def d){
		 d.accept(new CheckDef(), null);
		return ;
	}
	/**
	 * The programm evaluation needs a special case of contexts extenion becaus there is no enviroment yet And further more the cpp.cf 
	 * has a special case of {} at the first definition which is not handled by the block statement
	 * @param p
	 */
	public static void eval(Program p){
		 p.accept(new CheckProgram(),null);
		return ;
	}
	
	
	
}
