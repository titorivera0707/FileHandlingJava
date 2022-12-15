import java.util.Stack;
import java.util.*;
import java.io.*;
import org.w3c.dom.ls.LSException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileAnalysis {

	public static void main(String[] args) throws FileNotFoundException {

		//Create a file object to read from
		FileInputStream sourceFile= new FileInputStream(args[0]);
		
		//Create a target file object to write to
		FileOutputStream targetFile = new FileOutputStream(args[1]);
		
		//Declare variable of type PrintWriter, will be used to write to target file
		PrintWriter writer = null;
		
		try {
			// File reader
			Scanner reader = new Scanner(sourceFile);
            String readerString = null;
			// File writer
			writer = new PrintWriter(targetFile);
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			while (reader.hasNext()) {
                //System.out.println(reader.nextLine());
                readerString = reader.nextLine();
				char[] chars = readerString.toCharArray();

				for(char newChar: chars) {
					if(map.containsKey(newChar)) {

						map.put(newChar, map.get(newChar) + 1);

                    }else {
                        map.put(newChar, 1);
                    }
				}

			}

			for (Map.Entry newEntry: map.entrySet()) {
				System.out.println(newEntry.getKey() + " : " + newEntry.getValue());

		}

            System.out.println("Success");

            reader.close();

		} catch (ArrayIndexOutOfBoundsException aiobe){
            System.out.println("File already exists, use -f option to force overwrite.");
        }
		finally {
			if(writer!=null)writer.close();
		}
	}
}