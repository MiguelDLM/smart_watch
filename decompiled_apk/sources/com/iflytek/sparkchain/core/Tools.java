package com.iflytek.sparkchain.core;

import androidx.core.util.X0o0xo;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class Tools {
    private ArrayList<BaseTool> pluginList;

    public Tools() {
        this.pluginList = new ArrayList<>();
    }

    public Tools append(Tools tools) {
        this.pluginList.addAll(tools.getAllPlugin());
        return this;
    }

    public ArrayList<BaseTool> getAllPlugin() {
        return this.pluginList;
    }

    public BaseTool getPlugin(String str) {
        if (str != null && !str.isEmpty()) {
            Iterator<BaseTool> it = this.pluginList.iterator();
            while (it.hasNext()) {
                BaseTool next = it.next();
                if (str.equals(next.name)) {
                    return next;
                }
            }
        }
        return null;
    }

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        Iterator<BaseTool> it = this.pluginList.iterator();
        while (it.hasNext()) {
            BaseTool next = it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                String str = "";
                jSONObject.put("name", X0o0xo.oIX0oI(next.name) ? "" : next.name);
                jSONObject.put("desc", X0o0xo.oIX0oI(next.description) ? "" : next.description);
                if (!X0o0xo.oIX0oI(next.argsSchema)) {
                    str = next.argsSchema.toString();
                }
                jSONObject.put("prompt", str);
                jSONObject.put("isDirect", next.isDirect);
                jSONObject.put("platform", "android");
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return jSONArray.toString();
    }

    public Tools(BaseTool[] baseToolArr) {
        ArrayList<BaseTool> arrayList = new ArrayList<>();
        this.pluginList = arrayList;
        arrayList.addAll(Arrays.asList(baseToolArr));
    }

    public Tools append(BaseTool baseTool) {
        this.pluginList.add(baseTool);
        return this;
    }

    public Tools append(BaseTool[] baseToolArr) {
        this.pluginList.addAll(Arrays.asList(baseToolArr));
        return this;
    }
}
