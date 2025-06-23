package com.google.zxing.maxicode.decoder;

import OoIXo.xXxxox0I;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.ar.camera.CameraManager;
import com.baidu.mobads.sdk.internal.cm;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.UIMsg;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.garmin.fit.IXXIXx00I;
import com.garmin.fit.OxXXx0X;
import com.garmin.fit.X0xOO;
import com.goodix.ble.gr.libdfu.task.sub.ResultCode;
import com.goodix.ble.libble.center.BleCenter;
import com.goodix.ble.libble.v2.profile.BatteryService;
import com.goodix.ble.libcomx.ptmodel.PtStep;
import com.goodix.ble.libcomx.task.ITask;
import com.goodix.ble.libcomx.task.ITaskSet;
import com.goodix.ble.libcomx.task.TaskPipe;
import com.goodix.ble.libcomx.util.AccessLock;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus;
import com.google.zxing.common.BitMatrix;
import com.huawei.openalliance.ad.constant.ah;
import com.jieli.jl_rcsp.constant.Command;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.sifli.siflidfu.constants.General;
import com.sma.smartv3.ui.me.CoachingSegmentEditActivity;
import com.sma.smartv3.view.picker.HeightPicker;
import com.sma.smartv3.view.picker.WeightPicker;
import com.szabh.smable3.entity.BleNewsFeed;
import com.szabh.smable3.entity.BleQiblaSettings;

/* loaded from: classes10.dex */
final class BitMatrixParser {
    private static final int[][] BITNR = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, 157, 156, 163, 162, 169, 168, EMachine.EM_MCST_ELBRUS, 174, 181, 180, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, 147, 146, 153, 152, 159, 158, 165, 164, EMachine.EM_MANIK, 170, 177, 176, 183, 182, PsExtractor.PRIVATE_STREAM_1, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, 149, 148, 155, 154, 161, 160, 167, 166, 173, 172, EMachine.EM_SLE9X, 178, 185, 184, EMachine.EM_TILEGX, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, Command.CMD_PHONE_NUMBER_PLAY_MODE, 240, 235, 234, 229, 228, 223, 222, Command.CMD_GET_DEVICE_CONFIG_INFO, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, 254, 249, 248, 243, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 237, 236, 231, 230, 225, 224, 219, HeightPicker.f25534xoXoI, 213, 212, 207, 206, ITaskSet.EVT_SUBTASK_START, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, 250, 245, 244, 239, 238, 233, 232, 227, 226, 221, CoachingSegmentEditActivity.HR_MAX, 215, Command.CMD_GET_EXTERNAL_FLASH_MSG, 209, 208, ITaskSet.EVT_SUBTASK_PROGRESS, -3}, new int[]{289, 288, X0xOO.f13613OooO0XOx, X0xOO.f13756xx0, 301, 300, 307, 306, 313, 312, 319, 318, X0xOO.f13565IoX, X0xOO.f13644XOo0, 331, 330, 337, 336, 343, ITask.EVT_FINISH, 349, 348, AccessLock.EVT_LOCK_ACQUIRED, 354, 361, 360, 367, 366, 824, ITaskSet.EVT_SUBTASK_FINISH}, new int[]{X0xOO.f13580O0OOX0IIx, 290, 297, X0xOO.f13664XxXX, 303, 302, 309, 308, 315, 314, X0xOO.f13592OIxI0O, X0xOO.f13583O0o0, X0xOO.f13733xIoXXXIXo, X0xOO.f13676oI0, 333, 332, 339, 338, 345, 344, 351, 350, TTAdConstant.VALUE_CLICK_AREA_SAAS_AUTH, 356, 363, 362, 369, 368, 825, -3}, new int[]{X0xOO.f13594OIxx0I0, X0xOO.f13752xoX, X0xOO.f13593OIxOX, 298, 305, 304, 311, 310, 317, 316, 323, X0xOO.f13558IXX, X0xOO.f13631X0xOO, X0xOO.f13610OoIXo, 335, 334, 341, ITask.EVT_START, 347, IXXIXx00I.f11690IoXIXo, 353, 352, 359, 358, 365, 364, IXXIXx00I.f11780xXoOI00O, IXXIXx00I.f11791xxOXOOoIX, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, RendererCapabilities.MODE_SUPPORT_MASK, 379, 378, 373, IXXIXx00I.f11768x0OxxIOxX, 828, -3}, new int[]{411, 410, 405, 404, 399, IXXIXx00I.f11719XI, IXXIXx00I.f11728XOxxooXI, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, IXXIXx00I.f11718X0xxXX0, 386, 381, 380, IXXIXx00I.f11766x0, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, IXXIXx00I.f11755oXxOI0oIx, IXXIXx00I.f11682IO0XoXxO, 383, ResultCode.INVALID_FILE, 377, IXXIXx00I.f11717X0xII0I, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, ah.s, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, xXxxox0I.f2539xxIXOIIO, WeightPicker.f25581OxI, TaskPipe.EVT_TASK_ADDED, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, ah.t, 449, 448, 836, 835}, new int[]{481, 480, OxXXx0X.f13077OxxIIOOXO, OxXXx0X.f13158oI0IIXIo, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, BleNewsFeed.CONTENT_MAX_LENGTH, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 453, BleQiblaSettings.ITEM_LENGTH, 839, 838}, new int[]{485, 484, 479, 478, OxXXx0X.f13076Oxx0xo, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 492, ah.y, ah.x, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, cm.c, -3}, new int[]{491, 490, ah.w, ah.v, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, DfuAdapter.STATE_SYNC_SUB_INFO, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, DfuAdapter.STATE_PREPARE_CONNECTING, DfuAdapter.STATE_PREPARE_PAIRING_REQUEST, BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE, BNMapObserver.EventMapView.EVENT_CLICKED_ROUTE_PAN_ITEM, 523, DfuConstants.PROGRESS_HAND_OVER_PROCESSING, 846, -3}, new int[]{561, 560, 555, ResultCode.TIMEOUT, 549, General.SIFLI_DFU_PACKET_BODY_LEN_NOR, DfuAdapter.STATE_READ_IMAGE_INFO, DfuAdapter.STATE_READ_BATTERY_INFO, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, DfuAdapter.STATE_DISCOVERY_SERVICE, DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM, 530, 525, DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, UIMsg.MsgDefine.MSG_LOG_GESTURE, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, TypedValues.MotionType.TYPE_PATHMOTION_ARC, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, TypedValues.MotionType.TYPE_DRAW_PATH, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, BleCenter.EVT_REMOVED, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, ScreenUtil.SCREEN_SIZE_Y_LARGE, 647, 646, 854, 853}, new int[]{727, 726, 721, CameraManager.DEFAULTHEIGHT, 715, 714, 709, 708, ah.P, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, PtStep.EVT_JUDGE_UPDATED, 723, ResultCode.SET_IMG_LIST_FAILED, OxXXx0X.f13264xoXoI, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 718, 713, 712, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, BatteryService.EVT_BATTERY_UPDATE, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, ah.Y, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, OxXXx0X.f13142o00, 789, 788, 795, 794, ah.W, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, TaskPipe.EVT_BUSY, 760, DfuException.ERROR_NOTIFICATION_NO_RESPONSE, DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, ah.X, 809, 808, 815, 814, 863, 862}};
    private final BitMatrix bitMatrix;

    public BitMatrixParser(BitMatrix bitMatrix) {
        this.bitMatrix = bitMatrix;
    }

    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = BITNR[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
