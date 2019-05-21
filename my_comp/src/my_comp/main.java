package my_comp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class main {
	
 
    public static void main (String[] args) throws Exception {
    	
    	String []Keywords= {"start","float","for","if","end"};
		//char [] operator = {'+','-','*','/','(',')','<','>',';'};
		List<List<String>> lexem_table = new ArrayList<List<String>>();
		List<List<String>> var_table = new ArrayList<List<String>>();
		List<List<String>> const_table = new ArrayList<List<String>>();
		
		//int quantity_lexem=0;
    	//int quantity_variable=0;
    	//int quantity_constant=0;
    	
        FileReader fr= new FileReader("C:\\Users\\oushen\\Desktop\\source.txt");
        Scanner scan = new Scanner(fr);
        // write all file in String    
        int i; 
        String str = "";
        while ((i=fr.read()) != -1) { 
          str +=((char) i); 
        } 
        scan.close();
        char [] code=str.toCharArray();
        
       //Start to parse string
        int end_of_line=1;
        int index_start= 0; 
        int index_end=0 ;
        String word = "";
        String number = "";
        
   for(;index_end<code.length;index_end++) {
  	   index_start = index_end;
        	//next line of code
       	 	if(code[index_end]=='\n') {end_of_line+=1;}
       	 	
        	// if symbol letter

       	 	if(Character.isLetter(code[index_end])) {
        		 	index_end += 1;
        		 	while(!Character.isWhitespace(code[index_end])) {
        		 		if(Character.isLetter(code[index_end])) index_end += 1;
        		 		else break;
        	        }
        		 
        		 	for(;index_start<index_end;index_start++) {
        		 	word += code[index_start];
        	 				}	
        	 			
        		 		int variable_index = 0;
        	 			for (int keyword_index = 0;keyword_index<Keywords.length;keyword_index += 1) {
        	 					if (word.equals(Keywords[keyword_index])) {
        	 						List<String> list = new ArrayList<String>();
        	 						lexem_table.add(list); 
        	 						list.add(""+end_of_line);
        	 						list.add(""+word);
        	 						list.add(""+keyword_index);
        	 						word="";
        	 						System.out.println(list);
        	 						break;
        	 					}
        	 					}
        
        	 		
        	 							List<String> variable = new ArrayList<String>();
        	 							List<String> lexem = new ArrayList<String>();
        	 							var_table.add(variable);
        	 							lexem_table.add(lexem);
        	 							variable.add(""+end_of_line);
        	 							variable.add(""+word);
        	 							variable.add(""+variable_index);
        	 							lexem.add(""+end_of_line);
        	 							lexem.add(""+word);
        	 							lexem.add(""+variable_index);
        	 							word="";
        	 							System.out.println(lexem);
        	 						
        	 						variable_index += 1;
        	 						
        	 			
        		 continue;
        	 }
        	// if symbol number 
        	 if(Character.isDigit(code[index_end])) {
        		 number += code[index_end];
        		 
        		 while (Character.isDigit(code[index_end])) {
        				index_end += 1;
        				
        			if (code[index_end] == '.' && Character.isDigit(code[index_end+1])) {
        				index_end += 1;
        				 while (Character.isDigit(code[index_end])) {
             				index_end += 1;
        		 }}}
        		 
        		 for(;index_start<index_end;index_start++) {
         		 	number += code[index_start];
         	 				}
        		 
        		 int constant_index = 0;
        		 
        		 for (;constant_index<const_table.size();) {
        			 
        			 if(const_table.size()>0) {	
	 					if (!const_table.get(constant_index).contains(number)){
	 					
	 						ArrayList<String> list = new ArrayList<String>();
	 						const_table.add(list); 
	 						list.add(""+end_of_line);
	 						list.add(""+number);
	 						list.add(""+constant_index);
	 						number="";
	 						System.out.println(list);
	 						break;
	 					}}
	 						else constant_index += 1;
	 					}
        					
        		 
        		 continue;
        	 }
        	 // if symbol operator
        	// if(code[index_end].equals) {
        		 
        	 /*if source_code[index_end] in operators:
        			index_end += 1
        			#Отдельный случай для двухсимвольного оператора
        			if source_code[index_start : index_end+1] == ":=": index_end += 1
        			symbol = source_code[index_start : index_end]
        			operator_index = 13ж
        			for operator in operators:
        				if symbol == operator: break
        				operator_index += 1
        			lexem_table.append([line_index, symbol, operator_index, ""])
        			continue
        	
        	 System.out.println(end_of_line+" "+word+" "+word.length());
    		 word="";*/
        	
        }
   
   //System.out.println(lexem_table.size());
   //System.out.println(constant_table.size());
      
 }
}