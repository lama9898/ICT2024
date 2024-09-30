package thread23;

import java.util.Scanner;

public class MediaPlayerApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MediaPlayer player = null;
		
		while(true) {
			System.out.println("1.재생 2.중지 3.종료");
			System.out.print("메뉴 입력 :");
			int menu = sc.nextInt();
			if(menu==1) {
				
				player = new MediaPlayer("music/music.mp3");
				player.setDaemon(true);
				player.start();
			}
			else if(menu==2) {
				if(player!=null) player.pause();
			}
			else break;
		}

	} //main

}	//class
