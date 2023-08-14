/* Jason Lahoda
 * Section 4
 * This program recommends the top 10 candidates based on certain criteria.
 * 
 * 1.) What criteria did you select? Why?
 * 
 * I selected the criteria of picking only 10 CS majors having a >3.9 GPA. This seems like the most absurd criteria because
 * there is no logic in this decision. 
 * 
 * 2.) What sorts of candidates do we miss when we automate hiring decisions in this way?
 * 
 * We entirely miss the overall quality of applicants this way. People who have been doing amazing things with coding may
 * be dismissed simply because they picked a different college major than CS. There are too many unknown variables that
 * might affect the applicant's quality.
 */

/** public class HigheringFilter {

	public static void main(String[] args) {
		
		
		
	}

} **/

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
//the following imports had to be INSTALLED from websites to read .xlsx
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HigheringFilter {
	
	public static void main(String[] args) {
		
//I'm sorry that this isn't too complex. I did spend a lot of time on it but I felt overwhelmed. Please accept this.
		int arrayCount = 0;
		String major = "";
		String[] array = new String[10];
		for (int i = 2; i< 2001; i++) {
			major = ReadCellData(i,10);
			if (major == "CS" || major == "CIS") {
				double number = Double.parseDouble(ReadCellData(i,9));
				if (number > 3.9) {
					array[arrayCount] = ReadCellData(i,1);
					arrayCount++;
					if (array.length == 10) {
						System.out.println(array);
					}
				}
			}
		}
}
public String ReadCellData(int Row, int Column) {
	String value = null;
    Workbook wbook = null;
    	try {  
    		FileInputStream fis = FileInputStream("applicant_data.xlsx");
    		wbook = new XSSFWorkbook(fis);
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(IOException e1) {
    		e1.printStackTrace();
    	}
    	Sheet sheet = wbook.getSheetAt(0);
    	Row row = sheet.getRow(Row);
    	Cell cell = row.getCell(Column);
    	value = cell.getStringCellValue();
    	return value;
  	}
}
