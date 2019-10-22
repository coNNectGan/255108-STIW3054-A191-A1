import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
public class saveToExcel {

    private static final String[] columns = {"Name", "Matric","GithubLink"};
    private static final String[] column = {"Name", "Matric"};

    public void WriteToExcel(ArrayList<Data> data, ArrayList<Data> data2) throws IOException {

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();
        //Create sheet
        Sheet sheet = workbook.createSheet("List Students");
        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 16);
        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        //create a  CellStyle with border
        CellStyle cellStyle = workbook.createCellStyle();
        //Create row
        Row headerRow = sheet.createRow(0);
        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        // Print data to row
        int rowNum = 1;
        for (Data datafirst : data) {
            Row row = sheet.createRow(rowNum++);
            Cell column1 = row.createCell(0);
            column1.setCellValue(datafirst.getName());
            column1.setCellStyle(cellStyle);
            Cell column2 = row.createCell(1);
            column2.setCellValue(datafirst.getMatric());
            column2.setCellStyle(cellStyle);
            Cell column3 = row.createCell(2);
            column3.setCellValue(datafirst.getLink());
            column3.setCellStyle(cellStyle);
        }
        rowNum=rowNum+2;
        Row headerRow2 = sheet.createRow(rowNum);
        // title
        for (int i = 0; i < column.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(column[i]);
            cell.setCellStyle(headerCellStyle);
        }
        rowNum=rowNum+1;
        for (Data dataSecond : data) {
            Row row = sheet.createRow(rowNum++);
            Cell column2 = row.createCell(0);
            column2.setCellValue(dataSecond.getName());
            column2.setCellStyle(cellStyle);
            Cell column3 = row.createCell(1);
            column3.setCellValue(dataSecond.getMatric());
            column3.setCellStyle(cellStyle);
        }
        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("C:\\RealTime\\Assignment1.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("\n\n\n"+"Excel file has successfully created..........");

    }

}
