/**
* Ad Soyad: Ezgi Efsa Güleç
* Numara:250541023
* Proje: not sistemi
* Tarih: 19.11.2025
*/



import java.util.Scanner;

public class secimYapilari {
	public static double calculateAverage(double vize_notu, double final_notu, double odev_notu) {
		return (vize_notu * 0.30) + (final_notu * 0.40) + (ödev_notu * 0.30);
	}

	public static boolean isPassingGrade(double average) {
		return average >= 50.0;

	}

	public static String getLetterGrade(double average) {
		if (average >= 90) {
			return "A";
		} else if (average >= 80) {
			return "B";

		} else if (average >= 70) {
			return " C";
		} else if (average >= 60) {
			return " D";
		} else {
			return "F";

		}

	}

	public static boolean isHonorList(double average, double vize_notu, double final_notu, double ödev_notu) {

		boolean isAverageHigh = average >= 85.0;
		boolean areAllGradesHigh = !(vize_notu < 70.0 || final_notu < 70.0 || ödev_notu < 70.0);
		return isAverageHigh && areAllGradesHigh;
	}

	public static boolean hasRetakeRight(double average) {
		return (average <= 40.0 && average < 50.0);

	}

	public static void main (String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		// girdiler
		System.out.print("Vize Notu Girin(0-100): ");
		double vize_notu =scanner. nextDouble();
		System.out.print("Final Notu Girin(0-100): ");
		double final_notu =scanner. nextDouble();
		System.out.print("Ödev Notu Girin(0-100): ");
		double odev_notu  =scanner. nextDouble();
		
		scanner.close();
		
		//hesaplamalar
		double ortalama = calculateAverage (vize_notu,final_notu,ödev_notu);
		String durum = isPassingGrade(ortalama) ? "gecti" : "kaldı";
		String harfNotu = getLetterGrade (ortalama);
		String onurListesi = isHonorList (ortalama, vize_notu, final_notu, ödev_notu) ? "EVET" : "HAYIR" ;
		String butunleme = hasRetakeRight (ortalama) ? "var" : "yok";
		
		
		System.out.println("\n=== ÖĞRENCİ NOT RAPORU ===");
        System.out.printf("Vize Notu : %.1f\n", vize_notu);
        System.out.printf("Final Notu : %.1f\n", final_notu);
        System.out.printf("Ödev Notu : %.1f\n", ödev_notu);
        System.out.println("------------------------------");
        System.out.printf("Ortalama : %.1f\n", ortalama);
        System.out.printf("Harf Notu : %s\n", harfNotu);
        System.out.printf("Durum : %s\n", durum);
        System.out.printf("Onur Listesi : %s\n", onurListesi);
        System.out.printf("Bütünleme : %s\n", butunleme);
        System.out.println("==============================");
		
	}
	}
