package innerclass22;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InnerMemberEvent extends JFrame{
	JButton btn1, btn2, btn3;
	
	EventHandler handler = new EventHandler();	// ▲ 내부 클래스 인스턴스화

	public InnerMemberEvent() throws HeadlessException {
		setTitle("내부 멤버 클래스로 이벤트 처리하기");
		setLayout(new FlowLayout());
		add(btn1 = new JButton("1번 버튼"));
		add(btn2 = new JButton("2번 버튼"));
		add(btn3 = new JButton("3번 버튼"));
		
		// ▲ 이벤트 등록
		addWindowListener(handler);
		btn1.addActionListener(handler);
		btn2.addActionListener(handler);
		btn3.addActionListener(handler); // 버튼 클리식 EventHandler의 actionPerformed 호출
		
		pack();
		setVisible(true);
	}

	// ☆ 내부 멤버 클래스를 이용해서 이벤트 처리 ☆
	class EventHandler extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// 윈도우시스템 이벤트 처리
			if(e.getSource() == btn1)
				JOptionPane.showMessageDialog(btn1, "1번 버튼 클릭");
			else if(e.getSource() == btn2)
				JOptionPane.showMessageDialog(btn2, "2번 버튼 클릭");
			else
				JOptionPane.showMessageDialog(btn3, "3번 버튼 클릭");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			// 등록안하면 적용 X (▲)
		}
		
	}
	
	
	public static void main(String[] args) {
		new InnerMemberEvent();

	}	// main

}	// class innerMemberEvent
