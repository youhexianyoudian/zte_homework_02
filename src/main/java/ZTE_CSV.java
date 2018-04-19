import java.io.*;

public class ZTE_CSV {
    public static void main(String[] args ){
        ReadCSV();
    }

    //读取CSV文件
    public static void ReadCSV(){
        try {
            //注意将stuInfo.csv保存为utf-8，若ANSI格式，需要转换，可以使用GBK编码，但使用utf-8依旧乱码
            BufferedReader reader  = new BufferedReader(new FileReader("F:/code/stuInfo.csv"));
            //DataInputStream in = new DataInputStream(new FileInputStream(new File("F:\\code\\stuInfo.csv")));
            //BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                for ( int i =0;i < item.length;i++){
                    String last = item[i];
                    System.out.println(last);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
