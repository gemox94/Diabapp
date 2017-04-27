package com.example.gemox94.diabapp.DB;

import android.provider.BaseColumns;

public class DiabappContract{

    private DiabappContract(){}

    public static class Rol implements BaseColumns {
        public static final String TABLE_NAME = "rols";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_EMAIL= "email";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_ROL_ID = "rol_id";
        public static final String COLUMN_NAME_DOCTOR_ID = "doctor_id";
    }

    public static class Measurement implements BaseColumns {
        public static final String TABLE_NAME = "measurements";
        public static final String COLUMN_NAME_B_MEAL = "before_meal";
        public static final String COLUMN_NAME_A_MEAL = "after_meal";
        public static final String COLUMN_NAME_GlUCOSE = "glucose_level";
        public static final String COLUMN_NAME_CREATED = "created_at";
        public static final String COLUMN_NAME_PATIENT_ID = "patient_id";
        public static final String COLUMN_NAME_DOCTOR_ID = "doctor_id";
    }


}
