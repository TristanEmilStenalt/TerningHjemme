package terning;

public class Field
{
    private int fieldID;
    private String fieldName;
    //private String fieldText;
    private int fieldEffect;

    public Field(int ID, String name, int effect) //field object constructor
    {
        this.fieldID = ID;
        this.fieldName = name;
        //this.fieldText = text;
        this.fieldEffect = effect;
    }


//    public Field[] createBoard(int amountFields)
//    {
//        Field[] board = new Field[amountFields];
//        for (int i = 0; i < amountFields ; i++)
//        {
//            Field field = new Field(readID, readName, readText, readEffect);
//            board[i] = field;
//        }
//        return board;
//    }

    //perhaps get & set methods if u wanted a field to change over time(goldmine could give less every time landed on etc...)

    //get & set fieldID
    public int getFieldID()
    {
        return fieldID;
    }
    public void setFieldID(int ID)
    {
        this.fieldID = ID;
    }

    //get & set name
    public String getFieldName()
    {
        return fieldName;
    }
    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    //get & set effect
    public int getFieldEffect()
    {
        return fieldEffect;
    }
    public void setFieldEffect(int fieldEffect)
    {
        this.fieldEffect = fieldEffect;
    }


}
