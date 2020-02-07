import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Publisher publisher1 = new Publisher("Joe");
        Publisher publisher2 = new Publisher("Sam");

        Subscriber subscriber1 = new Subscriber("Dep");
        Subscriber subscriber2 = new Subscriber("Kev");

        Video video1 = new Video("TITLE 1");
        Video video2 = new Video("TITLE 2");
        Video video3 = new Video("TITLE 3");
        Video video4 = new Video("TITLE 4");
        Video video5 = new Video("TITLE 5");

        subscriber1.subscribe(publisher1);
        publisher1.uploadVideo(video1);

        subscriber2.subscribe(publisher1);
        publisher1.uploadVideo(video2);

        subscriber1.printTimeline();
        // should print = Dep : [TITLE 1] [TITLE 2]
        subscriber2.printTimeline();
        // should print = Kev : [TITLE 2]

        subscriber1.watch(video2);
        subscriber2.watch(video2);
        subscriber1.watch(video2);
        video2.getDetails();
        // should print = [TITLE 2] - Joe - 3 views

        subscriber2.watch(video1);
        video1.getDetails();
        // should print = [TITLE 1] - Joe - 1 views
        // notice that subscriber2 does not have the video2 on his/her timeline, but the video can still be watched

        subscriber1.subscribe(publisher2);
        subscriber1.printPublishers();
        // should print = Dep : Joe Sam

        publisher2.uploadVideo(video3);

        subscriber1.printTimeline();
        // should print = Dep : [TITLE 1] [TITLE 2] [TITLE 3]
        subscriber2.printTimeline();
        // should print = Kev : [TITLE 2]

        publisher2.printSubscribers();
        // should print = Sam : Dep

        subscriber1.unsubscribe(publisher2);
        
        publisher2.printSubscribers();
        // should print = Sam :
        // no subscribers
        
        publisher2.uploadVideo(video4);
        publisher1.uploadVideo(video5);
        
        subscriber1.printTimeline();
        //should print = Dep : [TITLE 1] [TITLE 2] [TITLE 3] [TITLE 5]
        subscriber2.printTimeline();
        //should print = Kev : [TITLE 2] [TITLE 5]

    }
}

class Publisher{
    private String name;
    private ArrayList<Video> vids;
    private ArrayList<Subscriber> subs;
    
    /*Constructor
    */
    public Publisher(String n){
        this.name = n;
        this.vids = new ArrayList<Video>();
        this.subs = new ArrayList<Subscriber>();
        
    }

    /*publisher mengupload video
    */
    public void uploadVideo(Video v){
        v.setUploader(this);                        //meng-set uploader video
        this.vids.add(v);                           //memasukkan ke arraylist video
        for(int s=0; s<this.subs.size(); s++){      //memasukkan ke video subscriber
            subs.get(s).addTimeline(v);
        }
    }

    /*Mencetak subscriber
    */
    public void printSubscribers(){
        System.out.printf("%s : ", this.name);
        for(int i=0; i < this.subs.size(); i++){
            System.out.printf(subs.get(i).getSubs() + " ");
        }
        System.out.println();
    }

    /*menambahkan subscriber
    */
    public void subscriber(Subscriber s){
        this.subs.add(s);
    }

    /*mengeluarkan subscriber dari list
    */
    public void unSub(Subscriber s){
        this.subs.remove(this.subs.indexOf(s));
    }

    /*accessor nama
    */
    public String getPubs(){
        return this.name;
    }
}

class Subscriber{
    
    private String name;
    private ArrayList<Video> vids;
    private ArrayList<Publisher> pubs;

    /*Constructor
    */
    public Subscriber(String n){
        this.name = n;
        this.vids = new ArrayList<Video>();
        this.pubs = new ArrayList<Publisher>();
    }

    /*Menambahkan view counter
    */
    public void watch(Video v){
        v.addViewCounter();
    }

    /*Jika subscriber mengsubscribe
    */
    public void subscribe(Publisher p){
        this.pubs.add(p);
        p.subscriber(this);
    }

    /*Jika subscriber meng unsub
    */
    public void unsubscribe(Publisher p){
        this.pubs.remove(p);
        p.unSub(this);
    }

    /*Mencetak timeline
    */
    public void printTimeline(){
        System.out.printf("%s : ", this.name);
        for(int t=0; t < this.vids.size() ; t++){
            System.out.printf(vids.get(t).getTitle() + " ");
        }
        System.out.println();
    }

    /*Mencetak orang yang disubscribe
    */
    public void printPublishers(){
        System.out.print(this.name + " : ");
        for(int t=0; t < this.vids.size() ; t++){
            System.out.printf(pubs.get(t).getPubs() + " ");;
        }
        System.out.println();
    }

    /*Menambahkan video ke timeline
    */
    public void addTimeline(Video v){
        this.vids.add(v);
    }

    /*Mengambil nama subcriber
    */
    public String getSubs(){
        return this.name;
    }
}

class Video{

    private String title;
    private Integer viewCounter;
    private String uploader;

    public Video(String t){
        this.title = t;;
        this.viewCounter = 0;
    }

    public void setUploader(Publisher p){
        this.uploader = p.getPubs();
    }

    public String getTitle(){
        return this.title;
    }

    public void addViewCounter(){
        this.viewCounter++;
    }

    public void getDetails(){
        System.out.println(this.title + " - " + this.uploader + " - " + this.viewCounter + " views");
    }

}
