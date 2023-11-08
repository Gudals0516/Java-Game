import com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GameFrame extends JFrame{
    String computerStr = "컴퓨터";
    String score = "score";
    String user = "유저";
    String startmsg = "가위바위보 게임을 시작합니다\n";
    static String msg = "";
    private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();
    private JLabel coml = new JLabel(computerStr, SwingConstants.CENTER);
    private JLabel userl = new JLabel(user, SwingConstants.CENTER);
    private JLabel vjlb = new JLabel("vs", SwingConstants.CENTER);
    private JLabel sjlb = new JLabel("점수 : "+score, SwingConstants.CENTER);
    private JTextField jtf = new JTextField(SwingConstants.CENTER);
    private JTextArea ta = new JTextArea(startmsg);
    private JScrollPane sp = new JScrollPane(ta);
    public void run() {
        Game game = new Game();
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = jtf.getText();
                game.input = user;
                game.run();
                score = String.valueOf(Game.score);
                computerStr = game.computer;
                change();
                jtf.setText("");
            }
        };
        jtf.addActionListener(action);

        coml.setFont(new Font("computer", Font.BOLD, 30));
        coml.setBackground(Color.gray);
        coml.setOpaque(true);
        userl.setFont(new Font("user", Font.BOLD, 30));
        userl.setBackground(Color.gray);
        userl.setOpaque(true);
        vjlb.setFont(new Font("vs", Font.BOLD, 30));
        sjlb.setFont(new Font("score", Font.BOLD, 30));
        sjlb.setBackground(Color.gray);
        sjlb.setOpaque(true);
        jtf.setFont(new Font("field", Font.BOLD, 30));
        jtf.setHorizontalAlignment(JLabel.CENTER);
        ta.setBackground(Color.white);
        ta.setFont(new Font("textarea", Font.BOLD, 30));
        ta.setDisabledTextColor(Color.BLACK);
        ta.setEnabled(false);
        ta.setLineWrap(true);
        ta.setCaretPosition(ta.getText().length());
        ta.requestFocus();

        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pan1.setLayout(new GridLayout(1,3));
        pan1.setPreferredSize(new Dimension(800, 300));
        pan2.setLayout(new GridLayout(1, 2));
        pan2.setPreferredSize(new Dimension(800, 50));
        pan3.setLayout(new BorderLayout());
        pan3.setPreferredSize(new Dimension(1000, 200));

        pan1.add(coml);
        pan1.add(vjlb);
        pan1.add(userl);
        pan2.add(sjlb);
        pan2.add(jtf);
        pan3.add(sp);

        add(pan1, BorderLayout.NORTH);
        add(pan3, BorderLayout.CENTER);
        add(pan2, BorderLayout.SOUTH);

        setTitle("가위바위보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void change(){
        coml.setText("컴퓨터 : "+computerStr);
        userl.setText("유저 : "+user);
        sjlb.setText("점수 : "+score);
        ta.append(msg+"\n");
    }
}
