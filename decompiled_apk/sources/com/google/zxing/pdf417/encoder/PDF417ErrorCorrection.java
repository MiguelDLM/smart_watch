package com.google.zxing.pdf417.encoder;

import OoIXo.xXxxox0I;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alimm.tanx.core.constant.AdType;
import com.baidu.ar.camera.CameraManager;
import com.baidu.mobads.sdk.internal.cm;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.garmin.fit.IXXIXx00I;
import com.garmin.fit.OxXXx0X;
import com.garmin.fit.X0xOO;
import com.goodix.ble.gr.libdfu.task.sub.ResultCode;
import com.goodix.ble.libcomx.task.ITask;
import com.goodix.ble.libcomx.task.ITaskSet;
import com.goodix.ble.libcomx.task.TaskPipe;
import com.goodix.ble.libcomx.util.AccessLock;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.huawei.openalliance.ad.constant.ah;
import com.jieli.jl_rcsp.constant.Command;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.sifli.siflidfu.constants.General;
import com.sma.smartv3.view.picker.WeightPicker;
import com.szabh.smable3.entity.BleMatchRecord;
import com.szabh.smable3.entity.BleNewsFeed;
import com.szabh.smable3.entity.BleQiblaSettings;

/* loaded from: classes10.dex */
final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, AdType.BOTTOM_FLOATING}, new int[]{DfuConstants.PROGRESS_HAND_OVER_PROCESSING, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET, ah.W, 132, X0xOO.f13613OooO0XOx, 116, ah.t, 428, X0xOO.f13613OooO0XOx, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, ScreenUtil.SCREEN_SIZE_Y_LARGE, X0xOO.f13592OIxI0O, DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, X0xOO.f13583O0o0, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 858, ITaskSet.EVT_SUBTASK_PROGRESS, DfuAdapter.STATE_READ_IMAGE_INFO, IXXIXx00I.f11717X0xII0I, 511, 400, 672, 762, 283, 184, WeightPicker.f25581OxI, 35, 519, 31, 460, 594, 225, DfuAdapter.STATE_PREPARE_CONNECTING, 517, 352, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 158, 651, 201, 488, 502, 648, 733, OxXXx0X.f13264xoXoI, 83, 404, 97, 280, 771, 840, 629, 4, 381, cm.c, 623, 264, DfuAdapter.STATE_READ_IMAGE_INFO}, new int[]{521, 310, 864, 547, 858, 580, X0xOO.f13664XxXX, 379, 53, 779, 897, 444, 400, 925, 749, 415, ITaskSet.EVT_SUBTASK_PROGRESS, 93, Command.CMD_GET_DEVICE_CONFIG_INFO, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, TaskPipe.EVT_TASK_ADDED, 631, X0xOO.f13752xoX, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, X0xOO.f13752xoX, 272, 96, 684, ah.s, 686, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, EMachine.EM_MANIK, 491, 297, 763, 156, 732, 95, 270, TaskPipe.EVT_TASK_ADDED, 90, 507, 48, 228, ITaskSet.EVT_SUBTASK_START, 808, 898, 784, 663, 627, 378, ResultCode.INVALID_FILE, 262, 380, 602, 754, 336, 89, 614, 87, ah.s, 670, 616, 157, 374, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 726, 600, 269, IXXIXx00I.f11766x0, 898, 845, 454, 354, 130, 814, 587, ah.Y, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, ah.W, 4, 108, 539}, new int[]{DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET, 894, 75, DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, CameraManager.DEFAULTHEIGHT, 858, 194, 311, DetailedCreativeType.SHORT_TEXT, 275, 190, IXXIXx00I.f11766x0, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 540, DetailedCreativeType.SHORT_TEXT, ah.W, 700, 799, 137, 439, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 592, 668, 353, 859, IXXIXx00I.f11791xxOXOOoIX, 694, X0xOO.f13565IoX, 240, 216, 257, 284, 549, 209, 884, 315, 70, X0xOO.f13631X0xOO, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, IXXIXx00I.f11717X0xII0I, 849, 521, 307, X0xOO.f13580O0OOX0IIx, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, BleNewsFeed.CONTENT_MAX_LENGTH, 637, 731, 66, 255, AdType.BOTTOM_FLOATING, 269, 463, 830, 730, 433, 848, 585, 136, 538, TypedValues.Custom.TYPE_REFERENCE, 90, 2, 290, 743, 199, 655, 903, X0xOO.f13631X0xOO, 49, ah.X, 580, AccessLock.EVT_LOCK_ACQUIRED, 588, 188, 462, 10, 134, 628, X0xOO.f13583O0o0, 479, 130, 739, 71, 263, 318, 374, 601, 192, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 142, 673, 687, 234, ResultCode.SET_IMG_LIST_FAILED, RendererCapabilities.MODE_SUPPORT_MASK, 177, 752, TypedValues.MotionType.TYPE_PATHMOTION_ARC, ScreenUtil.SCREEN_SIZE_Y_LARGE, 455, 193, 689, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, BNMapObserver.EventMapView.EVENT_CLICKED_ROUTE_PAN_ITEM, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, DetailedCreativeType.LONG_TEXT, ITask.EVT_FINISH, 126, 32, 681, 331, 792, 620, 60, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, xXxxox0I.f2539xxIXOIIO, 180, 791, 893, 754, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, X0xOO.f13593OIxOX, 922, EMachine.EM_TILEGX, 910, 532, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 829, PsExtractor.PRIVATE_STREAM_1, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, ah.w, 555, 642, DfuAdapter.STATE_READ_IMAGE_INFO, 307, 159, 924, 558, 648, 55, ah.w, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, ah.x, 285, 380, 350, 492, 197, 265, BleMatchRecord.ITEM_LENGTH, 155, DetailedCreativeType.LONG_TEXT, X0xOO.f13593OIxOX, 229, 643, X0xOO.f13756xx0, 871, 306, 88, 87, 193, 352, 781, 846, 75, X0xOO.f13733xIoXXXIXo, 520, 435, DfuAdapter.STATE_READ_IMAGE_INFO, 203, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, IXXIXx00I.f11690IoXIXo, 781, 621, ScreenUtil.SCREEN_SIZE_Y_LARGE, 268, 794, DfuAdapter.STATE_PREPARE_PAIRING_REQUEST, 539, 781, 408, 390, 644, 102, 476, ah.y, 290, 632, 545, 37, 858, 916, 552, 41, DfuAdapter.STATE_READ_BATTERY_INFO, 289, 122, 272, 383, 800, 485, 98, 752, 472, TaskPipe.EVT_BUSY, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, DetailedCreativeType.SHORT_TEXT, 142, 808, 684, 287, DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, 610, RendererCapabilities.MODE_SUPPORT_MASK, 168, 190, 826, X0xOO.f13610OoIXo, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, TTAdConstant.VALUE_CLICK_AREA_SAAS_AUTH, 850, 836, 827, 736, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 94, 8, 494, 114, 521, 2, ah.y, 851, DfuAdapter.STATE_READ_IMAGE_INFO, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, BleQiblaSettings.ITEM_LENGTH, 167, ITask.EVT_FINISH, 244, 173, 35, 463, 651, 51, 699, 591, BleQiblaSettings.ITEM_LENGTH, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, OxXXx0X.f13077OxxIIOOXO, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, X0xOO.f13733xIoXXXIXo, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, TypedValues.MotionType.TYPE_DRAW_PATH, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE, 35, 777, 618, 586, 424, 833, 77, 597, IXXIXx00I.f11690IoXIXo, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, xXxxox0I.f2539xxIXOIIO, 207, 300, 892, 827, 141, DfuAdapter.STATE_DISCOVERY_SERVICE, 381, 662, 513, 56, 252, 341, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 797, 838, 837, CameraManager.DEFAULTHEIGHT, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, OxXXx0X.f13076Oxx0xo, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, General.SIFLI_DFU_PACKET_BODY_LEN_NOR, 249, X0xOO.f13592OIxI0O, 881, 699, DfuAdapter.STATE_PREPARE_CONNECTING, 673, OxXXx0X.f13142o00, 210, 815, 905, 303, cm.c, 922, 281, 73, 469, 791, 660, 162, ah.x, 308, 155, 422, 907, 817, 187, 62, 16, 425, DfuAdapter.STATE_PREPARE_CONNECTING, 336, 286, 437, IXXIXx00I.f11766x0, 273, 610, X0xOO.f13664XxXX, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, TTAdConstant.VALUE_CLICK_AREA_SAAS_AUTH, CameraManager.DEFAULTHEIGHT, 742, 330, 5, 39, 923, 311, 424, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 749, X0xOO.f13592OIxI0O, 54, 669, 316, ITask.EVT_FINISH, X0xOO.f13593OIxOX, DfuAdapter.STATE_PREPARE_PAIRING_REQUEST, 105, 667, 488, ScreenUtil.SCREEN_SIZE_Y_LARGE, 672, 576, 540, 316, 486, 721, 610, 46, 656, TaskPipe.EVT_TASK_ADDED, EMachine.EM_MANIK, 616, 464, 190, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, 297, X0xOO.f13592OIxI0O, 762, 752, 533, EMachine.EM_MCST_ELBRUS, 134, 14, 381, 433, OxXXx0X.f13264xoXoI, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, X0xOO.f13565IoX, ah.x, 655, TTAdConstant.VALUE_CLICK_AREA_SAAS_AUTH, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, IXXIXx00I.f11755oXxOI0oIx, 244, 31, 121, 303, 263}};

    private PDF417ErrorCorrection() {
    }

    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            char c = cArr[i4];
            if (c != 0) {
                cArr[i4] = (char) (929 - c);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i) {
        if (i >= 0 && i <= 8) {
            return 1 << (i + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i > 0) {
            if (i <= 40) {
                return 2;
            }
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }
}
