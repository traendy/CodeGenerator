package gen;
import java.util.HashMap;
import java.util.LinkedList;



public  class Module {

	static String llvm_output="";
	static HashMap<String, String> context = new HashMap<>(); 
	static int level = 1;
	static LinkedList<String> variableStack;
	static LinkedList<String> Output;

	static void buildString(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(llvm_output).append(str);
		llvm_output = sb.toString();
	}
	static void finish(){
		@SuppressWarnings("unused")
		String s1 ="";
	StringBuilder sb = new StringBuilder();
		for(int i = 0; i< Output.size(); i++){
			sb.append(Output.get(i)).append("\n");
			System.out.println(Output.get(i));
		}
		s1=llvm_output +sb.toString();
	}
	
	public static void getType(String p){
		if(p.contains("int")) Module.buildString("int32 ");
	}

}
