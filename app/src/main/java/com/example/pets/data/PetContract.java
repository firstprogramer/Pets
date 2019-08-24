// this class to easy set or modify -change- database tables,columns names
package com.example.pets.data;

import android.provider.BaseColumns;

public class PetContract {
    public PetContract() {}

    public static final class PetEntry implements BaseColumns {
        // set table name
         public static final String TABLE_NAME = "Pets";

        // set columns name
        public static final String _ID = BaseColumns._ID;
        public static final String COL_NAME = "Name";
        public static final String COL_BREED = "Breed";
        public static final String COL_GENDER = "Gender";
        public static final String COL_WEIGHT = "Weight";

        // set static value used in gender column
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;




    }
}
