
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class webScraping2 {

    private final ArrayList<Data> tableGithub = new ArrayList<Data>();
    public  ArrayList<Data>  ScrapeData2() throws IOException {
        try {
            final String URL = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            final Document document = Jsoup.connect(URL).get();
            System.out.println("******************************************************************************************");
            System.out.println("                STIW3054-A191/Assignments/wiki/List_of_Student                            ");
            System.out.println("******************************************************************************************");
            Elements trs = document.getElementsByClass("div.markdown-body tr" );


            System.out.println("| No. | Matric | Name                             |");
            System.out.println("|-----|--------|----------------------------------|");
            for (int i = 1; i <= 35; i++) {
                Elements Matric= document.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
                Elements Name= document.select(" tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
                System.out.print("|");
                System.out.printf("%2d", i);
                System.out.print("|");
                System.out.printf(""+Matric.text().trim());
                System.out.print("|");
                System.out.printf(""+Name.text().trim());
                System.out.print("\n");

                tableGithub.add(new Data(Matric.text().trim(),Name.text().trim()));
            }
            System.out.println("-----------------------------------------------------------------------------------------");


        } catch (Exception e) {
            System.out.println("" + e);
        }
        return tableGithub;

    }
}
