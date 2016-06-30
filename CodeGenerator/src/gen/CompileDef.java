package gen;
import CPP.*;
import CPP.Absyn.*;

//The R and a has to be evaluated

public class CompileDef implements Def.Visitor<String, String> {
	/**
	 * create a string for that definition and write it in the text file
	 * go through all stuff that p has nad do the same 
	 */
	@Override
	public String visit(DFun p, String arg) {
		// TODO Auto-generated method stub
		System.out.println("Visit DFun");
		Module.getType(p.type_.toString());
		Module.buildString(p.id_ +"(");
		for(int i =0; i<p.listarg_.size(); i++){
			Compiler.eval(p.listarg_.get(i));	
			if(i< p.listarg_.size() - 1) Module.buildString(", ");
		}
		Module.buildString(")"+"{\n");
		for(int i =0; i<p.liststm_.size(); i++){
			Compiler.eval(p.liststm_.get(i));	
		}
		Module.buildString("ret i32 0\n");
		Module.buildString("\n}");
		return null;
	}
	
	
	
}
