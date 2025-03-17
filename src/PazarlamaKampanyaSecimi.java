import java.util.Arrays;
import java.util.Scanner;

class PazarlamaKampanyaSecimi {
    static int[] kampanyaMaliyetleri;
    static int[] kampanyaROI;
    static int butce;
    static int kampanyaSayisi;
    static int[][] dpKampanya;

    public static int kampanyaSec() {
        dpKampanya = new int[kampanyaSayisi + 1][butce + 1];

        for (int i = 0; i <= kampanyaSayisi; i++) {
            for (int j = 0; j <= butce; j++) {
                if (i == 0 || j == 0) {
                    dpKampanya[i][j] = 0;
                } else if (kampanyaMaliyetleri[i - 1] <= j) {
                    dpKampanya[i][j] = Math.max(kampanyaROI[i - 1] + dpKampanya[i - 1][j - kampanyaMaliyetleri[i - 1]], dpKampanya[i - 1][j]);
                } else {
                    dpKampanya[i][j] = dpKampanya[i - 1][j];
                }
            }
        }

        return dpKampanya[kampanyaSayisi][butce];
    }
}
