/**
* Ad Soyad: Ezgi Efsa Güleç
* Numara:250541023
* Proje: restoran sipariş
* Tarih: 20.11.2025
*/

	import java.util.Scanner;

	public class restoranSiparisi{

	    // ana yemek fiyatı
	    public static double getMainDishPrice(int secim) {
	        switch (secim) {
	            case 1: return 85;
	            case 2: return 120; 
	            case 3: return 110;
	            case 4: return 65;
	            default: return 0;
	        }
	    }

	    // baslangıç fiyatı
	    public static double getAppetizerPrice(int secim) {
	        switch (secim) {
	            case 1: return 25;
	            case 2: return 45; 
	            case 3: return 55;
	            default: return 0;
	        }
	    }

	    // içecek fiyatı
	    public static double getDrinkPrice(int secim) {
	        switch (secim) {
	            case 1: return 15;
	            case 2: return 12;
	            case 3: return 35; 
	            default: return 0;
	        }
	    }

	    // tatlı fiyatı
	    public static double getDessertPrice(int secim) {
	        switch (secim) {
	            case 1: return 65; 
	            case 2: return 55;
	            case 3: return 35;
	            default: return 0;
	        }
	    }

	    // combo: ana yemek + içecek + tatlı varsa
	    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli) {
	        return ana && icecek && tatli;
	    }

	    // happy hour kontrolü
	    public static boolean isHappyHour(int saat) {
	        return saat >= 14 && saat <= 17;
	    }

	    // öğrenci indirimi için haftaiçi kontrolü
	    public static boolean isWeekday(int gun) {
	        return gun >= 1 && gun <= 5;
	    }

	    // indirim hesaplama
	    public static double calculateDiscount(double araToplam, boolean combo, boolean ogrenci, int saat, double icecekFiyat, int gun) {
	        double indirim = 0;

	        // combo indirimi %15
	        if (combo) {
	            indirim += araToplam * 0.15;
	        }

	        // happy hour 
	        if (isHappyHour(saat)) {
	            indirim += icecekFiyat * 0.20;
	        }

	        // öğrenci indirimi 
	        if (ogrenci && isWeekday(gun)) {
	            double kalan = araToplam - indirim;
	            indirim += kalan * 0.10;
	        }

	        return indirim;
	    }

	    public static double calculateServiceTip(double tutar) {
	        return tutar * 0.10;
	    }

	    public static void main(String[] args) {

	        Scanner ezgu = new Scanner(System.in);

	        System.out.print("Ana Yemek (1-4): ");
	        int ana = ezgu.nextInt();

	        System.out.print("Başlangıç (0-3): ");
	        int bas = ezgu.nextInt();

	        System.out.print("İçecek (0-4): ");
	        int icecek = ezgu.nextInt();

	        System.out.print("Tatlı (0-3): ");
	        int tatli = ezgu.nextInt();

	        System.out.print("Saat (8-23): ");
	        int saat = ezgu.nextInt();

	        System.out.print("Öğrenci misiniz? (E/H): ");
	        boolean ogrenci = ezgu.next().equalsIgnoreCase("E");

	        System.out.print("Gün (1-7): ");
	        int gun = ezgu.nextInt();

	        // fiyatlar
	        double anaFiyat = getMainDishPrice(ana);
	        double basFiyat = getAppetizerPrice(bas);
	        double icecekFiyat = getDrinkPrice(icecek);
	        double tatliFiyat = getDessertPrice(tatli);

	        double araToplam = anaFiyat + basFiyat + icecekFiyat + tatliFiyat;

	        boolean combo = isComboOrder(ana != 0, icecek != 0, tatli != 0);

	        double indirim = calculateDiscount(araToplam, combo, ogrenci, saat, icecekFiyat, gun);

	        double toplam = araToplam - indirim;

	        double bahsis = calculateServiceTip(toplam);

	        System.out.println("---------------");
	        System.out.println("Ara Toplam: " + araToplam + " TL");
	        System.out.println("İndirim: -" + String.format("%.2f", indirim) + " TL");
	        System.out.println("TOPLAM: " + String.format("%.2f", toplam) + " TL");
	        System.out.println("Bahşiş Önerisi: " + String.format("%.2f", bahsis) + " TL");
	    }
	}




