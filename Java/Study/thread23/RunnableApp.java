package thread23;

class Soldier{
	void longMethod() {
		for(int i=1;i<=10;i++) {
			System.out.println(String.format("스레드명 : %s, i = %d", Thread.currentThread().getName(),i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}	// void longMethod
}	//class Soldier

class Commander extends Soldier implements Runnable{
	// Soldier 를 상속받으면서 Thread로 구현하고 싶은 경우 → "Runnable Interface"
	
	// run() 오버라이딩
	@Override
	public void run() {
		longMethod();
	}
}

public class RunnableApp {

	public static void main(String[] args) {
		Commander commander = new Commander();
		//commander.start();	// .start()는 Thread 클래스에 있음. Runnable 인터페이스에는 없음
		System.out.println(commander instanceof Commander);
		System.out.println(commander instanceof Runnable);
		//System.out.println(commander instanceof Thread);	//상속관계가 아니기 때문에
		// Runnable 타입을 Thread타입으로 변환 불가
		
		Thread th1 = new Thread(commander);	//Thread 생성자 중 Runnable type 넣는 생성자가 있음
		th1.start();
		Thread th2 = new Thread(commander,"두번재 스레드");
		th2.start();

	}	//main

}	//class RunnableApp
