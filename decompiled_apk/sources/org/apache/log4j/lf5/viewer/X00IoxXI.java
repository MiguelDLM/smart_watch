package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* loaded from: classes6.dex */
public class X00IoxXI extends oOXoIIIo {
    public X00IoxXI(JFrame jFrame, String str) {
        super(jFrame, "Error", true);
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new Xx000oIo(this));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jButton);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridBagLayout());
        X0o0xo(str, jPanel2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        oxoX();
    }
}
