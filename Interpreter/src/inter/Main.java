package inter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import CPP.Yylex;
import CPP.parser;

public class Main {
/**
 * The Interpreter updates variables as the programm contiuos
 * e.g: int x=1  // enviroment x:1
 * 		x=x+34	// envoroment x:35
 * 		int y = 2// enviroment x:35, y:2
 * 		int z = x+y // enviroment x:35, y:2, z: 37
 * @param args
 */
	
	static Yylex l;
	public static void main(String[] args) {

		try {
			
			File f = new File(args[0]);
			f.createNewFile();
			if(!f.exists()){
			System.out.println("File does not exist");
			}
			l= new Yylex(new FileReader(f));
			// l = new Yylex(new FileReader("good.cc")); //TODO: find out what this is
			
			parser p = new parser(l);
				
				CPP.Absyn.Program parse_tree;
				try {
					parse_tree = p.pProgram();
					interpret(p);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
		}catch(IOException e){
			
		}
	}
	private static void interpret(parser p) {
		
		
	}

}
