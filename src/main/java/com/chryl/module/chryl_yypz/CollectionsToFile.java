package com.chryl.module.chryl_yypz;


import com.chryl.module.chryl_yypz.model.JnzModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合导出文件
 * Created by Chr.yl on 2025/5/21.
 *
 * @author Chr.yl
 */
public class CollectionsToFile {


    //    public static void main(String[] args) {
//        List<String> list = List.of("Apple", "Banana", "Cherry");
//        writeListToTextFile(list, "output.txt");
//    }

    public static void writeMapToTextFile(Map<String, String> map, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            map.forEach((key, value) -> {
                // 处理key和value
                try {
//                    writer.write(key + ":" + value);
                    writer.write(key);
                    writer.newLine(); // 新的一行
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeListToTextFile(List<String> list, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine(); // 新的一行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeSetToTextFile(Set<String> set, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String item : set) {
                writer.write(item);
                writer.newLine(); // 新的一行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeModelListToTextFile(List<JnzModel> list, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (JnzModel jnzModel : list) {
                writer.write(jnzModel.getShengfen_name());
                writer.write(jnzModel.getShengfen_code());
                writer.write(jnzModel.getJnz_name());
                writer.write(jnzModel.getJnc_code());
                writer.newLine(); // 新的一行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeModelSetToTextFile(Set<JnzModel> set, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (JnzModel jnzModel : set) {
                writer.write(jnzModel.getShengfen_name());
                writer.write(jnzModel.getShengfen_code());
                writer.write(jnzModel.getJnz_name());
                writer.write(jnzModel.getJnc_code());
                writer.newLine(); // 新的一行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
