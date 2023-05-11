/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.libraryswing;

import com.mycompany.model.Library;
import com.mycompany.model.Reader;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author anton
 */
public class UserChoiceDialog extends javax.swing.JDialog {
    Library l;
    private boolean ok;

    /**
     * Creates new form UserChoiceDialog
     */
    
    public UserChoiceDialog(Frame parent, Library library) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
        l = library;
        if (l.getCurrentReader()== null) {
            buttonCencel.setEnabled(false);
        }
        // temporarily for demonstration
        textFieldLogin.setText("Thea Weis");
        textFieldPass.setText("123");
    }

    public UserChoiceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldLogin = new JTextField();
        textFieldPass = new JPasswordField();
        buttonOk = new JButton();
        buttonClear = new JButton();
        buttonCencel = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        buttonHelp = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        buttonOk.setText("OK");
        buttonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        buttonClear.setText("Clear");

        buttonCencel.setText("Cancel");
        buttonCencel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonCencelActionPerformed(evt);
            }
        });

        jLabel1.setText("Login:");

        jLabel2.setText("Passwort:");

        buttonHelp.setText("???");
        buttonHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonHelpActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHelp, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClear, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCencel))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldPass, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addComponent(textFieldLogin, GroupLayout.Alignment.LEADING)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOk)
                    .addComponent(buttonClear)
                    .addComponent(buttonCencel)
                    .addComponent(buttonHelp))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCencelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonCencelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCencelActionPerformed

    private void buttonHelpActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        l.getListReaders().forEach(r -> System.out.println(r.showReadersWithAuthorization()));
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void buttonOkActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        System.out.println(textFieldLogin.getText() + " " + textFieldPass.getSelectedText());
        char[] password = textFieldPass.getPassword();
//        System.out.println(Arrays.toString(password).toString());
        
       if(l.chooseCurReader(textFieldLogin.getText(), textFieldPass.getPassword())) {
           
           System.out.println("buttonOkActionPerformed"+l.getCurrentReader());
           ok = true;
           dispose();
           
       }
           
    }//GEN-LAST:event_buttonOkActionPerformed

    public Reader showDialog() {
        setVisible(true);
        return ok ? l.getCurrentReader() : null;
        
      
    }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonCencel;
    private JButton buttonClear;
    private JButton buttonHelp;
    private JButton buttonOk;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField textFieldLogin;
    private JPasswordField textFieldPass;
    // End of variables declaration//GEN-END:variables
}
