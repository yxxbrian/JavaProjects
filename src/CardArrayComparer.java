import java.util.*;

/**
 * Created by Brian_PC on 2017/7/19.
 */
public class CardArrayComparer {

    /*
    * Compare Result:
    * 1: first param is bigger
    * 0: the same
    * -1: second param is bigger
    * Integer.MIN_VALUE: invalid
    * */
    public int Compare(ArrayList<Card> cardArrayList_0,ArrayList<Card> cardArrayList_1)
    {
        if(cardArrayList_0.size() != cardArrayList_1.size())
            return  Integer.MIN_VALUE;
        int length = cardArrayList_0.size();
        HashMap<Integer,Integer> cardSummaryMap_0 = getSummaryOfCardArray(cardArrayList_0);
        HashMap<Integer,Integer> cardSummaryMap_1 = getSummaryOfCardArray(cardArrayList_1);
        return ComparePairsInCardArrays(cardSummaryMap_0,cardSummaryMap_1,length);

    }



    private  HashMap<Integer,Integer> getSummaryOfCardArray(ArrayList<Card> cardArrayList)
    {
        HashMap<Integer,Integer> cardSummaryMap = new HashMap<Integer, Integer>();
        for(Card card : cardArrayList)
        {
            if(!cardSummaryMap.containsKey(card.getNumber()))
                cardSummaryMap.put(card.getNumber(),1);
            else
            {
                int curVal = cardSummaryMap.get(card.getNumber());
                cardSummaryMap.remove(card.getNumber());
                cardSummaryMap.put(card.getNumber(),curVal+1);
            }
        }
        return cardSummaryMap;
    }

    private int ComparePairsInCardArrays(HashMap<Integer,Integer> firstCardSummary,HashMap<Integer,Integer> secondCardSummary,int pairLength)
    {
        if(pairLength == 0)
            return  0;
        ArrayList<Integer> cardSummaryOfParticularPairLength_0 = new ArrayList<Integer>();
        ArrayList<Integer> cardSummaryOfParticularPairLength_1 = new ArrayList<Integer>();

        //0
        Iterator iter = firstCardSummary.entrySet().iterator();
        while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val == pairLength)
            {
                cardSummaryOfParticularPairLength_0.add(key);
            }
        }
        sortByValueDesc(cardSummaryOfParticularPairLength_0);

        //1
        iter = secondCardSummary.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val == pairLength)
            {
                cardSummaryOfParticularPairLength_1.add(key);
            }
        }
        sortByValueDesc(cardSummaryOfParticularPairLength_1);
        int maxLength = Math.max(cardSummaryOfParticularPairLength_0.size(),cardSummaryOfParticularPairLength_1.size());

        for (int i=0;i<maxLength;i++)
        {
            if(i<cardSummaryOfParticularPairLength_0.size() && i<cardSummaryOfParticularPairLength_1.size())
            {
                //进行当前数值比较
                if(cardSummaryOfParticularPairLength_0.get(i)-cardSummaryOfParticularPairLength_1.get(i) != 0)
                    return cardSummaryOfParticularPairLength_0.get(i)-cardSummaryOfParticularPairLength_1.get(i)>0?1:-1;
                else
                    continue;
            }
            else if(i<cardSummaryOfParticularPairLength_0.size() && i>=cardSummaryOfParticularPairLength_1.size())
            {
                return 1;
            }
            else if(i>=cardSummaryOfParticularPairLength_0.size() && i<cardSummaryOfParticularPairLength_1.size())
            {
                return -1;
            }
            else
            {
                continue;
            }
        }
        return ComparePairsInCardArrays(firstCardSummary,secondCardSummary,pairLength-1);

    }

    //Bubble Sort
    private void sortByValueDesc(ArrayList<Integer> list)
    {
        if(list.size()<=1)
            return;
        boolean changed = true;
        while(changed)
        {
            changed = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if(list.get(i)<list.get(i+1))
                {
                    Integer tmp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,tmp);
                    changed = true;
                }
            }
        }
    }



}
