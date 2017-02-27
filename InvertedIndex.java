import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class InvertedIndex{         


               public static HashMap<String,HashSet<String>>invert_index  = new HashMap<String,HashSet<String>>();    
               //public static HashMap<String,HashSet<Integer>>invert_index =new HashMap<String,HashSet<Integer>>();          
               public static BufferedReader bufferedreader=null;
               public static FileInputStream inputfile_name=null;
          

              Set<String> stopword =new HashSet<>(Arrays.asList("story","title","date","content", 	 
                                              "के","का","एक","में","की" ,"है","यह","और","से","हैं","को","पर","इस","होता","कि","जो","कर","मे","गया",
                                              "करने","किया","लिये","अपने","ने","बनी","नहीं","तो","ही","या","एवं","दिया","हो","इसका","था","द्वारा","हुआ",
                                              "तक","साथ","करना","वाले","बाद","लिए","आप","कुछ","सकते","किसी","ये","इसके","सबसे","इसमें","थे","दो",
                                              "होने","वह","वे","करते","बहुत","कहा","वर्ग","कई","करें","होती","अपनी","उनके","थी","यदि","हुई","जा","ना",
    					      "इसे","कहते","जब","होते","कोई","हुए","व","न","अभी","जैसे","सभी","करता","उनकी","तरह","उस","आदि",
                                              "कुल","एस","रहा","इसकी","सकता","रहे","उनका","इसी","रखें","अपना","पे","उसके"));



    public void printInvertedIndex(){      //here will be the print function print word and 
             
         for (String key : invert_index.keySet()) {
            System.out.print(key+"  ");   
            //System.out.print(invert_index.get(key).size());          
            Set<String> tr=invert_index.get(key);
            //Set<Integer> tr=invert_index.get(key);
              
         for (String s : tr) {
              System.out.print(s+" ");

             }
              System.out.println();
        }
      }

  public void storeIndex(){     //here is the store function which store the invertedIndex data in inverted.bin formate
      try{
          FileOutputStream fos = new FileOutputStream("inverted.bin");
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(invert_index);
          oos.close();
         }
       catch (IOException e){
           e.printStackTrace();

         } 
        }

   public void Search(String search_word){  //search function is start here
     
        try{ 
          
           if(invert_index.containsKey(search_word)){
            System.out.print("word is valied  ");
            //Set<String> tr=invert_index.get(search_word);
            //System.out.print(search_word + "  " + invert_index.get(search_word));
             System.out.print(search_word + "  " + " Size " + invert_index.get(search_word).size()+"  ");
            }else{
            System.out.print("word is not valied");
            }
            }catch(Exception e){
           }
       }

public void ReturnStore(){
        try{
          FileInputStream fis = new FileInputStream("inverted.bin");
          ObjectInputStream ois = new ObjectInputStream(fis);
          HashMap<String,HashSet<String>> Rvalue=(HashMap<String,HashSet<String>>)ois.readObject(); //read from object
        for (String key : Rvalue.keySet()) {
             System.out.print(key+"  ");
             Set<String> tr=Rvalue.get(key);
           for (String s : tr) {
                System.out.print(s+" ");
                
              }System.out.println();
          }
          ois.close();
      
     }catch (Exception e){

          e.printStackTrace();

	} 
        
 
}
             
   int id=1;
   public void invertedIndex(File file){     //here start invertedIndex Function
      try{ 
        //System.out.println(file.getName()); 
        Steam stem = new Steam();
        inputfile_name= new FileInputStream(file); 
        bufferedreader= new BufferedReader(new InputStreamReader(inputfile_name, "UTF-8"));
        String temp = null;
              while((temp = bufferedreader.readLine()) != null){
		     temp=temp.replace("॥"," ");
		     temp=temp.replace(":"," ");
		     temp=temp.replace("।"," ");		     
                     temp=temp.replace(","," ");
		     temp=temp.replace("!"," ");
		     temp=temp.replace("?"," ");
		     temp=temp.replace("."," ");
                     temp=temp.replace("\\"," ");
		     temp=temp.replace("<"," ");
		     temp=temp.replace("*"," ");
		     temp=temp.replace("?"," ");
                     temp=temp.replace(">"," ");
                     temp=temp.replace("`"," ");
                     temp=temp.replace("~"," ");
                     temp=temp.replace("/"," ");
                     temp=temp.replace("-"," ");
                     temp=temp.replace("0"," ");
                     temp=temp.replace("1"," ");
		     temp=temp.replace("2"," ");
		     temp=temp.replace("3"," ");
		     temp=temp.replace("4"," ");
                     temp=temp.replace("5"," ");
                     temp=temp.replace("6"," ");
                     temp=temp.replace("7"," ");
                     temp=temp.replace("8"," ");
                     temp=temp.replace("9"," ");
                     temp=temp.replace("'"," ");
                     temp=temp.replace("("," ");
                     temp=temp.replace(")"," ");

		 StringTokenizer string_token = new StringTokenizer(temp," ");
	         while(string_token.hasMoreTokens()){
                       String s=(string_token.nextToken()).toString();
                        
                       if (stopword.contains(s)) {
                	continue;
                        }else{
                          int length=stem.steaming(s); //here count the length of the commom part of the steaming string 
                          char [] arr=new char[length];
                              for (int i=0;i<length ;i++ ) {
                                   arr[i]=s.charAt(i);
                                } 
				String steamed_word=new String(arr);
                               
				if(!invert_index.containsKey(steamed_word)){
                                    invert_index.put(steamed_word,new HashSet<>());
                                }
                                HashSet<String> sat=invert_index.get(steamed_word);
                                sat.add(file.getName());
                                  //HashSet<Integer> sat=invert_index.get(steamed_word); 
                                  //sat.add(id);
                                 
                                 
                          }
			}
                     } 
   bufferedreader.close(); 

                    
  }
catch(Exception e){
      }id++;
}
}
