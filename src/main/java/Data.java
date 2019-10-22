public class Data {
    private String name,matric,link;

    //------------------------------------------------------------------
    public Data( String column1, String column2,String column3) {
        this.matric = column2;
        this.name = column1;
        this.link = column3;

    }

    public Data(String column1, String column2) {

        this.matric = column1;
        this.name = column2;
    }

    //------------------------------------------------------------------

    public String getMatric() {
        return matric;
    }
    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }



}
