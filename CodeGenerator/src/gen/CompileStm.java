package gen;


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
		
		Module.Output.add( Compiler.eval(p.exp_));
		
		return null;
	}

	
	/**
	 * Todo Special case
	 */
	@Override
	public String visit(SDecls p, String arg) {
		System.out.println("Visit SDecls");
		
		for(int i =0; i< p.listid_.size(); i++)
		Module.Output.add("%" + p.listid_.get(i) + " = alloca i32, align 4");	
		
		
		return null;
	}

	@Override
	public String visit(SInit p, String arg) {
		System.out.println("Visit SInit");
		Module.Output.add( "%"+p.id_ + " = alloca i32, align 4");   
		Module.variableStack.add(p.id_);
		String s = Compiler.eval(p.exp_);
		
		if(isNumber(s)){
			
			Module.Output.add("store i32 "+ s + ", i32* "+Module.variableStack.getLast());
			Module.variableStack.removeLast();
		}else {
			Module.Output.add("%"+Module.level + "= "+ s); 
			Module.context.put(String.valueOf(Module.level), s);
			Module.variableStack.add(String.valueOf(Module.level));
			Module.level++;
			String s2 = ("store i32 %"+ Module.variableStack.getLast() + ", i32* %");
			Module.variableStack.removeLast();
			s2+= Module.variableStack.getLast() + ", align 4";
			Module.Output.add(s2);

		}
		
		return null;
	}

	@Override
	public String visit(SReturn p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit SReturn");
	
		Module.buildString("ret ");
		@SuppressWarnings("unused")
		String s= Compiler.eval(p.exp_);
	
			Module.Output.add("ret i32 %"+ Module.level);
		
		return null;
	}

	@Override
	public String visit(SReturnVoid p, String arg) {
		
		System.out.println("Visit SReturnVoid");
		Module.Output.add("ret void");
		
		return null;
	}

	@Override
	public String visit(SWhile p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit SWhile");
		String label = String.valueOf(Module.level);
		Module.Output.add("br label"+ label+ "\n");
		Module.level++;
		Module.Output.add("; <label>:" +label);
		
		
		Compiler.eval(p.exp_);
		
		
		Module.Output.add("br i1 %"+ Module.level +" label %wtrue, label %wfalse" );
		Module.level++;
		Module.Output.add("\n; <label>: wtrue");
		Compiler.eval(p.stm_);
		Module.Output.add("br label" +label);
		Module.Output.add("\n; <label>: wfalse: ");
		return null;
	}

	@Override
	public String visit(SBlock p, String arg) {
		System.out.println("Visit SBlock");
		
		for(int i=0; i<p.liststm_.size(); i++){
			Compiler.eval(p.liststm_.get(i));
			
		}
		
		return null;
	}

	@Override
	public String visit(SIfElse p, String arg) {
		
		System.out.println("Visit SIfElse");
		String label = String.valueOf(Module.level);
		Module.Output.add("br label"+ label+ "\n");
		Module.level++;
		Module.Output.add("; <label>:" +label);
		
		
		Compiler.eval(p.exp_);
		
		
		Module.Output.add("br i1 %"+ Module.level +" label %itrue, label %ifalse, label %ifinally " );
		Module.level++;
		Module.Output.add("\n; <label>: itrue");
		
		Compiler.eval(p.stm_1);
	
		Module.Output.add("\n; <label>: ifalse: ");
		Compiler.eval(p.stm_2);
		
		Module.Output.add("\n; <label>: ifinally: ");
		return null;
	}
	
	public static boolean isNumber(String s){
		for(char c: s.trim().toCharArray()) {
			
			if(!Character.isDigit(c))return false;
			
		}return true;
		
	}

}
