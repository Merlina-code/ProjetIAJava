/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;


// *****************************************************************************
// La classe Son illustre la lecture de fichiers son de type WAV,
// au format 16 bits monaural non compressé
// Installez et utilisez éventuellement Audacity dans la VM pour convertir vos
// propres sons dans ce format

public class SonFreq
{
	private int frequence;
	private float[] donnees;

	public int frequence() {return frequence;}
	public float[] donnees() {return donnees;}
	public float donnees1(int x) {return donnees[x];}

	// Constructeur d'un objet permettant de lire un fichier son mono-canal
	// 16 bits PCM little endian, en utilisant les API Java
	public SonFreq(final String nomFichier)
	{
		try
		{
			// Ouvrir le fichier comme une source audio
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(nomFichier));
			// Obtenir des informations sur cette source
			AudioFormat af = ais.getFormat();

			if (af.getChannels() == 1 &&	// Si le signal est monophonique
				af.getEncoding() == AudioFormat.Encoding.PCM_SIGNED &&	// et qu'il est en Pulse Code Modulation signé
				af.getSampleSizeInBits() == 16)	// et que les échantillons sont sur 16 bits
			{
				final int NombreDonnees = ais.available();	// Combien d'octets constituent les données
				final byte[] bufferOctets = new byte[NombreDonnees];	// Préparer un buffer pour lire tout le flux du fichier
				ais.read(bufferOctets);	// Lire le fichier dans le buffer d'octets
				ais.close();	// On peut fermer le flux du fichier
				ByteBuffer bb = ByteBuffer.wrap(bufferOctets);	// Prépare le travail sur le buffer
				bb.order(ByteOrder.LITTLE_ENDIAN);	// Indique le format des données lues dans le WAV
				ShortBuffer donneesAudio = bb.asShortBuffer();	// Préparer un buffer pour interpréter les données en tableau de short
				donnees = new float[donneesAudio.capacity()];
				for (int i = 0; i < donnees.length; ++i)
					donnees[i] = (float)donneesAudio.get(i);
				// Récupérer la fréquence du fichier audio
				frequence = (int)af.getSampleRate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static double plusProchePuissanceDe2(int nbr)
	{
		int k=0;
		while (Math.pow(2,k)<=nbr)
		{
			k++;
		}
		return(Math.pow(2,k-1));
	}
	
	public static float maxmod(Complexe[] signal,int freq,int n)
	{
		double modmax=0;
		int indexmodmax=0;
		int index=1;
		while (index<signal.length)
		{
			if(modmax<signal[index].mod())
			{
				//System.out.println("mod= "+signal[indexmodmax].mod()+"mod2= "+signal[index].mod());
				modmax=signal[index].mod();
				indexmodmax=index;
				//System.out.println("mod="+signal[index].mod()+" freq="+freq+" index="+index+" n="n);
			}
			index++;
			//System.out.println("mod="+signal[index].mod());
		}
		System.out.println("f= "+indexmodmax*freq/n+" indexmax= "+indexmodmax);
		return (indexmodmax*freq/n);
	}
	
	public static void frequence(Complexe[] signal,int freq,int n)
	{
		for(int i=0;i<n;i++)
		System.out.println("f= "+i*freq/n);
	}
	
	public static void makeCplx(Complexe[] signal,SonFreq son)
	{
		for(int i=0;i<signal.length;++i)
			{
				signal[i] = new ComplexeCartesien(son.donnees[i],0);
				//System.out.println(sonsignal[i].reel()+" ; "+sonsignal[i].imag());
			}
	}

	public static void main (String[] args)
	{
		/*System.out.println("Lecture du fichier WAV "+args[0]);
		Son son = new Son(args[0]);
		System.out.println("Fichier "+args[0]+" : "+son.donnees().length+" échantillons à "+son.frequence()+"Hz");
		Complexe[] sonsignal = new Complexe[(int)plusProchePuissanceDe2(son.donnees().length)];
		for(int i=0;i<sonsignal.length;++i)
		{
			sonsignal[i] = new ComplexeCartesien(son.donnees[i],0);
			//System.out.println(sonsignal[i].reel()+" ; "+sonsignal[i].imag());
		}
		System.out.println("donnee "+sonsignal.length);
		Complexe[] resultat = FFTCplx.appliqueSur(sonsignal);*/
		SonFreq sonA3=new SonFreq("A3.wav");
		SonFreq sonA4=new SonFreq("A4.wav");
		SonFreq sonA5=new SonFreq("A5.wav");
		Complexe[] sonsignalA3 = new Complexe[(int)plusProchePuissanceDe2(sonA3.donnees().length)];
		Complexe[] sonsignalA4 = new Complexe[(int)plusProchePuissanceDe2(sonA4.donnees().length)];
		Complexe[] sonsignalA5 = new Complexe[(int)plusProchePuissanceDe2(sonA5.donnees().length)];
		makeCplx(sonsignalA3,sonA3);
		makeCplx(sonsignalA4,sonA4);
		makeCplx(sonsignalA5,sonA5);
		System.out.println("Application de la fft");
		Complexe[] resultatA3 = FFTCplx.appliqueSur(sonsignalA3);
		Complexe[] resultatA4 = FFTCplx.appliqueSur(sonsignalA4);
		Complexe[] resultatA5 = FFTCplx.appliqueSur(sonsignalA5);
		System.out.println("Debut de la partie IA");
		final float[] entrees = {maxmod(resultatA3,sonA3.frequence,sonA3.donnees().length),maxmod(resultatA4,sonA4.frequence,sonA4.donnees().length),maxmod(resultatA5,sonA5.frequence,sonA5.donnees().length)};
	
		// Tableau des sorties de la fonction ET
		final float[] resultats = {220, 440, 932};
		// On crée un neurone taillé pour apprendre la fonction ET
		/*final neurone n = new neurone(entrees.length);
		System.out.println("Debut de l'apprentissage");
		n.apprentissage(entrees, resultats);
		System.out.println("neurone1");
		for (int i = 0; i < entrees.length; ++i)
		{
			// Pour une entrée donnée
			final float  entree = entrees[i];
		
			// On met à jour la sortie du neurone
			n.metAJour(entree);
		
			// On affiche cette sortie
			System.out.println("Entree "+i+" : "+n.sortie());
		}*/
		//maxmod(resultat,son.frequence,son.donnees().length);
		/*for (int i = 0; i < resultat.length; ++i) {
		System.out.print(i+" : ("+(float)resultat[i].reel()+" ; "+(float)resultat[i].imag()+"i)");
		System.out.println(", ("+(float)resultat[i].mod()+" ; "+(float)resultat[i].arg()+" rad)");
		}*/
	}
}
