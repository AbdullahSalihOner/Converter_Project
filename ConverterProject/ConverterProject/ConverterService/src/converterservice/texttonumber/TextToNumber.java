package converterservice.texttonumber;

import java.util.HashMap;

public class TextToNumber {

	public static long YazıyıSayıyaCevir(String sayiText) {
        // Rakamların ve değerlerinin tanımlandığı bir HashMap oluşturuyoruz
		
		//Türkçe Sayı İfadeleri
        HashMap<String, Long> rakamlar = new HashMap<String, Long>();
        rakamlar.put("sıfır", 0L);
        rakamlar.put("bir", 1L);
        rakamlar.put("iki", 2L);
        rakamlar.put("üç", 3L);
        rakamlar.put("dört", 4L);
        rakamlar.put("beş", 5L);
        rakamlar.put("altı", 6L);
        rakamlar.put("yedi", 7L);
        rakamlar.put("sekiz", 8L);
        rakamlar.put("dokuz", 9L);
        rakamlar.put("on", 10L);
        rakamlar.put("yirmi", 20L);
        rakamlar.put("otuz", 30L);
        rakamlar.put("kırk", 40L);
        rakamlar.put("elli", 50L);
        rakamlar.put("altmış", 60L);
        rakamlar.put("yetmiş", 70L);
        rakamlar.put("seksen", 80L);
        rakamlar.put("doksan", 90L);
        rakamlar.put("yüz", 100L);
        rakamlar.put("bin", 1000L);
        rakamlar.put("milyon", 1000000L);
        rakamlar.put("milyar", 1000000000L);
        
        
       

        // Metni boşluklardan ayırarak her kelimeyi diziye atıyoruz
        String[] kelimeler = sayiText.toLowerCase().split(" ");
        

        long toplam = 0L;
        long geciciToplam = 0L;
        long oncekiBasamakDegeri = 0L;
        // Sayı kelimlerini tek tek eklediğmiz dizi uzunluğunda dönen bir for döngüsü yapıyoruz
        for (int i = 0; i < kelimeler.length; i++) {
            long deger = rakamlar.get(kelimeler[i]);//i. kelimenin HashMap deki karşılığını deger değişkenine atıyoruz
            if (deger < 1000L) {
                if (deger == 100L) {  // "yüz" ise geçici toplamı bununla çarp
                    geciciToplam *= deger;
                } else {
                    geciciToplam += deger;
                }
            } else {
                if (deger < 1000000L) {
                    geciciToplam *= deger;
                    toplam += geciciToplam;
                    geciciToplam = 0L;
                } else {
                    toplam += geciciToplam * deger;
                    geciciToplam = 0L;
                    oncekiBasamakDegeri = deger;
                }
            }
        }

        toplam += geciciToplam;
        return toplam;
    }
	
	
	
	public static long convertEnglishToNumber(String text) {
	    HashMap<String, Long> numberWords = new HashMap<String, Long>();
	    numberWords.put("zero", 0L);
	    numberWords.put("one", 1L);
	    numberWords.put("two", 2L);
	    numberWords.put("three", 3L);
	    numberWords.put("four", 4L);
	    numberWords.put("five", 5L);
	    numberWords.put("six", 6L);
	    numberWords.put("seven", 7L);
	    numberWords.put("eight", 8L);
	    numberWords.put("nine", 9L);
	    numberWords.put("ten", 10L);
	    numberWords.put("eleven", 11L);
	    numberWords.put("twelve", 12L);
	    numberWords.put("thirteen", 13L);
	    numberWords.put("fourteen", 14L);
	    numberWords.put("fifteen", 15L);
	    numberWords.put("sixteen", 16L);
	    numberWords.put("seventeen", 17L);
	    numberWords.put("eighteen", 18L);
	    numberWords.put("nineteen", 19L);
	    numberWords.put("twenty", 20L);
	    numberWords.put("thirty", 30L);
	    numberWords.put("forty", 40L);
	    numberWords.put("fifty", 50L);
	    numberWords.put("sixty", 60L);
	    numberWords.put("seventy", 70L);
	    numberWords.put("eighty", 80L);
	    numberWords.put("ninety", 90L);
	    numberWords.put("hundred", 100L);
	    numberWords.put("thousand", 1000L);
	    numberWords.put("million", 1000000L);
	    numberWords.put("billion", 1000000000L);
	    
	    String[] words = text.toLowerCase().split(" ");
	    long result = 0;
	    long currentNumber = 0;
	    long currentMultiplier = 1;

	    for (String word : words) {
	        if (!numberWords.containsKey(word)) {
	            return -1; // Error: unknown word
	        }

	        long value = numberWords.get(word);

	        if (value == 100) {
	            if (currentNumber == 0) {
	                currentNumber = value;
	            } else if (currentNumber < 100) {
	                currentNumber *= value;
	            } else {
	                return -1; // Error: invalid combination of numbers
	            }
	        } else if (value == 1000 || value == 1000000 || value == 1000000000) {
	            currentMultiplier *= currentNumber * value;
	            result += currentMultiplier;
	            currentNumber = 0;
	            currentMultiplier = 1;
	        } else {
	            currentNumber += value;
	        }
	    }

	    result += currentNumber * currentMultiplier;
	    return result;
	}
	
}
