package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;



class MyWindow extends JFrame
{

    public MyWindow()
    {
        setTitle("My Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,800,400);
        setLayout(new BorderLayout());




        Random rand=new Random();

        RainField RF = new RainField();
        JButton jb=new JButton("jump");



        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    RF.setJumpSwitch(1);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RF.setJumpSwitch(1);
                System.out.println(" Y:"+e.getX()+"   X:"+e.getX());
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RF.setJumpSwitch(1);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        // add(jb,BorderLayout.NORTH);
        add(RF,BorderLayout.CENTER);




        int v[]=new int [100];
        int r[]=new int [100];
        for(int k=0;k<100;k++) {
            r[k] = rand.nextInt(getWidth());
            v[k] = rand.nextInt(getHeight());
        }
        RF.setX(r);
        RF.setY(v);

        int cx[]=new int [5];
        int cy[]=new int [5];
        for(int k=0;k<5;k++) {
            cx[k] = rand.nextInt(2000);
            cy[k] = rand.nextInt(150);
        }
        RF.setCloudX(cx);
        RF.setCloudY(cy);







        setResizable(false);
        setVisible(true);

        Thread rain = new Thread(RF);
        rain.start();
        System.out.println(getHeight());
    }


}
