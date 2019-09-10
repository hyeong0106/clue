package clue.model.vo.ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clue.model.vo.Player;

public class EndFrame extends JFrame {
	private JButton gameEnd;
	private JButton gameStart;
	private JLabel bgLabel;
	private JLabel outcomeLabel;
	private String bg;
	private String outcome;

	public EndFrame(Player[] playerArr) {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 512, d.height / 2 - 384, 1024, 768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		int maxScore = 0;
		// 나가 아닌경우 score의 최댓값 뽑기
		for (int i = 0; i < playerArr.length; i++) {
			if (!(playerArr[i].getName().equals("나 "))) {
				if (playerArr[i].getScore() > maxScore) {
					maxScore = playerArr[i].getScore();
				}
			}
		}
		// 나랑 나머지의 최대값비교
		for (int i = 0; i < playerArr.length; i++) {
			if (playerArr[i].getName().equals("나 ")) {
				if (playerArr[i].getScore() >= maxScore) {
					bgLabel = new JLabel(new ImageIcon(new ImageIcon("images/Map.jpg").getImage()
							.getScaledInstance(1024, 768, Image.SCALE_DEFAULT)));
					bgLabel.setBounds(0, 0, 1024, 768);

					outcomeLabel = new JLabel(new ImageIcon(new ImageIcon("imgages/Lose.png").getImage()
							.getScaledInstance(1024, 768, Image.SCALE_DEFAULT)));
					outcomeLabel.setBounds(0, 0, 612, 384);
				} else {
					bgLabel = new JLabel(new ImageIcon(new ImageIcon("images/End.jpg").getImage()
							.getScaledInstance(1024, 768, Image.SCALE_DEFAULT)));
					bgLabel.setBounds(0, 0, 1024, 768);

					outcomeLabel = new JLabel(new ImageIcon(new ImageIcon("imgages/Lose.png").getImage()
							.getScaledInstance(1024, 768, Image.SCALE_DEFAULT)));
					outcomeLabel.setBounds(0, 0, 612, 384);

				}
			}
		}
		add(bgLabel);
		add(outcomeLabel);
		setVisible(true);
	}

}