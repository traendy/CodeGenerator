package inter;

import CPP.Absyn.ADecl;
import CPP.Absyn.Arg;
import CPP.Absyn.Type;

public class CheckArg implements Arg.Visitor<Type, Type>{

	@Override
	public Type visit(ADecl p, Type arg) {
		System.out.println("ADecl");
		if(p.type_.toString().contains("int")) Env.addVar(p.id_, TypeCode.CInt);
		if(p.type_.toString().contains("double")) Env.addVar(p.id_, TypeCode.CDouble);
		if(p.type_.toString().contains("string")) Env.addVar(p.id_, TypeCode.CString);
		if(p.type_.toString().contains("bool")) Env.addVar(p.id_, TypeCode.CBool);
		return null;
	}

}
