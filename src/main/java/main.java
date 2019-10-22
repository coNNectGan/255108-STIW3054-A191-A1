import java.io.IOException;
import java.util.ArrayList;

public class main {
    private static ArrayList<Data> commentGithub= new ArrayList<Data>();;
    private static ArrayList<Data> tableGithub = new ArrayList<Data>();
    private static ArrayList<Data> compareData = new ArrayList<Data>();


    private static ArrayList[] dataC = new ArrayList[70];

    public static void main(String[] args) throws IOException {
        webScraping2 webScraping2 = new webScraping2();

        webScraping1 webScraping1 = new webScraping1();
        remove removeKer = new remove();

        commentGithub = webScraping1.ScrapeData();
        tableGithub = webScraping2.ScrapeData2();

        System.out.println("----------------------------------------------");
        for(int i =0; i<commentGithub.size();i++){


         ArrayList[] str = dataC;
         int n = str.length;
           removeKer.removeDuplicate(str,n);
           removeKer.removeDuplicate(str,n);
           compareData.remove(dataC);
        }

        for (int i =1; i<=compareData.size();i++){
        System.out.println(compareData.get(i).getMatric());}

        saveToExcel excel= new saveToExcel();
        excel.WriteToExcel(commentGithub,tableGithub);

    }
}
