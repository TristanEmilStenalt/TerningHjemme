package terning;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Language
{

    public String[] languageArray= null;
    public String textFileName = "terning/FieldTexts.txt";

    public String[] readFile()
    {
        List<String> itemsSchool = new ArrayList<String>();
        try
        {
            FileInputStream fstream_school = new FileInputStream("C:/Users/Tris2/OneDrive/[Universitet]/IdeaProjects/TerningHjemme/src/META-INF/"+textFileName);
            DataInputStream data_input = new DataInputStream(fstream_school);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
            String str_line;
            while ((str_line = buffer.readLine()) != null)
            {
                str_line = str_line.trim();
                if ((str_line.length()!=0))
                {
                    itemsSchool.add(str_line);
                }
            }
            languageArray = (itemsSchool.toArray(new String[itemsSchool.size()]));
        } catch (IOException e)

        {
        }
        return languageArray;
    }
}
