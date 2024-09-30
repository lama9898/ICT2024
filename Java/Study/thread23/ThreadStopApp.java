package thread23;

class ThreadStop extends Thread{
	
	// †■ 플래그 변수 이용 비추천 : 스레드가 멈추지 않을 수 있음
	// isFlag 가 true가 된다고 해도 while문 내의 모든 명령문의 실행이 끝나야 다시 반복조건을 검사하기 때문에
	
	//boolean isFlag;
	
	
	@Override
	public void run() {
		int i=1;
		/*
		while(!isFlag) {
			System.out.println("i:"+i++);
			try {
				sleep(500);
			} catch(InterruptedException e) { e.printStackTrace(); }
		}
		*/
	
	
		try {
			while(true) {
				System.out.println("i:"+i++);
				sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println("unterrupt()호출");
		}
		finally {
			System.out.println("스레드 DEAD");
		}
		//interrupt()메소드 호출(추천) : Interrupted Exception 예외 발생시키기 위해서 스레드 작업 중간에 멈출 수 있음
		//Interrupted exception이 발생하면 무조건 catch절로 들어감
	}
}

public class ThreadStopApp {

	public static void main(String[] args) {
		ThreadStop thread = new ThreadStop();	//runnable 상태
		thread.start();	//run

		//main 스레드를 5초동안 wait상태로 전이 (wait끝나면 dead (더 이상 실행할 코드가 없음)
		try {
			Thread.sleep(5000);	//wait, runnable 상태 스레든 실행 가능
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		//†■ 
		//thread.isFlag = true; // 실제로는 특정 조건일때 설정해주기	
		
		if(thread.isAlive()) //start 되었는지, dead가 아닌경우 : runnable, wait, running
			thread.interrupt(); //interrupt exception 발생
	}

}
