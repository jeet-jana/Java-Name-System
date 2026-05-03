import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Test100{
    String[] arr = {"Jeet Jana","Sumit Audhikari","Raunack Manna"};
    List<String> list = new ArrayList<>(Arrays.asList(arr));
    public static void print(List<String> list){
        System.out.println("Roll Name");
        for (int i = 0; i <= list.size() - 1; i++) {
            System.out.println((i+1)+"   "+list.get(i));
        }
    }

    void Add(String name){
        list.add(name);
        print(list);
        Csv();
    }

    void Remove(String name){
        list.remove(name);
        print(list);
        Csv();
    }

    void Search(String name){
        int count = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            if(list.get(i).equals(name)){
                System.out.println(name + "   has roll   " + (i+1));
                count++;
            }
        }
        if(count == 0){
            System.out.println("Invalid Name or This Number Does not exit");
        }
    }
    void Csv(){
        try{
            FileWriter writer = new FileWriter("Student.csv");
            writer.append("Roll   Name");
            writer.append("\n");
            int i =1;
            for(String s : list){
                writer.append(i +"       "+ s);
                writer.append('\n');
                i++;
            }
            writer.close();
            System.out.println("File Created");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
class Child3 extends Test100{
    Scanner sc = new Scanner(System.in);
    void NameInt(){
        System.out.println("Enter The Student name You Want To add:");
        String name = sc.nextLine();
        System.out.println("After Operation--------------");
        Add(name);
    }
    void NameRem(){
        System.out.println("Enter The Student name You Want To Remove:");
        String name = sc.nextLine();
        System.out.println("After Operation--------------");
        Remove(name);
    }
    void Nameser(){
        System.out.println("Enter The Student name You Want To Search:");
        String name = sc.nextLine();
        System.out.println("After Operation--------------");
        Search(name);
    }
    
}

class Option extends Child3{
    void Options(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Options \n 1.Add Name \n 2.Remove Name \n 3. Search Name \n 4.Conver into csv \n ------>");
        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                NameInt();
                break;
            case 2:
                NameRem();
                break;
            case 3:
                Nameser();
                break;
            case 4:
                Csv();
                break;
        
            default:
                break;
        }
        sc.close();
    }
}

public class Test {
    public static void main(String[] args) {
        Option o1 = new Option();
        o1.Options();
    }
}