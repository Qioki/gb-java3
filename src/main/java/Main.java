import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {


    static String path = "./testdir/";
    static int pageSize = 1800;

    public static void main(final String[] args) throws IOException {
        
        //readSimpleFile(path + "f1");

        //appendFromFiles(new File[]{ new File(path + "f1"), new File(path + "f2"), new File(path + "f3")});
        
        bookReader();
    }

    
    /* 
        Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). 
        Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. 
        Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    */
    public static void bookReader() throws IOException { 

        System.out.print("Введите стартовую страницу: ");
		Scanner scaner = new Scanner(System.in);
        int page = scaner.nextInt() - 1;

        try (RandomAccessFile raf = new RandomAccessFile(path + "book", "r")){
            openPage(raf, page++);

            System.out.println("Введите \"1\" для продолжения. Введите \"0\" чтобы выйти. ");
            int command;
            boolean hasNextPage;
            do{
                command = scaner.nextInt();
                hasNextPage = openPage(raf, page++);

            } while(command != 0 && hasNextPage);
            
            raf.close();
        }

        scaner.close();
    }
    public static boolean openPage(RandomAccessFile raf, int page) throws IOException {
        if(page < 0) page = 0;

            raf.seek(page*pageSize);
            //System.out.println((char)raf.read());

            byte[] arr = new byte[pageSize];
            int x;
            x = raf.read(arr);
            if(x < 0) return false;

            System.out.println(new String(arr, 0, x, "UTF-8")); 
            return true;
    }


    ////////////////////////////////

    //Последовательно сшить 5 файлов в один (файлы примерно 100 байт). 
    public static void appendFromFiles(File[] files) throws IOException { 

        Vector<InputStream> v = new Vector<InputStream>();
        for (File f : files) {
            v.add(new FileInputStream(f));
        }
        SequenceInputStream sis = new SequenceInputStream(v.elements());
        
        File fnew =  new File(path + "book");
 
        try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fnew, true), "UTF-8")) {
            byte[] arr = new byte[512];
            int x;
            while((x = sis.read(arr)) > 0){ 
                osw.append(new String(arr, 0, x, "UTF-8"));
            }
            sis.close();
        } 
    }
    
    // Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
    public static void readSimpleFile(String pathToFile) throws IOException {
 
        final File f1 = new File(pathToFile); 

        try(FileInputStream in = new FileInputStream(f1)) {
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) > 0) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}