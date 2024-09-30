package thread23;

//zzZ

// 동기화 블락을 이용한 데이터 동기화

/*	동기화 블락:
 * 	 synchronized(공유 메모리를 갖고 있는 객체){ 동기화할 로직 }
 * 
 *  - 여러 스레드가 공유하는 데이터를 갖고 있는 클래스-인스턴스를 하나만 생성
 *  - 각 스레드에 인스턴스 전달
 */

// 공유 데이터를 갖고 있는 클래스
//공유 데이터를 갖고 있는 클래스
class DataSyncClass{
	int shareData;	// 여러 스레드가 공유하는 메모리

	public DataSyncClass(int shareData) {
		this.shareData = shareData;
	}
}

//공유 데이터를 사용하는 스레드
class DataSyncThread extends Thread{
	DataSyncClass dsc;	//공유할 데이터를 갖고 있는 DataSyncClass 타입
	// 일정하게 증가시킬 숫자를 저장
	int inc;
	// 인자 생성자
	public DataSyncThread(DataSyncClass dsc, int inc, String threadName) {
		super(threadName);
		this.dsc = dsc;
		this.inc = inc;
	}
	
	void increase() {
		for(int i=0;i<=10;i++) {
			dsc.shareData+=inc;
			System.out.println(String.format("스레드 이름 : %s, 공유 데이터 :%s", getName(),dsc.shareData));
			try {
				sleep(500);
			} catch(InterruptedException e) { e.printStackTrace(); }
		}
	}
	
	@Override
	public void run() {
		// 동기화 전 ♠
		//increase();
		
		// 데이터 동기화 후 ♠
		synchronized(dsc) { increase(); }
	}
}

public class DataSynchornized {
	public static void main(String[] args) {
		// 공유메모리를 갖고 있는 클래스를 하나만 인스턴스화
		DataSyncClass dsc = new DataSyncClass(10);
		
		// 두개의 스레드 생성
		DataSyncThread dst1 = new DataSyncThread(dsc,2, "1st 스레드");
		DataSyncThread dst2 = new DataSyncThread(dsc,5, "2nd 스레드");
		dst1.start();
		dst2.start();
		
	}	// main
}	// class DataSynchornized
