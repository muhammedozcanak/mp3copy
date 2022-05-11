
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    //Dosya okurken aldığımız integer verileri Arrayliste aktarmak için bir list oluşturduk.
    private static ArrayList<Integer> icerik = new ArrayList<>();
    
    public static void mp3Kopyala() {

        //Dosya okuma İşlemi Yaptık
        try {
            FileInputStream oku = new FileInputStream("assassins.mp3");
            
            int deger;
            
            while ((deger = oku.read()) != -1) {
                //verileri içerik adlı Arrayliste aktardık.
                icerik.add(deger);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Okuma Dosyası Bulunamadı");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mp3Yazdır(String dosyaIsmi) {
        
        try {
            //Dosyayı yazdırmak için bu kodu kullandık dosya ismi belirledik.
            FileOutputStream out = new FileOutputStream(dosyaIsmi);
            //foreach ile içeriğin içindeki verileri .write ile yazdırdık.
            for (Integer integer : icerik) {
                out.write(integer);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Yazma Dosyası Bulunamadı");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        
        mp3Kopyala();
        mp3Yazdır("assassins2.mp3");
    }
}
