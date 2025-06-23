package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* loaded from: classes6.dex */
public class XOxIOxOx extends oOXoIIIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f33397I0Io = 30;

    /* renamed from: II0xO0, reason: collision with root package name */
    public JTextField f33398II0xO0;

    public XOxIOxOx(JFrame jFrame, String str, String str2) {
        this(jFrame, str, str2, 30);
    }

    public String Oxx0IOOO() {
        String text = this.f33398II0xO0.getText();
        if (text != null && text.trim().length() == 0) {
            return null;
        }
        return text;
    }

    public XOxIOxOx(JFrame jFrame, String str, String str2, int i) {
        super(jFrame, str, true);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(new JLabel(str2));
        JTextField jTextField = new JTextField(i);
        this.f33398II0xO0 = jTextField;
        jPanel2.add(jTextField);
        addKeyListener(new IO(this));
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new xII(this));
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new x0o(this));
        jPanel.add(jButton);
        jPanel.add(jButton2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        pack();
        oIX0oI(this);
        oxoX();
    }
}
