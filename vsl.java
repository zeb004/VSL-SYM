import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class vsl {
	 public static void main(String[] args) throws FileNotFoundException{
		try(  PrintWriter out = new PrintWriter( "Sym.txt" )  ){


		 int i=0;
		 String[] keys=new String[257];
		 try (Scanner input = new Scanner(new File("vsl.txt"))) {
		 		 while(input.hasNext())
		 		 {
		 		    String data = input.next();
		 		    keys[i]=data;
		 		    if(data.equals("var")){
						out.println("<"+data+", VAR>");
					} else if(data.equals(";")){
						out.println("<"+data+", SC>");
						}else if(data.equals("as")) {
						out.println("<"+data+", AS>");
					}else if(data.equals("int")) {
						out.println("<"+data+", INT>");
					}else if(data.equals("begin")) {
						out.println("<"+data+", START>");
					} else if(data.equals(":=")) {
						out.println("<"+data+", ASSGN>");
					} else if(data.equals(",")) {
						out.println("<"+data+", COMMA>");
					} else if(data.equals("*")) {
						out.println("<"+data+", MUL>");
						} else if(data.equals("div")) {
						out.println("<"+data+", DIV>");
						} else if(data.equals("mod")) {
						out.println("<"+data+", MOD>");
						} else if(data.equals("+")) {
						out.println("<"+data+", ADD>");
						} else if(data.equals("-")) {
						out.println("<"+data+", SUB>");
						} else if(data.equals("=")) {
						out.println("<"+data+", EQ>");
						} else if(data.equals("!=")) {
						out.println("<"+data+", NE>");
						} else if(data.equals("<")) {
						out.println("<"+data+", LT>");
						} else if(data.equals("<=")) {
						out.println("<"+data+", LE>");
						} else if(data.equals(">")) {
						out.println("<"+data+", GT>");
						} else if(data.equals(">=")) {
						out.println("<"+data+", GE>");
						} else if(data.equals("program")) {
						out.println("<"+data+", PROGRAM>");
						} else if(data.equals("do")) {
						out.println("<"+data+", DO>");
						} else if(data.equals("while")) {
						out.println("<"+data+", WHILE>");
						} else if(data.equals("end")) {
						out.println("<"+data+", END>");
						} else if(data.equals("begin")) {
						out.println("<"+data+", BEGIN>");
						} else if(data.equals("else")) {
						out.println("<"+data+", ELSE>");
						} else if(data.equals("then")) {
						out.println("<"+data+", THEN>");
						} else if(data.equals("if")) {
						out.println("<"+data+", IF>");
						} else if(data.equals("writeInt")) {
						out.println("<"+data+", WRITEINT>");
						} else if(data.equals("readInt")) {
						out.println("<"+data+", READINT>");
						} else if(data.equals("%")) {
						out.println("<"+data+", COMMENTS>");//skip comments
						input.nextLine();
					}else if(data.equals("(")) {
						out.println("<"+data+", LPAREN>");
					}else if(data.equals(")")) {
						out.println("<"+data+", RPAREN>");
					}else if(data.equals("1")||(data.equals("2")||data.equals("3")||data.equals("4")||data.equals("5")||
					data.equals("6")||data.equals("7")||data.equals("8")||data.equals("9")||data.equals("0"))) {
						out.println("<"+data+", NUM>");
					} else{
						out.println("<"+data+" , IDENT>");
					}


		 	i++;
		}
		 }
		 }  catch (IOException e) {
		 				e.printStackTrace();
		}








}
}