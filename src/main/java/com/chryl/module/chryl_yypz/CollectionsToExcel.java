package com.chryl.module.chryl_yypz;

import com.chryl.module.chryl_yypz.model.JnzModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/**
 * 集合导出excel
 * Created by Chr.yl on 2025/7/9.
 *
 * @author Chr.yl
 */

public class CollectionsToExcel {

    public static void exportSetToExcel(Set<JnzModel> data, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) { // 创建Workbook对象
            Sheet sheet = workbook.createSheet("Data"); // 创建Sheet对象
            int rowNum = 0;
//            for (String item : data) { // 遍历Set数据并写入Excel
//                Row row = sheet.createRow(rowNum++); // 创建行对象
//                Cell cell = row.createCell(0); // 创建单元格对象
//                cell.setCellValue(item); // 设置单元格的值
//            }

            //设置表头
//            Row row_ = sheet.createRow(rowNum); // 创建行对象
//            Cell cell0_ = row_.createCell(0); // 创建单元格对象
//            cell0_.setCellValue("shengfenName"); // 设置单元格的值
//
//            Cell cell1_ = row_.createCell(1); // 创建单元格对象
//            cell1_.setCellValue("shengfenCode"); // 设置单元格的值
//
//            Cell cell2_ = row_.createCell(2); // 创建单元格对象
//            cell2_.setCellValue("jnzName"); // 设置单元格的值
//
//            Cell cell3_ = row_.createCell(3); // 创建单元格对象
//            cell3_.setCellValue("jncCode"); // 设置单元格的值

            //设置表数据
            for (JnzModel jnzModel : data) {
                String shengfenName = jnzModel.getShengfen_name();
                String shengfenCode = jnzModel.getShengfen_code();
                String jnzName = jnzModel.getJnz_name();
                String jncCode = jnzModel.getJnc_code();
                Row row = sheet.createRow(rowNum++); // 创建行对象
                Cell cell0 = row.createCell(0); // 创建单元格对象
                cell0.setCellValue(shengfenName); // 设置单元格的值

                Cell cell1 = row.createCell(1); // 创建单元格对象
                cell1.setCellValue(shengfenCode); // 设置单元格的值

                Cell cell2 = row.createCell(2); // 创建单元格对象
                cell2.setCellValue(jnzName); // 设置单元格的值

                Cell cell3 = row.createCell(3); // 创建单元格对象
                cell3.setCellValue(jncCode); // 设置单元格的值
            }
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) { // 写入文件到磁盘
                workbook.write(outputStream); // 写入数据到文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
