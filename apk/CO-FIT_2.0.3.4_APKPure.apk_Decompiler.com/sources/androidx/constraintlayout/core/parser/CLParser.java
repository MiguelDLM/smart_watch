package androidx.constraintlayout.core.parser;

public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

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
        CLElement cLElement2;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElement2 = CLObject.allocate(cArr);
                break;
            case 2:
                cLElement2 = CLArray.allocate(cArr);
                break;
            case 3:
                cLElement2 = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElement2 = CLString.allocate(cArr);
                break;
            case 5:
                cLElement2 = CLKey.allocate(cArr);
                break;
            case 6:
                cLElement2 = CLToken.allocate(cArr);
                break;
            default:
                cLElement2 = null;
                break;
        }
        i++;
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.setLine(this.mLineNumber);
        if (z) {
            cLElement2.setStart((long) i);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.setContainer((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c == 9 || c == 10 || c == 13 || c == ' ') {
            return cLElement;
        }
        if (c == '\"' || c == '\'') {
            if (cLElement instanceof CLObject) {
                return createElement(cLElement, i, TYPE.KEY, true, cArr);
            }
            return createElement(cLElement, i, TYPE.STRING, true, cArr);
        } else if (c != '[') {
            if (c != ']') {
                if (c == '{') {
                    return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                } else if (c != '}') {
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
                            if (i2 >= cArr.length || cArr[i2] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i, TYPE.KEY, true, cArr);
                            }
                            CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) createElement;
                            if (cLToken.validate(c, (long) i)) {
                                return createElement;
                            }
                            throw new CLParsingException("incorrect token <" + c + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd((long) (i - 1));
            CLElement container = cLElement.getContainer();
            container.setEnd((long) i);
            return container;
        } else {
            return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
        }
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
            if (c == 10) {
                this.mLineNumber++;
            }
            i2++;
        }
        if (i2 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.mLineNumber);
            allocate.setStart((long) i2);
            int i3 = i2 + 1;
            CLElement cLElement = allocate;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c2 == 10) {
                    this.mLineNumber += i;
                }
                if (this.mHasComment) {
                    if (c2 == 10) {
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
                        cLElement.setEnd((long) (i3 - 1));
                    } else {
                        cLElement = getNextJsonElement(i3, c2, cLElement, charArray);
                    }
                } else if (!(cLElement instanceof CLArray)) {
                    boolean z2 = cLElement instanceof CLString;
                    if (z2) {
                        long j = cLElement.mStart;
                        if (charArray[(int) j] == c2) {
                            cLElement.setStart(j + 1);
                            cLElement.setEnd((long) (i3 - 1));
                        }
                    } else {
                        if (cLElement instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLElement;
                            if (!cLToken.validate(c2, (long) i3)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                            }
                        }
                        if ((cLElement instanceof CLKey) || z2) {
                            long j2 = cLElement.mStart;
                            char c3 = charArray[(int) j2];
                            if ((c3 == '\'' || c3 == '\"') && c3 == c2) {
                                cLElement.setStart(j2 + 1);
                                cLElement.setEnd((long) (i3 - 1));
                            }
                        }
                        if (!cLElement.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == 9 || c2 == 13 || c2 == 10 || c2 == ':')) {
                            long j3 = (long) (i3 - 1);
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
                    cLElement.setEnd((long) (i3 - 1));
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
                    cLElement.setStart((long) (((int) cLElement.mStart) + 1));
                }
                cLElement.setEnd((long) (length - 1));
                cLElement = cLElement.getContainer();
            }
            if (sDebug) {
                System.out.println("Root: " + allocate.toJSON());
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", (CLElement) null);
    }
}
