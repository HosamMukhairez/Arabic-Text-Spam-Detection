/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WekaClass;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hosam
 */
public class TextClassifierForm extends javax.swing.JFrame {

    /**
     * Creates new form TextClassifierForm
     */
    public TextClassifierForm() {
        initComponents();
        inputTextArea.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        TextClassifier t = new TextClassifier();
    }

    public void readWordBlackList() {
        try {
            String blackListWord = "";
            File file = new File("Arabic Dataset\\spam arabic words blacklist.txt");
            final DefaultListModel model = new DefaultListModel();
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((blackListWord = br.readLine()) != null) {
                model.addElement(blackListWord + "\n");
            }
            //blackList.setModel(model);
            JOptionPane.showMessageDialog(this, model, "List", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//*/

    public void readPhoneBlackList() {
        try {
            String blackListWord = "";
            File file = new File("Arabic Dataset\\spam phone number blacklist.txt");
            final DefaultListModel model = new DefaultListModel();
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((blackListWord = br.readLine()) != null) {
                model.addElement(blackListWord + "\n");
            }
            //blackList.setModel(model);
            JOptionPane.showMessageDialog(this, model, "List", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//*/

    public void readURLBlackList() {
        try {
            String blackListWord = "";
            File file = new File("Arabic Dataset\\spam URLs blacklist.txt");
            final DefaultListModel model = new DefaultListModel();
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((blackListWord = br.readLine()) != null) {
                model.addElement(blackListWord + "\n");
            }
            //blackList.setModel(model);
            JOptionPane.showMessageDialog(this, model, "List", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//*/

    public boolean isInBlackList() {
        try {
            int scoring = 0;
            String blackListWord = "";
            String inputText[] = inputTextArea.getText().split(" ");
            for (int i = 0; i < inputText.length; i++) {
                String inputWord = inputText[i].trim();
                File fileWords = new File("Arabic Dataset\\spam arabic words blacklist.txt");
                File filePhones = new File("Arabic Dataset\\spam phone number blacklist.txt");
                File fileURL = new File("Arabic Dataset\\spam URLs blacklist.txt");
                BufferedReader brWords = new BufferedReader(new FileReader(fileWords));
                BufferedReader brPhones = new BufferedReader(new FileReader(filePhones));
                BufferedReader brURL = new BufferedReader(new FileReader(fileURL));
                while ((blackListWord = brWords.readLine()) != null) {
                    if (blackListWord.equals(inputWord)) {
                        scoring++;
                        if (scoring == 3) {
                            System.out.println("brWords");
                            return true;
                        }
                    }
                }
                if (inputWord.startsWith("0") || inputWord.startsWith("+")) {//to check if this part is a number and not a normal word
                    if (!inputWord.startsWith("05") && !inputWord.startsWith("00966") && !inputWord.startsWith("+966")) {// to check if the number out side of KSA .. directly its spam
                        return true;
                    } else {
                        while ((blackListWord = brPhones.readLine()) != null) {
                            if (inputWord.equals(blackListWord)) {
                                System.out.println("brWords");
                                return true;
                            }
                        }
                    }
                }

                while ((blackListWord = brURL.readLine()) != null) {
                    if (inputWord.contains(blackListWord) || inputWord.contains("http")) {
                        System.out.println("brURL");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        notSpamF = new javax.swing.JTextField();
        spamF = new javax.swing.JTextField();
        checkB = new javax.swing.JButton();
        typeCB = new javax.swing.JComboBox<>();
        urlListB = new javax.swing.JButton();
        phonesListB = new javax.swing.JButton();
        wordsListB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arabic Text Classification");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Result");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(550, 320, 60, 40);

        inputTextArea.setColumns(20);
        inputTextArea.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        inputTextArea.setLineWrap(true);
        inputTextArea.setRows(5);
        jScrollPane1.setViewportView(inputTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 10, 780, 300);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Algorithm Type");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 320, 140, 40);

        notSpamF.setEditable(false);
        notSpamF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        notSpamF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notSpamF.setText("Not Spam");
        getContentPane().add(notSpamF);
        notSpamF.setBounds(610, 320, 110, 40);

        spamF.setEditable(false);
        spamF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spamF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        spamF.setText("Spam");
        getContentPane().add(spamF);
        spamF.setBounds(730, 320, 110, 40);

        checkB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        checkB.setText("Check Message");
        checkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBActionPerformed(evt);
            }
        });
        getContentPane().add(checkB);
        checkB.setBounds(360, 320, 180, 40);

        typeCB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        typeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rule-based scoring", "NaiveBayes" }));
        getContentPane().add(typeCB);
        typeCB.setBounds(160, 320, 190, 40);

        urlListB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urlListB.setText("Display URL BlackList");
        urlListB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlListBActionPerformed(evt);
            }
        });
        getContentPane().add(urlListB);
        urlListB.setBounds(160, 370, 195, 40);

        phonesListB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phonesListB.setText("Display Numbers BlackList");
        phonesListB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonesListBActionPerformed(evt);
            }
        });
        getContentPane().add(phonesListB);
        phonesListB.setBounds(370, 370, 195, 40);

        wordsListB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wordsListB.setText("Display Words BlackList");
        wordsListB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordsListBActionPerformed(evt);
            }
        });
        getContentPane().add(wordsListB);
        wordsListB.setBounds(580, 370, 210, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Text");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 10, 60, 30);

        setSize(new java.awt.Dimension(865, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBActionPerformed
        // TODO add your handling code here:
        try {
            JTextField arrayF[] = {spamF, notSpamF};
            for (int i = 0; i < 2; i++) {
                arrayF[i].setBackground(Color.WHITE);
            }
            if (typeCB.getSelectedItem().toString().equals("NaiveBayes")) {
                TextClassifier t = new TextClassifier();
                t.startClassification(inputTextArea.getText());
                if (t.status.equals("Spam")) {
                    spamF.setBackground(Color.RED);
                    notSpamF.setBackground(Color.WHITE);
                } else {
                    spamF.setBackground(Color.WHITE);
                    notSpamF.setBackground(Color.GREEN);
                }
            } else {
                String status = isInBlackList() ? "Spam" : "Not Spam";
                System.out.println("status:" + status);
                if (status.equals("Spam")) {
                    spamF.setBackground(Color.RED);
                    notSpamF.setBackground(Color.WHITE);
                } else {
                    spamF.setBackground(Color.WHITE);
                    notSpamF.setBackground(Color.GREEN);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_checkBActionPerformed

    private void wordsListBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordsListBActionPerformed
        // TODO add your handling code here:
        readWordBlackList();
    }//GEN-LAST:event_wordsListBActionPerformed

    private void phonesListBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonesListBActionPerformed
        // TODO add your handling code here:
        readPhoneBlackList();
    }//GEN-LAST:event_phonesListBActionPerformed

    private void urlListBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlListBActionPerformed
        // TODO add your handling code here:
        readURLBlackList();
    }//GEN-LAST:event_urlListBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextClassifierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextClassifierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextClassifierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextClassifierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextClassifierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkB;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField notSpamF;
    private javax.swing.JButton phonesListB;
    private javax.swing.JTextField spamF;
    private javax.swing.JComboBox<String> typeCB;
    private javax.swing.JButton urlListB;
    private javax.swing.JButton wordsListB;
    // End of variables declaration//GEN-END:variables
}
