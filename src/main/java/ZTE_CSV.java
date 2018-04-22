import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ZTE_CSV {
    public static void main(String[] args ){
        List<Student> list = ReadCSV();
        List<Student> res = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int[] sort = new int[3];
        System.out.println("请输入按id排序，按年龄排序，按成绩排序的排序方式（0为升序，1为降序，例如输入 0 0 0）：");
        sort[0] = s.nextInt();
        sort[1] = s.nextInt();
        sort[2] = s.nextInt();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId() < o2.getId())
                    return -1;
                if(o1.getId() > o2.getId())
                    return 1;
                return 0;
            }
        });
        if(sort[0] == 1)
            Collections.reverse(list);
        res.addAll(list);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() < o2.getAge())
                    return -1;
                if(o1.getAge() > o2.getAge())
                    return 1;
                return 0;
            }
        });
        if(sort[1] == 1)
            Collections.reverse(list);
        res.addAll(list);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() < o2.getScore())
                    return -1;
                if(o1.getScore() > o2.getScore())
                    return 1;
                return 0;
            }
        });
        if(sort[2] == 1)
            Collections.reverse(list);
        res.addAll(list);
        print(res);
        writeCSV(res);
    }

    public static void print(List<Student> list){
        for(Student s:list){
            System.out.println(s.toString());
        }
    }

    //读取CSV文件
    public static List<Student> ReadCSV(){
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            //注意将stuInfo.csv保存为utf-8，若ANSI格式，需要转换，可以使用GBK编码，但使用utf-8依旧乱码
            BufferedReader reader  = new BufferedReader(new FileReader("F:/code/stuInfo.csv"));
            //DataInputStream in = new DataInputStream(new FileInputStream(new File("F:\\code\\stuInfo.csv")));
            //BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                Student student = new Student();
                student.id = Integer.parseInt(item[0]);
                student.name = item[1];
                student.age = Integer.parseInt(item[2]);
                student.score = Double.parseDouble(item[3]);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  studentList;
    }

    public static void writeCSV(List<Student> list){
        try {
            //注意将stuInfo.csv保存为utf-8，若ANSI格式，需要转换，可以使用GBK编码，但使用utf-8依旧乱码
            BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("F:\\code\\stuwriteInfo.csv"), "gb2312" ));
            //DataInputStream in = new DataInputStream(new FileInputStream(new File("F:\\code\\stuInfo.csv")));
            //BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));
            bw.write("学号,"+"姓名,"+"年龄,"+"成绩");
            bw.newLine();
            for(Student s:list){
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
