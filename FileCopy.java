import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FileCopy {

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

			while (reader.hasNext()) {
				writer.println(reader.nextLine());
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