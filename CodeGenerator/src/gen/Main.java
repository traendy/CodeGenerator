package gen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jllvm.LLVMContext;
import org.jllvm.LLVMModule;

import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;


public class Main {

	public static void main(String[] args) {
		
		try {
			
			//File f = new File("/home/soenke/Schreibtisch/Compiler/ex4/workspace/CodeGenerator/files/good01.cc");
			File f = new File("good01.cc");
			f.createNewFile();
			if(!f.exists()){
			System.out.println("File does not exist");
			}
			Yylex l = new Yylex(new FileReader(f));
			// l = new Yylex(new FileReader("good.cc")); //TODO: find out what this is
			
			parser p = new parser(l);
				
				CPP.Absyn.Program parse_tree;
				try {
					parse_tree = p.pProgram();
					generate(parse_tree);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * 
	 * implemnt the functions
	 * 			-read through the doc of llvm to find the correct string values for the functions
	 * print the string in an existing file
	 * make java to execute jasmin and with that text file
	 * For any 
	 * 
	 * 
	 * maybe it does make sense to do sysos in every visit and eval 
	 * @param parse_tree
	 */
	
	private static void generate(Program parse_tree) {
		Compiler c = new Compiler();
		System.out.println(parse_tree.toString());
		
		c.eval(parse_tree);
		System.out.println(Module.llvm_output);
		//Module.mod.dump();
	}
	
	

}
