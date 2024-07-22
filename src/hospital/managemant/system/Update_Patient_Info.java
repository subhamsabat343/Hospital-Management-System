package hospital.managemant.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Patient_Info extends JFrame{
    
    Update_Patient_Info()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i1=imageicon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2=new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice =new Choice();
        choice.setBounds(248,85,150,25);
        panel.add(choice);

        try {
            conn c=new conn();
            String q="select * from Patient_Info";
            ResultSet resultSet=c.statement.executeQuery(q);

            while(resultSet.next())
            {
                choice.add(resultSet.getString("Name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,130,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR=new JTextField();
        textFieldR.setBounds(248,130,150,20);
        textFieldR.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(textFieldR);

        JLabel label4=new JLabel("In Time :");
        label4.setBounds(25,175,100,20);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime=new JTextField();
        textFieldINTime.setBounds(248,175,150,20);
        textFieldINTime.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(textFieldINTime);


        JLabel label5=new JLabel("Amount Paid (Rs) : ");
        label5.setBounds(25,217,150,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount=new JTextField();
        textFieldAmount.setBounds(248,217,150,20);
        textFieldAmount.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(textFieldAmount);


        JLabel label6=new JLabel("Pending Amount (Rs) : ");
        label6.setBounds(25,262,150,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending=new JTextField();
        textFieldPending.setBounds(248,262,150,20);
        textFieldPending.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(textFieldPending);

        
        JButton check=new JButton("Check");
        check.setBounds(281,380,90,30);
        check.setFont(new Font("serif",Font.BOLD,15));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                        conn c=new conn();
                        String id=choice.getSelectedItem();
                        String q="select * from Patient_Info where name = '"+id+"'";
                        ResultSet resultSet=c.statement.executeQuery(q);

                        while(resultSet.next()){
                            textFieldR.setText(resultSet.getString("Room_Number"));
                            textFieldINTime.setText(resultSet.getString("Time"));
                            textFieldAmount.setText(resultSet.getString("Deposite"));                           
                        }

                        ResultSet resultSet1=c.statement.executeQuery("select * from room where room_no ='"+textFieldR.getText()+"'");

                        while(resultSet1.next()){
                            String price=resultSet1.getString("Price");
                            int amountpaid=Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                    
                            textFieldPending.setText(""+amountpaid);
                            
                        }
                    } 
                catch (Exception E) {
                    E.printStackTrace();
            }

            }
        });


        JButton update=new JButton("Update");
        update.setBounds(56,380,90,30);
        update.setFont(new Font("serif",Font.BOLD,15));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                try {
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String room=textFieldR.getText();
                    String time=textFieldINTime.getText();
                    String amount=textFieldAmount.getText();

                    c.statement.executeUpdate("update Patient_Info set  Room_Number ='"+room+"' , Time ='"+time+"', Deposite = '"+amount+"' where name= '"+q+"' ");
                    JOptionPane.showMessageDialog(null, "Update Sucessfully");
                    setVisible(false);
                } 
            catch (Exception E) {
                E.printStackTrace();
        }
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(168,380,90,30);
        back.setFont(new Font("serif",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
               setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(950,500);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Info();
    }
    
}
