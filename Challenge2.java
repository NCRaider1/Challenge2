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

import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;

public class Challenge2
{
    static Boolean privacy;
    public static void main (String[] args)
    {

        // Here are all 5 frames used for this GUI application
        JFrame startScreen = new JFrame("Start");
        startScreen.setSize(1000,800);
        startScreen.setResizable(false);
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame = new JFrame("Repo Token");
        frame.setSize(1000,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame2 = new JFrame("Repo Information");
        frame2.setSize(1000,800);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame3 = new JFrame("Repo Created");
        frame3.setSize(1000,800);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame4 = new JFrame("Frame4");
        frame4.setSize(1000,800);
        frame4.setResizable(false);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JLabel user = new JLabel("Enter Github Username:");
        user.setSize(300,50);
        user.setLocation(550,125);
        user.setForeground(Color.RED);
        startPanel.add(user);

        JTextField uName = new JTextField();
        uName.setSize(200,50);
        uName.setLocation(550,175);
        startPanel.add(uName);

        JLabel pathname = new JLabel("Enter your repo directory path name:");
        pathname.setSize(300,50);
        pathname.setLocation(550,275);
        pathname.setForeground(Color.RED);
        startPanel.add(pathname);

        JTextField path = new JTextField();
        path.setSize(200,50);
        path.setLocation(550,325);
        startPanel.add(path);

        ImageIcon logo = new ImageIcon("githubLogo.jpg");
        Image img = logo.getImage();
        Image temp = img.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        logo = new ImageIcon(temp);
        JLabel log = new JLabel(logo);
        log.setLayout(null);
        log.setBounds(0, 0, 500, 500);
        startPanel.add(log);

        ImageIcon background = new ImageIcon("AppBackground.jpg");
        Image img2 = background.getImage();
        Image temp2 = img2.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp2);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 1000, 800);
        startPanel.add(back);

        // This button allows us to move to the second panel
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

        JLabel tokenText = new JLabel("Enter your access TOKEN:");
        tokenText.setSize(300,50);
        tokenText.setLocation(350,175);
        tokenText.setForeground(Color.RED);
        panel.add(tokenText);

        JTextField token = new JTextField();
        token.setSize(200,50);
        token.setLocation(350,225);
        panel.add(token);

        JButton continueB = new JButton("Continue");
        continueB.setSize(200,100);
        continueB.setLocation(400, 450);
        continueB.setBackground(Color.LIGHT_GRAY);
        continueB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });
        panel.add(continueB);

        // JLabel pathname = new JLabel("Enter Directory Path Name:");
        // pathname.setSize(300,50);
        // pathname.setLocation(350,300);
        // pathname.setForeground(Color.RED);
        // panel.add(pathname);

        // JTextField path = new JTextField();
        // path.setSize(200,50);
        // path.setLocation(350,350);
        // panel.add(path);

        ImageIcon background1 = new ImageIcon("AppBackground.jpg");
        Image img1 = background1.getImage();
        Image temp1 = img1.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background1 = new ImageIcon(temp1);
        JLabel back1 = new JLabel(background1);
        back1.setLayout(null);
        back1.setBounds(0, 0, 1000, 800);
        panel.add(back1);

        frame.setContentPane(panel);
        frame.setVisible(false);

        //Frame 2: Repo Information
        JPanel panelB = new JPanel();
        panelB.setLayout(null);

        JLabel reponame = new JLabel("Enter Repository Name:");
        reponame.setSize(300,50);
        reponame.setLocation(200,225);
        reponame.setForeground(Color.RED);
        panelB.add(reponame);

        JTextField rName = new JTextField();
        rName.setSize(200,50);
        rName.setLocation(350,225);
        panelB.add(rName);

        JLabel repodesc = new JLabel("Description of Repository:");
        repodesc.setSize(300,50);
        repodesc.setLocation(185,300);
        repodesc.setForeground(Color.RED);
        panelB.add(repodesc);

        JTextField desc = new JTextField();
        desc.setSize(200,50);
        desc.setLocation(350,300);
        panelB.add(desc);

        ImageIcon background2 = new ImageIcon("AppBackground.jpg");
        Image img3 = background2.getImage();
        Image temp3 = img3.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
        background2 = new ImageIcon(temp3);
        JLabel back3 = new JLabel(background2);
        back3.setLayout(null);
        back3.setBounds(0, 0, 1000, 800);
        panelB.add(back3);

        // These two following buttons allow the user to select whether the repository will be public or private
        JButton privateB = new JButton("Private");
        privateB.setSize(200,100);
        privateB.setLocation(475, 400);
        privateB.setBackground(Color.LIGHT_GRAY);
        privateB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = true;
            }
        });
        panelB.add(privateB);

        JButton publicB = new JButton("Public");
        publicB.setSize(200,100);
        publicB.setLocation(250, 400);
        publicB.setBackground(Color.LIGHT_GRAY);
        publicB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                privacy = false;
            }
        });
        panelB.add(publicB);

        JButton createButton = new JButton("Create Repository");
        createButton.setSize(250,50);
        createButton.setLocation(350,550);

        createButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // GitHubApiClient gitHubApiClient = new GitHubApiClient(user, token);
                // GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo("CSC109", "GitHubApiClient");
            }
        });

        //GitHubApiClient gitHubApiClient = new GitHubApiClient(user, token);
        //GetRepoInfoResponse repoInfo = gitHubApiClient.getRepoInfo("CSC109", "GitHubApiClient");


        //Button Listener that creates the repo based on the information
        panelB.add(createButton);

        frame2.setContentPane(panelB);
        frame2.setVisible(false);

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