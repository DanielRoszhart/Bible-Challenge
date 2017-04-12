package com.example.dan.biblechallenge;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String LOG = "MySQLiteHelper";
    //Database Name
    private static final String DATABASE_NAME = "AllBibleQuestions";
    //Database Version
    private static final int DATABASE_VERSION = 3;

    //Table Names
    private static final String TABLE_WHAT = "what";
   private static final String TABLE_WHO = "who";
    private static final String TABLE_WHEN = "when";
    private static final String TABLE_WHERE = "where";
    public static final String TABLE_WHY = "why";
    // Common Column
    private static final String Column_ID="id";
    //Who Question Tables

    private static final String Column_WHO_QUESTION="who_question";
    private static final String Column_WHO_MULTIPLE_CHOICEA="who_multiple_choiceA";
    private static final String Column_WHO_MULTIPLE_CHOICEB="who_multiple_choiceB";
    private static final String Column_WHO_MULTIPLE_CHOICEC="who_multiple_choiceC";
    private static final String Column_WHO_MULTIPLE_CHOICED="who_multiple_choiceD";
    private static final String Column_WHO_ANSWER="who_answer";

    //What Question Table
    private static final String Column_WHEN_QUESTION="when_question";
    private static final String Column_WHEN_MULTIPLE_CHOICEA="when_multiple_choiceA";
    private static final String Column_WHEN_MULTIPLE_CHOICEB="when_multiple_choiceB";
    private static final String Column_WHEN_MULTIPLE_CHOICEC="when_multiple_choiceC";
    private static final String Column_WHEN_MULTIPLE_CHOICED="when_multiple_choiceD";
    private static final String Column_WHEN_ANSWER="when_answer";

    public static final String Column_WHY_QUESTION="why_question";
    public static final String Column_WHY_MULTIPLE_CHOICEA="why_multiple_choiceA";
    public static final String Column_WHY_MULTIPLE_CHOICEB="why_multiple_choiceB";
    public static final String Column_WHY_MULTIPLE_CHOICEC="why_multiple_choiceC";
    public static final String Column_WHY_MULTIPLE_CHOICED="why_multiple_choiceD";
    public static final String Column_WHY_ANSWER="why_answer";

    private static final String Column_WHERE_QUESTION="where_question";
    private static final String Column_WHERE_MULTIPLE_CHOICEA="where_multiple_choiceA";
    private static final String Column_WHERE_MULTIPLE_CHOICEB="where_multiple_choiceB";
    private static final String Column_WHERE_MULTIPLE_CHOICEC="where_multiple_choiceC";
    private static final String Column_WHERE_MULTIPLE_CHOICED="where_multiple_choiceD";
    private static final String Column_WHERE_ANSWER="where_answer";


    private static final String Column_WHAT_QUESTION="what_question";
    private static final String Column_WHAT_MULTIPLE_CHOICEA="what_multiple_choiceA";
    private static final String Column_WHAT_MULTIPLE_CHOICEB="what_multiple_choiceB";
    private static final String Column_WHAT_MULTIPLE_CHOICEC="what_multiple_choiceC";
    private static final String Column_WHAT_MULTIPLE_CHOICED="what_multiple_choiceD";
    private static final String Column_WHAT_ANSWER="what_answer";

    private SQLiteDatabase database;
    private static final String CREATE_TABLEWHO = "CREATE TABLE " + TABLE_WHO  + " ("
            + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_WHO_QUESTION+ " VARCHAR, "
            + Column_WHO_MULTIPLE_CHOICEA + " VARCHAR, "
            + Column_WHO_MULTIPLE_CHOICEB + " VARCHAR, "
            + Column_WHO_MULTIPLE_CHOICEC + " VARCHAR, "
            + Column_WHO_MULTIPLE_CHOICED + " VARCHAR, "
            + Column_WHO_ANSWER + " VARCHAR" + " )";

    private static final String CREATE_TABLEWHAT = "CREATE TABLE " + TABLE_WHAT  + " ( "
            + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_WHAT_QUESTION + " TEXT, "
            + Column_WHAT_MULTIPLE_CHOICEA + " TEXT, "
            + Column_WHAT_MULTIPLE_CHOICEB + " TEXT, "
            + Column_WHAT_MULTIPLE_CHOICEC + " TEXT, "
            + Column_WHAT_MULTIPLE_CHOICED + " TEXT, "
            + Column_WHAT_ANSWER + " TEXT" + " )";

    private static final String CREATE_TABLEWHEN = "CREATE TABLE " + TABLE_WHEN  + " ( "
            + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_WHEN_QUESTION + " TEXT, "
            + Column_WHEN_MULTIPLE_CHOICEA + " TEXT, "
            + Column_WHEN_MULTIPLE_CHOICEB + " TEXT, "
            + Column_WHEN_MULTIPLE_CHOICEC + " TEXT, "
            + Column_WHEN_MULTIPLE_CHOICED + " TEXT, "
            + Column_WHEN_ANSWER + " TEXT " + " )";

   private static final String CREATE_TABLEWHERE = "CREATE TABLE " + TABLE_WHERE  + " ( "
            + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_WHERE_QUESTION + " TEXT, "
            + Column_WHERE_MULTIPLE_CHOICEA + " TEXT, "
            + Column_WHERE_MULTIPLE_CHOICEB + " TEXT, "
            + Column_WHERE_MULTIPLE_CHOICEC + " TEXT, "
            + Column_WHERE_MULTIPLE_CHOICED + " TEXT, "
            + Column_WHERE_ANSWER + " TEXT" + " )";

  private static final String CREATE_TABLEWHY = "CREATE TABLE " + TABLE_WHY + " ( "
            + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_WHY_QUESTION+ " TEXT, "
            + Column_WHY_MULTIPLE_CHOICEA + " TEXT, "
            + Column_WHY_MULTIPLE_CHOICEB + " TEXT, "
            + Column_WHY_MULTIPLE_CHOICEC + " TEXT, "
            + Column_WHY_MULTIPLE_CHOICED + " TEXT, "
            + Column_WHY_ANSWER + " TEXT " + " )";
    //Create Who Table
       public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_TABLEWHO);
        db.execSQL(CREATE_TABLEWHAT);
        db.execSQL(CREATE_TABLEWHEN);
        db.execSQL(CREATE_TABLEWHERE);
         db.execSQL(CREATE_TABLEWHY);
        addWhoQuestions();

        Log.d("Created", "All Table created");


    }
    //Who Questions
    public void addWhoQuestions() {
        QuestionsTable q1 = new QuestionsTable("Who was David's daughter?", "Tamar", "Macah", "Bathsheba",
                "Abigail", "Tamar");
        this.createWhoItem(q1);

        QuestionsTable q2 = new QuestionsTable("Who was Israel’s Firstborn son?", "Reuben", "Joseph", "Benjamin",
                "Judah", "Reuben");
        this.createWhoItem(q2);

        QuestionsTable q3 = new QuestionsTable("Who was the son of Jesse?", "Saul", "David", "Samson", "Goliath", "David");
        this.createWhoItem(q3);

        QuestionsTable q4 = new QuestionsTable("In Jesus' parable of the good Samaritan which of these passes by the injured man on the road?",
                "Priest", "Lawyer", "Servant", "Woman", "Servant");
        this.createWhoItem(q4);

        QuestionsTable q5 = new QuestionsTable("Who was not killed as part of satan's test in the book of Job, but for cursing God?",
                "Children", "Wife", "Friends", "Job", "Job");
        this.createWhoItem(q5);

        QuestionsTable q6 = new QuestionsTable("Who hired Delilah to cut Samson's hair?", "Philistines", "Israelites", "Agagites", "Amalekites", "Philistines");
        this.createWhoItem(q6);

        QuestionsTable q7 = new QuestionsTable("Who was known as the “weeping prophet?", "Ezekiel", "Jeremiah", "Isaiah", "Lamentations", "Jeremiah");
        this.createWhoItem(q7);

        QuestionsTable q8 = new QuestionsTable("Who was exiled on the isle of Patmos?", "John", "Paul", "Peter", "Onesimus", "John");
        this.createWhoItem(q8);

        QuestionsTable q9 = new QuestionsTable("Who was Moses father-in-law?", "Pharaoh", "Jethro", "Aaron", "Peter", "Jethro");
        this.createWhoItem(q9);

        QuestionsTable q10 = new QuestionsTable("Who did Solomon petition for supplies and workers for the temple?", "King of Tyre", "King of Syria", "King of Hittites", "King of Judah" , "King of Tyre");
        this.createWhoItem(q10);



    }

    public void addWhatQuestions() {
        QuestionsTable q1 = new  QuestionsTable("What prompted King Asa to remove the idols from the lands of Judah and Benjamin?", "Prophetic Word from Azariah", "Vision of God", "Burning bush",
                "Famine in the land", "Prophetic Word from Azariah");
        this.createWhatItem(q1);

        QuestionsTable q2 = new  QuestionsTable("How many gold candlesticks were built and placed in the temple?", "5", "10", "12",
                "40", "10");
        this.createWhatItem(q2);

       QuestionsTable q3 = new QuestionsTable("What did Paul say should not exist among the brethren?", "Lies", "Murder", "Divison", "Hatred", "Divison");
        this.createWhatItem(q3);

        QuestionsTable q4 = new  QuestionsTable("What town did Achish give to David and his men?",
                "Ziklag", "Jericho ", "Shechem", "Hebron", "Ziklag");
        this.createWhatItem(q4);

        QuestionsTable q5 = new  QuestionsTable("Jeroboam made two of what kind of idol?",
                "Silver lambs", "Baal", "Copper crosses", "Golden calves", "Golden calves");
        this.createWhatItem(q5);

        QuestionsTable q6 = new  QuestionsTable("What did Paul do to Bar-Jesus?", "Praised", "Blinded ", "Arrested", "Preached", "Blinded ");
        this.createWhatItem(q6);

        QuestionsTable q7 = new  QuestionsTable("How many animals did Solomon sacrifice to the Lord at the Temple’s dedication?", "120,000", "262,000", "22,000", "142,000", "142,000");
        this.createWhatItem(q7);

        QuestionsTable q8 = new  QuestionsTable("What was the second plague that befell the Egyptians??", "Frogs", "Locusts", "Hail", "Water turned into blood", "Frogs");
        this.createWhatItem(q8);

        QuestionsTable q9 = new  QuestionsTable("What did Hezekiah do after sanctifying the temple and offering the sacrifices?", "Waged war on Assyria", "Got Married", "Held a Passover feast", "Invited teh king of Aram to visit", "Held a Passover feast");
        this.createWhatItem(q9);

        QuestionsTable q10 = new  QuestionsTable("What did Nehemiah request of King Artaxerxes?", "Marry his daughter ", "To be sent to Jerusalem to rebuild the wall", "Live In the palace", "If he could have a different job" , "To be sent to Jerusalem to rebuild the wall");
        this.createWhatItem(q10);



    }

  public void addWhenQuestions() {
      QuestionsTable q1 = new  QuestionsTable("When were the Ten Commandments given to Moses?", "When the Israelites entered the Promised Land", "Immediately after they left Egypt", "Wandering around in the wilderness",
              "When they were at Mt. Sinai", "When they were at Mt. Sinai");
      this.createWhenItem(q1);

      QuestionsTable q2 = new  QuestionsTable("On what day did the apostles first speak in tongues?", "Pentecost", "Passover", "Christ's ascension",
              "Feast of Tabernacles", "Pentecost");
      this.createWhenItem(q2);

      QuestionsTable q3 = new QuestionsTable("When will the Rapture happen?", "Before the 7 years of Tribulation", "Sometime", "No one knows except God the Father", "Soon", "No one knows except God the Father");
      this.createWhenItem(q3);

      QuestionsTable q4 = new  QuestionsTable("When were the Israelites not supposed to gather manna during their time in the wilderness?",
              "If they weren’t hungry", "On the Sabbath ", "During siesta time", "While walking", "On the Sabbath");
      this.createWhenItem(q4);

      QuestionsTable q5 = new  QuestionsTable("During whose reign did Adonijah grab the altar’s horns?",
              " David", "Joash", "Hezekiah", "Solomon ", "Solomon ");
      this.createWhenItem(q5);

      QuestionsTable q6 = new  QuestionsTable("When was Paul’s first imprisonment in Rome?", "Approximately 40 AD to 42 AD", "59 AD – 62 AD ", "Around 33 AD", "Sometime around 75 AD", "59 AD – 62 AD ");
      this.createWhenItem(q6);

      QuestionsTable q7 = new  QuestionsTable("When was the second temple – Herod’s Temple – destroyed?", "70 AD", "33 AD", "It is still standing", "100 AD", "70 AD");
      this.createWhenItem(q7);

      QuestionsTable q8 = new  QuestionsTable("When did Nicodemus visit Jesus?", "In rain", "On a Saturday", "At a party", "Under the cover of darkness", "Under the cover of darkness");
      this.createWhenItem(q8);

      QuestionsTable q9 = new  QuestionsTable("When were the sun, moon, and stars created?", "First day of creation", "Fourth day of creation", "Third day of creation", "Second day of creation", "Fourth day of creation");
      this.createWhenItem(q9);

      QuestionsTable q10 = new  QuestionsTable("When did Satan tempt Jesus?", "Following His baptism", "After Jesus had fasted for forty days", "When Jesus was alone in the desert", "All of the above" , "All of the above");
      this.createWhenItem(q10);



  }

  public void addWhereQuestions() {
      QuestionsTable q1 = new  QuestionsTable("Elijah ran from Jezebel to what mountain?", "Mt. Horeb ", "Mt. Hermon", "Mt. Moriah",
              "Mt. Sinai", "Mt. Horeb ");
      this.createWhereItem(q1);

      QuestionsTable q2 = new  QuestionsTable("Where was the Ark of the Covenant housed before brought into Jerusalem?", "Nazareth", "Zion", "Gath",
              "Jerusalem", "Zion");
      this.createWhereItem(q2);

      QuestionsTable q3 = new QuestionsTable("When Christ returns those who are saved will meet him where?", "Mt. Zion", "Air", "Heaven", "Jerusalem", "Air");
      this.createWhereItem(q3);

      QuestionsTable q4 = new  QuestionsTable("Where must all believers make an appearance?",
              "Heaven's gate", "In front of Peter ", "In a confessional", "Judgment seat of Christ", "Judgment seat of Christ");
      this.createWhereItem(q4);

      QuestionsTable q5 = new  QuestionsTable("The Judeans were taken into exile where?",
              " Babylon", "Into the desert", "Egypt", "Into the hills", "Babylon");
      this.createWhereItem(q5);

      QuestionsTable q6 = new  QuestionsTable("What was the name of the mountain where Noah’s ark came to rest?", "Mt. Sinai ", "Mt. Moriah", "Mt. Ararat", "Mt. Carmel", "Mt. Ararat");
      this.createWhereItem(q6);

      QuestionsTable q7 = new  QuestionsTable("Where did Elijah make his showdown with the prophets of Baal?", "Jordan River", "Sea of Galilee", "Mediterranean", "Tigris River", "Jordan River");
      this.createWhereItem(q7);

      QuestionsTable q8 = new  QuestionsTable("When did Nicodemus visit Jesus?", "In rain", "On a Saturday", "At a party", "Under the cover of darkness", "Under the cover of darkness");
      this.createWhereItem(q8);

      QuestionsTable q9 = new  QuestionsTable("Where did David make his stand with Goliath?", "Gath", "Galilee", "Nazareth", "Socoh", "Socoh");
      this.createWhereItem(q9);

      QuestionsTable q10 = new  QuestionsTable("The Ten Commandments are found in what book of the Bible?", "Leviticus", "Genesis", "Exodus", "Numbers" , "Exodus");
      this.createWhereItem(q10);


  }

  public void addWhyQuestions() {
      QuestionsTable q1 = new  QuestionsTable("Why were Shadrach, Meshach & Abednego put into the fiery furnace?", "They wouldn’t eat their food ",
              "They refused to worship the image", "They couldn’t interpret the king’s dream ", "They were Jews", "They refused to worship the image ");
      this.createWhereItem(q1);

      QuestionsTable q2 = new  QuestionsTable("Why was Stephen stoned?", "He was caught stealing", "He was unfaithful to his wife", "He didn't worship Caesar",
              "He preached boldy", "He preached boldly");
      this.createWhyItem(q2);

      QuestionsTable q3 = new QuestionsTable("Why were the children of Israel led out of Egypt by a cloud and pillar of fire??", "To hide them from the Egyptian army", "As a reminder of God’s care",
              "So Pharoah would believe in God ","So they would trust God", "To hide them from the Egyptian army");
      this.createWhyItem(q3);

      QuestionsTable q4 = new  QuestionsTable("Why was Jonah discouraged after preaching to the Ninevites?",
              "They wouldn’t listen ", "He was hot and tired ", "He missed his family", "They repented", "They repented");
      this.createWhyItem(q4);

      QuestionsTable q5 = new  QuestionsTable("Why did Zacchaeus climb the sycamore tree?",
              " To get away from people", "So he would be able to see Jesus ", "He couldn’t find an olive tree", "To pick some fruit", "So he would be able to see Jesus ");
      this.createWhyItem(q5);

      QuestionsTable q6 = new  QuestionsTable("Why did Jacob have to work for Laban an additional seven years?", "To get Rachel for his wife ", "He needed more money",
              "He was a poor worker", "He had signed a contract ", "To get Rachel for his wife");
      this.createWhyItem(q6);

      QuestionsTable q7 = new  QuestionsTable("Why was Joseph put into prison in Egypt?", "Potiphar was jealous", "He tried to steal from Potiphar  ",
              "Potiphar’s wife falsely accused him", "The Pharaoh didn’t like him ", "Potiphar’s wife falsely accused him");
      this.createWhyItem(q7);

      QuestionsTable q8 = new  QuestionsTable("Why was Moses not allowed to enter the Promised Land?", "He disobeyed God", "He took the credit for bringing forth the water",
              "He struck the rock instead of speaking to it", "All of the above ", "All of the above ");
      this.createWhyItem(q8);

      QuestionsTable q9 = new  QuestionsTable("According to I Cor. 13:3, why does it not profit me to give all my possession to feed the poor?", "The wrong attitude", "Selfish motive ",
              "No compassion  ", "Don’t have love", "Don’t have love");
      this.createWhyItem(q9);

      QuestionsTable q10 = new  QuestionsTable("Why did the five virgins (in the Parable of the Ten Virgins) miss the Bridegroom?", "No oil in their lamps", "He came while they were eating",
              "In the wrong place  ", "They didn’t get their invitation" , "No oil in their lamps");
      this.createWhyItem(q10);
  }
    @Override
        public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_WHO );
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_WHAT);
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_WHEN);
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_WHERE);
           db.execSQL("DROP TABLE IF EXISTS " + TABLE_WHY);
       // create new tables
       onCreate(db);
        }

    public void createWhoItem(QuestionsTable Whoquests) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.Column_WHO_QUESTION,  Whoquests.getQuestion());
        values.put(MySQLiteHelper.Column_WHO_MULTIPLE_CHOICEA,  Whoquests.getMultipleChoiceA());
        values.put(MySQLiteHelper.Column_WHO_MULTIPLE_CHOICEB,  Whoquests.getMultipleChoiceB());
        values.put(MySQLiteHelper.Column_WHO_MULTIPLE_CHOICEC,  Whoquests.getMultipleChoiceC());
        values.put(MySQLiteHelper.Column_WHO_MULTIPLE_CHOICED,  Whoquests.getMultipleChoiceD());
        values.put(MySQLiteHelper.Column_WHO_ANSWER,  Whoquests.getAnswer());

         db.insert(MySQLiteHelper.TABLE_WHO, null, values);

    }

    public void  createWhatItem(QuestionsTable Whatquests) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.Column_WHAT_QUESTION, Whatquests.getQuestion());
        values.put(MySQLiteHelper.Column_WHAT_MULTIPLE_CHOICEA, Whatquests.getMultipleChoiceA());
        values.put(MySQLiteHelper.Column_WHAT_MULTIPLE_CHOICEB, Whatquests.getMultipleChoiceB());
        values.put(MySQLiteHelper.Column_WHAT_MULTIPLE_CHOICEC, Whatquests.getMultipleChoiceC());
        values.put(MySQLiteHelper.Column_WHAT_MULTIPLE_CHOICED, Whatquests.getMultipleChoiceD());
        values.put(MySQLiteHelper.Column_WHAT_ANSWER, Whatquests.getAnswer());

        db.insert(MySQLiteHelper.TABLE_WHAT, null, values);
    }

    public void  createWhenItem(QuestionsTable Whenquests) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.Column_WHEN_QUESTION, Whenquests.getQuestion());
        values.put(MySQLiteHelper.Column_WHEN_MULTIPLE_CHOICEA, Whenquests.getMultipleChoiceA());
        values.put(MySQLiteHelper.Column_WHEN_MULTIPLE_CHOICEB, Whenquests.getMultipleChoiceB());
        values.put(MySQLiteHelper.Column_WHEN_MULTIPLE_CHOICEC, Whenquests.getMultipleChoiceC());
        values.put(MySQLiteHelper.Column_WHEN_MULTIPLE_CHOICED, Whenquests.getMultipleChoiceD());
        values.put(MySQLiteHelper.Column_WHEN_ANSWER, Whenquests.getAnswer());

        db.insert(MySQLiteHelper.TABLE_WHEN, null, values);
    }

    public void  createWhereItem(QuestionsTable Wherequests) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.Column_WHERE_QUESTION, Wherequests.getQuestion());
        values.put(MySQLiteHelper.Column_WHERE_MULTIPLE_CHOICEA, Wherequests.getMultipleChoiceA());
        values.put(MySQLiteHelper.Column_WHERE_MULTIPLE_CHOICEB, Wherequests.getMultipleChoiceB());
        values.put(MySQLiteHelper.Column_WHERE_MULTIPLE_CHOICEC, Wherequests.getMultipleChoiceC());
        values.put(MySQLiteHelper.Column_WHERE_MULTIPLE_CHOICED, Wherequests.getMultipleChoiceD());
        values.put(MySQLiteHelper.Column_WHERE_ANSWER, Wherequests.getAnswer());

        db.insert(MySQLiteHelper.TABLE_WHERE, null, values);
    }

    public void  createWhyItem(QuestionsTable Whyquests) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.Column_WHY_QUESTION, Whyquests.getQuestion());
        values.put(MySQLiteHelper.Column_WHY_MULTIPLE_CHOICEA, Whyquests.getMultipleChoiceA());
        values.put(MySQLiteHelper.Column_WHY_MULTIPLE_CHOICEB, Whyquests.getMultipleChoiceB());
        values.put(MySQLiteHelper.Column_WHY_MULTIPLE_CHOICEC, Whyquests.getMultipleChoiceC());
        values.put(MySQLiteHelper.Column_WHY_MULTIPLE_CHOICED, Whyquests.getMultipleChoiceD());
        values.put(MySQLiteHelper.Column_WHY_ANSWER, Whyquests.getAnswer());

        db.insert(MySQLiteHelper.TABLE_WHY, null, values);
    }

    //Fetching all Whos from the table
    public List<QuestionsTable> getAllWhos() {
        List<QuestionsTable> whoQuesList = new ArrayList<>();
        String selectQuery = "Select * From " + TABLE_WHO;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
        do{
            QuestionsTable question = new QuestionsTable();
            question.setId(cursor.getInt(cursor.getColumnIndex(Column_ID)));
            question.setQuestion(cursor.getString(cursor.getColumnIndex(Column_WHO_QUESTION)));
            question.setMultipleChoiceA(cursor.getString(cursor.getColumnIndex(Column_WHO_MULTIPLE_CHOICEA)));
            question.setMultipleChoiceB(cursor.getString(cursor.getColumnIndex(Column_WHO_MULTIPLE_CHOICEB)));
            question.setMultipleChoiceC(cursor.getString(cursor.getColumnIndex(Column_WHO_MULTIPLE_CHOICEC)));
            question.setMultipleChoiceD(cursor.getString(cursor.getColumnIndex(Column_WHO_MULTIPLE_CHOICED)));
            question.setAnswer(cursor.getString(cursor.getColumnIndex(Column_WHO_ANSWER)));
            whoQuesList.add(question);
        }   while (cursor.moveToNext());
        }
        cursor.close();
        database.close();

        return whoQuesList;
    }
    //Fetching all Whats from the table
    public List<QuestionsTable> getAllWhats() {
        List<QuestionsTable> whatQuesList = new ArrayList<>();
        String selectQuery = "Select * From " + TABLE_WHAT;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                QuestionsTable question = new QuestionsTable();
                question.setId(cursor.getInt(cursor.getColumnIndex(Column_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Column_WHO_QUESTION)));
                question.setMultipleChoiceA(cursor.getString(cursor.getColumnIndex(Column_WHAT_MULTIPLE_CHOICEA)));
                question.setMultipleChoiceB(cursor.getString(cursor.getColumnIndex(Column_WHAT_MULTIPLE_CHOICEB)));
                question.setMultipleChoiceC(cursor.getString(cursor.getColumnIndex(Column_WHAT_MULTIPLE_CHOICEC)));
                question.setMultipleChoiceD(cursor.getString(cursor.getColumnIndex(Column_WHAT_MULTIPLE_CHOICED)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(Column_WHAT_ANSWER)));
                whatQuesList.add(question);
            }   while (cursor.moveToNext());

        }
        cursor.close();
        database.close();
        return whatQuesList;
    }


    //Fetching all Whens from the table
    public List<QuestionsTable> getAllWhens() {
        List<QuestionsTable> whenQuesList = new ArrayList<>();
        String selectQuery = "Select * From " + TABLE_WHEN;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                QuestionsTable question = new QuestionsTable();
                question.setId(cursor.getInt(cursor.getColumnIndex(Column_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Column_WHEN_QUESTION)));
                question.setMultipleChoiceA(cursor.getString(cursor.getColumnIndex(Column_WHEN_MULTIPLE_CHOICEA)));
                question.setMultipleChoiceB(cursor.getString(cursor.getColumnIndex(Column_WHEN_MULTIPLE_CHOICEB)));
                question.setMultipleChoiceC(cursor.getString(cursor.getColumnIndex(Column_WHEN_MULTIPLE_CHOICEC)));
                question.setMultipleChoiceD(cursor.getString(cursor.getColumnIndex(Column_WHEN_MULTIPLE_CHOICED)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(Column_WHEN_ANSWER)));
                whenQuesList.add(question);
            }   while (cursor.moveToNext());

        }
        cursor.close();
        database.close();
        return whenQuesList;
    }


    //Fetching all Wheres from the table
    public List<QuestionsTable> getAllWheres() {
        List<QuestionsTable> whereQuesList = new ArrayList<>();
        String selectQuery = "Select * From " + TABLE_WHERE;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                QuestionsTable question = new QuestionsTable();
                question.setId(cursor.getInt(cursor.getColumnIndex(Column_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Column_WHERE_QUESTION)));
                question.setMultipleChoiceA(cursor.getString(cursor.getColumnIndex(Column_WHERE_MULTIPLE_CHOICEA)));
                question.setMultipleChoiceB(cursor.getString(cursor.getColumnIndex(Column_WHERE_MULTIPLE_CHOICEB)));
                question.setMultipleChoiceC(cursor.getString(cursor.getColumnIndex(Column_WHERE_MULTIPLE_CHOICEC)));
                question.setMultipleChoiceD(cursor.getString(cursor.getColumnIndex(Column_WHERE_MULTIPLE_CHOICED)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(Column_WHERE_ANSWER)));
                whereQuesList.add(question);
            }   while (cursor.moveToNext());

        }
        cursor.close();
        database.close();
        return whereQuesList;
    }


    //Fetching all Whys from the table
    public List<QuestionsTable> getAllWhys() {
        List<QuestionsTable> whyQuesList = new ArrayList<>();
        String selectQuery = "Select * From " + TABLE_WHY;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                QuestionsTable question = new QuestionsTable();
                question.setId(cursor.getInt(cursor.getColumnIndex(Column_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Column_WHY_QUESTION)));
                question.setMultipleChoiceA(cursor.getString(cursor.getColumnIndex(Column_WHY_MULTIPLE_CHOICEA)));
                question.setMultipleChoiceB(cursor.getString(cursor.getColumnIndex(Column_WHY_MULTIPLE_CHOICEB)));
                question.setMultipleChoiceC(cursor.getString(cursor.getColumnIndex(Column_WHY_MULTIPLE_CHOICEC)));
                question.setMultipleChoiceD(cursor.getString(cursor.getColumnIndex(Column_WHY_MULTIPLE_CHOICED)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(Column_WHY_ANSWER)));
                whyQuesList.add(question);
            }   while (cursor.moveToNext());

        }
        cursor.close();
        database.close();
        return whyQuesList;
    }

}//END MySQLiteHelper Class


