package gen;

import CPP.Absyn.PDefs;
import CPP.Absyn.Program.Visitor;


/**
 * the R and A aastuff has to be evaluatet
 * @author soenke
 *
 */
public class CompileProgram implements Visitor<String, String>{
/**
 * something about module i guess i havent yet read through the whole llvm
 * and ofc string work her too
 */
	@Override
	public String visit(PDefs p, String arg) {
		System.out.println("Visit PDefs");
		Module.Output.add("@define int32 main(){");
		System.out.println("List length: " + p.listdef_.size());
		for(int i =0 ; i< p.listdef_.size(); i++){
			Compiler.eval(p.listdef_.get(i));
			
		}
		Module.Output.add("}");
		// TODO Auto-generated method stub
		return null;
	}

}
