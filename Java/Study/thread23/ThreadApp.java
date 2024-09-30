package thread23;

// 스레드로 구현하지 않은 클래스
class NotThread{
	String title;

	public NotThread(String title) {
		this.title = title;
	}
	
	// 스레드로 구현하지 않은 메소드
	void notThreadMethod() {
		// 아래 로직이 시간이 오래걸리는/IO 작업이라고 가정
		for(int i=1;i<=10;i++) {
			System.out.println(String.format("%s)i = %d", title,i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

// 스레드로 구현한 클래스
// 방법 1. Thread 클래스를 상속받아 스레드를 구현
class YesThread extends Thread{
	
	// 방법 3. 인자 생성자 : 매개변수(이자)로 스레드명으로 사용할 문자열 받음
	public YesThread(String threadName) {
		// runnable 타입 넣어주면 thread 타입이 됨
		super(threadName);
	}
	
	// 방법 2. run()메소드 오버라이딩
	//  - run()메소드안에 시간이 오래 걸리는 작업을 기술 -> 함수로 따로 뺌
	//	- run()메소드는 개발자가 직접 호출 불가, 스레드가 running 상태에 들어갔을 떄 자동으로 호출되는 메소드(콜백 메소드)
	@Override
	public void run() {
		threadMethod();
	}
	
	// 방법 4.
	void threadMethod() {
		for(int i=1;i<=10;i++) {
			System.out.println(String.format("%s)i = %d", getName(),i));
			try {
				// 스레드를 1/1000초 동안 wait상태에 빠지게 하는 메소드
				// 1/1000초 후에 다시 runnable 상태로 자동으로 돌아감
				sleep(500);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
}

//종속 스레드 만들기
// 보통 무한루프
class DaemonThread extends Thread{
	
	@Override
	public void run() {
		while(true) {
			System.out.println(String.format("%s > 배경음악이 흐르고있음...", getName()));
			System.out.println(String.format("%s > 3초마다 저장", getName()));
			try {
				sleep(3000);
			} catch(InterruptedException e) {e.printStackTrace();}
		}
		
	}
}

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread 시작");
		
		//스레드로 구현하지 않은 클래스 테스트
//		NotThread nt1 = new NotThread("1st class");
//		NotThread nt2 = new NotThread("2nd class");
//		nt1.notThreadMethod();
//		nt2.notThreadMethod();
		
		//스레드로 구현한 클래스 테스트
		YesThread yt1 = new YesThread("1st 스레드");
		YesThread yt2 = new YesThread("2nd 스레드");
		
		yt1.setName("첫번째 스레드");
		yt1.start();	//스레드를 runnable 상태로 전이시킴( run()메소드안의 코드가 실행되는 것은 아님)
		
		// join 메소드  
		/*
		 * 	1) start() 호출 후에 join()메소드를 호출해야 함.
		 *  2) join() 메소드를 호출한 스레드가 다 실행이 끝나야(dead) 다른 스레드가 동작한다.
		 */
		yt1.join(); // 컴파일 에러 throws 하기
		
		yt2.setPriority(Thread.MAX_PRIORITY);//우선 순위 설정하기, 보장X (확률만 높여주기, main thread는 우선권 5)
		yt2.start();
		
		// ◆
		DaemonThread daemonThread = new DaemonThread();
		// ◆ 데몬스레드로 설정하기
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		System.out.println("현재 활성화 상태(Runable 혹은 Running 상태)"+Thread.activeCount());
		// main, yt1, yt2
		System.out.println("첫번재 스레드 우선권 : "+yt1.getPriority());
		System.out.println("첫번재 스레드 우선권 : "+yt2.getPriority());
		// 따로 우선권 지정안하면 기본값인 5
		
		// (정적메소드) Thread.currentThread : 현재 running 상태에 있는 Thread 출력
		System.out.println("currentThread() : "+Thread.currentThread().getName());
		System.out.println("main 스레드 우선권 : "+Thread.currentThread().getPriority());
		
		System.out.println("main thread 종료");
		// main thread 종료 이후 thread 스케줄러가 runnable 상태의 스레드를 선택하여  호출
	}

}

/*
	독립 스레드(Non Daemon 스레드):
	    메인스레드와 working스레드(개발자가 만든 스레드)
		메인스레드가 끝나도 종료되지 않고 스레드가
		Dead상태 될때까지 계속 실행되는 스레드
	
	종속 스레드(Daemon 스레드):
		모든 독립스레드가 끝나면 자동으로 종료(Dead)가 되는
		스레드
		-주 스레드의 보조역할을 하는 스레드
		-종속 스레드는 주로 무한루프로 구성한다.
		-예]배경음악 깐다든지,10분마다 자동 저장한다든지 등등..
	
		어떤 스레드를 종속 스레드로 만들려면
		setDaemon(true)로 설정 (start 전에 set해주기)
*/
// 현재는 모두 독립스레드
