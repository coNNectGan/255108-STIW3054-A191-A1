
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class webScraping1 {

        //Declare arraylist for commentGithub
        public final ArrayList<Data> commentGithub = new ArrayList<Data>();

        public ArrayList<Data>  ScrapeData() throws IOException {
            try {
                //get the page link and connect to document
                String URL = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
                Document document = Jsoup.connect(URL).get();

                //print the title
                System.out.println("******************************************************************************************");
                System.out.println("                           STIW3054-A191/Main-Issues                                      ");
                System.out.println("******************************************************************************************");

                //get the element from the html
                Elements trs = document.getElementsByClass("d-block comment-body markdown-body  js-comment-body" );
                org.jsoup.select.Elements rows = trs.select("ol");

                //declare name , matric , link
                 String name=" ",matric=" ",link =" ";

                //for each loop at each comment
                for(Element tableAcc:trs){
                    Elements commentBlock=tableAcc.getElementsByTag("p");
                    String comment = commentBlock.select("p").toString();

                    Pattern nameP = Pattern.compile("Name: (.*?)<br>|Name :(.*?)<br>|:\\s(U.*)<br>|Name:(.*?)<br>|name :( .*?)<br> |Name (.*?)<br>");
                    Matcher nameM = nameP.matcher(comment);

                    while(nameM.find()){
                        name = nameM.group(0).replace("<br>","").replace("name :","").replace("Name :","").replace("Name:","").replace(":","").replace("Name ","").trim();
                    }


                    Pattern matricP = Pattern.compile("(\\b2.*?)<br>"); // compile
                    Matcher matricM = matricP.matcher(comment);
                    while(matricM.find()){
                        matric = matricM.group(1).trim();
                    }

                    link=tableAcc.getElementsByTag("a").attr("abs:href");



                    commentGithub.add(new Data(name,matric,link));
                }
                System.out.println("| No. | Matric | Name                             |GitHubLink");
                System.out.println("|-----|--------|----------------------------------|---------|");

                for(int i =1; i<commentGithub.size();i++){
                    System.out.println("|  "+i+"  |"+commentGithub.get(i).getMatric()+"|"+commentGithub.get(i).getName()+"|"+commentGithub.get(i).getLink()+"|");

                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

            } catch (Exception e) {
                System.out.println(""+e);
            }
            return commentGithub;
        }


    }
