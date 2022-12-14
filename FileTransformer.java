//

import java.util.Stack;
import org.w3c.dom.ls.LSException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileTransformer {

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
			// File writer
			writer = new PrintWriter(targetFile);
			Stack<String> newStack = new Stack<String>();
			Stack<String> revStack = new Stack<String>();

			while (reader.hasNext()) {
                //System.out.println(reader.nextLine());
				String[] strings = reader.nextLine().split(" ");

				for(String newString: strings) {
					newStack.push(newString);
				}
				for(int x = 0; x<strings.length;x++) {
					revStack.push(newStack.pop());
				}

				System.out.println(revStack.toString());
				newStack.clear();
				revStack.clear();

			}

            System.out.println("Success");

            reader.close();

		} catch (ArrayIndexOutOfBoundsException aiobe){
            System.out.println(aiobe);
        }
		finally {
			if(writer!=null)writer.close();
		}
	}
}