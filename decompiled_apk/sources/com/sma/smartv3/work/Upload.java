package com.sma.smartv3.work;

import android.content.Context;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.gson.Gson;
import com.sma.androidthirdpartylogin.google.GoogleFit;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.dao.AlipayBindInfoDao;
import com.sma.smartv3.db.dao.BloodOxygenDao;
import com.sma.smartv3.db.dao.BloodPressureDao;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.dao.SleepDao;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.dao.WorkoutDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.db.entity.AlipayBindInfo;
import com.sma.smartv3.db.entity.BloodOxygen;
import com.sma.smartv3.db.entity.BloodPressure;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Sleep;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.SMADataUploadData;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.entity.BleSleep;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDataWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataWorker.kt\ncom/sma/smartv3/work/Upload\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,947:1\n264#1,6:950\n515#1,68:956\n583#1,6:1027\n591#1,55:1034\n270#1,3:1089\n287#1,8:1092\n295#1,11:1102\n307#1,8:1114\n315#1,6:1124\n322#1,8:1131\n330#1,7:1141\n338#1,7:1149\n345#1,7:1158\n353#1,8:1166\n361#1,6:1176\n368#1,7:1183\n375#1,9:1192\n385#1,7:1202\n392#1,8:1211\n401#1,7:1220\n408#1,6:1229\n415#1,7:1236\n422#1,34:1245\n457#1,7:1280\n464#1,6:1289\n471#1,7:1296\n478#1,11:1305\n490#1,7:1317\n512#1:1324\n264#1,6:1325\n515#1,68:1331\n583#1,6:1402\n591#1,55:1409\n270#1,3:1464\n287#1,8:1467\n295#1,11:1477\n307#1,8:1489\n315#1,6:1499\n322#1,8:1506\n330#1,7:1516\n338#1,7:1524\n345#1,7:1533\n353#1,8:1541\n361#1,6:1551\n368#1,7:1558\n375#1,9:1567\n385#1,7:1577\n392#1,8:1586\n401#1,7:1595\n408#1,6:1604\n415#1,7:1611\n422#1,34:1620\n457#1,7:1655\n464#1,6:1664\n471#1,7:1671\n478#1,11:1680\n490#1,7:1692\n512#1:1699\n264#1,6:1700\n515#1,68:1706\n583#1,6:1777\n591#1,55:1784\n270#1,3:1839\n287#1,8:1842\n295#1,11:1852\n307#1,8:1864\n315#1,6:1874\n322#1,8:1881\n330#1,7:1891\n338#1,7:1899\n345#1,7:1908\n353#1,8:1916\n361#1,6:1926\n368#1,7:1933\n375#1,9:1942\n385#1,7:1952\n392#1,8:1961\n401#1,7:1970\n408#1,6:1979\n415#1,7:1986\n422#1,34:1995\n457#1,7:2030\n464#1,6:2039\n471#1,7:2046\n478#1,11:2055\n490#1,7:2067\n512#1:2074\n264#1,6:2075\n515#1,68:2081\n583#1,6:2152\n591#1,55:2159\n270#1,3:2214\n287#1,8:2217\n295#1,11:2227\n307#1,8:2239\n315#1,6:2249\n322#1,8:2256\n330#1,7:2266\n338#1,7:2274\n345#1,7:2283\n353#1,8:2291\n361#1,6:2301\n368#1,7:2308\n375#1,9:2317\n385#1,7:2327\n392#1,8:2336\n401#1,7:2345\n408#1,6:2354\n415#1,7:2361\n422#1,34:2370\n457#1,7:2405\n464#1,6:2414\n471#1,7:2421\n478#1,11:2430\n490#1,7:2442\n512#1:2449\n264#1,6:2450\n515#1,68:2456\n583#1,6:2527\n591#1,55:2534\n270#1,3:2589\n287#1,8:2592\n295#1,11:2602\n307#1,8:2614\n315#1,6:2624\n322#1,8:2631\n330#1,7:2641\n338#1,7:2649\n345#1,7:2658\n353#1,8:2666\n361#1,6:2676\n368#1,7:2683\n375#1,9:2692\n385#1,7:2702\n392#1,8:2711\n401#1,7:2720\n408#1,6:2729\n415#1,7:2736\n422#1,34:2745\n457#1,7:2780\n464#1,6:2789\n471#1,7:2796\n478#1,11:2805\n490#1,7:2817\n512#1:2824\n264#1,6:2825\n515#1,68:2831\n583#1,6:2902\n591#1,55:2909\n270#1,3:2964\n287#1,8:2967\n295#1,11:2977\n307#1,8:2989\n315#1,6:2999\n322#1,8:3006\n330#1,7:3016\n338#1,7:3024\n345#1,7:3033\n353#1,8:3041\n361#1,6:3051\n368#1,7:3058\n375#1,9:3067\n385#1,7:3077\n392#1,8:3086\n401#1,7:3095\n408#1,6:3104\n415#1,7:3111\n422#1,34:3120\n457#1,7:3155\n464#1,6:3164\n471#1,7:3171\n478#1,11:3180\n490#1,7:3192\n512#1:3199\n264#1,6:3200\n515#1,68:3206\n583#1,6:3277\n591#1,55:3284\n270#1,3:3339\n287#1,8:3342\n295#1,11:3352\n307#1,8:3364\n315#1,6:3374\n322#1,8:3381\n330#1,7:3391\n338#1,7:3399\n345#1,7:3408\n353#1,8:3416\n361#1,6:3426\n368#1,7:3433\n375#1,9:3442\n385#1,7:3452\n392#1,8:3461\n401#1,7:3470\n408#1,6:3479\n415#1,7:3486\n422#1,34:3495\n457#1,7:3530\n464#1,6:3539\n471#1,7:3546\n478#1,11:3555\n490#1,7:3567\n512#1:3574\n264#1,6:3575\n515#1,68:3581\n583#1,6:3652\n591#1,55:3659\n270#1,3:3714\n287#1,8:3717\n295#1,11:3727\n307#1,8:3739\n315#1,6:3749\n322#1,8:3756\n330#1,7:3766\n338#1,7:3774\n345#1,7:3783\n353#1,8:3791\n361#1,6:3801\n368#1,7:3808\n375#1,9:3817\n385#1,7:3827\n392#1,8:3836\n401#1,7:3845\n408#1,6:3854\n415#1,7:3861\n422#1,34:3870\n457#1,7:3905\n464#1,6:3914\n471#1,7:3921\n478#1,11:3930\n490#1,7:3942\n512#1:3949\n264#1,6:3950\n515#1,68:3956\n583#1,6:4027\n591#1,55:4034\n270#1,3:4089\n287#1,8:4092\n295#1,11:4102\n307#1,8:4114\n315#1,6:4124\n322#1,8:4131\n330#1,7:4141\n338#1,7:4149\n345#1,7:4158\n353#1,8:4166\n361#1,6:4176\n368#1,7:4183\n375#1,9:4192\n385#1,7:4202\n392#1,8:4211\n401#1,7:4220\n408#1,6:4229\n415#1,7:4236\n422#1,34:4245\n457#1,7:4280\n464#1,6:4289\n471#1,7:4296\n478#1,11:4305\n490#1,7:4317\n512#1:4324\n264#1,6:4325\n515#1,68:4331\n583#1,6:4402\n591#1,55:4409\n270#1,3:4464\n287#1,8:4467\n295#1,11:4477\n307#1,8:4489\n315#1,6:4499\n322#1,8:4506\n330#1,7:4516\n338#1,7:4524\n345#1,7:4533\n353#1,8:4541\n361#1,6:4551\n368#1,7:4558\n375#1,9:4567\n385#1,7:4577\n392#1,8:4586\n401#1,7:4595\n408#1,6:4604\n415#1,7:4611\n422#1,34:4620\n457#1,7:4655\n464#1,6:4664\n471#1,7:4671\n478#1,11:4680\n490#1,7:4692\n512#1:4699\n264#1,6:4700\n515#1,68:4706\n583#1,6:4777\n591#1,55:4784\n270#1,3:4839\n287#1,8:4842\n295#1,11:4852\n307#1,8:4864\n315#1,6:4874\n322#1,8:4881\n330#1,7:4891\n338#1,7:4899\n345#1,7:4908\n353#1,8:4916\n361#1,6:4926\n368#1,7:4933\n375#1,9:4942\n385#1,7:4952\n392#1,8:4961\n401#1,7:4970\n408#1,6:4979\n415#1,7:4986\n422#1,34:4995\n457#1,7:5030\n464#1,6:5039\n471#1,7:5046\n478#1,11:5055\n490#1,7:5067\n512#1:5074\n515#1,68:5075\n583#1,6:5146\n591#1,55:5153\n19#2:948\n15#2:949\n1549#3:1024\n1620#3,2:1025\n1622#3:1033\n1620#3,2:1100\n1622#3:1113\n1620#3,2:1122\n1622#3:1130\n1620#3,2:1139\n1622#3:1148\n1620#3,2:1156\n1622#3:1165\n1620#3,2:1174\n1622#3:1182\n1620#3,2:1190\n1622#3:1201\n1620#3,2:1209\n1622#3:1219\n1620#3,2:1227\n1622#3:1235\n1620#3,2:1243\n1622#3:1279\n1620#3,2:1287\n1622#3:1295\n1620#3,2:1303\n1622#3:1316\n1549#3:1399\n1620#3,2:1400\n1622#3:1408\n1620#3,2:1475\n1622#3:1488\n1620#3,2:1497\n1622#3:1505\n1620#3,2:1514\n1622#3:1523\n1620#3,2:1531\n1622#3:1540\n1620#3,2:1549\n1622#3:1557\n1620#3,2:1565\n1622#3:1576\n1620#3,2:1584\n1622#3:1594\n1620#3,2:1602\n1622#3:1610\n1620#3,2:1618\n1622#3:1654\n1620#3,2:1662\n1622#3:1670\n1620#3,2:1678\n1622#3:1691\n1549#3:1774\n1620#3,2:1775\n1622#3:1783\n1620#3,2:1850\n1622#3:1863\n1620#3,2:1872\n1622#3:1880\n1620#3,2:1889\n1622#3:1898\n1620#3,2:1906\n1622#3:1915\n1620#3,2:1924\n1622#3:1932\n1620#3,2:1940\n1622#3:1951\n1620#3,2:1959\n1622#3:1969\n1620#3,2:1977\n1622#3:1985\n1620#3,2:1993\n1622#3:2029\n1620#3,2:2037\n1622#3:2045\n1620#3,2:2053\n1622#3:2066\n1549#3:2149\n1620#3,2:2150\n1622#3:2158\n1620#3,2:2225\n1622#3:2238\n1620#3,2:2247\n1622#3:2255\n1620#3,2:2264\n1622#3:2273\n1620#3,2:2281\n1622#3:2290\n1620#3,2:2299\n1622#3:2307\n1620#3,2:2315\n1622#3:2326\n1620#3,2:2334\n1622#3:2344\n1620#3,2:2352\n1622#3:2360\n1620#3,2:2368\n1622#3:2404\n1620#3,2:2412\n1622#3:2420\n1620#3,2:2428\n1622#3:2441\n1549#3:2524\n1620#3,2:2525\n1622#3:2533\n1620#3,2:2600\n1622#3:2613\n1620#3,2:2622\n1622#3:2630\n1620#3,2:2639\n1622#3:2648\n1620#3,2:2656\n1622#3:2665\n1620#3,2:2674\n1622#3:2682\n1620#3,2:2690\n1622#3:2701\n1620#3,2:2709\n1622#3:2719\n1620#3,2:2727\n1622#3:2735\n1620#3,2:2743\n1622#3:2779\n1620#3,2:2787\n1622#3:2795\n1620#3,2:2803\n1622#3:2816\n1549#3:2899\n1620#3,2:2900\n1622#3:2908\n1620#3,2:2975\n1622#3:2988\n1620#3,2:2997\n1622#3:3005\n1620#3,2:3014\n1622#3:3023\n1620#3,2:3031\n1622#3:3040\n1620#3,2:3049\n1622#3:3057\n1620#3,2:3065\n1622#3:3076\n1620#3,2:3084\n1622#3:3094\n1620#3,2:3102\n1622#3:3110\n1620#3,2:3118\n1622#3:3154\n1620#3,2:3162\n1622#3:3170\n1620#3,2:3178\n1622#3:3191\n1549#3:3274\n1620#3,2:3275\n1622#3:3283\n1620#3,2:3350\n1622#3:3363\n1620#3,2:3372\n1622#3:3380\n1620#3,2:3389\n1622#3:3398\n1620#3,2:3406\n1622#3:3415\n1620#3,2:3424\n1622#3:3432\n1620#3,2:3440\n1622#3:3451\n1620#3,2:3459\n1622#3:3469\n1620#3,2:3477\n1622#3:3485\n1620#3,2:3493\n1622#3:3529\n1620#3,2:3537\n1622#3:3545\n1620#3,2:3553\n1622#3:3566\n1549#3:3649\n1620#3,2:3650\n1622#3:3658\n1620#3,2:3725\n1622#3:3738\n1620#3,2:3747\n1622#3:3755\n1620#3,2:3764\n1622#3:3773\n1620#3,2:3781\n1622#3:3790\n1620#3,2:3799\n1622#3:3807\n1620#3,2:3815\n1622#3:3826\n1620#3,2:3834\n1622#3:3844\n1620#3,2:3852\n1622#3:3860\n1620#3,2:3868\n1622#3:3904\n1620#3,2:3912\n1622#3:3920\n1620#3,2:3928\n1622#3:3941\n1549#3:4024\n1620#3,2:4025\n1622#3:4033\n1620#3,2:4100\n1622#3:4113\n1620#3,2:4122\n1622#3:4130\n1620#3,2:4139\n1622#3:4148\n1620#3,2:4156\n1622#3:4165\n1620#3,2:4174\n1622#3:4182\n1620#3,2:4190\n1622#3:4201\n1620#3,2:4209\n1622#3:4219\n1620#3,2:4227\n1622#3:4235\n1620#3,2:4243\n1622#3:4279\n1620#3,2:4287\n1622#3:4295\n1620#3,2:4303\n1622#3:4316\n1549#3:4399\n1620#3,2:4400\n1622#3:4408\n1620#3,2:4475\n1622#3:4488\n1620#3,2:4497\n1622#3:4505\n1620#3,2:4514\n1622#3:4523\n1620#3,2:4531\n1622#3:4540\n1620#3,2:4549\n1622#3:4557\n1620#3,2:4565\n1622#3:4576\n1620#3,2:4584\n1622#3:4594\n1620#3,2:4602\n1622#3:4610\n1620#3,2:4618\n1622#3:4654\n1620#3,2:4662\n1622#3:4670\n1620#3,2:4678\n1622#3:4691\n1549#3:4774\n1620#3,2:4775\n1622#3:4783\n1620#3,2:4850\n1622#3:4863\n1620#3,2:4872\n1622#3:4880\n1620#3,2:4889\n1622#3:4898\n1620#3,2:4906\n1622#3:4915\n1620#3,2:4924\n1622#3:4932\n1620#3,2:4940\n1622#3:4951\n1620#3,2:4959\n1622#3:4969\n1620#3,2:4977\n1622#3:4985\n1620#3,2:4993\n1622#3:5029\n1620#3,2:5037\n1622#3:5045\n1620#3,2:5053\n1622#3:5066\n1549#3:5143\n1620#3,2:5144\n1622#3:5152\n1549#3:5208\n1620#3,3:5209\n1549#3:5212\n1620#3,3:5213\n1549#3:5216\n1620#3,3:5217\n1549#3:5220\n1620#3,3:5221\n1549#3:5224\n1620#3,3:5225\n1549#3:5228\n1620#3,3:5229\n1549#3:5232\n1620#3,3:5233\n1549#3:5236\n1620#3,3:5237\n1549#3:5240\n1620#3,3:5241\n1549#3:5244\n1620#3,3:5245\n1549#3:5248\n1620#3,3:5249\n1549#3:5252\n1620#3,3:5253\n*S KotlinDebug\n*F\n+ 1 DataWorker.kt\ncom/sma/smartv3/work/Upload\n*L\n68#1:950,6\n68#1:956,68\n68#1:1027,6\n68#1:1034,55\n68#1:1089,3\n68#1:1092,8\n68#1:1102,11\n68#1:1114,8\n68#1:1124,6\n68#1:1131,8\n68#1:1141,7\n68#1:1149,7\n68#1:1158,7\n68#1:1166,8\n68#1:1176,6\n68#1:1183,7\n68#1:1192,9\n68#1:1202,7\n68#1:1211,8\n68#1:1220,7\n68#1:1229,6\n68#1:1236,7\n68#1:1245,34\n68#1:1280,7\n68#1:1289,6\n68#1:1296,7\n68#1:1305,11\n68#1:1317,7\n68#1:1324\n85#1:1325,6\n85#1:1331,68\n85#1:1402,6\n85#1:1409,55\n85#1:1464,3\n85#1:1467,8\n85#1:1477,11\n85#1:1489,8\n85#1:1499,6\n85#1:1506,8\n85#1:1516,7\n85#1:1524,7\n85#1:1533,7\n85#1:1541,8\n85#1:1551,6\n85#1:1558,7\n85#1:1567,9\n85#1:1577,7\n85#1:1586,8\n85#1:1595,7\n85#1:1604,6\n85#1:1611,7\n85#1:1620,34\n85#1:1655,7\n85#1:1664,6\n85#1:1671,7\n85#1:1680,11\n85#1:1692,7\n85#1:1699\n102#1:1700,6\n102#1:1706,68\n102#1:1777,6\n102#1:1784,55\n102#1:1839,3\n102#1:1842,8\n102#1:1852,11\n102#1:1864,8\n102#1:1874,6\n102#1:1881,8\n102#1:1891,7\n102#1:1899,7\n102#1:1908,7\n102#1:1916,8\n102#1:1926,6\n102#1:1933,7\n102#1:1942,9\n102#1:1952,7\n102#1:1961,8\n102#1:1970,7\n102#1:1979,6\n102#1:1986,7\n102#1:1995,34\n102#1:2030,7\n102#1:2039,6\n102#1:2046,7\n102#1:2055,11\n102#1:2067,7\n102#1:2074\n119#1:2075,6\n119#1:2081,68\n119#1:2152,6\n119#1:2159,55\n119#1:2214,3\n119#1:2217,8\n119#1:2227,11\n119#1:2239,8\n119#1:2249,6\n119#1:2256,8\n119#1:2266,7\n119#1:2274,7\n119#1:2283,7\n119#1:2291,8\n119#1:2301,6\n119#1:2308,7\n119#1:2317,9\n119#1:2327,7\n119#1:2336,8\n119#1:2345,7\n119#1:2354,6\n119#1:2361,7\n119#1:2370,34\n119#1:2405,7\n119#1:2414,6\n119#1:2421,7\n119#1:2430,11\n119#1:2442,7\n119#1:2449\n136#1:2450,6\n136#1:2456,68\n136#1:2527,6\n136#1:2534,55\n136#1:2589,3\n136#1:2592,8\n136#1:2602,11\n136#1:2614,8\n136#1:2624,6\n136#1:2631,8\n136#1:2641,7\n136#1:2649,7\n136#1:2658,7\n136#1:2666,8\n136#1:2676,6\n136#1:2683,7\n136#1:2692,9\n136#1:2702,7\n136#1:2711,8\n136#1:2720,7\n136#1:2729,6\n136#1:2736,7\n136#1:2745,34\n136#1:2780,7\n136#1:2789,6\n136#1:2796,7\n136#1:2805,11\n136#1:2817,7\n136#1:2824\n154#1:2825,6\n154#1:2831,68\n154#1:2902,6\n154#1:2909,55\n154#1:2964,3\n154#1:2967,8\n154#1:2977,11\n154#1:2989,8\n154#1:2999,6\n154#1:3006,8\n154#1:3016,7\n154#1:3024,7\n154#1:3033,7\n154#1:3041,8\n154#1:3051,6\n154#1:3058,7\n154#1:3067,9\n154#1:3077,7\n154#1:3086,8\n154#1:3095,7\n154#1:3104,6\n154#1:3111,7\n154#1:3120,34\n154#1:3155,7\n154#1:3164,6\n154#1:3171,7\n154#1:3180,11\n154#1:3192,7\n154#1:3199\n171#1:3200,6\n171#1:3206,68\n171#1:3277,6\n171#1:3284,55\n171#1:3339,3\n171#1:3342,8\n171#1:3352,11\n171#1:3364,8\n171#1:3374,6\n171#1:3381,8\n171#1:3391,7\n171#1:3399,7\n171#1:3408,7\n171#1:3416,8\n171#1:3426,6\n171#1:3433,7\n171#1:3442,9\n171#1:3452,7\n171#1:3461,8\n171#1:3470,7\n171#1:3479,6\n171#1:3486,7\n171#1:3495,34\n171#1:3530,7\n171#1:3539,6\n171#1:3546,7\n171#1:3555,11\n171#1:3567,7\n171#1:3574\n188#1:3575,6\n188#1:3581,68\n188#1:3652,6\n188#1:3659,55\n188#1:3714,3\n188#1:3717,8\n188#1:3727,11\n188#1:3739,8\n188#1:3749,6\n188#1:3756,8\n188#1:3766,7\n188#1:3774,7\n188#1:3783,7\n188#1:3791,8\n188#1:3801,6\n188#1:3808,7\n188#1:3817,9\n188#1:3827,7\n188#1:3836,8\n188#1:3845,7\n188#1:3854,6\n188#1:3861,7\n188#1:3870,34\n188#1:3905,7\n188#1:3914,6\n188#1:3921,7\n188#1:3930,11\n188#1:3942,7\n188#1:3949\n205#1:3950,6\n205#1:3956,68\n205#1:4027,6\n205#1:4034,55\n205#1:4089,3\n205#1:4092,8\n205#1:4102,11\n205#1:4114,8\n205#1:4124,6\n205#1:4131,8\n205#1:4141,7\n205#1:4149,7\n205#1:4158,7\n205#1:4166,8\n205#1:4176,6\n205#1:4183,7\n205#1:4192,9\n205#1:4202,7\n205#1:4211,8\n205#1:4220,7\n205#1:4229,6\n205#1:4236,7\n205#1:4245,34\n205#1:4280,7\n205#1:4289,6\n205#1:4296,7\n205#1:4305,11\n205#1:4317,7\n205#1:4324\n222#1:4325,6\n222#1:4331,68\n222#1:4402,6\n222#1:4409,55\n222#1:4464,3\n222#1:4467,8\n222#1:4477,11\n222#1:4489,8\n222#1:4499,6\n222#1:4506,8\n222#1:4516,7\n222#1:4524,7\n222#1:4533,7\n222#1:4541,8\n222#1:4551,6\n222#1:4558,7\n222#1:4567,9\n222#1:4577,7\n222#1:4586,8\n222#1:4595,7\n222#1:4604,6\n222#1:4611,7\n222#1:4620,34\n222#1:4655,7\n222#1:4664,6\n222#1:4671,7\n222#1:4680,11\n222#1:4692,7\n222#1:4699\n241#1:4700,6\n241#1:4706,68\n241#1:4777,6\n241#1:4784,55\n241#1:4839,3\n241#1:4842,8\n241#1:4852,11\n241#1:4864,8\n241#1:4874,6\n241#1:4881,8\n241#1:4891,7\n241#1:4899,7\n241#1:4908,7\n241#1:4916,8\n241#1:4926,6\n241#1:4933,7\n241#1:4942,9\n241#1:4952,7\n241#1:4961,8\n241#1:4970,7\n241#1:4979,6\n241#1:4986,7\n241#1:4995,34\n241#1:5030,7\n241#1:5039,6\n241#1:5046,7\n241#1:5055,11\n241#1:5067,7\n241#1:5074\n269#1:5075,68\n269#1:5146,6\n269#1:5153,55\n47#1:948\n47#1:949\n68#1:1024\n68#1:1025,2\n68#1:1033\n68#1:1100,2\n68#1:1113\n68#1:1122,2\n68#1:1130\n68#1:1139,2\n68#1:1148\n68#1:1156,2\n68#1:1165\n68#1:1174,2\n68#1:1182\n68#1:1190,2\n68#1:1201\n68#1:1209,2\n68#1:1219\n68#1:1227,2\n68#1:1235\n68#1:1243,2\n68#1:1279\n68#1:1287,2\n68#1:1295\n68#1:1303,2\n68#1:1316\n85#1:1399\n85#1:1400,2\n85#1:1408\n85#1:1475,2\n85#1:1488\n85#1:1497,2\n85#1:1505\n85#1:1514,2\n85#1:1523\n85#1:1531,2\n85#1:1540\n85#1:1549,2\n85#1:1557\n85#1:1565,2\n85#1:1576\n85#1:1584,2\n85#1:1594\n85#1:1602,2\n85#1:1610\n85#1:1618,2\n85#1:1654\n85#1:1662,2\n85#1:1670\n85#1:1678,2\n85#1:1691\n102#1:1774\n102#1:1775,2\n102#1:1783\n102#1:1850,2\n102#1:1863\n102#1:1872,2\n102#1:1880\n102#1:1889,2\n102#1:1898\n102#1:1906,2\n102#1:1915\n102#1:1924,2\n102#1:1932\n102#1:1940,2\n102#1:1951\n102#1:1959,2\n102#1:1969\n102#1:1977,2\n102#1:1985\n102#1:1993,2\n102#1:2029\n102#1:2037,2\n102#1:2045\n102#1:2053,2\n102#1:2066\n119#1:2149\n119#1:2150,2\n119#1:2158\n119#1:2225,2\n119#1:2238\n119#1:2247,2\n119#1:2255\n119#1:2264,2\n119#1:2273\n119#1:2281,2\n119#1:2290\n119#1:2299,2\n119#1:2307\n119#1:2315,2\n119#1:2326\n119#1:2334,2\n119#1:2344\n119#1:2352,2\n119#1:2360\n119#1:2368,2\n119#1:2404\n119#1:2412,2\n119#1:2420\n119#1:2428,2\n119#1:2441\n136#1:2524\n136#1:2525,2\n136#1:2533\n136#1:2600,2\n136#1:2613\n136#1:2622,2\n136#1:2630\n136#1:2639,2\n136#1:2648\n136#1:2656,2\n136#1:2665\n136#1:2674,2\n136#1:2682\n136#1:2690,2\n136#1:2701\n136#1:2709,2\n136#1:2719\n136#1:2727,2\n136#1:2735\n136#1:2743,2\n136#1:2779\n136#1:2787,2\n136#1:2795\n136#1:2803,2\n136#1:2816\n154#1:2899\n154#1:2900,2\n154#1:2908\n154#1:2975,2\n154#1:2988\n154#1:2997,2\n154#1:3005\n154#1:3014,2\n154#1:3023\n154#1:3031,2\n154#1:3040\n154#1:3049,2\n154#1:3057\n154#1:3065,2\n154#1:3076\n154#1:3084,2\n154#1:3094\n154#1:3102,2\n154#1:3110\n154#1:3118,2\n154#1:3154\n154#1:3162,2\n154#1:3170\n154#1:3178,2\n154#1:3191\n171#1:3274\n171#1:3275,2\n171#1:3283\n171#1:3350,2\n171#1:3363\n171#1:3372,2\n171#1:3380\n171#1:3389,2\n171#1:3398\n171#1:3406,2\n171#1:3415\n171#1:3424,2\n171#1:3432\n171#1:3440,2\n171#1:3451\n171#1:3459,2\n171#1:3469\n171#1:3477,2\n171#1:3485\n171#1:3493,2\n171#1:3529\n171#1:3537,2\n171#1:3545\n171#1:3553,2\n171#1:3566\n188#1:3649\n188#1:3650,2\n188#1:3658\n188#1:3725,2\n188#1:3738\n188#1:3747,2\n188#1:3755\n188#1:3764,2\n188#1:3773\n188#1:3781,2\n188#1:3790\n188#1:3799,2\n188#1:3807\n188#1:3815,2\n188#1:3826\n188#1:3834,2\n188#1:3844\n188#1:3852,2\n188#1:3860\n188#1:3868,2\n188#1:3904\n188#1:3912,2\n188#1:3920\n188#1:3928,2\n188#1:3941\n205#1:4024\n205#1:4025,2\n205#1:4033\n205#1:4100,2\n205#1:4113\n205#1:4122,2\n205#1:4130\n205#1:4139,2\n205#1:4148\n205#1:4156,2\n205#1:4165\n205#1:4174,2\n205#1:4182\n205#1:4190,2\n205#1:4201\n205#1:4209,2\n205#1:4219\n205#1:4227,2\n205#1:4235\n205#1:4243,2\n205#1:4279\n205#1:4287,2\n205#1:4295\n205#1:4303,2\n205#1:4316\n222#1:4399\n222#1:4400,2\n222#1:4408\n222#1:4475,2\n222#1:4488\n222#1:4497,2\n222#1:4505\n222#1:4514,2\n222#1:4523\n222#1:4531,2\n222#1:4540\n222#1:4549,2\n222#1:4557\n222#1:4565,2\n222#1:4576\n222#1:4584,2\n222#1:4594\n222#1:4602,2\n222#1:4610\n222#1:4618,2\n222#1:4654\n222#1:4662,2\n222#1:4670\n222#1:4678,2\n222#1:4691\n241#1:4774\n241#1:4775,2\n241#1:4783\n241#1:4850,2\n241#1:4863\n241#1:4872,2\n241#1:4880\n241#1:4889,2\n241#1:4898\n241#1:4906,2\n241#1:4915\n241#1:4924,2\n241#1:4932\n241#1:4940,2\n241#1:4951\n241#1:4959,2\n241#1:4969\n241#1:4977,2\n241#1:4985\n241#1:4993,2\n241#1:5029\n241#1:5037,2\n241#1:5045\n241#1:5053,2\n241#1:5066\n269#1:5143\n269#1:5144,2\n269#1:5152\n294#1:5208\n294#1:5209,3\n314#1:5212\n314#1:5213,3\n329#1:5216\n329#1:5217,3\n344#1:5220\n344#1:5221,3\n360#1:5224\n360#1:5225,3\n374#1:5228\n374#1:5229,3\n391#1:5232\n391#1:5233,3\n407#1:5236\n407#1:5237,3\n421#1:5240\n421#1:5241,3\n463#1:5244\n463#1:5245,3\n477#1:5248\n477#1:5249,3\n582#1:5252\n582#1:5253,3\n*E\n"})
/* loaded from: classes12.dex */
public final class Upload {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Upload f25780oIX0oI = new Upload();

