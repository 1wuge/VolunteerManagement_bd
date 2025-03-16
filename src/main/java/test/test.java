package test;


import com.example.spring.service.TeacherService;
import com.example.spring.service.UserService;
import com.example.spring.service.VolunteerService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        /*File directory = new File("D:\\java_compile\\vueWorkSpace\\hellovuecli1\\public\\img");

        // 获取文件夹中的所有文件
        if (directory.exists() && directory.isDirectory()) {
            // 获取所有文件（包括文件夹）
            String[] files = directory.list();

            if (files != null) {
                List<String> a = UserService.getAvatars();
                List<String> b = TeacherService.getAvatars();
                a.addAll(b);

                ArrayList<String> c = new ArrayList<>();
                for (int i = 0; i < a.size(); i++) {
                    c.add(a.get(i).substring(6)); // 提取文件名
                }

                // 遍历文件列表，标记不需要删除的文件
                for (int i = 0; i < files.length; i++) {
                    for (int j = 0; j < c.size(); j++) {
                        if (files[i].equals(c.get(j))) {
                            files[i] = "1"; // 将匹配的文件标记为"1"
                        }
                    }
                }

                // 删除不等于"1"的文件
                for (int i = 0; i < files.length; i++) {
                    if (!files[i].equals("1")) {
                        File fileToDelete = new File(directory, files[i]);
                        if (fileToDelete.exists() && fileToDelete.isFile()) {
                            boolean deleted = fileToDelete.delete();
                            if (deleted) {
                                System.out.println("已删除文件: " + files[i]);
                            } else {
                                System.out.println("删除失败: " + files[i]);
                            }
                        }
                    }
                }

            } else {
                System.out.println("无法读取文件夹内容");
            }
        } else {
            System.out.println("指定的路径不是一个有效的文件夹");
        }*/
    }
}


