package gen;

import CPP.Absyn.*;

import java.util.LinkedList;


/**
 * Find the R, and A attributes I dont know them now
 * @author soenke
 *
 */
public class CompileExp implements Exp.Visitor<String, String>{
/**
 * Most of the functions are her always return the appended string that schould be it
 */
	
	
	@Override
	public String visit(ETrue p, String arg) {
		// TODO Auto-generated method stub		
		System.out.println("Visit ETrue");		
		return "1 ";
	}

	@Override
	public String visit(EFalse p, String arg) {		
		System.out.println("Visit EFalse");		
		return "0 ";
	}

	@Override
	public String visit(EInt p, String arg) {
		System.out.println("Visit EInt");	
		return p.integer_.toString()+ " ";
	}

	@Override
	public String visit(EDouble p, String arg) {
		System.out.println("Visit Double");
		return (p.double_.toString()+" ");
	}

	@Override
	public String visit(EString p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EString");
		
		return p.string_ +" ";
	}

	@Override
	public String visit(EId p, String arg) {
		
		
		System.out.println("Visit EId");
		
		
		return "%"+p.id_+ " ";
	}

	/*@Override
	public String visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		if(p.listexp_.size()==0){
			return "call "+p.id_+"()";
		}
		int length = Module.context.size();
		String s ="";
		for(int index = 0; index < p.listexp_.size(); index++){
		 s = Compiler.eval(p.listexp_.get(index));
		}
		if(length != Module.context.size()){
			String s2 = "%"+Module.level + " = alloca i32, align 4\n";
			s2+=  "%"+Module.level + " = " +s + "\n";
			Module.Output.add(s2);
			String s3 = p.id_+"( i32 %" + Module.level + " )";
			Module.level++;
			return s3;
			
		}else{
			
			String s2 = p.id_+"( i32 %" + s + " )";
			return s2;
		}
		
	}*/
	
	@Override
	public String visit(EApp p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EApp");
		if(p.listexp_.size()==0){
			return "call "+p.id_+"()";
		
		}else{
			LinkedList<String> k= new LinkedList<>();
			String s="";
			for(int index = 0; index < p.listexp_.size(); index++){
				 k.add( Compiler.eval(p.listexp_.get(index)));
			}
			for(int i = 0; i<k.size()-1; i++){
				s+=" i32 "+ k.get(i)+",";
			}
			s+= "i32 "+ k.getLast();
			String s2 ="call "+ p.id_+"( " + s + " )";
			return s2;
		}
		
	}

	@Override
	public String visit(EPIncr p, String arg) {
		
		System.out.println("Visit EPIncr");
		
		String id = Compiler.eval(p.exp_);
		String s1 = ("%"+Module.level+" = load i32, i32* " +id+", align 4");
		Module.variableStack.add(String.valueOf(Module.level));
		Module.level++;
		String s2 = ("%"+Module.level+" = add i32 %" + Module.variableStack.getLast()+", 1");
		Module.Output.add(s1);
		Module.Output.add(s2);
		Module.Output.add("store i32 "+ id+", i32* %" + Module.level+ ", align 4"  );
		Module.level++;
		Module.variableStack.removeLast();
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EPDecr p, String arg) {
		
		System.out.println("Visit EPDecr");
		String id = Compiler.eval(p.exp_);
		String s1 = ("%"+Module.level+" = load i32, i32* " +id+", align 4");
		Module.variableStack.add(String.valueOf(Module.level));
		Module.level++;
		String s2 = ("%"+Module.level+" = sub i32 %" + Module.variableStack.getLast()+", 1");
		Module.Output.add(s1);
		Module.Output.add(s2);
		Module.Output.add("store i32 "+ id+", i32* %" + Module.level+ ", align 4"  );
		Module.level++;
		Module.variableStack.removeLast();
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EIncr p, String arg) {
		
		String id = Compiler.eval(p.exp_);
		String s1 = ("%"+Module.level+" = load i32, i32* " +id+", align 4");
		Module.variableStack.add(String.valueOf(Module.level));
		Module.level++;
		String s2 = ("%"+Module.level+" = add i32 %" + Module.variableStack.getLast()+", 1");
		Module.Output.add(s1);
		Module.Output.add(s2);
		Module.Output.add("store i32 "+ id+", i32* %" + Module.level+ ", align 4"  );
		Module.level++;
		Module.variableStack.removeLast();
		return "";
		//return "%"+ (Module.level-1);
	
	}

	@Override
	public String visit(EDecr p, String arg) {
		
		String id = Compiler.eval(p.exp_);
		String s1 = ("%"+Module.level+" = load i32, i32* " +id+", align 4");
		Module.variableStack.add(String.valueOf(Module.level));
		Module.level++;
		String s2 = ("%"+Module.level+" = sub i32 %" + Module.variableStack.getLast()+", 1");
		Module.Output.add(s1);
		Module.Output.add(s2);
		Module.Output.add("store i32 "+ id+", i32* %" + Module.level+ ", align 4"  );
		Module.level++;
		Module.variableStack.removeLast();
		
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ETimes p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit ETimes");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = mul i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
		
	}

	@Override
	public String visit(EDiv p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit EDiv");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = div i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EPlus p, String arg) {
		
		System.out.println("Visit EPlus");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = add i32 " + e1 + "," + e2;
		
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EMinus p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EMinus");
		
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = sub i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ELt p, String arg) {
		
		System.out.println("Visit ELt");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp olt i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EGt p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGt");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp ogt i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	
	}

	@Override
	public String visit(ELtEq p, String arg) {
		
		System.out.println("Visit ELtEq");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp ole i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EGtEq p, String arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Visit EGtEq");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp oge i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EEq p, String arg) {
		
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp oe i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ENEq p, String arg) {
		
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp one i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EAnd p, String arg) {
		// TODO Auto-generated method stub
		
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp oge i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EOr p, String arg) {
		System.out.println("Visit EOr");
		
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level + " = fcomp oge i32 " + e1 + "," + e2;
		Module.Output.add(s2);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(EAss p, String arg) {
		
		System.out.println("Visit EAss");
		String s1 = "%" + Module.level + " = alloca i32, align 4";
		Module.Output.add(s1);
		String e1 = Compiler.eval(p.exp_1);
		String e2 = Compiler.eval(p.exp_2);
		String s2 = "%" + Module.level+ " = load i32, i32* "+ e2 +", align 4";
		String s3 = "store i32 %"+ Module.level+ ", i32* "+e1+", align 4"; 
		
		Module.Output.add(s2);
		Module.Output.add(s3);
		Module.level++;
		return "";
		//return "%"+ (Module.level-1);
	}

	@Override
	public String visit(ETyped p, String arg) {
		
		System.out.println("Visit ETyped");
		return null;
	}
	
}
