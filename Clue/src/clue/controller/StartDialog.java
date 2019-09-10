package clue.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import clue.model.vo.Player;
import clue.model.vo.ui.GameFrame;

public class StartDialog extends JDialog {
	private JLabel DialogLabel;
	private JLabel orderLabel;
	private JButton DialogBtn;

	public StartDialog(Player[] playerArr) {
		setTitle("안내");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
	
		setBounds(d.width / 2 - 150, d.height / 2 - 100, 300, 200);
		setLayout(null);
		// 라벨 설정
		DialogLabel = new JLabel("게임을 시작합니다.");
		DialogLabel.setBounds(90, 30, 250, 20);

		// 순서 정보 라벨 설정
		orderLabel = new JLabel("순서는 " + playerArr[0].getCharacter() + "(" + playerArr[0].getName() + ") 먼저 진행하겠습니다.");

		orderLabel.setBounds(27, 70, 250, 20);

		// 버튼설정
		DialogBtn = new JButton("확인");
		DialogBtn.setBounds(110, 120, 60, 30);
		
		add(orderLabel);
		add(DialogLabel);
		add(DialogBtn);
		setFocusable(true);
		setVisible(true);
	}

	public JButton getDialogBtn() {
		return DialogBtn;
	}

	public void setDialogBtn(JButton dialogBtn) {
		DialogBtn = dialogBtn;
	}
	
}