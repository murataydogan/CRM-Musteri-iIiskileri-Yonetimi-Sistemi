import java.util.Arrays;
import java.util.Scanner;

public class CRMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Müşteri Destek Temsilcisi Yönlendirme ---");
        System.out.print("Müşteri sayısını girin: ");
        MusteriDestekYonlendirme.musteriSayisi = scanner.nextInt();

        System.out.print("Temsilci sayısını girin: ");
        MusteriDestekYonlendirme.temsilciSayisi = scanner.nextInt();

        MusteriDestekYonlendirme.musteriTalepleri = new int[MusteriDestekYonlendirme.musteriSayisi][MusteriDestekYonlendirme.temsilciSayisi];
        MusteriDestekYonlendirme.temsilciUygunluk = new int[MusteriDestekYonlendirme.temsilciSayisi];

        System.out.println("Müşteri taleplerini girin:");
        for (int i = 0; i < MusteriDestekYonlendirme.musteriSayisi; i++) {
            for (int j = 0; j < MusteriDestekYonlendirme.temsilciSayisi; j++) {
                System.out.print("Müşteri " + (i + 1) + ", Temsilci " + (j + 1) + " için uygunluk puanı: ");
                MusteriDestekYonlendirme.musteriTalepleri[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Temsilci uygunluklarını girin (1: Uygun, 0: Uygun değil):");
        for (int j = 0; j < MusteriDestekYonlendirme.temsilciSayisi; j++) {
            System.out.print("Temsilci " + (j + 1) + " uygun mu? ");
            MusteriDestekYonlendirme.temsilciUygunluk[j] = scanner.nextInt();
        }

        int maksimumDestekPuanı = MusteriDestekYonlendirme.temsilciAta();
        System.out.println("Maksimum Uygunluk Puanı (Destek): " + maksimumDestekPuanı);
        
        System.out.println("\n--- Pazarlama Kampanyası Seçimi ---");
        System.out.print("Kampanya sayısını girin: ");
        PazarlamaKampanyaSecimi.kampanyaSayisi = scanner.nextInt();

        System.out.print("Bütçeyi girin: ");
        PazarlamaKampanyaSecimi.butce = scanner.nextInt();

        PazarlamaKampanyaSecimi.kampanyaMaliyetleri = new int[PazarlamaKampanyaSecimi.kampanyaSayisi];
        PazarlamaKampanyaSecimi.kampanyaROI = new int[PazarlamaKampanyaSecimi.kampanyaSayisi];

        System.out.println("Kampanya maliyetlerini girin:");
        for (int i = 0; i < PazarlamaKampanyaSecimi.kampanyaSayisi; i++) {
            System.out.print("Kampanya " + (i + 1) + " maliyeti: ");
            PazarlamaKampanyaSecimi.kampanyaMaliyetleri[i] = scanner.nextInt();
        }

        System.out.println("Kampanya ROI değerlerini girin:");
        for (int i = 0; i < PazarlamaKampanyaSecimi.kampanyaSayisi; i++) {
            System.out.print("Kampanya " + (i + 1) + " ROI: ");
            PazarlamaKampanyaSecimi.kampanyaROI[i] = scanner.nextInt();
        }

        int maksimumROI = PazarlamaKampanyaSecimi.kampanyaSec();
        System.out.println("Maksimum ROI (Pazarlama): " + maksimumROI);

        scanner.close();
    }
}