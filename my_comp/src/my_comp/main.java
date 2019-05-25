package my_comp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class main {
	
 
	
	
    public static void main (String[] args) throws Exception {
    	
    	String []Keywords= {"start","float","for","if","end"};
		char [] operator = {'{','}','(',')','<','>','+','-','*','/','=',':',';'};
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
        int constant_index = 0;
        int variable_index = 0;
        
   for(;index_end<code.length;index_end++) {
  	   index_start = index_end;
        	//next line of code
       	 	if(code[index_end]=='\n') {end_of_line+=1;}
       	 	
        	// if symbol letter

       	 	/**/if(Character.isLetter(code[index_end])) {
        		 	index_end += 1;
        		 	while(index_end<code.length&&!Character.isWhitespace(code[index_end])) {
        		 		index_end += 1;
        		 	}
        		 
        		 	for(;index_start<index_end;index_start++) {
        		 	word += code[index_start];
        	 				}	
        	 			
        		 	
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
        	 				if(word!="") {
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
							//System.out.println(word);
							word="";
							System.out.println(lexem);
						
						variable_index+=1;}
        	 			
        		 continue;
        	 }
        	// if symbol number 
       	 /* if(Character.isDigit(code[index_end])) {
        		 //number += code[index_end];
        		 		index_end += 1;
        		 while (index_end<code.length&&Character.isDigit(code[index_end])) {
        				index_end += 1;}
        		 
        		 for(;index_start<index_end;index_start++) {
         		 	number += code[index_start];
         	 				}
        			 
	 						ArrayList<String> list = new ArrayList<String>();
	 						const_table.add(list); 
	 						list.add(""+end_of_line);
	 						list.add(""+number);
	 						list.add(""+constant_index);
	 						number="";
	 						System.out.println(list);
	 						constant_index+=1;
	 						 
        		 continue;
        	 }
        	 // if symbol operator
        	
        	 	for(int k=0; k<operator.length;k++) {
        			if(code[index_end]==operator[k]) {
        			
        			List<String> list = new ArrayList<String>();
        	 						lexem_table.add(list); 
        	 						list.add(""+end_of_line);
        	 						list.add(""+code[index_end]);
        	 						list.add(""+k);
        	 						System.out.println(list);
        			}
        			continue;
        		}*/
        
        
        	
        }
   
   //System.out.println(lexem_table.size());
   //System.out.println(constant_table.size());
      
 }
}