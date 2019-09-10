package clue.model.vo.ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartFrame extends JFrame {
	private JButton startBtn;
	private JLabel label;

	public StartFrame() {
		// 화면 크기 설정
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 514, d.height / 2 - 384, 1024, 768);
		// 배경 이미지 설정
		label = new JLabel(new ImageIcon(new ImageIcon("images\\ClueBackground.jpg").getImage().getScaledInstance(1024,
				768, Image.SCALE_DEFAULT)));
		label.setBounds(0, 0, 1024, 768);
		// 시작버튼 추가
		startBtn = new JButton(new ImageIcon(
				new ImageIcon("images\\StartBtn.jpg").getImage().getScaledInstance(220, 90, Image.SCALE_DEFAULT)));
		startBtn.setBounds(400, 540, 210, 80);

		// 프레임에 추가
		add(startBtn);
		add(label);
		
		//버튼 이벤트추가
		startBtn.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SelectFrame();
			}
		});

		setResizable(false);
		setVisible(true);

	}
}