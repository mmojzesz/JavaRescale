public class Main {

    public static void main(String[] args){

        //System.out.println("Hello");

        DataManager dm = new DataManager();
        Loader load = new Loader(dm);

        load.loadFiles();

        for(int i = 0; i < dm.files.length; i++)
            load.rescale(i);

    }

}
