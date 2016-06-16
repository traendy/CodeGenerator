package gen;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import CPP.Yylex;
import CPP.parser;
import CPP.Absyn.Program;

public class Main {

	public static void main(String[] args) {

		try {
			
			File f = new File(args[0]);
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
			
		}

	}

	private static void generate(Program parse_tree) {
		// TODO Auto-generated method stub
		
	}
	
	

}
