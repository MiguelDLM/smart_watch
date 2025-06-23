package androidx.work.impl;

import OXOo.OOXIXo;

public final class WorkDatabaseMigrationsKt {
    @OOXIXo
    private static final String CREATE_INDEX_PERIOD_START_TIME = "\n    CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec`(`period_start_time`)\n    ";
    @OOXIXo
    private static final String CREATE_OUT_OF_QUOTA_POLICY = "ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0";
    @OOXIXo
    private static final String CREATE_RUN_IN_FOREGROUND = "ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0";
    @OOXIXo
    private static final String CREATE_SYSTEM_ID_INFO = "\n    CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id`\n    INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ";
    @OOXIXo
    private static final String CREATE_WORK_PROGRESS = "\n    CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress`\n    BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ";
    @OOXIXo
    private static final String INITIALIZE_PERIOD_COUNTER = "UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0";
    @OOXIXo
    private static final String MIGRATE_ALARM_INFO_TO_SYSTEM_ID_INFO = "\n    INSERT INTO SystemIdInfo(work_spec_id, system_id)\n    SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo\n    ";
    @OOXIXo
    private static final String PERIODIC_WORK_SET_SCHEDULE_REQUESTED_AT = "\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ";
    @OOXIXo
    private static final String REMOVE_ALARM_INFO = "DROP TABLE IF EXISTS alarmInfo";
    @OOXIXo
    private static final String SET_DEFAULT_CONTENT_URI_TRIGGERS = "UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL";
    @OOXIXo
    private static final String SET_DEFAULT_NETWORK_TYPE = "UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ";
    @OOXIXo
    private static final String WORKSPEC_ADD_TRIGGER_MAX_CONTENT_DELAY = "ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1";
    @OOXIXo
    private static final String WORKSPEC_ADD_TRIGGER_UPDATE_DELAY = "ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1";
}
