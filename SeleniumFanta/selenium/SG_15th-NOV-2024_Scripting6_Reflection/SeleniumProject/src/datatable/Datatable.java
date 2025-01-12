package datatable;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.Calendar;

public class Datatable {
    /*************************************************
     * Name     : getRowCount
     *
     **************************************************/
    public int getRowCount(String filePath, String sheetName){
        FileInputStream fin = null;
        Workbook wb = null;
        Sheet sh = null;
        try{
            fin = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);
            if(sh==null){
                System.out.println("The sheet '"+sheetName+"' doesnot exist");
                return -1;
            }
            return sh.getPhysicalNumberOfRows()-1;
        }catch(Exception e){
            System.out.println("Exception in 'getRowCount() method. "+ e);
            return -1;
        }finally{
            try{
                fin.close();
                fin = null;
                sh = null;
                wb.close();
                wb = null;
            }catch(Exception e){}
        }
    }


    /*************************************************
     * Name     : getRowCount
     *
     **************************************************/
    public String getCellData(String filePath, String sheetName, String columnName, int rowNum){
        FileInputStream fin = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        String cellData = null;
        int colNum = 0;
        boolean flag = false;
        Calendar cal = null;
        try{
            fin = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);
            if(sh==null){
                System.out.println("The sheet '"+sheetName+"' doesnot exist");
                return null;
            }

            //Find the column number based on column name
            row = sh.getRow(0);
            for(int c=0; c<row.getLastCellNum(); c++){
                cell = row.getCell(c);
                if(cell.getStringCellValue().equalsIgnoreCase(columnName)){
                    colNum = c;
                    flag = true;
                    break;
                }
            }

            if(flag == true){
                row = sh.getRow(rowNum);
                cell = row.getCell(colNum);

                //format the cell data
                if(cell==null || cell.getCellType()== CellType.BLANK){
                    cellData = "";
                }else if(cell.getCellType()==CellType.BOOLEAN){
                    cellData = String.valueOf(cell.getBooleanCellValue());
                }else if(cell.getCellType()==CellType.STRING){
                    cellData = cell.getStringCellValue();
                }else if(cell.getCellType()==CellType.NUMERIC){
                    if(DateUtil.isCellDateFormatted(cell)==true){
                        double dt = cell.getNumericCellValue();
                        cal = Calendar.getInstance();
                        cal.setTime(DateUtil.getJavaDate(dt));
                        cellData = String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"/"+String.valueOf(cal.get(Calendar.MONTH)+1)+"/"+String.valueOf(cal.get(Calendar.YEAR));
                    }else{
                        cellData = String.valueOf(cell.getNumericCellValue());
                    }
                }
                return cellData;
            }else{
                System.out.println("Failed to find the column number based on Column name");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in 'getCellData() method. "+ e);
            return null;
        }finally{
            try{
                fin.close();
                fin = null;
                cell = null;
                sh = null;
                row = null;
                wb.close();
                wb = null;
                cal = null;
            }catch(Exception e){}
        }
    }


}
