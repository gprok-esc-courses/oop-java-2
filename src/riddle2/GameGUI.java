package riddle2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private JTextField usernameField, answerField;
    private JButton setUsernameBtn, playAgainBtn, newUserBtn, exitBtn, answerBtn;
    private JLabel scoreLabel, riddleLabel;
    private Game game;

    public GameGUI() {
        game = new Game(4);
        JPanel north = createNorthPanel();
        add(north, BorderLayout.NORTH);
        JPanel south = createSouthPanel();
        add(south, BorderLayout.SOUTH);
        JPanel center = createCenterPanel();
        add(center, BorderLayout.CENTER);

        setTitle("Riddles Game");
        setBounds(200, 200, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField(8);
        panel.add(usernameField);
        setUsernameBtn = new JButton("Set");
        setUsernameBtn.addActionListener(this);
        panel.add(setUsernameBtn);
        return panel;
    }

    public JPanel createSouthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel first = new JPanel();
        JPanel second = new JPanel();
        JLabel label = new JLabel("Score: ");
        first.add(label);
        scoreLabel = new JLabel("/");
        first.add(scoreLabel);
        playAgainBtn = new JButton("Play Again");
        playAgainBtn.addActionListener(this);
        playAgainBtn.setEnabled(false);
        second.add(playAgainBtn);
        newUserBtn = new JButton("New User");
        newUserBtn.addActionListener(this);
        newUserBtn.setEnabled(false);
        second.add(newUserBtn);
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(this);
        exitBtn.addActionListener(new ExitLogger());
        second.add(exitBtn);
        panel.add(first);
        panel.add(second);
        return panel;
    }

    public JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel labelPanel = new JPanel();
        JLabel riddleTitle = new JLabel("<html><h1>RIDDLE</h1></html>");
        labelPanel.add(riddleTitle);
        panel.add(labelPanel);
        JPanel riddlePanel = new JPanel();
        riddleLabel = new JLabel("-");
        riddleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        riddlePanel.add(riddleLabel);
        panel.add(riddlePanel);
        JPanel answerPanel = new JPanel();
        JLabel label = new JLabel("Answer:");
        answerPanel.add(label);
        answerField = new JTextField(15);
        answerPanel.add(answerField);
        answerBtn = new JButton("Submit");
        answerBtn.addActionListener(this);
        answerBtn.setEnabled(false);
        answerPanel.add(answerBtn);
        panel.add(answerPanel);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == setUsernameBtn) {
            if(usernameField.getText().isEmpty()) {
                return;
            }
            game.setUsername(usernameField.getText());
            game.startGame();
            setUsernameBtn.setEnabled(false);
            answerBtn.setEnabled(true);
            displayRiddle();
        }
        else if(e.getSource() == answerBtn) {
            if(answerField.getText().isEmpty()) {
                return;
            }
            String answer = answerField.getText();
            game.checkCurrentAnswer(answer);
            if(game.gameOver()) {
                scoreLabel.setText(game.getScore() + "/4");
                game.saveScore();
                answerBtn.setEnabled(false);
                playAgainBtn.setEnabled(true);
                newUserBtn.setEnabled(true);
            }
            else {
                displayRiddle();
            }
        }
        else if(e.getSource() == playAgainBtn) {
            game.startGame();
            answerBtn.setEnabled(true);
            playAgainBtn.setEnabled(false);
            newUserBtn.setEnabled(false);
            displayRiddle();
        }
        else if(e.getSource() == newUserBtn) {
            setUsernameBtn.setEnabled(true);
            playAgainBtn.setEnabled(false);
            newUserBtn.setEnabled(false);
            usernameField.setText("");
            usernameField.requestFocus();
        }
        else if(e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public void displayRiddle() {
        String question = game.getCurrentQuestion();
        riddleLabel.setText("<html><div style='width: 280px'>" + question + "</div></html>");
        answerField.setText("");
        answerField.requestFocus();
    }
}
