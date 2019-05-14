package exercise.exercise_0514.ioTest;

import java.io.*;
import java.lang.reflect.Field;

public class InputStreamTest {
    //输出流
    public static void main1(String[] args){
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "lenovo"+File.separator+"Desktop"+File.separator+"Test");
        //2.写入数据
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write("Hello World".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.取得输入流
        InputStream in = null;
        try {
            //3.读取输入流
            in = new FileInputStream(file);
            int len = 0;
            byte[] data = new byte[1024];
            len = in.read(data);
            System.out.println(new String(data,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //文件拷贝
    public static void main2(String[] args) throws IOException {
        if(args.length != 2){
            System.out.println("参数异常");
        }
        File sourceFile = new File(args[0]);
        File destFile = new File(args[1]);
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(destFile);
        copyFile(in,out);
    }
    public static void copyFile(InputStream in ,OutputStream out) throws IOException {
        System.out.println("文件拷贝开始");
        long start = System.currentTimeMillis();
        byte[] data = new byte[4096];
        int len = 0;
        while((len = in.read(data)) != -1){
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝结束，用时："+(end-start)+"毫秒");
    }
    public static void main(String[] args) throws IOException {

    }
}
