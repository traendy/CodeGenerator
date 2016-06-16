package inter;

import java.util.HashMap;
import java.util.LinkedList;
import java.io.*;
import CPP.Absyn.*;

/**
 * Enviroment is a list of contexts
 * each programm has an enviroment. Euch block denotet by {} is a new contextstack item
 * probably one could simply extend the hasmap but i do not care now
 * @author soenke
 *
 */
public class Env {
	
	public static LinkedList<HashMap<String,  Val>> contexts = new LinkedList<>();  //idk if this Type her should be a Type form bnfc gen stuff or from my TypeCode Enum
	public static LinkedList<LinkedList> ContextStack = new LinkedList<>();
	
	/**
	 * Search through the contexts List hashmaps until the newest id type is found
	 * @param id the id of which we search the type 
	 * @return
	 */
	
	/**
	 * looks for val in coressponding context
	 * @param id
	 * @return
	 */
	public static Val lookupVar(String id) {
		
			return null;
			
		
	}
	
	/**
	 * looks for val in coressponding context
	 * @param id
	 * @return
	 */
	public static Val lookupFun(String id) {//...idk if i need this before i have more than one function per programm to evalute 
		return null;
	}




	/**
	 * Ads a new val to its corressponding context
	 * @param id_
	 * @param val
	 */
	public static void addVar(String id_, Val val) {
	
	}

	/**
	 * String stuff
	 */
	
	
	
	/** 
	 * removes last context if blook is left
	 */
	public static void clearTable(){
		
	}
	
	
	/**
	 * adds new context if block is opened
	 */
	public void newContext(){
		
	}
	//....
}
