import org.apache.commons.lang3.StringUtils;

public class ImpDictionary implements InternalDictionary{

   public Boolean isEnglishWord(String inWord)
    {
     if(StringUtils.isEmpty(inWord))
         return false;
     else
         return true;

    }
}
