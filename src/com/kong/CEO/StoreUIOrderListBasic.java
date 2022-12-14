package com.kong.CEO;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kong.JDBC.ReviewDAO;
import com.kong.JDBC.ReviewDTO;
//주문내역 
class KongFrame07{
	private JPanel panel;
	private JFrame frame;	
	private JScrollPane jsp;
	private JTextArea ta;
	private JButton Button4,Button5,Button6,Button7;
	
	public KongFrame07() {		
		//배경 색상 		
		frame = new JFrame();
		panel = new JPanel();
		ta = new JTextArea();
		
		
		frame.setSize(480, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("점주 주문내역");
		
		//DB연동
		ReviewDAO rdao= new ReviewDAO();
		List<ReviewDTO> rlist = new ArrayList<>();
		rlist = rdao.getKongList();
		
		
		//getContentPane().
		frame.setLayout(null);
		panel.setSize(480, 600);
		panel.setLayout(null);
		
		// Top Message
		JLabel text1 = new JLabel("주문내역 ");
		JLabel text2 = new JLabel(">> 리뷰");
		// label.setHorizontalAlignment(JLabel.CENTER);
		
		text1.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		text1.setBounds(30, 0, 200, 40);
		text2.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		
		text2.setBounds(30, 30, 200, 40);

		panel.add(text1);
		panel.add(text2);
				
		
		jsp = new JScrollPane(ta); // 창 스크롤
		jsp.setBounds(20, 80, 430, 500);
		panel.add(jsp);
		
		//
		ta.setText("");		
		ta.setFont(new Font("MICE고딕", Font.PLAIN, 20));
				
		// 전체 출력
		for (int i = 0; i < rlist.size(); i++) {
			ta.append(
					rlist.get(i).getR_id()+"\n"
					+rlist.get(i).getR_point()+"\n" 
					+rlist.get(i).getR_store()+"\n"
					+rlist.get(i).getR_cont()+"\n"
					+rlist.get(i).getR_date()+"\n");
			ta.append("-----------------------------------------------\n");
		}
		
		
		frame.add(panel);		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//button
		//이전버튼
		Button4 = new JButton("");	
		Button4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
		});
		
		Button4.setBorderPainted(false);
		Button4.setContentAreaFilled(false);
		Button4.setFocusPainted(false);
		Button4.setIcon(new ImageIcon("./images/pre.png"));
		Button4.setRolloverIcon(new ImageIcon("./images/Rollpre.png"));
		Button4.setPressedIcon(new ImageIcon("./images/PressedPre.png"));	
		Button4.setBounds(-1, 672, 120, 105);
		frame.getContentPane().add(Button4);
		
		
		//홈버튼
		Button5 = new JButton();
		Button5.setBorderPainted(false);
		Button5.setContentAreaFilled(false);
		Button5.setFocusPainted(false);
		Button5.setIcon(new ImageIcon("./images/Home.png"));
		Button5.setRolloverIcon(new ImageIcon("./images/RollHome.png"));
		Button5.setPressedIcon(new ImageIcon("./images/PressedHome.png"));
		Button5.setBounds(119,672,120,105);
		frame.getContentPane().add(Button5);
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				new KongFrame01();
				frame.setVisible(false);
			}
			});

		//주문내역
		Button6 = new JButton();
		Button6.setBorderPainted(false);
		Button6.setContentAreaFilled(false);
		Button6.setFocusPainted(false);
		Button6.setIcon(new ImageIcon("./images/OrderList.png"));
		Button6.setRolloverIcon(new ImageIcon("./images/RollOrderList.png"));
		Button6.setPressedIcon(new ImageIcon("./images/PressedOrderList.png"));
		Button6.setBounds(239,672,120,105);
		frame.getContentPane().add(Button6);
		
		
		

		Button7 = new JButton();
		Button7.setBorderPainted(false);
		Button7.setContentAreaFilled(false);
		Button7.setFocusPainted(false);
		Button7.setIcon(new ImageIcon("./images/Mypage.png"));
		Button7.setRolloverIcon(new ImageIcon("./images/RollMypage.png"));
		Button7.setPressedIcon(new ImageIcon("./images/PressedMypage.png"));
		Button7.setBounds(359,672,120,105);
		Button7.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new My1();
				frame.dispose();
			}
			
		});
		frame.getContentPane().add(Button7);
		
		frame.setVisible(true);
		
	
	}
}

public class StoreUIOrderListBasic {
	public static void main(String[] args) {
		new KongFrame06();
	}

}
