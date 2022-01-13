package Otomasyon;

import java.awt.List;
import java.util.Scanner;

public class Anasayfa {


	
	public Anasayfa()
	{
		//departman bilgisini almak i�in departman dizisi olu�turuldu.Daha sonra olu�turma fonk. �a��r�ld�
		Departman[] departmanlar = Departman.Olustur();
		
		
		boolean durum=true;
		do{
			ekranayaz(".::MENU::.", true);
			ekranayaz("1) T�m Departmanlar� Listele", true);
			ekranayaz("2) Departman Ad�na G�re Arama Yap", true);
			ekranayaz("3) Personel  Ad�na G�re Arama Yap", true);
			ekranayaz("4) Servis G�zergah�na G�re Arama Yap", true);
			ekranayaz("5) Ya�� En B�y�k ve Em K���k Personel/Personelleri Bul", true);
			ekranayaz("6) ��k��", true);
			
			
			
			String secim=verigirisi("Se�im Yap�n�z:");
			
			switch (secim) {
			case "1":
				Departman.Listele(departmanlar);
		 		break;
		 		
			case "2":
				Departman.Ara(departmanlar, verigirisi("Departman Ad�:"));	
				break;
			
			case "3":
				Personel.Ara(departmanlar, verigirisi("Personel Ad�:"));	
			break;
				
			case "4":
				Servis.Ara(departmanlar, verigirisi("G�zergah Ad�:"));
				break;
			
			case "5":
				System.out.println("En k���k personel");
				Personel enk = Personel.Enk(departmanlar);
				System.out.print("Departman="+Departman.Ara(departmanlar, enk.getDepNo()).getDepAd());
				Personel.Yazdir(enk);
				System.out.println("En B�y�k personel");
				Personel enb = Personel.Enb(departmanlar);
				System.out.print("Departman="+Departman.Ara(departmanlar, enb.getDepNo()).getDepAd());
				Personel.Yazdir(enb);
				break;
			
			case "6":
			ekranayaz("��k�� Yap�ld�!", true);
			durum=false;
			break;
			
			default:
					ekranayaz("Ge�erli bir se�im yapmad�n�z!", true);
				break;
			}
			
		}while(durum);
		
		
	}
	public static void main(String[] args) {
		new Anasayfa();
	}
	
	//String veri giri�i i�in tan�mlanan metot
	public String verigirisi(String metin)
	{
		Scanner sc = new Scanner(System.in);
		ekranayaz(metin,false);
		return sc.nextLine();
	}
	
	//int veri giri�i i�in tan�ml� metot
	public int verigirisi_int(String metin)
	{
		Scanner sc = new Scanner(System.in);
		
		int veri=0;
		
		boolean durum=true;
		do{
			
			try{
				ekranayaz(metin,false);
				veri = sc.nextInt();
				durum=false;
			}catch(Exception ex){
				ekranayaz("Girilen Bilgi Hatal�!", true);
			}
		}
		while(durum);
		return veri; 
	}
	
	
	
	public void ekranayaz(String metin, boolean tur)
	{
		if(tur)
			System.out.println(metin); 
		else
			System.out.print(metin); 
	}
	}

