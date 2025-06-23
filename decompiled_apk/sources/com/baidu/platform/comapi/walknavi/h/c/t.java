package com.baidu.platform.comapi.walknavi.h.c;

/* loaded from: classes8.dex */
class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9792a;

    public t(c cVar) {
        this.f9792a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.e.e.c().j();
        com.baidu.platform.comapi.walknavi.e.e.c().b(false);
        com.baidu.platform.comapi.walknavi.e.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/tap1.mp3\", -1, 0)\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"turnAndSayHi\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 1\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.0\ncurrent_scene:set_event_handler(0, 0)\nparam._repeat_count = 1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onTurnAndSayHiPlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onTurnAndSayHiPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"turnAndSayHi\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "turnAndSayHi");
    }
}
