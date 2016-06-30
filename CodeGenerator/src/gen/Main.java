package gen;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;


public class Main {

	static  String filename;
	
	public static void main(String[] args) {
		if(args.length==0){
			System.out.println("No Input argument!");
			return;
		}
		try {
			
			//File f = new File("/home/soenke/Schreibtisch/Compiler/ex4/workspace/CodeGenerator/files/good01.cc");
			/*FileReader fr = new FileReader("/files/" + "good01.cc");
			BufferedReader br  = new BufferedReader(fr);*/
			//File f = new File("files/good11.cc");
			File f = new File(args[0]);
			
			f.createNewFile();
			filename = f.getName();
			if(!f.exists()){
			System.out.println("File does not exist");
			}
			Yylex l = new Yylex(new FileReader(f));
			
			
			@SuppressWarnings("deprecation")
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
		
		Module.variableStack = new LinkedList<>();
		Module.Output = new LinkedList<>();
		System.out.println(parse_tree.toString());
		
		Compiler.eval(parse_tree);
		Module.finish();
		Filewriter.write(filename);
		
	}
	
	

}
