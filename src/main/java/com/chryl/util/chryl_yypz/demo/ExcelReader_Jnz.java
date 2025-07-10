package com.chryl.util.chryl_yypz.demo;

import com.chryl.util.chryl_yypz.CollectionsToFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Chr.yl on 2025/7/9.
 *
 * @author Chr.yl
 */
public class ExcelReader_Jnz {
    static int columnIndex0 = 0;
    static int columnIndex1 = 1;

    static Map<String, String> jnzMap = new HashMap<>();
    static Set<String> jnzSet = new HashSet<>();

    public static void main(String[] args) {
        String excelFilePath = "/Users/chryl/Downloads/jnz.xlsx"; // Excel文件路径
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表，也可以使用workbook.getSheet("SheetName")按名称获取
            for (Row row : sheet) { // 遍历行
                String jnz = row.getCell(columnIndex0).getStringCellValue();
                String[] split = jnz.split(",");
//                System.out.print(jnz);
                String shengfen = row.getCell(columnIndex1).getStringCellValue();
//                System.out.print(shengfen);
                for (String s : split) {
                    String shengfenjnz = shengfen + "-" + s;
//                    jnzMap.put(shengfenjnz, shengfen);
                    jnzSet.add(shengfenjnz);
                }

//                for (Cell cell : row) { // 遍历列
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                        case NUMERIC:
//                            if (DateUtil.isCellDateFormatted(cell)) {
//                                System.out.print(cell.getDateCellValue() + "\t");
//                            } else {
//                                System.out.print(cell.getNumericCellValue() + "\t");
//                            }
//                            break;
//                        case BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue() + "\t");
//                            break;
//                        case FORMULA:
//                            System.out.print(cell.getCellFormula() + "\t");
//                            break;
//                        default:
//                            System.out.print("UNKNOWN TYPE\t"); // 对于未知类型，打印UNKNOWN TYPE并继续循环
//                    }
//                }
//                System.out.println(); // 换行以分隔各行数据
//                CollectionsToFile.writeMapToTextFile(jnzMap, "/Users/chryl/Downloads/jnzMap.txt");
                CollectionsToFile.writeSetToTextFile(jnzSet, "/Users/chryl/Downloads/jnzSet.txt");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


