package gen;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Filewriter for output file
 * 
 * 
 * @author soenke
 *
 */
public class Filewriter {
	

/**
 * uses the initiale file name like good01.cc and creates a File calles good01.cc.output.txt
 * with the llvm_output
 * @param fileName
 */

 public static void write(String filename){
	 StringBuilder sb = new StringBuilder();
	 sb.append(filename).append(".output").append(".txt");
	 String outputname = sb.toString();
	 try{
 
 FileWriter fw = new FileWriter(outputname);
 BufferedWriter bw = new BufferedWriter(fw);
 for(int i =0; i<Module.Output.size(); i++){
	 bw.write(Module.Output.get(i));
	 bw.write("\n");
 }
 
 bw.close();
 System.out.println("Done. File: "+ outputname);
	 }catch(IOException e){
		 
	 }
 }
}