    /* loaded from: classes12.dex */
    public static final class I0Io implements com.sma.smartv3.work.oIX0oI<BloodOxygen> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ BloodOxygenDao f25781oIX0oI;

        public I0Io(BloodOxygenDao bloodOxygenDao) {
            this.f25781oIX0oI = bloodOxygenDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<BloodOxygen> getList() {
            List<BloodOxygen> listASC = this.f25781oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.BloodOxygen>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.BloodOxygen> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<BloodOxygen> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25781oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0XooXoX implements com.sma.smartv3.work.oIX0oI<Sleep> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ SleepDao f25782oIX0oI;

        public II0XooXoX(SleepDao sleepDao) {
            this.f25782oIX0oI = sleepDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Sleep> getList() {
            return this.f25782oIX0oI.getListASC();
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Sleep> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25782oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements com.sma.smartv3.work.oIX0oI<AlipayBindInfo> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ AlipayBindInfoDao f25783oIX0oI;

        public II0xO0(AlipayBindInfoDao alipayBindInfoDao) {
            this.f25783oIX0oI = alipayBindInfoDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<AlipayBindInfo> getList() {
            List<AlipayBindInfo> listASC = this.f25783oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.AlipayBindInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.AlipayBindInfo> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<AlipayBindInfo> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25783oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class OOXIXo implements com.sma.smartv3.work.oIX0oI<Workout> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ WorkoutDao f25784oIX0oI;

        public OOXIXo(WorkoutDao workoutDao) {
            this.f25784oIX0oI = workoutDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Workout> getList() {
            return this.f25784oIX0oI.getListASC();
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Workout> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25784oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class Oxx0IOOO implements com.sma.smartv3.work.oIX0oI<Location> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ LocationDao f25785oIX0oI;

        public Oxx0IOOO(LocationDao locationDao) {
            this.f25785oIX0oI = locationDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Location> getList() {
            return this.f25785oIX0oI.getListASC();
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Location> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25785oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements com.sma.smartv3.work.oIX0oI<HeartRate> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ HeartRateDao f25786oIX0oI;

        public X0o0xo(HeartRateDao heartRateDao) {
            this.f25786oIX0oI = heartRateDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<HeartRate> getList() {
            List<HeartRate> listASC = this.f25786oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.HeartRate>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.HeartRate> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<HeartRate> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25786oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements com.sma.smartv3.work.oIX0oI<Hrv> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ HrvDao f25787oIX0oI;

        public XO(HrvDao hrvDao) {
            this.f25787oIX0oI = hrvDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Hrv> getList() {
            List<Hrv> listASC = this.f25787oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.Hrv>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.Hrv> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Hrv> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25787oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements com.sma.smartv3.work.oIX0oI<Activity> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ActivityDao f25788oIX0oI;

        public oIX0oI(ActivityDao activityDao) {
            this.f25788oIX0oI = activityDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Activity> getList() {
            List<Activity> listASC = this.f25788oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.Activity>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.Activity> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Activity> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25788oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements com.sma.smartv3.work.oIX0oI<BloodPressure> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ BloodPressureDao f25789oIX0oI;

        public oxoX(BloodPressureDao bloodPressureDao) {
            this.f25789oIX0oI = bloodPressureDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<BloodPressure> getList() {
            List<BloodPressure> listASC = this.f25789oIX0oI.getListASC();
            IIX0o.x0XOIxOo(listASC, "null cannot be cast to non-null type java.util.ArrayList<com.sma.smartv3.db.entity.BloodPressure>{ kotlin.collections.TypeAliasesKt.ArrayList<com.sma.smartv3.db.entity.BloodPressure> }");
            return (ArrayList) listASC;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<BloodPressure> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25789oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class xoIox implements com.sma.smartv3.work.oIX0oI<Weight> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ WeightDao f25794oIX0oI;

        public xoIox(WeightDao weightDao) {
            this.f25794oIX0oI = weightDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Weight> getList() {
            return this.f25794oIX0oI.getListASC();
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Weight> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25794oIX0oI.update(data);
        }
    }

    /* loaded from: classes12.dex */
    public static final class xxIXOIIO implements com.sma.smartv3.work.oIX0oI<Temperature> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ TemperatureDao f25795oIX0oI;

        public xxIXOIIO(TemperatureDao temperatureDao) {
            this.f25795oIX0oI = temperatureDao;
        }

        @Override // com.sma.smartv3.work.oIX0oI
        @OXOo.OOXIXo
        public List<Temperature> getList() {
            return this.f25795oIX0oI.getListASC();
        }

        @Override // com.sma.smartv3.work.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<Temperature> data) {
            IIX0o.x0xO0oo(data, "data");
            this.f25795oIX0oI.update(data);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0Io(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.I0Io(android.content.Context, java.lang.String):void");
    }

    public final /* synthetic */ <T> void II0XooXoX(Context context, List<? extends T> list) {
        String str;
        int size;
        int i = 0;
        if (Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24459ooOOo0oXI)) {
            if (Activity.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(list))) {
                if (list.size() >= 2 && (size = list.size() - 2) >= 0) {
                    int i2 = 0;
                    while (true) {
                        T t = list.get(i2);
                        IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Activity");
                        Activity activity = (Activity) t;
                        int i3 = i2 + 1;
                        T t2 = list.get(i3);
                        IIX0o.x0XOIxOo(t2, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Activity");
                        Activity activity2 = (Activity) t2;
                        if (activity2.getMStep() > 0 && activity2.getMStep() > activity.getMStep()) {
                            LogUtils.d(activity2);
                            LogUtils.d(activity);
                            GoogleFit googleFit = GoogleFit.f19698oIX0oI;
                            String packageName = context.getPackageName();
                            IIX0o.oO(packageName, "getPackageName(...)");
                            DataType TYPE_STEP_COUNT_DELTA = DataType.TYPE_STEP_COUNT_DELTA;
                            IIX0o.oO(TYPE_STEP_COUNT_DELTA, "TYPE_STEP_COUNT_DELTA");
                            Field FIELD_STEPS = Field.FIELD_STEPS;
                            IIX0o.oO(FIELD_STEPS, "FIELD_STEPS");
                            googleFit.oI0IIXIo(context, packageName, TYPE_STEP_COUNT_DELTA, "StepData", FIELD_STEPS, (activity2.getMStep() - activity.getMStep()) / 1.0f, activity.getMTime(), activity2.getMTime());
                            String packageName2 = context.getPackageName();
                            IIX0o.oO(packageName2, "getPackageName(...)");
                            DataType TYPE_CALORIES_EXPENDED = DataType.TYPE_CALORIES_EXPENDED;
                            IIX0o.oO(TYPE_CALORIES_EXPENDED, "TYPE_CALORIES_EXPENDED");
                            Field FIELD_CALORIES = Field.FIELD_CALORIES;
                            IIX0o.oO(FIELD_CALORIES, "FIELD_CALORIES");
                            googleFit.oI0IIXIo(context, packageName2, TYPE_CALORIES_EXPENDED, "CaloriesData", FIELD_CALORIES, (activity2.getMCalorie() - activity.getMCalorie()) / 10000.0f, activity.getMTime(), activity2.getMTime());
                            String packageName3 = context.getPackageName();
                            IIX0o.oO(packageName3, "getPackageName(...)");
                            DataType TYPE_DISTANCE_DELTA = DataType.TYPE_DISTANCE_DELTA;
                            IIX0o.oO(TYPE_DISTANCE_DELTA, "TYPE_DISTANCE_DELTA");
                            Field FIELD_DISTANCE = Field.FIELD_DISTANCE;
                            IIX0o.oO(FIELD_DISTANCE, "FIELD_DISTANCE");
                            googleFit.oI0IIXIo(context, packageName3, TYPE_DISTANCE_DELTA, "DistanceData", FIELD_DISTANCE, (activity2.getMDistance() - activity.getMDistance()) / 10000.0f, activity.getMTime(), activity2.getMTime());
                        }
                        if (i2 != size) {
                            i2 = i3;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                if (HeartRate.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(list))) {
                    for (T t3 : list) {
                        IIX0o.x0XOIxOo(t3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.HeartRate");
                        HeartRate heartRate = (HeartRate) t3;
                        GoogleFit googleFit2 = GoogleFit.f19698oIX0oI;
                        String packageName4 = context.getPackageName();
                        IIX0o.oO(packageName4, "getPackageName(...)");
                        DataType TYPE_HEART_RATE_BPM = DataType.TYPE_HEART_RATE_BPM;
                        IIX0o.oO(TYPE_HEART_RATE_BPM, "TYPE_HEART_RATE_BPM");
                        Field FIELD_BPM = Field.FIELD_BPM;
                        IIX0o.oO(FIELD_BPM, "FIELD_BPM");
                        googleFit2.oI0IIXIo(context, packageName4, TYPE_HEART_RATE_BPM, "HeartRateData", FIELD_BPM, heartRate.getMBpm(), heartRate.getMTime(), heartRate.getMTime() + 1000);
                    }
                    return;
                }
                if (!BloodPressure.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(list))) {
                    if (Sleep.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(list))) {
                        List<? extends T> list2 = list;
                        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
                        for (T t4 : list2) {
                            IIX0o.x0XOIxOo(t4, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Sleep");
                            Sleep sleep = (Sleep) t4;
                            arrayList.add(new BleSleep((int) (sleep.getMTime() / 1000), sleep.getMMode(), sleep.getMSoft(), sleep.getMStrong()));
                        }
                        BleSleep.Companion companion = BleSleep.Companion;
                        T t5 = list.get(0);
                        IIX0o.x0XOIxOo(t5, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Sleep");
                        List<BleSleep> analyseSleep = companion.analyseSleep(arrayList, ((Sleep) t5).getMAlgorithmType());
                        if (!analyseSleep.isEmpty() && analyseSleep.size() >= 2) {
                            ArrayList<GoogleFit.oIX0oI> arrayList2 = new ArrayList<>();
                            int size2 = analyseSleep.size() - 2;
                            if (size2 >= 0) {
                                while (true) {
                                    int mTime = analyseSleep.get(i).getMTime();
                                    int i4 = i + 1;
                                    int mTime2 = analyseSleep.get(i4).getMTime();
                                    int mMode = analyseSleep.get(i4).getMMode();
                                    if (mMode != 1) {
                                        if (mMode != 2) {
                                            str = FitnessActivities.SLEEP_AWAKE;
                                        } else {
                                            str = FitnessActivities.SLEEP_LIGHT;
                                        }
                                    } else {
                                        str = FitnessActivities.SLEEP_DEEP;
                                    }
                                    arrayList2.add(new GoogleFit.oIX0oI(mTime, mTime2, str));
                                    if (i == size2) {
                                        break;
                                    } else {
                                        i = i4;
                                    }
                                }
                            }
                            GoogleFit googleFit3 = GoogleFit.f19698oIX0oI;
                            String packageName5 = context.getPackageName();
                            IIX0o.oO(packageName5, "getPackageName(...)");
                            googleFit3.xoXoI(context, packageName5, "SleepData", "SleepData to GoogleFit", "SleepData by " + context.getString(R.string.app_name), arrayList2);
                            return;
                        }
                        return;
                    }
                    if (Weight.class.isInstance(CollectionsKt___CollectionsKt.O0OOX0IIx(list))) {
                        for (T t6 : list) {
                            IIX0o.x0XOIxOo(t6, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Weight");
                            Weight weight = (Weight) t6;
                            GoogleFit googleFit4 = GoogleFit.f19698oIX0oI;
                            String packageName6 = context.getPackageName();
                            IIX0o.oO(packageName6, "getPackageName(...)");
                            DataType TYPE_WEIGHT = DataType.TYPE_WEIGHT;
                            IIX0o.oO(TYPE_WEIGHT, "TYPE_WEIGHT");
                            Field FIELD_WEIGHT = Field.FIELD_WEIGHT;
                            IIX0o.oO(FIELD_WEIGHT, "FIELD_WEIGHT");
                            googleFit4.oI0IIXIo(context, packageName6, TYPE_WEIGHT, "WeightData", FIELD_WEIGHT, weight.getMWeight(), weight.getMTime(), weight.getMTime() + 1000);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ <T> void II0xO0(android.content.Context r46, java.lang.String r47, java.lang.String r48, java.util.List<? extends T> r49, com.sma.smartv3.work.oIX0oI<T> r50) {
        /*
            Method dump skipped, instructions count: 2275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.II0xO0(android.content.Context, java.lang.String, java.lang.String, java.util.List, com.sma.smartv3.work.oIX0oI):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OOXIXo(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.OOXIXo(android.content.Context, java.lang.String):void");
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        LogUtils.d("DataWorker upload data " + appUser2.getIdentity());
        if (appUser2.getIdentity().length() > 0) {
            I0Io(context, appUser2.getIdentity());
            xxIXOIIO(context, appUser2.getIdentity());
            XO(context, appUser2.getIdentity());
            OOXIXo(context, appUser2.getIdentity());
            oOoXoXO(context, appUser2.getIdentity());
            x0XOIxOo(context, appUser2.getIdentity());
            oO(context, appUser2.getIdentity());
            ooOOo0oXI(context, appUser2.getIdentity());
            X0o0xo(context, appUser2.getIdentity());
            xoIox(context, appUser2.getIdentity());
        }
        oxoX(context, appUser2.getIdentity());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X0o0xo(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.X0o0xo(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void XO(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.XO(android.content.Context, java.lang.String):void");
    }

    public final long oIX0oI(long j) {
        return (j - SMADataUploadData.defaultTime) / 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oO(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.oO(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oOoXoXO(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.oOoXoXO(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ooOOo0oXI(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.ooOOo0oXI(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0391 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x08f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oxoX(android.content.Context r48, java.lang.String r49) {
        /*
            Method dump skipped, instructions count: 2316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.oxoX(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0XOIxOo(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.x0XOIxOo(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void xoIox(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.xoIox(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x08e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void xxIXOIIO(android.content.Context r47, java.lang.String r48) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.work.Upload.xxIXOIIO(android.content.Context, java.lang.String):void");
    }
}
