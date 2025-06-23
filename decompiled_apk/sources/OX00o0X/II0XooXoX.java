package OX00o0X;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Level;

/* loaded from: classes6.dex */
public class II0XooXoX extends JPanel {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static /* synthetic */ Class f1898II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1899oIX0oI;

    static {
        Class cls = f1898II0xO0;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.chainsaw.ControlPanel");
            f1898II0xO0 = cls;
        }
        f1899oIX0oI = org.apache.log4j.x0xO0oo.xo0x(cls);
    }

    public II0XooXoX(IXxxXO iXxxXO) {
        setBorder(BorderFactory.createTitledBorder("Controls: "));
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = 13;
        gridBagConstraints.gridy = 0;
        JLabel jLabel = new JLabel("Filter Level:");
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        add(jLabel);
        gridBagConstraints.gridy++;
        JLabel jLabel2 = new JLabel("Filter Thread:");
        gridBagLayout.setConstraints(jLabel2, gridBagConstraints);
        add(jLabel2);
        gridBagConstraints.gridy++;
        JLabel jLabel3 = new JLabel("Filter Logger:");
        gridBagLayout.setConstraints(jLabel3, gridBagConstraints);
        add(jLabel3);
        gridBagConstraints.gridy++;
        JLabel jLabel4 = new JLabel("Filter NDC:");
        gridBagLayout.setConstraints(jLabel4, gridBagConstraints);
        add(jLabel4);
        gridBagConstraints.gridy++;
        JLabel jLabel5 = new JLabel("Filter Message:");
        gridBagLayout.setConstraints(jLabel5, gridBagConstraints);
        add(jLabel5);
        gridBagConstraints.weightx = 1.0d;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = 17;
        gridBagConstraints.gridy = 0;
        Level[] levelArr = {Level.FATAL, Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE};
        JComboBox jComboBox = new JComboBox(levelArr);
        Level level = levelArr[5];
        jComboBox.setSelectedItem(level);
        iXxxXO.OxxIIOOXO(level);
        gridBagLayout.setConstraints(jComboBox, gridBagConstraints);
        add(jComboBox);
        jComboBox.setEditable(false);
        jComboBox.addActionListener(new oIX0oI(this, iXxxXO, jComboBox));
        gridBagConstraints.fill = 2;
        gridBagConstraints.gridy++;
        JTextField jTextField = new JTextField("");
        jTextField.getDocument().addDocumentListener(new II0xO0(this, iXxxXO, jTextField));
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        add(jTextField);
        gridBagConstraints.gridy++;
        JTextField jTextField2 = new JTextField("");
        jTextField2.getDocument().addDocumentListener(new I0Io(this, iXxxXO, jTextField2));
        gridBagLayout.setConstraints(jTextField2, gridBagConstraints);
        add(jTextField2);
        gridBagConstraints.gridy++;
        JTextField jTextField3 = new JTextField("");
        jTextField3.getDocument().addDocumentListener(new oxoX(this, iXxxXO, jTextField3));
        gridBagLayout.setConstraints(jTextField3, gridBagConstraints);
        add(jTextField3);
        gridBagConstraints.gridy++;
        JTextField jTextField4 = new JTextField("");
        jTextField4.getDocument().addDocumentListener(new X0o0xo(this, iXxxXO, jTextField4));
        gridBagLayout.setConstraints(jTextField4, gridBagConstraints);
        add(jTextField4);
        gridBagConstraints.weightx = XIXIX.OOXIXo.f3760XO;
        gridBagConstraints.fill = 2;
        gridBagConstraints.anchor = 13;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        JButton jButton = new JButton("Exit");
        jButton.setMnemonic('x');
        jButton.addActionListener(OOXIXo.f1923II0xO0);
        gridBagLayout.setConstraints(jButton, gridBagConstraints);
        add(jButton);
        gridBagConstraints.gridy++;
        JButton jButton2 = new JButton("Clear");
        jButton2.setMnemonic('c');
        jButton2.addActionListener(new XO(this, iXxxXO));
        gridBagLayout.setConstraints(jButton2, gridBagConstraints);
        add(jButton2);
        gridBagConstraints.gridy++;
        JButton jButton3 = new JButton("Pause");
        jButton3.setMnemonic('p');
        jButton3.addActionListener(new Oxx0IOOO(this, iXxxXO, jButton3));
        gridBagLayout.setConstraints(jButton3, gridBagConstraints);
        add(jButton3);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
