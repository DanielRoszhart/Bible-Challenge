package com.example.dan.biblechallenge;


public class QuestionsTable {
    private int id;
   private  String question;
    private String multipleChoiceA;
    private String multipleChoiceB;
    private String multipleChoiceC;
    private String multipleChoiceD;
    private String answer;


    //constructors
    public QuestionsTable () {
      id=0;
        multipleChoiceA="";
        multipleChoiceB="";
        multipleChoiceC="";
        multipleChoiceD="";
        answer="";
    }


    public QuestionsTable( String question, String multipleChoiceA, String multipleChoiceB,
                          String multipleChoiceC, String multipleChoiceD, String answer) {

        this.question = question;
        this.multipleChoiceA = multipleChoiceA;
        this.multipleChoiceB= multipleChoiceB;
        this.multipleChoiceC = multipleChoiceC;
        this.multipleChoiceD = multipleChoiceD;
        this.answer=answer;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMultipleChoiceA(String multipleChoiceA) {
        this.multipleChoiceA = multipleChoiceA;
    }

    public void setMultipleChoiceB(String multipleChoiceB) {
        this.multipleChoiceB = multipleChoiceB;
    }

    public void setMultipleChoiceC(String multipleChoiceC) {
        this.multipleChoiceC = multipleChoiceC;
    }

    public void setMultipleChoiceD(String multipleChoiceD) {
        this.multipleChoiceD = multipleChoiceD;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    //Getters
    public long getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getMultipleChoiceA() {
        return this.multipleChoiceA;
    }

    public String getMultipleChoiceB() {
        return this.multipleChoiceB;
    }

    public String getMultipleChoiceC() {
        return this.multipleChoiceC;
    }

    public String getMultipleChoiceD() {
        return this.multipleChoiceD;
    }

    public String getAnswer() {
        return this.answer;
    }
}
