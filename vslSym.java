import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;

public class vslSym {
	 public static void main(String[] args) throws FileNotFoundException{
		 int f=0;
		 int num=1;
		 String label= "Label";
		 String[] ident=new String[257];
		 String add ="IDENT ASSGN IDENT ADD IDENT SC";
		 String sub="IDENT ASSGN IDENT SUB IDENT SC";
		 String mul="IDENT ASSGN IDENT MUL IDENT SC";
		 String div="IDENT ASSGN IDENT DIV IDENT SC";
		 String mod="IDENT ASSGN IDENT MOD IDENT SC";
		 String gt="IDENT ASSGN IDENT GT IDENT SC";
		 String ge="IDENT ASSGN IDENT GE IDENT SC";
		 String lt="IDENT ASSGN IDENT LT IDENT SC";
		 String le="IDENT ASSGN IDENT LE IDENT SC";
		 String read="IDENT ASSGN READINT SC";
		 String write="IDENT ASSGN WRITEINT SC";
		 String end="END SC";
		 String spec="VAR IDENT AS";
		 String assgn="IDENT ASSGN IDENT SC";
		 String assgn1="IDENT ASSGN NUM SC";
		 String ifthen="IF FLAG THEN WRITEINT IDENT SC";
		 String flag1="FLAG ASSGN IDENT LT IDENT SC";
		 String flag2="FLAG ASSGN IDENT LE IDENT SC";
		 String flag3="FLAG ASSGN IDENT GE IDENT SC";
		 String flag4="FLAG ASSGN IDENT GT IDENT SC";
		try(  PrintWriter out = new PrintWriter( "Sym.txt" )  ){


		 int i=0;

		 String[] keys=new String[257];
		 try (Scanner input = new Scanner(new File("input.txt"))) {
		 		 while(input.hasNext())
		 		 {
		 		    String data = input.next();
		 		    keys[i]=data;
		 		    if(data.equals("var")){
						out.print("VAR ");
					} else if(data.equals(";")){
						out.print("SC\n");
						}else if(data.equals("as")) {
						out.print("AS ");
					}else if(data.equals("int")) {
						out.print("INT ");
					}else if(data.equals("begin")) {
						out.print("START ");
					} else if(data.equals(":=")) {
						out.print("ASSGN ");
					} else if(data.equals(",")) {
						out.print("COMMA ");
					} else if(data.equals("*")) {
						out.print("MUL ");
						} else if(data.equals("div")) {
						out.print("DIV ");
						} else if(data.equals("mod")) {
						out.print("MOD ");
						} else if(data.equals("+")) {
						out.print("ADD ");
						} else if(data.equals("-")) {
						out.print("SUB ");
						} else if(data.equals("=")) {
						out.print("EQ ");
						} else if(data.equals("!=")) {
						out.print("NE ");
						} else if(data.equals("<")) {
						out.print("LT ");
						} else if(data.equals("<=")) {
						out.print("LE ");
						} else if(data.equals(">")) {
						out.print("GT ");
						} else if(data.equals(">=")) {
						out.print("GE ");
						} else if(data.equals("program")) {
						out.print("PROGRAM ");
						} else if(data.equals("do")) {
						out.print("DO ");
						} else if(data.equals("while")) {
						out.print("WHILE ");
						} else if(data.equals("end")) {
						out.print("END ");
						} else if(data.equals("begin")) {
						out.print("BEGIN ");
						} else if(data.equals("else")) {
						out.print("ELSE ");
						} else if(data.equals("then")) {
						out.print("THEN ");
						} else if(data.equals("if")) {
						out.print("IF ");
						} else if(data.equals("writeInt")) {
						out.print("WRITEINT ");
						} else if(data.equals("readInt")) {
						out.print("READINT ");
						} else if(data.equals("%")) {
						out.print("COMMENTS ");//skip comments
						input.nextLine();
					}else if(data.equals("(")) {
						out.print("LPAREN ");
					}else if(data.equals(")")) {
						out.print("RPAREN ");
				}else if(data.equals("FLAG")) {
						out.print("FLAG ");
						ident[f]=data;
						f++;
					}else if(data.equals("1")||(data.equals("2")||data.equals("3")||data.equals("4")||data.equals("5")||
					data.equals("6")||data.equals("7")||data.equals("8")||data.equals("9")||data.equals("0"))) {
						out.print("NUM ");
					} else{
						out.print("IDENT ");
						ident[f]=data;
						f++;
					}


		 	i++;
		}
		 }
		 }  catch (IOException e) {
		 				e.printStackTrace();
		}


try(  PrintWriter out1= new PrintWriter( "Valid.txt" )  ){
	try(  PrintWriter code= new PrintWriter( "Code.txt" )  ){


		 int j=0;
		 int p=0;
		 String[] keys1=new String[257];
		 try (Scanner input1 = new Scanner(new File("Sym.txt"))) {
		 		 while(input1.hasNext())
		 		 {
		 		    String data1 = input1.nextLine();
		 		    keys1[j]=data1;
					if(add.equals(keys1[j])) {
						out1.println("valid");
						code.println("LVALUE \t"+ident[p]);
						p++;
						code.println("RVALUE \t"+ident[p]);
						p++;
						code.println("RVALUE \t"+ident[p]);
						p++;
						code.println("ADD\n:=\n");
					} else if(read.equals(keys1[j])) {
						out1.println("valid");
						code.println("LVALUE \t"+ident[p]);
						p++;
						code.println("READINT");
						code.println(":=\n");
				} else if(flag1.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("LT\n:=\n");
					} else if(flag2.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("LE\n:=\n");
					} else if(flag3.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("GE\n:=\n");
					} else if(flag4.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("GT\n:=\n");
					} else if(sub.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
				   code.println("SUB\n:=\n");
					} else if(mul.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("MUL\n:=\n");
					} else if(div.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("DIV\n:=\n");
					} else if(mod.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("MOD\n:=\n");
					} else if(gt.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("GT\n:=\n");
					} else if(ge.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("GE\n:=\n");
					} else if(lt.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("LT\n:=\n");
					} else if(le.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println("LE\n:=\n");
					} else if(end.equals(keys1[j])) {
					out1.println("valid");
					} else if(ifthen.equals(keys1[j])) {
					out1.println("valid");
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("GOFALSE\t"+label+num);
					num++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("LABEL \t"+label+(num-1));
					code.println(":=\n");
					} else if(keys1[j].contains("WHILE")&&keys1[j].contains("DO")) {
					out1.println("valid");
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("MUL");
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("LE");
					code.println("GOTRUE\t"+label+num);
					num++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
					code.println(":=");
						code.println("LABEL\t"+label+(num-1)+"\n");

					} else if(assgn.equals(keys1[j])|| assgn1.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("RVALUE \t"+ident[p]);
					p++;
						code.println(":=\n");
					} else if(keys1[j].contains(spec)) {
					out1.println("valid");
					p++;
					} else if(write.equals(keys1[j])) {
					out1.println("valid");
					code.println("LVALUE \t"+ident[p]);
					p++;
					code.println("WRITEINT \t");
						code.println(":=\n");
					} else {
						out1.println("non valid");
					}
					j++;
				}
			}
}
}

try(  PrintWriter identifier= new PrintWriter( "idents.txt" )  ){
				for(int y=0;y<f;y++) {
	             identifier.println(ident[y]);


				}
			}



}
}