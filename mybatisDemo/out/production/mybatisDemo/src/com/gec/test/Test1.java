package com.gec.test;

import com.gec.pojo.User;
import com.gec.util.SessionTool;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.helpers.Integers;
import org.junit.Test;

import javax.swing.text.StringContent;
import java.io.*;

/**
 * @author Brice
 * @title: Test1
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2916:18
 */
public class Test1 {
    private Logger logger = Logger.getLogger(User.class);
    @Test
    public void fun1(){
        SqlSession session = SessionTool.foundSession(true);
        User user = session.selectOne("selectById", 1001);
        logger.debug(user);
    }
    @Test
    public void fun2(){
        SqlSession session = SessionTool.foundSession(true);
        User user = new User("王五", "123", "1232qq.com");
        int iter = session.insert("addUser", user);
        logger.debug(iter);
    }
    @Test
    public void fun3(){
        SqlSession session = SessionTool.foundSession(true);
        User user = session.selectOne("selectById", 1022);
        user.setUserPassword("123456");
        int iter = session.update("updateUser", user);
        logger.debug(iter);
    }
    @Test
    public void fun4() throws IOException {
        //稀疏数组
        int[][] sparseArr = new int[11][11];
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println("===================================================");
        sparseArr[1][2]=1;
        sparseArr[2][3]=2;
        sparseArr[6][3]=2;
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println("==================================================");
        //除0的数的数量
        int sum = 0;
        for(int[] i :sparseArr){
            for (int j:i
                 ) {
                if(j!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建稀疏数组
        int[][] newArr = new int[sum+1][3];
        newArr[0][0]=11;
        newArr[0][1]=11;
        newArr[0][2]=sum;
        //统计有多少值
        int count=0;
        for(int i = 0;i<sparseArr.length;i++){
            for (int j=0;j<sparseArr.length;j++){
                if (sparseArr[i][j]!=0){
                    count++;
                    newArr[count][0]=i;
                    newArr[count][1]=j;
                    newArr[count][2]=sparseArr[i][j];
                }
            }
        }
        File file = new File("aaa.txt");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        //写入文件
        for (int[] ints : newArr) {
            for (int anInt : ints) {
                System.out.println(anInt);
                bos.write((String.valueOf(anInt)+" ").getBytes());
            }
        }
        bos.close();


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[1024];
        int len = 0;
        String str ="";
        while((len=bis.read(b))>0){
            str = new String(b,0,len);
        }
        System.out.println("1111111111111111111111111");
        String[] s = str.split(" ");
        System.out.println(s.length);
        int[][] newArr3 = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
        for (int i = 3; i <s.length ; i+=3) {
            System.out.println(i);
            newArr3[Integer.parseInt(s[i])][Integer.parseInt(s[i+1])]=Integer.parseInt(s[i+2]);

        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (int[] ints : newArr3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        //遍历稀疏数组
        System.out.println("==================================================");
        for (int[] ints : newArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        System.out.println("==================================================");
        int[][] newArr2 = new int[newArr[0][0]][newArr[0][1]];
        for (int i = 1; i <newArr.length ; i++) {
            newArr2[newArr[i][0]][newArr[i][1]]=newArr[i][2];
        }
        for (int[] ints : newArr2) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
    @Test
    public void fun6(){
        int[] data = { 137, 89, 82, 181, 50, 220, 103, 20, 0, 59 };
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("pic.txt"), "utf-8");
            for (int i = 0; i < data.length; i++)
                osw.write(String.valueOf(data[i]));
            osw.close();
        } catch (IOException e) {
            System.out.println("Error - " + e.toString());
        }
    }
}
