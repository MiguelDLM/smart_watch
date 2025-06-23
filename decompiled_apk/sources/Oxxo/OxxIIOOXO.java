package Oxxo;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

/* loaded from: classes6.dex */
public class OxxIIOOXO extends DefaultTreeCellRenderer {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Color f3138I0Io = new Color(PsExtractor.PRIVATE_STREAM_1, 113, 0);

    /* renamed from: oxoX, reason: collision with root package name */
    public static ImageIcon f3139oxoX = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public JPanel f3140II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public JCheckBox f3141oIX0oI = new JCheckBox();

    public OxxIIOOXO() {
        JPanel jPanel = new JPanel();
        this.f3140II0xO0 = jPanel;
        jPanel.setBackground(UIManager.getColor("Tree.textBackground"));
        if (f3139oxoX == null) {
            f3139oxoX = new ImageIcon(getClass().getResource("/org/apache/log4j/lf5/viewer/images/channelexplorer_satellite.gif"));
        }
        setOpaque(false);
        this.f3141oIX0oI.setOpaque(false);
        this.f3140II0xO0.setOpaque(false);
        this.f3140II0xO0.setLayout(new FlowLayout(0, 0, 0));
        this.f3140II0xO0.add(this.f3141oIX0oI);
        this.f3140II0xO0.add(this);
        setOpenIcon(f3139oxoX);
        setClosedIcon(f3139oxoX);
        setLeafIcon(f3139oxoX);
    }

    public Component I0Io(JTree jTree, Object obj, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        xxIXOIIO xxixoiio = (xxIXOIIO) obj;
        super.getTreeCellRendererComponent(jTree, obj, z, z2, z3, i, z4);
        if (i == 0) {
            this.f3141oIX0oI.setVisible(false);
        } else {
            this.f3141oIX0oI.setVisible(true);
            this.f3141oIX0oI.setSelected(xxixoiio.oOoXoXO());
        }
        this.f3140II0xO0.setToolTipText(oIX0oI(xxixoiio));
        if (xxixoiio.xxIXOIIO()) {
            setForeground(f3138I0Io);
        }
        if (xxixoiio.xoIox()) {
            setForeground(Color.red);
        }
        return this.f3140II0xO0;
    }

    public Dimension II0xO0() {
        return new Dimension(0, 0);
    }

    public String oIX0oI(xxIXOIIO xxixoiio) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xxixoiio.Oxx0IOOO());
        stringBuffer.append(" contains a total of ");
        stringBuffer.append(xxixoiio.II0XooXoX());
        stringBuffer.append(" LogRecords.");
        stringBuffer.append(" Right-click for more info.");
        return stringBuffer.toString();
    }
}
