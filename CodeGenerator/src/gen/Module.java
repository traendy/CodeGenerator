package gen;
import java.util.HashMap;

import org.jllvm.LLVMContext;
import org.jllvm.LLVMInstructionBuilder;
import org.jllvm.LLVMModule;
import org.jllvm.LLVMValue;

public  class Module {

	static String llvm_output="";
	static HashMap<String, String> context = new HashMap<>(); // String funktionsmname String inhalt(llvm)
	
	
	//TODO Stringbuilder
	static void builder(String str){
		StringBuilder sbuilder = StringBuilder;
		sbuilder.append(str);
		llvm_output
	}
}
