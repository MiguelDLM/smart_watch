package com.google.firebase.crashlytics.buildtools.mappingfiles;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* loaded from: classes10.dex */
public abstract class MappingFileIdReader {
    protected final DocumentBuilder docBuilder;

    /* loaded from: classes10.dex */
    public static class FileIdReader extends MappingFileIdReader {
        private final File file;

        public FileIdReader(File file, DocumentBuilder documentBuilder) {
            super(documentBuilder);
            this.file = file;
        }

        @Override // com.google.firebase.crashlytics.buildtools.mappingfiles.MappingFileIdReader
        public Document parseXmlSource() throws IOException, SAXException {
            if (!this.file.exists()) {
                return null;
            }
            return getDocumentBuilder().parse(this.file);
        }
    }

    /* loaded from: classes10.dex */
    public static class StringIdReader extends MappingFileIdReader {
        private final String string;

        public StringIdReader(String str, DocumentBuilder documentBuilder) {
            super(documentBuilder);
            this.string = str;
        }

        @Override // com.google.firebase.crashlytics.buildtools.mappingfiles.MappingFileIdReader
        public Document parseXmlSource() throws IOException, SAXException {
            String str = this.string;
            if (str != null && !str.isEmpty()) {
                return getDocumentBuilder().parse(new ByteArrayInputStream(this.string.getBytes(StandardCharsets.UTF_8)));
            }
            return null;
        }
    }

    public MappingFileIdReader(DocumentBuilder documentBuilder) {
        this.docBuilder = documentBuilder;
    }

    public static MappingFileIdReader create(File file) {
        try {
            return new FileIdReader(file, DocumentBuilderFactory.newInstance().newDocumentBuilder());
        } catch (ParserConfigurationException e) {
            Buildtools.logE("Crashlytics experienced an unrecoverable parser configuration exception", e);
            throw new RuntimeException(e);
        }
    }

    public DocumentBuilder getDocumentBuilder() {
        return this.docBuilder;
    }

    public String getMappingFileId() throws IOException {
        Element mappingFileIdElement;
        try {
            Document parseXmlSource = parseXmlSource();
            if (parseXmlSource == null || (mappingFileIdElement = XmlResourceUtils.getMappingFileIdElement(parseXmlSource)) == null) {
                return null;
            }
            return mappingFileIdElement.getTextContent();
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }

    public abstract Document parseXmlSource() throws SAXException, IOException;

    public static MappingFileIdReader create(String str) {
        try {
            return new StringIdReader(str, DocumentBuilderFactory.newInstance().newDocumentBuilder());
        } catch (ParserConfigurationException e) {
            Buildtools.logE("Crashlytics experienced an unrecoverable parser configuration exception", e);
            throw new RuntimeException(e);
        }
    }
}
