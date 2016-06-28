package gen;
import java.util.HashMap;

import org.jllvm.LLVMContext;
import org.jllvm.LLVMInstructionBuilder;
import org.jllvm.LLVMModule;
import org.jllvm.LLVMValue;

public  class Module {

	static String llvm_output="";
	static HashMap<String, String> context = new HashMap<>(); // String funktionsmname String inhalt(llvm)
	static int varKey = 1;
	static String lastId = ""; 
	
	//TODO Stringbuilder
	static void buildString(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(llvm_output).append(str);
		llvm_output = sb.toString();
	}
	
	public static void getType(String p){
		if(p.contains("int")) Module.buildString("int32 ");
	}

}
