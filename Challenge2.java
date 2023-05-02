import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Challenge2
{
    static Boolean privacy;
    public static void main (String[] args)
    {
        JFrame startScreen = new JFrame("Start");
        startScreen.setSize(1000,800);
        startScreen.setResizable(false);
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame = new JFrame("Repo Token");
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // JFrame frame2 = new JFrame("Repo Information");
            // frame2.setSize(1000,800);
            // frame2.setResizable(false);
            // frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame3 = new JFrame("Repo Created");
        frame3.setSize(1000,800);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Starting Screen
        JPanel startPanel = new JPanel();
        startPanel.setLayout(null);
        startPanel.setBackground(Color.WHITE);

        JLabel titleMessage = new JLabel("GitHub Repo Creator");
        titleMessage.setSize(300,200);
        titleMessage.setFont(new Font("Cambria", Font.BOLD, 18));
        titleMessage.setLocation(425, 0);
        titleMessage.setForeground(Color.BLACK);
        startPanel.add(titleMessage);
         
        ImageIcon logo = new ImageIcon("githubLogo.jpg");
        Image img = logo.getImage();
        Image temp = img.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        logo = new ImageIcon(temp);
        JLabel log = new JLabel(logo);
        log.setLayout(null);
        log.setBounds(0, 0, 500, 500);
        startPanel.add(log);
        
        ImageIcon qulogo = new ImageIcon("QUbobcat.png");
        Image bobCat = qulogo.getImage();
        Image bobCatTemp = bobCat.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        qulogo = new ImageIcon(bobCatTemp);
        JLabel log2 = new JLabel(qulogo);
        log2.setLayout(null);
        log2.setBounds(0, 0, 1500, 500);
        startPanel.add(log2);

        ImageIcon background = new ImageIcon("cloudServer.jpg");
        Image img2 = background.getImage();
        Image temp2 = img2.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp2);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 1000, 800);
        startPanel.add(back);


        JButton next = new JButton("Continue");
        next.setSize(200,100);
        next.setLocation(400, 450);
        next.setBackground(Color.LIGHT_GRAY);
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startScreen.setVisible(false);
                frame.setVisible(true);
            }
        });
        startPanel.add(next);

        startScreen.setContentPane(startPanel);
        startScreen.setVisible(true);

        //Frame 1: Token
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel username = new JLabel("Enter Github Username:");
        username.setSize(300,50);
        username.setLocation(200,75);
        username.setForeground(Color.RED);
        panel.add(username);

        JTextField uName = new JTextField();
        uName.setSize(200,50);
        uName.setLocation(350,75);
        panel.add(uName);

        JLabel pathname = new JLabel("Enter Directory Path Name:");
        pathname.setSize(300,50);
        pathname.setLocation(185,125);
        pathname.setForeground(Color.RED);
        panel.add(pathname);

        JTextField path = new JTextField();
        path.setSize(200,50);
        path.setLocation(350,125);
        panel.add(path);

        JLabel tokenText = new JLabel("Enter TOKEN:");
        tokenText.setSize(300,50);
        tokenText.setLocation(260,175);
        tokenText.setForeground(Color.RED);
        panel.add(tokenText);

        JTextField token = new JTextField();
        token.setSize(200,50);
        token.setLocation(350,175);
        panel.add(token);

        JLabel reponame = new JLabel("Enter Repository Name:");
        reponame.setSize(300,50);
        reponame.setLocation(200,225);
        reponame.setForeground(Color.RED);
        panel.add(reponame);

        JTextField rName = new JTextField();
        rName.setSize(200,50);
        rName.setLocation(350,225);
        panel.add(rName);

        JLabel repodesc = new JLabel("Description of Repository:");
        repodesc.setSize(300,50);
        repodesc.setLocation(185,275);
        repodesc.setForeground(Color.RED);
        panel.add(repodesc);

        JTextField desc = new JTextField();
        desc.setSize(200,50);
        desc.setLocation(350,275);
        panel.add(desc);

        JButton addGitIgnore = new JButton("Add a .gitignore");
        addGitIgnore.setSize(200,100);
        addGitIgnore.setLocation(350, 330);
        addGitIgnore.setBackground(Color.LIGHT_GRAY);
        addGitIgnore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = true;
            }
        });
        panel.add(addGitIgnore);

        JButton privateB = new JButton("Private");
        privateB.setSize(200,100);
        privateB.setLocation(475, 440);
        privateB.setBackground(Color.LIGHT_GRAY);
        privateB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = true;
            }
        });
        panel.add(privateB);

        JButton publicB = new JButton("Public");
        publicB.setSize(200,100);
        publicB.setLocation(250,440);
        publicB.setBackground(Color.LIGHT_GRAY);
        publicB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = false;
            }
        });
        panel.add(publicB);

        JButton continueB = new JButton("Create Repository");
        continueB.setSize(200,100);
        continueB.setLocation(350, 550);
        continueB.setBackground(Color.LIGHT_GRAY);
        continueB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                frame3.setVisible(true);
            }
        });
        panel.add(continueB);


        ImageIcon background1 = new ImageIcon("cloudServer.jpg");
        Image img1 = background1.getImage();
        Image temp1 = img1.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background1 = new ImageIcon(temp1);
        JLabel back1 = new JLabel(background1);
        back1.setLayout(null);
        back1.setBounds(0, 0, 1000, 800);
        panel.add(back1);

        frame.setContentPane(panel);
        frame.setVisible(false);

        //Frame 3: Completed Repo
        JPanel compPanel = new JPanel();
        compPanel.setLayout(null);

        JLabel completed = new JLabel("Repo has been Created");
        completed.setSize(300,50);
        completed.setLocation(185,300);
        completed.setForeground(Color.RED);
        compPanel.add(completed);

        JLabel repoLink = new JLabel("");
        repoLink.setForeground(Color.ORANGE);
        repoLink.setLocation(600,100);
        repoLink.setSize(400,350);
        compPanel.add(repoLink);

        JLabel errorMessage = new JLabel("");
        errorMessage.setForeground(Color.ORANGE);
        errorMessage.setLocation(400,300);
        errorMessage.setSize(400,350);
        compPanel.add(errorMessage);
    }
}