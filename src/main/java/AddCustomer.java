import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfaddress, tfaadhar, tfnationality;
    JRadioButton rbmale, rbfemale;

    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(250, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150,25);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150,25);
        add(tfnationality);

        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150,25);
        add(tfaadhar);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 220, 150,25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Mobile Number");
        lblphone.setBounds(60, 270, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 270, 150,25);
        add(tfphone);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 320, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblgender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 320, 70, 25);
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 320, 70, 25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.white);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);

        ImageIcon image = new ImageIcon("C:/Users/Victous/IdeaProjects/AirlineManagementSystem/src/main/java/icons/emp.png");
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);


        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;

        if (rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        try{
            conn conn = new conn();
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"') ";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");

            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[]args){
        new AddCustomer();
    }
}
