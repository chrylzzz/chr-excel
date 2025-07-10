package com.chryl.util.chryl_yypz.demo;

import com.chryl.util.chryl_yypz.CollectionsToExcel;
import com.chryl.util.chryl_yypz.CollectionsToFile;
import com.chryl.util.chryl_yypz.model.JnzModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Chr.yl on 2025/7/9.
 *
 * @author Chr.yl
 */
public class ExcelReader_Jnz_convert {
    static int columnIndex0 = 0;
    static int columnIndex1 = 1;
    static int columnIndex2 = 2;

    static Map<String, String> shengfenMap = new HashMap<>();
    static Map<String, String> jnzMap = new HashMap<>();
    static List<JnzModel> jnzList = new ArrayList<>();
    static Set<JnzModel> jnzSet = new HashSet<>();


    static {
        shengfenMap.put("广东", "10001");
        shengfenMap.put("广西", "10002");
        shengfenMap.put("总部", "10003");
        shengfenMap.put("海南", "10004");
        shengfenMap.put("云南", "10005");
        shengfenMap.put("贵州", "10006");
        shengfenMap.put("超高压", "10007");
//广东，10001，技能组，1
    }

    public static void main(String[] args) {
        String excelFilePath = "/Users/chryl/Downloads/jnz.xlsx"; // Excel文件路径
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表，也可以使用workbook.getSheet("SheetName")按名称获取
            for (Row row : sheet) { // 遍历行
                String jnz_code = row.getCell(columnIndex0).getStringCellValue();
                String jnz_name = row.getCell(columnIndex1).getStringCellValue();
                String shengfen = row.getCell(columnIndex2).getStringCellValue();
                String[] code_arr = jnz_code.split(",");
                String[] name_arr = jnz_name.split(",");

                for (int i = 0; i < code_arr.length; i++) {
                    String shengfen_code = shengfenMap.get(shengfen);
                    String code = code_arr[i];
                    String name = name_arr[i];

                    JnzModel jnzModel = new JnzModel();
                    jnzModel.setShengfen_name(shengfen);
                    jnzModel.setShengfen_code(shengfen_code);
                    jnzModel.setJnc_code(code);
                    jnzModel.setJnz_name(name);

                    jnzList.add(jnzModel);
                    jnzSet.add(jnzModel);
                }

            }
//            CollectionsToFile.writeMapToTextFile(jnzMap, "/Users/chryl/Downloads/jnzMap.txt");
            CollectionsToFile.writeModelListToTextFile(jnzList, "/Users/chryl/Downloads/jnzList.txt");
            CollectionsToFile.writeModelSetToTextFile(jnzSet, "/Users/chryl/Downloads/jnzSet.txt");

            CollectionsToExcel.exportSetToExcel(jnzSet, "/Users/chryl/Downloads/jnzSet.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


