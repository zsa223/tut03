package semaphore;

import java.util.concurrent.Semaphore;

public class Discounter {
    static int kundenZahl = 20;

    static int maxGleichzeitig = 5;
    static Discounter aldi = new Discounter();

    private Semaphore einkaufswagen = new Semaphore(maxGleichzeitig);

    public boolean einkaufen(Kunde kunde) {
        try {
            einkaufswagen.acquire();
            System.out.println("세마포어 고객 : " + kunde.kundenNr+ "darf einkaufen") ;
            Thread.sleep(500);
            System.out.println("세마포터 개곡님 : "+ kunde.kundenNr+ "geht");
            einkaufswagen.release();
        }catch (InterruptedException e){
            e.printStackTrace();
            return false;
        }
        return true;
        }



    public static void main(String[] args) {
        for (int i = 0; i < kundenZahl; i++) {
            new Kunde(i, aldi).start();
        }
    }
}
