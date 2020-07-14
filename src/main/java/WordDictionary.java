

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class WordDictionary {


    public static void main(String[] args) {

  AtomicInteger numfound = new AtomicInteger();
    ImpDictionary dict = new ImpDictionary();
      Action act = (String sss)->
      {
          if(dict.isEnglishWord(sss)) {
              numfound.getAndIncrement();
              System.out.println(sss);
          }
      } ;

      String inp = "ABC";
      for(int k=1; k<=inp.length(); ++k) {
          generateSelections(inp, k, act);
      }

      System.out.println("found : "+numfound);

    }


    static void generateSelections(String input, int len, Action action)
    {
         boolean[] isSelected = new boolean[input.length()];
          Arrays.fill(isSelected, false);
     //   ArrayList<String> resCache = new ArrayList<String>();
         chooseKN(input, isSelected, action, len, 0);

    }


    static void chooseKN(String input, boolean[] selection, Action action,int len, int begin)
    {
        if(len==0)
        {
          StringBuilder resBuilder = new StringBuilder() ;
                    for(int i=0; i < input.length(); ++i)
                    {
                        if(selection[i])
                            resBuilder.append(input.charAt(i));
                    }
                    action.perform(resBuilder.toString());
                  //  Arrays.fill(selection, false);
        }
        else
        {
            //pick next item if not selected
            int newSelect = begin;
               for(int j=begin; j<input.length(); j++)
               {
                   selection[j] = true;
                   chooseKN(input, selection, action, len-1, j+1);
                   selection[j]= false;
               }

        }

    }
}
