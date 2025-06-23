package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* loaded from: classes.dex */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement allocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (type.ordinal()) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLNumber.allocate(cArr);
                break;
            case 4:
                allocate = CLString.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.mLineNumber);
        if (z) {
            allocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
            if (c != '\"' && c != '\'') {
                if (c != '[') {
                    if (c != ']') {
                        if (c != '{') {
                            if (c != '}') {
                                switch (c) {
                                    case '+':
                                    case '-':
                                    case '.':
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                                    case ',':
                                    case ':':
                                        return cLElement;
                                    case '/':
                                        int i2 = i + 1;
                                        if (i2 < cArr.length && cArr[i2] == '/') {
                                            this.mHasComment = true;
                                            return cLElement;
                                        }
                                        return cLElement;
                                    default:
                                        if ((cLElement instanceof CLContainer) && !(cLElement instanceof CLObject)) {
                                            CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                                            CLToken cLToken = (CLToken) createElement;
                                            if (!cLToken.validate(c, i)) {
                                                throw new CLParsingException("incorrect token <" + c + "> at line " + this.mLineNumber, cLToken);
                                            }
                                            return createElement;
                                        }
                                        return createElement(cLElement, i, TYPE.KEY, true, cArr);
                                }
                            }
                        } else {
                            return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                        }
                    }
                    cLElement.setEnd(i - 1);
                    CLElement container = cLElement.getContainer();
                    container.setEnd(i);
                    return container;
                }
                return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
            }
            if (cLElement instanceof CLObject) {
                return createElement(cLElement, i, TYPE.KEY, true, cArr);
            }
            return createElement(cLElement, i, TYPE.STRING, true, cArr);
        }
        return cLElement;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i = 1;
        this.mLineNumber = 1;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            char c = charArray[i2];
            if (c == '{') {
                break;
            }
            if (c == '\n') {
                this.mLineNumber++;
            }
            i2++;
        }
        if (i2 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.mLineNumber);
            allocate.setStart(i2);
            int i3 = i2 + 1;
            CLElement cLElement = allocate;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c2 == '\n') {
                    this.mLineNumber += i;
                }
                if (this.mHasComment) {
                    if (c2 == '\n') {
                        this.mHasComment = z;
                    } else {
                        continue;
                        i3++;
                        i = 1;
                        z = false;
                    }
                }
                if (cLElement == null) {
                    break;
                }
                if (cLElement.isDone()) {
                    cLElement = getNextJsonElement(i3, c2, cLElement, charArray);
                } else if (cLElement instanceof CLObject) {
                    if (c2 == '}') {
                        cLElement.setEnd(i3 - 1);
                    } else {
                        cLElement = getNextJsonElement(i3, c2, cLElement, charArray);
                    }
                } else if (!(cLElement instanceof CLArray)) {
                    boolean z2 = cLElement instanceof CLString;
                    if (z2) {
                        long j = cLElement.mStart;
                        if (charArray[(int) j] == c2) {
                            cLElement.setStart(j + 1);
                            cLElement.setEnd(i3 - 1);
                        }
                    } else {
                        if (cLElement instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLElement;
                            if (!cLToken.validate(c2, i3)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                            }
                        }
                        if ((cLElement instanceof CLKey) || z2) {
                            long j2 = cLElement.mStart;
                            char c3 = charArray[(int) j2];
                            if ((c3 == '\'' || c3 == '\"') && c3 == c2) {
                                cLElement.setStart(j2 + 1);
                                cLElement.setEnd(i3 - 1);
                            }
                        }
                        if (!cLElement.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == ':')) {
                            long j3 = i3 - 1;
                            cLElement.setEnd(j3);
                            if (c2 == '}' || c2 == ']') {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j3);
                                if (cLElement instanceof CLKey) {
                                    cLElement = cLElement.getContainer();
                                    cLElement.setEnd(j3);
                                }
                            }
                        }
                    }
                } else if (c2 == ']') {
                    cLElement.setEnd(i3 - 1);
                } else {
                    cLElement = getNextJsonElement(i3, c2, cLElement, charArray);
                }
                if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).mElements.size() > 0)) {
                    cLElement = cLElement.getContainer();
                }
                i3++;
                i = 1;
                z = false;
            }
            while (cLElement != null && !cLElement.isDone()) {
                if (cLElement instanceof CLString) {
                    cLElement.setStart(((int) cLElement.mStart) + 1);
                }
                cLElement.setEnd(length - 1);
                cLElement = cLElement.getContainer();
            }
            if (sDebug) {
                System.out.println("Root: " + allocate.toJSON());
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", null);
    }
}
