import java.io.*;
import java.util.*;
import java.io.File;

 
public class ir_lab {

         public static void main(String a[]){

          InvertedIndex invert=new InvertedIndex();
            try{
	      File file = new File("/home/ravi/Desktop/project/programs/IR/hindi");   //here access the folder Documents and it will be  
	      File[] folder_all_files = file.listFiles();                               // store in File arry.
              Arrays.sort(folder_all_files);
              for(File file_list: folder_all_files){
		
                         //String[] fileList = file.list();
	     		 //for(String name:fileList){
             		 // System.out.println(name);
             		//}

		   //System.out.println(file_list.getName()); 
                 
 
		   //f.getName will print document name 

                   invert.invertedIndex(file_list);

                  }
             

            }catch(Exception e){


     }
    invert.storeIndex();
    //invert.printInvertedIndex();
    //invert.ReturnStore();
    invert.Search("के");
    

  }
 }
 
                

		 




        //this code was apply for filltering the file name 
	/*File[] files = file.listFiles(new FilenameFilter() {
             
            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".txt")){
                    return true;
                } else {
                    return false;
                }
            }
        });
        for(File f:files){
            System.out.println(f.getName());
        }*/
       // for (String key : Rvalue.keySet()) {
           // System.out.print(key+"  ");
            //Set<String> tr=Rvalue.get(key);
           //for (String s : tr) {
            //System.out.print(s+" ");
            //System.out.println();

//}
//- See more at: http://www.java2novice.com/java-file-io-operations/file-list-from-folder/#sthash.gydo8Y1O.dpuf
