package inter;

import java.util.HashMap;

import CPP.Absyn.DFun;
import CPP.Absyn.Def;
import CPP.Absyn.Type;

public class CheckDef implements Def.Visitor<TypeCode, TypeCode>{

	

	@Override
	public TypeCode visit(DFun p, TypeCode arg) {
		System.out.println("Dfun");
		//System.out.println(p.id_);
		//System.out.println(p.type_);
		
		if(p.type_.toString().contains("int")) Env.addVar(p.id_, TypeCode.CInt);
		if(p.type_.toString().contains("double")) Env.addVar(p.id_, TypeCode.CDouble);
		if(p.type_.toString().contains("string")) Env.addVar(p.id_, TypeCode.CString);
		if(p.type_.toString().contains("bool")) Env.addVar(p.id_, TypeCode.CBool);
		if(p.type_.toString().contains("void")) Env.addVar(p.id_, TypeCode.CVoid);
		
		///Interpreter.eval(p.id_);
		for(int k=0; k< p.listarg_.size(); k++){
			Interpreter.eval(p.listarg_.get(k));
	
		}
		for(int i=0; i<p.liststm_.size();i++){
			return Interpreter.eval(p.liststm_.get(i));
		}
		return p.accept(new CheckDef(), null);
		
	}

}
