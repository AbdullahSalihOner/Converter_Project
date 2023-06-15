package converterservice.numbertotext;

public class NumberToText {

	// Buraya Cevabı Göndercem
	public static String sayiyiYaziyaDonustur(int sayi) {
		if (sayi == 0) {
			return "sıfır";
		}

		String[] birler = { "", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz" };
		String[] onlar = { "", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan" };

		String yazi = "";

		if (sayi < 0) {
			yazi += "eksi ";
			sayi = -sayi;
		}

		if (sayi >= 1000000000) {
			yazi += sayiyiYaziyaDonustur(sayi / 1000000000) + " milyar ";
			sayi %= 1000000000;
		}

		if (sayi >= 1000000) {
			yazi += sayiyiYaziyaDonustur(sayi / 1000000) + " milyon ";
			sayi %= 1000000;
		}

		if (sayi >= 1000) {
			yazi += sayiyiYaziyaDonustur(sayi / 1000) + " bin ";
			sayi %= 1000;
		}

		if (sayi >= 100) {
			yazi += birler[sayi / 100] + " yüz ";
			sayi %= 100;
		}

		if (sayi >= 10) {
			yazi += onlar[sayi / 10] + " ";
			sayi %= 10;
		}

		if (sayi > 0) {
			yazi += birler[sayi] + " ";
		}

		return yazi.trim();
	}

	
	// İngilizce Sayılar için çalışan metod
	public static String numberToWords(int num) {
	    //if (num == 0) {
	    //    return "Zero";
	    //}

	    String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	    if (num < 20) {
	        return units[num];
	    }

	    if (num < 100) {
	        return tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
	    }

	    if (num < 1000) {
	        return units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " : "") + numberToWords(num % 100);
	    }

	    if (num < 1000000) {
	        return numberToWords(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " " : "") + numberToWords(num % 1000);
	    }

	    if (num < 1000000000) {
	        return numberToWords(num / 1000000) + " Million" + ((num % 1000000 != 0) ? " " : "") + numberToWords(num % 1000000);
	    }

	    return numberToWords(num / 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " : "") + numberToWords(num % 1000000000);
	}
}
