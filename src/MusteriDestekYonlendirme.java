import java.util.Arrays;
import java.util.Scanner;


class MusteriDestekYonlendirme {
    static int[][] musteriTalepleri;
    static int[] temsilciUygunluk;
    static int[][] dpDestek;
    static int musteriSayisi;
    static int temsilciSayisi;

    public static int temsilciAta() {
        dpDestek = new int[musteriSayisi + 1][temsilciSayisi + 1];

        for (int i = 0; i <= musteriSayisi; i++) {
            Arrays.fill(dpDestek[i], -1);
        }

        return ata(0, 0);
    }

    private static int ata(int musteriIndeks, int temsilciIndeks) {
        if (musteriIndeks == musteriSayisi) {
            return 0;
        }
        if (temsilciIndeks == temsilciSayisi) {
            return 0;
        }
        if (dpDestek[musteriIndeks][temsilciIndeks] != -1) {
            return dpDestek[musteriIndeks][temsilciIndeks];
        }

        int maksimumPuan = 0;

        if (temsilciUygunluk[temsilciIndeks] == 1) {
            int puan = musteriTalepleri[musteriIndeks][temsilciIndeks] + ata(musteriIndeks + 1, temsilciIndeks + 1);
            maksimumPuan = Math.max(maksimumPuan, puan);
        }

        maksimumPuan = Math.max(maksimumPuan, ata(musteriIndeks, temsilciIndeks + 1));

        dpDestek[musteriIndeks][temsilciIndeks] = maksimumPuan;
        return maksimumPuan;
    }
}
