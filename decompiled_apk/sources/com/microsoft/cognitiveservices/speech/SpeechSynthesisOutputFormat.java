package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum SpeechSynthesisOutputFormat {
    Raw8Khz8BitMonoMULaw(1),
    Riff16Khz16KbpsMonoSiren(2),
    Audio16Khz16KbpsMonoSiren(3),
    Audio16Khz32KBitRateMonoMp3(4),
    Audio16Khz128KBitRateMonoMp3(5),
    Audio16Khz64KBitRateMonoMp3(6),
    Audio24Khz48KBitRateMonoMp3(7),
    Audio24Khz96KBitRateMonoMp3(8),
    Audio24Khz160KBitRateMonoMp3(9),
    Raw16Khz16BitMonoTrueSilk(10),
    Riff16Khz16BitMonoPcm(11),
    Riff8Khz16BitMonoPcm(12),
    Riff24Khz16BitMonoPcm(13),
    Riff8Khz8BitMonoMULaw(14),
    Raw16Khz16BitMonoPcm(15),
    Raw24Khz16BitMonoPcm(16),
    Raw8Khz16BitMonoPcm(17),
    Ogg16Khz16BitMonoOpus(18),
    Ogg24Khz16BitMonoOpus(19),
    Raw48Khz16BitMonoPcm(20),
    Riff48Khz16BitMonoPcm(21),
    Audio48Khz96KBitRateMonoMp3(22),
    Audio48Khz192KBitRateMonoMp3(23),
    Ogg48Khz16BitMonoOpus(24),
    Webm16Khz16BitMonoOpus(25),
    Webm24Khz16BitMonoOpus(26),
    Raw24Khz16BitMonoTrueSilk(27),
    Raw8Khz8BitMonoALaw(28),
    Riff8Khz8BitMonoALaw(29),
    Webm24Khz16Bit24KbpsMonoOpus(30),
    Audio16Khz16Bit32KbpsMonoOpus(31),
    Audio24Khz16Bit48KbpsMonoOpus(32),
    Audio24Khz16Bit24KbpsMonoOpus(33),
    Raw22050Hz16BitMonoPcm(34),
    Riff22050Hz16BitMonoPcm(35),
    Raw44100Hz16BitMonoPcm(36),
    Riff44100Hz16BitMonoPcm(37),
    AmrWb16000Hz(38),
    G72216Khz64Kbps(39);

    private final int id;

    SpeechSynthesisOutputFormat(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
