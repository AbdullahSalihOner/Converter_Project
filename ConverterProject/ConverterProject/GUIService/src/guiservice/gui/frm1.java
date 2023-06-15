package guiservice.gui;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



import converterservice.numbertotext.NumberToText;
import converterservice.texttonumber.TextToNumber;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class frm1 extends JFrame {
	private JLabel label1, label2, label3;
    private JTextField textField1, textField2, textField3;
    private JButton button1, button2, button3, button4;


	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm1 frame = new frm1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm1() {  
		super("My Swing App");
		
		
		
		//Local deki mevcut dile göre ayarlanmasını sağladık
		//Messeages dosayalarımızdan local değerine göre gereki olan dili çektik
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		
		//Local dile göre değişen bir değişken oluşturdum
		boolean isTurkish = false;
		if(locale.getLanguage().equals("tr")) {
			isTurkish = true;
		}
		
		//Türkçe dışındaki local dilleri için ingilizce olarak program çalışıyor
		if (isTurkish) {
            bundle = ResourceBundle.getBundle("messages", new Locale("tr", "TR"));
        } else {
            bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        }
		
		
	    
		//Messages dosyasındaki key lerimizi girdik
	    String sayi1 = bundle.getString("sayi1");
	    String sayi2 = bundle.getString("sayi2");
	    String sonuc = bundle.getString("Sonuc");
		
	    
	   
		
		setTitle("Converter Project");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        
        //1. sayı değerini girdiğimiz kısım
        label1 = new JLabel(sayi1);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField1 = new JTextField(10);
        panel.add(label1);
        panel.add(textField1);

        //2.sayı değerini girdiğimiz kısım
        label2 = new JLabel(sayi2);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField2 = new JTextField(10);
        panel.add(label2);
        panel.add(textField2);
        
        //Sonucu yazdırdığımız kısım
        label3 = new JLabel(sonuc);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField3 = new JTextField(10);
        textField3.setEditable(false);
        panel.add(label3);
        panel.add(textField3);
        
        //İşlem seçtiğimiz buttonlarımız
        JPanel buttonPanel = new JPanel();
        button1 = new JButton(" + ");
        button1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        button2 = new JButton(" - ");
        button2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        button3 = new JButton(" x");
        button3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        button4 = new JButton(" / ");
        button4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        getContentPane().add(panel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

        // Buttonlara aksiyon ekledik
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Şart durumu ile Local de çalışan dile göre programı değiştirdik.
            	
            	if (locale.getLanguage().equals("tr")) { // Etkin dil Türkçe ise
            		long num1 = TextToNumber.YazıyıSayıyaCevir(textField1.getText());
                	long num2 = TextToNumber.YazıyıSayıyaCevir(textField2.getText());
                	
                	long sum = num1 + num2;
                    int newSum = (int)sum;
                    //3. text field a işlem sonucu Yazıya dönüştürerek ekledik
                    textField3.setText(NumberToText.sayiyiYaziyaDonustur(newSum));
                    
                } else { // Geri Kalan durumlar ingilizce
                	long num1 = TextToNumber.convertEnglishToNumber(textField1.getText());
                	long num2 = TextToNumber.convertEnglishToNumber(textField2.getText());
                	
                	long sum = num1 + num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.numberToWords(newSum));
                }
            	
            	
                
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (locale.getLanguage().equals("tr")) { // Etkin dil Türkçe ise
            		long num1 = TextToNumber.YazıyıSayıyaCevir(textField1.getText());
                	long num2 = TextToNumber.YazıyıSayıyaCevir(textField2.getText());
                	
                	long sum = num1 - num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.sayiyiYaziyaDonustur(newSum));
                    
                } else { // Geri Kalan durumlar ingilizce
                	long num1 = TextToNumber.convertEnglishToNumber(textField1.getText());
                	long num2 = TextToNumber.convertEnglishToNumber(textField2.getText());
                	
                	long sum = num1 - num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.numberToWords(newSum));
                }
            }
        });
        
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (locale.getLanguage().equals("tr")) { // Etkin dil Türkçe ise
            		long num1 = TextToNumber.YazıyıSayıyaCevir(textField1.getText());
                	long num2 = TextToNumber.YazıyıSayıyaCevir(textField2.getText());
                	
                	long sum = num1 * num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.sayiyiYaziyaDonustur(newSum));
                    
                } else { // Geri Kalan durumlar ingilizce
                	long num1 = TextToNumber.convertEnglishToNumber(textField1.getText());
                	long num2 = TextToNumber.convertEnglishToNumber(textField2.getText());
                	
                	long sum = num1 * num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.numberToWords(newSum));
                }
            }
        });
        
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (locale.getLanguage().equals("tr")) { // Etkin dil Türkçe ise
            		long num1 = TextToNumber.YazıyıSayıyaCevir(textField1.getText());
                	long num2 = TextToNumber.YazıyıSayıyaCevir(textField2.getText());
                	
                	long sum = num1 / num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.sayiyiYaziyaDonustur(newSum));
                    
                } else { // Geri Kalan durumlar ingilizce
                	long num1 = TextToNumber.convertEnglishToNumber(textField1.getText());
                	long num2 = TextToNumber.convertEnglishToNumber(textField2.getText());
                	
                	long sum = num1 / num2;
                    int newSum = (int)sum;
                    textField3.setText(NumberToText.numberToWords(newSum));
                }
            }
        });
	}

}
